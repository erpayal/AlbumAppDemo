package com.example.albumappdemo;

import android.app.Application;
import android.os.Bundle;

import com.example.albumappdemo.databinding.ActivityMainBinding;
import com.example.albumappdemo.databinding.AlbumdescpBinding;
import com.example.albumappdemo.viewmodel.AlbumListViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class AlbumDescpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       AlbumdescpBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.albumdescp);
        AlbumListViewModel albumViewModel = ViewModelProviders.of(this).get(AlbumListViewModel.class);

        activityBinding.setListmodel(albumViewModel);
    }


}
