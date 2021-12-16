package com.vidya.aplikasipengaduan

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.ScrollingTabContainerView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.my_tiket_item.*

class MyTulisAdapter (private val context: Context, private val items: ArrayList<MyTulis>):
    RecyclerView.Adapter<MyTulisAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.my_tiket_item, parent, false)
    )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    class ViewHolder(override val containerView: View):
            RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item:MyTulis) {
            txtTiketID.text=item.pelapor
            txtTiketJenis.text=item.jenis
            txtTiketKategori.text=item.kategori
            txtTiketIsi.text=item.isi
            txtTiketStatus.text=item.sta
            txtTiketKeterangan.text=item.keterangan
        }
    }

}