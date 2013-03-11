package bargaining.agents
import bargaining._
import scala.math._

class TrulyRandomAgent extends RandomAgent {
  override val name = "trulyRandom"
  
  override def accept(agent: Agent, division: Division): Boolean =
    random.nextBoolean
   
}