import java.awt.{Robot, MouseInfo}
import java.awt.event.InputEvent

object Main extends App{
  val robot = new Robot()
  val leftclick = InputEvent.BUTTON1_DOWN_MASK
  robot.setAutoDelay(50)
  robot.mouseMove(200,300)

  def go(i:Int, history:List[Vector2]):Unit = i match {
    case i if i < 10000 =>{
      //robot.mousePress(leftclick)
      //robot.mouseRelease(leftclick)
      val x = MouseInfo.getPointerInfo.getLocation.x
      val y = MouseInfo.getPointerInfo.getLocation.y
      println((x,y))
      go(i+1, Vector2(x,y) :: history)
    }
    case _ => ()
  }
  go(0, List.fill(10)(Vector2(0,0)))
}
