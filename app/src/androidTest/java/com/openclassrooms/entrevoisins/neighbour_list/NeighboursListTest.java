package com.openclassrooms.entrevoisins.neighbour_list;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.ClickNeighbourViewAction;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

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
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.list_neighbour))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(ViewMatchers.withId(R.id.list_neighbour)).check(withItemCount(ITEMS_COUNT));
        // Make sure that the item is visible
        onView(ViewMatchers.withId(R.id.list_neighbour)).perform(scrollTo());
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_neighbour))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1 , new DeleteViewAction()));
        // Then : the number of element is 11
        onView(ViewMatchers.withId(R.id.list_neighbour)).check(withItemCount(ITEMS_COUNT-1));
    }

    /**
     * When we click on an item, launch DetailNeighbourActivity
     */
    @Test
    public void myNeighbourList_clickAction_shouldLaunchDetail(){
        // Given : Want to see the details at position 3
        onView(ViewMatchers.withId(R.id.list_neighbour)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on third item
        onView(ViewMatchers.withId(R.id.list_neighbour)).perform((ViewAction) RecyclerViewActions.actionOnItemAtPosition(2, new ClickNeighbourViewAction()));
        // Then open the screen details of the neighbour
        onView(ViewMatchers.withId(R.id.detail_neighbour_activity)).check(matches(isDisplayed()));
    }
}