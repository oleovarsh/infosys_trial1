package com.example.trial1.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BrowseRequestViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BrowseRequestViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
