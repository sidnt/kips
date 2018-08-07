package kips.session2

import org.scalatest._
import Q1._

class Q1Spec extends FlatSpec with Matchers {
  val l1 = List(7,0,5,1,2,3)
  "maxIn method" should "work correctly" in {
    maxIn(l1) shouldEqual Some(7)
  }
  "minIn method" should "work correctly" in {
    minIn(l1) shouldEqual Some(0)
  }
  "lenOf method" should "work correctly" in {
    lenOf(l1) shouldEqual 6
  }
  "nthIn method" should "work correctly" in {
    nthIn(l1,2) shouldEqual Some(5)
  }
  "nthFromLastIn method" should "work correctly" in {
    nthFromLastIn(l1,2) shouldEqual Some(2)
  }

}