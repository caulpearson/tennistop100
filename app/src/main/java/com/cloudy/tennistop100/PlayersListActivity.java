package com.cloudy.tennistop100;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayOutputStream;

public class PlayersListActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Tennis Top 100 (60 for now)");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //send Query to FirebaseDatabase
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");
    }

    //Search data
    private void firebaseSearch(String searchText){
        Query firebaseSearchQuery = mRef.orderByChild("title").startAt(searchText).endAt(searchText + '\uf8ff');


        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(
                Model.class,
        R.layout.row,
        ViewHolder.class,
        firebaseSearchQuery
                ){

            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Model model, int i) {
                viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getDescription(),model.getImage());
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {
                        //Getting data from firebase at pos clicked
                        String mTitle = getItem(position).getTitle();
                        String mDesc = getItem(position).getDescription();
                        String mImage = getItem(position).getImage();
                        String mMajors = getItem(position).getMajors();
                        String mTitles = getItem(position).getTitles();
                        String mYears = getItem(position).getYears();
                        String mCountry = getItem(position).getNationality();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), PlayerDetailActivity.class);
                        intent.putExtra("title", mTitle);
                        intent.putExtra("description", mDesc);
                        intent.putExtra("image", mImage);
                        intent.putExtra("majors", mMajors);
                        intent.putExtra("titles", mTitles);
                        intent.putExtra("years", mYears);
                        intent.putExtra("country", mCountry);

                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        //Something else maybe
                    }
                });
                return viewHolder;
            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    //Search data
    private void firebaseSort(int n){
        Query firebaseSearchQuery = mRef.orderByChild("majors");


        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(
                Model.class,
                R.layout.row,
                ViewHolder.class,
                firebaseSearchQuery
        ){

            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Model model, int i) {
                viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getDescription(),model.getImage());
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {
                        //Getting data from firebase at pos clicked
                        String mTitle = getItem(position).getTitle();
                        String mDesc = getItem(position).getDescription();
                        String mImage = getItem(position).getImage();
                        String mMajors = getItem(position).getMajors();
                        String mTitles = getItem(position).getTitles();
                        String mYears = getItem(position).getYears();
                        String mCountry = getItem(position).getNationality();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), PlayerDetailActivity.class);
                        intent.putExtra("title", mTitle);
                        intent.putExtra("description", mDesc);
                        intent.putExtra("image", mImage);
                        intent.putExtra("majors", mMajors);
                        intent.putExtra("titles", mTitles);
                        intent.putExtra("years", mYears);
                        intent.putExtra("country", mCountry);

                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        //Something else maybe
                    }
                });
                return viewHolder;
            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        onStart();
    }



    //Load data into recycler view
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(Model.class, R.layout.row, ViewHolder.class,mRef) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int i) {
                        viewHolder.setDetails(getApplicationContext(),Integer.toString(i+1)+": "+model.getTitle() , model.getDescription(),model.getImage());
                    }
                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                        viewHolder.setOnClickListener(new ViewHolder.ClickListener(){
                            @Override
                            public void onItemClick(View view, int position) {
                                //Getting data from firebase at pos clicked
                                String mTitle = getItem(position).getTitle();
                                String mDesc = getItem(position).getDescription();
                                String mImage = getItem(position).getImage();
                                String mMajors = getItem(position).getMajors();
                                String mTitles = getItem(position).getTitles();
                                String mYears = getItem(position).getYears();
                                String mCountry = getItem(position).getNationality();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), PlayerDetailActivity.class);
                                intent.putExtra("title", mTitle);
                                intent.putExtra("description", mDesc);
                                intent.putExtra("image", mImage);
                                intent.putExtra("majors", mMajors);
                                intent.putExtra("titles", mTitles);
                                intent.putExtra("years", mYears);
                                intent.putExtra("country", mCountry);

                                startActivity(intent);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu to add items to action bar
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        MenuItem settings = menu.findItem(R.id.action_settings);
        MenuItem majors = menu.findItem(R.id.action_majors);
        MenuItem reset = menu.findItem(R.id.action_reset);
        settings.setTitle("About");
        majors.setTitle("Majors");
        reset.setTitle("Reset");
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setQueryHint("Capitals Required");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                firebaseSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //filter while typing
                firebaseSearch(s);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Handle other action bar item clicks
        if(id == R.id.action_settings) {
            //TODO
            Intent intent = new Intent(this, AboutActivity.class);
            this.startActivity(intent);
            return true;
        }
        if(id == R.id.action_majors){
            firebaseSort(1);
        }
        if(id == R.id.action_reset){
            onStart();
        }
        return super.onOptionsItemSelected(item);


    }
}
