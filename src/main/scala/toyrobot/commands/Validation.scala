package toyrobot.commands

import toyrobot.models.{TheWorld, Robot, Table}

package object Validation {

  def isCurrentWorldValid(theCurrentWorld: TheWorld): Boolean = {
    return robotInBoundsOfTable(theCurrentWorld) &
      allObjectsAreValidOnTable(theCurrentWorld) &
      isRobotNotCrashingIntoObject(theCurrentWorld)
  }

  def robotInBoundsOfTable(theCurrentWorld: TheWorld): Boolean = {

    theCurrentWorld.robot match {
      case None => true
      case Some(Robot(x, y, _)) => {
        inBoundsOfTable(x, y, theCurrentWorld.table)
      }
    }
  }

  def allObjectsAreValidOnTable(theCurrentWorld: TheWorld): Boolean = {

    val allObjectsOnTable = theCurrentWorld.table.objects.forall(
      ( coords: (Int, Int) ) => inBoundsOfTable(coords._1, coords._2, theCurrentWorld.table)
    )

    val allObjectCoordsUnique = theCurrentWorld.table.objects.forall(
      ( coords: (Int, Int) ) => isUniqueCoords(coords, theCurrentWorld.table.objects)
    )

    return allObjectsOnTable & allObjectCoordsUnique
  }

  def isUniqueCoords(coords: (Int, Int), objects: List[(Int, Int)]): Boolean = {
    return objects.filter( c => c == coords).length == 1
  }


  def inBoundsOfTable(x: Int, y: Int, table: Table): Boolean = {
    x >= 0 &
      x < table.sizeX &
      y >= 0 &
      y < table.sizeY
  }

  def isRobotNotCrashingIntoObject(theCurrentWorld: TheWorld): Boolean = {
    theCurrentWorld.robot match {
      case None => true
      case Some(Robot(x, y, _)) => {
        theCurrentWorld.table.objects.filter( c => c == (x, y)).length == 0
      }
    }
  }
}
