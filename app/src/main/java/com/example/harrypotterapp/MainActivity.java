package com.example.harrypotterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.harrypotterapp.adapters.UserAdapter;
import com.example.harrypotterapp.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private List<UserModel> modelList;
private UserAdapter adapter;
private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        modelList = new ArrayList<>();

        initUserModel();


        adapter = new UserAdapter(modelList, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


    }

    private void initUserModel() {

        modelList.add(new UserModel(1, "Альбус Дамблдор", 1881, "https://fanfics.me/images/fandoms_heroes/2-1447606879.jpg", "gsdfgsdfgsdfgsdfg"));
        modelList.add(new UserModel(1, "Беллатриса Лестрейндж", 1951, "https://fanfics.me/images/fandoms_heroes/2-1447607427.jpg", "gsdfgsdfgsdfgsdfg"));
        modelList.add(new UserModel(1, "Гарри Поттер", 1980, "https://fanfics.me/images/fandoms_heroes/2-1447605955.jpg", "gsdfgsdfgsdfgsdfg"));
        modelList.add(new UserModel(1, "Гермиона Грейнджер", 1979, "https://fanfics.me/images/fandoms_heroes/2-1447606201.jpg", "gsdfgsdfgsdfgsdfg"));
        modelList.add(new UserModel(1, "Джеймс Поттер", 1960, "https://fanfics.me/images/fandoms_heroes/2-1447755140.jpg", "gsdfgsdfgsdfgsdfg"));



    }
}