package com.blake.math.numbertheory

import com.blake.math.Definitions.Types._
import com.blake.math.Functions.{modularPow, gcd}

import scala.collection.mutable.ListBuffer

object NumberTheory {
  private var factors = new ListBuffer[Factor]()

  def flushFactors: Any = {
    factors = new ListBuffer[Factor]()
  }

  def pMinusOne(n: Long, a: Long = 2, solution: Long): ListBuffer[Factor] = {
    var worker: Long = a
    var iter: Long = 1
    var divisor = gcd(worker,n)
    while(divisor == 1){
      worker = modularPow(worker, iter, n)
      divisor = gcd(worker - 1, n)
      iter += 1
    }
    factors += divisor
    if(factors.toList.product == solution){
      factors.sorted
    }else{
      pMinusOne(n/divisor, solution = solution)
    }
  }


}