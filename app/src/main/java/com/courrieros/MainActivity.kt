package com.courrieros

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.courrieros.model.ClientOrder
import com.courrieros.model.ClientTotals
import com.courrieros.reader.CsvReader
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_client_list.layoutManager = LinearLayoutManager(this)
        rv_client_list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        val list: List<ClientOrder> = CsvReader().readInputIntoList(resources.openRawResource(R.raw.client_orders))
        val grouped: Map<String, List<ClientOrder>> = list.groupBy { it.clientName }
        val listaSomada = grouped.entries.map {
            val name = it.key
            val totalSaved = it.value.sumByDouble { it.co2Saved }
            ClientTotals(name, totalSaved)
        }

        rv_client_list.adapter = ClientAdapter(listaSomada, this)

    }


}


