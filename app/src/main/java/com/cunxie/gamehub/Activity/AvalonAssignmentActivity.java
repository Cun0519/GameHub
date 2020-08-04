package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.cunxie.gamehub.AvalonRole;
import com.cunxie.gamehub.R;
import com.cunxie.gamehub.Util.Signal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AvalonAssignmentActivity extends AppCompatActivity implements View.OnClickListener{

    private int count;
    private List<AvalonRole> avalonRoleList = new ArrayList<>();
    private List<Integer> avalonAssignmentList = new ArrayList<>();
    private TextView textView0;
    private TextView textView1;
    private Button checkButton;
    private Button contentButton;
    private Button confirmButton;
    private Button playButton;
    private int number = 1;
    private boolean checkFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalon_assignment);

        Intent intent = getIntent();
        count = intent.getIntExtra("count", 0);
        if (count == 0) {
            Signal.signalToast(AvalonAssignmentActivity.this, "角色传递失败");
        }
        initRoleList(count);
        if (count != avalonRoleList.size()) {
            Signal.signalToast(AvalonAssignmentActivity.this, "角色创建失败");
        }
        initAssignmentList(count);
        if (count != avalonAssignmentList.size()) {
            Signal.signalToast(AvalonAssignmentActivity.this, "角色分配失败");
        }

        checkButton = (Button) findViewById(R.id.button_avalon_assignment_check);
        checkButton.setOnClickListener(this);
        contentButton = (Button) findViewById(R.id.button_avalon_assignment_content);
        contentButton.setOnClickListener(this);
        confirmButton = (Button) findViewById(R.id.button_avalon_assignment_confirm);
        confirmButton.setOnClickListener(this);
        playButton = (Button) findViewById(R.id.button_avalon_assignment_play);
        playButton.setOnClickListener(this);
        playButton.setVisibility(View.INVISIBLE);

        textView0 = (TextView) findViewById(R.id.text_avalon_assignment_0);
        textView0.setText("一共" + count + "位玩家");
        textView1 = (TextView) findViewById(R.id.text_avalon_assignment_1);
        textView1.setText("请第" + number + "位玩家查看身份");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_avalon_assignment_check:
                Animator animCheck = ViewAnimationUtils.createCircularReveal(checkButton,
                        checkButton.getWidth() / 2, checkButton.getHeight() / 2, checkButton.getWidth(), 0);
                animCheck.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        checkButton.setVisibility(View.INVISIBLE);
                    }
                });
                animCheck.start();
                if (number == count) {
                    Animator animPlay = ViewAnimationUtils.createCircularReveal(playButton,
                            playButton.getWidth() / 2, playButton.getHeight() / 2, 0, playButton.getWidth());
                    animPlay.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            playButton.setVisibility(View.VISIBLE);
                        }
                    });
                    animPlay.start();
                }
                checkFlag = true;
                break;
            case R.id.button_avalon_assignment_content:
                if (checkFlag) {
                    AvalonRole role = avalonRoleList.get(avalonAssignmentList.get(number - 1));
                    role.goToContent(AvalonAssignmentActivity.this);
                } else {
                    Signal.signalToast(AvalonAssignmentActivity.this, "请查看身份");
                }
                break;
            case R.id.button_avalon_assignment_confirm:
                if (number == count) {
                    Signal.signalToast(AvalonAssignmentActivity.this, "请开始游戏");
                    break;
                }
                if (checkFlag) {
                    Animator animConfirm = ViewAnimationUtils.createCircularReveal(checkButton,
                            checkButton.getWidth() / 2, checkButton.getHeight() / 2, 0, checkButton.getWidth());
                    animConfirm.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            checkButton.setVisibility(View.VISIBLE);
                        }
                    });
                    number++;
                    textView1.setText("请第" + number + "位玩家查看身份");
                    animConfirm.start();
                    checkFlag = false;
                } else {
                    Signal.signalToast(AvalonAssignmentActivity.this, "请查看身份");
                }
                break;
            case R.id.button_avalon_assignment_play:
                Signal.signalToast(AvalonAssignmentActivity.this, "游戏开始");
                break;
        }
    }

    private void initRoleList(int count) {
        switch (count) {
            case 6:
                avalonRoleList.add(new AvalonRole("梅林"));
                avalonRoleList.add(new AvalonRole("派西维尔"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("莫甘娜"));
                avalonRoleList.add(new AvalonRole("刺客"));
                break;
            case 7:
                avalonRoleList.add(new AvalonRole("梅林"));
                avalonRoleList.add(new AvalonRole("派西维尔"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("莫甘娜"));
                avalonRoleList.add(new AvalonRole("刺客"));
                avalonRoleList.add(new AvalonRole("奥伯伦"));
                break;
            case 8:
                avalonRoleList.add(new AvalonRole("梅林"));
                avalonRoleList.add(new AvalonRole("派西维尔"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("莫甘娜"));
                avalonRoleList.add(new AvalonRole("刺客"));
                avalonRoleList.add(new AvalonRole("爪牙"));
                break;
            case 9:
                avalonRoleList.add(new AvalonRole("梅林"));
                avalonRoleList.add(new AvalonRole("派西维尔"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("莫甘娜"));
                avalonRoleList.add(new AvalonRole("刺客"));
                avalonRoleList.add(new AvalonRole("黑老大"));
                break;
            case 10:
                avalonRoleList.add(new AvalonRole("梅林"));
                avalonRoleList.add(new AvalonRole("派西维尔"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("忠臣"));
                avalonRoleList.add(new AvalonRole("莫甘娜"));
                avalonRoleList.add(new AvalonRole("刺客"));
                avalonRoleList.add(new AvalonRole("黑老大"));
                avalonRoleList.add(new AvalonRole("奥伯伦"));
                break;
            default:
                break;
        }
    }

    private void initAssignmentList(int count) {
        Random random = new Random();
        while (avalonAssignmentList.size() < count) {
            int randomInt = random.nextInt(count);
            if (!avalonAssignmentList.contains(randomInt)) {
                avalonAssignmentList.add(randomInt);
            }
        }
    }
}