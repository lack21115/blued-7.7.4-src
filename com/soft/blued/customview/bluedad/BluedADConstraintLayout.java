package com.soft.blued.customview.bluedad;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.blued.android.core.AppInfo;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import skin.support.constraint.SkinCompatConstraintLayout;

public class BluedADConstraintLayout extends SkinCompatConstraintLayout {
  public BluedADExtra g;
  
  public Context h;
  
  public final String i = getClass().getName();
  
  private ViewTreeObserver.OnPreDrawListener j;
  
  public BluedADConstraintLayout(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public BluedADConstraintLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public BluedADConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.h = paramContext;
    this.j = new -$$Lambda$BluedADConstraintLayout$ppt9R3BpzlLgXXj8wv0nhhn5A_E(this);
  }
  
  private void b() {
    post(new -$$Lambda$BluedADConstraintLayout$uViJ-8JS8V1MwjMiPJ2j7Z76DVM(this));
  }
  
  public void a(BluedADExtra paramBluedADExtra, View.OnClickListener paramOnClickListener) {
    if (paramBluedADExtra == null) {
      setVisibility(8);
      return;
    } 
    this.g = paramBluedADExtra;
    invalidate();
    setOnClickListener(new -$$Lambda$BluedADConstraintLayout$A_aUhW6cKwk-_eZgCrxvERpzo0Q(this, paramOnClickListener));
    if (this.g != null) {
      if (a((View)this) && !this.g.isShowUrlVisited) {
        paramBluedADExtra = this.g;
        paramBluedADExtra.isShowUrlVisited = true;
        FindHttpUtils.a(paramBluedADExtra.show_url);
        return;
      } 
      b();
    } 
  }
  
  public boolean a(View paramView) {
    boolean bool1;
    boolean bool3 = false;
    if (paramView == null)
      return false; 
    if (paramView.hasWindowFocus() && paramView.getVisibility() == 0 && paramView.isShown()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    boolean bool2 = bool3;
    if (bool1) {
      bool2 = bool3;
      if (arrayOfInt[1] <= AppInfo.m)
        bool2 = true; 
    } 
    return bool2;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
  }
  
  public void setADData(BluedADExtra paramBluedADExtra) {
    a(paramBluedADExtra, (View.OnClickListener)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\bluedad\BluedADConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */