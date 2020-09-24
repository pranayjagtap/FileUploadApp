package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView gesture = findViewById(R.id.textView);

        Intent intent = getIntent();
        String video_url = intent.getStringExtra("vid_url");
        String gest_name = intent.getStringExtra("gesture_name");

        gesture.setText(gest_name);

        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        VideoView practiceVideoView = (VideoView) findViewById(R.id.practiceVideoView);
        Uri uri = Uri.parse(video_url);
        practiceVideoView.setVideoURI(uri);
        practiceVideoView.start();

        Button btn = (Button)findViewById(R.id.practiceButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oldintent = getIntent();
                Intent intent1 = new Intent(Main2Activity.this, RecordActivity.class);
                intent1.putExtra("asu_id",oldintent.getStringExtra("asu_id") );
                intent1.putExtra("last_name",oldintent.getStringExtra("last_name") );
                intent1.putExtra("group_id",oldintent.getStringExtra("group_id") );
                intent1.putExtra("gesture_name",oldintent.getStringExtra("gesture_name") );

                startActivity(intent1);
            }
        });

    }
}
