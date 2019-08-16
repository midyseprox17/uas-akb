package com.siddiqqulhakim.uas.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.siddiqqulhakim.uas.preference.UserPreference;
import com.siddiqqulhakim.uas.view.MainView;



public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
