package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{Robot, TheWorld, Table}


class ObjectsTest extends FunSpec with TypeCheckedTripleEquals {
  describe("placeObject") {

    describe("when robot is unplaced") {
      it("returns none") {
        val world = TheWorld(Table(5, 5,List()), None)

        val result = Objects.getObjectPosition(world)
        assert(result === None)
      }
    }

    describe("when robot the robot is placed facing North") {
      it("returns position of next object") {
        val world = TheWorld(Table(5, 5,List()), Some(Robot(0,0, North)))

        val result = Objects.getObjectPosition(world)
        assert(result === Some((0, 1)))
      }
    }

    describe("when robot the robot is placed facing South") {
      it("returns position of next object") {
        val world = TheWorld(Table(5, 5,List()), Some(Robot(0,1, South)))

        val result = Objects.getObjectPosition(world)
        assert(result === Some((0, 0)))
      }
    }

    describe("when robot the robot is placed facing East") {
      it("returns position of next object") {
        val world = TheWorld(Table(5, 5,List()), Some(Robot(0,0, East)))

        val result = Objects.getObjectPosition(world)
        assert(result === Some((1, 0)))
      }
    }

    describe("when robot the robot is placed facing West") {
      it("returns position of next object") {
        val world = TheWorld(Table(5, 5,List()), Some(Robot(1,0, West)))

        val result = Objects.getObjectPosition(world)
        assert(result === Some((0, 0)))
      }
    }
  }
}