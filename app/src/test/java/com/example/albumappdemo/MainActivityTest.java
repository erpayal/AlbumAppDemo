package com.example.albumappdemo;

import android.content.Context;

import com.example.albumappdemo.viewmodel.AlbumListViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {
    @Mock
    AlbumListViewModel albumListViewModel;
    @Mock
    Context context;
    @Mock
    MainActivity mainActivity;

    @Test
    public void onCreateTest() {

    }

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

}
