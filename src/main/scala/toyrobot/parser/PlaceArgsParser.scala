package toyrobot.parser

import toyrobot.commands._

object PlaceArgsParser {

  def parsedArgsOrNothing(command: String): Option[PlaceArgs] = {
    val commandAndArgs = command.split(" ")
    val parsedArgs = validateAndParseArgs(commandAndArgs)

    parsedArgs match {
      case Some(args) => {

        for {
          x <- args(0).toIntOption
          y <- args(1).toIntOption
          facing <- args(2) match {
            case "NORTH" => Some(North)
            case "EAST" => Some(East)
            case "SOUTH" => Some(South)
            case "WEST" => Some(West)
            case _ => None
          }
        } yield( PlaceArgs(x, y, facing) )

      }
      case None => None
    }
  }

  private def validateAndParseArgs(commandAndArgs: Array[String]): Option[Array[String]] = {
    if (commandAndArgs.length == 2) {
      val argsStr = commandAndArgs(1).split(",")

      if (argsStr.length == 3) {
        Some(argsStr)
      }
      else {
        None
      }
    }
    else {
      None
    }
  }
}
