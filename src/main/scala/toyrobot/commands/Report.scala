package toyrobot.commands

import toyrobot.models.Robot

package object Report {

  def reportRobotPosition(robot: Option[Robot]): Option[String] = {
    robot match {
      case None => None
      case Some(Robot(x, y, facing)) => Some(s"${x},${y},${facing}")
    }
  }
}
