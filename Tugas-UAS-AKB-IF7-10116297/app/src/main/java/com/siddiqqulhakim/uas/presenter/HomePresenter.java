package com.siddiqqulhakim.uas.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.siddiqqulhakim.uas.data.model.User;
import com.siddiqqulhakim.uas.data.repo.UserRepository;
import com.siddiqqulhakim.uas.preference.UserPreference;
import com.siddiqqulhakim.uas.view.HomeView;



public class HomePresenter {

    private HomeView view;
    private UserRepository repo;
    private UserPreference prefs;

    public HomePresenter(Context context, HomeView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new UserPreference(context);
    }

    public void getUserData(LifecycleOwner owner) {
        String username = prefs.userLogin();
        String password = prefs.passwordLogin();

        repo.selectUser(username, password).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                view.showUser(user);
            }
        });
    }

    public void signOut() {
        prefs.setIsLogin(null, null);
        view.onSignOut();
    }
}
