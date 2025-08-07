package com.doaa.mosalam.birthdaycard.ui.setting.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doaa.mosalam.birthdaycard.util.LocaleManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(

): ViewModel()  {

    private val _language = MutableStateFlow("en")
    val language: StateFlow<String> = _language


    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode

    private val _isLoggedOut = MutableStateFlow(false)
    val isLoggedOut: StateFlow<Boolean> = _isLoggedOut


    fun changeLanguage(context: android.content.Context, lang: String) {
        viewModelScope.launch {
           LocaleManager.setLocale(context, lang)
            _language.emit(lang)
        }
    }


    fun toggleTheme(isDark: Boolean) {
        viewModelScope.launch {
            _isDarkMode.emit(isDark)
        }
    }

    fun logout() {
        viewModelScope.launch {

            _isLoggedOut.emit(true)
        }
    }
}

