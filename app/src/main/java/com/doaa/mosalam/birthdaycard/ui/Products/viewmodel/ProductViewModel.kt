package com.doaa.mosalam.birthdaycard.ui.Products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doaa.mosalam.birthdaycard.domain.Repo.ProductRepo
import com.doaa.mosalam.birthdaycard.domain.model.products.ProductsList
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepo
): ViewModel() {
    private val _products = MutableStateFlow<List<ProductsList?>?>(null)
    val products: StateFlow<List<ProductsList?>?> = _products
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
                    _products.emit(response.products)
                } catch (e: Exception) {
                    _error.value = "Error: ${e.message}"
                }
            }
    }
}