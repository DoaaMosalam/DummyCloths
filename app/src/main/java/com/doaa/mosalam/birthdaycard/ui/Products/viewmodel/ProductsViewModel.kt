package com.doaa.mosalam.birthdaycard.ui.Products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doaa.mosalam.domain.Repo.ProductRepo
import com.doaa.mosalam.domain.model.products.ProductsList
import com.doaa.mosalam.domain.usecase.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository : ProductsUseCase
) : ViewModel() {
    private val _products = MutableStateFlow<List<ProductsList?>?>(null)
    val products: StateFlow<List<ProductsList?>?> = _products
    private val _isLoading = MutableStateFlow<Boolean>(false)

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {

        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.emit(true)
            try {
                val response = repository.getAllProducts()
                _products.emit(response.products)
            } catch (e: Exception) {
                _error.emit("Error: ${e.message}")
            }finally {
                _isLoading.emit(false)
            }
        }
    }
}