package com.example.alex.berich.ui.base;

public interface Presenter< T> {

    void attachView(T mvpView);

    void detachView();
}
