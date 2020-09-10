package com.example.apphoctienganhapi02062020.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apphoctienganhapi02062020.model.form.LoadMorePageForm;
import com.example.apphoctienganhapi02062020.model.response.ResponseData;
import com.example.apphoctienganhapi02062020.model.WordModel;
import com.example.apphoctienganhapi02062020.repository.WordRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel  {
    private MutableLiveData<ResponseData<List<WordModel>>> wordsFormPages;
    private MutableLiveData<ResponseData<List<WordModel>>> wordInsert;
    private WordRepository wordRepository = null;

    public MainViewModel() {
        wordRepository = WordRepository.getInstance();
        wordsFormPages = new MutableLiveData<>();
        wordInsert = new MutableLiveData<>();
    }

    public void loadMoreWordFormPages(LoadMorePageForm loadMorePageForm){
        wordRepository.getWordsFormPages(loadMorePageForm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listResponseData -> wordsFormPages.setValue(listResponseData));
    }
    public LiveData<ResponseData<List<WordModel>>> getWordFormPage(){
        return wordsFormPages;
    }
    public void insertWord(String en , String vn , Integer ismemorized){
        wordRepository.insertWord(en , vn , ismemorized)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listResponseData -> wordInsert.setValue(listResponseData));
    }
    public LiveData<ResponseData<List<WordModel>>> insertResult(){
        return wordInsert;
    }
}
