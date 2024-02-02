package com.codebyashish.bookmyseat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class CurvedView extends View {
    private Paint paint, paint2;
    private Path path, path2;

    public CurvedView(Context context) {
        super(context);
        init();
    }

    public CurvedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CurvedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(android.R.color.darker_gray)); // Change color as needed

        paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(getResources().getColor(android.R.color.white)); // Change color as needed

        path = new Path();
        path2 = new Path();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = 150;

        path.moveTo(0, height);
        path2.moveTo( 50,  height);


        path.quadTo((float) (width/2), (float) height/2 -200, (float) width, height);
        path2.quadTo((float) (width/2), (float) height/2 -150, width - 50, height);


        canvas.drawPath(path, paint);

        canvas.drawPath(path2, paint2);
    }
}
