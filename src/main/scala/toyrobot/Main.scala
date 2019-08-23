package toyrobot

import toyrobot.commands.{Command, CommandExecutor}
import toyrobot.models.{Robot, Table, TheWorld}
import toyrobot.parser.CommandParser

object Main {
  def main(args: Array[String]): Unit = {
    //todo command line listening and file reading

    //maybe filter out invalid commands early

//    val commands = List(
//      "PLACE 1,2,EAST",
//      "GUFF",
//      "MOVE",
//      "MOVE",
//      "LEFT",
//      "MOVE",
//      "REPORT"
//    ) //3,3,NORTH

//    val commands = List(
//      "PLACE 0,0,NORTH",
//      "MOVE",
//      "REPORT"
//    ) //0,1,NORTH

//        val commands = List(
//          "PLACE 0,0,NORTH",
//          "LEFT",
//          "REPORT"
//        ) //0,0,WEST


    val commands = List(
      "MOVE",
      "LEFT",
      "RIGHT",
      "REPORT",
      "PLACE 1,2,EAST",
      "GUFF",
      "MOVE",
      "MOVE",
      "LEFT",
      "MOVE",
      "REPORT",
      "MOVE",
      "MOVE",
      "MOVE",
      "REPORT",
      "RIGHT",
      "REPORT",
      "MOVE",
      "MOVE",
      "REPORT",
      "RIGHT",
      "REPORT",
      "MOVE",
      "MOVE",
      "MOVE",
      "MOVE",
      "MOVE",
      "REPORT",
      "RIGHT",
      "REPORT",
      "MOVE",
      "MOVE",
      "MOVE",
      "MOVE",
      "MOVE",
      "MOVE",
      "REPORT",
      "RIGHT",
      "RIGHT",
      "REPORT",
      "PLACE_OBJECT",
      "MOVE",
      "REPORT",
      "RIGHT",
      "REPORT",
      "PLACE_OBJECT",
      "PLACE_OBJECT",
      "MOVE",
      "REPORT",
      "MAP"
    )
    //3,3,NORTH
    //3,4,NORTH
    //3,4,EAST
    //4,4,EAST
    //4,0,SOUTH
    //4,0,WEST
    //0,0,WEST
    //0,0,EAST
    //0,0,EAST
    //0,0,SOUTH
    //0,0,SOUTH


    val robot: Option[Robot] = None
    val table: Table = Table(5, 5, List())

    val theWorld = TheWorld(table, robot)

    val parsedCommands: Seq[Option[Command]] = commands.map(CommandParser.parsedCommandOrNothing)

    parsedCommands.foldLeft(theWorld)(movePerformCommand)

  }
  
  def movePerformCommand(theCurrentWorld: TheWorld, command: Option[Command]): TheWorld = {
    command match {
      case Some(command) => {
        val result: (TheWorld, Option[String]) = CommandExecutor.executeCommand(command, theCurrentWorld)

        result._2.map(println)

        result._1
      }
      case None => theCurrentWorld
    }
  }
}