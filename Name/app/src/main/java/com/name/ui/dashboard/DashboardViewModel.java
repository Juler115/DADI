package com.name.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bienvenido ");
    }

    public LiveData<String> getText(String name) {
        mText.setValue(mText.getValue() + name + " !");
        return mText;
    }
}