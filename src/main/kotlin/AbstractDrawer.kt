import kotlinx.browser.window
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

abstract class AbstractDrawer(protected val canvas: HTMLCanvasElement) {
    protected val context = canvas.getContext("2d") as CanvasRenderingContext2D
    protected abstract fun draw()

    protected fun clear(){
        context.clearRect(0.0,0.0,canvas.width.toDouble(),canvas.height.toDouble())
    }
    fun start(){
        draw()
        window.requestAnimationFrame {start()}
    }

}