package com.example.harrypotterapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("idUser")
    @Expose
    private Integer idUser;
    @SerializedName("strName")
    @Expose
    private String strName;
    @SerializedName("inYear")
    @Expose
    private Integer inYear;
    @SerializedName("strImage")
    @Expose
    private String strImage;
    @SerializedName("strText")
    @Expose
    private String strText;

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
