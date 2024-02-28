package com.cs4520.assignment3

// Contract for our MVP interactions
interface Contract {
    interface View {
        fun setResult(result: String)

        /**
         * Clears the user inputs
         */
        fun clearInputs()


        /**
         * Getters for each user operand
         */
        fun getInput1(): String

        fun getInput2(): String

        /**
         * Displays a generic error or a specific error if passed in true
         */
        fun displayErrorToast(specialError: Boolean)
    }

    interface Model {
        /**
         * Functions to perform operation in the model
         */
        fun add(op1: Double, op2: Double): Double
        fun sub(op1: Double, op2: Double): Double
        fun mult(op1: Double, op2: Double): Double
        fun divide(op1: Double, op2: Double): Double
    }

    interface Presenter {
        /**
         * Handlers for each operation button in the UI
         */
        fun addPressed()
        fun subtractPressed()
        fun multiplyPressed()
        fun dividePressed()
    }
}