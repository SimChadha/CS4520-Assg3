package com.cs4520.assignment3

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class MVVCViewModel : BaseObservable() {

    private val model: Model = Model()
    private var result: Double? = null


    private fun validData(): Boolean {
        val op1 = getInput1()?.toDoubleOrNull()
        val op2 = getInput2()?.toDoubleOrNull()
        return op1 != null && op2 != null
    }


    fun addPressed() {
        if (validData()) {
            result = model.add(getInput1()!!.toDouble(), getInput2()!!.toDouble())
        }
        else {
            println("Bad data!")
        }
    }

    fun subPressed() {
        if (validData()) {
            result = model.sub(getInput1()!!.toDouble(), getInput2()!!.toDouble())
        }
        else {
            // toast stuff
        }
    }

    fun multPressed() {
        if (validData()) {
            result = model.mult(getInput1()!!.toDouble(), getInput2()!!.toDouble())
        }
        else {
            // toast stuff
        }
    }

    fun divPressed() {
        if (validData()) {
            result = model.dividie(getInput1()!!.toDouble(), getInput2()!!.toDouble())
        }
        else {
            // toast stuff
        }
    }

    @Bindable
    fun getInput1(): String? {
        return model.op1
    }
    fun setInput1(input: String?) {
        model.op1 = input
    }

    @Bindable
    fun getInput2(): String? {
        return model.op2
    }
    fun setInput2(input: String?) {
        model.op2 = input
    }

    @Bindable
    fun getResult(): String? {
        return result.toString()
    }
    fun setResult(res: String?) {
        this.result = res?.toDouble()
    }

}