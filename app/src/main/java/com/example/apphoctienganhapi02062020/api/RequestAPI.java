package com.example.apphoctienganhapi02062020.api;

import com.example.apphoctienganhapi02062020.model.response.ResponseData;
import com.example.apphoctienganhapi02062020.model.response.WordResponse;

import java.util.List;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestAPI {

    @GET("apituvung/word.php")
    Maybe<ResponseData<List<WordResponse>>> getWordsFormPages(
            @Query("page") Integer page,
            @Query("numItems") Integer numItems
    );
}
