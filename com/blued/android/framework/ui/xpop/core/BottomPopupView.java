package com.blued.android.framework.ui.xpop.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupStatus;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.SmartDragLayout;

public class BottomPopupView extends BasePopupView {
  protected SmartDragLayout a = (SmartDragLayout)findViewById(R.id.bottomPopupContainer);
  
  public BottomPopupView(Context paramContext) {
    super(paramContext);
  }
  
  protected void a() {
    View view = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup)this.a, false);
    this.a.addView(view);
  }
  
  public void b() {
    super.b();
    if (this.a.getChildCount() == 0)
      a(); 
    this.a.b(this.l.z.booleanValue());
    this.a.c(this.l.c.booleanValue());
    this.a.d(this.l.e.booleanValue());
    this.a.a(this.l.G);
    getPopupImplView().setTranslationX(this.l.x);
    getPopupImplView().setTranslationY(this.l.y);
    XPopupUtils.a((ViewGroup)getPopupContentView(), getMaxWidth(), getMaxHeight());
    this.a.setOnCloseListener(new SmartDragLayout.OnCloseListener(this) {
          public void a() {
            this.a.u();
            if (this.a.l.p != null)
              this.a.l.p.e(this.a); 
            this.a.q();
          }
          
          public void a(int param1Int, float param1Float, boolean param1Boolean) {
            if (this.a.l.p != null)
              this.a.l.p.a(this.a, param1Int, param1Float, param1Boolean); 
          }
          
          public void b() {
            BottomPopupView.a(this.a);
          }
        });
    this.a.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.p();
          }
        });
  }
  
  public int getAnimationDuration() {
    return this.l.z.booleanValue() ? 0 : super.getAnimationDuration();
  }
  
  protected int getImplLayoutId() {
    return 0;
  }
  
  protected int getMaxWidth() {
    return (this.l.l == 0) ? XPopupUtils.a(getContext()) : this.l.l;
  }
  
  protected PopupAnimator getPopupAnimator() {
    return (PopupAnimator)(this.l.z.booleanValue() ? null : new TranslateAnimator(getPopupContentView(), PopupAnimation.m));
  }
  
  protected int getPopupLayoutId() {
    return R.layout._xpopup_bottom_popup_view;
  }
  
  protected View getTargetSizeView() {
    return getPopupImplView();
  }
  
  protected void i() {
    if (this.l.z.booleanValue())
      return; 
    super.i();
  }
  
  public void n() {
    if (this.l.z.booleanValue()) {
      this.a.a();
      return;
    } 
    super.n();
  }
  
  public void o() {
    if (this.l.z.booleanValue()) {
      this.a.b();
      return;
    } 
    super.o();
  }
  
  public void p() {
    if (this.l == null)
      return; 
    if (this.l.z.booleanValue()) {
      if (this.p == PopupStatus.d)
        return; 
      this.p = PopupStatus.d;
      if (this.l.o.booleanValue())
        KeyboardUtils.b((View)this); 
      clearFocus();
      this.a.b();
      return;
    } 
    super.p();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\BottomPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */