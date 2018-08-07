package kips.session2

import org.scalatest._
import Q2._

class Q2Spec extends FlatSpec with Matchers {
  val l = List(7,0,5,1,2,3)
  val m = Map(1->'a',2->'b')
  
  "apply method" should "work correctly" in {
    Q2("bro") shouldEqual "you gave me this string: bro"
    Q2(2) shouldEqual "thanks for the int: 2"
    Q2(2.2f) shouldEqual "input was the float 2.2"
    //Q2(Array(3,4)) shouldEqual "input was Array(3,4)" HOW DO WE TEST THIS?
    //Q2(Array("abc","def")) shouldEqual "input was Array(abc, def)" HOW DO WE TEST THIS?
    Q2(Pet("Bo")) shouldEqual "input was Pet(Bo)"
    Q2(List("abc","def")) shouldEqual "input was List(abc, def)"
    Q2(List(1,2)) shouldEqual "input was List(1, 2)"
    Q2(m) shouldEqual "input was Map(1 -> a, 2 -> b)"
  }
}