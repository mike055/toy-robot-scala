package toyrobot.commands

import toyrobot.models.{Robot, TheWorld}

package object Report {

  def reportRobotPosition(robot: Option[Robot]): Option[String] = {
    robot match {
      case None => None
      case Some(Robot(x, y, facing)) => Some(s"${x},${y},${facing}")
    }
  }

  def map(theCurrentWorld: TheWorld): String = {
    val map = new StringBuilder()

    for (y <- 4 to 0 by -1) {
      for ( x <- 0 to 4)  {
        map.append(getCharForPosition(x, y, theCurrentWorld.table.objects, theCurrentWorld.robot))
      }

      if( y != 0)
        map.append("\n")
    }

    map.toString()
  }

  def getCharForPosition(x: Int, y: Int, objects: List[(Int, Int)], robot: Option[Robot]): String = {
    if (isThereAnObjectInSpot(x, y, objects)) {
      return "X"
    }

    if (isRobotOnSpot(x, y, robot)) {
      return getRobotDirectionChar(robot.map(r=> r.currentlyFacing))
    }

    return "0"
  }

  def isThereAnObjectInSpot(x: Int, y: Int, objects: List[(Int, Int)]): Boolean = {
    objects.filter( c => c == (x, y)).length > 0
  }

  def isRobotOnSpot(x: Int, y: Int, robot: Option[Robot]): Boolean = {
    robot match {
      case None => false
      case Some(Robot(robotX, robotY, _)) => {
        x == robotX & y == robotY
      }
    }
  }

  def getRobotDirectionChar(facing: Option[Direction]) = {

    facing match {
      case None => ""
      case Some(dir) => {
        dir match {
          case North => "^"
          case East => ">"
          case South => "|"
          case West => "<"
        }
      }
    }
  }
}
