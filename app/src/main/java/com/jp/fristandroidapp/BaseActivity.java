package com.jp.fristandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by jipeng on 2017/3/20.
 */

public class BaseActivity extends AppCompatActivity {

    public void ToastString(String data)
    {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}
