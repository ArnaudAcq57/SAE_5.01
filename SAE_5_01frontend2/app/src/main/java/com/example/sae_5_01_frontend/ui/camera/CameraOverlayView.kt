package com.example.sae_5_01_frontend.ui.camera

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class CameraOverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Pour l'instant, on ne dessine rien.
        // Tu ajouteras les contours/détections plus tard.
    }
}
