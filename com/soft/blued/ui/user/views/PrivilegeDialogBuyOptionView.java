package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.utils.StringUtils;

public class PrivilegeDialogBuyOptionView extends LinearLayout {
  public Context a;
  
  public View b;
  
  private ShapeConstraintLayout c;
  
  private TextView d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  private TextView h;
  
  public PrivilegeDialogBuyOptionView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public PrivilegeDialogBuyOptionView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public PrivilegeDialogBuyOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  public void a() {
    this.b = LayoutInflater.from(this.a).inflate(2131493635, (ViewGroup)this);
    this.c = (ShapeConstraintLayout)this.b.findViewById(2131298900);
    this.d = (TextView)this.b.findViewById(2131301048);
    this.e = (TextView)this.b.findViewById(2131301049);
    this.f = (TextView)this.b.findViewById(2131301167);
    this.g = (TextView)this.b.findViewById(2131300754);
    this.h = (TextView)this.b.findViewById(2131300711);
  }
  
  public void setOptionView(PrivilegeBuyOptionForJsonParse.ProductBean paramProductBean) {
    ShapeHelper.b((ShapeHelper.ShapeView)this.c, 2131100728);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    if (paramProductBean.choosen) {
      layoutParams.width = DensityUtils.a(this.a, 100.0F);
      layoutParams.height = DensityUtils.a(this.a, 133.0F);
      ShapeHelper.b((ShapeHelper.ShapeView)this.c, 2131099654);
      ShapeHelper.d((ShapeHelper.ShapeView)this.c, 2131100837);
      if (!StringUtils.e(paramProductBean.discount)) {
        this.g.setVisibility(0);
        this.g.setText(paramProductBean.discount);
      } else {
        this.g.setVisibility(4);
      } 
      this.d.setTextSize(26.0F);
      this.d.setPadding(0, DensityUtils.a(this.a, 10.0F), 0, 0);
      this.e.setTextSize(14.0F);
      this.f.setTextSize(14.0F);
      this.h.setTextSize(14.0F);
    } else {
      layoutParams.width = DensityUtils.a(this.a, 100.0F);
      layoutParams.height = DensityUtils.a(this.a, 109.0F);
      ShapeHelper.d((ShapeHelper.ShapeView)this.c, 2131100586);
      ShapeHelper.b((ShapeHelper.ShapeView)this.c, 2131100586);
      this.g.setVisibility(8);
      this.d.setPadding(0, DensityUtils.a(this.a, 31.0F), 0, 0);
      this.d.setTextSize(22.0F);
      this.e.setTextSize(12.0F);
      this.f.setTextSize(12.0F);
      this.h.setTextSize(12.0F);
    } 
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (paramProductBean.showBeans) {
      if (paramProductBean.discount_beans > 0) {
        TextView textView = this.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramProductBean.discount_beans);
        stringBuilder.append(this.a.getResources().getString(2131755033));
        stringBuilder.append("/");
        stringBuilder.append(paramProductBean.unit);
        textView.setText(stringBuilder.toString());
      } else {
        TextView textView = this.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramProductBean.average_beans);
        stringBuilder.append(this.a.getResources().getString(2131755033));
        stringBuilder.append("/");
        stringBuilder.append(paramProductBean.unit);
        textView.setText(stringBuilder.toString());
      } 
    } else if (paramProductBean.discount_price > 0) {
      TextView textView = this.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("￥");
      stringBuilder.append(paramProductBean.discount_price);
      stringBuilder.append("/");
      stringBuilder.append(paramProductBean.unit);
      textView.setText(stringBuilder.toString());
    } else {
      TextView textView = this.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("￥");
      stringBuilder.append(paramProductBean.average_price);
      stringBuilder.append("/");
      stringBuilder.append(paramProductBean.unit);
      textView.setText(stringBuilder.toString());
    } 
    this.d.setText(String.valueOf(paramProductBean.buy_num));
    this.e.setText(paramProductBean.unit);
    this.h.setText(paramProductBean.discount_per);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\PrivilegeDialogBuyOptionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */