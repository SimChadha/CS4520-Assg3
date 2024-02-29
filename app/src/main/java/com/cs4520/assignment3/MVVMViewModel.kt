package com.cs4520.assignment3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel : ViewModel() {

    private val model: Model = Model()
    private var result: Double? = null

    // Live data objects that our view will observe to update itself accordingly
    val resultText = MutableLiveData<String>()
    val errorMessageChanged = MutableLiveData<Boolean>() // Flipped whenever there is a new error
    val isDivideByZeroError = MutableLiveData<Boolean>(false) // True if the current error is due to division by 0


    private fun validData(): Boolean {
        val op1 = getInput1()?.toDoubleOrNull()
        val op2 = getInput2()?.toDoubleOrNull()
        return op1 != null && op2 != null
    }


    fun addPressed() {
        if (validData()) {
            result = model.add(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            resultText.value = result.toString()
        }
        else {
            isDivideByZeroError.value = false
            errorMessageChanged.value = errorMessageChanged.value?.not()
        }
    }

    fun subPressed() {
        if (validData()) {
            result = model.sub(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            resultText.value = result.toString()
        }
        else {
            isDivideByZeroError.value = false
            errorMessageChanged.value = errorMessageChanged.value?.not()
        }
    }

    fun multPressed() {
        if (validData()) {
            result = model.mult(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            resultText.value = result.toString()
        }
        else {
            isDivideByZeroError.value = false
            errorMessageChanged.value = errorMessageChanged.value?.not()
        }
    }

    fun divPressed() {
        if (validData() && !getInput2()!!.toDouble().equals(0.0) ) {
            result = model.divide(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            resultText.value = result.toString()
        }
        else {
            isDivideByZeroError.value = getInput2()!!.toDouble().equals(0.0)
            errorMessageChanged.value = errorMessageChanged.value?.not()
        }
    }

    private fun getInput1(): String? {
        return model.op1
    }
    fun setInput1(str: String?) {
        model.op1 = str
    }

    private fun getInput2(): String? {
        return model.op2
    }
    fun setInput2(str: String?) {
        model.op2 = str
    }

}