package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

public class m extends TouchDelegate {
  private View a;
  
  private Rect b;
  
  private Rect c;
  
  private boolean d;
  
  private int e;
  
  public m(Rect paramRect, View paramView) {
    super(paramRect, paramView);
    this.b = paramRect;
    this.e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.c = new Rect(paramRect);
    paramRect = this.c;
    int i = this.e;
    paramRect.inset(-i, -i);
    this.a = paramView;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getX : ()F
    //   4: f2i
    //   5: istore_3
    //   6: aload_1
    //   7: invokevirtual getY : ()F
    //   10: f2i
    //   11: istore #4
    //   13: aload_1
    //   14: invokevirtual getAction : ()I
    //   17: istore #5
    //   19: iconst_1
    //   20: istore #7
    //   22: iconst_0
    //   23: istore #9
    //   25: iload #5
    //   27: ifeq -> 102
    //   30: iload #5
    //   32: iconst_1
    //   33: if_icmpeq -> 68
    //   36: iload #5
    //   38: iconst_2
    //   39: if_icmpeq -> 68
    //   42: iload #5
    //   44: iconst_3
    //   45: if_icmpeq -> 54
    //   48: iconst_0
    //   49: istore #6
    //   51: goto -> 134
    //   54: aload_0
    //   55: getfield d : Z
    //   58: istore #6
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield d : Z
    //   65: goto -> 134
    //   68: aload_0
    //   69: getfield d : Z
    //   72: istore #8
    //   74: iload #8
    //   76: istore #6
    //   78: iload #8
    //   80: ifeq -> 134
    //   83: aload_0
    //   84: getfield c : Landroid/graphics/Rect;
    //   87: iload_3
    //   88: iload #4
    //   90: invokevirtual contains : (II)Z
    //   93: istore #7
    //   95: iload #8
    //   97: istore #6
    //   99: goto -> 134
    //   102: aload_0
    //   103: getfield b : Landroid/graphics/Rect;
    //   106: iload_3
    //   107: iload #4
    //   109: invokevirtual contains : (II)Z
    //   112: ifeq -> 126
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield d : Z
    //   120: iconst_1
    //   121: istore #6
    //   123: goto -> 134
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield d : Z
    //   131: goto -> 48
    //   134: iload #9
    //   136: istore #8
    //   138: iload #6
    //   140: ifeq -> 212
    //   143: aload_0
    //   144: getfield a : Landroid/view/View;
    //   147: astore #10
    //   149: iload #7
    //   151: ifeq -> 177
    //   154: aload_1
    //   155: aload #10
    //   157: invokevirtual getWidth : ()I
    //   160: iconst_2
    //   161: idiv
    //   162: i2f
    //   163: aload #10
    //   165: invokevirtual getHeight : ()I
    //   168: iconst_2
    //   169: idiv
    //   170: i2f
    //   171: invokevirtual setLocation : (FF)V
    //   174: goto -> 192
    //   177: aload_0
    //   178: getfield e : I
    //   181: iconst_2
    //   182: imul
    //   183: ineg
    //   184: i2f
    //   185: fstore_2
    //   186: aload_1
    //   187: fload_2
    //   188: fload_2
    //   189: invokevirtual setLocation : (FF)V
    //   192: iload #9
    //   194: istore #8
    //   196: aload #10
    //   198: invokevirtual getVisibility : ()I
    //   201: ifne -> 212
    //   204: aload #10
    //   206: aload_1
    //   207: invokevirtual dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   210: istore #8
    //   212: iload #8
    //   214: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */