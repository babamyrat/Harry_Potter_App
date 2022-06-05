package com.example.harrypotterapp.ui.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.harrypotterapp.MainActivity;
import com.example.harrypotterapp.R;


public class FullFragment extends Fragment {

    private TextView txtFullName, txtFullText, txtFullYear;
    private ImageView imgFullImage;
    private View view;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final Integer ARG_PARAM4 = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private Integer mParam4;

    public FullFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FullFragment newInstance(String param1, String param2, String param3, Integer param4) {
        FullFragment fragment = new FullFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putInt(String.valueOf(ARG_PARAM4), param4);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getInt(String.valueOf(ARG_PARAM4));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_full, container, false);

       txtFullName = view.findViewById(R.id.txtFullName);
       txtFullText = view.findViewById(R.id.txtFullText);
       txtFullYear = view.findViewById(R.id.txtFullYear);
       imgFullImage = view.findViewById(R.id.imgFullImage);

       txtFullName.setText(mParam1);
       txtFullText.setText(mParam2);
       txtFullYear.setText(String.valueOf(mParam4));
        Glide.with(this).load(mParam3).into(imgFullImage);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

}