package com.blake.math

object Functions {
  def modularPow(b: Long, e: Long, m: Long, result: Long = 1): Long = {
    // seems to be working perfectly
    if(e == 1) {result*b % m}
    else {modularPow(b, e - 1, m, result*b % m)}
  }

  def gcd(a: Long, b: Long): Long = {
    val collected = Array(a,b)
    if(b > a){
      gcd(b, a)
    }
    if(collected.product == 0){
      collected.lift(collected.indexWhere(_ > 0)).getOrElse(0L)
    }else{
      gcd(b, a % b)
    }
  }
}
