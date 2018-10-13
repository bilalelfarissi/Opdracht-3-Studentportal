package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements PortalAdapter.PortalClickListener {

    /**
     * Binding
     */
    @BindView(R.id.addListButton)
    FloatingActionButton addListButton;
    @BindView(R.id.portalRecyclerView)
    RecyclerView portalRecyclerView;

    /**
     * Creating adapter and array
     */
    private PortalAdapter portalAdapter;
    private ArrayList<Portal> portalArrayList;

    /**
     * Creating "Keys"
     */
    public static final String EXTRA_PORTAL = "Portal";
    public static final String URL = "URL";
    public static final int REQUESTCODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bind all views with the ButterKnife library which uses the annotations
        ButterKnife.bind(this);

        portalArrayList = new ArrayList<>();
        portalAdapter = new PortalAdapter(portalArrayList, this);
        portalRecyclerView.setAdapter(portalAdapter);
        // set 3 columns in the Recyclerview layout
        portalRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    /**
     * This method is used to get the data from AddPortalActivity by using the key "EXTRA PORTAL"
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTCODE) {
            if (resultCode == Activity.RESULT_OK) {
                Portal newPortal = data.getParcelableExtra(MainActivity.EXTRA_PORTAL);
                portalArrayList.add(newPortal);
                portalAdapter.notifyDataSetChanged();
            }
        }
    }

    /**
     * This method is used to start a new activity with his own request code.
     */
    @OnClick(R.id.addListButton)
    public void addList(){
        startActivityForResult(new Intent(this, AddPortalActivity.class), REQUESTCODE);
    }

    /**
     * This method is used to start the webviewactivity when users click on a portal in the list.
     * By giving the url the webviewactivity knows which url it needs to get open.
     */
    @Override
    public void portalOnClick(int i) {
        Intent intent = new Intent (this, WebViewActivity.class);
        intent.putExtra(MainActivity.URL, portalArrayList.get(i).getUrl());
        startActivity(intent);
    }
}
