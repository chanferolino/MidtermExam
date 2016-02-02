package sidespell.tech.midtermexam.model;

import android.graphics.Bitmap;

/**
 * Created by Christian on 2/2/2016.
 */
public class Album {
    private String mName;
    private String mArtist;
    private String mImageId;
    private Bitmap mAlbumIcon;

    public Album(String mName, String mArtist, String mImageId) {
        this.mName = mName;
        this.mArtist = mArtist;
        this.mImageId = mImageId;

    }

    public Album() {

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    public String getmImageId() {
        return mImageId;
    }

    public void setmImageId(String mImageId) {
        this.mImageId = mImageId;
    }

    public Bitmap getmAlbumIcon() {
        return mAlbumIcon;
    }

    public void setmAlbumIcon(Bitmap mWeatherIcon) {
        this.mAlbumIcon = mWeatherIcon;
    }
}
