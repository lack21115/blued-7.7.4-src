package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

public class NoDataAndLoadFailView extends LinearLayout {
  private Context a;
  
  private View b;
  
  private LinearLayout c;
  
  private ImageView d;
  
  private TextView e;
  
  private TextView f;
  
  private ShapeTextView g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private boolean o = false;
  
  private boolean p = false;
  
  private boolean q = false;
  
  private int r;
  
  private int s;
  
  private View.OnClickListener t;
  
  private View.OnClickListener u;
  
  private boolean v = true;
  
  public NoDataAndLoadFailView(Context paramContext) {
    this(paramContext, null, 0);
  }
  
  public NoDataAndLoadFailView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NoDataAndLoadFailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    this.b = LayoutInflater.from(this.a).inflate(2131493588, (ViewGroup)this);
    this.b.setVisibility(8);
    this.c = (LinearLayout)this.b.findViewById(2131298932);
    this.c.setBackgroundColor(BluedSkinUtils.a(this.a, 2131100728));
    this.d = (ImageView)this.b.findViewById(2131297534);
    this.e = (TextView)this.b.findViewById(2131301116);
    this.f = (TextView)this.b.findViewById(2131301118);
    this.g = (ShapeTextView)this.b.findViewById(2131301252);
    this.j = 2131758231;
    this.k = 2131232466;
    this.l = 2131756115;
    this.r = 2131100845;
    this.s = 2131100845;
    c();
    if (paramAttributeSet != null) {
      TypedArray typedArray = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.NoDataAndLoadFailView);
      this.h = typedArray.getResourceId(9, 2131100728);
      this.c.setBackgroundResource(this.h);
      this.i = typedArray.getResourceId(7, 2131232640);
      this.j = typedArray.getResourceId(8, 2131758231);
      this.k = typedArray.getResourceId(3, 2131232466);
      this.l = typedArray.getResourceId(4, 2131756115);
      this.m = typedArray.getResourceId(1, 0);
      this.n = typedArray.getResourceId(1, 0);
      int i = typedArray.getResourceId(6, DensityUtils.a(this.a, 160.0F));
      int j = typedArray.getResourceId(5, DensityUtils.a(this.a, 160.0F));
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      layoutParams.width = i;
      layoutParams.height = j;
      this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      c();
      i = typedArray.getInt(2, 0);
      if (i != 1) {
        if (i != 2) {
          c();
        } else {
          b();
          i = this.n;
          if (i > 0) {
            this.g.setText(i);
            this.g.setVisibility(0);
          } else {
            this.g.setVisibility(8);
          } 
        } 
      } else {
        a();
        i = this.m;
        if (i > 0) {
          this.g.setText(i);
          this.g.setVisibility(0);
        } else {
          this.g.setVisibility(8);
        } 
      } 
      typedArray.recycle();
    } 
  }
  
  public void a() {
    this.b.setVisibility(0);
    if (this.i == 0)
      this.i = 2131232640; 
    this.d.setImageResource(this.i);
    if (this.j == 0)
      this.j = 2131758231; 
    this.e.setText(this.j);
    this.e.setTextColor(BluedSkinUtils.a(this.a, this.r));
    if (this.p) {
      this.g.setVisibility(0);
      this.g.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (NoDataAndLoadFailView.b(this.a) != null)
                NoDataAndLoadFailView.b(this.a).onClick(param1View); 
            }
          });
    } else {
      this.g.setVisibility(4);
    } 
    if (this.q) {
      this.f.setVisibility(0);
      return;
    } 
    this.f.setVisibility(8);
  }
  
  public void b() {
    this.b.setVisibility(0);
    if (this.k == 0)
      this.k = 2131232466; 
    this.d.setImageResource(this.k);
    if (this.l == 0)
      this.l = 2131756115; 
    this.e.setText(this.l);
    this.e.setTextColor(BluedSkinUtils.a(this.a, this.s));
    if (this.o) {
      this.g.setVisibility(0);
      this.g.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (NoDataAndLoadFailView.a(this.a) != null)
                NoDataAndLoadFailView.a(this.a).onClick(param1View); 
            }
          });
    } else {
      this.g.setVisibility(4);
    } 
    if (this.q) {
      this.f.setVisibility(0);
      return;
    } 
    this.f.setVisibility(8);
  }
  
  public void c() {
    this.b.setVisibility(8);
  }
  
  public ShapeTextView getBtn() {
    return this.g;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.v;
  }
  
  public void setBackgroundColorRes(int paramInt) {
    this.b.findViewById(2131298932).setBackgroundColor(BluedSkinUtils.a(this.a, paramInt));
  }
  
  public void setBtnStr(int paramInt) {
    this.g.setText(paramInt);
  }
  
  public void setFailBtnListener(View.OnClickListener paramOnClickListener) {
    this.u = paramOnClickListener;
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (NoDataAndLoadFailView.a(this.a) != null)
              NoDataAndLoadFailView.a(this.a).onClick(param1View); 
          }
        });
    this.o = true;
  }
  
  public void setFailBtnVisibility(int paramInt) {
    if (paramInt == 0) {
      this.o = true;
      return;
    } 
    this.o = false;
  }
  
  public void setFailImg(int paramInt) {
    this.k = paramInt;
    this.d.setImageResource(paramInt);
  }
  
  public void setFailStr(int paramInt) {
    this.l = paramInt;
    this.e.setText(paramInt);
  }
  
  public void setFailTextColor(int paramInt) {
    this.s = paramInt;
  }
  
  public void setImageScale(float paramFloat) {
    if (paramFloat > 0.0F && paramFloat <= 1.0F) {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
      int i = (int)(layoutParams.width * paramFloat);
      int j = (int)(layoutParams.height * paramFloat);
      layoutParams.width = i;
      layoutParams.height = j;
      this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  public void setNoDataBtnListener(View.OnClickListener paramOnClickListener) {
    this.t = paramOnClickListener;
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (NoDataAndLoadFailView.b(this.a) != null)
              NoDataAndLoadFailView.b(this.a).onClick(param1View); 
          }
        });
    this.p = true;
  }
  
  public void setNoDataBtnVisibility(int paramInt) {
    if (paramInt == 0) {
      this.p = true;
      return;
    } 
    this.p = false;
  }
  
  public void setNoDataImg(int paramInt) {
    this.i = paramInt;
    this.d.setImageDrawable(BluedSkinUtils.b(this.a, paramInt));
  }
  
  public void setNoDataSecondLineVisible(int paramInt) {
    if (paramInt == 0) {
      this.q = true;
      return;
    } 
    this.q = false;
  }
  
  public void setNoDataStr(int paramInt) {
    this.j = paramInt;
    this.e.setText(paramInt);
  }
  
  public void setNoDataTextColor(int paramInt) {
    this.r = paramInt;
  }
  
  public void setOnTouchEvent(boolean paramBoolean) {
    this.v = paramBoolean;
  }
  
  public void setSecondLineFailStr(CharSequence paramCharSequence) {
    this.f.setVisibility(0);
    this.f.setMovementMethod(LinkMovementMethod.getInstance());
    this.f.setText(paramCharSequence);
  }
  
  public void setTopSpace(int paramInt) {
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    layoutParams.topMargin = paramInt;
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\NoDataAndLoadFailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */