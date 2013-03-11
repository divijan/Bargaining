package bargaining

import bargaining.agents._
import bargaining._

object Main {
  def printAgentAccounts(accounts: Map[Agent,Int]) =
    println (accounts.toList map (agentAccount => agentAccount._1.name + "(" + agentAccount._2 + ")"))
  
  def main(args: Array[String]): Unit =
  {
	val gameResults = new GameRunner ( Vector (
			new MyAgent,
			new RandomAgent,
			new TrulyRandomAgent
			)
		).runGames
	printAgentAccounts(gameResults)
  }	
}