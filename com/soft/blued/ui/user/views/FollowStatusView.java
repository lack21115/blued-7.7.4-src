package com.soft.blued.ui.user.views;

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

public class FollowStatusView extends LinearLayout {
  public Context a;
  
  public View b;
  
  public LayoutInflater c;
  
  private TextView d;
  
  private ShapeLinearLayout e;
  
  public FollowStatusView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    c();
  }
  
  public FollowStatusView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    c();
  }
  
  public FollowStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    c();
  }
  
  private void c() {
    this.c = LayoutInflater.from(this.a);
    this.b = this.c.inflate(2131494236, (ViewGroup)this);
    this.d = (TextView)this.b.findViewById(2131301377);
    this.e = (ShapeLinearLayout)this.b.findViewById(2131298932);
    if (!isInEditMode())
      ShapeHelper.b((ShapeHelper.ShapeView)this.e, 2131100728); 
  }
  
  private void d() {
    ShapeHelper.d((ShapeHelper.ShapeView)this.e, 2131100716);
    this.d.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    this.d.setText(2131755359);
  }
  
  private void e() {
    ShapeHelper.d((ShapeHelper.ShapeView)this.e, 2131100716);
    this.d.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    this.d.setText(2131755437);
  }
  
  private void f() {
    ShapeHelper.d((ShapeHelper.ShapeView)this.e, 2131100851);
    this.d.setTextColor(BluedSkinUtils.a(this.a, 2131100845));
    this.d.setText(2131756545);
  }
  
  private void g() {
    ShapeHelper.d((ShapeHelper.ShapeView)this.e, 2131100851);
    this.d.setTextColor(BluedSkinUtils.a(this.a, 2131100845));
    this.d.setText(2131756538);
  }
  
  public void a() {
    ShapeHelper.d((ShapeHelper.ShapeView)this.e, 2131100716);
    this.d.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    this.d.setText(2131758962);
  }
  
  public void b() {
    ShapeHelper.b((ShapeHelper.ShapeView)this.e, 2131100881);
  }
  
  public void setRelationShip(String paramString) {
    if ("1".equalsIgnoreCase(paramString)) {
      f();
      return;
    } 
    if ("3".equalsIgnoreCase(paramString)) {
      g();
      return;
    } 
    if ("2".equalsIgnoreCase(paramString)) {
      e();
      return;
    } 
    d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\FollowStatusView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */