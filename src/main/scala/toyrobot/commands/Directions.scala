package toyrobot.commands

import toyrobot.models.Robot

package object Directions {

  def moveLeft(robot: Option[Robot]): Option[Robot] = {
    robot.map( (r: Robot) => {
      Robot(r.currentPositionX, r.currentPositionY, getNextDirections(r.currentlyFacing)._1)
    })
  }

  def moveRight(robot: Option[Robot]): Option[Robot] = {
    robot.map((r: Robot) => {
      Robot(r.currentPositionX, r.currentPositionY, getNextDirections(r.currentlyFacing)._2)
    })
  }

  def getNextDirections(facing: Direction): (Direction, Direction) = {
    facing match {
      case North => (West, East)
      case East => (North, South)
      case South => (East, West)
      case West => (South, North)
    }
  }
}
