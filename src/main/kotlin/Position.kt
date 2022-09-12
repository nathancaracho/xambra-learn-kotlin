import kotlin.random.Random

class Position(var x:Double=0.0,var y:Double=0.0) {
    operator fun plusAssign(other: Position){
        this.x += other.x
        this.y += other.y
    }

    companion object{

        fun rand(min: Position = Position(), max: Position) = Position(
            Random.nextDouble(min.x, max.x), Random.nextDouble(min.y, max.y)
        )
    }

}