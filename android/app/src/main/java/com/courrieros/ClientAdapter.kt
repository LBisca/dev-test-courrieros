package com.courrieros

import android.content.Context
import kotlinx.android.synthetic.main.client_list.view.*
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.courrieros.model.ClientTotals

class ClientAdapter (val items : List<ClientTotals>, val context: Context ) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.client_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvClientName.text = items[position].clientName
        holder.tvTotalSaved.text = ("%.4f".format(items[position].totalSaved))
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvClientName = view.client_name
    val tvTotalSaved = view.total_saved
}


