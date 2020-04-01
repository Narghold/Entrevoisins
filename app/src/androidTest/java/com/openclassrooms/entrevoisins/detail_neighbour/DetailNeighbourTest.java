package com.openclassrooms.entrevoisins.detail_neighbour;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.ClickNeighbourViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Test class for neighbour's detail
 */
@RunWith(AndroidJUnit4.class)
public class DetailNeighbourTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     *  Verify if the TextView is visible and not empty
     */
    @Test
    public void detailNeighbour_nameCannotBeEmpty(){
        // Perform a click on the 1st neighbour
        onView(withId(R.id.list_neighbour)).perform(RecyclerViewActions.actionOnItemAtPosition(0 , new ClickNeighbourViewAction()));
        // Verify if item is visible
        onView(withId(R.id.neighbour_name_info)).check(matches(isDisplayed()));
        onView(withId(R.id.neighbour_name)).check(matches(isDisplayed()));
        // Verify if item isn't empty
        onView(withId(R.id.neighbour_name_info)).check(matches(not(withText(""))));
        onView(withId(R.id.neighbour_name)).check(matches(not(withText(""))));
    }

    /**
     *  Verify if the ImageView is visible
     */
    @Test
    public void detailNeighbour_avatarImageCannotBeEmpty(){
        // Perform a click on the 1st neighbour
        onView(withId(R.id.list_neighbour)).perform(RecyclerViewActions.actionOnItemAtPosition(0 , new ClickNeighbourViewAction()));
        // Verify if item is visible
        onView(withId(R.id.neighbour_avatar)).check(matches(isDisplayed()));
    }

}
