package com.bala.core.kotlin.view.activity.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bala.core.kotlin.R
import com.bala.core.kotlin.domain.entity.PhotoEntity
import com.squareup.picasso.Picasso


class RecyclerViewAdapterNew(private val mList: List<PhotoEntity>) :
    RecyclerView.Adapter<RecyclerViewAdapterNew.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_list_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = mList[position].title
        Picasso.get().load(mList[position].thumbnailUrl).into(holder.imageView);
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.title)
        val imageView: ImageView = itemView.findViewById(R.id.loadImageIV)
    }
}