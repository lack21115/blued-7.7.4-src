package com.blued.android.framework.ui.xpop.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PartShadowContainer;

public abstract class AttachPopupView extends BasePopupView {
  protected int a = 0;
  
  protected int b = 0;
  
  protected PartShadowContainer c = (PartShadowContainer)findViewById(R.id.attachPopupContainer);
  
  public boolean d;
  
  boolean e;
  
  protected int f = 6;
  
  float g = 0.0F;
  
  float h = 0.0F;
  
  float i = XPopupUtils.b(getContext());
  
  int j = 10;
  
  float k = 0.0F;
  
  public AttachPopupView(Context paramContext) {
    super(paramContext);
  }
  
  protected void a() {
    View view = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup)this.c, false);
    this.c.addView(view);
  }
  
  public void b() {
    super.b();
    if (this.c.getChildCount() == 0)
      a(); 
    if (this.l.a() != null || this.l.k != null) {
      int i;
      if (this.l.y == 0) {
        i = XPopupUtils.a(getContext(), 4.0F);
      } else {
        i = this.l.y;
      } 
      this.a = i;
      this.b = this.l.x;
      this.c.setTranslationX(this.l.x);
      this.c.setTranslationY(this.l.y);
      c();
      XPopupUtils.a((ViewGroup)getPopupContentView(), getMaxWidth(), getMaxHeight(), new Runnable(this) {
            public void run() {
              this.a.d();
            }
          });
      return;
    } 
    throw new IllegalArgumentException("atView() or touchPoint must not be null for AttachPopupView ！");
  }
  
  protected void c() {
    if (!this.q) {
      if (Build.VERSION.SDK_INT >= 21) {
        if (getPopupImplView().getBackground() != null) {
          Drawable.ConstantState constantState1 = getPopupImplView().getBackground().getConstantState();
          if (constantState1 != null) {
            Drawable drawable = constantState1.newDrawable();
            this.c.setBackground(drawable);
            getPopupImplView().setBackground(null);
          } 
        } else {
          int i;
          PartShadowContainer partShadowContainer = this.c;
          Resources resources = getResources();
          if (this.l.E) {
            i = R.color._xpopup_dark_color;
          } else {
            i = R.color._xpopup_light_color;
          } 
          partShadowContainer.setBackground((Drawable)XPopupUtils.a(resources.getColor(i), this.l.n));
        } 
        this.c.setElevation(XPopupUtils.a(getContext(), 20.0F));
        return;
      } 
      if (getPopupImplView().getBackground() == null) {
        int i = this.b;
        int j = this.f;
        this.b = i - j;
        this.a -= j;
        PartShadowContainer partShadowContainer = this.c;
        Resources resources = getResources();
        if (this.l.E) {
          i = R.color._xpopup_dark_color;
        } else {
          i = R.color._xpopup_light_color;
        } 
        partShadowContainer.setBackground((Drawable)XPopupUtils.a(resources.getColor(i), this.l.n));
        return;
      } 
      Drawable.ConstantState constantState = getPopupImplView().getBackground().getConstantState();
      if (constantState != null) {
        Drawable drawable = constantState.newDrawable();
        this.c.setBackground(drawable);
        getPopupImplView().setBackground(null);
      } 
    } 
  }
  
  public void d() {
    int i;
    boolean bool1;
    this.j = XPopupUtils.a(getContext(), this.j);
    boolean bool = XPopupUtils.c(getContext());
    PointF pointF = this.l.k;
    boolean bool3 = true;
    boolean bool2 = true;
    if (pointF != null) {
      float f;
      this.k = this.l.k.y;
      if (this.l.k.y + getPopupContentView().getMeasuredHeight() > this.i) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i) {
        if (this.l.k.y > (XPopupUtils.b(getContext()) / 2)) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        this.d = bool1;
      } else {
        this.d = false;
      } 
      if (this.l.k.x < (XPopupUtils.a(getContext()) / 2)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.e = bool1;
      ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
      if (e()) {
        f = this.l.k.y - XPopupUtils.a();
        i = this.j;
      } else {
        f = XPopupUtils.b(getContext()) - this.l.k.y;
        i = this.j;
      } 
      i = (int)(f - i);
      if (this.e) {
        f = XPopupUtils.a(getContext()) - this.l.k.x;
      } else {
        f = this.l.k.x;
      } 
      int k = (int)(f - this.j);
      if (getPopupContentView().getMeasuredHeight() > i)
        layoutParams.height = i; 
      if (getPopupContentView().getMeasuredWidth() > k)
        layoutParams.width = k; 
      getPopupContentView().setLayoutParams(layoutParams);
      getPopupContentView().post(new Runnable(this, bool) {
            public void run() {
              if (this.a) {
                float f;
                AttachPopupView attachPopupView = this.b;
                if (attachPopupView.e) {
                  f = XPopupUtils.a(this.b.getContext()) - this.b.l.k.x - this.b.getPopupContentView().getMeasuredWidth() - this.b.b;
                } else {
                  f = XPopupUtils.a(this.b.getContext()) - this.b.l.k.x + this.b.b;
                } 
                attachPopupView.g = -f;
              } else {
                float f;
                AttachPopupView attachPopupView = this.b;
                if (attachPopupView.e) {
                  f = this.b.l.k.x + this.b.b;
                } else {
                  f = this.b.l.k.x - this.b.getPopupContentView().getMeasuredWidth() - this.b.b;
                } 
                attachPopupView.g = f;
              } 
              if (this.b.l.A)
                if (this.b.e) {
                  if (this.a) {
                    AttachPopupView attachPopupView = this.b;
                    attachPopupView.g += this.b.getPopupContentView().getMeasuredWidth() / 2.0F;
                  } else {
                    AttachPopupView attachPopupView = this.b;
                    attachPopupView.g -= this.b.getPopupContentView().getMeasuredWidth() / 2.0F;
                  } 
                } else if (this.a) {
                  AttachPopupView attachPopupView = this.b;
                  attachPopupView.g -= this.b.getPopupContentView().getMeasuredWidth() / 2.0F;
                } else {
                  AttachPopupView attachPopupView = this.b;
                  attachPopupView.g += this.b.getPopupContentView().getMeasuredWidth() / 2.0F;
                }  
              if (this.b.e()) {
                AttachPopupView attachPopupView = this.b;
                attachPopupView.h = attachPopupView.l.k.y - this.b.getPopupContentView().getMeasuredHeight() - this.b.a;
              } else {
                AttachPopupView attachPopupView = this.b;
                attachPopupView.h = attachPopupView.l.k.y + this.b.a;
              } 
              this.b.getPopupContentView().setTranslationX(this.b.g);
              this.b.getPopupContentView().setTranslationY(this.b.h);
            }
          });
      return;
    } 
    int[] arrayOfInt = new int[2];
    this.l.a().getLocationOnScreen(arrayOfInt);
    Rect rect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.l.a().getMeasuredWidth(), arrayOfInt[1] + this.l.a().getMeasuredHeight());
    int j = (rect.left + rect.right) / 2;
    if ((rect.bottom + getPopupContentView().getMeasuredHeight()) > this.i) {
      i = 1;
    } else {
      i = 0;
    } 
    this.k = ((rect.top + rect.bottom) / 2);
    if (i) {
      if (this.k > (XPopupUtils.b(getContext()) / 2)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.d = bool1;
    } else {
      this.d = false;
    } 
    if (j <= XPopupUtils.a(getContext()) / 2) {
      bool1 = bool3;
    } else {
      bool1 = false;
    } 
    this.e = bool1;
    if (!this.q) {
      ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
      if (e()) {
        i = rect.top - XPopupUtils.a();
        j = this.j;
      } else {
        i = XPopupUtils.b(getContext()) - rect.bottom;
        j = this.j;
      } 
      j = i - j;
      if (this.e) {
        i = XPopupUtils.a(getContext()) - rect.left;
      } else {
        i = rect.right;
      } 
      i -= this.j;
      if (getPopupContentView().getMeasuredHeight() > j)
        layoutParams.height = j; 
      if (getPopupContentView().getMeasuredWidth() > i)
        layoutParams.width = i; 
      getPopupContentView().setLayoutParams(layoutParams);
    } 
    getPopupContentView().post(new Runnable(this, bool, rect) {
          public void run() {
            if (this.a) {
              int i;
              AttachPopupView attachPopupView = this.c;
              if (attachPopupView.e) {
                i = XPopupUtils.a(this.c.getContext()) - this.b.left - this.c.getPopupContentView().getMeasuredWidth() - this.c.b;
              } else {
                i = XPopupUtils.a(this.c.getContext()) - this.b.right + this.c.b;
              } 
              attachPopupView.g = -i;
            } else {
              int i;
              AttachPopupView attachPopupView = this.c;
              if (attachPopupView.e) {
                i = this.b.left + this.c.b;
              } else {
                i = this.b.right - this.c.getPopupContentView().getMeasuredWidth() - this.c.b;
              } 
              attachPopupView.g = i;
            } 
            if (this.c.l.A)
              if (this.c.e) {
                if (this.a) {
                  AttachPopupView attachPopupView = this.c;
                  attachPopupView.g -= (this.b.width() - this.c.getPopupContentView().getMeasuredWidth()) / 2.0F;
                } else {
                  AttachPopupView attachPopupView = this.c;
                  attachPopupView.g += (this.b.width() - this.c.getPopupContentView().getMeasuredWidth()) / 2.0F;
                } 
              } else if (this.a) {
                AttachPopupView attachPopupView = this.c;
                attachPopupView.g += (this.b.width() - this.c.getPopupContentView().getMeasuredWidth()) / 2.0F;
              } else {
                AttachPopupView attachPopupView = this.c;
                attachPopupView.g -= (this.b.width() - this.c.getPopupContentView().getMeasuredWidth()) / 2.0F;
              }  
            if (this.c.e()) {
              this.c.h = (this.b.top - this.c.getPopupContentView().getMeasuredHeight() - this.c.a);
            } else {
              this.c.h = (this.b.bottom + this.c.a);
            } 
            this.c.getPopupContentView().setTranslationX(this.c.g);
            this.c.getPopupContentView().setTranslationY(this.c.h);
          }
        });
  }
  
  protected boolean e() {
    return this.l.I ? ((this.k > (XPopupUtils.b(getContext()) / 2))) : (((this.d || this.l.s == PopupPosition.c) && this.l.s != PopupPosition.d));
  }
  
  protected PopupAnimator getPopupAnimator() {
    PopupAnimation popupAnimation;
    if (e()) {
      View view1 = getPopupContentView();
      if (this.e) {
        popupAnimation = PopupAnimation.u;
      } else {
        popupAnimation = PopupAnimation.s;
      } 
      return (PopupAnimator)new ScrollScaleAnimator(view1, popupAnimation);
    } 
    View view = getPopupContentView();
    if (this.e) {
      popupAnimation = PopupAnimation.o;
    } else {
      popupAnimation = PopupAnimation.q;
    } 
    return (PopupAnimator)new ScrollScaleAnimator(view, popupAnimation);
  }
  
  protected int getPopupLayoutId() {
    return R.layout._xpopup_attach_popup_view;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\AttachPopupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */