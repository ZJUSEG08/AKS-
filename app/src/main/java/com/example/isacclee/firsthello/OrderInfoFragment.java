package com.example.isacclee.firsthello;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OrderInfoFragment extends Fragment {


    public OrderInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_info, container, false);
        TextView name = (TextView) view.findViewById(R.id.textView15);
        TextView price = (TextView) view.findViewById(R.id.textView16);
        TextView orderInfo = (TextView) view.findViewById(R.id.order_info);
        TextView expressState = (TextView) view.findViewById(R.id.express_state);
        TextView expressID = (TextView) view.findViewById(R.id.expressid);
        //getArgument获取传递过来的Bundle对象
        name.setText(getArguments().getString("name"));
        orderInfo.setText(getArguments().getString("OrderInfo"));
        price.setText(getArguments().getString("price"));
        expressID.setText(getArguments().getString("ExpressID"));
        expressState.setText(getArguments().getString("ExpressState"));
        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
