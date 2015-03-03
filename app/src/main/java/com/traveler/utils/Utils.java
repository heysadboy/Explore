package com.traveler.utils;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveler.Constants;
import com.traveler.models.flickr.FlickrPhoto;
import com.traveler.models.flickr.Size;
import com.traveler.models.google.GooglePhoto;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vgrec, created on 9/5/14.
 */
public class Utils {


    public static <T> T fromJson(Class<T> clazz, String json) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (IOException e) {
            Log.e("GREC", "Cannot construct object from json", e);
        }
        return null;
    }

    public static <T> String toJson(T object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            Log.e("GREC", "Exception", e);
        }
        return null;
    }

    public static void setColorForTextViewDrawable(int color, TextView... textViews) {
        for (TextView textView : textViews) {
            Drawable[] drawables = textView.getCompoundDrawables();
            Drawable leftDrawable = drawables[0];
            leftDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
    }


    public static ArrayList<String> flickrPhotosToUrls(ArrayList<FlickrPhoto> flickrPhotos) {
        ArrayList<String> urls = new ArrayList<>();
        for (FlickrPhoto flickrPhoto : flickrPhotos) {
            urls.add(String.format(Constants.Flickr.PHOTO_URL, flickrPhoto.getFarm(), flickrPhoto.getServer(), flickrPhoto.getId(), flickrPhoto.getSecret(), Size.z));
        }
        return urls;
    }

    public static ArrayList<String> googlePhotosToUrls(List<GooglePhoto> photos) {
        ArrayList<String> urls = new ArrayList<>();
        for (GooglePhoto photo : photos) {
            urls.add(String.format(Constants.Google.IMAGE_URL, photo.getPhotoReference()));
        }
        return urls;
    }

    public static String encodeAsUrl(String input) {
        try {
            return URLEncoder.encode(input, "utf8");
        } catch (UnsupportedEncodingException e) {
            return input;
        }
    }
}
