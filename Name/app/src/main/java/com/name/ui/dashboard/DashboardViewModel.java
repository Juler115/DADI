package com.name.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tienes  ");
    }

    public LiveData<String> getText(String naci) {
        int edad = 2024 - Integer.valueOf(naci);
        mText.setValue(mText.getValue() + String.valueOf(edad) + " !");
        return mText;
    }
}