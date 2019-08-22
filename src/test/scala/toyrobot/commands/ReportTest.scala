package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{UnPlacedRobot, PlacedRobot}


class ReportTest extends FunSpec with TypeCheckedTripleEquals {
  describe("reportRobotPosition") {

    describe("when robot is unplaced") {
      it("returns None") {
        val result = Report.reportRobotPosition(UnPlacedRobot())
        assert(result === None)
      }
    }

    describe("when robot the robot is placed") {
      it("returns None") {
        val result = Report.reportRobotPosition(PlacedRobot(1, 1, North))
        assert(result === Some("1,1,North"))
      }
    }
  }
}