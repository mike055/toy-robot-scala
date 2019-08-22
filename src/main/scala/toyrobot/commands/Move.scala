package toyrobot.commands

import toyrobot.models.{Robot, Table}

package object Move {

  def moveRobot(robot: Option[Robot], table: Table): Option[Robot] = {
    robot.map( (r: Robot) => {
      val nextPos = getNextPositionCoords(r.currentlyFacing)
      val x = r.currentPositionX + nextPos._1
      val y = r.currentPositionY + nextPos._2

      Robot(x, y, r.currentlyFacing)
    })
  }

  def getNextPositionCoords(facing: Direction): (Int, Int) = {
    facing match {
      case North => (0, 1)
      case East => (1, 0)
      case South => (0, -1)
      case West => (-1, 0)
    }
  }
}
