package toyrobot.parser

import toyrobot.commands._

object CommandParser {

  def parsedCommandOrNothing(command: String): Option[Command] = {
    command.trim match {
      case "MOVE" => Some(MoveCommand)
      case "LEFT" => Some(LeftCommand)
      case "RIGHT" => Some(RightCommand)
      case "REPORT" => Some(ReportCommand)
      case _ => makePlaceCommandOrNothing(command)
    }
  }

  private def makePlaceCommandOrNothing(command: String): Option[Command] = {
    if(command.contains("PLACE")) {
      val parsedArgs = PlaceArgsParser.parsedArgsOrNothing(command)

      parsedArgs match {
        case Some(args) => {
          Some(PlaceCommand(args))
        }
        case None => None
      }
    }
    else {
      None
    }
  }
}
