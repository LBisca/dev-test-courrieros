package com.courrieros.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.courrieros.R
import com.courrieros.controller.MainController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val controller = MainController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClient.layoutManager = LinearLayoutManager(this)
        rvClient.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        val clientTotals = controller.getClientTotals(resources)
        rvClient.adapter = ClientAdapter(clientTotals, this)
    }
}


