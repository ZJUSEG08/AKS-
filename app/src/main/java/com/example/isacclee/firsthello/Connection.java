package com.example.isacclee.firsthello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.String;

/**
 * Created by Pro15 on 17/7/9.
 */

public class Connection {

    public String target="http://123.207.218.103/AKS+/";

    public HttpURLConnection huc;
    public OutputStreamWriter writer;
    public BufferedReader br;

    public Connection(String API){
        try {
            URL httpUrl = new URL(target+API);
            huc = (HttpURLConnection) httpUrl.openConnection();
            huc.setRequestMethod("POST");
            huc.setDoInput(true);
            huc.setDoOutput(true);
            huc.setRequestProperty("Content-Type", "application/json");
            huc.connect();
            writer = new OutputStreamWriter(huc.getOutputStream());
        }catch(Exception e){

        }
    }

    public void drop() {
        try {
            huc.connect();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String JsonString){
        try{
            writer.write(JsonString);
            writer.flush();
            br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "UTF-8"));
        }catch(Exception e) {

        }
    }

    BufferedReader getBr(){
        return br;
    }
}
