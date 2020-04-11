package com.cloudy.tennistop100;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerCompareListActivity extends AppCompatActivity {
//    String image = "";
//    String title = "";
//    String desc = "";
//    String majors = "";
//    String titles = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        //title
        actionBar.setTitle("Choose Comparison Player");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_compare_list);
        Intent intent = getIntent();
//        image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
//        desc = getIntent().getStringExtra("description");
//        majors = getIntent().getStringExtra("majors");
//        titles = getIntent().getStringExtra("titles");

    }

    @Override
    public void finish() {
        Intent intent = new Intent(this, PlayerDetailActivity.class);
//        intent.putExtra("name", title);
//        intent.putExtra("description", desc);
//        intent.putExtra("majors", majors);
//        intent.putExtra("titles", titles);
//        intent.putExtra("image", image);
        intent.putExtra("result", "finished");
        setResult(RESULT_OK, intent);
        super.finish();
    }

//    @Override
//    public void onBackPressed() {
//        Intent intent = new Intent(this, PlayerDetailActivity.class);
//        intent.putExtra(")
//        super.onBackPressed();
//    }
}
