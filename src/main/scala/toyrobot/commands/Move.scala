package toyrobot.commands

import toyrobot.models.{Robot, Table}

package object Move {

  def moveRobot(robot: Option[Robot], table: Table): Option[Robot] = {
    robot.map( (r: Robot) => {
      val nextPos = Position.getNextPositionCoords(r.currentlyFacing)
      val x = r.currentPositionX + nextPos._1
      val y = r.currentPositionY + nextPos._2

      Robot(x, y, r.currentlyFacing)
    })
  }
}
