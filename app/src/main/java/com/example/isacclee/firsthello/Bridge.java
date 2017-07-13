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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Bridge {
    public String Connect(final String API, final String JsonString) throws InterruptedException {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // 在这里进行 http request.网络请求相关操作
                String jsonStr = "";

                Connection makeOrderConnection = new Connection(API + "/");
                makeOrderConnection.send(JsonString);
                String AChar;

                while ((AChar = makeOrderConnection.getBr().readLine()) != null) {
                    //接受请求结果
                    jsonStr += AChar;
                }

                makeOrderConnection.drop();
                return jsonStr;
            }
        };

        FutureTask<String> networkTask = new FutureTask<>(callable);
        new Thread(networkTask).start();

        String result="";
        try {
            result = networkTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}