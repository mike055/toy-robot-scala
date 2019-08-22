package toyrobot.models

import toyrobot.commands.Direction

case class Robot(currentPositionX: Int, currentPositionY: Int, currentlyFacing: Direction)
