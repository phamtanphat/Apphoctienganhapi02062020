package com.example.apphoctienganhapi02062020.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apphoctienganhapi02062020.model.form.LoadMorePageForm;
import com.example.apphoctienganhapi02062020.model.response.ResponseData;
import com.example.apphoctienganhapi02062020.model.response.WordResponse;
import com.example.apphoctienganhapi02062020.repository.WordRepository;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel  {
    private MutableLiveData<ResponseData<List<WordResponse>>> wordsFormPages;
    private WordRepository wordRepository = null;

    public MainViewModel() {
        wordRepository = WordRepository.getInstance();
        wordsFormPages = new MutableLiveData<>();
    }

    public void loadMoreWordFormPages(LoadMorePageForm loadMorePageForm){
        wordRepository.getWordsFormPages(loadMorePageForm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseData<List<WordResponse>>>() {
                    @Override
                    public void accept(ResponseData<List<WordResponse>> listResponseData) throws Exception {
                        wordsFormPages.setValue(listResponseData);
                    }
                });
    }
    public LiveData<ResponseData<List<WordResponse>>> getWordFormPage(){
        return wordsFormPages;
    }
}
