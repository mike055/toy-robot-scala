package toyrobot.commands

import toyrobot.models.{TheWorld, Robot}

package object Objects {

  def getObjectPosition(theCurrentWorld: TheWorld): Option[(Int, Int)] = {

    theCurrentWorld.robot match {
      case None => None
      case Some(Robot(x, y, facing)) => {
        val nextPos = Position.getNextPositionCoords(facing)

        val nextX = x + nextPos._1
        val nextY = y + nextPos._2

        return Some((nextX, nextY))
      }
    }
  }
}
