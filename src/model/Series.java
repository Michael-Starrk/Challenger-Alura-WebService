package model;

public class Series extends Title{

    private int seasons;
    private boolean activates;
    private int episodesPerSeason;
    private int minutesPerEpisode;

    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public int getSeasons() {
        return seasons;
    }

    public boolean isActivates() {
        return activates;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void setActivates(boolean activates) {
        this.activates = activates;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getDurationInMinutes() {
        return seasons * episodesPerSeason * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return "Series: " + this.getName() + "(" + this.getReleaseYear() + ")";
    }
}
