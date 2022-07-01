package com.soft.blued.ui.circle.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class GroupJoinView extends LinearLayout {
  public Context a;
  
  public View b;
  
  private boolean c;
  
  private ImageView d;
  
  private TextView e;
  
  private ShapeLinearLayout f;
  
  public GroupJoinView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    b();
  }
  
  public GroupJoinView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  public GroupJoinView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    b();
  }
  
  private void b() {
    this.b = LayoutInflater.from(this.a).inflate(2131494226, null);
    this.d = (ImageView)this.b.findViewById(2131297496);
    this.e = (TextView)this.b.findViewById(2131301377);
    this.f = (ShapeLinearLayout)this.b.findViewById(2131298932);
    addView(this.b, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, DensityUtil.a(26.0F)));
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    layoutParams.width = DensityUtil.a(18.0F);
    layoutParams.height = DensityUtil.a(18.0F);
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a() {
    this.c = false;
    ShapeHelper.b((ShapeHelper.ShapeView)this.f, 2131100792);
    ShapeHelper.d((ShapeHelper.ShapeView)this.f, 2131100897);
    this.e.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    this.d.setImageResource(2131232421);
    this.e.setText(getContext().getString(2131756643));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\view\GroupJoinView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */