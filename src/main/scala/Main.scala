import java.awt._
import java.awt.event.InputEvent

object Main extends App{
  val robot = new Robot()
  val leftclick = InputEvent.BUTTON1_DOWN_MASK

  robot.setAutoDelay(50)
  robot.mouseMove(200,300)

  def go(i:Int):Unit = i match {
    case i if i < 100000 =>{
      MouseInfo.getPointerInfo 
      //robot.mousePress(leftclick)
      //robot.mouseRelease(leftclick)
      println(MouseInfo.getPointerInfo.getLocation.x)
      println(MouseInfo.getPointerInfo.getLocation.y)
      go(i+1)
    }
    case _ => ()
  }
  go(0)
}
