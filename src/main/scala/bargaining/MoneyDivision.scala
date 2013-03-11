package bargaining

case class Division(forMe: Int, forYou: Int)
//can be constructed without new, and are compared by value, not by address
//can be compared by address with eq operator.
//case classes have copy() function with optional parameters.
//case classes
//look at class definitions

trait Agent {

  def name: String = "unknown"
  
  def propose(agent: Agent, sum: Int): Division
  
  def accept(agent: Agent, division: Division): Boolean
  
}

//Д/з: посмотреть дома GameRunner