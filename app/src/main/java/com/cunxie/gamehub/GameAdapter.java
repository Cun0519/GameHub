package com.cunxie.gamehub;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private static final String TAG = "GameAdapter";

    private List<Game> mGameList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View gameView;
        ImageView gameImage;
        TextView gameName;

        public ViewHolder(View view) {
            super(view);
            gameView = view;
            gameImage = (ImageView) view.findViewById(R.id.game_image);
            gameName = (TextView) view.findViewById(R.id.game_name);
        }
    }

    public GameAdapter(List<Game> gameList) {
        mGameList = gameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.gameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Game game = mGameList.get(position);
                game.goToGame(view.getContext());
                //Toast.makeText(view.getContext(), "You Click " + game.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Game game = mGameList.get(position);
        holder.gameImage.setImageResource(game.getImageId());
        holder.gameName.setText(game.getName());
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }
}
