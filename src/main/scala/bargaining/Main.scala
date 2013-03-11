package bargaining

import bargaining.agents._
import bargaining._

object Main {
  def printAgentAccounts(accounts: Map[Agent,Int]) =
    println (accounts.toList.sortWith(_._2 > _._2) 
		map (agentAccount => agentAccount._1.name + "(" + agentAccount._2 + ")"))
  
  def main(args: Array[String]): Unit =
  {
	val gameResults = new GameRunner ( Vector (
			new MyAgent,
			new RandomAgent,
			new TrulyRandomAgent,
			new RandomBeaterAgent,
			new SmartAgent
			)
		).runGames
	printAgentAccounts(gameResults)
  }	
}