package toyrobot.commands

sealed trait Direction
case object North extends Direction
case object South extends Direction
case object East extends Direction
case object West extends Direction

case class PlaceArgs(x: Int, y: Int, facing: Direction)

sealed trait Command
case object MoveCommand extends Command
case object LeftCommand extends Command
case object RightCommand extends Command
case object ReportCommand extends Command
case class PlaceCommand(args: PlaceArgs) extends Command

