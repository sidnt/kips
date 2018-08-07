package kips.session2

import org.scalatest._
import Q3._

class Q3Spec extends FlatSpec with Matchers {
  
  val s1 = Student(1,"Ram",10,"A")
  val s2 = Student(2,"Sam",11,"C")
  val s3 = Student(3,"Jon",10,"A")
  val s4 = Student(4,"Max",11,"D")
  val ls:List[Student] = List(s1,s2,s3,s4)

  val s1sc = ScoreCard(1,45,10,20,15)
  val s2sc = ScoreCard(2,100,25,30,45)
  val s3sc = ScoreCard(3,30,10,10,10)
  val s4sc = ScoreCard(4,75,50,10,15)
  val lsc:List[ScoreCard] = List(s1sc,s2sc,s3sc,s4sc)

  "top3ByClass method" should "work correctly" in {
    val rankers = top3ByClass(ls, lsc)
    rankers(Class(10,"A")) shouldEqual List((Student(1,"Ram",10,"A"),ScoreCard(1,45,10,20,15)),(Student(3,"Jon",10,"A"),ScoreCard(3,30,10,10,10)))
    rankers(Class(11,"C")) shouldEqual List((Student(2,"Sam",11,"C"),ScoreCard(2,100,25,30,45)))
    rankers(Class(11,"D")) shouldEqual List((Student(4,"Max",11,"D"),ScoreCard(4,75,50,10,15)))
  }
  "topperBySubject method" should "work correctly" in {
    val toppersBySubject = topperBySubject(lsc)
    toppersBySubject(1) shouldEqual ScoreCard(4,75,50,10,15)
    toppersBySubject(2) shouldEqual ScoreCard(2,100,25,30,45)
    toppersBySubject(3) shouldEqual ScoreCard(2,100,25,30,45)
  }

}