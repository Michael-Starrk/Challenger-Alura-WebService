package main;

import calculations.RecommendationFilter;
import calculations.TimeCalculator;
import model.Episode;
import model.Film;
import model.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Film myFilm = new Film("O poderoso chefao", 1970);
        myFilm.setDurationInMinutes(180);
        System.out.println("Film duration: " + myFilm.getDurationInMinutes());

        myFilm.viewTechnicalSheet();
        myFilm.evaluate(8);
        myFilm.evaluate(10);
        myFilm.evaluate(5);
        System.out.println("Total reviews: " + myFilm.getTotalReviews());
        System.out.println(myFilm.getAverage());

        Series lost = new Series("Lost", 2000);
        lost.viewTechnicalSheet();
        lost.setSeasons(10);
        lost.setEpisodesPerSeason(10);
        lost.setMinutesPerEpisode(50);
        System.out.println("Duration to marathon Lost: " + lost.getDurationInMinutes());

        Film AnotherFilm = new Film("Avatar", 2023);
        AnotherFilm.setDurationInMinutes(200);

        TimeCalculator calculator = new TimeCalculator();
        calculator.includes(myFilm);
        calculator.includes(AnotherFilm);
        calculator.includes(lost);
        System.out.println(calculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(myFilm);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSeries(lost);
        episode.setTotalViews(300);
        filter.filter(episode);

        var filmDoPaulo = new Film("Dogville", 2003);
        filmDoPaulo.setDurationInMinutes(200);
        filmDoPaulo.evaluate(10);

        ArrayList<Film> filmList = new ArrayList<>();
        filmList.add(filmDoPaulo);
        filmList.add(myFilm);
        filmList.add(AnotherFilm);
        System.out.println("Tamanho da lista " + filmList.size());
        System.out.println("Primeiro filme " + filmList.get(0).getName());
        System.out.println(filmList);
        System.out.println("toString do filme " + filmList.get(0).toString());


    }
}
