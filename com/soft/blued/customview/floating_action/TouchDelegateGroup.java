package com.soft.blued.customview.floating_action;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

public class TouchDelegateGroup extends TouchDelegate {
  private static final Rect a = new Rect();
  
  private final ArrayList<TouchDelegate> b = new ArrayList<TouchDelegate>();
  
  private TouchDelegate c;
  
  private boolean d;
  
  public TouchDelegateGroup(View paramView) {
    super(a, paramView);
  }
  
  public void a() {
    this.b.clear();
    this.c = null;
  }
  
  public void a(TouchDelegate paramTouchDelegate) {
    this.b.add(paramTouchDelegate);
  }
  
  public void a(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Z
    //   4: istore_3
    //   5: iconst_0
    //   6: istore #4
    //   8: iload_3
    //   9: ifne -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_1
    //   15: invokevirtual getAction : ()I
    //   18: istore_2
    //   19: aconst_null
    //   20: astore #6
    //   22: iload_2
    //   23: ifeq -> 71
    //   26: iload_2
    //   27: iconst_1
    //   28: if_icmpeq -> 57
    //   31: iload_2
    //   32: iconst_2
    //   33: if_icmpeq -> 48
    //   36: iload_2
    //   37: iconst_3
    //   38: if_icmpeq -> 57
    //   41: aload #6
    //   43: astore #5
    //   45: goto -> 125
    //   48: aload_0
    //   49: getfield c : Landroid/view/TouchDelegate;
    //   52: astore #5
    //   54: goto -> 125
    //   57: aload_0
    //   58: getfield c : Landroid/view/TouchDelegate;
    //   61: astore #5
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield c : Landroid/view/TouchDelegate;
    //   68: goto -> 125
    //   71: iconst_0
    //   72: istore_2
    //   73: aload #6
    //   75: astore #5
    //   77: iload_2
    //   78: aload_0
    //   79: getfield b : Ljava/util/ArrayList;
    //   82: invokevirtual size : ()I
    //   85: if_icmpge -> 125
    //   88: aload_0
    //   89: getfield b : Ljava/util/ArrayList;
    //   92: iload_2
    //   93: invokevirtual get : (I)Ljava/lang/Object;
    //   96: checkcast android/view/TouchDelegate
    //   99: astore #5
    //   101: aload #5
    //   103: aload_1
    //   104: invokevirtual onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   107: ifeq -> 118
    //   110: aload_0
    //   111: aload #5
    //   113: putfield c : Landroid/view/TouchDelegate;
    //   116: iconst_1
    //   117: ireturn
    //   118: iload_2
    //   119: iconst_1
    //   120: iadd
    //   121: istore_2
    //   122: goto -> 73
    //   125: iload #4
    //   127: istore_3
    //   128: aload #5
    //   130: ifnull -> 147
    //   133: iload #4
    //   135: istore_3
    //   136: aload #5
    //   138: aload_1
    //   139: invokevirtual onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   142: ifeq -> 147
    //   145: iconst_1
    //   146: istore_3
    //   147: iload_3
    //   148: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\floating_action\TouchDelegateGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */