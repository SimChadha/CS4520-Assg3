package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.HomeLayoutBinding

class HomeFragment: Fragment(R.layout.home_layout) {
    private var _binding: HomeLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


}