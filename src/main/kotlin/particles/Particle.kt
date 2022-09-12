package particles


import Color
import Position
import org.w3c.dom.CanvasRenderingContext2D
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random


class Particle(
    private val size:Double
    , private val color: Color
    , private val context:CanvasRenderingContext2D
    , var position: Position
    , private var acceleration: Position
){

    private val attractionSize:Double = size * 10
    var linksCount = 0

    private fun drawCore(){
        context.beginPath()
        color.alpha =Random.nextInt(100,255)
        context.fillStyle = color
        context.arc(position.x, position.y, 1.0, 0.0, 2 * PI)
        context.fill()
        context.closePath()
    }
    private fun drawParticle(){
        context.beginPath()
        context.fillStyle = color
        context.arc(position.x, position.y, size, 0.0, 2 * PI)
        context.fill()
        context.closePath()
    }
    private fun changeDirection(){
        if(position.x<=0 || position.x>=context.canvas.width)
            acceleration.x *= -1
        if(position.y<=0 || position.y>=context.canvas.height)
            acceleration.y *= -1
    }
    fun draw(){
        color.alpha = linksCount * 50 + 10
        position += acceleration

        drawParticle()
        drawCore()
        changeDirection()
    }
    fun isNear(particle: Particle):Boolean{
        val distance = sqrt((particle.position.x - (position.x+ attractionSize)).pow(2)
                             + (particle.position.y - (position.y+ attractionSize)).pow(2))

        return distance <= particle.size + size + attractionSize
    }

    companion object{
        fun rand(minSIze:Int = 1
                 , maxSize:Int = 100
                 , context:CanvasRenderingContext2D):Particle {

            val position = Position.rand(max=Position(context.canvas.width.toDouble(), context.canvas.height.toDouble()))

            val acceleration = Position.rand(min = Position(-.20, -.20), max = Position(.20, .20))

            return Particle(
                 Random.nextInt(minSIze, maxSize).toDouble()
                , Color.rand()
                ,context
                ,position
                ,acceleration)
        }
    }
}
