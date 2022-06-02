package com.example.harrypotterapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.harrypotterapp.R;
import com.example.harrypotterapp.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<UserModel> modelList;
    private Context context;
    private ItemClickListener listener;

    public UserAdapter(List<UserModel> modelList, Context context, ItemClickListener listener) {
        this.modelList = modelList;
        this.context = context;
        this.listener = listener;
    }

    public void addItems(List<UserModel> userModels) {
        modelList.clear();
        modelList.addAll(userModels);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textView.setText(modelList.get(position).getStrName());
//        holder.textView2.setText(modelList.get(position).getInYear());
        holder.textView2.setText(String.valueOf(modelList.get(position).getInYear()));

        Glide.with(context)
                .load(modelList.get(position).getStrImage())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(view -> listener.onItemClick(modelList.get(position)));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2;
        ImageView imageView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

    public interface ItemClickListener{
        void onItemClick(UserModel userModel);
    }
}
