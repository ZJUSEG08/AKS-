package com.example.isacclee.firsthello;

/**
 * Created by Pro15 on 17/7/13.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.String;
import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public class Bridge {

    String jsonStr;

    public String Connect(final String API, final String JsonString) {

        Runnable networkTask = new Runnable() {

            @Override
            public void run() {
                // 在这里进行 http request.网络请求相关操作

                try {
                    Connection makeOrderConnection = new Connection(API + "/");
                    makeOrderConnection.send(JsonString);
                    String AChar;
                    jsonStr = "";
                    while ((AChar = makeOrderConnection.getBr().readLine()) != null) {
                        //接受请求结果
                        jsonStr += AChar;
                    }

                    makeOrderConnection.drop();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(networkTask).start();
        return jsonStr;
    }

}