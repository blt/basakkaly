package basakkaly

import akka.actor.Actor
import akka.event.{EventHandler => log}

class Hello extends Actor {
  log.info(this,"Hello, world!")

  def receive = {
    case _ => self.reply_?("How did you get this number!?")
  }
}
