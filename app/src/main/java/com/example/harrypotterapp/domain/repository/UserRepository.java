package com.example.harrypotterapp.domain.repository;



import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterapp.data.api.ApiClient;
import com.example.harrypotterapp.data.local.LocalClient;
import com.example.harrypotterapp.models.UserModel;
import com.example.harrypotterapp.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private final Context context;
    private final ApiClient apiClient;
    private static UserRepository instance;
    private final LocalClient localClient;
    private final CompositeDisposable compositeDisposable;


    public UserRepository(Context context) {
        this.context = context;
        apiClient = ApiClient.getInstance();
        localClient = LocalClient.newInstance(context);
        compositeDisposable = new CompositeDisposable();
    }

    public static UserRepository getInstance(Context context){
        if (instance == null){
            instance = new UserRepository(context);
        }
        return instance;
    }

    @SuppressLint("CheckResult")
    public void loadUsers(MutableLiveData<List<UserModel>> liveData) {
        if (NetworkUtils.isNetworkConnected(context)) {
            //api
            apiClient.getUsers()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(UserResponse -> {
                        liveData.postValue(UserResponse.getPerson());
                        insertUserAll(UserResponse.getPerson());
                    }, error -> Log.d("ERROR", error.getMessage()));

        }else {
        // local
            localClient.getUsersDao()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(liveData::postValue, throwable -> {
                    });
        }
    }

    public void insertUserAll(List<UserModel> userModels) {
        compositeDisposable.add(localClient.insertUserLocal(userModels)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    Log.d("SUCCESS", userModels.size() + "person inserted in db");
                }, throwable -> {
                    Log.d("ERROR", "error inserting user : " + throwable.getMessage());
                }));


    }


}
