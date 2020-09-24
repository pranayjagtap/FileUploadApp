package com.example.assignment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RecordActivity extends AppCompatActivity {
    private String selectedPath;
    static final int REQUEST_VIDEO_CAPTURE = 101;
    private int requestCode;
    private int resultCode;
    private Intent data;
    private TextView textView;
    private TextView textViewResponse;
    private String gesture;
    private String asuid;
    private String lastname;
    private String groupid;
    private String GestureFileName;

    private static final int SELECT_VIDEO = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
        textViewResponse = (TextView) findViewById(R.id.textViewResponse);
        textView.setVisibility(View.GONE);

        Intent oldintent = getIntent();
        gesture=oldintent.getStringExtra("gesture_name");
        asuid=oldintent.getStringExtra("asu_id");
        groupid=oldintent.getStringExtra("group_id");
        lastname=oldintent.getStringExtra("last_name");


        System.out.println(asuid+"P");
        SharedPreferences prefs = getSharedPreferences("datastore", MODE_PRIVATE);
        int trycount = prefs.getInt(lastname+gesture+"practice", 1);//"No name defined" is the default value.

        GestureFileName=gesture+"_"+trycount+"_PRACTICE_"+lastname+".mp4";
        SharedPreferences.Editor editor = getSharedPreferences("datastore", MODE_PRIVATE).edit();
        editor.putInt(lastname+gesture+"practice", trycount+1);
        editor.apply();

    }

    public void captureVideo(View view) {

        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        videoIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 5);

        if (videoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoIntent, REQUEST_VIDEO_CAPTURE);

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("Inside");
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            System.out.println("Inside2");

            Uri videoUri = data.getData();
            System.out.println("Inside3");
            selectedPath = getPath(videoUri);
            System.out.println("Inside4");
            System.out.println("SELECT_VIDEO Path : " + selectedPath);

            textView.setText(selectedPath);

        }
    }


    public String getPath(Uri uri) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    0);
        }

        Cursor cursor = getContentResolver().query(uri, new String[]{MediaStore.MediaColumns.DATA}, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

//        cursor = getContentResolver().query(
//                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
//                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
//        cursor.moveToFirst();
//        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
//        cursor.close();

        return document_id;
    }




    public void uploadVideo(View view) {

        class Upload extends AsyncTask<String, String, String>{
            private int serverResponseCode;
            String iFileName = GestureFileName;
            String lineEnd = "\r\n";
            String twoHyphens = "--";
            String boundary = "*****";
            String Tag="fSnd";
            FileInputStream fileInputStream = null;
            @Override
            protected String doInBackground(String... s){

                String filepath=selectedPath;
                File srcfile=new File(filepath);
                if(!srcfile.isFile()){
                    return "FAIL";
                }
                else{
                    try {
                        fileInputStream=new FileInputStream(srcfile);
                        String uri="http://50f239a6.ngrok.io/cse535/upload_video.php";
                        URL url=new URL(uri);
                        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                        conn.setDoInput(true);

                        // Allow Outputs
                        conn.setDoOutput(true);

                        // Don't use a cached copy.
                        conn.setUseCaches(false);

                        // Use a post method.
                        conn.setRequestMethod("POST");

                        conn.setRequestProperty("Connection", "Keep-Alive");

                        conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
                        conn.setRequestProperty("ENCTYPE","multipart/form-data");
                        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());


                        dos.writeBytes(twoHyphens + boundary + lineEnd);
                        dos.writeBytes("Content-Disposition: form-data; name=\"group_id\""+ lineEnd);
                        dos.writeBytes(lineEnd);
                        dos.writeBytes("22");
                        dos.writeBytes(lineEnd);
                        dos.writeBytes(twoHyphens + boundary + lineEnd);

                        dos.writeBytes(twoHyphens + boundary + lineEnd);
                        dos.writeBytes("Content-Disposition: form-data; name=\"id\""+ lineEnd);
                        dos.writeBytes(lineEnd);
                        dos.writeBytes(asuid);
                        dos.writeBytes(lineEnd);
                        dos.writeBytes(twoHyphens + boundary + lineEnd);

                        dos.writeBytes(twoHyphens + boundary + lineEnd);
                        dos.writeBytes("Content-Disposition: form-data; name=\"accept\""+ lineEnd);
                        dos.writeBytes(lineEnd);
                        dos.writeBytes("1");
                        dos.writeBytes(lineEnd);
                        dos.writeBytes(twoHyphens + boundary + lineEnd);

                        dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\"" + iFileName +"\"" + lineEnd);
                        dos.writeBytes(lineEnd);
                        int bytesAvailable = fileInputStream.available();

                        int maxBufferSize = 1024*1024*20;
                        int bufferSize = Math.min(bytesAvailable, maxBufferSize);
                        byte[ ] buffer = new byte[bufferSize];

                        // read file and write it into form...
                        int bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                        System.out.println(bytesRead);
                        while (bytesRead > 0)
                        {
                            System.out.println("Yes");
                            dos.write(buffer, 0, bufferSize);
                            bytesAvailable = fileInputStream.available();
                            bufferSize = Math.min(bytesAvailable,maxBufferSize);
                            bytesRead = fileInputStream.read(buffer, 0,bufferSize);
                        }
                        dos.writeBytes(lineEnd);
                        dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                        fileInputStream.close();

                        dos.flush();
                        dos.close();
                        String serverResponseMessage = conn.getResponseMessage();
                        System.out.println(serverResponseMessage);
                        serverResponseCode = conn.getResponseCode();

                        System.out.println(serverResponseCode+":"+serverResponseMessage);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return serverResponseCode+"";


                }

            }
            @Override
            protected void onPostExecute(String result){
                Intent intent1 = new Intent(RecordActivity.this, MainActivity.class);
                intent1.putExtra("asuid",asuid);
                intent1.putExtra("lastname",lastname );
                intent1.putExtra("groupid",groupid );


                startActivity(intent1);
            }

        }
       Upload u = new Upload();
        u.execute();
    }



}
