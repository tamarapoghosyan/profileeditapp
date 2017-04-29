package com.example.lenovo.profileeditapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int REQUEST_CODE_TEST = 1;

    public static final String EXTRA_MESSAGE = "com.example.lenovo.testapp.USER";
    public static final String EXTRA_MESSAGE_TO_EDIT = "com.example.lenovo.testapp.USEREDIT";


    TextView textViewName;
    TextView textViewLastName;
    TextView textViewUserName;
    TextView textViewGender;
    TextView textViewAge;
    TextView textViewBio;
    Button buttonEdit;

    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        user= (User) intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE);

        textViewName= (TextView) findViewById(R.id.act_profile_tv_name);
        textViewName.setText(user.getFirstName());
        textViewLastName= (TextView) findViewById(R.id.act_profile_tv_lastname);
        textViewLastName.setText(user.getLastName());
        textViewUserName= (TextView) findViewById(R.id.act_profile_tv_username);
        textViewUserName.setText(user.getUserName());
        textViewGender= (TextView) findViewById(R.id.act_profile_tv_gender);
        textViewGender.setText(user.getGender());
        textViewAge= (TextView) findViewById(R.id.act_profile_tv_age);
        textViewAge.setText(user.getAge().toString());
        textViewBio= (TextView) findViewById(R.id.act_profile_tv_bio);
        textViewBio.setText(user.getBio());

        buttonEdit= (Button) findViewById(R.id.act_profile_btn_edit);
        buttonEdit.setOnClickListener( this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.act_profile_btn_edit:{
                Intent intent = new Intent(ProfileActivity.this, EditActivity.class);

                intent.putExtra(EXTRA_MESSAGE_TO_EDIT,user);
//    ProfileActivity.this.startActivity(intent);
                startActivityForResult(intent,1);
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_TEST){
            Log.d("testt", "requestCode = " + requestCode);
            Log.d("testt", "resultCode = " + resultCode);

            if (resultCode == Activity.RESULT_OK){
                User uu= (User) data.getSerializableExtra(EXTRA_MESSAGE_TO_EDIT);
                user=uu;

                textViewName= (TextView) findViewById(R.id.act_profile_tv_name);
                textViewName.setText(uu.getFirstName());
                textViewLastName= (TextView) findViewById(R.id.act_profile_tv_lastname);
                textViewLastName.setText(uu.getLastName());
                textViewUserName= (TextView) findViewById(R.id.act_profile_tv_username);
                textViewUserName.setText(uu.getUserName());
                textViewGender= (TextView) findViewById(R.id.act_profile_tv_gender);
                textViewGender.setText(uu.getGender());
                textViewAge= (TextView) findViewById(R.id.act_profile_tv_age);
                textViewAge.setText(uu.getAge().toString());
                textViewBio= (TextView) findViewById(R.id.act_profile_tv_bio);
                textViewBio.setText(uu.getBio());

//                String dataStr = data.getStringExtra("aaaaa");
//                textView.setText(dataStr);
            }
        }

    }

}
