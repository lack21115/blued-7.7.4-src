package com.soft.blued.customview.floating_action;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.soft.blued.R;

public class FloatingActionButton extends AppCompatImageView implements View.OnTouchListener {
  private Context a;
  
  int b;
  
  int c;
  
  int d;
  
  String e;
  
  String f;
  
  boolean g;
  
  private Animation h;
  
  private int i;
  
  public FloatingActionButton(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  int a(int paramInt) {
    return getResources().getColor(paramInt);
  }
  
  void a(Context paramContext, AttributeSet paramAttributeSet) {
    this.a = paramContext;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton, 0, 0);
    this.b = typedArray.getColor(9, a(17170451));
    this.c = typedArray.getColor(10, a(17170450));
    this.d = typedArray.getColor(8, a(17170432));
    this.i = typedArray.getResourceId(11, 0);
    this.e = typedArray.getString(14);
    this.g = typedArray.getBoolean(13, true);
    typedArray.recycle();
    setOnTouchListener(this);
  }
  
  public String getColor() {
    return this.f;
  }
  
  TextView getLabelView() {
    return (TextView)getTag(2131297027);
  }
  
  public String getTitle() {
    return this.e;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      this.h = AnimationUtils.loadAnimation(this.a, 2130772018);
      startAnimation(this.h);
    } 
    if (paramMotionEvent.getAction() == 1) {
      this.h = AnimationUtils.loadAnimation(this.a, 2130772019);
      startAnimation(this.h);
    } 
    return false;
  }
  
  public void setIcon(int paramInt) {
    if (this.i != paramInt)
      this.i = paramInt; 
  }
  
  public void setLabelColor(String paramString) {
    this.f = paramString;
    TextView textView = getLabelView();
    if (textView != null)
      textView.setTextColor(Color.parseColor(paramString)); 
  }
  
  public void setTitle(String paramString) {
    this.e = paramString;
    TextView textView = getLabelView();
    if (textView != null)
      textView.setText(paramString); 
  }
  
  public void setVisibility(int paramInt) {
    TextView textView = getLabelView();
    if (textView != null)
      textView.setVisibility(paramInt); 
    super.setVisibility(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\floating_action\FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */