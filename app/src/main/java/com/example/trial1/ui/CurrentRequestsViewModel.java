package com.example.trial1.ui;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrentRequestsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CurrentRequestsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
