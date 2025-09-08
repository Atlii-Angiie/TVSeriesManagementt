
package com.mycompany.tvseriesmanagement;


public class TVSeries {

    private int id;
    private String name;
    private int ageRestriction;
    private int episodes;

    public TVSeries(int id, String name, int ageRestriction, int episodes) {
        this.id = id;
        this.name = name;
        this.ageRestriction = ageRestriction;
        this.episodes = episodes;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAgeRestriction() { return ageRestriction; }
    public int getEpisodes() { return episodes; }

    public void setName(String name) { this.name = name; }
    public void setAgeRestriction(int ageRestriction) { this.ageRestriction = ageRestriction; }
    public void setEpisodes(int episodes) { this.episodes = episodes; }

    @Override
    public String toString() {
        return "Series ID: " + id + "\n" +
               "Series Name: " + name + "\n" +
               "Age Restriction: " + ageRestriction + "\n" +
               "Number of Episodes: " + episodes + "\n" +
               "---------------------------";
    }


}
