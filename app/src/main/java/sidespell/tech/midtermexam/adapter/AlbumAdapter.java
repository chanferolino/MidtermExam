package sidespell.tech.midtermexam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sidespell.tech.midtermexam.R;
import sidespell.tech.midtermexam.model.Album;

/**
 * Created by Christian on 2/2/2016.
 */
public class AlbumAdapter extends ArrayAdapter<Album> {

    private Context mContext;
    private int         mLayoutId;
    private List<Album> mAlbum;

    public AlbumAdapter(Context context, int resource, List<Album> album) {
        super(context, resource, album);

        mContext = context;
        mLayoutId = resource;
        mAlbum = album;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();
            viewHolder.imgMovie = (ImageView) convertView.findViewById(R.id.imgAlbum);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvSinger = (TextView) convertView.findViewById(R.id.tvSinger);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the movie data
        Album album= mAlbum.get(position);

        if (album != null) {
            if (viewHolder.imgMovie != null) {
                viewHolder.imgMovie.setImageResource(Integer.parseInt(album.getmImageId()));
            }
            if (viewHolder.tvName != null) {
                viewHolder.tvName.setText(album.getmName());
            }
            if (viewHolder.tvSinger != null) {
                viewHolder.tvSinger.setText(album.getmArtist());
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        public ImageView imgMovie;
        public TextView  tvName;
        public TextView  tvSinger;
    }
}