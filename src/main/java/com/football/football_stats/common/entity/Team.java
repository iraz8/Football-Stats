package com.football.football_stats.common.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Team")

public class Team {

    @Id
    @Column(name = "idTeam", unique = true)
    private int idTeam;

    @Column(name = "strTeam")
    private String strTeam;

    @Column(name = "intFormedYear")
    private int intFormedYear;

    @Column(name = "strTeamShort")
    private String strTeamShort;

    @Column(name = "strLeague")
    private String strLeague;

    @Column(name = "strLeague2")
    private String strLeague2;

    @Column(name = "strLeague3")
    private String strLeague3;

    @Column(name = "strLeague4")
    private String strLeague4;

    @Column(name = "strLeague5")
    private String strLeague5;

    @Column(name = "strLeague6")
    private String strLeague6;

    @Column(name = "strLeague7")
    private String strLeague7;

    @Column(name = "strStadium")
    private String strStadium;

    @Column(name = "strRss")
    private String strRss;

    @Column(name = "strStadiumThumb")
    private String strStadiumThumb;

    @Column(name = "strStadiumDescription", length = 50000)
    private String strStadiumDescription;

    @Column(name = "strStadiumLocation")
    private String strStadiumLocation;

    @Column(name = "intStadiumCapacity")
    private int intStadiumCapacity;

    @Column(name = "strWebsite")
    private String strWebsite;

    @Column(name = "strFacebook")
    private String strFacebook;

    @Column(name = "strTwitter")
    private String strTwitter;

    @Column(name = "strInstagram")
    private String strInstagram;

    @Column(name = "strDescriptionEN", length = 50000)
    private String strDescriptionEN;

    @Column(name = "strCountry")
    private String strCountry;

    @Column(name = "strTeamBadge")
    private String strTeamBadge;

    @Column(name = "strTeamJersey")
    private String strTeamJersey;

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrLeague2() {
        return strLeague2;
    }

    public void setStrLeague2(String strLeague2) {
        this.strLeague2 = strLeague2;
    }

    public String getStrLeague3() {
        return strLeague3;
    }

    public void setStrLeague3(String strLeague3) {
        this.strLeague3 = strLeague3;
    }

    public String getStrLeague4() {
        return strLeague4;
    }

    public void setStrLeague4(String strLeague4) {
        this.strLeague4 = strLeague4;
    }

    public String getStrLeague5() {
        return strLeague5;
    }

    public void setStrLeague5(String strLeague5) {
        this.strLeague5 = strLeague5;
    }

    public String getStrLeague6() {
        return strLeague6;
    }

    public void setStrLeague6(String strLeague6) {
        this.strLeague6 = strLeague6;
    }

    public String getStrLeague7() {
        return strLeague7;
    }

    public void setStrLeague7(String strLeague7) {
        this.strLeague7 = strLeague7;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }

    public int getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    public void setIntStadiumCapacity(int intStadiumCapacity) {
        this.intStadiumCapacity = intStadiumCapacity;
    }

    public String getStrRss() {
        return strRss;
    }

    public void setStrRss(String strRss) {
        this.strRss = strRss;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }

    public void setStrTeamShort(String strTeamShort) {
        this.strTeamShort = strTeamShort;
    }


    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public int getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(int intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }
}
