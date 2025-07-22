package com.doaa.mosalam.birthdaycard.Products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doaa.mosalam.birthdaycard.Repo.ProductRepo
import com.doaa.mosalam.birthdaycard.Repo.ProductRepoImpl
import com.doaa.mosalam.birthdaycard.model.products.ProductsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ProductViewModel: ViewModel() {
    private val repository : ProductRepo = ProductRepoImpl()

    private val _products = MutableStateFlow<List<ProductsList>>(listOf())
    val products: StateFlow<List<ProductsList>> = _products
    private val _isLoading = MutableStateFlow<Boolean>(false)

    private val _error = MutableStateFlow<String?>(null)
    val error : StateFlow<String?> = _error

    init {

        fetchProducts()
    }

    private fun fetchProducts() {
            viewModelScope.launch {
                try {
                    val response = repository.getAllProducts()
                    _products.value = response.products!!
                } catch (e: Exception) {
                    _error.value = "Error: ${e.message}"
                }
            }
    }
}