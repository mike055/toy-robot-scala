package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.Robot


class ReportTest extends FunSpec with TypeCheckedTripleEquals {
  describe("reportRobotPosition") {

    describe("when robot is unplaced") {
      it("returns None") {
        val result = Report.reportRobotPosition(None)
        assert(result === None)
      }
    }

    describe("when robot the robot is placed") {
      it("returns None") {
        val result = Report.reportRobotPosition(Some(Robot(1, 1, North)))
        assert(result === Some("1,1,North"))
      }
    }
  }
}