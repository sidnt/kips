package kips.session2

object Q2 {

  case class Pet(name:String)
  
  def apply(i:Any):String = i match {

    //these are pm against AnyVal
    case s:String => s"you gave me this string: $s"
    case i:Int => s"thanks for the int: $i"
    case f:Float => s"input was the float $f"

    //these are pm against AnyRef
    case ai:Array[Int] => s"input was $ai"
    case as:Array[String] => s"input was $as"
    case Pet(n) => "input was " + Pet(n)

    case la:List[_] => s"input was $la"
    case ma:Map[_,_] => s"input was $ma"
    
  }
  
}