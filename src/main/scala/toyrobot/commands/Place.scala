package toyrobot.commands

import toyrobot.models.{Robot, Table}

package object Place {

  def placeRobot(args: PlaceArgs, robot: Option[Robot], table: Table): Option[Robot] = {
    Some(Robot(args.x, args.y, args.facing))
  }
}
