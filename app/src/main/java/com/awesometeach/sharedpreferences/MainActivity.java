package com.awesometeach.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
Intent intent;
EditText uname,pass;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login);
        sharedPreferences=getSharedPreferences("user_info",MODE_PRIVATE);
        intent=new Intent(MainActivity.this,userInfo.class);
        if(sharedPreferences.contains("username")&& sharedPreferences.contains("password")){
            startActivity(intent);
        }
        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                        String username=uname.getText().toString();
                                        String passwod=pass.getText().toString();
                                        if(username.equals("awesometeach")&&passwod.equals("awesome")){
                                            SharedPreferences.Editor editor=sharedPreferences.edit();
                                            editor.putString("username",username);
                                            editor.putString("password",passwod);
                                            editor.commit();
                                            startActivity(intent);
                                            Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(MainActivity.this,"Invalid username and password",Toast.LENGTH_SHORT).show();
                                        }
                                     }
                                 }
        );
    }
}
