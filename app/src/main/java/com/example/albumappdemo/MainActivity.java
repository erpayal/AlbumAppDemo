package com.example.albumappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.albumappdemo.databinding.ActivityMainBinding;
import com.example.albumappdemo.model.AlbumList;
import com.example.albumappdemo.viewmodel.AlbumListViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {


    AlbumListViewModel albumViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBindings(savedInstanceState);

    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityMainBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        albumViewModel = ViewModelProviders.of(this).get(AlbumListViewModel.class);

        activityBinding.setModel(albumViewModel);

        setupListUpdate();


    }

    private void setupListUpdate() {
        albumViewModel.getAllAlbums().observe(this, new Observer<List<AlbumList>>() {
            @Override
            public void onChanged(List<AlbumList> albumResponse) {
                Log.e("responsebody", albumResponse.toString() + "ee");

                if (albumResponse.size() == 0) {

                } else {

                    albumViewModel.setAlbumListInAdapter(albumResponse);
                }

            }
        });


    }




}
