package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{Robot, Table}


class PlaceTest extends FunSpec with TypeCheckedTripleEquals {
  val testTable = Table(5,5)

  describe("placeRobot") {

    describe("when a valid place on the table") {
      it("returns a placed robot") {

        val result = Place.placeRobot(PlaceArgs(1, 1, North), None, Table(5, 5))
        assert(result === Some(Robot(1, 1, North)))
      }
    }

    describe("when an invalid place on the table") {
      it("returns an unplaced robot") {

        val result = Place.placeRobot(PlaceArgs(6, 6, North), None, Table(5, 5))
        assert(result === None)
      }
    }
  }
}