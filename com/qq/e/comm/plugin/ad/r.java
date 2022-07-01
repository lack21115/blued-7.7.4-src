package com.qq.e.comm.plugin.ad;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.p;

public class r implements GestureDetector.OnGestureListener {
  private final GestureDetector a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private boolean e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private ak.a j;
  
  public r(Context paramContext) {
    this(paramContext, false);
  }
  
  public r(Context paramContext, boolean paramBoolean) {
    int i;
    this.e = false;
    this.j = null;
    this.a = new GestureDetector(paramContext, this);
    int j = p.a(paramContext);
    int k = p.b(paramContext);
    if (paramBoolean) {
      i = GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_s_v_ratio", 10);
    } else {
      i = GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_v_ratio", 5);
    } 
    this.d = i * k / 100;
    this.c = GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_h_ratio", 10) * j / 100;
    if (GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_s_ratio", 0) != 0) {
      this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      i = this.b;
      this.c = i;
      this.d = i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("手机像素 = 宽 ");
    stringBuilder.append(j);
    stringBuilder.append(" *  高 ");
    stringBuilder.append(k);
    stringBuilder.append(", 阈值中，横向移动的像素 = ");
    stringBuilder.append(this.c);
    stringBuilder.append(" , 纵向移动的像素 = ");
    stringBuilder.append(this.d);
    ak.a(stringBuilder.toString(), this.j);
  }
  
  public void a(MotionEvent paramMotionEvent) {
    if (paramMotionEvent == null)
      return; 
    GestureDetector gestureDetector = this.a;
    if (gestureDetector != null)
      gestureDetector.onTouchEvent(paramMotionEvent); 
    this.h = (int)paramMotionEvent.getX();
    this.i = (int)paramMotionEvent.getY();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("横向滑动了 ");
    stringBuilder.append(Math.abs(this.h - this.f));
    stringBuilder.append(" 像素");
    ak.a(stringBuilder.toString(), this.j);
    stringBuilder = new StringBuilder();
    stringBuilder.append("纵向滑动了 ");
    stringBuilder.append(Math.abs(this.i - this.g));
    stringBuilder.append(" 像素");
    ak.a(stringBuilder.toString(), this.j);
    if (Math.abs(this.h - this.f) >= this.c)
      this.e = false; 
    if (Math.abs(this.i - this.g) >= this.d)
      this.e = false; 
  }
  
  public boolean a() {
    int i = GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click", 0);
    boolean bool = true;
    if (i == 1) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mIsInterceptClickedEvent=");
      stringBuilder.append(this.e);
      if (this.e == true) {
        str = " , 响应点击事件";
      } else {
        str = " , 不响应点击事件";
      } 
      stringBuilder.append(str);
      ak.a(stringBuilder.toString(), this.j);
      bool = this.e;
    } 
    return bool;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent) {
    if (paramMotionEvent != null) {
      this.f = (int)paramMotionEvent.getX();
      this.g = (int)paramMotionEvent.getY();
      ak.a("onDown(e)", this.j);
      this.e = true;
    } 
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    ak.a("onFling(e1, e2, velocityX, velocityY)", this.j);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {
    ak.a("onLongPress(e)", this.j);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    // Byte code:
    //   0: ldc 'onScroll(e1, e2, distanceX, distanceY)'
    //   2: aload_0
    //   3: getfield j : Lcom/qq/e/comm/plugin/util/ak$a;
    //   6: invokestatic a : (Ljava/lang/String;Lcom/qq/e/comm/plugin/util/ak$a;)V
    //   9: iconst_0
    //   10: istore #6
    //   12: iload #6
    //   14: istore #5
    //   16: aload_1
    //   17: ifnull -> 88
    //   20: iload #6
    //   22: istore #5
    //   24: aload_2
    //   25: ifnull -> 88
    //   28: aload_1
    //   29: invokevirtual getX : ()F
    //   32: aload_2
    //   33: invokevirtual getX : ()F
    //   36: fsub
    //   37: invokestatic abs : (F)F
    //   40: aload_0
    //   41: getfield c : I
    //   44: i2f
    //   45: fcmpl
    //   46: iflt -> 57
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield e : Z
    //   54: goto -> 85
    //   57: iload #6
    //   59: istore #5
    //   61: aload_1
    //   62: invokevirtual getY : ()F
    //   65: aload_2
    //   66: invokevirtual getY : ()F
    //   69: fsub
    //   70: invokestatic abs : (F)F
    //   73: aload_0
    //   74: getfield d : I
    //   77: i2f
    //   78: fcmpl
    //   79: iflt -> 88
    //   82: goto -> 49
    //   85: iconst_1
    //   86: istore #5
    //   88: iload #5
    //   90: ireturn
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {
    ak.a("onShowPress(e)", this.j);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
    ak.a("onSingleTapUp(e)", this.j);
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */