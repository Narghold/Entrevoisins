package com.openclassrooms.entrevoisins.neighbour_list;

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
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
        // Verify if the item is visible
        onView(ViewMatchers.withId(R.id.list_neighbour)).check(matches(isDisplayed()));
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
        // Verify if the item is visible
        onView(ViewMatchers.withId(R.id.list_neighbour)).check(matches(isDisplayed()));
        // When perform a click on third item
        onView(ViewMatchers.withId(R.id.list_neighbour)).perform(RecyclerViewActions.actionOnItemAtPosition(2, new ClickNeighbourViewAction()));
        // Then open the screen details of the neighbour
        onView(ViewMatchers.withId(R.id.detail_neighbour_activity)).check(matches(isDisplayed()));
    }

    /**
     *  Verify if FavoriteTab is displaying Favorite Neighbours
     */
    @Test
    public void myNeighbourList_addFavoriteAction(){
        // Perform a click on the 1st neighbour
        onView(withId(R.id.list_neighbour)).perform(RecyclerViewActions.actionOnItemAtPosition(0 , new ClickNeighbourViewAction()));
        // Perform a click on the favorite button
        onView(withId(R.id.favorite_btn)).perform(click());
        // Return to last activity
        onView(isRoot()).perform(pressBack());
        // Go to the FavoriteTab
        onView(withId(R.id.main_content)).perform(swipeLeft());
        // Verify if favorite tab isn't empty
        onView(ViewMatchers.withId(R.id.list_favorite)).check(matches(hasMinimumChildCount(1)));
    }
}