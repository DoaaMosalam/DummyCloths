package com.doaa.mosalam.birthdaycard.ui.Products

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.doaa.mosalam.birthdaycard.R
import com.doaa.mosalam.birthdaycard.common.BaseFragment
import com.doaa.mosalam.birthdaycard.databinding.FragmentProductsBinding
import com.doaa.mosalam.birthdaycard.ui.Products.viewmodel.ProductsViewModel
import com.doaa.mosalam.birthdaycard.ui.Products.viewmodel.SearchViewModel
import com.doaa.mosalam.birthdaycard.ui.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding, ProductsViewModel>() {
    override fun getLayoutResID(): Int = R.layout.fragment_products

    override val viewModel: ProductsViewModel by viewModels()

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var adapter: ProductsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.products.collectLatest { productList ->
                productList?.let {
                    adapter = ProductsAdapter(productList)
                    binding.recyclerViewProducts.adapter = adapter
                }
//                adapter.submitList(productList)
            }
        }

        lifecycleScope.launch {

            viewModel.error.collectLatest { errorMsg ->
                errorMsg?.let {
//                    Toast.makeText(this@ProductsActivity, it, Toast.LENGTH_SHORT).show()
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
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

                if (!results.isNullOrEmpty()) {
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
//                    Toast.makeText(this@ProductsActivity, it, Toast.LENGTH_SHORT).show()
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



