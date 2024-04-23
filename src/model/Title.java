package model;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title>{
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includeInThePlan;
    private double sumOfRatings;
    private int totalReviews;
    private int durationInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isIncludeInThePlan() {
        return includeInThePlan;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncludeInThePlan(boolean includeInThePlan) {
        this.includeInThePlan = includeInThePlan;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    public void viewTechnicalSheet(){
        System.out.println("Film's name: " + name);
        System.out.println("Release Year: " + releaseYear);
    }

    public void evaluate(double rate){
        sumOfRatings += rate;
        totalReviews++;
    }

    public double getAverage(){
        return sumOfRatings / totalReviews;
    }

    @Override
    public int compareTo(Title anotherTitle) {
        return this.getName().compareTo(anotherTitle.getName());
    }
}
