package com.cs4520.assignment3

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.databinding.MvpLayoutBinding

class MVVMFragment : Fragment(R.layout.mvp_layout) {
    private var _binding: MvpLayoutBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: MVVMViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            view.setBackgroundColor(ContextCompat.getColor(it, R.color.red))
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = MvpLayoutBinding.inflate(inflater, container, false)

        viewModel = MVVMViewModel()

        bindUiToModel(viewModel)

        // Text Changed listeners are used to bind our UI back to the ViewModel so it can
        // see the changes in user input
        _binding!!.numberField1.addTextChangedListener { object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setInput1(s.toString())
            }
        } }

        _binding!!.numberField2.addTextChangedListener { object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setInput2(s.toString())
            }
        } }

        observeData()

        return binding.root
    }

    private fun bindUiToModel(viewModel: MVVMViewModel) {
        _binding!!.addButton.setOnClickListener(View.OnClickListener {
            updateInputs()
            clearInputs()
            viewModel.addPressed() })
        _binding!!.subButton.setOnClickListener(View.OnClickListener {
            updateInputs()
            clearInputs()
            viewModel.subPressed() })
        _binding!!.multButton.setOnClickListener(View.OnClickListener {
            updateInputs()
            clearInputs()
            viewModel.multPressed() })
        _binding!!.divButton.setOnClickListener(View.OnClickListener {
            updateInputs()
            clearInputs()
            viewModel.divPressed() })
    }

    private fun updateInputs() {
        viewModel.setInput1(_binding!!.numberField1.text.toString())
        viewModel.setInput2(_binding!!.numberField2.text.toString())
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
        viewModel.errorStateChanged.observe(viewLifecycleOwner, Observer {
            displayErrorToast()
        })
    }

    private fun displayErrorToast() {
        val toast = Toast.makeText(context, getString(R.string.errorToast), Toast.LENGTH_SHORT)
        toast.show()
    }
}