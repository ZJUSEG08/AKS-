package com.example.isacclee.firsthello;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by Pro15 on 17/7/9.
 * Some methods
 */

public class Controller {

    public int SignUp(String email,String password,String phone) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServer.put("password", password);
            ToServer.put("phone", phone);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("SignUp",ToServerString);
            JSONObject fromServer=new JSONObject(line);
            String result=fromServer.getString("result");
            if (result.equals("Y")){
                answer=1;
            }else{
                answer=0;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public int ForgetPassword(String email) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("ForgetPassword",ToServerString);
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public int SignIn(String email,String password) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServer.put("password", password);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("SignIn",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public int EditInfo(String email,String password,String phone) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServer.put("password", password);
            ToServer.put("phone", phone);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("EditInfo",ToServerString);
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public int CheckDevice(String email,String aksID) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServer.put("aksID", aksID);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("CheckDevice",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String state=fromServer.getString("state");
                if (state.equals("New")){
                    answer=-1;
                }else{
                    if (state.equals("Yes")){
                        answer=1;
                    }else{
                        answer=0;
                    }
                }

            }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public void GetDevice(DeviceStructure Device) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        try {
            ToServer.put("aksID", Device.aksID);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("GetDevice",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                Device.goodsID=fromServer.getString("goodsID");
                Device.number=fromServer.getInt("number");
                Device.receiverName=fromServer.getString("receiverName");
                Device.address=fromServer.getString("address");
                Device.postCode=fromServer.getString("postCode");
                Device.phone=fromServer.getString("phone");
                Device.orderLimit=fromServer.getInt("orderLimit");


        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int UpdateDevice(DeviceStructure Device) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("aksID", Device.aksID);
            ToServer.put("goodsID", Device.goodsID);
            ToServer.put("number", Device.number);
            ToServer.put("receiverName", Device.receiverName);
            ToServer.put("address", Device.address);
            ToServer.put("postCode", Device.postCode);
            ToServer.put("phone", Device.phone);
            ToServer.put("orderLimit", Device.orderLimit);

            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("UpdateDevice",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }

        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public int ResetDevice(String aksID) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("aksID", aksID);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("ResetDevice",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }

        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public int OrderList(String email, OrderStructure[] result) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("OrderList",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                JSONArray orderList=fromServer.getJSONArray("orderList");
                answer=orderList.length();
                for (int i=0;i<answer;i++)
                {
                    JSONObject order=orderList.getJSONObject(i);
                    result[i].orderID=order.getString("orderID");
                    result[i].goodsID=order.getString("goodsID");
                    result[i].number=order.getInt("number");
                    result[i].state=order.getString("state");
                }

            //断开连接*/
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    public void OrderInfo(OrderStructure order) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        try {
            ToServer.put("orderID", order.orderID);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
            String line=new Bridge().Connect("OrderInfo",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                order.goodsID=fromServer.getString("goodsID");
                order.number=fromServer.getInt("number");
                order.creatingTime=fromServer.getString("creatingTime");
                order.sendingTime=fromServer.getString("sendingTime");
                order.receiver=fromServer.getString("receiver");
                order.address=fromServer.getString("address");
                order.supplier=fromServer.getString("supplier");
                order.expressID=fromServer.getString("expressID");

                JSONArray statesList=fromServer.getJSONArray("statesList");
                order.numOfStates=statesList.length();
                for (int i=0;i<order.numOfStates;i++)
                {
                    JSONObject state=statesList.getJSONObject(i);
                    order.statesList[i].time=state.getString("time");
                    order.statesList[i].state=state.getString("state");
                }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //获取商品列表
    public int GoodsList(ArrayList<String> result, Context mContext) {
        int answer=0;

        try{
            String line=new Bridge().Connect("GoodsList","");
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                JSONArray goodsList=fromServer.getJSONArray("goodsList");
                answer=goodsList.length();
                for (int i=0;i<answer;i++)
                {
                    JSONObject goods=goodsList.getJSONObject(i);
                    result.add(goods.getString("goodsID"));
                }

            //与现有的goodsList进行比较
            FileCacheUtil fileCacheUtil = new FileCacheUtil();
            ArrayList<String> cacheFile = new ArrayList<>();
            if(!fileCacheUtil.cacheIsOutDate(mContext,FileCacheUtil.docCache)){
                //如果缓存中数据存在而且没有过期，获取并解析JSON生成对象
                String Cache = fileCacheUtil.getCache(mContext,FileCacheUtil.docCache);
                Toast.makeText(mContext, Cache, Toast.LENGTH_SHORT).show();
                JSONObject goodsObjectInCache = new JSONObject(Cache);
                JSONArray goodsListInCache = goodsObjectInCache.getJSONArray("goodsList");
                for (int i = 0; i< goodsListInCache.length(); i++){
                    JSONObject goodsInCache = goodsListInCache.getJSONObject(i);
                    cacheFile.add(goodsInCache.getString("goodsID"));
                }

                //比较result与cacheFile，结果放到GoodsStructure
                GoodsStructure.clearGoodsList();
                for (String itemInResult: result) {
                    if(!cacheFile.contains(itemInResult)){
                        GoodsStructure.addGoodsList(itemInResult);
                    }
                }
            }else{
                //数据过期，清空重新写入
                GoodsStructure.clearGoodsList();
                for (String itemInResult: result) {
                    GoodsStructure.addGoodsList(itemInResult);
                }
            }

            //设置缓存
            JSONArray newCache = new JSONArray();
            for (String newItem:GoodsStructure.getGoodsList()){
                JSONObject json = new JSONObject();
                json.put("goodsID",newItem);
                newCache.put(json);
            }
            FileCacheUtil.setCache(newCache.toString(),
                    mContext,
                    FileCacheUtil.docCache,
                    MODE_PRIVATE);
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    //获取商品信息
    public void GoodsInfo(GoodsStructure[] goods, Context mContext) {
        String ToServerString;
        FileCacheUtil fileCacheUtil = new FileCacheUtil();

        //读取缓存
        //前面设置缓存的时候写入的就是JSON字符串，
        //这里读取的时候应该就不用再转换了
        ToServerString = fileCacheUtil.getCache(mContext,FileCacheUtil.docCache);

        try{
            String line=new Bridge().Connect("GoodsInfo",ToServerString);
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                JSONArray goodsList = fromServer.getJSONArray("goodList");
                for (int i = 0; i < goodsList.length(); i++){
                    JSONObject oneGoods=goodsList.getJSONObject(i);
                    goods[i].setGoodsID(oneGoods.getString("goodsID"));
                    goods[i].setGoodsName(oneGoods.getString("name"));
                    goods[i].setDescription(oneGoods.getString("description"));
                    goods[i].setPrice(oneGoods.getDouble("price"));
                    goods[i].setPicture(oneGoods.getString("picture"));
                }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
