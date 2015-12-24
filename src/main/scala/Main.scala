import java.awt.{Robot, MouseInfo}
import java.awt.event.InputEvent

object Main extends App{
  val robot = new Robot()
  val leftclick = InputEvent.BUTTON1_DOWN_MASK
  robot.setAutoDelay(50)
  robot.mouseMove(200,300)

  def diff(vectors: Seq[Vector2]): Seq[Vector2] = vectors zip(vectors.drop(1)) map{
    case (v1, v2) => v1 - v2
  }

  def go(i:Int, history:Seq[Vector2]):Unit = i match {
    case i if i < 10000 =>{
      //robot.mousePress(leftclick)
      //robot.mouseRelease(leftclick)
      val x = MouseInfo.getPointerInfo.getLocation.x
      val y = MouseInfo.getPointerInfo.getLocation.y

      diff(history).map(_.angle).foldLeft(0d)(_ + _) match{
        case ang if ang != 0 => println(ang)
        case _ => ()
      }
      go(i+1, Vector2(x,y) +: history.take(4))
    }
    case _ => ()
  }
  go(0, List.fill(5)(Vector2(0,0)))
}
