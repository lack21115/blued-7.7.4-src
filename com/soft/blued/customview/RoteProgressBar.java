package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.soft.blued.R;
import com.soft.blued.utils.Logger;
import java.util.Timer;
import java.util.TimerTask;

public class RoteProgressBar extends TextView {
  private Paint a;
  
  private Paint b;
  
  private RectF c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private boolean k;
  
  private int l;
  
  private Paint m;
  
  private int n;
  
  private Paint o;
  
  private boolean p;
  
  private Handler q;
  
  private boolean r;
  
  private Timer s;
  
  private MyTimerTask t;
  
  private int u;
  
  private int v;
  
  private float w;
  
  private float x;
  
  public RoteProgressBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoteProgressBar);
    this.j = typedArray.getInt(3, 100);
    this.u = this.j;
    this.k = typedArray.getBoolean(1, true);
    if (!this.k) {
      this.b.setStyle(Paint.Style.STROKE);
      this.m.setStyle(Paint.Style.STROKE);
      this.o.setStyle(Paint.Style.STROKE);
    } 
    this.l = AppMethods.a(typedArray.getInt(2, 0));
    this.p = typedArray.getBoolean(7, true);
    this.d = AppMethods.a(typedArray.getInt(4, 10));
    if (this.k)
      this.d = 0; 
    this.b.setStrokeWidth(this.d);
    this.m.setStrokeWidth(this.d);
    this.o.setStrokeWidth(this.d);
    this.e = typedArray.getColor(5, -13312);
    this.b.setColor(this.e);
    this.f = typedArray.getColor(6, this.e & 0xFFFFFF | 0x66000000);
    this.m.setColor(this.f);
    this.g = typedArray.getColor(0, -7829368);
    this.o.setColor(this.g);
    typedArray.recycle();
  }
  
  private void a() {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(0.0F);
    this.d = 0;
    this.e = -13312;
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setStrokeWidth(this.d);
    this.b.setColor(this.e);
    this.m = new Paint();
    this.m.setAntiAlias(true);
    this.m.setStyle(Paint.Style.FILL);
    this.m.setStrokeWidth(this.d);
    this.f = this.e & 0xFFFFFF | 0x66000000;
    this.m.setColor(this.f);
    this.g = -7829368;
    this.o = new Paint();
    this.o.setAntiAlias(true);
    this.o.setStyle(Paint.Style.FILL);
    this.o.setStrokeWidth(this.d);
    this.o.setColor(this.g);
    this.h = -90;
    this.i = 0;
    this.j = 100;
    this.u = 100;
    this.k = true;
    this.p = true;
    this.l = 0;
    this.n = 0;
    this.c = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.v = 25;
    this.w = 0.0F;
    this.x = 0.0F;
    this.r = false;
    this.q = new Handler(this) {
        public void handleMessage(Message param1Message) {
          if (param1Message.what == 256) {
            if (!RoteProgressBar.a(this.a))
              return; 
            RoteProgressBar roteProgressBar = this.a;
            RoteProgressBar.a(roteProgressBar, RoteProgressBar.b(roteProgressBar) + RoteProgressBar.c(this.a));
            roteProgressBar = this.a;
            roteProgressBar.setProgress((int)RoteProgressBar.b(roteProgressBar));
            if (RoteProgressBar.b(this.a) > RoteProgressBar.d(this.a)) {
              RoteProgressBar.a(this.a, false);
              roteProgressBar = this.a;
              RoteProgressBar.a(roteProgressBar, RoteProgressBar.e(roteProgressBar));
              if (RoteProgressBar.f(this.a) != null) {
                RoteProgressBar.f(this.a).cancel();
                RoteProgressBar.a(this.a, (RoteProgressBar.MyTimerTask)null);
              } 
            } 
          } 
        }
      };
    this.s = new Timer("RotePro");
  }
  
  public int getMax() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getProgress() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getSecondaryProgress() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield n : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.p)
      paramCanvas.drawArc(this.c, 0.0F, 360.0F, this.k, this.o); 
    float f = this.n / this.j;
    paramCanvas.drawArc(this.c, this.h, f * 360.0F, this.k, this.m);
    f = this.i / this.j;
    paramCanvas.drawArc(this.c, this.h, f * 360.0F, this.k, this.b);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Logger.b("", new Object[] { "W = ", Integer.valueOf(paramInt1), ", H = ", Integer.valueOf(paramInt2) });
    paramInt3 = this.l;
    if (paramInt3 != 0) {
      RectF rectF1 = this.c;
      paramInt4 = this.d;
      rectF1.set((paramInt4 / 2 + paramInt3), (paramInt4 / 2 + paramInt3), (paramInt1 - paramInt4 / 2 - paramInt3), (paramInt2 - paramInt4 / 2 - paramInt3));
      return;
    } 
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingRight();
    int i = getPaddingTop();
    int j = getPaddingBottom();
    RectF rectF = this.c;
    int k = this.d;
    rectF.set((paramInt3 + k / 2), (i + k / 2), (paramInt1 - paramInt4 - k / 2), (paramInt2 - j - k / 2));
  }
  
  public void setMax(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifgt -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: iload_1
    //   11: putfield j : I
    //   14: aload_0
    //   15: getfield i : I
    //   18: iload_1
    //   19: if_icmple -> 27
    //   22: aload_0
    //   23: iload_1
    //   24: putfield i : I
    //   27: aload_0
    //   28: getfield n : I
    //   31: iload_1
    //   32: if_icmple -> 40
    //   35: aload_0
    //   36: iload_1
    //   37: putfield n : I
    //   40: aload_0
    //   41: aload_0
    //   42: getfield j : I
    //   45: putfield u : I
    //   48: aload_0
    //   49: invokevirtual invalidate : ()V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	55	finally
    //   27	40	55	finally
    //   40	52	55	finally
  }
  
  public void setProgress(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield i : I
    //   7: aload_0
    //   8: getfield i : I
    //   11: ifge -> 19
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield i : I
    //   19: aload_0
    //   20: getfield i : I
    //   23: aload_0
    //   24: getfield j : I
    //   27: if_icmple -> 38
    //   30: aload_0
    //   31: aload_0
    //   32: getfield j : I
    //   35: putfield i : I
    //   38: aload_0
    //   39: invokevirtual invalidate : ()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	45	finally
    //   19	38	45	finally
    //   38	42	45	finally
  }
  
  public void setSecondaryProgress(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield n : I
    //   7: aload_0
    //   8: getfield n : I
    //   11: ifge -> 19
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield n : I
    //   19: aload_0
    //   20: getfield n : I
    //   23: aload_0
    //   24: getfield j : I
    //   27: if_icmple -> 38
    //   30: aload_0
    //   31: aload_0
    //   32: getfield j : I
    //   35: putfield n : I
    //   38: aload_0
    //   39: invokevirtual invalidate : ()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	45	finally
    //   19	38	45	finally
    //   38	42	45	finally
  }
  
  class MyTimerTask extends TimerTask {
    public void run() {
      RoteProgressBar.g(this.a).obtainMessage(256).sendToTarget();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\RoteProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */