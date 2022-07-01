package com.soft.blued.customview.smartrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

public class BluedRefreshView extends InternalAbstract implements RefreshHeader {
  private LottieAnimationView a;
  
  private TextView b;
  
  private boolean c = true;
  
  private String d = "wave_white.json";
  
  public BluedRefreshView(Context paramContext) {
    this(paramContext, null);
  }
  
  public BluedRefreshView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BluedRefreshView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    View view = LayoutInflater.from(paramContext).inflate(2131493790, (ViewGroup)this);
    this.a = (LottieAnimationView)view.findViewById(2131298000);
    this.b = (TextView)view.findViewById(2131301244);
    this.a.setAnimation(getAnimationJson());
  }
  
  public int a(RefreshLayout paramRefreshLayout, boolean paramBoolean) {
    LottieAnimationView lottieAnimationView = this.a;
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
          if (this.c) {
            this.b.setVisibility(0);
            this.b.setText(2131758478);
            return;
          } 
          this.b.setVisibility(8);
          return;
        } 
        if (this.c) {
          this.b.setVisibility(0);
          this.b.setText(2131758479);
          return;
        } 
        this.b.setVisibility(8);
        return;
      } 
      if (this.c) {
        this.b.setVisibility(0);
        this.b.setText(2131758476);
        return;
      } 
      this.b.setVisibility(8);
      return;
    } 
    LottieAnimationView lottieAnimationView = this.a;
    if (lottieAnimationView != null) {
      lottieAnimationView.setFrame(0);
      this.a.setProgress(0.0F);
    } 
    if (this.c) {
      this.b.setVisibility(0);
      return;
    } 
    this.b.setVisibility(8);
  }
  
  public void b(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2) {
    LottieAnimationView lottieAnimationView = this.a;
    if (lottieAnimationView != null)
      lottieAnimationView.a(); 
  }
  
  public String getAnimationJson() {
    return this.d;
  }
  
  public void setShowText(boolean paramBoolean) {
    this.c = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\smartrefresh\BluedRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */