package toyrobot.commands

import toyrobot.models.{PlacedRobot, Robot, Table, UnPlacedRobot}

package object Place {

  def placeRobot(args: PlaceArgs, robot: Robot, table: Table): Robot = {
    if(Position.positionIsValid(args.x, args.y, table)) {
      PlacedRobot(args.x, args.y, args.facing)
    }
    else {
      UnPlacedRobot()
    }
  }
}
