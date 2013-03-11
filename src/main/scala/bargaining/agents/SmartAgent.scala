package bargaining.agents

import bargaining._
import scala.util.Random
import scala.math.max

class SmartAgent extends Agent {
  override val name: String = "2Smart"
    
  def propose (agent: Agent, sum: Int): Division = {
	val forMe =	(sum/2 +: (for (forMe <- sum/2 + 1 to sum by max(1, sum/100);
		if agent.accept(this, Division(forMe, sum - forMe))) yield forMe)).last
	Division(forMe, sum - forMe)
  }
    
  def accept (agent: Agent, div: Division): Boolean  = 
  {
    val Division(forYou, forMe) = div
    forMe >= forYou || Random.nextBoolean 
  }  
}