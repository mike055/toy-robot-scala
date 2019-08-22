package toyrobot.commands

import toyrobot.models.{Robot, Table}

package object Move {

  def moveRobot(robot: Option[Robot], table: Table): Option[Robot] = {
    robot.map( (r: Robot) => {
      r.currentlyFacing match {
        case North => moveNorth(r.currentPositionX, r.currentPositionY, r.currentlyFacing, table)
        case South => moveSouth(r.currentPositionX, r.currentPositionY, r.currentlyFacing, table)
        case East => moveEast(r.currentPositionX, r.currentPositionY, r.currentlyFacing, table)
        case West => moveWest(r.currentPositionX, r.currentPositionY, r.currentlyFacing, table)
      }
    })
  }

  // Have a position type (x,y) and a function to return a movement vector based on Facing direction


  def moveNorth(x: Int, y: Int, facing: Direction, table: Table): Robot = {
    val nextX = x
    val nextY = y + 1

    Robot(nextX, nextY, facing)
  }

  def moveSouth(x: Int, y: Int, facing: Direction, table: Table): Robot = {
    val nextX = x
    val nextY = y - 1

    Robot(nextX, nextY, facing)
  }

  def moveEast(x: Int, y: Int, facing: Direction, table: Table): Robot = {
    val nextX = x + 1
    val nextY = y

    Robot(nextX, nextY, facing)
  }

  def moveWest(x: Int, y: Int, facing: Direction, table: Table): Robot = {
    val nextX = x - 1
    val nextY = y

    Robot(nextX, nextY, facing)
  }
}
