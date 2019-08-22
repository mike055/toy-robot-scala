package toyrobot.models

import toyrobot.commands.Direction

sealed trait Robot
case class UnPlacedRobot() extends Robot
case class PlacedRobot(currentPositionX: Int, currentPositionY: Int, currentlyFacing: Direction) extends Robot
