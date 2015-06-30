package com.bercik.retrofitlista.API;


import com.bercik.retrofitlista.model.Profile;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface APIProfileInterface {

    @GET("/profile/{id_usera}/{realm}/{character_name}/")
    void getProfile(@Path("id_usera") long idUser
            ,@Path("realm") long realm
            ,@Path("character_name") String CharacterName
            , Callback<Profile> callback);


}
