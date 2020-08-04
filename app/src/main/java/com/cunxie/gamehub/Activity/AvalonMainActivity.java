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
        avalonRoleList.add(new AvalonRole("梅林", R.drawable.meilin,
                "好人方的主公，他能看到除了黑老大之外的所有坏人，他需要在游戏中隐藏自己，给派西维尔透露信息。"));
        avalonRoleList.add(new AvalonRole("派西维尔", R.drawable.paixiweier,
                "好人方的带队人，他能看到莫甘娜和梅林，但不知道谁是真正的梅林，他需要确定真正的梅林，然后带领好人方组队赢得游戏。"));
        avalonRoleList.add(new AvalonRole("忠臣", R.drawable.zhongchen,
                "好人方的成员，他们只能看到自己的身份牌，需要跟随派西维尔的领导让任务成功，并且隐藏真正的梅林身份。"));
        avalonRoleList.add(new AvalonRole("莫甘娜", R.drawable.moganna,
                "坏人方的领头人，莫甘娜能看见除奥伯伦之外的坏人，同时他能被梅林看见，他可以被派西维尔看见，但派西维尔并不知道他的真正身份，所以可以装作自己是梅林来迷惑派西维尔。"));
        avalonRoleList.add(new AvalonRole("刺客", R.drawable.cike,
                "坏人方的精英，他能被梅林看见，他的任务是寻找真正的梅林，并在好人赢得三局游戏后刺杀梅林，刺杀成功则坏人胜利。"));
        avalonRoleList.add(new AvalonRole("奥伯伦", R.drawable.aobolun,
                "坏人方角色，但是他看不到他的队友，他的队友也看不到他，他能被梅林看见。"));
        avalonRoleList.add(new AvalonRole("黑老大", R.drawable.heilaoda,
                "在忠臣里的坏人，梅林晚上看不到他，所以他隐藏在平民里，混进队伍让任务失败。"));
        avalonRoleList.add(new AvalonRole("爪牙", R.drawable.zhuaya,
                "坏人方角色，能被梅林看到。"));
    }

}