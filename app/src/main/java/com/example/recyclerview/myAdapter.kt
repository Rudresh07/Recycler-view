package com.example.recyclerview

import android.app.Activity
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class myAdapter(var newsArrayList: ArrayList<news>, var context : Activity) :
RecyclerView.Adapter<myAdapter.MyViewHolder>(){

    //to create new views instance if layout manager fails to provide view
    //we will create a layout inflater todo so


    private lateinit var mylistener:onItemClickListener
    interface onItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener:onItemClickListener){

        mylistener = listener

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_design,parent,false)
        return MyViewHolder(itemView,mylistener)
    }

    //populate items with data
    override fun onBindViewHolder(holder: myAdapter.MyViewHolder, position: Int) {

        var currentitem = newsArrayList[position]
        holder.hTitle.text = currentitem.newsHeading
        holder.hImage.setImageResource(currentitem.newsImage)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size//return no. of item present
    }

    //it holds view so that views aren't created every time, so that memory can be saved

    class MyViewHolder(itemView: View,listener:onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val hTitle = itemView.findViewById<TextView>(R.id.HeadingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.NewsImage)


        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}