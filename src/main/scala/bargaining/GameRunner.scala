package bargaining

import bargaining.agents._
import scala.util.Random

class GameRunner (agents: Vector[Agent], sum: Int = 50, numberOfGames: Int = 1000) {
  
  def increaseAccount(accounts: Map[Agent,Int], a: Agent, s: Int): Map[Agent,Int] =
	  accounts.updated(a, accounts(a) + s)
	  
  def runOneGame (agent1: Agent, agent2: Agent): Division =
	{
	  val Division(forMe,forYou) = agent1.propose(agent2, sum)
	  //assert(forMe*forYou > 0 && forMe + forYou == sum)
	  if (agent2.accept(agent1,Division(forMe,forYou))) Division(forMe,forYou)
	  else Division(0,0)
	}
  
  def runGames: Map[Agent,Int] = {
    var agentAccounts = (agents map ((_,0))).toMap
    for (i <- 1 to numberOfGames) {
      val agent1 = agents(Random.nextInt(agents.length))
      val agent2 = agents(Random.nextInt(agents.length))
      val gameResult = runOneGame(agent1, agent2)
      agentAccounts = increaseAccount(
		increaseAccount(agentAccounts,
			agent1,
			gameResult.forMe),
		agent2,
		gameResult.forYou)
    }
    agentAccounts
  }
}