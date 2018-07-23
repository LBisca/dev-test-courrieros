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

        rvClient.layoutManager = LinearLayoutManager(this)
        rvClient.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        val list: List<ClientOrder> = CsvReader().readInputIntoList(resources.openRawResource(R.raw.client_orders))
        val grouped: Map<String, List<ClientOrder>> = list.groupBy { it.clientName }
        val listaSomada = grouped.entries.map {
            val name = it.key
            val totalSaved = it.value.sumByDouble { it.co2Saved }
            ClientTotals(name, totalSaved)
        }

        rvClient.adapter = ClientAdapter(listaSomada, this)

    }
}


