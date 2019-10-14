package com.example.studentportal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity


public class PortalAdapter(private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(portal: Portal) {
            itemView.tvPortalName.text = portal.name
            itemView.tvPortalUrl.text = portal.url

            itemView.setOnClickListener { openUrl(portal) }
        }
    }

    // Opens url in browser
    private fun openUrl(portal: Portal) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(portal.url))
        context.startActivity(browserIntent)
    }
}