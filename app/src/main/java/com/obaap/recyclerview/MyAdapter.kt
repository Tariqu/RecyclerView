package com.obaap.recyclerview

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.io.File
import android.widget.TextView



class MyAdapter: RecyclerView.Adapter<MyHolder> {
    var path:String?=null
    var file:File?=null
    var files:Array<File>?=null
    var inflater:LayoutInflater?=null
    var context:Context?=null
    var bid:CoordinatorLayout?=null
    constructor(mainActivity: MainActivity, bid: CoordinatorLayout){
        context=mainActivity
        path="/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
        file= File(path)
        if (!file!!.exists()){
            path="/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        }
        files=file!!.listFiles()
        inflater= LayoutInflater.from(context)
        this.bid=bid
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var v: View =inflater!!.inflate(R.layout.mycardview,parent,false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
        return files!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var f = files!!.get(position)
        var bmp=BitmapFactory.decodeFile(f.path)
        var size="${f.length()} bytes"
        holder.ciview!!.setImageBitmap(bmp)
        holder.name.text=f.name
        holder.size.text=size
        holder!!.delete.setOnClickListener {
            var sBar=Snackbar.make(bid!!,"Are you sure want to delete?",Snackbar.LENGTH_LONG)
            sBar.setAction("Yes", View.OnClickListener {
                f.delete()
                files=file!!.listFiles()
                this@MyAdapter.notifyDataSetChanged()
            })
            sBar.setActionTextColor(Color.YELLOW)
            val sbView = sBar.getView()
            val textView = sbView.findViewById(android.support.design.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.YELLOW)
            sBar.setActionTextColor(Color.RED)
            sBar.show()
        }
    }

}