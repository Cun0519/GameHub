package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.cunxie.gamehub.R;

public class AvalonSettingsActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private Button button;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalon_settings);

        numberPicker = (NumberPicker) findViewById(R.id.numberpicker_avalon_settings_count);
        numberPicker.setMinValue(6);
        numberPicker.setMaxValue(10);
        numberPicker.setValue(6);
        count = 6;
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                count = i1;
            }
        });

        button = (Button) findViewById(R.id.button_avalon_settings_confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AvalonSettingsActivity.this, AvalonAssignmentActivity.class);
                intent.putExtra("count", count);
                startActivity(intent);
            }
        });
    }
}