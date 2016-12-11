package com.envrionment.report.utils;

import android.content.Context;

import com.google.gson.Gson;

import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * Created by mac on 12/11/16.
 */

public class FileUtil {


    public static String getAssetsFile(Context context, String path)
    {
        String content = "";
        try {

            InputStream is = context.getResources().getAssets().open(path);
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            content = new String(buffer, "UTF-8");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return content;
    }

    public static <T> T gsonConver(String content, Type type)
    {
        Gson gson = new Gson();
        return gson.fromJson(content,type);
    }
}
