package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public final class Frame {
  public Bitmap mBitmap = null;
  
  public Frame$Metadata zzlgd = new Frame$Metadata();
  
  public ByteBuffer zzlge = null;
  
  private Frame() {}
  
  public final ByteBuffer getGrayscaleImageData() {
    if (this.mBitmap != null) {
      int i = this.mBitmap.getWidth();
      int j = this.mBitmap.getHeight();
      int k = i * j;
      int[] arrayOfInt = new int[k];
      this.mBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
      byte[] arrayOfByte = new byte[k];
      for (i = 0; i < arrayOfInt.length; i++)
        arrayOfByte[i] = (byte)(int)(Color.red(arrayOfInt[i]) * 0.299F + Color.green(arrayOfInt[i]) * 0.587F + Color.blue(arrayOfInt[i]) * 0.114F); 
      return ByteBuffer.wrap(arrayOfByte);
    } 
    return this.zzlge;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */