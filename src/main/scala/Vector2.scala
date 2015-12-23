case class Vector2(x:Double, y:Double){
  def +(that: Vector2):Vector2 = Vector2(x + that.x, y + that.y)
  def -(that: Vector2):Vector2 = Vector2(x - that.x, y + that.y)

  def angle: Double = math.cos(x) + math.sin(x)
}
