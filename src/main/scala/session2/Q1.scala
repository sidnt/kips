package kips.session2

object Q1 {
  /*
  Q1. Use pattern matching to find the following
  1) Maximum Element of a list
  2) Length of a list
  3) Nth element from the last of a list
  4) Minimum Element of a list
  Note : Use recursion, do not use vars
  */

  def maxIn(li:List[Int]): Option[Int] = {
    def maxOf(a:Int,b:Int):Int = if(a>=b) a else b
    chooseFrom(li, maxOf)
  }
  def minIn(li:List[Int]): Option[Int] = {
    def minOf(a:Int,b:Int):Int = if(a<=b) a else b
    chooseFrom(li, minOf)
  }

  def chooseFrom[A](la:List[A], chooseFrom:(A,A)=>A): Option[A] = la match {
    
    case Nil => None
    case h :: Nil => Some(h)
    case h :: t => {

      def iter(ila:List[A], chosenSoFar: A): A = ila match {
        case Nil => chosenSoFar
        case h :: t => iter(t, chooseFrom(chosenSoFar, h))
      }

      Some(
        iter(t, chooseFrom(h,t.head))
      )

    }
  }

  def lenOf[A](la:List[A]):Int = {

    def iter(la:List[A], lenSoFar:Int): Int = la match {
      case Nil => lenSoFar
      case h :: t => iter(t, lenSoFar + 1)
    }
    iter(la, 0)
  }

  def nthIn[A](la:List[A], n:Int):Option[A] = la match {
    case Nil => None
    case h :: t if n == 0 => Some(h)
    case _ => nthIn(la.tail, n-1)
  }

  def nthFromLastIn[A](la:List[A], n:Int): Option[A] = {
    val len = lenOf(la)
    val x = len - n
    nthIn(la,x)
  }
}