package com.doaa.mosalam.birthdaycard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doaa.mosalam.birthdaycard.databinding.ProductsItemBinding
import com.doaa.mosalam.birthdaycard.domain.model.products.ProductsList
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products: List<ProductsList?>?) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsViewHolder {
        val binding =
            ProductsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductsViewHolder,
        position: Int
    ) {
        val currentProducts = products?.get(position)
        with(holder.product) {
            productName.text = currentProducts?.title
            productDescription.text = currentProducts?.description
            productPrice.text = "${currentProducts?.price}$"
            Picasso.get()
                .load(currentProducts?.thumbnail)
                .into(productImage)

        }


    }

    override fun getItemCount(): Int = products?.size ?: 0


    // inner class to hold the view for each product item
    inner class ProductsViewHolder(val product: ProductsItemBinding) :
        RecyclerView.ViewHolder(product.root)
}