package com.example.harrypotterapp.ui.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.harrypotterapp.domain.repository.UserRepository;
import com.example.harrypotterapp.models.UserModel;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mUser = UserRepository.getInstance(getApplication());

    private MutableLiveData<List<UserModel>> mLiveData = new MutableLiveData<>();

    public MutableLiveData<List<UserModel>> getLiveData() {
        return mLiveData;
    }

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public void getUserModel() {
        mUser.loadUsers(mLiveData);
    }


}
