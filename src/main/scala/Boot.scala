package basakkaly

import akka.actor.Actor.actorOf
import akka.config.Supervision._
import akka.actor.Supervisor

class Boot {
  val strategy = OneForOneStrategy(List(classOf[Exception]), 3, 1000)
  val supervisor = Supervisor(SupervisorConfig(strategy, Nil))

  supervisor.link(actorOf[Hello].start)
}
