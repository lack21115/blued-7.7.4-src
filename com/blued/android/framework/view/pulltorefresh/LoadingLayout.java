package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.R;

public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
  static final Interpolator ANIMATION_INTERPOLATOR = (Interpolator)new LinearInterpolator();
  
  static final String LOG_TAG = "PullToRefresh-LoadingLayout";
  
  public boolean isHeaderStyleEnabled;
  
  public boolean isNeedBackgroudImage;
  
  protected final ImageView mHeaderImage;
  
  protected FrameLayout mHeaderLayout;
  
  protected final ProgressBar mHeaderProgress;
  
  protected final TextView mHeaderText;
  
  protected FrameLayout mInnerLayout;
  
  protected final PullToRefreshBase.Mode mMode;
  
  private CharSequence mPullLabel;
  
  private int mRefreshingHeight;
  
  private CharSequence mRefreshingLabel;
  
  private CharSequence mReleaseLabel;
  
  protected final PullToRefreshBase.Orientation mScrollDirection;
  
  private final TextView mSubHeaderText;
  
  private boolean mUseIntrinsicAnimation;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray) {
    super(paramContext);
    Drawable drawable1;
    this.isNeedBackgroudImage = true;
    this.isHeaderStyleEnabled = true;
    this.mMode = paramMode;
    this.mScrollDirection = paramOrientation;
    if (null.a[paramOrientation.ordinal()] != 1) {
      LayoutInflater.from(paramContext).inflate(R.layout.pull_to_refresh_header_vertical, (ViewGroup)this);
    } else {
      LayoutInflater.from(paramContext).inflate(R.layout.pull_to_refresh_header_horizontal, (ViewGroup)this);
    } 
    this.mInnerLayout = (FrameLayout)findViewById(R.id.fl_inner);
    this.mHeaderLayout = (FrameLayout)this.mInnerLayout.findViewById(R.id.fl_header);
    this.mHeaderText = (TextView)this.mInnerLayout.findViewById(R.id.pull_to_refresh_text);
    this.mHeaderProgress = (ProgressBar)this.mInnerLayout.findViewById(R.id.pull_to_refresh_progress);
    this.mSubHeaderText = (TextView)this.mInnerLayout.findViewById(R.id.pull_to_refresh_sub_text);
    this.mHeaderImage = (ImageView)this.mInnerLayout.findViewById(R.id.pull_to_refresh_image);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.mInnerLayout.getLayoutParams();
    if (null.b[paramMode.ordinal()] != 1) {
      byte b;
      if (paramOrientation == PullToRefreshBase.Orientation.a) {
        b = 80;
      } else {
        b = 5;
      } 
      layoutParams.gravity = b;
      this.mPullLabel = PullToRefreshHelper.a();
      this.mRefreshingLabel = PullToRefreshHelper.c();
      this.mReleaseLabel = PullToRefreshHelper.b();
    } else {
      byte b;
      if (paramOrientation == PullToRefreshBase.Orientation.a) {
        b = 48;
      } else {
        b = 3;
      } 
      layoutParams.gravity = b;
      this.mPullLabel = PullToRefreshHelper.a();
      this.mRefreshingLabel = PullToRefreshHelper.c();
      this.mReleaseLabel = PullToRefreshHelper.b();
    } 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderBackground)) {
      drawable2 = paramTypedArray.getDrawable(R.styleable.PullToRefresh_ptrHeaderBackground);
      if (drawable2 != null)
        ViewCompat.a((View)this, drawable2); 
    } 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderNeedBackgroundImg))
      this.isNeedBackgroudImage = paramTypedArray.getBoolean(R.styleable.PullToRefresh_ptrHeaderNeedBackgroundImg, true); 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderTextAppearance)) {
      TypedValue typedValue = new TypedValue();
      paramTypedArray.getValue(R.styleable.PullToRefresh_ptrHeaderTextAppearance, typedValue);
      setTextAppearance(typedValue.data);
    } 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrSubHeaderTextAppearance)) {
      TypedValue typedValue = new TypedValue();
      paramTypedArray.getValue(R.styleable.PullToRefresh_ptrSubHeaderTextAppearance, typedValue);
      setSubTextAppearance(typedValue.data);
    } 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderTextColor)) {
      ColorStateList colorStateList = paramTypedArray.getColorStateList(R.styleable.PullToRefresh_ptrHeaderTextColor);
      if (colorStateList != null)
        setTextColor(colorStateList); 
    } 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderSubTextColor)) {
      ColorStateList colorStateList = paramTypedArray.getColorStateList(R.styleable.PullToRefresh_ptrHeaderSubTextColor);
      if (colorStateList != null)
        setSubTextColor(colorStateList); 
    } 
    paramOrientation = null;
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrDrawable))
      drawable2 = paramTypedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawable); 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderStyleEnabled))
      this.isHeaderStyleEnabled = paramTypedArray.getBoolean(R.styleable.PullToRefresh_ptrHeaderStyleEnabled, true); 
    if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrRefreshingHeight))
      this.mRefreshingHeight = (int)paramTypedArray.getDimension(R.styleable.PullToRefresh_ptrRefreshingHeight, 0.0F); 
    setHeaderBgImage();
    if (null.b[paramMode.ordinal()] != 1) {
      if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableStart)) {
        drawable1 = paramTypedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableStart);
      } else {
        drawable1 = drawable2;
        if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableTop)) {
          Log.w("ptrDrawableTop", "ptrDrawableStart");
          drawable1 = paramTypedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableTop);
        } 
      } 
    } else if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableEnd)) {
      drawable1 = paramTypedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableEnd);
    } else {
      drawable1 = drawable2;
      if (paramTypedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableBottom)) {
        Log.w("ptrDrawableBottom", "ptrDrawableEnd");
        drawable1 = paramTypedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableBottom);
      } 
    } 
    Drawable drawable2 = drawable1;
    if (drawable1 == null)
      drawable2 = paramContext.getResources().getDrawable(getDefaultDrawableResId()); 
    setLoadingDrawable(drawable2);
    reset();
  }
  
  private void setSubHeaderText(CharSequence paramCharSequence) {
    if (this.mSubHeaderText != null) {
      if (TextUtils.isEmpty(paramCharSequence)) {
        this.mSubHeaderText.setVisibility(8);
        return;
      } 
      this.mSubHeaderText.setText(paramCharSequence);
      if (8 == this.mSubHeaderText.getVisibility())
        this.mSubHeaderText.setVisibility(0); 
    } 
  }
  
  private void setSubTextAppearance(int paramInt) {
    TextView textView = this.mSubHeaderText;
    if (textView != null)
      textView.setTextAppearance(getContext(), paramInt); 
  }
  
  private void setSubTextColor(ColorStateList paramColorStateList) {
    TextView textView = this.mSubHeaderText;
    if (textView != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  private void setTextAppearance(int paramInt) {
    TextView textView = this.mHeaderText;
    if (textView != null)
      textView.setTextAppearance(getContext(), paramInt); 
    textView = this.mSubHeaderText;
    if (textView != null)
      textView.setTextAppearance(getContext(), paramInt); 
  }
  
  private void setTextColor(ColorStateList paramColorStateList) {
    TextView textView = this.mHeaderText;
    if (textView != null)
      textView.setTextColor(paramColorStateList); 
    textView = this.mSubHeaderText;
    if (textView != null)
      textView.setTextColor(paramColorStateList); 
  }
  
  public final int getContentSize() {
    if (null.a[this.mScrollDirection.ordinal()] != 1) {
      int i = this.mRefreshingHeight;
      return (i != 0) ? i : (this.isHeaderStyleEnabled ? ("2".equals(AppInfo.e()) ? AppMethods.a(100) : AppMethods.a(65)) : ("2".equals(AppInfo.e()) ? AppMethods.a(60) : AppMethods.a(50)));
    } 
    return this.mInnerLayout.getWidth();
  }
  
  protected abstract int getDefaultDrawableResId();
  
  public final void hideAllViews() {
    if (this.mHeaderText.getVisibility() == 0)
      this.mHeaderText.setVisibility(4); 
    if (this.mHeaderProgress.getVisibility() == 0)
      this.mHeaderProgress.setVisibility(4); 
    if (this.mHeaderImage.getVisibility() == 0)
      this.mHeaderImage.setVisibility(4); 
    if (this.mSubHeaderText.getVisibility() == 0)
      this.mSubHeaderText.setVisibility(4); 
  }
  
  protected abstract void onLoadingDrawableSet(Drawable paramDrawable);
  
  public final void onPull(float paramFloat) {
    AnimationDrawable animationDrawable;
    if (!this.mUseIntrinsicAnimation) {
      onPullImpl(paramFloat);
      return;
    } 
    if (this.isHeaderStyleEnabled) {
      animationDrawable = (AnimationDrawable)this.mHeaderImage.getDrawable();
    } else {
      animationDrawable = (AnimationDrawable)this.mHeaderImage.getResources().getDrawable(R.drawable.loading_progress);
    } 
    if (animationDrawable != null) {
      if (animationDrawable.isRunning())
        animationDrawable.stop(); 
      int i = animationDrawable.getNumberOfFrames();
      if (i > 1 && paramFloat <= 1.0F)
        animationDrawable.selectDrawable(i - (int)(paramFloat * i) - 1); 
    } 
  }
  
  protected abstract void onPullImpl(float paramFloat);
  
  public final void pullToRefresh() {
    TextView textView = this.mHeaderText;
    if (textView != null && this.isHeaderStyleEnabled)
      textView.setText(this.mPullLabel); 
    if (this.mUseIntrinsicAnimation) {
      if ("1".equals(AppInfo.e()) && this.isHeaderStyleEnabled) {
        ((AnimationDrawable)this.mHeaderImage.getDrawable()).stop();
        ((AnimationDrawable)this.mHeaderImage.getDrawable()).selectDrawable(19);
        return;
      } 
    } else {
      pullToRefreshImpl();
    } 
  }
  
  protected abstract void pullToRefreshImpl();
  
  protected Drawable readDrawable(int paramInt) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inPurgeable = true;
    options.inInputShareable = true;
    Bitmap bitmap = BitmapFactory.decodeStream(getContext().getResources().openRawResource(paramInt), null, options);
    return (Drawable)((bitmap != null) ? new BitmapDrawable(getResources(), bitmap) : null);
  }
  
  public final void refreshing() {
    TextView textView = this.mHeaderText;
    if (textView != null && this.isHeaderStyleEnabled)
      textView.setText(this.mRefreshingLabel); 
    if (this.mUseIntrinsicAnimation) {
      if (this.isHeaderStyleEnabled) {
        ((AnimationDrawable)this.mHeaderImage.getDrawable()).stop();
        ((AnimationDrawable)this.mHeaderImage.getDrawable()).selectDrawable(0);
        ((AnimationDrawable)this.mHeaderImage.getDrawable()).start();
      } else {
        ((AnimationDrawable)this.mHeaderImage.getDrawable()).start();
      } 
    } else {
      refreshingImpl();
    } 
    textView = this.mSubHeaderText;
    if (textView != null)
      textView.setVisibility(8); 
  }
  
  protected abstract void refreshingImpl();
  
  public final void releaseToRefresh() {
    TextView textView = this.mHeaderText;
    if (textView != null && this.isHeaderStyleEnabled)
      textView.setText(this.mReleaseLabel); 
    releaseToRefreshImpl();
  }
  
  protected abstract void releaseToRefreshImpl();
  
  public final void reset() {
    TextView textView = this.mHeaderText;
    if (textView != null && this.isHeaderStyleEnabled)
      textView.setText(this.mReleaseLabel); 
    if (this.mUseIntrinsicAnimation) {
      ((AnimationDrawable)this.mHeaderImage.getDrawable()).stop();
    } else {
      resetImpl();
    } 
    textView = this.mSubHeaderText;
    if (textView != null) {
      if (TextUtils.isEmpty(textView.getText())) {
        this.mSubHeaderText.setVisibility(8);
        return;
      } 
      this.mSubHeaderText.setVisibility(0);
    } 
  }
  
  protected abstract void resetImpl();
  
  public void setHeaderBgImage() {
    if (this.isHeaderStyleEnabled) {
      if (this.isNeedBackgroudImage) {
        this.mHeaderLayout.setBackgroundDrawable(readDrawable(R.drawable.header_bg_blue));
        this.mHeaderText.setBackgroundDrawable(readDrawable(R.drawable.header_cloud_bg));
        return;
      } 
    } else {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
      layoutParams.gravity = 17;
      layoutParams.setMargins(0, 20, 0, 0);
      this.mHeaderImage.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  public final void setHeight(int paramInt) {
    (getLayoutParams()).height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence) {
    setSubHeaderText(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable) {
    this.mHeaderImage.setImageDrawable(paramDrawable);
    this.mUseIntrinsicAnimation = paramDrawable instanceof AnimationDrawable;
    onLoadingDrawableSet(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence) {
    this.mPullLabel = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence) {
    this.mRefreshingLabel = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence) {
    this.mReleaseLabel = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface) {
    this.mHeaderText.setTypeface(paramTypeface);
  }
  
  public final void setWidth(int paramInt) {
    (getLayoutParams()).width = paramInt;
    requestLayout();
  }
  
  public final void showInvisibleViews() {
    if (4 == this.mHeaderText.getVisibility())
      this.mHeaderText.setVisibility(0); 
    if (4 == this.mHeaderProgress.getVisibility())
      this.mHeaderProgress.setVisibility(0); 
    if (4 == this.mHeaderImage.getVisibility() && !"1".equals(AppInfo.e()))
      this.mHeaderImage.setVisibility(0); 
    if (4 == this.mSubHeaderText.getVisibility())
      this.mSubHeaderText.setVisibility(0); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\LoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */