package mx.tecnm.tepic.ladm_u2_practica1_presentaciondiademuertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class Lienzo(p:MainActivity):View(p) {
    val principal = p
    val s = 250f
    var posXAlebrije = -600f
    var posYAlebrije = -600f
    var posXFantasma = 3800f
    val altarsito = BitmapFactory.decodeResource(principal.resources, R.drawable.altar)
    val altar = BitmapFactory.decodeResource(principal.resources, R.drawable.altarsito)
    val tumbita = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbita)
    val tumbita2 = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbita2)
    val tumbachikita = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbachikita)
    val tumbachikitita = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbachikititita)
    val tumbamaschiquita = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbamaschiquita)
    val tumbasuperchikita = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbasuperchikita)
    val alebrije = BitmapFactory.decodeResource(principal.resources, R.drawable.alebrije1)
    val fantasmita = BitmapFactory.decodeResource(principal.resources, R.drawable.fantasmita)

    val picadaAlebrije = object : CountDownTimer(2000,80){
        override fun onTick(p0: Long) {
            posXAlebrije += 5
            posYAlebrije += 5
            if(posYAlebrije > 1000) {
                posXAlebrije = -600f
                posYAlebrije = -600f
            }
            invalidate()
        }

        override fun onFinish() {
            start()
        }
    }

    val movimientoFantasma = object : CountDownTimer(2000,80){
        override fun onTick(p0: Long) {
            posXFantasma -= 12
            if(posXFantasma < - 250) {
                posXFantasma = 3800f
            }
            invalidate()
        }

        override fun onFinish() {
            start()
        }
    }



    init {
        picadaAlebrije.start()
        movimientoFantasma.start()
    }


    override fun onDraw(c: Canvas?) {
        super.onDraw(c)
        var p = Paint()
        c!!.drawColor(Color.rgb(37,40,80)); //FONDO

        p.color = Color.GREEN;
        c.drawOval(-20f, 600f + s, 1600f + s, 1300f + s, p) //MONTAÑA IZQUIERDA
        p.style = Paint.Style.STROKE
        p.strokeWidth = 4.0f
        p.color = Color.GREEN
        c.drawOval(-20f, 600f + s, 1600f + s, 1300f + s, p) //Contorno cyan MONTAÑA izquierda

        p.color = Color.GREEN;
        p.style = Paint.Style.FILL
        c.drawOval(900f + s, 500f + s, 2500f + s, 1300f + s, p) //MONTAÑA DERECHA
        p.style = Paint.Style.STROKE
        p.strokeWidth = 4.0f
        p.color = Color.GREEN
        c.drawOval(900f + s, 500f + s, 2500f + s, 1300f + s, p) //Contorno cyan MONTAÑA derecha

        p.color = Color.rgb(180, 114, 20)
        p.style = Paint.Style.FILL
        c.drawRect(290f + s, 570f + s, 340f + s, 630f + s, p) //Tronco Arbol1
        p.color = Color.rgb(255,128,0)
        c.drawOval(240f + s, 510f + s, 390f + s, 570f + s, p)  //HOJA INFERIOR ARBOL1
        c.drawOval(265f + s, 460f + s, 365f + s, 530f + s, p) //HOJA SUPERIOR ARBOL1

        p.color = Color.rgb(180, 114, 20)
        c.drawRect(1350f + s, 400f + s, 1450f + s, 550f + s, p) //Tronco Arbol2
        p.color = Color.rgb(255,128,0)
        c.drawOval(1250f + s, 280f + s, 1550f + s, 450f + s, p)  //HOJA INFERIOR ARBOL2
        c.drawOval(1300f + s, 180f + s, 1500f + s, 370f + s, p) //HOJA SUPERIOR ARBOL2

        p.color = Color.WHITE
        c.drawCircle(160f, 210f, 100f, p) //LUNA
        p.color = Color.rgb(37,40,80)
        c.drawCircle(195f, 190f, 70f, p) //HOYITO LUNA

        p.color = Color.WHITE
        c.drawOval(400f + s, 50f + s, 700f + s, 150f + s, p)
        c.drawOval(300f + s, 0f + s, 600f + s, 100f + s, p) //Nube 1

        p.color = Color.WHITE
        c.drawOval(1300f + s, -50f + s, 1500f + s, 50f + s, p)
        c.drawOval(1200f + s, -100f + s, 1400f + s, 0f + s, p) //Nube2

        p.color = Color.WHITE
        c.drawOval(2000f + s, -100f + s, 2200f + s, 0f + s, p)
        c.drawOval(1900f + s, -150f + s, 2100f + s, -50f + s, p) //Nub3

        c.drawBitmap(altar,60f,650f,p)
        c.drawBitmap(altarsito,1800f,300f,p)
        c.drawBitmap(tumbita2,560f,750f,p)
        c.drawBitmap(tumbachikitita,900f,550f,p)
        c.drawBitmap(tumbachikita,1150f,750f,p)
        c.drawBitmap(tumbamaschiquita,1400f,700f,p)
        c.drawBitmap(tumbita,1800f,700f,p)
        c.drawBitmap(tumbasuperchikita,2350f,700f,p)
        c.drawBitmap(fantasmita,posXFantasma,150f,p)
        c.drawBitmap(alebrije,posXAlebrije,posYAlebrije,p)



    }
}