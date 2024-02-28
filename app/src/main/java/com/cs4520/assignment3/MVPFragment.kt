package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.MvpLayoutBinding

class MVPFragment : Fragment(R.layout.mvp_layout), Contract.View {

    private var _binding: MvpLayoutBinding? = null
    private val binding get() = _binding!!

    var presenter: MVPPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = MvpLayoutBinding.inflate(inflater, container, false)

        presenter = MVPPresenter(this, Model())

        _binding!!.addButton.setOnClickListener(View.OnClickListener { presenter!!.addPressed() })
        _binding!!.subButton.setOnClickListener(View.OnClickListener { presenter!!.subtractPressed() })
        _binding!!.multButton.setOnClickListener(View.OnClickListener { presenter!!.multiplyPressed() })
        _binding!!.divButton.setOnClickListener(View.OnClickListener { presenter!!.dividePressed() })

        return binding.root
    }

    override fun showResult(result: String) {
        _binding?.resultText?.visibility = View.VISIBLE
    }

    override fun clearInputs() {
        _binding?.numberField1?.text?.clear()
        _binding?.numberField2?.text?.clear()
    }

    override fun setResult(result: String) {
        _binding?.resultText?.text = getString(R.string.result, result)
    }

    override fun hideResult() {
        _binding?.resultText?.visibility = View.INVISIBLE
    }

    override fun getInput1(): String {
        return _binding?.numberField1?.text.toString()
    }

    override fun getInput2(): String {
        return _binding?.numberField2?.text.toString()
    }

    override fun displayErrorToast() {
        val toast = Toast.makeText(context, getString(R.string.errorToast), Toast.LENGTH_SHORT)
        toast.show()
    }
}