package com.example.parsinglocaljsonfile

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parsinglocaljsonfile.databinding.ItemRowBinding


class RVAdapter(private val images: ArrayList<Image>, val context: Context): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val title = images[position].title
        val image = images[position].url

        holder.binding.apply {
            tvTitle.text=title

            Glide.with(context)
                .load(Uri.parse(image))
                .into(imgView)
        }


    }

    override fun getItemCount() = images.size

}