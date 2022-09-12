package particles

import org.w3c.dom.CanvasRenderingContext2D

class Linker(private val particles: List<Particle>,private val context: CanvasRenderingContext2D){

    fun drawTo(particle: Particle) {
        particle.linksCount = 0
        particles.forEach {
            if (particle.isNear(it)) {
                context.beginPath()
                context.moveTo(particle.position.x, particle.position.y)
                context.lineTo(it.position.x, it.position.y)
                context.strokeStyle = "#b3e5fc11"
                context.stroke()
                context.closePath()
                particle.linksCount++
            }
        }
    }

}
