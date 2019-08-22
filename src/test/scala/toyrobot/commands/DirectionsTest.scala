package toyrobot.parser

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.commands._
import toyrobot.models.Robot


class DirectionsTest extends FunSpec with TypeCheckedTripleEquals {
  describe("moveLeft") {

    describe("when robot is unplaced") {
      it("returns unplaced robot") {
        val result = Directions.moveLeft(None)
        assert(result === None)
      }
    }

    describe("robot currently facing North") {
      it("returns robot facing West") {
        val result = Directions.moveLeft(Some(Robot(1, 1, North)))
        assert(result === Some(Robot(1, 1, West)))
      }
    }

    describe("robot currently facing West") {
      it("returns robot facing South") {
        val result = Directions.moveLeft(Some(Robot(1, 1, West)))
        assert(result === Some(Robot(1, 1, South)))
      }
    }

    describe("robot currently facing South") {
      it("returns robot facing East") {
        val result = Directions.moveLeft(Some(Robot(1, 1, South)))
        assert(result === Some(Robot(1, 1, East)))
      }
    }

    describe("robot currently facing East") {
      it("returns robot facing North") {
        val result = Directions.moveLeft(Some(Robot(1, 1, East)))
        assert(result === Some(Robot(1, 1, North)))
      }
    }
  }

  describe("moveRight") {

    describe("when robot is unplaced") {
      it("returns unplaced robot") {
        val result = Directions.moveRight(None)
        assert(result === None)
      }
    }

    describe("robot currently facing North") {
      it("returns robot facing East") {
        val result = Directions.moveRight(Some(Robot(1, 1, North)))
        assert(result === Some(Robot(1, 1, East)))
      }
    }

    describe("robot currently facing West") {
      it("returns robot facing North") {
        val result = Directions.moveRight(Some(Robot(1, 1, West)))
        assert(result === Some(Robot(1, 1, North)))
      }
    }

    describe("robot currently facing South") {
      it("returns robot facing West") {
        val result = Directions.moveRight(Some(Robot(1, 1, South)))
        assert(result === Some(Robot(1, 1, West)))
      }
    }

    describe("robot currently facing East") {
      it("returns robot facing South") {
        val result = Directions.moveRight(Some(Robot(1, 1, East)))
        assert(result === Some(Robot(1, 1, South)))
      }
    }
  }
}