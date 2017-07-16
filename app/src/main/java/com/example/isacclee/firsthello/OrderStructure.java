package com.example.isacclee.firsthello;

/**
 * Created by Pro15 on 17/7/9.
 */

public class OrderStructure {
    public class States{
        public String time;
        public String state;
        public States(){
            time = new String();
            state = new String();
        }
    }

    public OrderStructure()
    {
      //  statesList=new States[100];
        statesListState=new String[100];
        statesListTime=new String[100];
    }

    public String orderID;
    public String goodsID;
    public int number;
    public String state;
    public String creatingTime;
    public String sendingTime;
    public String receiver;
    public String address;
    public String supplier;
    public String expressID;
    public int numOfStates;
    //public States[] statesList;
    public String[] statesListState;
    public String[] statesListTime;

}
