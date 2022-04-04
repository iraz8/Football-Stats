package com.football.football_stats.common.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Player")

public class Player {
    @Id
    @Column(name = "idPlayer", unique = true)
    private Integer idPlayer;

    @Column(name = "idTeam")
    private Integer idTeam;

    @Column(name = "idTeam2")
    private Integer idTeam2;

    @Column(name = "idTeamNational")
    private Integer idTeamNational;

    @Column(name = "strNationality")
    private String strNationality;

    @Column(name = "strPlayer")
    private String strPlayer;

    @Column(name = "strTeam")
    private String strTeam;

    @Column(name = "strTeam2")
    private String strTeam2;

    @Column(name = "strSport")
    private String strSport;

    @Column(name = "dateBorn")
    private String dateBorn;

    @Column(name = "strNumber")
    private String strNumber;

    @Column(name = "dateSigned")
    private String dateSigned;

    @Column(name = "strSigning")
    private String strSigning;

    @Column(name = "strWage")
    private String strWage;

    @Column(name = "strBirthLocation")
    private String strBirthLocation;

    @Column(name = "strDescriptionEN", length = 50000)
    private String strDescriptionEN;

    @Column(name = "strGender")
    private String strGender;

    @Column(name = "strSide")
    private String strSide;

    @Column(name = "strPosition")
    private String strPosition;

    @Column(name = "strFacebook")
    private String strFacebook;

    @Column(name = "strWebsite")
    private String strWebsite;

    @Column(name = "strTwitter")
    private String strTwitter;

    @Column(name = "strInstagram")
    private String strInstagram;

    @Column(name = "strYoutube")
    private String strYoutube;

    @Column(name = "strHeight")
    private String strHeight;

    @Column(name = "strWeight")
    private String strWeight;

    @Column(name = "intLoved")
    private Integer intLoved;

    @Column(name = "strThumb")
    private String strThumb;

    @Column(name = "strCutout")
    private String strCutout;

    @Column(name = "strRender")
    private String strRender;

    @Column(name = "strBanner")
    private String strBanner;

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public Integer getIdTeam2() {
        return idTeam2;
    }

    public void setIdTeam2(Integer idTeam2) {
        this.idTeam2 = idTeam2;
    }

    public Integer getIdTeamNational() {
        return idTeamNational;
    }

    public void setIdTeamNational(Integer idTeamNational) {
        this.idTeamNational = idTeamNational;
    }

    public String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeam2() {
        return strTeam2;
    }

    public void setStrTeam2(String strTeam2) {
        this.strTeam2 = strTeam2;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getStrNumber() {
        return strNumber;
    }

    public void setStrNumber(String strNumber) {
        this.strNumber = strNumber;
    }

    public String getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getStrSigning() {
        return strSigning;
    }

    public void setStrSigning(String strSigning) {
        this.strSigning = strSigning;
    }

    public String getStrWage() {
        return strWage;
    }

    public void setStrWage(String strWage) {
        this.strWage = strWage;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public String getStrSide() {
        return strSide;
    }

    public void setStrSide(String strSide) {
        this.strSide = strSide;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
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

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }

    public String getStrWeight() {
        return strWeight;
    }

    public void setStrWeight(String strWeight) {
        this.strWeight = strWeight;
    }

    public Integer getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(Integer intLoved) {
        this.intLoved = intLoved;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    public String getStrCutout() {
        return strCutout;
    }

    public void setStrCutout(String strCutout) {
        this.strCutout = strCutout;
    }

    public String getStrRender() {
        return strRender;
    }

    public void setStrRender(String strRender) {
        this.strRender = strRender;
    }

    public String getStrBanner() {
        return strBanner;
    }

    public void setStrBanner(String strBanner) {
        this.strBanner = strBanner;
    }

    public String getStrBirthLocation() {
        return strBirthLocation;
    }

    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
    }
}
