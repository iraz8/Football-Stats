package com.football.football_stats.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "League")
public class League {

    @Id
    @Column(name = "idLeague", unique = true)
    private Integer idLeague;

    @Column(name = "strLeague")
    private String strLeague;

    @Column(name = "strSport")
    private String strSport;

    @Column(name = "strLeagueAlternate")
    private String strLeagueAlternate;

    @Column(name = "intDivision")
    private Integer intDivision;

    @Column(name = "idCup")
    private Integer idCup;

    @Column(name = "strCurrentSeason")
    private String strCurrentSeason;

    @Column(name = "intFormedYear")
    private Integer intFormedYear;

    @Column(name = "strGender")
    private String strGender;

    @Column(name = "strCountry")
    private String strCountry;

    @Column(name = "strWebsite")
    private String strWebsite;

    @Column(name = "strFacebook")
    private String strFacebook;

    @Column(name = "strInstagram")
    private String strInstagram;

    @Column(name = "strTwitter")
    private String strTwitter;

    @Column(name = "strYoutube")
    private String strYoutube;

    @Column(name = "strRSS")
    private String strRSS;

    @Column(name = "strDescriptionEN")
    private String strDescriptionEN;

    @Column(name = "strTvRights")
    private String strTvRights;

    @Column(name = "strBadge")
    private String strBadge;

    @Column(name = "strLogo")
    private String strLogo;

    @Column(name = "strPoster")
    private String strPoster;

    @Column(name = "strTrophy")
    private String strTrophy;

    public Integer getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(Integer idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

    public Integer getIntDivision() {
        return intDivision;
    }

    public void setIntDivision(Integer intDivision) {
        this.intDivision = intDivision;
    }

    public Integer getIdCup() {
        return idCup;
    }

    public void setIdCup(Integer idCup) {
        this.idCup = idCup;
    }

    public String getStrCurrentSeason() {
        return strCurrentSeason;
    }

    public void setStrCurrentSeason(String strCurrentSeason) {
        this.strCurrentSeason = strCurrentSeason;
    }

    public Integer getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(Integer intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
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

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrRSS() {
        return strRSS;
    }

    public void setStrRSS(String strRSS) {
        this.strRSS = strRSS;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrTvRights() {
        return strTvRights;
    }

    public void setStrTvRights(String strTvRights) {
        this.strTvRights = strTvRights;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public String getStrLogo() {
        return strLogo;
    }

    public void setStrLogo(String strLogo) {
        this.strLogo = strLogo;
    }

    public String getStrPoster() {
        return strPoster;
    }

    public void setStrPoster(String strPoster) {
        this.strPoster = strPoster;
    }

    public String getStrTrophy() {
        return strTrophy;
    }

    public void setStrTrophy(String strTrophy) {
        this.strTrophy = strTrophy;
    }
}