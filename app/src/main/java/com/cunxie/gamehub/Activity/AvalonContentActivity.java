package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.cunxie.gamehub.R;

public class AvalonContentActivity extends AppCompatActivity {

    private ImageView avalon_role_image;
    private TextView avalon_role_name;
    private TextView avalon_role_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalon_content);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int imageId = intent.getIntExtra("imageId", 0);
        String content = intent.getStringExtra("content");

        avalon_role_image = findViewById(R.id.avalon_role_image);
        avalon_role_name = findViewById(R.id.avalon_role_name);
        avalon_role_content = findViewById(R.id.avalon_role_content);
        avalon_role_image.setImageResource(imageId);
        avalon_role_name.setText(name);
        avalon_role_content.setText(content);
    }
}