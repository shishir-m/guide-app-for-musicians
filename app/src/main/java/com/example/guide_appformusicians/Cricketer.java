package com.example.guide_appformusicians;

import java.io.Serializable;

public class Cricketer implements Serializable {

    public String cricketerName;
    public String teamName;
    public String time;
    public Cricketer() {

    }

    public Cricketer(String cricketerName, String teamName, String time) {
        this.cricketerName = cricketerName;
        this.teamName = teamName;
        this.time = time;
    }

    public String getCricketerName() {
        return cricketerName;
    }

    public void setCricketerName(String cricketerName) {
        this.cricketerName = cricketerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

}
