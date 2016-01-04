package com.explore.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.explore.http.ImageLoader;
import com.explore.models.youtube.Video;
import com.vgrec.explore.R;

import java.util.List;

/**
 * @author vgrec, created on 12/2/14.
 */
public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {


    private final List<Video> videos;
    private Context context;

    public VideosAdapter(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Video video = videos.get(position);
        viewHolder.name.setText(video.getTitle());
        viewHolder.duration.setText(video.getDuration());
        ImageLoader.loadImage(context, video.getThumbnailUrl(), viewHolder.videoThumbnail);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView duration;
        public NetworkImageView videoThumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            duration = (TextView) itemView.findViewById(R.id.duration);
            videoThumbnail = (NetworkImageView) itemView.findViewById(R.id.video_thumbnail);
        }
    }
}
