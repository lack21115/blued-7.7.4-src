package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.APNGWriter;
import com.blued.android.core.image.apng.io.Writer;
import java.io.IOException;

public class StillFrame extends Frame<APNGReader, APNGWriter> {
  public StillFrame(APNGReader paramAPNGReader) {
    super(paramAPNGReader);
  }
  
  public Bitmap a(Canvas paramCanvas, Paint paramPaint, int paramInt, Bitmap paramBitmap, APNGWriter paramAPNGWriter) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = false;
    options.inSampleSize = paramInt;
    options.inMutable = true;
    options.inBitmap = paramBitmap;
    try {
      this.g.reset();
      paramBitmap = BitmapFactory.decodeStream(this.g.t_(), null, options);
      try {
        if (a || paramBitmap != null) {
          paramPaint.setXfermode(null);
          paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, paramPaint);
          return paramBitmap;
        } 
        throw new AssertionError();
      } catch (IOException null) {
        Bitmap bitmap = paramBitmap;
      } 
    } catch (IOException iOException) {
      paramPaint = null;
    } 
    iOException.printStackTrace();
    return (Bitmap)paramPaint;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\StillFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */