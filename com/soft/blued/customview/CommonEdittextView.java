package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.soft.blued.R;

public class CommonEdittextView extends LinearLayout {
  private View a;
  
  private Context b;
  
  private ShapeFrameLayout c;
  
  private ShapeFrameLayout d;
  
  private TextView e;
  
  private LinearLayout f;
  
  private ClearEditText g;
  
  public CommonEdittextView(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    a(null);
  }
  
  public CommonEdittextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a(paramAttributeSet);
  }
  
  public CommonEdittextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a(paramAttributeSet);
  }
  
  public void a() {
    this.f.setPadding(0, 0, 0, 0);
  }
  
  public void a(AttributeSet paramAttributeSet) {
    this.a = LayoutInflater.from(this.b).inflate(2131494232, (ViewGroup)this);
    this.f = (LinearLayout)this.a.findViewById(2131299753);
    this.c = (ShapeFrameLayout)this.a.findViewById(2131299911);
    this.d = (ShapeFrameLayout)this.a.findViewById(2131299912);
    ShapeHelper.b((ShapeHelper.ShapeView)this.c, 2131100881);
    ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100881);
    this.e = (TextView)this.a.findViewById(2131300528);
    this.g = (ClearEditText)this.a.findViewById(2131296972);
    if (paramAttributeSet != null) {
      TypedArray typedArray = getResources().obtainAttributes(paramAttributeSet, R.styleable.CommonEdittextView);
      int i = typedArray.getResourceId(0, -1);
      if (i > 0)
        setHintText(i); 
      setIfShowAreaCode(typedArray.getBoolean(1, false));
      typedArray.recycle();
    } 
  }
  
  public TextView getAreaCodeText() {
    return this.e;
  }
  
  public ClearEditText getEditText() {
    return this.g;
  }
  
  public Editable getText() {
    return this.g.getText();
  }
  
  public void setAreaCodeClickListener(View.OnClickListener paramOnClickListener) {
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setAreaCodeText(String paramString) {
    this.e.setText(paramString);
  }
  
  public void setHintText(int paramInt) {
    this.g.setHint(paramInt);
  }
  
  public void setIfShowAreaCode(boolean paramBoolean) {
    if (paramBoolean) {
      this.c.setVisibility(0);
      this.e.setVisibility(0);
      return;
    } 
    this.c.setVisibility(8);
    this.e.setVisibility(8);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CommonEdittextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */