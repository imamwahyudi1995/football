package com.imamwahyudi.kotlin.football

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter(private val context : Context, private val items : List<Item>
                          ,private val listener : (Item) -> Unit):
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))



    override fun getItemCount(): Int = items.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener,context)

    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(items: Item, listener: (Item) -> Unit, context: Context) {
            //kotlin android extensions
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)

            itemView.setOnClickListener {
                listener(items)
            }

        }

    }

}