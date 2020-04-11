package com.cloudy.tennistop100;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class PlayerDetailActivity extends AppCompatActivity {

    TextView mTitleTv, mDetailTv, mMajorTv, mTitlesTv, mYearsTv, mCountryTv,
            mTitleTv2, mDetailTv2, mMajorTv2, mTitlesTv2,mYearsTv2, mCountryTv2;
    ImageView mImageIv;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    CardView mCardView2;

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
        mYearsTv = findViewById(R.id.yearsTv);
        mCountryTv = findViewById(R.id.countryTv);
        mTitlesTv = findViewById(R.id.titlesTv);

        mTitleTv2 = findViewById(R.id.titleTv2);
//        mDetailTv2 = findViewById(R.id.descriptionTv2);
        mMajorTv2 = findViewById(R.id.majorsTv2);
        mTitlesTv2 = findViewById(R.id.titlesTv2);
        mYearsTv2 = findViewById(R.id.yearsTv2);
        mCountryTv2 = findViewById(R.id.countryTv2);

        mCardView2 = findViewById(R.id.cardView2);

        final String image = getIntent().getStringExtra("image");
        final String title = getIntent().getStringExtra("title");
        final String desc = getIntent().getStringExtra("description");
        final String majors = getIntent().getStringExtra("majors");
        final String titles = getIntent().getStringExtra("titles");
        final String years = getIntent().getStringExtra("years");
        final String country = getIntent().getStringExtra("country");

        //setting to views
        mTitleTv.setText(title);
        mDetailTv.setText(desc);
        Picasso.get().load(image).into(mImageIv);
        mMajorTv.setText("Majors Won: "+ majors);
        mTitlesTv.setText("Titles Won: "+ titles);
        mYearsTv.setText("Years Played: "+ years);
        mCountryTv.setText("Country: "+ country);



        //Recycler View
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //send Query to FirebaseDatabase
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");


        Button button = findViewById(R.id.compareButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mCardView2.setVisibility(View.GONE);
            }
        });
    }

    //Load data into recycler view
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, miniViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, miniViewHolder>(Model.class, R.layout.mini_row, miniViewHolder.class,mRef) {
                    @Override
                    protected void populateViewHolder(miniViewHolder viewHolder, Model model, int i) {
                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), null, null);
                    }
                    @Override
                    public miniViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        miniViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                        viewHolder.setOnClickListener(new miniViewHolder.ClickListener(){
                            @Override
                            public void onItemClick(View view, int position) {
                                //Hiding recycler view
                                mRecyclerView.setVisibility(View.GONE);

                                String title = getItem(position).getTitle();
                                String desc = getItem(position).getDescription();
                                String majors = getItem(position).getMajors();
                                String titles = getItem(position).getTitles();
                                String years = getItem(position).getYears();
                                String country = getItem(position).getNationality();

                                //setting to views
                                mTitleTv2.setText(title);
//                                mDetailTv2.setText(desc);
                                mMajorTv2.setText("Majors Won: "+ majors);
                                mTitlesTv2.setText("Titles Won: "+ titles);
                                mYearsTv2.setText("Years Played: "+ years);
                                mCountryTv2.setText("Country: "+ country);


                                //showing 2nd card
                                mCardView2.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {
                                //Something else maybe
                            }
                        });
                        return viewHolder;
                    }


                };

        //Set adapter to recyclerview
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
