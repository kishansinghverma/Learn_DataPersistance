package com.example.learn_datapersistance;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt=findViewById(R.id.editText);
    }

    protected void onPause(){
        super.onPause();
        SharedPreferences sp=getSharedPreferences("com.example.learn_datapersistance", MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("name", edt.getText().toString());
        ed.putBoolean("bool", true);
        ed.putString("test", "Ram");
        ed.apply();
    }

    protected void onResume() {

        super.onResume();
        SharedPreferences sp=getSharedPreferences("com.example.learn_datapersistance", MODE_PRIVATE);
        String s1=sp.getString("name", "user");
        Toast.makeText(this, sp.getString("name", "kuch bhi"), Toast.LENGTH_SHORT).show();
        edt.setText(s1);
    }
}
