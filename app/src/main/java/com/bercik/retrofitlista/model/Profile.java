package com.bercik.retrofitlista.model;


public class Profile {

    private Integer id;
    private Achievements achievements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Achievements getAchievements() {
        return achievements;
    }

    public void setAchievements(Achievements achievements) {
        this.achievements = achievements;
    }

}
