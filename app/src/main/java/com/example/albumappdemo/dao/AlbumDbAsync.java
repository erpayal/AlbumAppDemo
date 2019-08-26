package com.example.albumappdemo.dao;

import android.os.AsyncTask;

public class AlbumDbAsync extends AsyncTask<Void, Void, Void> {

    private final AlbumDao mDao;

    AlbumDbAsync(AlbumsDatabase db) {
        mDao = db.albumDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
        return null;
    }
}