package com.store.play.like.ntsk.likegoogleplaystore;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.store.play.like.ntsk.likegoogleplaystore.databinding.RowAppCardBinding;
import com.store.play.like.ntsk.likegoogleplaystore.databinding.ViewHorizontalAppListBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalAppListView extends RelativeLayout {
    public HorizontalAppListView(Context context) {
        this(context, null);
    }

    public HorizontalAppListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalAppListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ViewHorizontalAppListBinding binding = ViewHorizontalAppListBinding.inflate(LayoutInflater.from(context), this, true);
        HorizontalAppListAdapter adapter = new HorizontalAppListAdapter();
        adapter.addApps(generateApps());

        RecyclerView recyclerView = binding.appList;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recyclerView);
    }

    private class HorizontalAppListAdapter extends RecyclerView.Adapter<HorizontalAppListAdapter.HorizontalAppListViewHolder> {
        private List<AppData> apps = new ArrayList<>();

        @Override
        public HorizontalAppListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HorizontalAppListViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.row_app_card, parent, false));
        }

        @Override
        public void onBindViewHolder(HorizontalAppListViewHolder holder, int position) {
            holder.render(position);
        }

        @Override
        public int getItemCount() {
            return apps.size();
        }

        void addApps(List<AppData> apps) {
            this.apps.addAll(apps);
            notifyDataSetChanged();
        }

        class HorizontalAppListViewHolder extends RecyclerView.ViewHolder {
            private RowAppCardBinding appCardBinding;

            HorizontalAppListViewHolder(View itemView) {
                super(itemView);
                appCardBinding = RowAppCardBinding.bind(itemView);
            }

            void render(final int position) {
                Glide.with(getContext()).load(apps.get(position).getDrawableId()).into(appCardBinding.appImage);
                appCardBinding.appTitle.setText(apps.get(position).getName());
                appCardBinding.appScore.setText(apps.get(position).getScore());
                appCardBinding.appImage.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), apps.get(position).getName() + " is Clicked", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }

    private List<AppData> generateApps() {
        List<AppData> apps = new ArrayList<>();
        apps.add(new AppData(R.drawable.gmail, "Gmail", "4.0"));
        apps.add(new AppData(R.drawable.chrome, "Chrome", "4.1"));
        apps.add(new AppData(R.drawable.game, "Google Play Games", "4.2"));
        apps.add(new AppData(R.drawable.map, "Map", "4.3"));
        apps.add(new AppData(R.drawable.home, "Google Home", "4.4"));
        apps.add(new AppData(R.drawable.music, "Google Play Music", "4.5"));
        apps.add(new AppData(R.drawable.news, "Google News", "4.6"));
        Collections.shuffle(apps);
        return apps;
    }
}
