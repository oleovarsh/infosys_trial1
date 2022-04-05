package com.example.trial1.ui;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrentDeliveriesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CurrentDeliveriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
