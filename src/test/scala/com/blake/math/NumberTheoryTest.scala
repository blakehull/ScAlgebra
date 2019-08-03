package com.blake.math

import com.blake.math.numbertheory.NumberTheory._
import org.scalatest.FunSpec

import scala.collection.mutable.ListBuffer

class NumberTheoryTest extends FunSpec {

  describe("number theory function tests"){
    it("should be 753 = 3*251"){
      assert(pMinusOne(753, solution = 753) == ListBuffer(3, 251))
      flushFactors
    }
    it("should be 779167 = 2003*389"){
      assert(pMinusOne(779167, solution = 779167)== ListBuffer(389, 2003))
      flushFactors
    }
    it("should be 2*2*3*151*7253*19603"){
      assert(pMinusOne(257631172908L, solution = 257631172908L) == ListBuffer(2,2,3,151,7253,19603))
      flushFactors
    }
    it("should verify ChineseRemainder"){
      val verifyMod = ChineseRemainder(List((2L,3L), (3L,5L)))
      assert(verifyMod.isRight)
      assert(verifyMod.right.get % 3 == 2 && verifyMod.right.get % 5 == 3)
    }
    it("should verify"){
      val verifyMod = ChineseRemainder(List((6L,11L), (13L,16L), (9L, 21L), (19L, 25L)))
      assert(verifyMod.right.get == 89469)
    }
  }

}