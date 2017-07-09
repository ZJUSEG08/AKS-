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


public class HeartBeat extends Thread {

    private int time=0;
    private JSONObject ToServer;

    public void HeartBeat(String email) {
        try {
            ToServer = new JSONObject();
            ToServer.put("email", email);
        }catch (JSONException e){

        }
    }

    public void run(){
        time++;
        if (time>=3000) {
            time-=3000;

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

                    }else{
                        if (result.equals("Fail")){

                        }
                    }
                }

                HeartBeatConnection.drop();
                //断开连接*/


            }catch(Exception e){

            };


        }
    }
}