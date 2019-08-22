package toyrobot.commands

import toyrobot.models.{Robot, Table}

package object Place {

  def placeRobot(args: PlaceArgs, robot: Option[Robot], table: Table): Option[Robot] = {
    if(Position.positionIsValid(args.x, args.y, table)) {
      Some(Robot(args.x, args.y, args.facing))
    }
    else {
      None
    }
  }
}
