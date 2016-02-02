package sidespell.tech.midtermexam.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sidespell.tech.midtermexam.model.Album;
import sidespell.tech.midtermexam.utils.HttpUtils;

/**
 * Created by Christian on 2/2/2016.
 */
public class AlbumAPI {
    public static final String BASE_URL     = "http://ws.audioscrobbler.com/2.0/";

    public static final String PARAM_NAME   = "album";
    public static final String PARAM_ARTIST   = "limit";
    public static final String PARAM_API_KEY = "api_key";

    private static final String ALBUM_HEHE = "album";
    private static final String ALBUM_NAME        = "name";
    private static final String ALBUM_ARTIST   = "artist";
    private static final String ALBUM_IMAGE    = "image";

    public static Album getAlubm(Uri uri, @NonNull String requestMethod) {
        String json = HttpUtils.getResponse(uri, requestMethod);

        if (TextUtils.isEmpty(json)) {
            return null;
        }

        // Here we will now parse the json response and convert it into a Weather object.
        final String name;
        final String artist;
        final JSONArray icon;
        final String image;


        try {
            // 1) Convert the json string response into an actual JSON Object
            JSONObject jsonObject = new JSONObject(json);
                JSONObject results = new JSONObject(json);


                JSONArray album = jsonObject.getJSONArray(ALBUM_HEHE);
                JSONObject w0 = album.getJSONObject(50);
                name = w0.getString(ALBUM_NAME).toUpperCase();
                artist = w0.getString(ALBUM_ARTIST).toUpperCase();
                icon = w0.getJSONArray(ALBUM_IMAGE);
                JSONObject imag = icon.getJSONObject(2);
                image = imag.getString(String.valueOf(1));

                // 9) If there's no issue up to this point, then we are now ready to create our
                // Weather model.
               Album a = new Album();
                        a.setmName(name);
                        a.setmArtist(artist);
                        a.setmImageId(image);

                // 10) Get the actual weather icon
                Bitmap imageBitmap = HttpUtils.getImageBitmap(a.getmImageId());
               a.setmAlbumIcon(imageBitmap);

                // 11) Return our weather data
                return a;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
