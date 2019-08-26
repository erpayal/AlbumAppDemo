package com.example.albumappdemo.dao;

import android.content.Context;

import com.example.albumappdemo.model.AlbumList;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {AlbumList.class}, version = 1)
public abstract class AlbumsDatabase extends RoomDatabase {
    private static final Object sLock = new Object();
    // private static Context context;
    private static AlbumsDatabase INSTANCE;
    private static Callback sRoomDatabaseCallback =
            new Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new AlbumDbAsync(INSTANCE).execute();
                }
            };

    public static AlbumsDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AlbumsDatabase.class, "Albums.db")
                        .allowMainThreadQueries()
                        .build();
            }
            return INSTANCE;
        }
    }

    public abstract AlbumDao albumDao();
}
