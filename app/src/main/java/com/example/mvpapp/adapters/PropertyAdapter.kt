package com.example.mvpapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpapp.databinding.PropertyItemBinding
import com.example.mvpapp.databinding.SectionListItemBinding
import com.example.mvpapp.models.Property
import com.google.gson.Gson

class PropertyAdapter : ListAdapter<Property, RecyclerView.ViewHolder>(NEWS_COMPARATOR) {
    private val VIEW_ITEM = 1
    private val VIEW_HEADER = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        lateinit var vh: RecyclerView.ViewHolder
        if (viewType == VIEW_ITEM) {
            val binding =
                PropertyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            vh = MessageViewHolder(binding)
        } else {
            val binding =
                SectionListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            vh = HeaderViewHolder(binding)
        }

        return vh
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null && currentItem.type !=0) {
            (holder as MessageViewHolder).bind(currentItem)
        } else {
            (holder as HeaderViewHolder).bind(currentItem!!)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position)!!.type == 0) VIEW_HEADER else VIEW_ITEM
    }


    class HeaderViewHolder(private val binding: SectionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(property: Property) {
            binding.titleSection.text = property.name
        }
    }

    class MessageViewHolder(private val binding: PropertyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(property: Property) {
            binding.apply {

                binding.name.text = property.name
                itemView.setOnClickListener{

                }
            }
        }
    }

    companion object {
        private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<Property>() {
            override fun areItemsTheSame(oldItem: Property, newItem: Property) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Property, newItem: Property) =
                oldItem == newItem
        }
    }

}