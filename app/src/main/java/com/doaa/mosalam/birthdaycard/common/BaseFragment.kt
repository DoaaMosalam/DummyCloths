package com.doaa.mosalam.birthdaycard.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel


abstract class BaseFragment<DB : ViewDataBinding, VM : ViewModel> : Fragment() {
//    val progressDialog by lazy { ProgressDialog.createProgressDialog(requireActivity()) }

    protected abstract val viewModel: VM

    protected var _binding: DB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutResID(), container, false)
        return binding.root
    }

    /**
     * Get layout resource id which inflate in onCreateView.
     */
    @LayoutRes
    abstract fun getLayoutResID(): Int
//    abstract fun setUpInitView()

}
//abstract class BaseFragment<DB : ViewBinding, VM : ViewModel> : Fragment() {
//
//    protected abstract val viewModel: VM
//
//    private var _binding: DB? = null
//    protected val binding get() = _binding!!
//
//    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): DB
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = getViewBinding(inflater, container)
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}

