package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.cunxie.gamehub.Activity.AvalonMainActivity;
import com.cunxie.gamehub.Game;
import com.cunxie.gamehub.GameAdapter;
import com.cunxie.gamehub.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Game> gameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getGames();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        GameAdapter adapter = new GameAdapter(gameList);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 获得各个游戏的名字和图片
     */
    private void getGames() {
        gameList.add(new Game("Avalon", R.drawable.avalon, new Intent(this, AvalonMainActivity.class)));
        gameList.add(new Game("Werewolf", R.drawable.werewolf, null));
    }
}