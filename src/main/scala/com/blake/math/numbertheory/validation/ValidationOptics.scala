package com.blake.math.numbertheory.validation

import com.blake.math.Definitions.Types.ModuloTuple
import com.blake.math.Functions.gcd

sealed trait Validations {
  def errorMessage: String
}

case object NotRelativelyPrime extends Validations {
  def errorMessage: String = "These numbers are not relatively prime"
}

sealed trait Validator {
  def validateGCD(tuple: ModuloTuple): Either[Validations, ModuloTuple] =
    Either.cond(
      gcd(tuple._1, tuple._2) == 1,
      tuple,
      NotRelativelyPrime
    )
}

object Validations extends Validator