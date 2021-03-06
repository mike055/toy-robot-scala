package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{PlacedRobot, UnPlacedRobot}
import toyrobot.models.Table


class MoveTest extends FunSpec with TypeCheckedTripleEquals {
  val testTable = Table(5,5)

  describe("moveRobot") {

    describe("when robot is not placed") {
      it("returns an unplaced robot") {
        val currentRobot = UnPlacedRobot()
        val result = Move.moveRobot(currentRobot, testTable)
        assert(result === UnPlacedRobot())
      }
    }

    describe("when the robot is placed") {
      describe("when the next position is not valid") {

        describe("in the SOUTH direction") {
          it("returns a robot in current position") {
            val currentRobot = PlacedRobot(1, 0, South)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(1, 0, South))
          }
        }

        describe("in the NORTH direction") {
          it("returns a robot in current position") {
            val currentRobot = PlacedRobot(1, 4, North)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(1, 4, North))
          }
        }

        describe("in the WEST direction") {
          it("returns a robot in current position") {
            val currentRobot = PlacedRobot(0, 1, West)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(0, 1, West))
          }
        }

        describe("in the EAST direction") {
          it("returns a robot in current position") {
            val currentRobot = PlacedRobot(4, 1, East)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(4, 1, East))
          }
        }
      }

      describe("when the next position is valid") {
        describe("and it is facing SOUTH") {
          it("returns a robot in new position") {
            val currentRobot = PlacedRobot(1, 2, South)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(1, 1, South))
          }
        }

        describe("and it is facing NORTH") {
          it("returns a robot in new position") {
            val currentRobot = PlacedRobot(1, 1, North)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(1, 2, North))
          }
        }

        describe("and it is facing WEST") {
          it("returns a robot in new position") {
            val currentRobot = PlacedRobot(5, 1, West)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(4, 1, West))
          }
        }

        describe("and it is facing EAST") {
          it("returns a robot in new position") {
            val currentRobot = PlacedRobot(1, 1, East)

            val result = Move.moveRobot(currentRobot, testTable)
            assert(result === PlacedRobot(2, 1, East))
          }
        }

      }
    }
  }
}