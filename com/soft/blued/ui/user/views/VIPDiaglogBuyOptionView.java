package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.utils.StringUtils;

public class VIPDiaglogBuyOptionView extends LinearLayout {
  public Context a;
  
  public View b;
  
  private ConstraintLayout c;
  
  private TextView d;
  
  private TextView e;
  
  private ShapeTextView f;
  
  private ShapeTextView g;
  
  private TextView h;
  
  private int i = 1;
  
  public VIPDiaglogBuyOptionView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public VIPDiaglogBuyOptionView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public VIPDiaglogBuyOptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  public void a() {
    this.b = LayoutInflater.from(this.a).inflate(2131493687, (ViewGroup)this);
    this.c = (ConstraintLayout)this.b.findViewById(2131298900);
    this.d = (TextView)this.b.findViewById(2131301088);
    this.e = (TextView)this.b.findViewById(2131300514);
    this.f = (ShapeTextView)this.b.findViewById(2131300754);
    this.g = (ShapeTextView)this.b.findViewById(2131301370);
    this.h = (TextView)this.b.findViewById(2131301539);
  }
  
  public void setOptionView(VIPBuyOption paramVIPBuyOption) {
    if (paramVIPBuyOption != null) {
      boolean bool1 = StringUtils.e(paramVIPBuyOption.item.tag);
      boolean bool = false;
      if (!bool1) {
        this.f.setText(paramVIPBuyOption.item.tag);
        this.f.setVisibility(0);
      } else {
        this.f.setVisibility(4);
      } 
      if (this.f.getVisibility() == 0)
        bool = true; 
      if (paramVIPBuyOption.choosen) {
        if (bool) {
          if (this.i == 2) {
            this.c.setBackground(this.a.getResources().getDrawable(2131233741));
          } else {
            this.c.setBackground(this.a.getResources().getDrawable(2131233747));
          } 
        } else if (this.i == 2) {
          this.c.setBackground(this.a.getResources().getDrawable(2131233740));
        } else {
          this.c.setBackground(this.a.getResources().getDrawable(2131233746));
        } 
      } else if (bool) {
        this.c.setBackground(this.a.getResources().getDrawable(2131233743));
      } else {
        this.c.setBackground(this.a.getResources().getDrawable(2131233742));
      } 
      if (this.i == 2) {
        this.h.setTextColor(this.a.getResources().getColor(2131099657));
        this.e.setTextColor(this.a.getResources().getColor(2131099657));
        this.g.setTextColor(this.a.getResources().getColor(2131099657));
        ShapeHelper.b((ShapeHelper.ShapeView)this.g, 2131099658);
        return;
      } 
      this.h.setTextColor(this.a.getResources().getColor(2131099662));
      this.e.setTextColor(this.a.getResources().getColor(2131099662));
      this.g.setTextColor(this.a.getResources().getColor(2131099662));
      ShapeHelper.b((ShapeHelper.ShapeView)this.g, 2131099660);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\VIPDiaglogBuyOptionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */