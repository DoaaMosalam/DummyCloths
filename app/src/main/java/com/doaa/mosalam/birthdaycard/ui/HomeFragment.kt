package com.doaa.mosalam.birthdaycard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.doaa.mosalam.birthdaycard.R
import com.doaa.mosalam.birthdaycard.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.startedBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_productsFragment)
//                findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}