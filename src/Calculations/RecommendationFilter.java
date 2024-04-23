package Calculations;

import java.util.SortedMap;

public class RecommendationFilter {

    private String Recommendation;

    public void filter(Sortable sortable) {
        if (sortable.getClassification() >= 4) {
            System.out.println("This title is one of my most favorites at the moment");
        } else if (sortable.getClassification() >= 2) {
            System.out.println("Very highly rated at the moment!");
        } else {
            System.out.println("Put it on your list to watch later");
        }
    }

}
