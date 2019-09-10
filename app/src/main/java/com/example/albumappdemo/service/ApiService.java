package com.example.albumappdemo.service;

import com.example.albumappdemo.model.AlbumList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("albums")
    Call<List<AlbumList>> getAlbums();
    @GET("albums/{id}")
    Call<AlbumList> getAlbumsDetail(@Path("id") String user);
}
