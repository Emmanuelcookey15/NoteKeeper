package com.example.notekeeper;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static org.hamcrest.Matchers.*;
import static android.support.test.espresso.Espresso.pressBack;


@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    static DataManager sDataManager;
    @BeforeClass
    public static void classSetup() throws  Exception {
        sDataManager = DataManager.getInstance();
    }

    @Rule
    public ActivityTestRule<NoteListActivity> mNoteListActivityActivityTestRule =
            new ActivityTestRule<>(NoteListActivity.class);

    @Test
    public void createNewNote() {
        final CourseInfo course = sDataManager.getCourse("java lang");
        final String noteTitle = "Text note title";
        final String noteText = "This is the body of our test note";

//        ViewInteraction fabNewNote = onView(withId(R.id.fab));
//        fabNewNote.perform(click());
        onView(withId(R.id.fab)).perform(click());
        onData(allOf(instanceOf(CourseInfo.class), equalTo(course)));
        onView(withId(R.id.text_note_title)).perform(typeText(noteTitle));
        onView(withId(R.id.text_note_text)).perform(typeText(noteText),
                closeSoftKeyboard());
    }

}