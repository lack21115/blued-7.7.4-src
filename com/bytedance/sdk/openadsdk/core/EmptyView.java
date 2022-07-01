package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.r;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EmptyView extends View implements ak.a {
  private boolean a;
  
  private boolean b;
  
  private a c;
  
  private View d;
  
  private List<View> e;
  
  private List<View> f;
  
  private boolean g;
  
  private int h;
  
  private final Handler i = (Handler)new ak(Looper.getMainLooper(), this);
  
  private final AtomicBoolean j = new AtomicBoolean(true);
  
  public EmptyView(Context paramContext, View paramView) {
    super(o.a());
    this.d = paramView;
    setLayoutParams(new ViewGroup.LayoutParams(0, 0));
  }
  
  private void b() {
    if (this.j.getAndSet(false)) {
      a a1 = this.c;
      if (a1 != null)
        a1.a(); 
    } 
  }
  
  private void c() {
    if (!this.j.getAndSet(true)) {
      a a1 = this.c;
      if (a1 != null)
        a1.b(); 
    } 
  }
  
  private void d() {
    if (this.b) {
      if (this.a)
        return; 
      this.a = true;
      this.i.sendEmptyMessage(1);
    } 
  }
  
  private void e() {
    if (!this.a)
      return; 
    this.i.removeCallbacksAndMessages(null);
    this.a = false;
  }
  
  public void a() {
    a(this.e, (c)null);
    a(this.f, (c)null);
  }
  
  public void a(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2)
        return; 
      boolean bool = ah.d(o.a(), o.a().getPackageName());
      if (y.a(this.d, 20, this.h) || !bool) {
        this.i.sendEmptyMessageDelayed(2, 1000L);
        return;
      } 
      if (!this.g) {
        setNeedCheckingShow(true);
        return;
      } 
    } else if (this.a) {
      if (y.a(this.d, 20, this.h)) {
        e();
        this.i.sendEmptyMessageDelayed(2, 1000L);
        a a1 = this.c;
        if (a1 != null) {
          a1.a(this.d);
          return;
        } 
      } else {
        this.i.sendEmptyMessageDelayed(1, 1000L);
      } 
    } 
  }
  
  public void a(List<View> paramList, c paramc) {
    if (r.b(paramList))
      for (View view : paramList) {
        view.setOnClickListener((View.OnClickListener)paramc);
        view.setOnTouchListener((View.OnTouchListener)paramc);
      }  
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    d();
    this.g = false;
    b();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    e();
    this.g = true;
    c();
  }
  
  public void onFinishTemporaryDetach() {
    super.onFinishTemporaryDetach();
    b();
  }
  
  public void onStartTemporaryDetach() {
    super.onStartTemporaryDetach();
    c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    a a1 = this.c;
    if (a1 != null)
      a1.a(paramBoolean); 
  }
  
  public void setAdType(int paramInt) {
    this.h = paramInt;
  }
  
  public void setCallback(a parama) {
    this.c = parama;
  }
  
  public void setNeedCheckingShow(boolean paramBoolean) {
    this.b = paramBoolean;
    if (!paramBoolean && this.a) {
      e();
      return;
    } 
    if (paramBoolean && !this.a)
      d(); 
  }
  
  public void setRefClickViews(List<View> paramList) {
    this.e = paramList;
  }
  
  public void setRefCreativeViews(List<View> paramList) {
    this.f = paramList;
  }
  
  public static interface a {
    void a();
    
    void a(View param1View);
    
    void a(boolean param1Boolean);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\EmptyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */