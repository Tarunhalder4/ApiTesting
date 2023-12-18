package com.example.apitesting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DataAdapter(private val context: Context, private val data:List<Image>?):RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data?.get(position)?.name ?: ""
        holder.des.text = data?.get(position)?.tag ?: ""
        Glide
            .with(context)
            .load(data?.get(position)?.imgurl)
            .centerCrop()
            .placeholder(R.drawable.ic_android_black_24dp)
            .into(holder.image)
    }


    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val image:ImageView = view.findViewById(R.id.iamge)
        val title:TextView = view.findViewById(R.id.title)
        val des:TextView = view.findViewById(R.id.des)

    }
}