import java.awt.{Robot, MouseInfo}
import java.awt.event.InputEvent

object Main extends App{
  val robot = new Robot()
  val leftclick = InputEvent.BUTTON1_DOWN_MASK
  robot.setAutoDelay(10)

  def diff(vectors: Seq[Vector2]): Seq[Vector2] = vectors zip(vectors.drop(1)) map{
    case (v1, v2) => v1 - v2
  }

  def go(history:Seq[Vector2]):Unit = {

    robot.mousePress(leftclick)
    robot.mouseRelease(leftclick)

    val x = MouseInfo.getPointerInfo.getLocation.x
    val y = MouseInfo.getPointerInfo.getLocation.y

    diff(history).map(_.magnitude).foldLeft(0d)(_ + _) match{
      case dis if math.abs(dis) < 10 => go(Vector2(x,y) +: history.take(4))
      case _ => ()
    }

  }

  val x = MouseInfo.getPointerInfo.getLocation.x
  val y = MouseInfo.getPointerInfo.getLocation.y
  go(List.fill(5)(Vector2(x,y)))
}
