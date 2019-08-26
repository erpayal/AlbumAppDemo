package com.example.albumappdemo.service;

import com.example.albumappdemo.model.AlbumList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("albums")
    Call<List<AlbumList>> getAlbums();
}
