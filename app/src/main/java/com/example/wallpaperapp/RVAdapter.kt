package com.example.wallpaperapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.databinding.ItemWallpaperBinding

class RVAdapter : RecyclerView.Adapter<RVViewHolder>() {

    private val imageList: MutableList<Hit> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val binding = ItemWallpaperBinding.inflate(LayoutInflater.from(parent.context))
        return RVViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun udpateImageList(newList : List<Hit>)
    {
        imageList.clear()
        imageList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
       holder.onBind(imageList[position].largeImageURL, imageList[position].previewURL)
    }

}

class RVViewHolder(private val binding: ItemWallpaperBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(url: String, previewUrl: String) {
        with(binding) {
            Glide.with(binding.root.context)
                .load(url)
                .thumbnail(Glide.with(binding.root.context).load(previewUrl))
                .centerCrop()
                .into(imageContainer)
        }
    }
}