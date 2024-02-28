package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.CalcLayoutBinding

class MVPFragment : Fragment(R.layout.calc_layout), Contract.View {

    private var _binding: CalcLayoutBinding? = null
    private val binding get() = _binding!!

    private var presenter: MVPPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = CalcLayoutBinding.inflate(inflater, container, false)

        presenter = MVPPresenter(this, Model())

        _binding!!.addButton.setOnClickListener(View.OnClickListener { presenter!!.addPressed() })
        _binding!!.subButton.setOnClickListener(View.OnClickListener { presenter!!.subtractPressed() })
        _binding!!.multButton.setOnClickListener(View.OnClickListener { presenter!!.multiplyPressed() })
        _binding!!.divButton.setOnClickListener(View.OnClickListener { presenter!!.dividePressed() })

        return binding.root
    }

    override fun clearInputs() {
        _binding?.numberField1?.text?.clear()
        _binding?.numberField2?.text?.clear()
    }

    override fun setResult(result: String) {
        _binding?.resultText?.text = getString(R.string.result, result)
    }

    override fun getInput1(): String {
        return _binding?.numberField1?.text.toString()
    }

    override fun getInput2(): String {
        return _binding?.numberField2?.text.toString()
    }

    /**
     * Displays a generic error toast when specialError is false and a divide by 0 error when
     * true
     */
    override fun displayErrorToast(specialError: Boolean) {
        val errorStr = if (specialError) {
            getString(R.string.divErrorToast)
        } else {
            getString(R.string.genericErrorToast)
        }
        val toast = Toast.makeText(context, errorStr, Toast.LENGTH_SHORT)
        toast.show()
    }
}