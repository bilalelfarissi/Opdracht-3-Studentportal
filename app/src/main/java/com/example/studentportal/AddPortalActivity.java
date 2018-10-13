package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddPortalActivity extends AppCompatActivity {

    /**
     * Binding
     */
    @BindView(R.id.urlEditText)
    EditText mUrlEditText;

    @BindView(R.id.titelEditText)
    EditText mTitelEditText;

    @BindView(R.id.addPortalButton)
    Button mAddPortalButton;

    /**
     * Creating variables
     */
    private String urlText;
    private String titelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        //Bind all views with the ButterKnife library which uses the annotations
        ButterKnife.bind(this);

        // This is the going back button at the top of the screen
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    /**
     * This method makes gives the class where the back button needs to "go". So when the user is
     * clicking on the back button this method "indicates" where it needs to go.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    /**
     * This method is used to make it possible to return the values that has been given by the user
     * There is an if and statement that detects whether the user has filled both fields in.
     * If he did the values would be returned to the MainActivity.
     */
    @OnClick(R.id.addPortalButton)
    public void addPortal(View view) {
        Portal portal;
        urlText = mUrlEditText.getText().toString();
        titelText = mTitelEditText.getText().toString();

        if (!TextUtils.isEmpty(urlText) && !TextUtils.isEmpty(titelText)) {
            portal = new Portal(urlText, titelText);
            //Prepare the return parameter and return
            Intent resultIntent = new Intent();
            resultIntent.putExtra(MainActivity.EXTRA_PORTAL, portal);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        } else {
            Snackbar.make(view, "Please enter some data first!", Snackbar.LENGTH_LONG);
        }
    }
}
