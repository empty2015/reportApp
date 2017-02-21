package com.envrionment.report.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
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

    @BindView(R.id.tv_right)
    TextView tv_right;




    @OnClick({R.id.tv_101,R.id.tv_102,R.id.tv_baseinfo,R.id.tv_right,R.id.tv_react})
    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId())
        {
            case R.id.tv_101:
                intent = new Intent(MainActivity.this,Table101Activity.class);
                break;
            case R.id.tv_102:
                Intent intent1 = new Intent();
                ComponentName componentName = new ComponentName(MainActivity.this,"com.envrionment.report.activity.TmpActivity");
                intent1.setComponent(componentName);
                startActivity(intent1);
                return;

            case R.id.tv_baseinfo:
                intent = new Intent(MainActivity.this,BaseInfoActivity.class);
                break;
            case R.id.tv_right:
                return;
            case R.id.tv_react:
                showReactApp();
                return;
        }
        startActivity(intent);
    }

    private static final int OVERLAY_PERMISSION_REQ_CODE = 100;
    private void showReactApp(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }else{
                Intent intent = new Intent(this,MyReactActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    Intent intent = new Intent(this,MyReactActivity.class);
                    startActivity(intent);
                }
            }
        }
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
