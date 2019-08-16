package com.siddiqqulhakim.uas.view;

import android.widget.EditText;

import com.siddiqqulhakim.uas.data.model.Friends;



public interface AddEditFriendsView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(Friends friend);
    void showError(EditText et);
    void showFailed(String msg);
}
