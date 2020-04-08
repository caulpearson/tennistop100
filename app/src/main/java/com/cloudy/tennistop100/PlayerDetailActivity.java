package com.cloudy.tennistop100;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayerDetailActivity extends AppCompatActivity {

    TextView mTitleTv, mDetailTv, mMajorTv, mTitlesTv;
    ImageView mImageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        //title
        actionBar.setTitle("Player Details");
        //set back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mTitleTv = findViewById(R.id.titleTv);
        mDetailTv = findViewById(R.id.descriptionTv);
        mImageIv = findViewById(R.id.imageView);
        mMajorTv = findViewById(R.id.majorsTv);
        mTitlesTv = findViewById(R.id.titlesTv);


        String image = getIntent().getStringExtra("image");
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");
        String majors = getIntent().getStringExtra("majors");
        String titles = getIntent().getStringExtra("titles");

        //setting to views
        mTitleTv.setText(title);
        mDetailTv.setText(desc);
        Picasso.get().load(image).into(mImageIv);
        mMajorTv.setText("Majors Won: "+ majors);
        mTitlesTv.setText("Titles Won: "+ titles);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
