package com.bytedance.sdk.openadsdk.core.a;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.o;

public abstract class c implements View.OnClickListener, View.OnTouchListener {
  protected static int A = 8;
  
  private static float a = 0.0F;
  
  private static float b = 0.0F;
  
  private static float c = 0.0F;
  
  private static float d = 0.0F;
  
  private static long e = 0L;
  
  protected SparseArray<a> B = new SparseArray();
  
  protected int r;
  
  protected int s;
  
  protected int t;
  
  protected int u;
  
  protected long v;
  
  protected long w;
  
  protected int x;
  
  protected int y;
  
  protected int z;
  
  protected abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void onClick(View paramView) {
    if (!j.a())
      return; 
    a(paramView, this.r, this.s, this.t, this.u);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #4
    //   6: iload #4
    //   8: ifeq -> 175
    //   11: iload #4
    //   13: iconst_1
    //   14: if_icmpeq -> 144
    //   17: iload #4
    //   19: iconst_2
    //   20: if_icmpeq -> 41
    //   23: iload #4
    //   25: iconst_3
    //   26: if_icmpeq -> 35
    //   29: iconst_m1
    //   30: istore #4
    //   32: goto -> 234
    //   35: iconst_4
    //   36: istore #4
    //   38: goto -> 234
    //   41: getstatic com/bytedance/sdk/openadsdk/core/a/c.c : F
    //   44: aload_2
    //   45: invokevirtual getX : ()F
    //   48: getstatic com/bytedance/sdk/openadsdk/core/a/c.a : F
    //   51: fsub
    //   52: invokestatic abs : (F)F
    //   55: fadd
    //   56: putstatic com/bytedance/sdk/openadsdk/core/a/c.c : F
    //   59: getstatic com/bytedance/sdk/openadsdk/core/a/c.d : F
    //   62: aload_2
    //   63: invokevirtual getY : ()F
    //   66: getstatic com/bytedance/sdk/openadsdk/core/a/c.b : F
    //   69: fsub
    //   70: invokestatic abs : (F)F
    //   73: fadd
    //   74: putstatic com/bytedance/sdk/openadsdk/core/a/c.d : F
    //   77: aload_2
    //   78: invokevirtual getX : ()F
    //   81: putstatic com/bytedance/sdk/openadsdk/core/a/c.a : F
    //   84: aload_2
    //   85: invokevirtual getY : ()F
    //   88: putstatic com/bytedance/sdk/openadsdk/core/a/c.b : F
    //   91: invokestatic currentTimeMillis : ()J
    //   94: getstatic com/bytedance/sdk/openadsdk/core/a/c.e : J
    //   97: lsub
    //   98: ldc2_w 200
    //   101: lcmp
    //   102: ifle -> 138
    //   105: getstatic com/bytedance/sdk/openadsdk/core/a/c.c : F
    //   108: fstore_3
    //   109: getstatic com/bytedance/sdk/openadsdk/core/a/c.A : I
    //   112: istore #4
    //   114: fload_3
    //   115: iload #4
    //   117: i2f
    //   118: fcmpl
    //   119: ifgt -> 132
    //   122: getstatic com/bytedance/sdk/openadsdk/core/a/c.d : F
    //   125: iload #4
    //   127: i2f
    //   128: fcmpl
    //   129: ifle -> 138
    //   132: iconst_1
    //   133: istore #4
    //   135: goto -> 234
    //   138: iconst_2
    //   139: istore #4
    //   141: goto -> 234
    //   144: aload_0
    //   145: aload_2
    //   146: invokevirtual getRawX : ()F
    //   149: f2i
    //   150: putfield t : I
    //   153: aload_0
    //   154: aload_2
    //   155: invokevirtual getRawY : ()F
    //   158: f2i
    //   159: putfield u : I
    //   162: aload_0
    //   163: invokestatic currentTimeMillis : ()J
    //   166: putfield w : J
    //   169: iconst_3
    //   170: istore #4
    //   172: goto -> 234
    //   175: aload_0
    //   176: aload_2
    //   177: invokevirtual getRawX : ()F
    //   180: f2i
    //   181: putfield r : I
    //   184: aload_0
    //   185: aload_2
    //   186: invokevirtual getRawY : ()F
    //   189: f2i
    //   190: putfield s : I
    //   193: aload_0
    //   194: invokestatic currentTimeMillis : ()J
    //   197: putfield v : J
    //   200: aload_0
    //   201: aload_2
    //   202: iconst_0
    //   203: invokevirtual getToolType : (I)I
    //   206: putfield x : I
    //   209: aload_0
    //   210: aload_2
    //   211: invokevirtual getDeviceId : ()I
    //   214: putfield y : I
    //   217: aload_0
    //   218: aload_2
    //   219: invokevirtual getSource : ()I
    //   222: putfield z : I
    //   225: invokestatic currentTimeMillis : ()J
    //   228: putstatic com/bytedance/sdk/openadsdk/core/a/c.e : J
    //   231: iconst_0
    //   232: istore #4
    //   234: aload_0
    //   235: getfield B : Landroid/util/SparseArray;
    //   238: aload_2
    //   239: invokevirtual getActionMasked : ()I
    //   242: invokevirtual get : (I)Ljava/lang/Object;
    //   245: ifnonnull -> 281
    //   248: aload_0
    //   249: getfield B : Landroid/util/SparseArray;
    //   252: aload_2
    //   253: invokevirtual getActionMasked : ()I
    //   256: new com/bytedance/sdk/openadsdk/core/a/c$a
    //   259: dup
    //   260: iload #4
    //   262: aload_2
    //   263: invokevirtual getSize : ()F
    //   266: f2d
    //   267: aload_2
    //   268: invokevirtual getPressure : ()F
    //   271: f2d
    //   272: invokestatic currentTimeMillis : ()J
    //   275: invokespecial <init> : (IDDJ)V
    //   278: invokevirtual put : (ILjava/lang/Object;)V
    //   281: iconst_0
    //   282: ireturn
  }
  
  static {
    if (ViewConfiguration.get(o.a()) != null)
      A = ViewConfiguration.get(o.a()).getScaledTouchSlop(); 
  }
  
  public static class a {
    public int a = -1;
    
    public double b;
    
    public double c;
    
    public long d;
    
    public a(int param1Int, double param1Double1, double param1Double2, long param1Long) {
      this.a = param1Int;
      this.b = param1Double1;
      this.c = param1Double2;
      this.d = param1Long;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */