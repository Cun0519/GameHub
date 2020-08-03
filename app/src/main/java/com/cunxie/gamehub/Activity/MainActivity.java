package com.cunxie.gamehub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.cunxie.gamehub.Game;
import com.cunxie.gamehub.Adapter.GameAdapter;
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

    private void getGames() {
        gameList.add(new Game("Avalon", R.drawable.avalon));
        gameList.add(new Game("Werewolf", R.drawable.werewolf));
    }
}