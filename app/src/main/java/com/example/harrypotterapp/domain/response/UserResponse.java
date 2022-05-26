package com.example.harrypotterapp.domain.response;

import com.example.harrypotterapp.models.UserModel;

import java.util.List;

public class UserResponse {

    private List<UserModel> person = null;

    public List<UserModel> getPerson() {
        return person;
    }

    public void setPerson(List<UserModel> person) {
        this.person = person;
    }
}
