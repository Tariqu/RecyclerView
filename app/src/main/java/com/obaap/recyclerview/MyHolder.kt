package com.obaap.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.mikhaellopez.circularimageview.CircularImageView

class MyHolder(itemView:View?):RecyclerView.ViewHolder(itemView) {
    var ciview=itemView!!.findViewById<CircularImageView>(R.id.ciview)
    var name=itemView!!.findViewById<TextView>(R.id.name)
    var size=itemView!!.findViewById<TextView>(R.id.size)
    var delete=itemView!!.findViewById<ImageButton>(R.id.delete)
}