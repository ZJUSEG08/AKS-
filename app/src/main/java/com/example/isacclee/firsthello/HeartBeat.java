/**
 * Created by Pro15 on 17/7/8.
 */

package com.example.isacclee.firsthello;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;
import java.lang.String;

import java.net.HttpURLConnection;
import java.io.*;

import android.app.*;
import android.app.Activity;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore.Audio;
import android.util.Log;
import android.widget.RemoteViews;


public class HeartBeat extends Thread {

    private JSONObject ToServer;

    public void HeartBeat(String email) {
        try {
            ToServer = new JSONObject();
            ToServer.put("email", email);
        }catch (JSONException e){

        }
    }

    public void CreateNotice(String title, String content){

        NotificationActivity Notice=new NotificationActivity(title,content);

    }

    public void run(){
        try{
            Connection HeartBeatConnection=new Connection("HeartBeat");
            //建立一个HttpURLConnection服务器连接

            String ToServerString=ToServer.toString();
            HeartBeatConnection.send(ToServerString);
            //向服务器发请求

            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Success")){
                    CreateNotice("一键下单成功！","您有一笔订单已下达，点击查看详情");
                }else{
                    if (result.equals("Fail")){
                        CreateNotice("一键下单失败！","本日该设备已达到购买上限，点击查看详情或修改上限");
                            //一键支付失败的推送
                    }
                }
            }
            HeartBeatConnection.drop();
            //断开连接
            this.sleep(3000);
        }catch(Exception e){

        };
    }
}
