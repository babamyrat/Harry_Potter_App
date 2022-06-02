package com.example.harrypotterapp.data.api;
import com.example.harrypotterapp.domain.response.UserResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private ApiService apiService;
    private static ApiClient instance;


    private ApiClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://api.npoint.io")
                .build();

        apiService = retrofit.create(ApiService.class);

    }

    public static ApiClient getInstance() {
        if (instance == null){
            instance = new ApiClient();
        }
        return instance;
    }

    public Observable<UserResponse> getUsers() {
        return apiService.getUserResponses();
    }




}
