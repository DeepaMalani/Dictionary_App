package android.myapp.dictionary_app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSearchButton(){
        onView(withId(R.id.btn_search)).perform(click())
        onView(withId(R.id.txt_Definition)).check(matches(withText("Definitions")))
    }
    @Test
    fun validateEditText(){
        onView(withId(R.id.edit_text_query)).perform(typeText("Grammar")).check(matches(withText("Grammar")));
    }


}