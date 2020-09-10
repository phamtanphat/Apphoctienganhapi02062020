package com.example.apphoctienganhapi02062020.repository;

import com.example.apphoctienganhapi02062020.api.RequestAPI;
import com.example.apphoctienganhapi02062020.api.RetrofitAPI;
import com.example.apphoctienganhapi02062020.model.form.LoadMorePageForm;
import com.example.apphoctienganhapi02062020.model.response.ResponseData;
import com.example.apphoctienganhapi02062020.model.WordModel;

import java.util.List;

import io.reactivex.Maybe;

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
    public Maybe<ResponseData<List<WordModel>>> getWordsFormPages(LoadMorePageForm loadMore){
        return requestAPI
                .getWordsFormPages(
                        loadMore.getPage(),
                        loadMore.getNumItems()
                );
    }
    public Maybe<ResponseData<List<WordModel>>> insertWord(String en , String vn , Integer ismemorized){
        return requestAPI
                .insertWord(en ,vn , ismemorized);
    }
}
