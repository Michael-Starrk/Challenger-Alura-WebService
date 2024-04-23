package model;

import Calculations.Sortable;

public class Film extends Title implements Sortable {

    private String director;

    public Film(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    @Override
    public int getClassification(){
        return (int) getAverage() / 2;
    }

    @Override
    public String toString(){
        return "Film: " + this.getName() + " ( " + this.getReleaseYear() + ")";
    }
}
