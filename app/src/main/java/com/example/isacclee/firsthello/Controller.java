package com.example.isacclee.firsthello;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
            String line = new Bridge().Connect("SignUp",ToServerString);

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

    public int EditInfo(String email,String oPassword,String nPassword,String phone) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServer.put("oPassword", oPassword);
            ToServer.put("nPassword", nPassword);
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
//askid - > deviceId ,email->username
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

    //aksId -> data
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

    //修改
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

    //解除绑定
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

    public int OrderList(String email, ArrayList<OrderStructure> result) {

        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        int answer=0;
        try {
            ToServer.put("email", email);
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
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
                    OrderStructure ans=new OrderStructure();
                    ans.orderID=order.getString("orderID");
                    ans.goodsID=order.getString("goodsID");
                    ans.number=order.getInt("number");
                    ans.state=order.getString("state");
                    result.add(ans);
                }
            return answer;
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

    /**
     * 获取商品列表，新的商品ID将用于获取商品信息
     * @param mContext 上下文环境，这里一般来说就是调用方法的环境，this即可
     */
    private void GoodsList(final Context mContext)  throws InterruptedException {
        /*
         * 网络操作相关的子线程
         */

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                    try {
                        ArrayList<String> result = new ArrayList<>();

                        Connection HeartBeatConnection = new Connection("GoodsList/");
                        HeartBeatConnection.send("");

                        //接受请求结果
                        String line;
                        String jsonStr = "";
                        while ((line = HeartBeatConnection.getBr().readLine()) != null) {
                            //接受请求结果
                            jsonStr += line;
                        }

                        JSONObject fromServer = new JSONObject(jsonStr);
                        JSONArray goodsList = fromServer.getJSONArray("goodsList");
                        int answer = goodsList.length();
                        for (int i = 0; i < answer; i++) {
                            JSONObject goods = goodsList.getJSONObject(i);
                            result.add(goods.getString("goodsID"));
                        }
                        HeartBeatConnection.drop();
                        //断开连接*/

                        //与现有的goodsList进行比较
                        ArrayList<String> cacheFile = new ArrayList<>();
                        GoodsStructure goodsStructure = new GoodsStructure();
                        goodsStructure.setGoodsList(new ArrayList<String>());
                        if (!FileCacheUtil.cacheIsOutDate(mContext, FileCacheUtil.docCache)) {
                            //如果缓存中数据存在而且没有过期，获取并解析JSON生成对象
                            String Cache = FileCacheUtil.getCache(mContext, FileCacheUtil.docCache);
                            JSONObject goodsObjectInCache = new JSONObject(Cache);
                            JSONArray goodsListInCache = goodsObjectInCache.getJSONArray("goodsList");
                            for (int i = 0; i < goodsListInCache.length(); i++) {
                                JSONObject goodsInCache = goodsListInCache.getJSONObject(i);
                                cacheFile.add(goodsInCache.getString("goodsID"));
                            }

                            //比较result与cacheFile，结果放到GoodsStructure
                            goodsStructure.setGoodsList(new ArrayList<String>());
                            for (String itemInResult : result) {
                                if (!cacheFile.contains(itemInResult)) {
                                    goodsStructure.addGoodsList(itemInResult);
                                }
                            }
                        } else {
                            //数据过期，清空重新写入
                            if(!goodsStructure.isEmptyGoodsList()){
                                goodsStructure.setGoodsList(new ArrayList<String>());
                            }
                            for (String itemInResult : result) {
                                goodsStructure.addGoodsList(itemInResult);
                            }
                        }

                        //设置缓存,新的商品列表
                        JSONObject newRequest  = new JSONObject();
                        JSONArray newCache = new JSONArray();
                        for (String newItem : goodsStructure.getGoodsList()) {
                            JSONObject json = new JSONObject();
                            json.put("goodsID", newItem);
                            newCache.put(json);
                        }
                        newRequest.put("goodsList", newCache);

                        //新的连接，
                        Connection GoodsInfo = new Connection("GoodsInfo/");
                        GoodsInfo.send(newRequest.toString());
                        jsonStr = "";
                        while ((line = GoodsInfo.getBr().readLine()) != null) {
                            //接受请求结果
                            jsonStr += line;
                        }

                        //将商品信息保存在本地
                        FileCacheUtil.setCache(jsonStr,
                                mContext,
                                FileCacheUtil.goodsFile,
                                MODE_PRIVATE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "Y";
                }
            };

            FutureTask<String> networkTask = new FutureTask<>(callable);
            new Thread(networkTask).start();

            try {
                networkTask.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
    }

    /**
     * 获取指定ID商品信息
     * @param mContext 上下文环境，这里一般来说就是调用方法的环境，this即可
     * @param goodsID 物品ID，用于搜索
     * @return 返回值是GoodStructure结构的result
     */
    public GoodsStructure GoodsInfo(Context mContext, String goodsID) {
        //从缓存中获取商品信息
        if (FileCacheUtil.cacheIsOutDate(mContext, FileCacheUtil.goodsFile)) {
            try {
                GoodsList(mContext);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String fileCache = FileCacheUtil.getCache(mContext, FileCacheUtil.goodsFile);
        GoodsStructure result = new GoodsStructure();
        try {
            JSONObject goodsObjectInCache = new JSONObject(fileCache);
            /*
            * data={goodsList : [{goodsID : string ,
                                  name : string ,
                                  description : string ,
                                  price : float ,
                                  picture : url}]
                   }
            **/
            JSONArray goodsListInCache = goodsObjectInCache.getJSONArray("goodsList");
            int i;
            for (i = 0; i < goodsListInCache.length(); i++) {
                JSONObject goodsInCache = goodsListInCache.getJSONObject(i);
                if (goodsInCache.getString("goodsID").equals(goodsID)){
                    result.setGoodsID(goodsInCache.getString("goodsID"));
                    result.setGoodsName(goodsInCache.getString("name"));
                    result.setDescription(goodsInCache.getString("description"));
                    result.setPrice(goodsInCache.getDouble("price"));
                    result.setPicture(goodsInCache.getString("picture"));
                    break;
                }
            }
            if(i == goodsListInCache.length()){
                if (i==0){
                    result.setGoodsName("No goods in Cache");
                }else {
                    result.setGoodsName("Not found in Cache");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取缓存中所有的商品信息
     * @param mContext 上下文环境
     * @return 返回值是ArrayList<GoodsStructure>结构的result
     */
 ArrayList<GoodsStructure> GoodsInfo(Context mContext) {
        //从缓存中获取商品信息
        if (FileCacheUtil.cacheIsOutDate(mContext, FileCacheUtil.goodsFile)) {
            try {
                GoodsList(mContext);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String fileCache = FileCacheUtil.getCache(mContext, FileCacheUtil.goodsFile);
        ArrayList<GoodsStructure> result = new ArrayList<>();

        try {
            JSONObject goodsObjectInCache = new JSONObject(fileCache);
            /*
            * data={goodsList : [{goodsID : string ,
                                  name : string ,
                                  description : string ,
                                  price : float ,
                                  picture : url}]
                   }
            **/
            JSONArray goodsListInCache = goodsObjectInCache.getJSONArray("goodsList");
            int i;
            for (i = 0; i < goodsListInCache.length(); i++) {
                JSONObject goodsInCache = goodsListInCache.getJSONObject(i);

                GoodsStructure item = new GoodsStructure();
                item.setGoodsID(goodsInCache.getString("goodsID"));
                item.setGoodsName(goodsInCache.getString("name"));
                item.setDescription(goodsInCache.getString("description"));
                item.setPrice(goodsInCache.getDouble("price"));
                item.setPicture(goodsInCache.getString("picture"));

                result.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
