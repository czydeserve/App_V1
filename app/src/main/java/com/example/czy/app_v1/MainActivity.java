package com.example.czy.app_v1;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.*;



public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button sign_in_btn,sign_up_btn;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2;
    private TextInputLayout tilayout1,tilayout2;
    private EditText text1,text2;


    private void showListDialog() {
        final String[] items = { "拍摄","从相册选择" };
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(MainActivity.this);
        listDialog.setTitle("上传头像");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        "你选择了[" + items[which]+"]",
                        Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(MainActivity.this,"你选择了[取消]",Toast.LENGTH_SHORT).show();
                    }
                });
        listDialog.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup3);
        sign_in_btn = (Button) findViewById(R.id.button2);
        sign_up_btn = (Button) findViewById(R.id.button1);
        rb1 = (RadioButton) findViewById(R.id.radioButton3);
        rb2 = (RadioButton) findViewById(R.id.radioButton4);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText1);
        tilayout1 = (TextInputLayout) findViewById(R.id.textInputLayout1);
        tilayout2 = (TextInputLayout) findViewById(R.id.textInputLayout2);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showListDialog();
            }

        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup mRoot, int id) {
                switch (id) {
                    case R.id.radioButton3:
                        Snackbar.make(mRoot,"你选择了学生",Snackbar.LENGTH_SHORT).
                                setAction("确定",new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){
                                        Toast.makeText(MainActivity.this, "SnackBar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                    }
                                } ).setActionTextColor(getResources().getColor(R.color.colorBlue)).setDuration(5000).show();
                        break;
                    case R.id.radioButton4:
                        Snackbar.make(mRoot,"你选择了教职工",Snackbar.LENGTH_SHORT).
                                setAction("确定",new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){
                                        Toast.makeText(MainActivity.this, "SnackBar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                    }
                                } ).setActionTextColor(getResources().getColor(R.color.colorBlue)).setDuration(5000).show();
                        break;
                }
            }
       });
        sign_in_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String number = tilayout1.getEditText().getText().toString();
                String password = tilayout2.getEditText().getText().toString();
                if(TextUtils.isEmpty(number)){
                    tilayout1.setError("学号不能为空");
                    tilayout1.setErrorEnabled(true);
                    tilayout2.setError(null);
                    tilayout2.setErrorEnabled(false);
                }
                else if(TextUtils.isEmpty(password)){
                    tilayout2.setError("密码不能为空");
                    tilayout2.setErrorEnabled(true);
                    tilayout1.setError(null);
                    tilayout1.setErrorEnabled(false);
                }
                else if(number.equals("123456") && password.equals("6666")){
                    tilayout1.setErrorEnabled(false);
                    tilayout2.setErrorEnabled(false);
                    Snackbar.make(sign_in_btn,"登陆成功",Snackbar.LENGTH_SHORT).
                            setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(MainActivity.this, "SnackBar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            } ).setDuration(5000).show();
                }
                else{
                    tilayout1.setErrorEnabled(false);
                    tilayout2.setErrorEnabled(false);
                    Snackbar.make(sign_in_btn,"学号或密码错误",Snackbar.LENGTH_SHORT).
                            setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(MainActivity.this, "SnackBar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            } ).setActionTextColor(getResources().getColor(R.color.colorBlue)).setDuration(5000).show();
                }

            }

        });
        sign_up_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(rb1.isChecked()){
                    Snackbar.make(sign_in_btn,"学生注册功能尚未启用",Snackbar.LENGTH_SHORT).
                            setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(MainActivity.this, "SnackBar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            } ).setActionTextColor(getResources().getColor(R.color.colorBlue)).setDuration(5000).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "教职工注册功能尚未启用", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
