package com.cloudy.tennistop100
//
//import android.content.Context
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.squareup.picasso.Picasso
//
//class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    //RecyclerView details
//    fun setDetails(
//        ctx: Context?,
//        title: String?,
//        description: String?,
//        image: String?
//    ) {
//        val mTitleTv: TextView = itemView.findViewById(R.id.rTitleTv)
//        val mDetailTv: TextView = itemView.findViewById(R.id.rDescriptionTv)
//        val mImageIv: ImageView =
//            itemView.findViewById(R.id.rImageView)
//        mTitleTv.text = title
//        mDetailTv.text = description
//        Picasso.get().load(image).into(mImageIv)
//    }
//}