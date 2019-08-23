package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{TheWorld, Table, Robot}


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

  describe("map") {

    describe("when no objects or robot") {
      it("returns map") {
        val theCurrentWorld = TheWorld(Table(5, 5, List()), None)


        val result = Report.map(theCurrentWorld)
        assert(result ===
          "00000\n" +
            "00000\n" +
            "00000\n" +
            "00000\n" +
            "00000"
        )
      }
    }

    describe("when objects") {
      it("returns map") {
        val theCurrentWorld = TheWorld(Table(5, 5, List((0,0), (4,4))), None)


        val result = Report.map(theCurrentWorld)
        assert(result ===
          "0000X\n" +
            "00000\n" +
            "00000\n" +
            "00000\n" +
            "X0000"
        )
      }
    }

    describe("when objects and robot facing North") {
      it("returns map") {
        val theCurrentWorld = TheWorld(Table(5, 5, List((0,0), (4,4))), Some(Robot(1, 1, North)))


        val result = Report.map(theCurrentWorld)
        assert(result ===
          "0000X\n" +
            "00000\n" +
            "00000\n" +
            "0^000\n" +
            "X0000"
        )
      }
    }

    describe("when objects and robot facing east") {
      it("returns map") {
        val theCurrentWorld = TheWorld(Table(5, 5, List((0,0), (4,4))), Some(Robot(1, 1, East)))


        val result = Report.map(theCurrentWorld)
        assert(result ===
          "0000X\n" +
            "00000\n" +
            "00000\n" +
            "0>000\n" +
            "X0000"
        )
      }
    }

    describe("when objects and robot facing west") {
      it("returns map") {
        val theCurrentWorld = TheWorld(Table(5, 5, List((0,0), (4,4))), Some(Robot(1, 1, West)))


        val result = Report.map(theCurrentWorld)
        assert(result ===
          "0000X\n" +
            "00000\n" +
            "00000\n" +
            "0<000\n" +
            "X0000"
        )
      }
    }

    describe("when objects and robot facing south") {
      it("returns map") {
        val theCurrentWorld = TheWorld(Table(5, 5, List((0,0), (4,4))), Some(Robot(1, 1, South)))


        val result = Report.map(theCurrentWorld)
        assert(result ===
          "0000X\n" +
            "00000\n" +
            "00000\n" +
            "0|000\n" +
            "X0000"
        )
      }
    }
  }
}