package com.blued.android.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.pulltorefresh.LoadingLayout;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshHelper;
import com.soft.blued.utils.Logger;

public class WaveLoadingLayout extends LoadingLayout {
  private final String TAG = WaveLoadingLayout.class.getSimpleName();
  
  private Context mContext;
  
  private LottieAnimationView mLavLoadingWave;
  
  private TextView mTvRefresh;
  
  public WaveLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray) {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.mContext = paramContext;
    View view = LayoutInflater.from(this.mContext).inflate(2131493791, null);
    ((LinearLayout)this.mInnerLayout.findViewById(2131299046)).setVisibility(8);
    view.setBackgroundColor(BluedSkinUtils.a(this.mContext, 2131100897));
    this.mLavLoadingWave = (LottieAnimationView)view.findViewById(2131298001);
    this.mTvRefresh = (TextView)view.findViewById(2131301244);
    this.mInnerLayout.addView(view);
    this.mInnerLayout.setBackgroundColor(BluedSkinUtils.a(this.mContext, 2131100897));
    this.mHeaderImage.setVisibility(8);
    this.mHeaderLayout.setBackgroundColor(BluedSkinUtils.a(this.mContext, 2131100897));
    this.mLavLoadingWave.setAnimation("wave_white.json");
  }
  
  public static void preloadLoadingAnimation(Context paramContext) {
    (new LottieAnimationView(paramContext)).setAnimation("wave_white.json");
  }
  
  public int getDefaultDrawableResId() {
    return 2131233389;
  }
  
  public void onLoadingDrawableSet(Drawable paramDrawable) {}
  
  public void onPullImpl(float paramFloat) {
    Logger.a(this.TAG, new Object[] { "onPullImpl" });
  }
  
  public void pullToRefreshImpl() {
    Logger.a(this.TAG, new Object[] { "pullToRefreshImpl" });
    LottieAnimationView lottieAnimationView = this.mLavLoadingWave;
    if (lottieAnimationView != null) {
      lottieAnimationView.d();
      this.mTvRefresh.setText(PullToRefreshHelper.a());
    } 
  }
  
  public void refreshingImpl() {
    Logger.a(this.TAG, new Object[] { "refreshingImpl" });
    LottieAnimationView lottieAnimationView = this.mLavLoadingWave;
    if (lottieAnimationView != null) {
      lottieAnimationView.a();
      this.mTvRefresh.setText(PullToRefreshHelper.c());
    } 
  }
  
  public void releaseToRefreshImpl() {
    Logger.a(this.TAG, new Object[] { "releaseToRefreshImpl" });
    this.mTvRefresh.setText(PullToRefreshHelper.b());
  }
  
  public void resetImpl() {
    Logger.a(this.TAG, new Object[] { "resetImpl" });
    LottieAnimationView lottieAnimationView = this.mLavLoadingWave;
    if (lottieAnimationView != null) {
      lottieAnimationView.d();
      this.mTvRefresh.setText(PullToRefreshHelper.b());
    } 
  }
  
  public void setHeaderBgImage() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\pulltorefresh\WaveLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */