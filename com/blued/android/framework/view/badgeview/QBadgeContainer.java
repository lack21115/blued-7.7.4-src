package com.blued.android.framework.view.badgeview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.blued.android.framework.R;

public class QBadgeContainer extends RelativeLayout implements Badge {
  public QBadgeView a;
  
  private Context b;
  
  private int c = 0;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private int g;
  
  private int h;
  
  private boolean i;
  
  private float j;
  
  private int k;
  
  public QBadgeContainer(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public QBadgeContainer(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QBadgeContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a();
    Resources resources = getResources();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Badge);
    this.c = typedArray.getInt(R.styleable.Badge_badge_num, 0);
    this.g = typedArray.getColor(R.styleable.Badge_badge_backgroundColor, -65536);
    this.h = typedArray.getColor(R.styleable.Badge_badge_textColor, -1);
    float f1 = resources.getDimension(R.dimen.default_off_x);
    float f2 = resources.getDimension(R.dimen.default_off_y);
    this.d = typedArray.getDimension(R.styleable.Badge_badge_offx, f1);
    this.e = typedArray.getDimension(R.styleable.Badge_badge_offy, f2);
    f1 = resources.getDimension(R.dimen.default_padding);
    this.f = typedArray.getDimension(R.styleable.Badge_badge_padding, f1);
    this.i = typedArray.getBoolean(R.styleable.Badge_badge_ext, false);
    f1 = resources.getDimension(R.dimen.default_text_size);
    this.j = typedArray.getDimension(R.styleable.Badge_badge_textSize, f1);
    this.k = typedArray.getInt(R.styleable.Badge_badge_gravity, 1);
  }
  
  private void a() {
    this.a = new QBadgeView(getContext());
  }
  
  private void b() {
    b(this.g);
    c(this.h);
    a(this.d, this.e, false);
    b(this.f, false);
    a(this.i);
    a(this.j, false);
    int i = this.k;
    if (i == 0) {
      d(8388659);
      return;
    } 
    if (2 == i) {
      d(8388691);
      return;
    } 
    if (3 == i) {
      d(8388693);
      return;
    } 
    if (4 == i) {
      d(49);
      return;
    } 
    if (5 == i) {
      d(81);
      return;
    } 
    if (6 == i) {
      d(8388627);
      return;
    } 
    if (7 == i) {
      d(8388629);
      return;
    } 
    d(8388661);
  }
  
  public Badge a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return this.a.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public Badge a(float paramFloat, boolean paramBoolean) {
    return this.a.a(paramFloat, paramBoolean);
  }
  
  public Badge a(int paramInt) {
    return this.a.a(paramInt);
  }
  
  public Badge a(int paramInt, float paramFloat, boolean paramBoolean) {
    return this.a.a(paramInt, paramFloat, paramBoolean);
  }
  
  public Badge a(Badge.OnDragStateChangedListener paramOnDragStateChangedListener) {
    return this.a.a(paramOnDragStateChangedListener);
  }
  
  public Badge a(String paramString) {
    return this.a.a(paramString);
  }
  
  public Badge a(boolean paramBoolean) {
    return this.a.c(paramBoolean);
  }
  
  public void a(View paramView) {
    this.a.a(paramView);
    b();
  }
  
  public Badge b(float paramFloat, boolean paramBoolean) {
    return this.a.b(paramFloat, paramBoolean);
  }
  
  public Badge b(int paramInt) {
    return this.a.b(paramInt);
  }
  
  public void b(boolean paramBoolean) {
    this.a.b(paramBoolean);
  }
  
  public Badge c(int paramInt) {
    return this.a.c(paramInt);
  }
  
  public Badge d(int paramInt) {
    return this.a.d(paramInt);
  }
  
  public Drawable getBadgeBackground() {
    return this.a.getBadgeBackground();
  }
  
  public int getBadgeBackgroundColor() {
    return this.a.getBadgeBackgroundColor();
  }
  
  public int getBadgeGravity() {
    return this.a.getBadgeGravity();
  }
  
  public int getBadgeNumber() {
    return this.a.getBadgeNumber();
  }
  
  public String getBadgeText() {
    return this.a.getBadgeText();
  }
  
  public int getBadgeTextColor() {
    return this.a.getBadgeTextColor();
  }
  
  public int getBageVisible() {
    return this.a.getVisibility();
  }
  
  public PointF getDragCenter() {
    return this.a.getDragCenter();
  }
  
  public View getTargetView() {
    return this.a.getTargetView();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBageVisible(int paramInt) {
    this.a.setVisibility(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\badgeview\QBadgeContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */