import kotlinx.html.dom.append
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.*
import org.w3c.dom.HTMLCanvasElement
import particles.ParticlesDrawer


fun main() {
    document.body!!.append {
        nav{
            classes = setOf("indigo")
            div{
                classes= setOf("nav-wrapper")
                a {
                    classes = setOf("brand-logo")
                    i {
                        classes = setOf("large material-icons")
                        +"battery_charging_full"
                    }
                    + "XambraFun"
                }
            }
        }
        div {
            classes = setOf("container")
            h2{
                classes = setOf("indigo-text","darken-4")
                +"Linked Particles"
            }
            div {
                classes = setOf("row")
                div {
                    classes = setOf("col s9")
                    canvas {
                        classes = setOf("z-depth-3")
                        id = "screen"
                        width = "600px"
                        height = "600px"
                        style = "filter:blur(1.5px)"

                    }
                }
            }

        }

    }
    val canvas = document.getElementById("screen") as HTMLCanvasElement
    val particles = ParticlesDrawer(canvas = canvas)


    particles.start()


}
