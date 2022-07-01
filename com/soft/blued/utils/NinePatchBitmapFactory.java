package com.soft.blued.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class NinePatchBitmapFactory {
  public static NinePatchDrawable a(Resources paramResources, Bitmap paramBitmap, List<Range> paramList1, List<Range> paramList2, String paramString) {
    return new NinePatchDrawable(paramResources, paramBitmap, a(paramList1, paramList2).array(), new Rect(), paramString);
  }
  
  private static ByteBuffer a(List<Range> paramList1, List<Range> paramList2) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(paramList1.size() * 8 + 32 + paramList2.size() * 8 + 36).order(ByteOrder.nativeOrder());
    byteBuffer.put((byte)1);
    byteBuffer.put((byte)(paramList1.size() * 2));
    byteBuffer.put((byte)(paramList2.size() * 2));
    byteBuffer.put((byte)9);
    byteBuffer.putInt(0);
    byteBuffer.putInt(0);
    byteBuffer.putInt(0);
    byteBuffer.putInt(0);
    byteBuffer.putInt(0);
    byteBuffer.putInt(0);
    byteBuffer.putInt(0);
    for (Range range : paramList1) {
      byteBuffer.putInt(range.a);
      byteBuffer.putInt(range.b);
    } 
    for (Range range : paramList2) {
      byteBuffer.putInt(range.a);
      byteBuffer.putInt(range.b);
    } 
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    byteBuffer.putInt(1);
    return byteBuffer;
  }
  
  public static class Range {
    public int a;
    
    public int b;
  }
  
  public static class RangeLists {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\NinePatchBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */