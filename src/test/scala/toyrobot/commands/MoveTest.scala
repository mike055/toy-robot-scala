package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.Robot
import toyrobot.models.Table


class MoveTest extends FunSpec with TypeCheckedTripleEquals {
  val testTable = Table(5,5)

  describe("moveRobot") {

    describe("when robot is not placed") {
      it("returns an unplaced robot") {
        val currentRobot = None
        val result = Move.moveRobot(currentRobot, testTable)
        assert(result === None)
      }
    }

    describe("and it is facing SOUTH") {
      it("returns a robot in new position") {
        val currentRobot = Some(Robot(1, 2, South))

        val result = Move.moveRobot(currentRobot, testTable)
        assert(result === Some(Robot(1, 1, South)))
      }
    }

    describe("and it is facing NORTH") {
      it("returns a robot in new position") {
        val currentRobot = Some(Robot(1, 1, North))

        val result = Move.moveRobot(currentRobot, testTable)
        assert(result === Some(Robot(1, 2, North)))
      }
    }

    describe("and it is facing WEST") {
      it("returns a robot in new position") {
        val currentRobot = Some(Robot(5, 1, West))

        val result = Move.moveRobot(currentRobot, testTable)
        assert(result === Some(Robot(4, 1, West)))
      }
    }

    describe("and it is facing EAST") {
      it("returns a robot in new position") {
        val currentRobot = Some(Robot(1, 1, East))

        val result = Move.moveRobot(currentRobot, testTable)
        assert(result === Some(Robot(2, 1, East)))
      }
    }
  }
}