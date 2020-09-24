package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    //public static final String STRING_VIDEO_URL = "com.example.assignment1.STRING_VIDEO_URL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner gestureDropDown = (Spinner) findViewById(R.id.gestureSpinner);
        ArrayAdapter<String> gestureAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.gestureList));

        gestureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gestureDropDown.setAdapter(gestureAdapter);
        gestureDropDown.setSelection(0);

        gestureDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent oldintent = getIntent();
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                String url = "";
                switch(i)
                {
                    case 0:
                        break;
                    case 1:
                        url = "https://www.signingsavvy.com/media/mp4-ld/6/6442.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "buy");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );
                        intent1.putExtra("gesture_name", "buy");
                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 2:
                        url = "https://www.signingsavvy.com/media/mp4-ld/23/23234.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "house");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 3:
                        url = "https://www.signingsavvy.com/media/mp4-ld/22/22976.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "fun");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 4:
                        url = "https://www.signingsavvy.com/media/mp4-ld/22/22197.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "hope");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 5:
                        url = "https://www.signingsavvy.com/media/mp4-ld/14/14210.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "arrive");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 6:
                        url = "https://www.signingsavvy.com/media/mp4-ld/24/24977.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "really");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 7:
                        url = "https://www.signingsavvy.com/media/mp4-ld/7/7042.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "read");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 8:
                        url = "https://www.signingsavvy.com/media/mp4-ld/26/26085.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "lip");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 9:
                        url = "https://www.signingsavvy.com/media/mp4-ld/22/22188.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "mouth");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 10:
                        url = "https://www.signingsavvy.com/media/mp4-ld/23/23931.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "some");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 11:
                        url = "https://www.signingsavvy.com/media/mp4-ld/22/22897.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "communicate");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 12:
                        url = "https://www.signingsavvy.com/media/mp4-ld/8/8441.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "write");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 13:
                        url = "https://www.signingsavvy.com/media/mp4-ld/22/22337.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "create");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 14:
                        url = "https://www.signingsavvy.com/media/mp4-ld/25/25901.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "pretend");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 15:
                        url = "https://www.signingsavvy.com/media/mp4-ld/21/21587.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "sister");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 16:
                        url = "https://www.signingsavvy.com/media/mp4-ld/21/21568.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "man");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 17:
                        url = "https://www.signingsavvy.com/media/mp4-ld/11/11001.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "one");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 18:
                        url = "https://www.signingsavvy.com/media/mp4-ld/23/23918.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "drive");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 19:
                        url = "https://www.signingsavvy.com/media/mp4-ld/24/24791.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "perfect");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    case 20:
                        url = "https://www.signingsavvy.com/media/mp4-ld/21/21571.mp4";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "mother");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                    default:
                        url = "default";
                        intent1.putExtra("vid_url", url);
                        intent1.putExtra("gesture_name", "default");
                        intent1.putExtra("asu_id",oldintent.getStringExtra("asuid") );
                        intent1.putExtra("last_name",oldintent.getStringExtra("lastname") );
                        intent1.putExtra("group_id",oldintent.getStringExtra("groupid") );

                        startActivity(intent1);
                        gestureDropDown.setSelection(0);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
