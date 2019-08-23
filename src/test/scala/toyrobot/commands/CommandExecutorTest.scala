package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{TheWorld, Table, Robot}


class CommandExecutorTest extends FunSpec with TypeCheckedTripleEquals {
  describe("executeCommand") {

    describe("when valid place command") {
      it("returns placed robot") {
        val command = PlaceCommand(PlaceArgs(6,6,North))
        val currentWorld = TheWorld(Table(5,5,List()), Some(Robot(1, 1, South)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (currentWorld, None))
      }
    }

    describe("when invalid place command") {
      it("new world returned") {
        val command = PlaceCommand(PlaceArgs(1,1,North))
        val currentWorld = TheWorld(Table(5,5,List()), None)

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (TheWorld(Table(5,5,List()), Some(Robot(1, 1, North))), None))
      }
    }

    describe("when invalid move command") {
      it("current world returned") {
        val command = MoveCommand
        val currentWorld = TheWorld(Table(5,5,List()), Some(Robot(4, 4, North)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (currentWorld, None))
      }
    }

    describe("when valid move command") {
      it("new world returned") {
        val command = MoveCommand
        val currentWorld = TheWorld(Table(5,5,List()), Some(Robot(4, 3, North)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (TheWorld(Table(5,5,List()), Some(Robot(4, 4, North))), None))
      }
    }


    describe("when invalid spot to place object") {
      it("current world returned") {
        val command = PlaceObjectCommand
        val currentWorld = TheWorld(Table(5,5,List()), Some(Robot(4, 4, North)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (currentWorld, None))
      }
    }

    describe("when trying to place object on same spot") {
      it("only one object adderd") {
        val currentWorld = TheWorld(Table(5,5,List()), Some(Robot(0, 0, North)))

        val result1 = CommandExecutor.executeCommand(PlaceObjectCommand, currentWorld)
        val result2 = CommandExecutor.executeCommand(PlaceObjectCommand, result1._1)
        assert(result2 === (TheWorld(Table(5,5,List((0,1))), Some(Robot(0, 0, North))), None))
      }
    }

    describe("when valid spot to place object") {
      it("new world returned with object") {
        val command = PlaceObjectCommand
        val currentWorld = TheWorld(Table(5,5,List()), Some(Robot(4, 3, North)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (TheWorld(Table(5,5,List((4,4))), Some(Robot(4, 3, North))), None))
      }

      it("can add multiple objects") {
        val currentWorld = TheWorld(Table(5,5,List()), Some(Robot(0, 0, North)))

        val firstPlaceObjectResult = CommandExecutor.executeCommand(PlaceObjectCommand, currentWorld)
        val rightResult = CommandExecutor.executeCommand(RightCommand, firstPlaceObjectResult._1)
        val secondPlaceObjectResult = CommandExecutor.executeCommand(PlaceObjectCommand, rightResult._1)

        assert(secondPlaceObjectResult === (TheWorld(Table(5,5,List((0,1), (1,0))), Some(Robot(0, 0, East))), None))
      }
    }

    describe("when moving robot onto object") {
      it("current world returned") {
        val currentWorld = TheWorld(Table(5,5,List( (0, 1) )), Some(Robot(0, 0, North)))

        val result = CommandExecutor.executeCommand(MoveCommand, currentWorld)
        assert(result === (currentWorld, None))
      }
    }
  }
}