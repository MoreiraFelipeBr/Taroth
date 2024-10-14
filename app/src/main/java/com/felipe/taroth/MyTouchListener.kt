package com.felipe.taroth

import android.view.MotionEvent
import android.view.View

class MyTouchListener : View.OnTouchListener {

    private var lastX = 0f
    private var lastY = 0f
    private  var newX = 0f
    private  var newY :Float = 0f
    private  var mx :Float = 0f
    private  var  my :Float = 0f


    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        if (event != null) {
            mx = event.x - lastX
            my = event.y - lastY

            // Atualizar lastX e lastY no primeiro toque ou verificar nulidade
            if (event.action == MotionEvent.ACTION_DOWN || view == null) {
                lastX = event.x
                lastY = event.y
                return true // Consumido para manipulação inicial do toque
            }

            newX = view.x + mx
            newY = view.y + my



            view.setX(newX)
            view.setY(newY)

            /*lastX = event.x
            lastY = event.y*/

            return true
        } else {
            return false
        }
    }
}