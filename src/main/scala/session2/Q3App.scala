package kips.session2
import Q3._

object Q3App extends App {
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

  val markSheetString: String = {
    val markSheet: List[(Student, ScoreCard)] = markSheetOf(ls:List[Student], lsc:List[ScoreCard])
    markSheet.map(
      tup => {
        val s = tup._1
        val sc = tup._2
        s"ID : ${s.id}\nNAME : ${s.name}\nDIVISION-SECTION : ${s.division} - ${s.section}\nMARKS :\nSUBJECTS :\n SUBJECT 1 : ${sc.subject1}\n SUBJECT 2 : ${sc.subject2}\n SUBJECT 3 : ${sc.subject3}\n TOTAL MARKS : ${sc.totalMarks}"
      }
    ).mkString("\n\n")
  }
// ID : 1
// NAME : Bob
// DIVISION-SECTION : 11 - A
// MARKS :
// SUBJECTS :
// SUBJECT 1 : 88.0
// SUBJECT 2 : 45.0
// SUBJECT 3 : 79.0
// TOTAL MARKS : 212.0

  println(markSheetString)
}