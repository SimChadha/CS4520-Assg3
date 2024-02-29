package com.cs4520.assignment3

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
import com.cs4520.assignment3.databinding.CalcLayoutBinding

class MVVMFragment : Fragment(R.layout.calc_layout) {
    private var _binding: CalcLayoutBinding? = null
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
        _binding = CalcLayoutBinding.inflate(inflater, container, false)

        viewModel = MVVMViewModel()

        bindUiToModel(viewModel)

        observeData()

        return binding.root
    }

    /**
     * Provides ViewModel with user input when a button is clicked and performs the operation
      */
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

    /**
     * Sets the observers for result text and error so the Fragment reacts when the ViewModel
     * changes
     */
    private fun observeData() {
        viewModel.resultText.observe(viewLifecycleOwner, Observer { res ->
            if (res != "null") {
                _binding!!.resultText.text = getString(R.string.result, res)
            }
        })
        viewModel.errorMessageChanged.observe(viewLifecycleOwner, Observer {
            displayErrorToast(viewModel.isDivideByZeroError.value)
        })
    }

    private fun displayErrorToast(divByZero: Boolean?) {
        val errorStr = if (divByZero != null && divByZero) {
            getString(R.string.divErrorToast)
        } else {
            getString(R.string.genericErrorToast)
        }
        val toast = Toast.makeText(context, errorStr, Toast.LENGTH_SHORT)
        toast.show()
    }
}