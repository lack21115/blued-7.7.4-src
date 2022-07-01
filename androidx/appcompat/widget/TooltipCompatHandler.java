package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

class TooltipCompatHandler implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
  private static TooltipCompatHandler j;
  
  private static TooltipCompatHandler k;
  
  private final View a;
  
  private final CharSequence b;
  
  private final int c;
  
  private final Runnable d = new Runnable(this) {
      public void run() {
        this.a.a(false);
      }
    };
  
  private final Runnable e = new Runnable(this) {
      public void run() {
        this.a.a();
      }
    };
  
  private int f;
  
  private int g;
  
  private TooltipPopup h;
  
  private boolean i;
  
  private TooltipCompatHandler(View paramView, CharSequence paramCharSequence) {
    this.a = paramView;
    this.b = paramCharSequence;
    this.c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(this.a.getContext()));
    d();
    this.a.setOnLongClickListener(this);
    this.a.setOnHoverListener(this);
  }
  
  private static void a(TooltipCompatHandler paramTooltipCompatHandler) {
    TooltipCompatHandler tooltipCompatHandler = j;
    if (tooltipCompatHandler != null)
      tooltipCompatHandler.c(); 
    j = paramTooltipCompatHandler;
    paramTooltipCompatHandler = j;
    if (paramTooltipCompatHandler != null)
      paramTooltipCompatHandler.b(); 
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if (Math.abs(i - this.f) <= this.c && Math.abs(j - this.g) <= this.c)
      return false; 
    this.f = i;
    this.g = j;
    return true;
  }
  
  private void b() {
    this.a.postDelayed(this.d, ViewConfiguration.getLongPressTimeout());
  }
  
  private void c() {
    this.a.removeCallbacks(this.d);
  }
  
  private void d() {
    this.f = Integer.MAX_VALUE;
    this.g = Integer.MAX_VALUE;
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence) {
    TooltipCompatHandler tooltipCompatHandler1;
    TooltipCompatHandler tooltipCompatHandler2 = j;
    if (tooltipCompatHandler2 != null && tooltipCompatHandler2.a == paramView)
      a((TooltipCompatHandler)null); 
    if (TextUtils.isEmpty(paramCharSequence)) {
      tooltipCompatHandler1 = k;
      if (tooltipCompatHandler1 != null && tooltipCompatHandler1.a == paramView)
        tooltipCompatHandler1.a(); 
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    } 
    new TooltipCompatHandler(paramView, (CharSequence)tooltipCompatHandler1);
  }
  
  void a() {
    if (k == this) {
      k = null;
      TooltipPopup tooltipPopup = this.h;
      if (tooltipPopup != null) {
        tooltipPopup.a();
        this.h = null;
        d();
        this.a.removeOnAttachStateChangeListener(this);
      } else {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      } 
    } 
    if (j == this)
      a((TooltipCompatHandler)null); 
    this.a.removeCallbacks(this.e);
  }
  
  void a(boolean paramBoolean) {
    long l;
    if (!ViewCompat.isAttachedToWindow(this.a))
      return; 
    a((TooltipCompatHandler)null);
    TooltipCompatHandler tooltipCompatHandler = k;
    if (tooltipCompatHandler != null)
      tooltipCompatHandler.a(); 
    k = this;
    this.i = paramBoolean;
    this.h = new TooltipPopup(this.a.getContext());
    this.h.a(this.a, this.f, this.g, this.i, this.b);
    this.a.addOnAttachStateChangeListener(this);
    if (this.i) {
      l = 2500L;
    } else {
      int i;
      if ((ViewCompat.getWindowSystemUiVisibility(this.a) & 0x1) == 1) {
        l = 3000L;
        i = ViewConfiguration.getLongPressTimeout();
      } else {
        l = 15000L;
        i = ViewConfiguration.getLongPressTimeout();
      } 
      l -= i;
    } 
    this.a.removeCallbacks(this.e);
    this.a.postDelayed(this.e, l);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent) {
    if (this.h != null && this.i)
      return false; 
    AccessibilityManager accessibilityManager = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
    if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled())
      return false; 
    int i = paramMotionEvent.getAction();
    if (i != 7) {
      if (i != 10)
        return false; 
      d();
      a();
      return false;
    } 
    if (this.a.isEnabled() && this.h == null && a(paramMotionEvent))
      a(this); 
    return false;
  }
  
  public boolean onLongClick(View paramView) {
    this.f = paramView.getWidth() / 2;
    this.g = paramView.getHeight() / 2;
    a(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView) {
    a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\TooltipCompatHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */