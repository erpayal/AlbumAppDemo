package com.example.albumappdemo.dao;

import android.app.Application;
import android.os.AsyncTask;

import com.example.albumappdemo.model.AlbumList;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AlbumDaoRepository {


    private AlbumDao albumDao;
    private LiveData<List<AlbumList>> allAlbums;

    public AlbumDaoRepository(Application application) {

        AlbumsDatabase db = AlbumsDatabase.getInstance(application);
        albumDao = db.albumDao();
        allAlbums = albumDao.findAll();
    }

    public LiveData<List<AlbumList>> getAllAlbums() {
        return allAlbums;
    }

    public void insert(List<AlbumList> album) {
        new AlbumDaoRepository.insertAsyncTask(albumDao).execute(album);
    }

    private static class insertAsyncTask extends AsyncTask<List<AlbumList>, Void, Void> {

        private AlbumDao mAsyncTaskDao;

        insertAsyncTask(AlbumDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<AlbumList>... params) {
            mAsyncTaskDao.saveAll(params[0]);
            return null;
        }
    }
}
