package com.android.sharedprefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private TextView result;
    private EditText enterMessage;

    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefs";  //file created internally like xml file stores all info for us name of that file here is myPref
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMessage = findViewById(R.id.enterMessage);
        result = findViewById(R.id.result);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    myPrefs = getSharedPreferences(PREFS_NAME,0); //level 0 to be accessible
                    SharedPreferences.Editor editor = myPrefs.edit();

                    editor.putString("message",enterMessage.getText().toString());
                    editor.commit();
            }
        });

        //Get data back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);

        if (prefs.contains("message")){
            String message = prefs.getString("message","not found");
            result.setText("Message:" + message);
        }


    }
}