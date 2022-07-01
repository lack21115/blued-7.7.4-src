package com.blued.android.framework.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class SwitchPanelRelativeLayout extends RelativeLayout {
  private SwitchPanelLayoutHandler a;
  
  public SwitchPanelRelativeLayout(Context paramContext) {
    super(paramContext);
    a((AttributeSet)null);
  }
  
  public SwitchPanelRelativeLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public SwitchPanelRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    this.a = new SwitchPanelLayoutHandler((View)this);
  }
  
  public void a(boolean paramBoolean) {
    this.a.a(paramBoolean);
  }
  
  public boolean a() {
    return this.a.a();
  }
  
  public void b() {
    super.setVisibility(0);
  }
  
  public void c() {
    this.a.b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int[] arrayOfInt = this.a.a(paramInt1, paramInt2);
    super.onMeasure(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public void setVisibility(int paramInt) {
    if (this.a.a(paramInt))
      return; 
    super.setVisibility(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\custom\SwitchPanelRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */