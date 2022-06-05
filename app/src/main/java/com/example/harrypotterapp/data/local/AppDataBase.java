package com.example.harrypotterapp.data.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.harrypotterapp.models.UserModel;

@Database(entities = {UserModel.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao personDao();

}
