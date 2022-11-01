package com.miso.vyns.adapters

import com.miso.vyns.R
import com.miso.vyns.model.VynsAlbum
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Context

class AlbumItemAdapter(private val dataset: List<VynsAlbum>): RecyclerView.Adapter<AlbumItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.findViewById(R.id.id_album)
        val textViewTitulo: TextView = view.findViewById(R.id.titulo_album)
        val textViewCover: TextView = view.findViewById(R.id.cover_album)
        val textViewDesc: TextView = view.findViewById(R.id.desc_album)
        val textViewGenre: TextView = view.findViewById(R.id.genero_album)
        val textViewRC: TextView = view.findViewById(R.id.rl_album)
        val textViewDate: TextView = view.findViewById(R.id.fecha_album)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return ItemViewHolder(adapterLayout)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textViewId.text =  item.id.toString()
        holder.textViewTitulo.text =  item.name
        holder.textViewCover.text =  item.cover
        holder.textViewDesc.text =  item.description
        holder.textViewGenre.text =  item.genre
        holder.textViewRC.text =  item.recordLabel
        holder.textViewDate.text =  item.releaseDate
    }
}