package com.example.apitesting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter constructor(private val context: Context, private val posts:List<Post>)
    :RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post,parent,false )
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return posts.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = posts[position].id.toString()
        holder.userID.text = posts[position].userId.toString()
        holder.title.text = posts[position].title
        holder.body.text = posts[position].body
    }
     inner class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
         val id: TextView = item.findViewById(R.id.id)
         val userID : TextView= item.findViewById(R.id.user_id)
         val title : TextView= item.findViewById(R.id.title)
         val body: TextView = item.findViewById(R.id.body)
    }

}