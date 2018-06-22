package com.obaap.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    var rview:RecyclerView?=null
    var lManager:LayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rview=findViewById(R.id.rview)
        lManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rview!!.layoutManager=lManager
        var bid=findViewById<CoordinatorLayout>(R.id.bid)
        rview!!.adapter=MyAdapter(this,bid)


    }
}
