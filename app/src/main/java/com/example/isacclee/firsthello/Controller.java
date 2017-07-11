package com.example.isacclee.firsthello;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            Connection HeartBeatConnection=new Connection("SignUp");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
            }
            HeartBeatConnection.drop();
            //断开连接*/
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
            Connection HeartBeatConnection=new Connection("ForgetPassword");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
            }
            HeartBeatConnection.drop();
            //断开连接*/
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
            Connection HeartBeatConnection=new Connection("SignIn");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
            }
            HeartBeatConnection.drop();
            //断开连接*/
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
            Connection HeartBeatConnection=new Connection("EditInfo");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
            }
            HeartBeatConnection.drop();
            //断开连接*/
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
            Connection HeartBeatConnection=new Connection("CheckDevice");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
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
            }
            HeartBeatConnection.drop();
            //断开连接*/
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
            Connection HeartBeatConnection=new Connection("GetDevice");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                Device.goodsID=fromServer.getString("goodsID");
                Device.number=fromServer.getInt("number");
                Device.receiverName=fromServer.getString("receiverName");
                Device.address=fromServer.getString("address");
                Device.postCode=fromServer.getString("postCode");
                Device.phone=fromServer.getString("phone");
                Device.orderLimit=fromServer.getInt("orderLimit");
            }
            HeartBeatConnection.drop();
            //断开连接
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
            Connection HeartBeatConnection=new Connection("UpdateDevice");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
            }
            HeartBeatConnection.drop();
            //断开连接*/
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
            Connection HeartBeatConnection=new Connection("ResetDevice");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                String result=fromServer.getString("result");
                if (result.equals("Y")){
                    answer=1;
                }else{
                    answer=0;
                }
            }
            HeartBeatConnection.drop();
            //断开连接*/
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
            Connection HeartBeatConnection=new Connection("OrderList");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
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
            }
            HeartBeatConnection.drop();
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
            Connection HeartBeatConnection=new Connection("OrderInfo");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
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
            }
            HeartBeatConnection.drop();
            //断开连接*/
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //获取商品列表
    public int GoodsList(GoodsStructure[] result, Context mContext) {
        int answer=0;

        try{
            Connection HeartBeatConnection=new Connection("GoodsList");
            HeartBeatConnection.send("");
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
                //接受请求结果
                JSONObject fromServer=new JSONObject(line);
                JSONArray goodsList=fromServer.getJSONArray("goodsList");
                answer=goodsList.length();
                for (int i=0;i<answer;i++)
                {
                    JSONObject goods=goodsList.getJSONObject(i);
                    result[i].setGoodsID(goods.getString("goodsID"));
                }
            }
            HeartBeatConnection.drop();
            //断开连接*/

            //与现有的goodsList进行比较
            FileCacheUtil fileCacheUtil = new FileCacheUtil();
            if(!fileCacheUtil.cacheIsOutDate(mContext,FileCacheUtil.docCache)){
                Toast.makeText(mContext,
                        fileCacheUtil.getCache(mContext,FileCacheUtil.docCache),
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(mContext,
                        "setCache",
                        Toast.LENGTH_SHORT).show();
                FileCacheUtil.setCache("write now",
                        mContext,
                        FileCacheUtil.docCache,
                        MODE_PRIVATE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer;
    }

    //获取商品信息
    public void GoodsInfo(GoodsStructure[] goods) {
        String ToServerString=null;
        JSONObject ToServer = new JSONObject();
        try {
            ToServer.put("goodsList", GoodsStructure.getGoodsList());
            ToServerString = ToServer.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try{
            Connection HeartBeatConnection=new Connection("OrderInfo");
            HeartBeatConnection.send(ToServerString);
            String line;
            while ((line = HeartBeatConnection.br.readLine()) != null) {
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
            }
            HeartBeatConnection.drop();
            //断开连接*/
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
