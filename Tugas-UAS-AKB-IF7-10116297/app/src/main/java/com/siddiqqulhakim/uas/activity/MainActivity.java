package com.siddiqqulhakim.uas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.siddiqqulhakim.uas.R;
import com.siddiqqulhakim.uas.fragment.AboutFragmentManager;
import com.siddiqqulhakim.uas.fragment.ContactFragment;
import com.siddiqqulhakim.uas.fragment.FriendsFragment;
import com.siddiqqulhakim.uas.fragment.HomeFragment;
import com.siddiqqulhakim.uas.fragment.ProfileFragment;
import com.siddiqqulhakim.uas.presenter.MainPresenter;
import com.siddiqqulhakim.uas.view.MainView;



public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;
    FragmentManager fm = getSupportFragmentManager();
    final Fragment home = new HomeFragment();
    final Fragment profil = new ProfileFragment();
    final Fragment contact = new ContactFragment();
    final Fragment friend = new FriendsFragment();
    final Fragment about = new AboutFragmentManager();
    Fragment active = profil;
    Fragment[] fragment = {about, friend, contact, profil, home};

    @Override
    public void showView(Fragment fragment) {
        fm.beginTransaction().hide(active).show(fragment).commit();
        active = fragment;
    }

    @Override
    public void addView() {
        for (int i = 0; i<5; i++) {
            fm.beginTransaction().add(R.id.content, fragment[i]).hide(fragment[i]).commit();
        }
    }

    @Override
    public void toLogin() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    presenter.changeView(home);
                    return true;
                case R.id.navigation_profile:
                    presenter.changeView(profil);
                    return true;
                case R.id.navigation_contact:
                    presenter.changeView(contact);
                    return true;
                case R.id.navigation_friends:
                    presenter.changeView(friend);
                    return true;
                case R.id.navigation_about:
                    presenter.changeView(about);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this,this);
        presenter.isLogin();
        presenter.addView();
        presenter.changeView(home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
