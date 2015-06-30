package com.bercik.retrofitlista.backend;


import com.bercik.retrofitlista.API.APIProfileInterface;
import com.bercik.retrofitlista.model.Profile;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ArticleRepository {
    static RestAdapter restAdapter= new RestAdapter.Builder().setEndpoint("http://us.battle.net/api/sc2").build();

    public interface OnResponse <T>{
        void OnSuccess(T response);
        void OnError(RetrofitError retrofitError);
    }
    public static void getArticle(final OnResponse<Profile> onResponse) {
        APIProfileInterface restApi = restAdapter.create(APIProfileInterface.class);
        restApi.getProfile(999000, 1, "DayNine", new Callback<Profile>(){
            @Override
            public void success(Profile profile, Response response) {

                onResponse.OnSuccess(profile);
            }
            @Override
            public void failure(RetrofitError error) {
                onResponse.OnError(error);
            }
        });


    }

}