package com.example.harrypotterapp.domain.response;

import com.example.harrypotterapp.models.UserModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("person")
    private List<UserModel> person = null;

    public List<UserModel> getPerson() {
        return person;
    }

    public void setPerson(List<UserModel> person) {
        this.person = person;
    }
}
