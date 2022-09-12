package particles

import AbstractDrawer
import org.w3c.dom.HTMLCanvasElement

class ParticlesDrawer(private val qtdMAx:Int = 200, canvas: HTMLCanvasElement): AbstractDrawer(canvas) {

    private val particles  = (0..qtdMAx).map { Particle.rand(maxSize = 5, context=context) }
    private val linker = Linker(particles,context)

    private fun fillCanvas(){
        context.fillStyle = "#000051"
        context.fillRect(0.0,0.0,canvas.width.toDouble(),canvas.height.toDouble())
    }

    override fun draw(){
        clear()
        fillCanvas()

        particles.forEach {
            it.draw()
            linker.drawTo(it)
        }
    }
}