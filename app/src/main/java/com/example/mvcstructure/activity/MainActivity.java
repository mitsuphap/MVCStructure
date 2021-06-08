package com.example.mvcstructure.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mvcstructure.R;
import com.example.mvcstructure.fragment.MainFragment;
import com.example.mvcstructure.fragment.SecondFragment;
import com.example.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        Toast.makeText(this, "Width = " + screenWidth + " Height = " + screenHeight,
                Toast.LENGTH_SHORT);

        if (Build.VERSION.SDK_INT >= 21) {
            //Run on Android 21+
        } else {
            //Run on Android 1-20
        }

        if (savedInstanceState == null) {
            // First Create
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(123), "MainFragment")
                    .commit();

            SecondFragment secondFragment = SecondFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,
                            secondFragment,
                            "SecondFragment")
                    .detach(secondFragment)
                    .commit();

        }
    }

    @Override
    protected void onPostCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment mainFragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            mainFragment.setHelloText("Woo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\nWoo Hooooooo\n");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_first_tab: {
                MainFragment mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");
                getSupportFragmentManager().beginTransaction()
                        .attach(mainFragment)
                        .detach(secondFragment)
                        .commit();
                return true;
            }

            case R.id.action_second_tab: {

                MainFragment mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");
                getSupportFragmentManager().beginTransaction()
                        .attach(secondFragment)
                        .detach(mainFragment)
                        .commit();
                return true;
            }

            case R.id.action_second_fragment: {

                Fragment fragment = getSupportFragmentManager()
                        .findFragmentById(R.id.contentContainer);

                if (fragment instanceof SecondFragment == false) {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right)
                            .replace(R.id.contentContainer,
                                    SecondFragment.newInstance())
                            .addToBackStack(null)
                            .commit();

                    SecondFragment secondFragment = SecondFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contentContainer,
                                    secondFragment,
                                    "SecondFragment")
                            .detach(secondFragment)
                            .commit();
                }

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}