package toyrobot.commands

import toyrobot.models.Table

package object Position {

  def positionIsValid(x: Int, y: Int, table: Table): Boolean = {

    val xIsValid = (x >= 0 & x < table.sizeX)
    val yIsValid = (y >= 0 & y < table.sizeY)

    return xIsValid & yIsValid
  }
}
