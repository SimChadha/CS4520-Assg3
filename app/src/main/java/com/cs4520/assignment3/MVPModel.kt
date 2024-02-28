package com.cs4520.assignment3

class MVPModel : Contract.Model {
    private var op1 = null
    private var op2 = null
    override fun add(op1: Double, op2: Double): Double {
        return op1 + op2
    }

    override fun sub(op1: Double, op2: Double): Double {
        return op1 - op2
    }

    override fun mult(op1: Double, op2: Double): Double {
        return op1 * op2
    }

    override fun dividie(op1: Double, op2: Double): Double {
        return op1 / op2
    }
}