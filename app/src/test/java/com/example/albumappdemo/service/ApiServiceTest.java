package com.example.albumappdemo.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ApiServiceTest {
    @Mock
    ApiService apiService;

    @Test
    public void getAlbumsTest() {
    }

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }
}