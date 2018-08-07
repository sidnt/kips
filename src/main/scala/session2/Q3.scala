package kips.session2
import Q1._

object Q3 {
  case class Student(id:Int, name:String, division:Int, section:String)
  case class ScoreCard(id:Int, totalMarks:Int, subject1:Int,subject2:Int,subject3:Int) 
  case class Class(division:Int, section:String)

  def top3ByClass(ls:List[Student], lsc:List[ScoreCard]): Map[Class, List[(Student,ScoreCard)]] = {
    val studentsByClass: Map[Class, List[Student]] = ls.groupBy(s => Class(s.division,s.section))
    val scorecardByStudId: Map[Int, ScoreCard] = lsc.groupBy(sc => sc.id).mapValues(_.head)
    val studentsRankedWithScorecardsByClass: Map[Class, List[(Student,ScoreCard)]] = 
      studentsByClass
        .mapValues(ls => ls.map(s => (s, scorecardByStudId(s.id)))) //: Map[Class, Iterable[(Student,Scorecard)]]
        .mapValues(ls => ls.sortWith((t1,t2)=>t1._2.totalMarks > t2._2.totalMarks))
    
    studentsRankedWithScorecardsByClass.mapValues(ltsm => ltsm.take(3))
  }

  //calc topper of each subject with their marks
  //all info to solve this is present in list of scorecards
  def topperBySubject(lsc:List[ScoreCard]): Map[Int, ScoreCard] = {
    val ts1: ScoreCard = chooseFrom(lsc, (sc1:ScoreCard, sc2:ScoreCard) => if(sc1.subject1 >= sc2.subject1) sc1 else sc2 ).get
    val ts2: ScoreCard = chooseFrom(lsc, (sc1:ScoreCard, sc2:ScoreCard) => if(sc1.subject2 >= sc2.subject2) sc1 else sc2 ).get
    val ts3: ScoreCard = chooseFrom(lsc, (sc1:ScoreCard, sc2:ScoreCard) => if(sc1.subject3 >= sc2.subject3) sc1 else sc2 ).get
    Map(
      1 -> ts1,
      2 -> ts2,
      3 -> ts3
    )
  }

  def markSheetOf(ls:List[Student], lsc:List[ScoreCard]): List[(Student, ScoreCard)] = {
    val marksById: Map[Int, ScoreCard] = lsc.groupBy(sc => sc.id).mapValues(_.head)
    ls.map(s => (s, marksById(s.id)))
  }

}