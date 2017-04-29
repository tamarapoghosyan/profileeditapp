package com.example.lenovo.profileeditapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.lenovo.editapp.USER";

    User user1;
    User user2;
    TextView textViewName1;
    TextView textViewName2;
    TextView textViewGender1;
    TextView textViewGender2;
    FrameLayout frameLayoutJohn;
    FrameLayout frameLayoutSarah;
    FrameLayout frameLayoutAddedJohn;
    FrameLayout frameLayoutAddedSarah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user1=new User(1,"John","Smith","johnsmith","M",26,"I am an engineer");
        user2=new User(2,"Sarah","Jonson","sarahjonson","F",22,"I am a singer");


        textViewName1= (TextView) findViewById(R.id.act_main_tv_name1);
        textViewName2= (TextView) findViewById(R.id.act_main_tv_name2);
        textViewGender1= (TextView) findViewById(R.id.act_main_tv_gender1);
        textViewGender2= (TextView) findViewById(R.id.act_main_tv_gender2);
        textViewName1.setText(user1.getFirstName()+" "+user1.getLastName());
        textViewGender1.setText(user1.getGender());

        textViewName2.setText(user2.getFirstName()+" "+user2.getLastName());
        textViewGender2.setText(user2.getGender());

        frameLayoutJohn= (FrameLayout) findViewById(R.id.layout_john);
        frameLayoutSarah= (FrameLayout) findViewById(R.id.layout_sarah);
        frameLayoutAddedJohn= (FrameLayout) findViewById(R.id.layout_added_john);
        frameLayoutAddedSarah= (FrameLayout) findViewById(R.id.layout_added_sarah);

        frameLayoutJohn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frameLayoutAddedSarah.getVisibility()==View.VISIBLE){
//                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//
//                    intent.putExtra(EXTRA_MESSAGE,user1);
//                    MainActivity.this.startActivity(intent);
                    // frameLayoutAddedSarah.setVisibility(View.GONE);
                }
                if(frameLayoutAddedJohn.getVisibility()==View.VISIBLE){
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

                    intent.putExtra(EXTRA_MESSAGE,user1);
                    MainActivity.this.startActivity(intent);
                }else{
                    frameLayoutAddedJohn.setVisibility(View.VISIBLE);
                }
            }
        });
        frameLayoutSarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frameLayoutAddedJohn.getVisibility()==View.VISIBLE){

                    frameLayoutAddedJohn.setVisibility(View.GONE);
                }
                if(frameLayoutAddedSarah.getVisibility()==View.VISIBLE){
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

                    intent.putExtra(EXTRA_MESSAGE,user2);
                    MainActivity.this.startActivity(intent);
//                    frameLayoutAddedSarah.setVisibility(View.GONE);
                }else {
                    frameLayoutAddedSarah.setVisibility(View.VISIBLE);
                }
            }
        });

    }

}
