package com.example.albumappdemo.dao;

import com.example.albumappdemo.model.AlbumList;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<AlbumList> albums);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(AlbumList album);

    @Update
    void update(AlbumList albums);

    @Delete
    void delete(AlbumList albums);

    @Query("DELETE FROM album")
    void deleteAll();

    @Query("SELECT * FROM album")
    LiveData<List<AlbumList>> findAll();
}
