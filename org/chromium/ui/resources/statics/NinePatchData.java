package org.chromium.ui.resources.statics;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class NinePatchData {
  public Rect mAperture;
  
  private final int[] mDivX;
  
  private final int[] mDivY;
  
  private final int mHeight;
  
  public final Rect mPadding;
  
  private final int mWidth;
  
  private NinePatchData(int paramInt1, int paramInt2, Rect paramRect, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mPadding = new Rect(paramRect.left, paramRect.top, this.mWidth - paramRect.right, this.mHeight - paramRect.bottom);
    this.mDivX = new int[paramArrayOfint1.length];
    this.mDivY = new int[paramArrayOfint2.length];
    System.arraycopy(paramArrayOfint1, 0, this.mDivX, 0, paramArrayOfint1.length);
    System.arraycopy(paramArrayOfint2, 0, this.mDivY, 0, paramArrayOfint2.length);
    this.mAperture = new Rect(this.mDivX[0], this.mDivY[0], this.mDivX[1], this.mDivY[1]);
  }
  
  public static NinePatchData create(Bitmap paramBitmap) {
    if (paramBitmap == null)
      return null; 
    try {
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      if (arrayOfByte != null) {
        if (!NinePatch.isNinePatchChunk(arrayOfByte))
          return null; 
        ByteBuffer byteBuffer = ByteBuffer.wrap(arrayOfByte).order(ByteOrder.nativeOrder());
        if (byteBuffer.get() == 0)
          return null; 
        byte b = byteBuffer.get();
        if (b != 0) {
          if ((b & 0x1) != 0)
            return null; 
          byte b1 = byteBuffer.get();
          if (b1 != 0) {
            if ((b1 & 0x1) != 0)
              return null; 
            byteBuffer.get();
            byteBuffer.getInt();
            byteBuffer.getInt();
            Rect rect = new Rect();
            rect.left = byteBuffer.getInt();
            rect.right = byteBuffer.getInt();
            rect.top = byteBuffer.getInt();
            rect.bottom = byteBuffer.getInt();
            byteBuffer.getInt();
            int[] arrayOfInt1 = new int[b];
            boolean bool = false;
            int i;
            for (i = 0; i < b; i++)
              arrayOfInt1[i] = byteBuffer.getInt(); 
            int[] arrayOfInt2 = new int[b1];
            for (i = bool; i < b1; i++)
              arrayOfInt2[i] = byteBuffer.getInt(); 
            return new NinePatchData(paramBitmap.getWidth(), paramBitmap.getHeight(), rect, arrayOfInt1, arrayOfInt2);
          } 
          return null;
        } 
        return null;
      } 
      return null;
    } catch (BufferUnderflowException bufferUnderflowException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\statics\NinePatchData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */