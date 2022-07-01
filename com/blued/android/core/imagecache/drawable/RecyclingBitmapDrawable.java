package com.blued.android.core.imagecache.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;

public class RecyclingBitmapDrawable extends BitmapDrawable implements IRecyclingDrawable {
  private static boolean d = true;
  
  public int a;
  
  public int b;
  
  public int c;
  
  private IRecyclingDrawable.CountRef e = new IRecyclingDrawable.CountRef(this);
  
  private String f;
  
  public RecyclingBitmapDrawable(Resources paramResources, Bitmap paramBitmap) {
    super(paramResources, paramBitmap);
  }
  
  private boolean f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 25
    //   11: aload_2
    //   12: invokevirtual isRecycled : ()Z
    //   15: istore_1
    //   16: iload_1
    //   17: ifne -> 25
    //   20: iconst_1
    //   21: istore_1
    //   22: goto -> 27
    //   25: iconst_0
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   11	16	31	finally
  }
  
  public void a(String paramString) {
    this.f = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.e.a(paramBoolean);
  }
  
  public boolean a() {
    return true;
  }
  
  public String b() {
    return this.f;
  }
  
  public void b(boolean paramBoolean) {
    this.e.b(paramBoolean);
  }
  
  public boolean c() {
    return f();
  }
  
  public void d() {
    RecyclingImageLoader.a(getBitmap());
  }
  
  public int e() {
    int j = RecyclingUtils.a(this);
    int i = j;
    if (j == 0)
      i = 1; 
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\RecyclingBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */