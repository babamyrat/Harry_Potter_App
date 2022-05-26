package com.example.harrypotterapp.models;

public class UserModel {

    private Integer idUser;
    private String strName;
    private Integer inYear;
    private String strImage;
    private String strText;

    public UserModel(Integer idUser, String strName,
                     Integer inYear, String strImage,
                     String strText) {
        this.idUser = idUser;
        this.strName = strName;
        this.inYear = inYear;
        this.strImage = strImage;
        this.strText = strText;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public Integer getInYear() {
        return inYear;
    }

    public void setInYear(Integer inYear) {
        this.inYear = inYear;
    }

    public String getStrImage() {
        return strImage;
    }

    public void setStrImage(String strImage) {
        this.strImage = strImage;
    }

    public String getStrText() {
        return strText;
    }

    public void setStrText(String strText) {
        this.strText = strText;
    }
}
