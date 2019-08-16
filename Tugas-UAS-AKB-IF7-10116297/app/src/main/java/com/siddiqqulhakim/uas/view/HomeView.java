package com.siddiqqulhakim.uas.view;

import com.siddiqqulhakim.uas.data.model.User;



public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
