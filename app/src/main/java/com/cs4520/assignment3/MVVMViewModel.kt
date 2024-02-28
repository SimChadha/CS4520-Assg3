package com.cs4520.assignment3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel : ViewModel() {

    private val model: Model = Model()
    private var result: Double? = null

    val resultText = MutableLiveData<String>()


    private fun validData(): Boolean {
        val op1 = getInput1()?.toDoubleOrNull()
        val op2 = getInput2()?.toDoubleOrNull()
        return op1 != null && op2 != null
    }


    fun addPressed() {
        if (validData()) {
            result = model.add(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            println("Result: " + result)
            resultText.value = result.toString()
        }
        else {
            println("Bad data!")
        }
    }

    fun subPressed() {
        if (validData()) {
            result = model.sub(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            resultText.value = result.toString()
        }
        else {
            // toast stuff
            print("Helloo")
        }
    }

    fun multPressed() {
        if (validData()) {
            result = model.mult(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            resultText.value = result.toString()
        }
        else {
            // toast stuff
        }
    }

    fun divPressed() {
        if (validData()) {
            result = model.dividie(getInput1()!!.toDouble(), getInput2()!!.toDouble())
            resultText.value = result.toString()
        }
        else {
            // toast stuff
        }
    }

    private fun getInput1(): String? {
        return model.op1
    }
    fun setInput1(str: String?) {
        model.op1 = str
        println(model.op1)
    }

    private fun getInput2(): String? {
        return model.op2
    }
    fun setInput2(str: String?) {
        model.op2 = str
        println(model.op1)
    }

}