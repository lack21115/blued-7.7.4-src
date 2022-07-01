package com.cmic.sso.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.cmic.sso.sdk.utils.n;

public class LoadingImageView extends ImageView {
  private Animation a = null;
  
  private LinearInterpolator b = null;
  
  public LoadingImageView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a() {
    this.a = AnimationUtils.loadAnimation(getContext(), n.b(getContext(), "umcsdk_anim_loading"));
    this.b = new LinearInterpolator();
    this.a.setInterpolator((Interpolator)this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\widget\LoadingImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */