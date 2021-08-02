package com.prabhakar.analysethefragmenttransactionmethods;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    private static final String TAG = FragmentB.class.getSimpleName();

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLog("onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        printLog("onCreateView");
        return inflater.inflate(R.layout.fragment_b, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        printLog("onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        printLog("onActivityCreated");
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        printLog("onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        printLog("onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        printLog("onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        printLog("onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        printLog("onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printLog("onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        printLog("onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        printLog("onDetach");
    }

    private void printLog(String message) {
        Log.d(TAG, message);
    }
}