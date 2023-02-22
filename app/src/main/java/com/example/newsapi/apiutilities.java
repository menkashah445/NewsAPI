package com.example.newsapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiutilities {
    private static Retrofit retrofit= null;


    public  static ApiInterface getApiInterface ()
        {

        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl
                            (ApiInterface.Base_URl).addConverterFactory (GsonConverterFactory.create ())
                    .build ();
        }
        return retrofit.create(ApiInterface.class);
    }

}


