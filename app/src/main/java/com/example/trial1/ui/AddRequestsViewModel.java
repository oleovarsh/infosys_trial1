package com.example.trial1.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddRequestsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AddRequestsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is add requests fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
