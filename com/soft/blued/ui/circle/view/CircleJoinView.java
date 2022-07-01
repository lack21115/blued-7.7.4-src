package com.soft.blued.ui.circle.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.MyCircleModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircleJoinView extends LinearLayout {
  public Context a;
  
  public View b;
  
  private TextView c;
  
  private ShapeLinearLayout d;
  
  private int e = 0;
  
  public CircleJoinView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    b();
  }
  
  public CircleJoinView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  public CircleJoinView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    b();
  }
  
  private void b() {
    this.b = LayoutInflater.from(this.a).inflate(2131494227, (ViewGroup)this);
    this.c = (TextView)this.b.findViewById(2131301377);
    this.d = (ShapeLinearLayout)this.b.findViewById(2131298932);
  }
  
  private void c() {
    if (this.e == 0) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100897);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100716);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100792);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100897);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100806));
    } 
    this.c.setText(2131755878);
  }
  
  private void d() {
    if (this.e == 0) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100897);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100851);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100845));
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100793);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100897);
      this.d.getBackground().setAlpha(100);
      this.c.setTextColor(this.a.getResources().getColor(2131100792));
    } 
    this.c.setText(2131755882);
  }
  
  private void e() {
    if (this.e == 0) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100897);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100716);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100792);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100897);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100806));
    } 
    this.c.setText(2131755846);
  }
  
  private void f() {
    if (this.e == 0) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100897);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100851);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100845));
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100793);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100897);
      this.c.setTextColor(this.a.getResources().getColor(2131100806));
    } 
    this.c.setText(2131755845);
  }
  
  private void g() {
    if (this.e == 0) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100897);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100851);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100845));
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100793);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100897);
      this.c.setTextColor(this.a.getResources().getColor(2131100806));
    } 
    this.c.setText(2131755864);
  }
  
  public void a() {
    if (this.e == 0) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100881);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100806));
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100881);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100897);
      this.c.setTextColor(BluedSkinUtils.a(this.a, 2131100806));
    } 
    this.c.setText(2131755887);
  }
  
  public void setJoinStatus(CircleJoinState paramCircleJoinState) {
    if (paramCircleJoinState == null)
      return; 
    if (paramCircleJoinState.isJoin()) {
      d();
      return;
    } 
    int i = paramCircleJoinState.is_applied;
    if (i != 1) {
      if (i != 2) {
        if (paramCircleJoinState.allow_join == 1) {
          c();
          return;
        } 
        e();
        return;
      } 
      g();
      return;
    } 
    f();
  }
  
  @Deprecated
  public void setJoinStatusWithMember(MyCircleModel paramMyCircleModel) {
    if (paramMyCircleModel == null)
      return; 
    if (paramMyCircleModel.is_member == 1) {
      d();
      return;
    } 
    int i = paramMyCircleModel.is_applied;
    if (i != 1) {
      if (i != 2) {
        if (paramMyCircleModel.allow_join == 1) {
          c();
          return;
        } 
        e();
        return;
      } 
      g();
      return;
    } 
    f();
  }
  
  public void setStyle(int paramInt) {
    this.e = paramInt;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Style {
    public static final int DETAILS = 1;
    
    public static final int LIST = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\view\CircleJoinView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */