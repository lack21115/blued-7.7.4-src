package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

public class CommonTopTitleNoTrans extends LinearLayout implements View.OnClickListener {
  private View a;
  
  private Context b;
  
  private LinearLayout c;
  
  private ShapeTextView d;
  
  private ShapeTextView e;
  
  private ShapeTextView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private View.OnClickListener i;
  
  private View.OnClickListener j;
  
  private View.OnClickListener k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private RelativeLayout o;
  
  public CommonTopTitleNoTrans(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    a((AttributeSet)null);
  }
  
  public CommonTopTitleNoTrans(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a(paramAttributeSet);
  }
  
  public CommonTopTitleNoTrans(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a(paramAttributeSet);
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, int paramInt) {
    if (paramImageView != null) {
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(paramInt);
    } 
    if (paramTextView != null)
      paramTextView.setVisibility(8); 
  }
  
  private void a(TextView paramTextView, ImageView paramImageView, String paramString) {
    if (paramTextView != null) {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString);
    } 
    if (paramImageView != null)
      paramImageView.setVisibility(8); 
  }
  
  public void a() {
    this.f.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  public void a(AttributeSet paramAttributeSet) {
    this.a = LayoutInflater.from(this.b).inflate(2131494257, (ViewGroup)this);
    this.c = (LinearLayout)this.a.findViewById(2131298714);
    this.d = (ShapeTextView)this.a.findViewById(2131296863);
    this.d.setOnClickListener(this);
    this.e = (ShapeTextView)this.a.findViewById(2131296857);
    this.e.setOnClickListener(this);
    this.n = (TextView)this.a.findViewById(2131296858);
    this.f = (ShapeTextView)this.a.findViewById(2131296867);
    this.f.setOnClickListener(this);
    this.g = (ImageView)this.a.findViewById(2131296865);
    this.g.setOnClickListener(this);
    this.h = (ImageView)this.a.findViewById(2131296868);
    this.h.setOnClickListener(this);
    this.l = (TextView)this.a.findViewById(2131301411);
    this.m = (TextView)this.a.findViewById(2131301151);
    this.o = (RelativeLayout)this.a.findViewById(2131299697);
    if (paramAttributeSet != null) {
      TypedArray typedArray = getResources().obtainAttributes(paramAttributeSet, R.styleable.CommonTopTitleNoTrans);
      int i = typedArray.getResourceId(8, -1);
      if (i > 0) {
        this.d.setText(i);
        this.d.setVisibility(0);
      } 
      i = typedArray.getDimensionPixelSize(9, -1);
      if (i != -1)
        this.d.setTextSize(DensityUtils.c(this.b, i)); 
      i = typedArray.getResourceId(11, -1);
      if (i > 0) {
        this.f.setText(i);
        this.f.setVisibility(0);
      } 
      i = typedArray.getDimensionPixelSize(13, -1);
      if (i != -1)
        this.f.setTextSize(DensityUtils.c(this.b, i)); 
      i = typedArray.getResourceId(12, -1);
      if (i > 0)
        this.f.setTextColor(BluedSkinUtils.a(getContext(), i)); 
      i = typedArray.getResourceId(1, -1);
      if (i > 0) {
        this.e.setText(i);
        this.e.setVisibility(0);
      } 
      i = typedArray.getDimensionPixelSize(2, -1);
      if (i != -1)
        this.e.setTextSize(DensityUtils.c(this.b, i)); 
      i = typedArray.getResourceId(7, -1);
      if (i > 0) {
        this.d.setVisibility(8);
        this.g.setVisibility(0);
        this.g.setImageResource(i);
      } 
      i = typedArray.getResourceId(10, -1);
      if (i > 0) {
        this.f.setVisibility(8);
        this.h.setVisibility(0);
        this.h.setImageResource(i);
      } 
      boolean bool1 = typedArray.getBoolean(5, false);
      boolean bool2 = typedArray.getBoolean(6, false);
      boolean bool3 = typedArray.getBoolean(4, false);
      boolean bool4 = typedArray.getBoolean(3, false);
      boolean bool5 = typedArray.getBoolean(0, false);
      typedArray.recycle();
      if (bool1) {
        this.d.setVisibility(8);
        this.g.setVisibility(8);
      } 
      if (bool2) {
        this.f.setVisibility(8);
        this.h.setVisibility(8);
      } 
      if (bool3)
        this.e.setVisibility(8); 
      if (bool4) {
        this.l.setVisibility(8);
      } else {
        this.l.setVisibility(0);
      } 
      if (bool5)
        this.c.setBackgroundColor(getResources().getColor(2131100897)); 
    } 
    this.e.setTextColor(BluedSkinUtils.a(this.b, 2131100838));
  }
  
  public void b() {
    this.f.setVisibility(0);
    this.h.setVisibility(8);
  }
  
  public void c() {
    this.d.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public void d() {
    this.d.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  public void e() {
    this.l.setVisibility(8);
  }
  
  public Drawable getBackground() {
    return this.c.getBackground();
  }
  
  public TextView getCenterBelowTextView() {
    return this.n;
  }
  
  public TextView getCenterTextView() {
    return (TextView)this.e;
  }
  
  public RelativeLayout getContent() {
    return this.o;
  }
  
  public View getDivider() {
    return (View)this.l;
  }
  
  public ImageView getLeftImg() {
    return this.g;
  }
  
  public ShapeTextView getLeftTextView() {
    return this.d;
  }
  
  public ImageView getRightImg() {
    return this.h;
  }
  
  public ShapeTextView getRightTextView() {
    return this.f;
  }
  
  public LinearLayout getTitleBackground() {
    return this.c;
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131296868:
        onClick((View)this.f);
        return;
      case 2131296867:
        onClickListener = this.j;
        if (onClickListener != null) {
          onClickListener.onClick((View)this.f);
          return;
        } 
        return;
      case 2131296865:
        onClick((View)this.d);
        return;
      case 2131296863:
        onClickListener = this.i;
        if (onClickListener != null) {
          onClickListener.onClick((View)this.d);
          return;
        } 
        return;
      case 2131296857:
        break;
    } 
    View.OnClickListener onClickListener = this.k;
    if (onClickListener != null)
      onClickListener.onClick((View)this.e); 
  }
  
  public void setCenterClickListener(View.OnClickListener paramOnClickListener) {
    this.k = paramOnClickListener;
  }
  
  public void setCenterText(int paramInt) {
    a((TextView)this.e, (ImageView)null, this.b.getString(paramInt));
  }
  
  public void setCenterText(CharSequence paramCharSequence) {
    this.e.setText(paramCharSequence);
  }
  
  public void setCenterText(String paramString) {
    a((TextView)this.e, (ImageView)null, paramString);
  }
  
  public void setCenterTextColor(int paramInt) {
    ShapeHelper.a((ShapeHelper.ShapeView)this.e, paramInt);
  }
  
  public void setLeftClickListener(View.OnClickListener paramOnClickListener) {
    this.i = paramOnClickListener;
  }
  
  public void setLeftImg(int paramInt) {
    a(this.g, (TextView)this.d, paramInt);
  }
  
  public void setLeftImgDrawable(Drawable paramDrawable) {
    this.g.setImageDrawable(paramDrawable);
  }
  
  public void setLeftText(int paramInt) {
    a((TextView)this.d, this.g, this.b.getString(paramInt));
  }
  
  public void setLeftText(String paramString) {
    a((TextView)this.d, this.g, paramString);
  }
  
  public void setLeftTextColor(int paramInt) {
    ShapeHelper.a((ShapeHelper.ShapeView)this.d, paramInt);
  }
  
  public void setRightBtnEnable(boolean paramBoolean) {
    this.h.setEnabled(paramBoolean);
    this.f.setEnabled(paramBoolean);
    if (paramBoolean) {
      this.h.setAlpha(1.0F);
      this.f.setAlpha(1.0F);
      return;
    } 
    this.h.setAlpha(0.3F);
    this.f.setAlpha(0.3F);
  }
  
  public void setRightClickListener(View.OnClickListener paramOnClickListener) {
    this.j = paramOnClickListener;
  }
  
  public void setRightImg(int paramInt) {
    a(this.h, (TextView)this.f, paramInt);
  }
  
  public void setRightImgDrawable(Drawable paramDrawable) {
    this.h.setImageDrawable(paramDrawable);
  }
  
  public void setRightText(int paramInt) {
    a((TextView)this.f, this.h, this.b.getString(paramInt));
  }
  
  public void setRightText(String paramString) {
    a((TextView)this.f, this.h, paramString);
  }
  
  public void setRightTextColor(int paramInt) {
    ShapeHelper.a((ShapeHelper.ShapeView)this.f, paramInt);
  }
  
  public void setTitleBackgroundDrawable(int paramInt) {
    this.c.setBackgroundColor(BluedSkinUtils.a(getContext(), paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CommonTopTitleNoTrans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */