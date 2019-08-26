package com.example.albumappdemo.viewmodel;

import android.app.Application;

import com.example.albumappdemo.R;
import com.example.albumappdemo.adapter.AlbumListAdapter;
import com.example.albumappdemo.dao.AlbumDaoRepository;
import com.example.albumappdemo.model.AlbumList;
import com.example.albumappdemo.service.AlbumRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AlbumListViewModel extends AndroidViewModel {


    private MutableLiveData<List<AlbumList>> mutableLiveData;
    private AlbumRepository albumRepository;
    private AlbumListAdapter albumListAdapter;
    private AlbumList albumList;
    private AlbumDaoRepository albumDaoRepository;

    private LiveData<List<AlbumList>> allAlbums;

    public AlbumListViewModel(Application application) {
        super(application);
        albumDaoRepository = new AlbumDaoRepository(application);
        albumRepository = new AlbumRepository(application);
        mutableLiveData = albumRepository.getAlbums();
        allAlbums = albumDaoRepository.getAllAlbums();
        albumListAdapter = new AlbumListAdapter(R.layout.album_list, this);

    }


    public LiveData<List<AlbumList>> getAllAlbums
            () {
        return allAlbums;
    }

    public void insert(List<AlbumList> album) {
        albumDaoRepository.insert(album);
    }


    public AlbumListAdapter getAdapter() {
        return albumListAdapter;
    }

    public void setAlbumListInAdapter(List<AlbumList> albums) {

        Collections.sort(albums, new Comparator<AlbumList>() {
            public int compare(AlbumList G1, AlbumList G2) {
                return G1.getTitle().compareTo(G2.getTitle());
            }
        });
        this.albumListAdapter.setAlbumLists(albums);
        this.albumListAdapter.notifyDataSetChanged();
    }


    public AlbumList getAlbumAt(Integer index) {
        if (allAlbums.getValue() != null &&
                index != null &&
                allAlbums.getValue().size() > index) {
            return allAlbums.getValue().get(index);
        }
        return null;
    }


}
