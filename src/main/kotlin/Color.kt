import kotlin.random.Random

class Color(private val baseColor:String, var alpha: Int=255){
    override fun toString(): String {
        return baseColor + alpha.toString(16)
    }
    companion object {
        private val colorsList = listOf(
            red()
            , pink()
            , purple()
            , deepPurple()
            , indigo()
            , blue()
            , lightBlue()
            , cyan()
            , teal()
            , green()
            , lightGreen()
            , lime()
            , yellow()
            , amber()
            , orange()
            , deepOrange()
        )
        fun red() = Color("#FFCDD2")
        fun pink() = Color("#F8BBD0")
        fun purple() = Color("#E1BEE7")
        fun deepPurple() = Color("#D1C4E9")
        fun indigo() = Color("#C5CAE9")
        fun blue() = Color("#BBDEFB")
        fun lightBlue() = Color("#B3E5FC")
        fun cyan() = Color("#B2EBF2")
        fun teal() = Color("#B2DFDB")
        fun green() = Color("#C8E6C9")
        fun lightGreen() = Color("#DCEDC8")
        fun lime() = Color("#F0F4C3")
        fun yellow() = Color("#FFF9C4")
        fun amber() = Color("#FFECB3")
        fun orange() = Color("#FFE0B2")
        fun deepOrange() = Color("#FFCCBC")

        fun rand() = colorsList.elementAt(Random.nextInt(0, colorsList.size-1))
    }

}