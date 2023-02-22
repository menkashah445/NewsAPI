package com.example.newsapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homefragment extends Fragment {

    String api = "20f97415ea00405c998161a0277a5cc4";
    Adapter adapter;
    ArrayList<ModelClass> modelClassArrayList;
    String country = "in";
    private  RecyclerView recyclerViewOfhome;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate (R.layout.homefragment,null);

        recyclerViewOfhome = view.findViewById (R.id.homefragments);
        modelClassArrayList = new ArrayList<> ();
        recyclerViewOfhome.setLayoutManager(new LinearLayoutManager (getContext ()));
        adapter = new Adapter (getContext (),modelClassArrayList);
        recyclerViewOfhome.setAdapter (adapter);
        
        findNews();
        return view;
    }

    private void findNews() {
        apiutilities.getApiInterface ().getNews(country,100,api) .enqueue (new Callback<mainNews> () {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful ())
                {
                    modelClassArrayList.addAll (response.body ().getArticles ());
                    adapter.notifyDataSetChanged ();
                }

            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
