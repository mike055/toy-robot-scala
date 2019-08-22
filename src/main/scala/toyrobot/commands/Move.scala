package toyrobot.commands

import toyrobot.models.{PlacedRobot, Robot, Table, UnPlacedRobot}

package object Move {

  def moveRobot(robot: Robot, table: Table): Robot = {
    robot match {
      case (UnPlacedRobot()) => UnPlacedRobot()
      case (PlacedRobot(x, y, facing)) => facing match {
        case North => moveNorth(x, y, facing, table)
        case South => moveSouth(x, y, facing, table)
        case East => moveEast(x, y, facing, table)
        case West => moveWest(x, y, facing, table)
      }
    }
  }

  // Have a position type (x,y) and a function to return a movement vector based on Facing direction


  def moveNorth(x: Int, y: Int, facing: Direction, table: Table): Robot = {
    val nextX = x
    val nextY = y + 1

    if (Position.positionIsValid(nextX, nextY, table)) {
      PlacedRobot(nextX, nextY, facing)
    }
    else {
      PlacedRobot(x, y, facing)
    }
  }

  def moveSouth(x: Int, y: Int, facing: Direction, table: Table): Robot = {
    val nextX = x
    val nextY = y - 1

    if (Position.positionIsValid(nextX, nextY, table)) {
      PlacedRobot(nextX, nextY, facing)
    }
    else {
      PlacedRobot(x, y, facing)
    }
  }

  def moveEast(x: Int, y: Int, facing: Direction, table: Table): Robot = {

    val nextX = x + 1
    val nextY = y

    if (Position.positionIsValid(nextX, nextY, table)) {
      PlacedRobot(nextX, nextY, facing)
    }
    else {
      PlacedRobot(x, y, facing)
    }
  }

  def moveWest(x: Int, y: Int, facing: Direction, table: Table): Robot = {
    val nextX = x - 1
    val nextY = y

    if (Position.positionIsValid(nextX, nextY, table)) {
      PlacedRobot(nextX, nextY, facing)
    }
    else {
      PlacedRobot(x, y, facing)
    }
  }
}
