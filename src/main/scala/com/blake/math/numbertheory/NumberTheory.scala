package com.blake.math.numbertheory

import com.blake.math.Definitions.Types._
import com.blake.math.Functions._
import com.blake.math.numbertheory.validation.{NotRelativelyPrime, Validations}

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

  def ChineseRemainder(equations: List[ModuloTuple]): Either[String, Long] = {
    val relativelyPrime: Boolean = equations.map(_._2).
      combinations(2).map(e => (e(0), e(1))).toList.
      map(e => Validations.validateGCD(e).isRight).
      forall(_ == true)

    if(relativelyPrime){
      val solutionMod = equations.map(_._2).product
      val z: List[Long] = equations.map(solutionMod/_._2)
      val inverseZ: List[Long] = (z zip equations.map(_._2)).map(e => modularInverse(e._1, e._2))
      val solution = (inverseZ zip z).map(x => x._1 * x._2) zip equations.map(_._1)
      Right(solution.map(e => e._1 * e._2).sum % solutionMod)
    }else{
      Left(NotRelativelyPrime.errorMessage)
    }

  }


}