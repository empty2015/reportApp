package com.envrionment.report.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.envrionment.report.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_101)
    TextView tv_101;

    @BindView(R.id.tv_102)
    TextView tv_102;

    @BindView(R.id.tv_baseinfo)
    TextView tv_baseinfo;


    @OnClick({R.id.tv_101,R.id.tv_102,R.id.tv_baseinfo})
    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId())
        {
            case R.id.tv_101:
                intent = new Intent(MainActivity.this,Table101Activity.class);
                break;
            case R.id.tv_102:
                return;

            case R.id.tv_baseinfo:
                intent = new Intent(MainActivity.this,BaseInfoActivity.class);
                break;
        }
        startActivity(intent);
    }





    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        tv_title.setText("表格信息状态");
    }

    @Override
    public void initListener() {

    }
}
