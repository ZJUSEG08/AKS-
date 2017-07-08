/**
 * Created by Pro15 on 17/7/8.
 */

import org.json.JSONObject;
import org.json.JSONException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;


public class HeartBeat extends Thread {

    private int time=0;
    private String Heart;

    public void HeartBeat(String email)
    {
        Heart = "{ \"email\" : \""+email+"\" }";
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
                //链接地址
                huc.connect();
                OutputStreamWriter writer = new OutputStreamWriter(huc.getOutputStream());
                //发送参数
                writer.write(Heart);
                //清理当前编辑器的左右缓冲区，并使缓冲区数据写入基础流
                writer.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(),"UTF-8")) ;
                String line;




                Map js;
                while ((line = br.readLine()) != null) {
                    returninfo = line;
                    js=(Map)JSONObject.fromObject(returninfo);
                    System.out.println(js.toString());
                }
                huc.connect();
                br.close();
                return returninfo;
            }catch(Exception e){

            };


        }
    }
}