package com.doaa.mosalam.birthdaycard.ui.Products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doaa.mosalam.birthdaycard.domain.Repo.SearchProductRepo
import com.doaa.mosalam.birthdaycard.domain.model.products.ProductsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepo: SearchProductRepo
): ViewModel(){
//    private val searchRepo: ProductSearchRepo = SearchProductRepoImpl()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _searchResults = MutableStateFlow<List<ProductsList?>?>(emptyList())
    val searchResults: StateFlow<List<ProductsList?>?> = _searchResults

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