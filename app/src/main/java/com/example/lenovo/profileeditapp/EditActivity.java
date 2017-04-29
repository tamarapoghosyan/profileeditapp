package com.example.lenovo.profileeditapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_MESSAGE_TO_EDIT = "com.example.lenovo.testapp.USEREDIT";
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextUserName;
    EditText editTextGender;
    EditText editTextAge;
    EditText editTextBio;

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();

        user= (User) intent.getSerializableExtra(ProfileActivity.EXTRA_MESSAGE_TO_EDIT);

        editTextName= (EditText) findViewById(R.id.act_edit_et_name);
        editTextName.setText(user.getFirstName());

        editTextLastName= (EditText) findViewById(R.id.act_edit_et_lastname);
        editTextLastName.setText(user.getLastName());
        editTextUserName= (EditText) findViewById(R.id.act_edit_et_username);
        editTextUserName.setText(user.getUserName());
        editTextGender= (EditText) findViewById(R.id.act_edit_et_gender);
        editTextGender.setText(user.getGender());
        editTextAge= (EditText) findViewById(R.id.act_edit_et_age);
        editTextAge.setText(user.getAge().toString());

        editTextBio= (EditText) findViewById(R.id.act_edit_et_bio);
        editTextBio.setText(user.getBio());

//        editTextName.setMinimumWidth(3);


        findViewById(R.id.act_edit_btn_save).setOnClickListener(this);
        findViewById(R.id.act_edit_btn_cancel).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.act_edit_btn_save:{
                if(editTextName.getText().length()==0 ||editTextLastName.getText().length()==0 ||
                        editTextUserName.getText().length()==0|| editTextGender.getText().length()==0 ||
                        editTextAge.getText().length()==0){
                    Toast.makeText(this,"Wrong Data",Toast.LENGTH_SHORT).show();

                }
                else if(editTextName.getText().length()<3 ||editTextLastName.getText().length()<3 || editTextUserName.getText().length()<3 ){
                    Toast.makeText(this,"first name, last name and username must be at least 3 characters long",Toast.LENGTH_SHORT).show();
                }

                else{

                    user.setFirstName(editTextName.getText().toString());
                    user.setLastName(editTextLastName.getText().toString());
                    user.setUserName(editTextUserName.getText().toString());
                    user.setGender(editTextGender.getText().toString());
                    user.setAge(Integer.parseInt(editTextAge.getText().toString()));
                    user.setBio(editTextBio.getText().toString());

                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_MESSAGE_TO_EDIT, user);
                    setResult(Activity.RESULT_OK, intent);
                    //  startActivityForResult(intent,1);
                    finish();}
                break;
//                Intent intent = new Intent(ProfileActivity.this, EditActivity.class);
//
//                intent.putExtra(EXTRA_MESSAGE_TO_EDIT,user);
//                ProfileActivity.this.startActivity(intent);
            }
            case R.id.act_edit_btn_cancel: {

                finish();
                break;

            }
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        user.setFirstName(editTextName.getText().toString());
        user.setLastName(editTextLastName.getText().toString());
        user.setUserName(editTextUserName.getText().toString());
        user.setGender(editTextGender.getText().toString());
        user.setAge(Integer.parseInt(editTextAge.getText().toString()));
        user.setBio(editTextBio.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(EXTRA_MESSAGE_TO_EDIT, user);
        setResult(Activity.RESULT_OK, intent);
        //  startActivityForResult(intent,1);

        finish();

    }
}
