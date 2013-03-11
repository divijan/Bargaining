package bargaining.agents

import bargaining._
import scala.util.Random
import scala.math.max

class SmartAgent extends Agent {
  override val name: String = "2Smart"
    
  def propose (agent: Agent, sum: Int): Division = {
	val forMeList =	(for (forMe <- sum to sum/2 + 1 by -max(1, sum/100)) yield forMe).
		takeWhile(forMe => agent.accept(this, Division(forMe, sum - forMe)))
	if (forMeList.isEmpty) Division(sum/2, sum - sum/2)
	else Division(forMeList.head, sum - forMeList.head)
  }
    
  def accept (agent: Agent, div: Division): Boolean  = 
  {
    val Division(forYou, forMe) = div
    forMe >= forYou || Random.nextBoolean 
  }  
}