package com.bytedance.sdk.openadsdk.core.widget.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class GifView extends ImageView {
  private Movie a;
  
  private long b;
  
  private int c;
  
  private AnimatedImageDrawable d;
  
  private boolean e;
  
  private boolean f;
  
  private float g;
  
  private float h;
  
  private float i;
  
  private int j;
  
  private int k;
  
  private volatile boolean l;
  
  private boolean m;
  
  public GifView(Context paramContext) {
    super(paramContext);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    } else {
      bool = false;
    } 
    this.e = bool;
    this.f = false;
    this.m = true;
    a();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    } else {
      bool = false;
    } 
    this.e = bool;
    this.f = false;
    this.m = true;
    a();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    } else {
      bool = false;
    } 
    this.e = bool;
    this.f = false;
    this.m = true;
    a();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    } else {
      bool = false;
    } 
    this.e = bool;
    this.f = false;
    this.m = true;
    a();
  }
  
  private Movie a(byte[] paramArrayOfbyte) {
    try {
      return Movie.decodeByteArray(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    } finally {
      paramArrayOfbyte = null;
      t.a("GifView", "createMovieWithByteArrayBySafely error1", (Throwable)paramArrayOfbyte);
    } 
  }
  
  private AnimatedImageDrawable a(ImageDecoder.Source paramSource) {
    try {
      Drawable drawable = ImageDecoder.decodeDrawable(paramSource);
      setImageDrawable(drawable);
      if (drawable instanceof AnimatedImageDrawable) {
        AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable)drawable;
        return animatedImageDrawable;
      } 
    } finally {
      paramSource = null;
    } 
  }
  
  private File a(Context paramContext, String paramString1, String paramString2) {
    return (paramContext == null) ? null : k.a(paramContext, b.b(), paramString1, paramString2);
  }
  
  private void a(Canvas paramCanvas) {
    Movie movie = this.a;
    if (movie == null)
      return; 
    movie.setTime(this.c);
    float f1 = this.i;
    paramCanvas.scale(f1, f1);
    movie = this.a;
    f1 = this.g;
    float f2 = this.i;
    movie.draw(paramCanvas, f1 / f2, this.h / f2);
    paramCanvas.restore();
  }
  
  private AnimatedImageDrawable b(byte[] paramArrayOfbyte) {
    ImageDecoder.Source source2 = null;
    if (paramArrayOfbyte == null)
      return null; 
    ImageDecoder.Source source1 = source2;
    if (this.f)
      try {
        source1 = (ImageDecoder.Source)ImageDecoder.class.getMethod("createSource", new Class[] { Resources.class, InputStream.class }).invoke(null, new Object[] { getResources(), new ByteArrayInputStream(paramArrayOfbyte) });
      } finally {
        source1 = null;
        t.c("GifView", "GifView android P  : Use Reflection fail : ", (Throwable)source1);
      }  
    source2 = source1;
    if (source1 == null)
      source2 = c(paramArrayOfbyte); 
    return a(source2);
  }
  
  private void b() {
    if (this.a != null && !this.e && this.m) {
      if (Build.VERSION.SDK_INT >= 16) {
        postInvalidateOnAnimation();
        return;
      } 
      invalidate();
    } 
  }
  
  private ImageDecoder.Source c(byte[] paramArrayOfbyte) {
    try {
      String str;
      Context context = getContext();
      if (b.b()) {
        str = "GIF_AD_CACHE/";
      } else {
        str = "/GIF_CACHE/";
      } 
      File file = a(context, str, "TT_GIF_FILE");
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      try {
        ImageDecoder.Source source;
        fileOutputStream.write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
      } finally {
        File file1;
        file = null;
        FileOutputStream fileOutputStream1 = fileOutputStream;
      } 
    } finally {
      null = null;
    } 
  }
  
  private void c() {
    if (this.a == null)
      return; 
    long l = SystemClock.uptimeMillis();
    if (this.b == 0L)
      this.b = l; 
    int j = this.a.duration();
    int i = j;
    if (j == 0)
      i = 1000; 
    this.c = (int)((l - this.b) % i);
  }
  
  void a() {
    if (!this.e) {
      setLayerType(1, null);
      return;
    } 
    this.f = aa.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("android p 反射解锁：exempt result: ");
    stringBuilder.append(this.f);
    t.b("GifView", stringBuilder.toString());
  }
  
  public void a(byte[] paramArrayOfbyte, boolean paramBoolean) {
    this.l = paramBoolean;
    if (paramArrayOfbyte != null) {
      if (!this.e) {
        this.a = a(paramArrayOfbyte);
        return;
      } 
      this.d = b(paramArrayOfbyte);
    } 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.a != null && !this.e)
      try {
        return;
      } finally {
        paramCanvas = null;
        t.c("GifView", "onDraw->Throwable->", (Throwable)paramCanvas);
      }  
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null && !this.e) {
      this.g = (getWidth() - this.j) / 2.0F;
      this.h = (getHeight() - this.k) / 2.0F;
    } 
    if (getVisibility() == 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    this.m = paramBoolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: invokespecial onMeasure : (II)V
    //   6: aload_0
    //   7: getfield e : Z
    //   10: ifne -> 156
    //   13: aload_0
    //   14: getfield a : Landroid/graphics/Movie;
    //   17: astore #7
    //   19: aload #7
    //   21: ifnull -> 156
    //   24: aload #7
    //   26: invokevirtual width : ()I
    //   29: istore #5
    //   31: aload_0
    //   32: getfield a : Landroid/graphics/Movie;
    //   35: invokevirtual height : ()I
    //   38: istore #6
    //   40: iload_1
    //   41: invokestatic getMode : (I)I
    //   44: ifeq -> 68
    //   47: iload_1
    //   48: invokestatic getSize : (I)I
    //   51: istore_1
    //   52: iload #5
    //   54: iload_1
    //   55: if_icmple -> 68
    //   58: iload #5
    //   60: i2f
    //   61: iload_1
    //   62: i2f
    //   63: fdiv
    //   64: fstore_3
    //   65: goto -> 70
    //   68: fconst_1
    //   69: fstore_3
    //   70: iload_2
    //   71: invokestatic getMode : (I)I
    //   74: ifeq -> 99
    //   77: iload_2
    //   78: invokestatic getSize : (I)I
    //   81: istore_1
    //   82: iload #6
    //   84: iload_1
    //   85: if_icmple -> 99
    //   88: iload #6
    //   90: i2f
    //   91: iload_1
    //   92: i2f
    //   93: fdiv
    //   94: fstore #4
    //   96: goto -> 102
    //   99: fconst_1
    //   100: fstore #4
    //   102: aload_0
    //   103: fconst_1
    //   104: fload_3
    //   105: fload #4
    //   107: invokestatic max : (FF)F
    //   110: fdiv
    //   111: putfield i : F
    //   114: iload #5
    //   116: i2f
    //   117: fstore_3
    //   118: aload_0
    //   119: getfield i : F
    //   122: fstore #4
    //   124: aload_0
    //   125: fload_3
    //   126: fload #4
    //   128: fmul
    //   129: f2i
    //   130: putfield j : I
    //   133: aload_0
    //   134: iload #6
    //   136: i2f
    //   137: fload #4
    //   139: fmul
    //   140: f2i
    //   141: putfield k : I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield j : I
    //   149: aload_0
    //   150: getfield k : I
    //   153: invokevirtual setMeasuredDimension : (II)V
    //   156: return
  }
  
  public void onScreenStateChanged(int paramInt) {
    super.onScreenStateChanged(paramInt);
    if (this.a != null) {
      boolean bool = true;
      if (paramInt != 1)
        bool = false; 
      this.m = bool;
      b();
    } 
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.a != null) {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.m = bool;
      b();
    } 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    if (this.a != null) {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.m = bool;
      b();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\gif\GifView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */