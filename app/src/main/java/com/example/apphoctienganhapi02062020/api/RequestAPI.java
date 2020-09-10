package com.example.apphoctienganhapi02062020.api;

import com.example.apphoctienganhapi02062020.model.response.ResponseData;
import com.example.apphoctienganhapi02062020.model.WordModel;

import java.util.List;

import io.reactivex.Maybe;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestAPI {

    @GET("apituvung/word.php")
    Maybe<ResponseData<List<WordModel>>> getWordsFormPages(
            @Query("page") Integer page,
            @Query("numItems") Integer numItems
    );

    @FormUrlEncoded
    @POST("apituvung/insert.php")
    Maybe<ResponseData<List<WordModel>>> insertWord(
            @Field("en") String en ,
            @Field("vn") String vn ,
            @Field("ismemorized") Integer ismemorized
    );
}
