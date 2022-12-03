package com.example.reactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.reactapp.databinding.PersonItemBinding

class NameAdapter : ListAdapter<PersonApp, NameViewHolder>(NameAdapter) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        return NameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val list = getItem(position)
        holder.bind(list)
    }

    private companion object : DiffUtil.ItemCallback<PersonApp>() {
        override fun areItemsTheSame(oldItem: PersonApp, newItem: PersonApp): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PersonApp, newItem: PersonApp): Boolean {
            return oldItem == newItem
        }
    }
}

class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: PersonItemBinding = PersonItemBinding.bind(view)

    fun bind(person: PersonApp) {
        person.apply {
            binding.tvName.text = firstName
        }
    }
}