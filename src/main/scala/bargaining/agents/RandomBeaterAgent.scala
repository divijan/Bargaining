package bargaining.agents

import bargaining._
import scala.util.Random

class RandomBeaterAgent extends Agent {
  override val name: String = "RandomBeater"
    
  def propose (agent: Agent, sum: Int): Division =
    if (agent.name == "random")	Division(sum,0)
	else Division(sum/2 + 1, sum/2 - 1)
    
  def accept (agent: Agent, div: Division): Boolean = true  
}