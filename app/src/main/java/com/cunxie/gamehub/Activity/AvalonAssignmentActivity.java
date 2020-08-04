package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.cunxie.gamehub.R;

public class AvalonAssignmentActivity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalon_assignment);

        Intent intent = getIntent();
        count = intent.getIntExtra("count", 0);
    }
}