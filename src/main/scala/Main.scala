import java.awt.Robot
import java.awt.event.InputEvent

object Main extends App{
  val robot = new Robot()
  val leftclick = InputEvent.BUTTON1_DOWN_MASK
  robot.mouseMove(100,100)
  def go:Unit = {
    robot.mousePress(leftclick)
    robot.mouseRelease(leftclick)
    go
  }
  go
}
