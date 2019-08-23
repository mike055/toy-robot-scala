package toyrobot.parser

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.commands._
import toyrobot.parser.CommandParser._


class CommandParserTest extends FunSpec with TypeCheckedTripleEquals {
  describe("parsedCommandOrNothing") {

    describe("when empty string") {
      it("should return none") {
        val result = parsedCommandOrNothing("")
        assert(result === None)
      }
    }

    describe("move command") {
      describe("when string is MOVE") {
        it("should return move command") {
          val result = parsedCommandOrNothing("MOVE")
          assert(result === Some(MoveCommand))
        }
      }

      describe("when string is MOVE with trailing spaces") {
        it("should return move command") {
          val result = parsedCommandOrNothing("MOVE ")
          assert(result === Some(MoveCommand))
        }
      }

      describe("when string is MOVE with leading spaces") {
        it("should return move command") {
          val result = parsedCommandOrNothing(" MOVE")
          assert(result === Some(MoveCommand))
        }
      }

      describe("when string contains MOVE and other characters") {
        it("should return none") {
          val result = parsedCommandOrNothing("I WANT TO MOVE PLEASE")
          assert(result === None)
        }
      }
    }

    describe("left command") {
      describe("when string is LEFT") {
        it("should return left command") {
          val result = parsedCommandOrNothing("LEFT")
          assert(result === Some(LeftCommand))
        }
      }

      describe("when string is LEFT with trailing spaces") {
        it("should return left command") {
          val result = parsedCommandOrNothing("LEFT ")
          assert(result === Some(LeftCommand))
        }
      }

      describe("when string is LEFT with leading spaces") {
        it("should return left command") {
          val result = parsedCommandOrNothing(" LEFT")
          assert(result === Some(LeftCommand))
        }
      }

      describe("when string contains LEFT and other characters") {
        it("should return none") {
          val result = parsedCommandOrNothing("I WANT TO LEFT PLEASE")
          assert(result === None)
        }
      }
    }

    describe("right command") {
      describe("when string is RIGHT") {
        it("should return right command") {
          val result = parsedCommandOrNothing("RIGHT")
          assert(result === Some(RightCommand))
        }
      }

      describe("when string is RIGHT with trailing spaces") {
        it("should return right command") {
          val result = parsedCommandOrNothing("RIGHT ")
          assert(result === Some(RightCommand))
        }
      }

      describe("when string is RIGHT with leading spaces") {
        it("should return right command") {
          val result = parsedCommandOrNothing(" RIGHT")
          assert(result === Some(RightCommand))
        }
      }

      describe("when string contains RIGHT and other characters") {
        it("should return none") {
          val result = parsedCommandOrNothing("I WANT TO RIGHT PLEASE")
          assert(result === None)
        }
      }
    }

    describe("report command") {
      describe("when string is REPORT") {
        it("should return report command") {
          val result = parsedCommandOrNothing("REPORT")
          assert(result === Some(ReportCommand))
        }
      }

      describe("when string is REPORT with trailing spaces") {
        it("should return report command") {
          val result = parsedCommandOrNothing("REPORT ")
          assert(result === Some(ReportCommand))
        }
      }

      describe("when string is REPORT with leading spaces") {
        it("should return report command") {
          val result = parsedCommandOrNothing(" REPORT")
          assert(result === Some(ReportCommand))
        }
      }

      describe("when string contains REPORT and other characters") {
        it("should return none") {
          val result = parsedCommandOrNothing("I WANT TO REPORT PLEASE")
          assert(result === None)
        }
      }
    }

    describe("map command") {
      describe("when string is MAP") {
        it("should return map command") {
          val result = parsedCommandOrNothing("MAP")
          assert(result === Some(MapCommand))
        }
      }

      describe("when string is MAP with trailing spaces") {
        it("should return map command") {
          val result = parsedCommandOrNothing("MAP ")
          assert(result === Some(MapCommand))
        }
      }

      describe("when string is MAP with leading spaces") {
        it("should return map command") {
          val result = parsedCommandOrNothing(" MAP")
          assert(result === Some(MapCommand))
        }
      }

      describe("when string contains MAP and other characters") {
        it("should return none") {
          val result = parsedCommandOrNothing("I WANT TO MAP PLEASE")
          assert(result === None)
        }
      }
    }

    describe("place object command") {
      describe("when string is PLACE_OBJECT") {
        it("should return place object command") {
          val result = parsedCommandOrNothing("PLACE_OBJECT")
          assert(result === Some(PlaceObjectCommand))
        }
      }

      describe("when string is PLACE_OBJECT with trailing spaces") {
        it("should return right command") {
          val result = parsedCommandOrNothing("PLACE_OBJECT ")
          assert(result === Some(PlaceObjectCommand))
        }
      }

      describe("when string is PLACE_OBJECT with leading spaces") {
        it("should return right command") {
          val result = parsedCommandOrNothing(" PLACE_OBJECT")
          assert(result === Some(PlaceObjectCommand))
        }
      }

      describe("when string contains PLACE_OBJECT and other characters") {
        it("should return none") {
          val result = parsedCommandOrNothing("I WANT TO PLACE_OBJECT PLEASE")
          assert(result === None)
        }
      }
    }

    describe("place command") {
      describe("when string is PLACE 1,2,EAST") {
        it("should return place command with args") {
          val result = parsedCommandOrNothing("PLACE 1,2,EAST")
          assert(result === Some(PlaceCommand(PlaceArgs(1,2,East))))
        }
      }

      describe("when PLACE with no args") {
        it("should return None") {
          val result = parsedCommandOrNothing("PLACE")
          assert(result === None)
        }
      }

      describe("when PLACE with invalid args") {
        it("should return None") {
          val result = parsedCommandOrNothing("PLACE HELLO")
          assert(result === None)
        }
      }

      describe("when PLACE with invalid X co-ord") {
        it("should return None") {
          val result = parsedCommandOrNothing("PLACE A,2,EAST")
          assert(result === None)
        }
      }

      describe("when PLACE with invalid Y co-ord") {
        it("should return None") {
          val result = parsedCommandOrNothing("PLACE 2,A,EAST")
          assert(result === None)
        }
      }

      describe("when PLACE with invalid direction") {
        it("should return None") {
          val result = parsedCommandOrNothing("PLACE 2,2,BLAH")
          assert(result === None)
        }
      }
    }
  }
}
