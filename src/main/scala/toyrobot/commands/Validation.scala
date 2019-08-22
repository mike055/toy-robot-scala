package toyrobot.commands

import toyrobot.models.{TheWorld, Robot}

package object Validation {

  def isCurrentWorldValid(theCurrentWorld: TheWorld): Boolean = {
    return robotInBoundsOfTable(theCurrentWorld)
  }

  def robotInBoundsOfTable(theCurrentWorld: TheWorld): Boolean = {

    theCurrentWorld.robot match {
      case None => true
      case Some(Robot(x, y, _)) => {
        (
          x >= 0 &
          x < theCurrentWorld.table.sizeX &
          y >= 0 &
          y < theCurrentWorld.table.sizeY
        )
      }
    }
  }
}
