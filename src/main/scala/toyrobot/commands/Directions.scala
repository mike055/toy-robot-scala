package toyrobot.commands

import toyrobot.models.{PlacedRobot, Robot, UnPlacedRobot}

package object Directions {

  def moveLeft(robot: Robot): Robot = {
    robot match {
      case(UnPlacedRobot()) => UnPlacedRobot()
      case(PlacedRobot(x, y, facing)) => facing match {
        case North => PlacedRobot(x, y, West)
        case East => PlacedRobot(x, y, North)
        case South => PlacedRobot(x, y, East)
        case West => PlacedRobot(x, y, South)
      }
    }
  }

  def moveRight(robot: Robot): Robot = {
    robot match {
      case(UnPlacedRobot()) => UnPlacedRobot()
      case(PlacedRobot(x, y, facing)) => facing match {
        case North => PlacedRobot(x, y, East)
        case East => PlacedRobot(x, y, South)
        case South => PlacedRobot(x, y, West)
        case West => PlacedRobot(x, y, North)
      }
    }
  }
}
