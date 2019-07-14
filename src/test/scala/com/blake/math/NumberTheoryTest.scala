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
  }

}