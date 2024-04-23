package calculations;

import model.Title;

public class TimeCalculator {

    private int totalTime;

    public int getTotalTime() {
        return this.totalTime;
    }

    public void includes(Title title) {
        System.out.println("Adding duration in minutes" + title);
        this.totalTime += title.getDurationInMinutes();
    }

}
