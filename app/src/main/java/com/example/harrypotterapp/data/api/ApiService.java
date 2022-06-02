package com.example.harrypotterapp.data.api;

import androidx.lifecycle.LiveData;

import com.example.harrypotterapp.domain.response.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/37ee55c68606b3890e54")
    Observable<UserResponse> getUserResponses();
}
