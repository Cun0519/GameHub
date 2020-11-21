package com.cunxie.gamehub.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cunxie.gamehub.AvalonRole;
import com.cunxie.gamehub.R;

import java.util.ArrayList;
import java.util.List;

public class AvalonRoleAdapter extends RecyclerView.Adapter<AvalonRoleAdapter.ViewHolder> {

    private List<AvalonRole> mAvalonRoleList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder {
        View avalonRoleView;
        ImageView avalonRoleImage;
        TextView avalonRoleName;

        public ViewHolder(View view) {
            super(view);
            avalonRoleView = view;
            avalonRoleImage = (ImageView) view.findViewById(R.id.avalon_role_image);
            avalonRoleName = (TextView) view.findViewById(R.id.avalon_role_name);
        }
    }

    public AvalonRoleAdapter(List<AvalonRole> avalonRoleList) {
        mAvalonRoleList = avalonRoleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_avalon_role, parent, false);
        final AvalonRoleAdapter.ViewHolder holder = new AvalonRoleAdapter.ViewHolder(view);
        holder.avalonRoleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                AvalonRole avalonRole = mAvalonRoleList.get(position);
                //传递上下文
                avalonRole.goToContent(view.getContext());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AvalonRoleAdapter.ViewHolder holder, int position) {
        AvalonRole avalonRole = mAvalonRoleList.get(position);
        holder.avalonRoleImage.setImageResource(avalonRole.getImageId());
        holder.avalonRoleName.setText(avalonRole.getName());

    }

    @Override
    public int getItemCount() {
        return mAvalonRoleList.size();
    }
}
