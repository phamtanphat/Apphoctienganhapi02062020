package com.example.apphoctienganhapi02062020.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.apphoctienganhapi02062020.R;
import com.example.apphoctienganhapi02062020.model.form.LoadMorePageForm;
import com.example.apphoctienganhapi02062020.model.response.ResponseData;
import com.example.apphoctienganhapi02062020.model.response.WordResponse;
import com.example.apphoctienganhapi02062020.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new MainViewModel();
        getLifecycle().addObserver(mainViewModel);

        mainViewModel.getWordFormPage().observe(this, new Observer<ResponseData<List<WordResponse>>>() {
            @Override
            public void onChanged(ResponseData<List<WordResponse>> listResponseData) {
                Log.d("BBB",listResponseData.toString());
            }
        });

        mainViewModel.loadMoreWordFormPages(new LoadMorePageForm(1,3));
    }
}