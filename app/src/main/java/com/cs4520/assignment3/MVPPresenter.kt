package com.cs4520.assignment3

class MVPPresenter(private val view : Contract.View?,
                   private val model : Contract.Model) : Contract.Presenter {


    private fun verifyData(): Boolean {
        if (view != null) {
            val op1 = view.getInput1().toDoubleOrNull()
            val op2 = view.getInput2().toDoubleOrNull()
            return (op1 != null) && (op2 != null)
        }
        return false
    }

    override fun addPressed() {
        if (view != null) {
            if (verifyData()) {
                val result = model.add(view.getInput1().toDouble(), view.getInput2().toDouble())
                view.setResult(result.toString())
                view.clearInputs()
            } else {
                view.displayErrorToast(false)
            }
        }
    }

    override fun subtractPressed() {
        if (view != null) {
            if (verifyData()) {
                val result = model.sub(view.getInput1().toDouble(), view.getInput2().toDouble())
                view.setResult(result.toString())
                view.clearInputs()
            } else {
                view.displayErrorToast(false)
            }
        }
    }

    override fun multiplyPressed() {
        if (view != null) {
            if (verifyData()) {
                val result = model.mult(view.getInput1().toDouble(), view.getInput2().toDouble())
                view.setResult(result.toString())
                view.clearInputs()
            } else {
                view.displayErrorToast(false)
            }
        }
    }

    override fun dividePressed() {
        if (view != null) {
            if (verifyData() && !view.getInput2().toDouble().equals(0.0)) {
                val result = model.divide(view.getInput1().toDouble(), view.getInput2().toDouble())
                view.setResult(result.toString())
                view.clearInputs()
            } else {
                // Display div by 0 error if input 2 is 0
                view.displayErrorToast(view.getInput2().toDouble().equals(0.0))
            }
        }
    }
}