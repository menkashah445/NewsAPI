package com.example.newsapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String Base_URl = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<mainNews> getNews

            (
                    @Query("country") String country,
                    @Query("pageSize") int Pagesize,


                    @Query("apiKey") String apikey

            );

    @GET("top-headlines")
    Call<mainNews> getCategoryNews

            (
                    @Query("country") String country,


                    @Query ("category") String category,
                    @Query("pageSize") int Pagesize,
                    @Query("apiKey") String apikey

            );

//    Call<mainNews> getCategoryNews(String country, String category, int i, String api);

//    Call<mainNews> getNews(String country, int i, String api);
//
//    Call<mainNews> getCategoryNews(String country, String category, int i, String api);
}
