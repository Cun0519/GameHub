package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.cunxie.gamehub.AvalonRole;
import com.cunxie.gamehub.R;
import com.cunxie.gamehub.Util.Signal;

import java.util.ArrayList;
import java.util.List;

public class AvalonPlayActivity extends AppCompatActivity {

    private NumberPicker numberPicker;
    private Button buttonCheck;
    private Button buttonFinish;

    private List<AvalonRole> avalonRoleList = new ArrayList<>();
    private List<Integer> avalonAssignmentList = new ArrayList<>();

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalon_play);

        Intent intent = getIntent();
        avalonRoleList = (List<AvalonRole>) intent.getSerializableExtra("avalonRoleList");
        avalonAssignmentList = (List<Integer>) intent.getSerializableExtra("avalonAssignmentList");
        if (avalonRoleList.size() != avalonAssignmentList.size()) {
            Signal.signalAlertDialog(AvalonPlayActivity.this, "Error", "Error List Size");
        }

        numberPicker = (NumberPicker) findViewById(R.id.numberpicker_avalon_play_number);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(avalonRoleList.size());
        numberPicker.setValue(1);
        count = 1;
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                count = i1;
            }
        });
        buttonCheck = (Button) findViewById(R.id.button_avalon_play_check);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avalonRoleList.get(avalonAssignmentList.get(count - 1)).goToContent(AvalonPlayActivity.this);
            }
        });
        buttonFinish = (Button) findViewById(R.id.button_avalon_play_finish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}