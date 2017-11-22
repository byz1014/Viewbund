package com.example.jni.viewbund;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jni.viewbund.viewbund.FindviewbyId;
import com.example.jni.viewbund.viewbund.ViewUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @FindviewbyId(value = R.id.btn_1, click = true)
    Button btn_1;
    @FindviewbyId(value = R.id.btn_2, click = false)
    Button btn_2;
    @FindviewbyId(value = R.id.btn_3, click = false)
    Button btn_3;
    @FindviewbyId(value = R.id.btn_4, click = false)
    Button btn_4;
    @FindviewbyId(value = R.id.btn_5, click = true)
    Button btn_5;
    @FindviewbyId(value = R.id.btn_6, click = true)
    Button btn_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.getViewUtils().IndexFindViewById(this);
    }

    @Override
    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.btn_1:
                i = 1;
                break;
            case R.id.btn_2:
                i = 2;
                break;
            case R.id.btn_3:
                i = 3;
                break;
            case R.id.btn_4:
                i = 4;
                break;
            case R.id.btn_5:
                i = 5;
                break;
            case R.id.btn_6:
                i = 6;
                break;
        }

        if(i != 0){
            Toast.makeText(MainActivity.this,"按钮---"+i,Toast.LENGTH_SHORT).show();
        }


    }
}
