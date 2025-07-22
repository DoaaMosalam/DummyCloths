package com.doaa.mosalam.birthdaycard.common

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BasicActivity<MviewBinding:ViewBinding>(private val bindingInflater:(inflater :LayoutInflater) -> MviewBinding )
    :AppCompatActivity() {

        private var _binding:MviewBinding? = null
//    val binding:MviewBinding get() = _binding as MviewBinding

    val binding: MviewBinding
        get() = checkNotNull(_binding) {
            "Binding is not initialized. Make sure to call setContentView() before accessing the binding."
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null // Clear the binding reference to avoid memory leaks
    }

}
