package com.example.harrypotterapp.data.api;

import static com.example.harrypotterapp.utils.Constant.USER_API_KEY;


import com.example.harrypotterapp.domain.response.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET(USER_API_KEY)
    Observable<UserResponse> getUserResponses();
}
