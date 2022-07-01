package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;

public class ResizeLayout extends LinearLayout {
  int a = 0;
  
  int b = 0;
  
  int c = 0;
  
  LinearLayout d;
  
  LinearLayout e;
  
  private GridView f;
  
  public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppInfo.n().post(new Runnable(this, paramInt4, paramInt2) {
          public void run() {
            ResizeLayout resizeLayout = this.c;
            resizeLayout.e = (LinearLayout)resizeLayout.findViewById(2131296550);
            resizeLayout = this.c;
            resizeLayout.d = (LinearLayout)resizeLayout.findViewById(2131296557);
            EditText editText = (EditText)this.c.findViewById(2131296971);
            if (this.a - this.b > 50) {
              this.c.e.setVisibility(0);
              this.c.d.setVisibility(8);
              editText.requestFocus();
              if (ResizeLayout.a(this.c).getVisibility() == 0) {
                ResizeLayout.a(this.c).setVisibility(8);
                return;
              } 
            } else if (ResizeLayout.a(this.c).getVisibility() != 0) {
              this.c.e.setVisibility(8);
              this.c.d.setVisibility(0);
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ResizeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */