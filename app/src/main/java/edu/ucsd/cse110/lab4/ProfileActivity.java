package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", null);
        String status =  preferences.getString("status", null);

        TextView profile_name = findViewById(R.id.name_textview);
        TextView profile_status = findViewById(R.id.status_textview);
        profile_name.setText(name);
        profile_status.setText(status);
    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView profile_name = findViewById(R.id.name_textview);
        TextView profile_status = findViewById(R.id.status_textview);
        editor.putString("name", profile_name.getText().toString());
        editor.putString("status", profile_status.getText().toString());

        editor.apply();
    }

    public void onExitClicked(View view) {
        finish();
    }
}