package com.blued.android.framework.ui.xpop.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.BlurAnimator;
import com.blued.android.framework.ui.xpop.animator.EmptyAnimator;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator;
import com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator;
import com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAlphaAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupStatus;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.util.navbar.OnNavigationBarListener;
import java.util.ArrayList;
import java.util.Stack;

public abstract class BasePopupView extends FrameLayout implements LifecycleObserver, OnNavigationBarListener {
  private static Stack<BasePopupView> a = new Stack<BasePopupView>();
  
  private int b;
  
  private Handler c = new Handler(Looper.getMainLooper());
  
  private Runnable d = new Runnable(this) {
      public void run() {
        if (this.a.r != null) {
          if (this.a.r.getWindow() == null)
            return; 
          BasePopupView basePopupView = this.a;
          basePopupView.b(XPopupUtils.b(basePopupView.r.getWindow()));
          this.a.getPopupContentView().setAlpha(1.0F);
          BasePopupView.a(this.a);
          if (this.a.l.p != null)
            this.a.l.p.b(this.a); 
          this.a.j();
          this.a.n();
          this.a.i();
        } 
      }
    };
  
  private boolean e = false;
  
  private Runnable f = new Runnable(this) {
      public void run() {
        BasePopupView.b(this.a);
        if (this.a.getContext() instanceof FragmentActivity)
          ((FragmentActivity)this.a.getContext()).getLifecycle().addObserver(this.a); 
        this.a.l.q = (ViewGroup)this.a.r.getWindow().getDecorView();
        KeyboardUtils.a(this.a.r.getWindow(), this.a, new KeyboardUtils.OnSoftInputChangedListener(this) {
              public void a(int param2Int) {
                if (this.a.a.l != null && this.a.a.l.p != null)
                  this.a.a.l.p.a(this.a.a, param2Int); 
                if (param2Int == 0) {
                  XPopupUtils.a(this.a.a);
                  BasePopupView.a(this.a.a, false);
                  return;
                } 
                if (this.a.a instanceof com.blued.android.framework.ui.xpop.impl.FullScreenPopupView && this.a.a.p == PopupStatus.b)
                  return; 
                if (this.a.a instanceof com.blued.android.framework.ui.xpop.impl.PartShadowPopupView && this.a.a.p == PopupStatus.b)
                  return; 
                XPopupUtils.a(param2Int, this.a.a);
                BasePopupView.a(this.a.a, true);
              }
            });
        this.a.f();
      }
    };
  
  private Runnable g = new Runnable(this) {
      public void run() {
        this.a.p = PopupStatus.a;
        this.a.v();
        if (this.a.l != null && this.a.l.p != null)
          this.a.l.p.c(this.a); 
        if (this.a.r != null && XPopupUtils.a(this.a.r.getWindow()) > 0 && !BasePopupView.c(this.a))
          XPopupUtils.a(XPopupUtils.a(this.a.r.getWindow()), this.a); 
      }
    };
  
  private ShowSoftInputTask h;
  
  private Runnable i = new Runnable(this) {
      public void run() {
        if (this.a.l == null)
          return; 
        if (this.a.l.o.booleanValue()) {
          BasePopupView basePopupView = this.a;
          if (basePopupView instanceof com.blued.android.framework.ui.xpop.impl.PartShadowPopupView)
            KeyboardUtils.b((View)basePopupView); 
        } 
        this.a.t();
        if (this.a.l.p != null)
          this.a.l.p.d(this.a); 
        if (this.a.s != null) {
          this.a.s.run();
          this.a.s = null;
        } 
        this.a.p = PopupStatus.c;
        if (!BasePopupView.x().isEmpty())
          BasePopupView.x().pop(); 
        if (this.a.l.B)
          if (!BasePopupView.x().isEmpty()) {
            ((BasePopupView)BasePopupView.x().get(BasePopupView.x().size() - 1)).j();
          } else if (this.a.l.q != null) {
            View view = this.a.l.q.findViewById(16908290);
            if (view != null) {
              view.setFocusable(true);
              view.setFocusableInTouchMode(true);
            } 
          }  
        if (this.a.r != null)
          this.a.r.dismiss(); 
      }
    };
  
  private float j;
  
  private float k;
  
  public PopupInfo l;
  
  protected PopupAnimator m;
  
  protected ShadowBgAnimator n;
  
  protected BlurAnimator o;
  
  public PopupStatus p = PopupStatus.c;
  
  protected boolean q = false;
  
  public FullScreenDialog r;
  
  Runnable s;
  
  public BasePopupView(Context paramContext) {
    super(paramContext);
    this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.n = new ShadowBgAnimator((View)this);
    View view = LayoutInflater.from(paramContext).inflate(getPopupLayoutId(), (ViewGroup)this, false);
    view.setAlpha(0.0F);
    addView(view);
  }
  
  private void a() {
    if (this instanceof AttachPopupView && !(this instanceof com.blued.android.framework.ui.xpop.impl.PartShadowPopupView)) {
      if (this.l.j != null) {
        this.m = this.l.j;
        this.m.c = getPopupContentView();
      } else {
        this.m = l();
        if (this.m == null)
          this.m = getPopupAnimator(); 
      } 
      if (this.l.e.booleanValue())
        this.n.a(); 
      if (this.l.f.booleanValue()) {
        this.o = new BlurAnimator((View)this);
        this.o.b = this.l.e.booleanValue();
        this.o.a = XPopupUtils.a(XPopupUtils.b((View)this).getWindow().getDecorView());
        this.o.a();
      } 
      PopupAnimator popupAnimator = this.m;
      if (popupAnimator != null) {
        popupAnimator.a();
        return;
      } 
    } else if (this.m == null) {
      if (this.l.j != null) {
        this.m = this.l.j;
        this.m.c = getPopupContentView();
      } else {
        this.m = l();
        if (this.m == null)
          this.m = getPopupAnimator(); 
      } 
      if (this.l.e.booleanValue())
        this.n.a(); 
      if (this.l.f.booleanValue()) {
        this.o = new BlurAnimator((View)this);
        this.o.b = this.l.e.booleanValue();
        this.o.a = XPopupUtils.a(XPopupUtils.b((View)this).getWindow().getDecorView());
        this.o.a();
      } 
      PopupAnimator popupAnimator = this.m;
      if (popupAnimator != null)
        popupAnimator.a(); 
    } 
  }
  
  private void c() {
    if (this.r == null)
      this.r = (new FullScreenDialog(getContext())).a(this); 
    this.r.show();
  }
  
  public void a(long paramLong) {
    long l = paramLong;
    if (paramLong < 0L)
      l = 0L; 
    this.c.postDelayed(new Runnable(this) {
          public void run() {
            this.a.p();
          }
        },  l);
  }
  
  protected void a(View paramView) {
    if (this.l.o.booleanValue()) {
      ShowSoftInputTask showSoftInputTask = this.h;
      if (showSoftInputTask == null) {
        this.h = new ShowSoftInputTask(paramView);
      } else {
        this.c.removeCallbacks(showSoftInputTask);
      } 
      this.c.postDelayed(this.h, 10L);
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (!paramBoolean) {
      g();
      return;
    } 
    b(true);
  }
  
  public void b() {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void f() {
    if (this instanceof AttachPopupView) {
      b();
    } else if (!this.q) {
      b();
    } 
    if (!(this instanceof com.blued.android.framework.ui.xpop.impl.FullScreenPopupView)) {
      int i;
      int j;
      View view = getTargetSizeView();
      if (getMaxWidth() != 0 && getPopupWidth() > getMaxWidth()) {
        i = getMaxWidth();
      } else {
        i = getPopupWidth();
      } 
      if (getMaxHeight() != 0 && getPopupHeight() > getMaxHeight()) {
        j = getMaxHeight();
      } else {
        j = getPopupHeight();
      } 
      XPopupUtils.a(view, i, j);
    } 
    if (!this.q) {
      this.q = true;
      m();
      if (this.l.p != null)
        this.l.p.a(this); 
    } 
    this.c.postDelayed(this.d, 50L);
  }
  
  protected void g() {}
  
  public int getAnimationDuration() {
    return (this.l.i == PopupAnimation.v) ? 10 : (10 + XPopup.b());
  }
  
  protected int getImplLayoutId() {
    return -1;
  }
  
  protected int getMaxHeight() {
    return this.l.m;
  }
  
  protected int getMaxWidth() {
    return 0;
  }
  
  protected PopupAnimator getPopupAnimator() {
    return null;
  }
  
  public View getPopupContentView() {
    return getChildAt(0);
  }
  
  protected int getPopupHeight() {
    return 0;
  }
  
  public View getPopupImplView() {
    return ((ViewGroup)getPopupContentView()).getChildAt(0);
  }
  
  protected abstract int getPopupLayoutId();
  
  protected int getPopupWidth() {
    return 0;
  }
  
  protected View getTargetSizeView() {
    return getPopupContentView();
  }
  
  public BasePopupView h() {
    Activity activity = XPopupUtils.b((View)this);
    if (activity != null) {
      if (activity.isFinishing())
        return this; 
      if (this.p == PopupStatus.b)
        return this; 
      this.p = PopupStatus.b;
      FullScreenDialog fullScreenDialog = this.r;
      if (fullScreenDialog != null && fullScreenDialog.isShowing())
        return this; 
      this.c.post(this.f);
    } 
    return this;
  }
  
  protected void i() {
    this.c.removeCallbacks(this.g);
    this.c.postDelayed(this.g, getAnimationDuration());
  }
  
  public void j() {
    PopupInfo popupInfo = this.l;
    if (popupInfo != null && popupInfo.B) {
      setFocusableInTouchMode(true);
      requestFocus();
      if (!a.contains(this))
        a.push(this); 
      setOnKeyListener(new BackPressListener(this));
      if (!this.l.C)
        a((View)this); 
      ArrayList<EditText> arrayList = new ArrayList();
      XPopupUtils.a(arrayList, (ViewGroup)getPopupContentView());
      for (int i = 0; i < arrayList.size(); i++) {
        EditText editText = arrayList.get(i);
        editText.setOnKeyListener(new BackPressListener(this));
        if (i == 0 && this.l.C) {
          editText.setFocusable(true);
          editText.setFocusableInTouchMode(true);
          editText.requestFocus();
          a((View)editText);
        } 
      } 
    } 
  }
  
  protected void k() {
    if (KeyboardUtils.a == 0) {
      p();
      return;
    } 
    KeyboardUtils.b((View)this);
  }
  
  protected PopupAnimator l() {
    PopupInfo popupInfo = this.l;
    if (popupInfo != null) {
      if (popupInfo.i == null)
        return null; 
      switch (null.a[this.l.i.ordinal()]) {
        default:
          return null;
        case 22:
          return (PopupAnimator)new EmptyAnimator(getPopupContentView());
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        case 21:
          return (PopupAnimator)new ScrollScaleAnimator(getPopupContentView(), this.l.i);
        case 10:
        case 11:
        case 12:
        case 13:
          return (PopupAnimator)new TranslateAnimator(getPopupContentView(), this.l.i);
        case 6:
        case 7:
        case 8:
        case 9:
          return (PopupAnimator)new TranslateAlphaAnimator(getPopupContentView(), this.l.i);
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
          break;
      } 
      return (PopupAnimator)new ScaleAlphaAnimator(getPopupContentView(), this.l.i);
    } 
    return null;
  }
  
  protected void m() {}
  
  public void n() {
    if (this.l.e.booleanValue() && !this.l.f.booleanValue()) {
      this.n.b();
    } else if (this.l.f.booleanValue()) {
      BlurAnimator blurAnimator = this.o;
      if (blurAnimator != null)
        blurAnimator.b(); 
    } 
    PopupAnimator popupAnimator = this.m;
    if (popupAnimator != null)
      popupAnimator.b(); 
  }
  
  public void o() {
    if (this.l.e.booleanValue() && !this.l.f.booleanValue()) {
      this.n.c();
    } else if (this.l.f.booleanValue()) {
      BlurAnimator blurAnimator = this.o;
      if (blurAnimator != null)
        blurAnimator.c(); 
    } 
    PopupAnimator popupAnimator = this.m;
    if (popupAnimator != null)
      popupAnimator.c(); 
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy() {
    w();
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    a.clear();
    this.c.removeCallbacksAndMessages(null);
    PopupInfo popupInfo = this.l;
    if (popupInfo != null) {
      if (popupInfo.q != null)
        KeyboardUtils.a((View)this.l.q, this); 
      if (this.l.H) {
        popupInfo = this.l;
        popupInfo.g = null;
        popupInfo.h = null;
        popupInfo.p = null;
        this.l = null;
      } 
    } 
    this.p = PopupStatus.c;
    this.h = null;
    this.e = false;
    BlurAnimator blurAnimator = this.o;
    if (blurAnimator != null && blurAnimator.a != null && !this.o.a.isRecycled()) {
      this.o.a.recycle();
      this.o.a = null;
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    Rect rect = new Rect();
    getPopupContentView().getGlobalVisibleRect(rect);
    if (!XPopupUtils.a(paramMotionEvent.getX(), paramMotionEvent.getY(), rect)) {
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i == 1) {
          float f1 = paramMotionEvent.getX();
          float f2 = this.j;
          float f3 = paramMotionEvent.getY();
          float f4 = this.k;
          if ((float)Math.sqrt(Math.pow((f1 - f2), 2.0D) + Math.pow((f3 - f4), 2.0D)) < this.b && this.l.c.booleanValue())
            p(); 
          this.j = 0.0F;
          this.k = 0.0F;
        } 
      } else {
        this.j = paramMotionEvent.getX();
        this.k = paramMotionEvent.getY();
      } 
    } 
    if (this.r != null) {
      PopupInfo popupInfo = this.l;
      if (popupInfo != null && popupInfo.D)
        this.r.a(paramMotionEvent); 
    } 
    return true;
  }
  
  public void p() {
    this.c.removeCallbacks(this.f);
    this.c.removeCallbacks(this.d);
    if (this.p != PopupStatus.d) {
      if (this.p == PopupStatus.c)
        return; 
      this.p = PopupStatus.d;
      clearFocus();
      PopupInfo popupInfo = this.l;
      if (popupInfo != null && popupInfo.p != null)
        this.l.p.e(this); 
      u();
      o();
      q();
    } 
  }
  
  public void q() {
    PopupInfo popupInfo = this.l;
    if (popupInfo != null && popupInfo.o.booleanValue() && !(this instanceof com.blued.android.framework.ui.xpop.impl.PartShadowPopupView))
      KeyboardUtils.b((View)this); 
    this.c.removeCallbacks(this.i);
    this.c.postDelayed(this.i, getAnimationDuration());
  }
  
  public boolean r() {
    return (this.p != PopupStatus.c);
  }
  
  public boolean s() {
    return (this.p == PopupStatus.c);
  }
  
  public void t() {}
  
  protected void u() {}
  
  public void v() {}
  
  public void w() {
    FullScreenDialog fullScreenDialog = this.r;
    if (fullScreenDialog != null)
      fullScreenDialog.dismiss(); 
    onDetachedFromWindow();
    PopupInfo popupInfo = this.l;
    if (popupInfo != null) {
      popupInfo.g = null;
      popupInfo.h = null;
      popupInfo.p = null;
    } 
    this.l = null;
  }
  
  class BackPressListener implements View.OnKeyListener {
    BackPressListener(BasePopupView this$0) {}
    
    public boolean onKey(View param1View, int param1Int, KeyEvent param1KeyEvent) {
      if (param1Int == 4 && param1KeyEvent.getAction() == 1 && this.a.l != null) {
        if (this.a.l.b.booleanValue() && (this.a.l.p == null || !this.a.l.p.f(this.a)))
          this.a.k(); 
        return true;
      } 
      return false;
    }
  }
  
  static class ShowSoftInputTask implements Runnable {
    View a;
    
    boolean b = false;
    
    public ShowSoftInputTask(View param1View) {
      this.a = param1View;
    }
    
    public void run() {
      View view = this.a;
      if (view != null && !this.b) {
        this.b = true;
        KeyboardUtils.a(view);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\BasePopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */