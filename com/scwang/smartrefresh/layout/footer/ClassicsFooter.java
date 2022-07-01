package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements RefreshFooter {
  public static String a;
  
  public static String b;
  
  public static String c;
  
  public static String d;
  
  public static String e;
  
  public static String f;
  
  public static String g;
  
  protected boolean h;
  
  public ClassicsFooter(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ClassicsFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    String str;
    this.h = false;
    if (a == null)
      a = paramContext.getString(R.string.srl_footer_pulling); 
    if (b == null)
      b = paramContext.getString(R.string.srl_footer_release); 
    if (c == null)
      c = paramContext.getString(R.string.srl_footer_loading); 
    if (d == null)
      d = paramContext.getString(R.string.srl_footer_refreshing); 
    if (e == null)
      e = paramContext.getString(R.string.srl_footer_finish); 
    if (f == null)
      f = paramContext.getString(R.string.srl_footer_failed); 
    if (g == null)
      g = paramContext.getString(R.string.srl_footer_nothing); 
    ImageView imageView2 = this.p;
    ImageView imageView1 = this.q;
    DensityUtil densityUtil = new DensityUtil();
    this.o.setTextColor(-10066330);
    TextView textView = this.o;
    if (isInEditMode()) {
      str = c;
    } else {
      str = a;
    } 
    textView.setText(str);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ClassicsFooter);
    RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)imageView2.getLayoutParams();
    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)imageView1.getLayoutParams();
    layoutParams2.rightMargin = typedArray.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, densityUtil.b(20.0F));
    layoutParams1.rightMargin = layoutParams2.rightMargin;
    layoutParams1.width = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams1.width);
    layoutParams1.height = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams1.height);
    layoutParams2.width = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
    layoutParams2.height = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
    layoutParams1.width = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams1.width);
    layoutParams1.height = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams1.height);
    layoutParams2.width = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
    layoutParams2.height = typedArray.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
    this.B = typedArray.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.B);
    this.w = SpinnerStyle.values()[typedArray.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.w.ordinal())];
    if (typedArray.hasValue(R.styleable.ClassicsFooter_srlDrawableArrow)) {
      this.p.setImageDrawable(typedArray.getDrawable(R.styleable.ClassicsFooter_srlDrawableArrow));
    } else {
      this.t = new ArrowDrawable();
      this.t.a(-10066330);
      this.p.setImageDrawable((Drawable)this.t);
    } 
    if (typedArray.hasValue(R.styleable.ClassicsFooter_srlDrawableProgress)) {
      this.q.setImageDrawable(typedArray.getDrawable(R.styleable.ClassicsFooter_srlDrawableProgress));
    } else {
      this.u = new ProgressDrawable();
      this.u.a(-10066330);
      this.q.setImageDrawable((Drawable)this.u);
    } 
    if (typedArray.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
      this.o.setTextSize(0, typedArray.getDimensionPixelSize(R.styleable.ClassicsFooter_srlTextSizeTitle, DensityUtil.a(16.0F)));
    } else {
      this.o.setTextSize(16.0F);
    } 
    if (typedArray.hasValue(R.styleable.ClassicsFooter_srlPrimaryColor))
      c(typedArray.getColor(R.styleable.ClassicsFooter_srlPrimaryColor, 0)); 
    if (typedArray.hasValue(R.styleable.ClassicsFooter_srlAccentColor))
      b(typedArray.getColor(R.styleable.ClassicsFooter_srlAccentColor, 0)); 
    typedArray.recycle();
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    if (!this.h) {
      String str;
      TextView textView = this.o;
      if (paramBoolean) {
        str = e;
      } else {
        str = f;
      } 
      textView.setText(str);
      return super.a(paramRefreshLayout, paramBoolean);
    } 
    return 0;
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    ImageView imageView = this.p;
    if (!this.h) {
      switch (null.a[paramRefreshState2.ordinal()]) {
        default:
          return;
        case 6:
          this.o.setText(d);
          imageView.setVisibility(8);
          return;
        case 5:
          this.o.setText(b);
          imageView.animate().rotation(0.0F);
          return;
        case 3:
        case 4:
          imageView.setVisibility(8);
          this.o.setText(c);
          return;
        case 1:
          imageView.setVisibility(0);
          break;
        case 2:
          break;
      } 
      this.o.setText(a);
      imageView.animate().rotation(180.0F);
    } 
  }
  
  public boolean a(boolean paramBoolean) {
    if (this.h != paramBoolean) {
      this.h = paramBoolean;
      ImageView imageView = this.p;
      if (paramBoolean) {
        this.o.setText(g);
        imageView.setVisibility(8);
      } else {
        this.o.setText(a);
        imageView.setVisibility(0);
      } 
    } 
    return true;
  }
  
  public void b(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    if (!this.h)
      super.b(paramRefreshLayout, paramInt1, paramInt2); 
  }
  
  @Deprecated
  public void setPrimaryColors(int... paramVarArgs) {
    if (this.w == SpinnerStyle.c)
      super.setPrimaryColors(paramVarArgs); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\footer\ClassicsFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */