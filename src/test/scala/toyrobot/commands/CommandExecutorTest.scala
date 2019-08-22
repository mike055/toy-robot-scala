package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{TheWorld, Table, Robot}


class CommandExecutorTest extends FunSpec with TypeCheckedTripleEquals {
  describe("executeCommand") {

    describe("when valid place command") {
      it("returns placed robot") {
        val command = PlaceCommand(PlaceArgs(6,6,North))
        val currentWorld = TheWorld(Table(5,5), Some(Robot(1, 1, South)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (currentWorld, None))
      }
    }

    describe("when invalid place command") {
      it("new world returned") {
        val command = PlaceCommand(PlaceArgs(1,1,North))
        val currentWorld = TheWorld(Table(5,5), None)

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (TheWorld(Table(5,5), Some(Robot(1, 1, North))), None))
      }
    }

    describe("when invalid move command") {
      it("current world returned") {
        val command = MoveCommand
        val currentWorld = TheWorld(Table(5,5), Some(Robot(4, 4, North)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (currentWorld, None))
      }
    }

    describe("when valid move command") {
      it("new world returned") {
        val command = MoveCommand
        val currentWorld = TheWorld(Table(5,5), Some(Robot(4, 3, North)))

        val result = CommandExecutor.executeCommand(command, currentWorld)
        assert(result === (TheWorld(Table(5,5), Some(Robot(4, 4, North))), None))
      }
    }
  }
}