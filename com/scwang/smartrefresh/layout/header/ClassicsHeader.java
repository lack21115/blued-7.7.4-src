package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements RefreshHeader {
  public static String a;
  
  public static String b;
  
  public static String c;
  
  public static String d;
  
  public static String e;
  
  public static String f;
  
  public static String g;
  
  public static String h;
  
  protected String i;
  
  protected Date j;
  
  protected TextView k;
  
  protected SharedPreferences l;
  
  protected DateFormat m;
  
  protected boolean n;
  
  public ClassicsHeader(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ClassicsHeader(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ClassicsHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    String str;
    StringBuilder stringBuilder;
    this.i = "LAST_UPDATE_TIME";
    this.n = true;
    if (a == null)
      a = paramContext.getString(R.string.srl_header_pulling); 
    if (b == null)
      b = paramContext.getString(R.string.srl_header_refreshing); 
    if (c == null)
      c = paramContext.getString(R.string.srl_header_loading); 
    if (d == null)
      d = paramContext.getString(R.string.srl_header_release); 
    if (e == null)
      e = paramContext.getString(R.string.srl_header_finish); 
    if (f == null)
      f = paramContext.getString(R.string.srl_header_failed); 
    if (g == null)
      g = paramContext.getString(R.string.srl_header_update); 
    if (h == null)
      h = paramContext.getString(R.string.srl_header_secondary); 
    this.k = new TextView(paramContext);
    this.k.setTextColor(-8618884);
    this.m = new SimpleDateFormat(g, Locale.getDefault());
    ImageView imageView2 = this.p;
    TextView textView = this.k;
    ImageView imageView1 = this.q;
    LinearLayout linearLayout = this.r;
    DensityUtil densityUtil = new DensityUtil();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ClassicsHeader);
    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)imageView2.getLayoutParams();
    RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams)imageView1.getLayoutParams();
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.topMargin = typedArray.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, densityUtil.b(0.0F));
    layoutParams1.rightMargin = typedArray.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, densityUtil.b(20.0F));
    layoutParams2.rightMargin = layoutParams1.rightMargin;
    layoutParams2.width = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams2.width);
    layoutParams2.height = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams2.height);
    layoutParams1.width = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams1.width);
    layoutParams1.height = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams1.height);
    layoutParams2.width = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
    layoutParams2.height = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
    layoutParams1.width = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams1.width);
    layoutParams1.height = typedArray.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams1.height);
    this.B = typedArray.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.B);
    this.n = typedArray.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.n);
    this.w = SpinnerStyle.values()[typedArray.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.w.ordinal())];
    if (typedArray.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
      this.p.setImageDrawable(typedArray.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
    } else {
      this.t = new ArrowDrawable();
      this.t.a(-10066330);
      this.p.setImageDrawable((Drawable)this.t);
    } 
    if (typedArray.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
      this.q.setImageDrawable(typedArray.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
    } else {
      this.u = new ProgressDrawable();
      this.u.a(-10066330);
      this.q.setImageDrawable((Drawable)this.u);
    } 
    if (typedArray.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
      this.o.setTextSize(0, typedArray.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, DensityUtil.a(16.0F)));
    } else {
      this.o.setTextSize(16.0F);
    } 
    if (typedArray.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
      this.k.setTextSize(0, typedArray.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, DensityUtil.a(12.0F)));
    } else {
      this.k.setTextSize(12.0F);
    } 
    if (typedArray.hasValue(R.styleable.ClassicsHeader_srlPrimaryColor))
      c(typedArray.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0)); 
    if (typedArray.hasValue(R.styleable.ClassicsHeader_srlAccentColor))
      a(typedArray.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0)); 
    typedArray.recycle();
    textView.setId(4);
    if (this.n) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    textView.setVisibility(paramInt);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    textView = this.o;
    if (isInEditMode()) {
      str = b;
    } else {
      str = a;
    } 
    textView.setText(str);
    try {
      if (paramContext instanceof FragmentActivity) {
        FragmentManager fragmentManager = ((FragmentActivity)paramContext).getSupportFragmentManager();
        if (fragmentManager != null) {
          List list = fragmentManager.getFragments();
          if (list != null && list.size() > 0)
            return; 
        } 
      } 
    } finally {
      str = null;
    } 
    stringBuilder.append(this.i);
    stringBuilder.append(paramContext.getClass().getName());
    this.i = stringBuilder.toString();
    this.l = paramContext.getSharedPreferences("ClassicsHeader", 0);
    a(new Date(this.l.getLong(this.i, System.currentTimeMillis())));
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    if (paramBoolean) {
      this.o.setText(e);
      if (this.j != null)
        a(new Date()); 
    } else {
      this.o.setText(f);
    } 
    return super.a(paramRefreshLayout, paramBoolean);
  }
  
  public ClassicsHeader a(int paramInt) {
    this.k.setTextColor(0xFFFFFF & paramInt | 0xCC000000);
    return (ClassicsHeader)super.b(paramInt);
  }
  
  public ClassicsHeader a(Date paramDate) {
    this.j = paramDate;
    this.k.setText(this.m.format(paramDate));
    if (this.l != null && !isInEditMode())
      this.l.edit().putLong(this.i, paramDate.getTime()).apply(); 
    return this;
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    ImageView imageView = this.p;
    TextView textView = this.k;
    int i = null.a[paramRefreshState2.ordinal()];
    byte b = 8;
    switch (i) {
      default:
        return;
      case 7:
        imageView.setVisibility(8);
        if (this.n)
          b = 4; 
        textView.setVisibility(b);
        this.o.setText(c);
        return;
      case 6:
        this.o.setText(h);
        imageView.animate().rotation(0.0F);
        return;
      case 5:
        this.o.setText(d);
        imageView.animate().rotation(180.0F);
        return;
      case 3:
      case 4:
        this.o.setText(b);
        imageView.setVisibility(8);
        return;
      case 1:
        if (this.n)
          b = 0; 
        textView.setVisibility(b);
        break;
      case 2:
        break;
    } 
    this.o.setText(a);
    imageView.setVisibility(0);
    imageView.animate().rotation(0.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\header\ClassicsHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */