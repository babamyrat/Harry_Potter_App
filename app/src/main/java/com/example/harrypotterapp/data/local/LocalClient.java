package com.example.harrypotterapp.data.local;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.harrypotterapp.models.UserModel;

import java.util.List;

import io.reactivex.Observable;

public class LocalClient {
    private static LocalClient instance;
    private final AppDataBase appDataBase;

    private LocalClient(Context context){

        appDataBase =  Room.databaseBuilder(context,
                AppDataBase.class, "database").build();

    }

    public static LocalClient newInstance(Context context) {
        if(instance == null)
            instance = new LocalClient(context);
            return instance;
    }

    public Observable<List<UserModel>> getUsersDao(){
        return Observable.fromCallable(() -> appDataBase.personDao().loadUsers());
    }

    public Observable<Boolean> insertUserLocal(List<UserModel> userModels){

        return Observable.fromCallable(() -> {
            try {
                appDataBase.personDao().insertUsers(userModels);

                return true;
            } catch (Exception e){
                Log.d("Error", e.getMessage());
            }
            return false;
        });

    }

}
