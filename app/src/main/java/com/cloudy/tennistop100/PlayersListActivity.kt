package com.cloudy.tennistop100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_players_list.*

//class PlayersListActivity : AppCompatActivity() {
//
//    var mRecyclerView: RecyclerView? = null
//    var mFirebaseDatabase: FirebaseDatabase? = null
//    var mRef: DatabaseReference? = null
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_players_list)
//
//        //actionbar
//        val actionBar: ActionBar? = supportActionBar
//        //set title
//        if (actionBar != null) {
//            actionBar.setTitle("Posts List")
//        }
//        mRecyclerView = findViewById(R.id.recyclerView)
////        mRecyclerView.setHasFixedSize(true)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        mFirebaseDatabase = FirebaseDatabase.getInstance()
//        //!! is not null asserted call
//        mRef = mFirebaseDatabase!!.getReference("Data")
//
//
//    }
//
//    override fun onStart() {
//        super.onStart()
//
//
//        val adapter = object : FirebaseRecyclerAdapter<Model, ViewHolder>(Model::class.java, R.layout.row, ViewHolder::class.java, mRef){
//            public override fun populateViewHolder(p0: ViewHolder?, p1: Model?, p2: Int) {
//                if (p1 != null) {
//                    if (p0 != null) {
//                        p0.setDetails(applicationContext, p1.getTitle(), p1.getDescription(), p1.getImage())
//                    }
//                }
//            }
//        }
//    }
//
//
//}
