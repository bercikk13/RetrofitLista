package com.bercik.retrofitlista.model;



public class Achievement {


    private Long achievementId;

    private Long completionDate;

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public Achievement withAchievementId(Long achievementId) {
        this.achievementId = achievementId;
        return this;
    }

    public Long getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Long completionDate) {
        this.completionDate = completionDate;
    }

    public Achievement withCompletionDate(Long completionDate) {
        this.completionDate = completionDate;
        return this;
    }
    @Override
    public String toString() {
        return String.format("%d %d",achievementId,completionDate);
    }
}