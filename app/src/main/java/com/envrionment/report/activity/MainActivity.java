package com.envrionment.report.activity;

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
    @BindView(R.id.edit_scale)
    TextView edit_scale;
    @BindView(R.id.edit_open_time)
    TextView edit_open_time;
    OptionsPickerView pickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        tv_title.setText("工业企业污染排放及处理利用情况");

    }

    OptionsPickerView.OnOptionsSelectListener listener = new OptionsPickerView.OnOptionsSelectListener() {
        @Override
        public void onOptionsSelect(int options1, int option2, int options3) {
            if(selectIndex==0)
            {
                scaleIndex = options1;
                edit_scale.setText(getCompanyScale().get(options1));
            }else if(selectIndex==1)
            {
                yearIndex = options1;
                monthIndex = option2;
                edit_open_time.setText(getComPanyOpenYear().get(options1)+getComPanyOpenMonth().get(options1).get(option2));
            }
        }
    };

    @Override
    public void initListener() {

    }


    private int selectIndex = 0;
    @OnClick({R.id.edit_scale,R.id.edit_open_time})
    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id)
        {
            case R.id.edit_scale:
                selectIndex = 0 ;
                showPickerView(getCompanyScale(),scaleIndex,null,0);

                break;
            case R.id.edit_open_time:
                selectIndex = 1;
                showPickerView(getComPanyOpenYear(),yearIndex,getComPanyOpenMonth(),monthIndex);
                break;
            default:
                break;
        }
    }

    private void showPickerView(ArrayList<String> options1,int option1Index,ArrayList<ArrayList<String>> options2,int option2Index)
    {
        pickerView = new OptionsPickerView(this);
        pickerView.setOnoptionsSelectListener(listener);
        pickerView.findViewById(R.id.tvTitle).setVisibility(View.INVISIBLE);
        pickerView.setCancelable( true );
        pickerView.setPicker(options1,options2,false);
        pickerView.setSelectOptions(option1Index,option2Index);
        pickerView.setCyclic( false );
        pickerView.show();
    }

    ArrayList<String> comPanyScale;
    private int scaleIndex = 0;
    private ArrayList<String> getCompanyScale()
    {
        if(comPanyScale==null)
        {
            comPanyScale = new ArrayList<>();
            comPanyScale.add("大型");
            comPanyScale.add("中型");
            comPanyScale.add("小型");
            comPanyScale.add("微型");
        }

        return comPanyScale;
    }


    private int yearIndex = 0;
    ArrayList<String> comPanyYears;
    ArrayList<String> getComPanyOpenYear()
    {
        if(comPanyYears==null)
        {
            Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
            int curYear = c.get(Calendar.YEAR);
            comPanyYears = new ArrayList<>();
            for(int i=1980;i<=curYear;i++)
                comPanyYears.add(i+"年");
        }
        return comPanyYears;
    }

    private int monthIndex = 0;
    ArrayList<ArrayList<String>> comPanyMoths;
    ArrayList<ArrayList<String>> getComPanyOpenMonth()
    {

        if(comPanyMoths==null)
        {
            comPanyMoths = new ArrayList<>();
            int size = getComPanyOpenYear().size();
            for(int i=0;i<size;i++)
            {
                ArrayList<String> items = new ArrayList<>();
                for(int j=1;j<=12;j++)
                    items.add(j+"月");
                comPanyMoths.add(items);
            }

        }
        return comPanyMoths;
    }

}
