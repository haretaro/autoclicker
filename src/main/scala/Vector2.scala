case class Vector2(x:Double, y:Double){
  def +(that: Vector2):Vector2 = Vector2(x + that.x, y + that.y)
  def -(that: Vector2):Vector2 = Vector2(x - that.x, y - that.y)

  def angle: Double = math.atan2(y,x)

  def magnitude: Double = math.sqrt(x * x + y * y)

  def normalized: Vector2 = {
    val m = magnitude
    Vector2(x/m, y/m)
  }

}
