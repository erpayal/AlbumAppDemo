package com.example.albumappdemo.service;

import android.app.Application;
import android.util.Log;

import com.example.albumappdemo.dao.AlbumDao;
import com.example.albumappdemo.dao.AlbumDaoRepository;
import com.example.albumappdemo.model.AlbumList;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {


    private static AlbumRepository albumsRepository;
    Application application;
    private AlbumDao albumDao;
    private ApiService apiService;

    public AlbumRepository(Application application) {
        this.application = application;
        apiService = Api.cteateService(ApiService.class);
    }


    public MutableLiveData<List<AlbumList>> getAlbums() {

        final MutableLiveData<List<AlbumList>> albumData = new MutableLiveData<>();
        apiService.getAlbums().enqueue(new Callback<List<AlbumList>>() {
            @Override
            public void onResponse(Call<List<AlbumList>> call,
                                   Response<List<AlbumList>> response) {
                if (response.isSuccessful()) {

                    albumData.setValue(response.body());

                    AlbumDaoRepository albumDaoRepository = new AlbumDaoRepository(application);
                    albumDaoRepository.insert(response.body());


                }
            }

            @Override
            public void onFailure(Call<List<AlbumList>> call, Throwable t) {
                albumData.setValue(null);
            }
        });
        return albumData;
    }



}
