package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.Table


class PositionTest extends FunSpec with TypeCheckedTripleEquals {
  describe("positionIsValid") {

    describe("when the table has no positions") {
      it("returns false when 0,0") {
        val result = Position.positionIsValid(0,0, Table(0, 0))
        assert(result === false)
      }

      it("returns false when 1,0") {
        val result = Position.positionIsValid(0,0, Table(1, 0))
        assert(result === false)
      }

      it("returns false when 0,1") {
        val result = Position.positionIsValid(0,0, Table(0, 1))
        assert(result === false)
      }
    }

    describe("when position exists on 5,5 table") {

      it("returns true") {

        for( x <- 0 to 4){
          for( y <- 0 to 4) {
            val result = Position.positionIsValid(x, y, Table(5, 5))
            assert(result === true)
          }
        }
      }
    }

    describe("when position does not exist on 5,5 table") {

      it("returns false, when 4, 5") {
        val result = Position.positionIsValid(4,5, Table(5, 5))
        assert(result === false)
      }

      it("returns false, when 5, 4") {
        val result = Position.positionIsValid(5, 4, Table(5, 5))
        assert(result === false)
      }
    }
  }
}