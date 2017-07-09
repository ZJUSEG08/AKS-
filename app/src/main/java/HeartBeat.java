/**
 * Created by Pro15 on 17/7/8.
 */

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.net.URL;
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
                URL httpUrl = new URL("http://localhost:8080"); //……/HeartBeat
                HttpURLConnection huc = (HttpURLConnection) httpUrl.openConnection();
                huc.setRequestMethod("POST");
                huc.setDoInput(true);
                huc.setDoOutput(true);
                huc.setRequestProperty("Content-Type",  "application/json");
                huc.connect();
                OutputStreamWriter writer = new OutputStreamWriter(huc.getOutputStream());
                //HttpURLConnection连接服务器


                String ToServerString=ToServer.toString();
                writer.write(ToServerString);
                writer.flush();
                //向服务器发请求


                BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(),"UTF-8")) ;
                String line;
                while ((line = br.readLine()) != null) {
                    JSONObject fromServer=new JSONObject(line);
                    String result=fromServer.getString("result");
                    if (result.equals("Success")){

                    }else{
                        if (result.equals("Fail")){

                        }
                    }
                }
                //接受返回结果，并且处理推送

                huc.connect();
                br.close();
                //断开连接


            }catch(Exception e){

            };


        }
    }
}