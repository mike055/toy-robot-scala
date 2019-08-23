package toyrobot.commands

import toyrobot.commands.{Direction, East, North, South, West}

package object Position {
  def getNextPositionCoords(facing: Direction): (Int, Int) = {
    facing match {
      case North => (0, 1)
      case East => (1, 0)
      case South => (0, -1)
      case West => (-1, 0)
    }
  }
}
