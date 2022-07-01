package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BubbleLayout extends View {
  private List<Bubble> a = Collections.synchronizedList(new ArrayList<Bubble>());
  
  private Random b = new Random();
  
  private int c;
  
  private int d;
  
  private Context e;
  
  private Paint f = new Paint();
  
  private int g;
  
  private int h;
  
  private int i;
  
  private ArrayList<Bitmap> j;
  
  private LoadOptions k;
  
  private Bitmap l;
  
  public BubbleLayout(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public BubbleLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public BubbleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  protected Bitmap a(Bitmap paramBitmap) {
    float f = DensityUtils.a(this.e, 5.0F) / 10.0F;
    Matrix matrix = new Matrix();
    matrix.postScale(f, f);
    Bitmap bitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
    paramBitmap.recycle();
    return bitmap;
  }
  
  public void a(Context paramContext) {
    this.e = paramContext;
    this.i = DensityUtils.a(this.e, 65.0F);
    this.g = DensityUtils.a(this.e, 28.0F);
    this.h = DensityUtils.a(this.e, 17.0F);
    this.j = new ArrayList<Bitmap>();
    this.k = new LoadOptions();
    this.k.a(DensityUtils.a(this.e, 28.0F), DensityUtils.a(this.e, 50.0F));
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    a(paramBoolean, paramInt, false);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    float f2;
    int j = 0;
    int i = 0;
    if (!paramBoolean2 && !paramBoolean1) {
      j = this.b.nextInt(3);
      while (i < j + 3) {
        AppInfo.n().postDelayed(new Runnable(this, paramBoolean1, paramInt) {
              public void run() {
                this.c.a(this.a, this.b, true);
              }
            }(i * 500));
        i++;
      } 
      return;
    } 
    if (this.l == null)
      this.l = ((BitmapDrawable)getResources().getDrawable(R.drawable.icon_rich26_like)).getBitmap(); 
    synchronized (this.j) {
      if (this.j.size() == 0) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable)getResources().getDrawable(R.drawable.heart_self);
        this.j.add(bitmapDrawable.getBitmap());
      } 
      this.f.reset();
      this.f.setColor(6723993);
      this.c = getWidth();
      this.d = getHeight();
      Bubble bubble = new Bubble();
      if (paramInt >= 26) {
        bubble.e = this.l;
      } else {
        paramInt = this.b.nextInt(this.j.size());
        bubble.e = this.j.get(paramInt);
      } 
      bubble.c(this.b.nextFloat() * 5.0F + 1.5F);
      bubble.c = 0.08F;
      bubble.a((this.c - this.h - DensityUtils.a(this.e, 22.0F)));
      bubble.b((this.d - DensityUtils.a(this.e, 12.0F)));
      f1 = this.b.nextFloat();
    } 
    while (true) {
      f2 = f1 - 1.0F;
      if (f2 >= -0.25D || f2 <= -0.7F) {
        f1 = this.b.nextFloat();
        continue;
      } 
      paramInt = j;
      if (this.b.nextInt(2) == 0)
        paramInt = 1; 
      break;
    } 
    float f1 = f2;
    if (paramInt == 0)
      f1 = f2 * -1.0F; 
    SYNTHETIC_LOCAL_VARIABLE_9.d(f1 * 3.0F);
    ((Bubble)SYNTHETIC_LOCAL_VARIABLE_9).a = SYNTHETIC_LOCAL_VARIABLE_9.e();
    post(new Runnable(this, paramBoolean1, (Bubble)SYNTHETIC_LOCAL_VARIABLE_9) {
          public void run() {
            if (this.a) {
              BubbleLayout.b(this.c).add(this.b);
            } else if (BubbleLayout.b(this.c).size() <= 50) {
              BubbleLayout.b(this.c).add(this.b);
            } 
            this.c.invalidate();
          }
        });
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_8} */
  }
  
  public void a(String[] paramArrayOfString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield j : Ljava/util/ArrayList;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull -> 67
    //   11: aload_1
    //   12: arraylength
    //   13: ifle -> 67
    //   16: aload_0
    //   17: getfield j : Ljava/util/ArrayList;
    //   20: invokevirtual clear : ()V
    //   23: iconst_0
    //   24: istore_2
    //   25: iload_2
    //   26: aload_1
    //   27: arraylength
    //   28: if_icmpge -> 93
    //   31: aload_1
    //   32: iload_2
    //   33: aaload
    //   34: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   37: ifne -> 101
    //   40: aconst_null
    //   41: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;)Lcom/blued/android/core/image/ImageFileWrapper;
    //   44: aload_1
    //   45: iload_2
    //   46: aaload
    //   47: invokevirtual a : (Ljava/lang/String;)Lcom/blued/android/core/image/ImageFileWrapper;
    //   50: new com/blued/android/module/live_china/view/BubbleLayout$1
    //   53: dup
    //   54: aload_0
    //   55: invokespecial <init> : (Lcom/blued/android/module/live_china/view/BubbleLayout;)V
    //   58: invokevirtual a : (Lcom/blued/android/core/image/ImageFileLoader$OnLoadFileListener;)Lcom/blued/android/core/image/ImageFileWrapper;
    //   61: invokevirtual a : ()V
    //   64: goto -> 101
    //   67: aload_0
    //   68: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   71: getstatic com/blued/android/module/live_china/R$drawable.heart_self : I
    //   74: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   77: checkcast android/graphics/drawable/BitmapDrawable
    //   80: astore_1
    //   81: aload_0
    //   82: getfield j : Ljava/util/ArrayList;
    //   85: aload_1
    //   86: invokevirtual getBitmap : ()Landroid/graphics/Bitmap;
    //   89: invokevirtual add : (Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_3
    //   94: monitorexit
    //   95: return
    //   96: astore_1
    //   97: aload_3
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: iload_2
    //   102: iconst_1
    //   103: iadd
    //   104: istore_2
    //   105: goto -> 25
    // Exception table:
    //   from	to	target	type
    //   11	23	96	finally
    //   25	64	96	finally
    //   67	93	96	finally
    //   93	95	96	finally
    //   97	99	96	finally
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.j != null) {
      for (int i = 0; i < this.j.size(); i++)
        ((Bitmap)this.j.get(i)).recycle(); 
      this.j.clear();
    } 
    Bitmap bitmap = this.l;
    if (bitmap != null && !bitmap.isRecycled())
      this.l.recycle(); 
    List<Bubble> list = this.a;
    if (list != null)
      list.clear(); 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.a.size() > 0) {
      Iterator<Bubble> iterator = this.a.iterator();
      while (iterator.hasNext()) {
        Bubble bubble = iterator.next();
        if (bubble == null)
          continue; 
        if (bubble.c() - bubble.d() <= 0.0F || (bubble.e != null && bubble.e.isRecycled())) {
          iterator.remove();
          continue;
        } 
        float f1 = (this.c - this.g) - bubble.b();
        float f2 = this.i;
        if (bubble.e() >= 0.0F) {
          if (f1 <= 0.0F)
            bubble.d(-bubble.e()); 
        } else if (f2 - f1 <= 0.0F) {
          bubble.d(-bubble.e());
        } 
        bubble.a();
        this.f.setAlpha(bubble.d);
        if (bubble.e.getWidth() > DensityUtils.a(this.e, 28.0F)) {
          f1 = 1.0F / bubble.e.getWidth() / DensityUtils.a(this.e, 28.0F);
        } else {
          f1 = 1.0F;
        } 
        if (bubble.b < 1.0F) {
          Matrix matrix1 = new Matrix();
          matrix1.postScale(bubble.b * f1, bubble.b * f1, 1.0F, 1.0F);
          matrix1.postTranslate(bubble.b(), bubble.c());
          if (bubble.e != null && !bubble.e.isRecycled())
            paramCanvas.drawBitmap(bubble.e, matrix1, this.f); 
          bubble.b += bubble.c;
          bubble.b(bubble.c() - 5.0F);
          bubble.a(bubble.b() - 3.5F);
          continue;
        } 
        Matrix matrix = new Matrix();
        matrix.postScale(f1, f1, 1.0F, 1.0F);
        matrix.postTranslate(bubble.b(), bubble.c());
        if (bubble.e != null && !bubble.e.isRecycled())
          paramCanvas.drawBitmap(bubble.e, matrix, this.f); 
        bubble.a(bubble.b() + bubble.e());
        bubble.b(bubble.c() - bubble.d());
      } 
      invalidate();
    } 
  }
  
  public void setShakeWidth(int paramInt) {
    this.i = paramInt;
  }
  
  public static class Bubble {
    public float a;
    
    public float b = 0.2F;
    
    public float c;
    
    public int d = 220;
    
    public Bitmap e;
    
    private float f;
    
    private float g;
    
    private float h;
    
    private float i;
    
    public void a() {
      float f1 = this.i;
      float f2 = this.f;
      if (f1 - f2 <= this.d) {
        this.d = (int)(f1 - f2);
        if (this.d <= 10)
          this.d = 0; 
      } 
    }
    
    public void a(float param1Float) {
      this.h = param1Float;
    }
    
    public float b() {
      return this.h;
    }
    
    public void b(float param1Float) {
      this.i = param1Float;
    }
    
    public float c() {
      return this.i;
    }
    
    public void c(float param1Float) {
      this.f = param1Float;
    }
    
    public float d() {
      return this.f;
    }
    
    public void d(float param1Float) {
      this.g = param1Float;
    }
    
    public float e() {
      return this.g;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\BubbleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */