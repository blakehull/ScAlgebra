package com.blake.math

import com.blake.math.Functions._
import com.blake.math.numbertheory.validation.{NotRelativelyPrime, Validations}
import org.scalatest.FunSpec

class FunctionsTest extends FunSpec {
  describe("test them funcs"){
    it("should equal 4"){
      assert(modularPow(3,2,5) == 4)
    }
    it("should equal 445"){
      assert(modularPow(4,13,497) == 445)
    }
    it("should equal 211"){
      assert(modularPow(439,233,713) == 211)
    }
    it("should verify relative primeness"){
      assert(Validations.validateGCD((2L,3L)) == Right((2,3)))
      assert(Validations.validateGCD((2L,4L)) == Left(NotRelativelyPrime))
    }
    it("should give modular inverses"){
      assert(modularInverse(3L, 11L) == 4L)
    }
  }
}
