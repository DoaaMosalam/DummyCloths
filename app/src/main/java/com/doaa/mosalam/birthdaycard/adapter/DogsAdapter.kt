package com.doaa.mosalam.birthdaycard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doaa.mosalam.birthdaycard.databinding.DogsItemBinding
import com.doaa.mosalam.birthdaycard.model.Dogs
import com.squareup.picasso.Picasso

class DogsAdapter(private val dogs: List<Dogs>) : RecyclerView.Adapter<DogsAdapter.DogsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
       val binding = DogsItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return DogsViewHolder(binding)
    }

    override fun getItemCount(): Int = dogs.size

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val dog = dogs[position]
        holder.dogs.dogName.text = dog.name
        holder.dogs.dogImage.setImageResource(dog.imageUrl)

//        Picasso.get().load(dog.imageUrl).into(holder.dogs.dogImage)
    }

    // inner class to hold the view for each dog item
    inner class DogsViewHolder (val  dogs : DogsItemBinding):RecyclerView.ViewHolder(dogs.root)
}