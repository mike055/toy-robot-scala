package toyrobot.commands

import toyrobot.models.{TheWorld}
package object CommandExecutor {


  // can return
    // the new world (updated robot and table)
    // any messages

  def executeCommand(command: Command, theCurrentWorld: TheWorld): (TheWorld, Option[String]) = {

    //do the command (with invalid state)
    //validate the new world
    //if valid return new world
    //if not valid return the old world

    val result = command match {
      case PlaceCommand(args) =>
        (theCurrentWorld.copy(robot = Place.placeRobot(args, theCurrentWorld.robot, theCurrentWorld.table)), None)
      case MoveCommand =>
        (theCurrentWorld.copy(robot = Move.moveRobot(theCurrentWorld.robot, theCurrentWorld.table)), None)
      case LeftCommand =>
        (theCurrentWorld.copy(robot = Directions.moveLeft(theCurrentWorld.robot)), None)
      case RightCommand =>
        (theCurrentWorld.copy(robot = Directions.moveRight(theCurrentWorld.robot)), None)
      case ReportCommand =>
        (theCurrentWorld, Report.reportRobotPosition(theCurrentWorld.robot))
      case PlaceObjectCommand => {
        val objectPosition = Objects.getObjectPosition(theCurrentWorld)

        objectPosition match {
          case None => (theCurrentWorld, None)
          case Some( (x, y) ) => {
            val newObjectsList = theCurrentWorld.table.objects :+ (x, y)
            val newTable = theCurrentWorld.table.copy(objects = newObjectsList)

            (theCurrentWorld.copy(table = newTable), None)
          }
        }
      }

      case _ => (theCurrentWorld, None)
    }

    if (Validation.isCurrentWorldValid(result._1)) {
      result
    }
    else {
      (theCurrentWorld, None)
    }
  }
}
