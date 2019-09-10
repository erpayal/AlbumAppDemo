package com.example.albumappdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "album")
public class AlbumList extends BaseObservable {


    @Expose
    @NonNull
    @ColumnInfo(name = "userId")
    @SerializedName("userId")
    String userId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    String id;

    @NonNull
    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    String title;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AlbumList(@NonNull String userId, @NonNull String id, @NonNull String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }
}
