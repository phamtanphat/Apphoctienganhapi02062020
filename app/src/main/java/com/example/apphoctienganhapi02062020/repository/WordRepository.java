package com.example.apphoctienganhapi02062020.repository;

import com.example.apphoctienganhapi02062020.api.RequestAPI;
import com.example.apphoctienganhapi02062020.api.RetrofitAPI;

public class WordRepository {
    private static WordRepository wordRepository = null;
    private static RequestAPI requestAPI = null;

    private WordRepository() {
        requestAPI = RetrofitAPI.getInstance();
    }

    public static WordRepository getInstance() {
        if (wordRepository == null) {
            wordRepository = new WordRepository();
        }
        return wordRepository;
    }
}
