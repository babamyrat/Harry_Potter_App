package com.example.harrypotterapp.data.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.harrypotterapp.models.UserModel;

import java.util.List;
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(List<UserModel> userModels);

    @Query("SELECT * FROM person")
    List<UserModel> loadUsers();
}
