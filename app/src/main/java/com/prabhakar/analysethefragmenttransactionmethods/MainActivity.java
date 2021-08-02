package com.prabhakar.analysethefragmenttransactionmethods;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addAButton, addBButton, removeAButton, removeBButton,
            ButtonReplaceAWithB_withoutBackStack, ButtonReplaceAWithB_backStack, ButtonReplaceBWithA;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        addAButton = findViewById(R.id.btnAddA);
        addBButton = findViewById(R.id.btnAddB);
        removeAButton = findViewById(R.id.btnRemoveA);
        removeBButton = findViewById(R.id.btnRemoveB);
        ButtonReplaceAWithB_withoutBackStack = findViewById(R.id.btnReplaceA_WithB_withoutBackstack);
        ButtonReplaceAWithB_backStack = findViewById(R.id.btnReplaceA_WithB_backstack);
        ButtonReplaceBWithA = findViewById(R.id.btnReplaceB_WithA);
        fragmentManager = getSupportFragmentManager();
        addAButton.setOnClickListener(this);
        addBButton.setOnClickListener(this);
        removeAButton.setOnClickListener(this);
        removeBButton.setOnClickListener(this);
        ButtonReplaceAWithB_withoutBackStack.setOnClickListener(this);
        ButtonReplaceAWithB_backStack.setOnClickListener(this);
        ButtonReplaceBWithA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceA_WithB_withoutBackstack:
                ReplaceAWithB_withoutBackStack();
                break;
            case R.id.btnReplaceA_WithB_backstack:
                ReplaceAWithB_backStack();
                break;
            case R.id.btnReplaceB_WithA:
                ReplaceBWithA();
                break;
        }
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer, fragmentA, "fragmentA").commit();
    }

    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }

    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB).commit();
        }

    }

    private void ReplaceAWithB_withoutBackStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    private void ReplaceAWithB_backStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("fragmentB_backstack").commit();
    }

    private void ReplaceBWithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer,fragmentA,"fragmentA").commit();
    }
}