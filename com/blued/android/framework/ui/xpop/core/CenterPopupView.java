package com.blued.android.framework.ui.xpop.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class CenterPopupView extends BasePopupView {
  protected FrameLayout a = (FrameLayout)findViewById(R.id.centerPopupContainer);
  
  protected View b;
  
  public CenterPopupView(Context paramContext) {
    super(paramContext);
  }
  
  protected void a() {
    this.b = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup)this.a, false);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    layoutParams.gravity = 17;
    this.a.addView(this.b, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void b() {
    super.b();
    if (this.a.getChildCount() == 0)
      a(); 
    getPopupContentView().setTranslationX(this.l.x);
    getPopupContentView().setTranslationY(this.l.y);
    XPopupUtils.a((ViewGroup)getPopupContentView(), getMaxWidth(), getMaxHeight());
  }
  
  protected int getImplLayoutId() {
    return 0;
  }
  
  protected int getMaxWidth() {
    return (this.l.l == 0) ? (int)(XPopupUtils.a(getContext()) * 0.8F) : this.l.l;
  }
  
  protected PopupAnimator getPopupAnimator() {
    return (PopupAnimator)new ScaleAlphaAnimator(getPopupContentView(), PopupAnimation.a);
  }
  
  protected int getPopupLayoutId() {
    return R.layout._xpopup_center_popup_view;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    setTranslationY(0.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\CenterPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */