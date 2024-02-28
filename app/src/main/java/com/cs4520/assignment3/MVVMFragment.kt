package com.cs4520.assignment3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.databinding.MvpLayoutBinding

class MVVMFragment : Fragment(R.layout.mvp_layout) {
    private var _binding: MvpLayoutBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: MVVMViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = MvpLayoutBinding.inflate(inflater, container, false)

        viewModel = MVVMViewModel()

        bindUiToModel(viewModel)

        _binding!!.numberField1.addTextChangedListener { object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                println("Inside 1")
                viewModel.setInput1(s.toString())
            }
        } }

        _binding!!.numberField2.addTextChangedListener { object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                println("Inside 1")
                viewModel.setInput2(s.toString())
            }
        } }

        observeData()

        return binding.root
    }

    private fun bindUiToModel(viewModel: MVVMViewModel) {
        _binding!!.addButton.setOnClickListener(View.OnClickListener {
            viewModel.setInput1(_binding!!.numberField1.text.toString())
            viewModel.setInput2(_binding!!.numberField2.text.toString())
            clearInputs()
            viewModel.addPressed() })
        _binding!!.subButton.setOnClickListener(View.OnClickListener {
            viewModel.setInput1(_binding!!.numberField1.text.toString())
            viewModel.setInput2(_binding!!.numberField2.text.toString())
            clearInputs()
            viewModel.subPressed() })
        _binding!!.multButton.setOnClickListener(View.OnClickListener {
            viewModel.setInput1(_binding!!.numberField1.text.toString())
            viewModel.setInput2(_binding!!.numberField2.text.toString())
            clearInputs()
            viewModel.multPressed() })
        _binding!!.divButton.setOnClickListener(View.OnClickListener {
            viewModel.setInput1(_binding!!.numberField1.text.toString())
            viewModel.setInput2(_binding!!.numberField2.text.toString())
            clearInputs()
            viewModel.divPressed() })
    }

    private fun clearInputs() {
        _binding!!.numberField1.text.clear()
        _binding!!.numberField2.text.clear()
    }

    private fun observeData() {
        viewModel.resultText.observe(viewLifecycleOwner, Observer { res ->
            if (res != "null") {
                _binding!!.resultText.text = getString(R.string.result, res)
            }
        })
    }
}