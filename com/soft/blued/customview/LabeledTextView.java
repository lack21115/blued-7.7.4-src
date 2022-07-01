package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.soft.blued.R;

public class LabeledTextView extends RelativeLayout {
  private ImageView a;
  
  private ImageView b;
  
  private ImageView c;
  
  private View d;
  
  private TextView e;
  
  private View f;
  
  private View g;
  
  private String h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private boolean o = true;
  
  private boolean p;
  
  private boolean q;
  
  private boolean r;
  
  public LabeledTextView(Context paramContext) {
    super(paramContext);
    a(paramContext, null);
  }
  
  public LabeledTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public LabeledTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a() {
    int i = this.i;
    if (i != 0) {
      a(i, this.k, this.l);
    } else {
      setLeftIconShow(false);
    } 
    i = this.j;
    if (i != 0) {
      b(i, this.m, this.n);
    } else {
      setTvRightImgShow(false);
    } 
    setRightIconShow(this.o);
    setTopLineShow(this.q);
    setBottomLineShow(this.r);
  }
  
  protected View a(Context paramContext) {
    return View.inflate(paramContext, 2131493731, (ViewGroup)this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.a.setImageResource(paramInt1);
    setLeftIconShow(true);
    if (paramInt2 > 0 && paramInt3 > 0)
      this.a.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(paramInt2, paramInt3)); 
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CommonLabeledTextView);
    this.h = typedArray.getString(5);
    this.i = typedArray.getResourceId(1, 0);
    this.k = typedArray.getResourceId(3, 0);
    this.l = typedArray.getResourceId(2, 0);
    this.j = typedArray.getResourceId(7, 0);
    this.p = typedArray.getBoolean(6, false);
    this.m = typedArray.getResourceId(9, 0);
    this.n = typedArray.getResourceId(8, 0);
    this.o = typedArray.getBoolean(4, true);
    this.q = typedArray.getBoolean(10, false);
    this.r = typedArray.getBoolean(0, false);
    typedArray.recycle();
    View view = a(paramContext);
    this.a = (ImageView)view.findViewById(2131297399);
    this.d = view.findViewById(2131297751);
    this.b = (ImageView)view.findViewById(2131301279);
    this.c = (ImageView)view.findViewById(2131297404);
    this.e = (TextView)view.findViewById(2131300940);
    setTextTitle(this.h);
    this.f = view.findViewById(2131300299);
    this.g = view.findViewById(2131296555);
    a(Boolean.valueOf(this.p));
    a();
  }
  
  public void a(Boolean paramBoolean) {
    View view = this.d;
    if (view != null) {
      byte b;
      if (paramBoolean.booleanValue()) {
        b = 0;
      } else {
        b = 8;
      } 
      view.setVisibility(b);
    } 
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3) {
    this.b.setImageResource(paramInt1);
    setTvRightImgShow(true);
    if (paramInt2 > 0 && paramInt3 > 0)
      this.b.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(paramInt2, paramInt3)); 
  }
  
  public void setBottomLineShow(boolean paramBoolean) {
    byte b;
    View view = this.g;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    view.setVisibility(b);
  }
  
  public void setLeftIcon(int paramInt) {
    a(paramInt, 0, 0);
  }
  
  public void setLeftIconShow(boolean paramBoolean) {
    byte b;
    ImageView imageView = this.a;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
  }
  
  public void setRightIconShow(boolean paramBoolean) {
    byte b;
    ImageView imageView = this.c;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
  }
  
  public void setTextTitle(String paramString) {
    this.e.setText(paramString);
  }
  
  public void setTopLineShow(boolean paramBoolean) {
    byte b;
    View view = this.f;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    view.setVisibility(b);
  }
  
  public void setTvRightImg(int paramInt) {
    b(paramInt, 0, 0);
  }
  
  public void setTvRightImgShow(boolean paramBoolean) {
    byte b;
    ImageView imageView = this.b;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\LabeledTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */