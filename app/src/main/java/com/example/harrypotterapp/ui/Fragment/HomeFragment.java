package com.example.harrypotterapp.ui.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harrypotterapp.R;
import com.example.harrypotterapp.adapters.UserAdapter;
import com.example.harrypotterapp.models.UserModel;
import com.example.harrypotterapp.ui.ViewModel.UserViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements UserAdapter.ItemClickListener {
 private View view;
    private final List<UserModel> userModels = new ArrayList<>();
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private UserViewModel viewModel;


    public static HomeFragment newInstance() {
        return new HomeFragment();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(UserViewModel.class);

        initView();
        initObserve();

    }

    private void initView() {
        recyclerView = view.findViewById(R.id.recyclerView);
        userAdapter = new UserAdapter(userModels, getContext(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);
    }

    private void initObserve() {
        viewModel.getUserModel();
        viewModel.getLiveData().observe(getViewLifecycleOwner(), userModels -> {
            if (userModels != null) {
                userAdapter.addItems(userModels);
            }
        });
    }

    @Override
    public void onItemClick(UserModel userModel) {
        Fragment fragment = FullFragment.newInstance(userModel.getStrName(), userModel.getStrText(),
                userModel.getStrImage());

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "full_fragment");
        transaction.addToBackStack(null);
        transaction.commit();

    }


}