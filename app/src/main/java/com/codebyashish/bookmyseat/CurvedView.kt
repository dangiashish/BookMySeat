package com.codebyashish.bookmyseat

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class CurvedView : View {
    private var paint: Paint? = null
    private var paint2: Paint? = null
    private var path: Path? = null
    private var path2: Path? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        paint = Paint()
        paint!!.isAntiAlias = true
        paint!!.style = Paint.Style.FILL
        paint!!.color = resources.getColor(android.R.color.darker_gray)
        paint2 = Paint()
        paint2!!.isAntiAlias = true
        paint2!!.style = Paint.Style.FILL
        paint2!!.color = resources.getColor(R.color.white)
        path = Path()
        path2 = Path()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width
        val height = 150
        path!!.moveTo(0f, height.toFloat())
        path2!!.moveTo(50f, height.toFloat())
        path!!.quadTo(
            (width / 2).toFloat(),
            height.toFloat() / 2 - 200,
            width.toFloat(),
            height.toFloat()
        )
        path2!!.quadTo(
            (width / 2).toFloat(),
            height.toFloat() / 2 - 150,
            (width - 50).toFloat(),
            height.toFloat()
        )
        canvas.drawPath(path!!, paint!!)
        canvas.drawPath(path2!!, paint2!!)
    }
}
