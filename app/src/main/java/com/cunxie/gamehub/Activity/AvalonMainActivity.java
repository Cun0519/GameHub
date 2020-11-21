package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cunxie.gamehub.AvalonRole;
import com.cunxie.gamehub.Adapter.AvalonRoleAdapter;
import com.cunxie.gamehub.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AvalonMainActivity extends AppCompatActivity {

    private List<AvalonRole> avalonRoleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalon_main);

        getRoles();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_avalon_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AvalonRoleAdapter adapter = new AvalonRoleAdapter(avalonRoleList);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_avalon_main_play);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AvalonMainActivity.this, AvalonSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getRoles() {
        avalonRoleList.add(new AvalonRole("梅林"));
        avalonRoleList.add(new AvalonRole("派西维尔"));
        avalonRoleList.add(new AvalonRole("忠臣"));
        avalonRoleList.add(new AvalonRole("莫甘娜"));
        avalonRoleList.add(new AvalonRole("刺客"));
        avalonRoleList.add(new AvalonRole("奥伯伦"));
        avalonRoleList.add(new AvalonRole("黑老大"));
        avalonRoleList.add(new AvalonRole("爪牙"));
    }

}