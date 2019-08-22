package toyrobot.commands

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.FunSpec
import toyrobot.models.{TheWorld, Table, Robot}


class ValidationTest extends FunSpec with TypeCheckedTripleEquals {
  describe("isCurrentWorldValid") {

    describe("when the robot does not exist") {
      it("returns true") {
        val result = Validation.isCurrentWorldValid( TheWorld(Table(0, 0), None))
        assert(result === true)
      }
    }

    describe("when the table has no positions") {
      it("returns false when 0,0") {
        val result = Validation.isCurrentWorldValid( TheWorld(Table(0, 0), Some(Robot(0,0, North))))
        assert(result === false)
      }

      it("returns false when 1,0") {
        val result = Validation.isCurrentWorldValid( TheWorld(Table(1, 0), Some(Robot(0,0, North))))
        assert(result === false)
      }

      it("returns false when 0,1") {
        val result = Validation.isCurrentWorldValid( TheWorld(Table(0, 1), Some(Robot(0,0, North))))
        assert(result === false)
      }
    }

    describe("when position exists on 5,5 table") {

      it("returns true") {

        for( x <- 0 to 4){
          for( y <- 0 to 4) {
            val result = Validation.isCurrentWorldValid( TheWorld(Table(5, 5), Some(Robot(x,y, North))))
            assert(result === true)
          }
        }
      }
    }

    describe("when position does not exist on 5,5 table") {

      it("returns false, when 4, 5") {
        val result = Validation.isCurrentWorldValid( TheWorld(Table(5, 5), Some(Robot(4,5, North))))
        assert(result === false)
      }

      it("returns false, when 5, 4") {
        val result = Validation.isCurrentWorldValid( TheWorld(Table(5, 5), Some(Robot(5,4, North))))
        assert(result === false)
      }
    }
  }
}