package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ActivityCompat.requestPermissions(info.this,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.INTERNET},200);


    }

    public void saveInfo(View view) {

        EditText lname = (EditText) findViewById(R.id.Last_Name);
        String lastname = lname.getText().toString();
        EditText gid = (EditText) findViewById(R.id.Group_ID);
        String group = gid.getText().toString();
        EditText asu = (EditText) findViewById(R.id.ASU_ID);
        String asu_id = asu.getText().toString();

        Intent intent1 = new Intent(info.this, MainActivity.class);
        intent1.putExtra("lastname", lastname);
        intent1.putExtra("groupid", group);
        intent1.putExtra("asuid", asu_id);
        startActivity(intent1);
    }


}
