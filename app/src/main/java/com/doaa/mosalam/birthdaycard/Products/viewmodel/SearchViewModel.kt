package com.doaa.mosalam.birthdaycard.Products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doaa.mosalam.birthdaycard.Repo.ProductRepo
import com.doaa.mosalam.birthdaycard.Repo.ProductRepoImpl
import com.doaa.mosalam.birthdaycard.Repo.ProductSearchRepo
import com.doaa.mosalam.birthdaycard.Repo.SearchProductRepoImpl
import com.doaa.mosalam.birthdaycard.model.products.ProductsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
// private val searchRepo: ProductSearchRepo = SearchProductRepoImpl()

): ViewModel(){
    private val searchRepo: ProductSearchRepo = SearchProductRepoImpl()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _searchResults = MutableStateFlow<List<ProductsList>>(emptyList())
    val searchResults: StateFlow<List<ProductsList>> = _searchResults

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun setSearchQuery(query:String){
        _searchQuery.value = query
    }

    fun searchProducts(){
      viewModelScope.launch {
          _isLoading.value = true
          _error.value = null
          try {
              val response = searchRepo.searchProducts(_searchQuery.value)
              _searchResults.value = response.products ?: emptyList()
          } catch (e: Exception) {
              _error.value = e.localizedMessage ?: "An error occurred"
          } finally {
              _isLoading.value = false
          }
      }
    }

    fun clearSearchQuery() {
        _searchQuery.value = ""
    }

}