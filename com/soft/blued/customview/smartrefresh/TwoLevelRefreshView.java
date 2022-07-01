package com.soft.blued.customview.smartrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

public class TwoLevelRefreshView extends InternalAbstract implements RefreshHeader {
  public View a;
  
  public LottieAnimationView b;
  
  public TextView c;
  
  public boolean d = false;
  
  public boolean e = false;
  
  public TwoLevelRefreshView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TwoLevelRefreshView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TwoLevelRefreshView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    View view = LayoutInflater.from(paramContext).inflate(2131493792, (ViewGroup)this);
    this.a = view.findViewById(2131297158);
    this.b = (LottieAnimationView)view.findViewById(2131298000);
    this.c = (TextView)view.findViewById(2131301244);
    this.b.setAnimation("wave_white.json");
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    LottieAnimationView lottieAnimationView = this.b;
    if (lottieAnimationView != null)
      lottieAnimationView.d(); 
    return super.a(paramRefreshLayout, paramBoolean);
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    int i = null.a[paramRefreshState2.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          if (this.e) {
            this.c.setText(2131757759);
            return;
          } 
          this.c.setText(2131758478);
          return;
        } 
        if (this.e) {
          this.c.setText(2131757759);
          return;
        } 
        this.c.setText(2131758479);
        return;
      } 
      if (this.e) {
        this.c.setText(2131757759);
        return;
      } 
      this.c.setText(2131758476);
      return;
    } 
    LottieAnimationView lottieAnimationView = this.b;
    if (lottieAnimationView != null) {
      lottieAnimationView.setFrame(0);
      this.b.setProgress(0.0F);
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    this.d = paramBoolean2;
    this.e = paramBoolean1;
    if (paramBoolean2) {
      this.a.setBackgroundColor(getResources().getColor(2131100897));
      this.c.setTextSize(12.0F);
      this.c.setTextColor(getResources().getColor(2131100728));
      LottieAnimationView lottieAnimationView = this.b;
      if (lottieAnimationView != null) {
        lottieAnimationView.setVisibility(4);
        return;
      } 
    } else {
      this.a.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100728));
      this.c.setTextSize(10.0F);
      this.c.setTextColor(getResources().getColor(2131100527));
      LottieAnimationView lottieAnimationView = this.b;
      if (lottieAnimationView != null)
        lottieAnimationView.setVisibility(0); 
    } 
  }
  
  public void b(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    LottieAnimationView lottieAnimationView = this.b;
    if (lottieAnimationView != null)
      lottieAnimationView.a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\smartrefresh\TwoLevelRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */