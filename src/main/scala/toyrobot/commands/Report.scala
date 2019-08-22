package toyrobot.commands

import toyrobot.models.{Robot, UnPlacedRobot, PlacedRobot}

package object Report {

  def reportRobotPosition(robot: Robot): Option[String] = {
    robot match {
      case UnPlacedRobot() => None
      case PlacedRobot(x, y, facing) => Some(s"$x,$y,$facing")
    }
  }
}
