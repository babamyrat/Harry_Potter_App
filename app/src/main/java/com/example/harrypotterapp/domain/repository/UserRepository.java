package com.example.harrypotterapp.domain.repository;



import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterapp.data.api.ApiClient;
import com.example.harrypotterapp.models.UserModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private Context context;
    private ApiClient apiClient;
    private ArrayList<UserModel> userModels;
    private static UserRepository instance;


    public UserRepository(Context context) {
        this.context = context;
        this.apiClient = ApiClient.getInstance();
        this.userModels = new ArrayList<>();
    }

    public static UserRepository getInstance(Context context){
        if (instance == null){
            instance = new UserRepository(context);
        }
        return instance;
    }

    public void loadUsers(MutableLiveData<List<UserModel>> liveData) {
        // Api
        apiClient.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(UserResponse -> {
                    liveData.postValue(UserResponse.getPerson());
                }, error -> Log.d("ERROR", error.getMessage()));
    }


}
