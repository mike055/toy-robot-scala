package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{PlacedRobot, Table, UnPlacedRobot}


class PlaceTest extends FunSpec with TypeCheckedTripleEquals {
  val testTable = Table(5,5)

  describe("placeRobot") {

    describe("when a valid place on the table") {
      it("returns a placed robot") {

        val result = Place.placeRobot(PlaceArgs(1, 1, North), UnPlacedRobot(), Table(5, 5))
        assert(result === PlacedRobot(1, 1, North))
      }
    }

    describe("when an invalid place on the table") {
      it("returns an unplaced robot") {

        val result = Place.placeRobot(PlaceArgs(0, 0, North), UnPlacedRobot(), Table(5, 5))
        assert(result === UnPlacedRobot())
      }
    }
  }
}