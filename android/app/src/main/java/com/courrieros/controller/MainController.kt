package com.courrieros.controller

import android.content.res.Resources
import com.courrieros.R
import com.courrieros.model.ClientOrder
import com.courrieros.model.ClientTotals
import com.courrieros.reader.CsvReader

class MainController {

    private val reader = CsvReader()

    fun getClientTotals(resources: Resources): List<ClientTotals> {
        val list: List<ClientOrder> = getClientOrders(resources)
        val grouped: Map<String, List<ClientOrder>> = list.groupBy { it.clientName }

        return grouped.entries.map {
            val name = it.key
            val totalSaved = it.value.sumByDouble { it.co2Saved }
            ClientTotals(name, totalSaved)
        }
    }

    fun getClientOrders(resources: Resources): List<ClientOrder> {
        return reader.readInputIntoList(resources.openRawResource(R.raw.client_orders))
    }
}