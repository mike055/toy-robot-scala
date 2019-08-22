package toyrobot.commands

import toyrobot.models.Robot

package object Directions {

  def moveLeft(robot: Option[Robot]): Option[Robot] = {
    robot.map( (r: Robot) => {
      r.currentlyFacing match {
        case North => Robot(r.currentPositionX, r.currentPositionY, West)
        case East => Robot(r.currentPositionX, r.currentPositionY, North)
        case South => Robot(r.currentPositionX, r.currentPositionY, East)
        case West => Robot(r.currentPositionX, r.currentPositionY, South)
      }
    })
  }

  def moveRight(robot: Option[Robot]): Option[Robot] = {
    robot.map((r: Robot) => {
      r.currentlyFacing match {
        case North => Robot(r.currentPositionX, r.currentPositionY, East)
        case East => Robot(r.currentPositionX, r.currentPositionY, South)
        case South => Robot(r.currentPositionX, r.currentPositionY, West)
        case West => Robot(r.currentPositionX, r.currentPositionY, North)
      }
    })
  }
}
