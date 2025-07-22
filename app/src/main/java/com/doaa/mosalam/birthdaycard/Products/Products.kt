package com.doaa.mosalam.birthdaycard.Products

import com.doaa.mosalam.birthdaycard.Products.viewmodel.SearchViewModel
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.doaa.mosalam.birthdaycard.Products.viewmodel.ProductViewModel
import com.doaa.mosalam.birthdaycard.adapter.ProductsAdapter
import com.doaa.mosalam.birthdaycard.common.BasicActivity
import com.doaa.mosalam.birthdaycard.databinding.ActivityProductsBinding
import com.doaa.mosalam.birthdaycard.model.products.ProductsList
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus


class Products : BasicActivity<ActivityProductsBinding>(ActivityProductsBinding::inflate){
//    private val viewModel: ProductViewModel by viewModels()
private val viewModel: ProductViewModel by lazy { ProductViewModel() }
    private val searchViewModel: SearchViewModel by lazy { SearchViewModel() }
    private lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.products.collectLatest { productList ->
                adapter = ProductsAdapter(productList)
                binding.recyclerViewProducts.adapter = adapter
//                adapter.submitList(productList)
            }
        }

        lifecycleScope.launch {
            viewModel.error.collectLatest { errorMsg ->
                errorMsg?.let {
                    Toast.makeText(this@Products, it, Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Search input
//        binding.searchInput.setOnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                val query = binding.searchInput.text.toString().trim()
//                if (query.isNotEmpty()) {
//                    searchViewModel.setSearchQuery(query)
//                    searchViewModel.searchProducts()
//                }
//                true
//            } else {
//                false
//            }
//        }

        binding.searchInput.doAfterTextChanged {
            val query = it.toString().trim()
            if (query.isNotEmpty()) {
                searchViewModel.setSearchQuery(query)
                searchViewModel.searchProducts()
            }
        }

        lifecycleScope.launch {
            searchViewModel.searchResults.collectLatest { results ->

                if (results.isNotEmpty()) {
                    binding.recyclerViewProducts.adapter = ProductsAdapter(results)
                }
//                else {
//                    Toast.makeText(this@Products, "No results found", Toast.LENGTH_SHORT).show()
//                }
            }
        }

        lifecycleScope.launch {
            searchViewModel.error.collectLatest { errorMsg ->
                errorMsg?.let {
                    Toast.makeText(this@Products, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}