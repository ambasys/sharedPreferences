package com.awesometeach.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userInfo extends AppCompatActivity {
SharedPreferences sharedPreferences;
Intent intent;
TextView welcome;
Button Logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        welcome=findViewById(R.id.welcome);
        Logout=findViewById(R.id.logout);
        sharedPreferences=getSharedPreferences("user_info",MODE_PRIVATE);
        welcome.setText("welcome to "+sharedPreferences.getString("username",null));
        Logout.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                intent=new Intent(userInfo.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
