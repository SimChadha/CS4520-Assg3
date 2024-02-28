package com.cs4520.assignment3

class Model : Contract.Model {
    var op1: String? = null
    var op2: String?  = null

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

    fun getOp1() {
        return this.op1
    }
}