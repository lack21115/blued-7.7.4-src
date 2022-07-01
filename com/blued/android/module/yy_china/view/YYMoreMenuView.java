package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;

public class YYMoreMenuView extends LinearLayout implements View.OnClickListener {
  private BaseYYStudioFragment a;
  
  private LinearLayout b;
  
  private TextView c;
  
  private View.OnClickListener d;
  
  public YYMoreMenuView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYMoreMenuView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYMoreMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_more_menu_layout, (ViewGroup)this, true);
    this.b = (LinearLayout)findViewById(R.id.ll_shutdown);
    this.c = (TextView)findViewById(R.id.tv_shutdown_name);
    this.b.setOnClickListener(this);
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, String paramString) {
    this.a = paramBaseYYStudioFragment;
    this.c.setText(paramString);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.ll_shutdown) {
      if (this.a == null)
        return; 
      View.OnClickListener onClickListener = this.d;
      if (onClickListener != null)
        onClickListener.onClick(paramView); 
    } 
  }
  
  public void setShutdownLisenter(View.OnClickListener paramOnClickListener) {
    this.d = paramOnClickListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYMoreMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */