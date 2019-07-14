package com.blake.math

import org.scalatest.FunSpec
import com.blake.math.Functions._

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
  }
}
