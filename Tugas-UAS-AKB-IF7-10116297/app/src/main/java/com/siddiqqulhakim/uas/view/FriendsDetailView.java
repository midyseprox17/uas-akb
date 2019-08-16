package com.siddiqqulhakim.uas.view;

import com.siddiqqulhakim.uas.data.model.Friends;



public interface FriendsDetailView {
    void showDetail(Friends fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void onFriendDeleted();
}
