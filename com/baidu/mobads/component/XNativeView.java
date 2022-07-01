package com.baidu.mobads.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.c.a;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;

public class XNativeView extends RelativeLayout implements View.OnClickListener {
  private static final int COVER_PIC_ID = 17;
  
  private static final int LOADING_VIEW_ID = 18;
  
  private static final int PAUSE_ID = 16;
  
  private static final String PLAY_ICON_STRING = "iVBORw0KGgoAAAANSUhEUgAAAJAAAACQCAYAAADnRuK4AAAABHNCSVQICAgIfAhkiAAADT5JREFU\neJztnXtsleUdxz897YFKL1AQKEUFKsjqAqgILotIzBYQdERilqAsMTAuIoMNGEtmt8G0cUuj/GFM\nDDFk/lGRqBXZisCMiGBAWjsuQS4ttFx6A6QX2kLpoefsj985tLQ97bm873ne9z3PJznhWM/lC8+3\nz+33e55fAvGHC0gHBgND/H8OBNxdHgO6PAfw+B/tXZ57gFtAE9Do//M64I3R38MSJKgWYDJuIBMY\nBWQghklDTGQGXsRETUADUAvUIWZzJE4zUCIwEsgCRgPDMc8soeIFrgLVQA1wGehQqshAnGAgNzAO\nGI/0NIlq5fRLB9IzlQPnsXnvZFcDJSA9zATEPElq5UTMbaASKEN6J59aOeFjNwOlAzmIcQYp1mI0\nrcBZ4BQyj7IFdjHQEOBRZJiyi+ZI8SFGOoKs7iyN1RvjXsQ441QLUUQFcBT4UbWQYFjVQMOBqcAD\nqoVYhItAKbKasxRWM9BAYDoyz9H05BRQjGxgWgKrGCgBeAh4AkhWrMXqtAGHkZWb8lWbFQw0DHgS\n2QDUhE4d8C1Qr1KESgO5kHnOI4p12BkfMskuRVEMTlXDpQC/QOJUmuipA75C9pJiiopt//uBucje\njsYYUpE5ZD0x3oSMpYFcwDRgBvYNPViZJGSHPhGJtcVkgh0rAyUDc5CdZI25ZCLZCBeQWJupxMJA\nqcCvkF1lTWxIBcYgJmo384vMNtBQxDxpJn+PpifJwINAFXDTrC8x00CZwLPojUGVuJFpQx3QYsYX\nmGWgMcAzdOYUa9SRiJioHkm1NfzDjWYMMAv1qaSaTlzIcHYNg01ktIEykZ5Hm8d6JCBpMbUYOJwZ\naaChyJxHD1vWxYWY6CIGTayNMlBgqa4nzNYnERiLJKtFvcQ3wkDJ6KW63XAjIaVzRLnZGK2BXMgO\ns94ktB/JSApNOVGEPaI10DR0eMLOpCKdQHWkHxCNge5HAqMae5MJXCHCKH6ky+0U4OkI36uxHk8j\nbRo2kRjIhSSD6RWXc0hG2jRsP0QyhD2O5J1onEUqstlYE86bwnXcMCSHWeNMHkE2hEMmHAMlIKcn\ndAK8cwm7jcMx0EPoozfxQCbS1iERqoEGIof+NPHBE0ib90uoBpqOXnXFE8lIm/dLKAYajj6rHo/k\nIG3fJ6EYaGr0WjQ2pd+2789A96KvWIlnHkC2boLSn4EeNU6Lxqb06YG+DDSE+L0ZTNNJNn0cQ+/L\nQLr30QQIGn0IZqB0dJ6PppMJBMk4DWagHHTIQtNJAkG2cnozUAIOi7a/+eabk8+ePbuqsLBwVmZm\n5gDVemzKBHrpVHrrZe5D7u9xDM3Nzf9ITU0dCtDa2tpQUFDw+cqVK7/r6HBMyYpYsZNu6a+99UCO\n6n0AAuYBSElJyVi+fPmi6urq19auXeu4v6vJ9AiydjdQoHCJ4xk5cuSYt99++48nT55cPmfOnH63\n7DWAeOOug6PdDWTnwiURkZOT81hRUdHGffv2vZCdnX2Paj0WJwk5lHiH7gaKy6W7y+VKmjlz5qwf\nfvghr6CgYOagQYP02f7g3DXsd/2HSkTqbcUtycnJqQsXLnzp0qVLf9u4ceNPVeuxKHfVZOtqoJFY\nv1hbTBg6dOioDRs2rD537tzvFyxYkKVaj8UIVIUE7jbQ6NhrsTbZ2dkPb9269a+HDx9+acqUKamq\n9ViIO79Urt5+qOkkISHBNX369JklJSV527dvn5WRkRFXi4wg9DCQmxCyz+IZt9t9z/PPP//C+fPn\n/75p06Z4T7IbgX85HzBQJpEfc44r0tPT712zZs2yqqqq9cuWLRujWo8iXPjLVARME9err0gYPXr0\n+M2bN//52LFji5566qkM1XoUMAo6DRSP/wBGkDB58uSf7d279/Xdu3fPy8rKiqdAbQZ0GkgXPomC\nxMTEAbNnz362rKws7/333/+52+2Oh1SYwSAGcqGvpzOElJSUwUuWLHm5qqrqtfXr14d8utOmpAMu\nV+CJYjGOYsSIEQ/k5+evO3369IrnnntuhGo9JuEC0lz4uyKN8UycOPGRHTt2bNy/f/+vJ06cOEi1\nHhMY4kLPf0zF5XIlzpgx45fHjh3L27p169MOC9QO1j1QjBg4cGDKiy++uKCqqmpDXl7eJNV6DGKw\nixBvYdAYQ0ZGRmZubu7vKisr/7Bw4UK7xx+TXejSBEoYO3ZsTkFBwV+Ki4t/M3XqVLuugt0uIJ42\nv6yGa9q0aTMOHTqUt2PHjmeGDRtmt0CtW/dAFsDtdifPmzdvfmVl5evvvPPO46r1hIE2kJVIS0sb\ntmrVqqU1NTV/evXVV+1wuMGdALyMwyfSPp9vs2oNkXD8+PHi+fPnb62oqDCt5mmUtOkeyMJMnjx5\n+p49e36rWkcfDHDSppZGAS7Ao1qEpndOnDhRPHv27C2qdfRBuzaQBamtra1YuXLlPydNmrTFwvMf\nAE8SBpQ91BhDc3Nz/QcffPDZ6tWrS1RrCRFPEroHUo7H42nbvXv37kWLFn157dq1qEpQxhhtIMV4\nS0tLDy5fvvzz0tLSZtViIkAbSBUXLlw4lZub+8mHH34YcblJC9CeBNxSrSKeaGhoqHvvvfcKc3Nz\nj6vWYgC3koAm1SrigVu3brVu3769aOnSpd+0tLQ45Wq0piSgUbUKJ+P1ejsOHjz49ZIlS3aeOXPm\nhmo9BtOkeyATKSsrO7Zu3bpPi4qKrqjWYhKNSUi5Zy/6ZIZhXL169dJbb731SX5+/hnVWkzECzQn\nBZ6gc6OjprW1tWnbtm2fr1ix4pDH4/Gp1mMy1wFvIAOuEW2giOno6Gjfu3fvl4sXL95TVVUVL6va\nRui8ULMBiNebJqLBd/z48ZJVq1Z9tn///gbVYmLMXQaqRZfzDovq6upzb7zxxsebN28+r1qLImqh\n00B16Il0SDQ3N/+4ZcuWz9asWVOqWotCvIhn7hjIA1xFl/UOisfjublz585dixcv/qqhocFOAU8z\nuII/BNb1GEk12kA98Pl83pKSkm9feeWVfx85csSOAU8zqAk8Ser2w8dir8W6VFRUnMzNzf1k27Zt\nNf2/Oq7o1UCXgQ70XdHU19fXvvvuu59u2LDhhGotFqQD8Qpwt4E6kJn1fbFWZBXa2tpaCgsL/7Ns\n2bL9N27c8KrWY1FqEa8APQurnCUODeT1em8fOHDg66VLl+4sLy+3cg6yFSjv+h/dDVQJPNnLzx3L\n6dOnj6xdu7Zw165dV1VrsQG3EY/cobtRPP4XOL4Q2+XLly/m5+d/vGnTpvL+X63xU4GY6A699TRl\nOMxALS0t9V1KXjb6S14e0iUvw6bHL1tvK64W4Cc46NqXtLS0q1lZWYP27dt3YO7cuf/66KOPLvh8\nTg+WG04rcLD7D4PdZ/wEMMVUORq7cRQo7v7DYLGvU4D+FdUE8CGe6EEwA11HlvQaDcjcp9cwTl/R\n9yPmaNHYkKPB/kdfBmpElm2a+KaCPk7u9Jf/E9R5mrihz5GoPwP9CFw0TovGZlwErvX1glAyEOM5\n8y7e+b6/F4SSunEDGISuqRpvnARO9/eiUHOgi4G2qORo7EQbENIlV6Ea6BZwOGI5GrvxHSHe2hLO\nKYwy/Jn4GkdTh7R1SIRjIB/wLTrE4WQCbRwy4eY/3/S/R5cJdyZHgHPhvCGSg4Sl6KHMidQB/wv3\nTZEYyAt8hV6VOYk2pE3DPkgQ6REeD1CPwzIX45gvkahD2ERzBuy6//2ZUXyGRj1HCZLrEwrRXqbw\nPXo+ZGfqCCFc0RfRnkL1AReQu4WSo/wsTWxpBL4gynvCjTjGfBsx0YPo2mN2oRUoQuKcUWHUOfh2\noAoYb+BnasyhHTHPdSM+zMjGvomMqePRF1VZlQ5gFxGuuHrD6N6iBVneP0jwI0MaNfiA/yL3QBmG\nGcNNE5LFNg7dE1mFDsQ8hmeXmjVfaUKuARln4ndoQqMdGbZMqQpkZuO2II4fi16dqSKw2jJsztMd\ns3uHm8ixkPvR+0SxphEDV1vBiMXw0o6kCIwEUmPwfRpZDX+BAfs8/RGr+clt5HisCx07M5ujwD5i\nVIkylhNcHzKRu4IMaXFzC1qMaEOi6jG9GEPFCilwccMI9JBmFHXATkycLAdD1RLbgwxpCciQpjcd\nI8OHpKF+g8w1Y44VGm4ocrGnnhuFRx2SAF+vUoQVDASi4yHkZjS93O+bNuTcVshHb8zEKgYKMBCY\nDuSoFmJRTiInRi1T1M5qBgowHJgKPKBaiEW4iGQOxnyS3B9WNVCAYcCjQLZqIYqoQCbJfV6xohKr\nGyjAEKSi4gTsozlSfMgK9Sh93AxmFezWGGnAw0jSWopiLUbTihjnFEEutLQidjNQgAQgC1m5jcO+\nu9q3kWGqHKnBZbt7B+xqoK64kZSRCciZfavnHwXKapUjdUlsXT7TCQbqSiIS9c/yP0agPivSi8T/\navyPQGE/R+A0A3XHjexwjwIygMFAOuaZyovE+hr9j1pkxzgmkXEVON1AveFCJuNDEEMNRna/3b08\nAgVn2hETdH+0Iem7TYhhmongggI7838jQjJwZ8OEVQAAAABJRU5ErkJggg==\n";
  
  private static final String TAG = "XNativeView";
  
  private q mAdLogger = new q();
  
  private ImageView mCoverPic;
  
  private XAdNativeResponse mCurrentNativeItem;
  
  public View mLoadingView;
  
  private INativeViewClickListener mNativeViewListener;
  
  private ImageView mPauseBtn;
  
  private FeedPortraitVideoView mVideoView;
  
  private boolean videoMute = true;
  
  public XNativeView(Context paramContext) {
    super(paramContext);
    setBackgroundColor(Color.parseColor("#000000"));
    XNativeViewManager.getInstance().addItem(this);
  }
  
  public XNativeView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setBackgroundColor(Color.parseColor("#000000"));
    XNativeViewManager.getInstance().addItem(this);
  }
  
  public XNativeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setBackgroundColor(Color.parseColor("#000000"));
    XNativeViewManager.getInstance().addItem(this);
  }
  
  private void hideCoverPic() {
    ImageView imageView = this.mPauseBtn;
    if (imageView != null)
      imageView.setVisibility(4); 
    imageView = this.mCoverPic;
    if (imageView != null)
      imageView.setVisibility(4); 
    View view = this.mLoadingView;
    if (view != null)
      view.setVisibility(4); 
  }
  
  private void hidePauseBtn() {
    ImageView imageView = this.mPauseBtn;
    if (imageView != null)
      imageView.setVisibility(4); 
    imageView = this.mCoverPic;
    if (imageView != null)
      imageView.setVisibility(0); 
    View view = this.mLoadingView;
    if (view != null)
      view.setVisibility(0); 
  }
  
  private void initAdVideoView() {
    FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
    if (feedPortraitVideoView == null)
      return; 
    feedPortraitVideoView.setCanClickVideo(true);
    this.mVideoView.setAdData(this.mCurrentNativeItem);
    this.mVideoView.setVideoMute(this.videoMute);
  }
  
  private boolean isVisible(View paramView, int paramInt) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null) {
      bool1 = bool2;
      if (paramView.getVisibility() == 0) {
        if (paramView.getParent() == null)
          return false; 
        Rect rect = new Rect();
        if (!paramView.getGlobalVisibleRect(rect))
          return false; 
        long l1 = rect.height();
        long l2 = rect.width();
        long l3 = paramView.getHeight() * paramView.getWidth();
        if (l3 <= 0L)
          return false; 
        bool1 = bool2;
        if (l1 * l2 * 100L >= paramInt * l3)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  private void play() {
    if (this.mVideoView != null) {
      initAdVideoView();
      hidePauseBtn();
      this.mVideoView.play();
    } 
  }
  
  private void renderView() {
    XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
    if (xAdNativeResponse == null)
      return; 
    NativeResponse.MaterialType materialType = xAdNativeResponse.getMaterialType();
    if (this.mVideoView == null) {
      this.mVideoView = new FeedPortraitVideoView(getContext());
      addView((View)this.mVideoView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      this.mVideoView.setFeedPortraitListener(new a(this));
    } 
    if (materialType == NativeResponse.MaterialType.NORMAL) {
      this.mVideoView.showNormalPic(this.mCurrentNativeItem);
      return;
    } 
    if (materialType == NativeResponse.MaterialType.VIDEO)
      showView(); 
  }
  
  private boolean shouldAutoPlay() {
    boolean bool1;
    boolean bool2;
    XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
    boolean bool3 = true;
    if (xAdNativeResponse != null && xAdNativeResponse.isAutoPlay()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    xAdNativeResponse = this.mCurrentNativeItem;
    if (xAdNativeResponse == null || xAdNativeResponse.isNonWifiAutoPlay()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Boolean bool = XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getContext().getApplicationContext());
    if (!bool1 || !bool.booleanValue()) {
      if (bool2 && !bool.booleanValue())
        return true; 
      bool3 = false;
    } 
    return bool3;
  }
  
  private void showView() {
    if (this.mCoverPic == null) {
      this.mCoverPic = new ImageView(getContext());
      this.mCoverPic.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.mCoverPic.setId(17);
      addView((View)this.mCoverPic, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    } 
    if (this.mCoverPic != null)
      a.a().a(this.mCoverPic, this.mCurrentNativeItem.getImageUrl()); 
    if (this.mPauseBtn == null) {
      this.mPauseBtn = new ImageView(getContext());
      this.mPauseBtn.setImageBitmap(XAdSDKFoundationFacade.getInstance().getBitmapUtils().string2bitmap("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\n"));
      this.mPauseBtn.setScaleType(ImageView.ScaleType.FIT_XY);
      this.mPauseBtn.setId(16);
      this.mPauseBtn.setOnClickListener(this);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(120, 120);
      layoutParams.addRule(13);
      addView((View)this.mPauseBtn, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.mLoadingView == null) {
      this.mLoadingView = (View)new ProgressBar(getContext());
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(13);
      this.mLoadingView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.mLoadingView.setVisibility(4);
      addView(this.mLoadingView);
    } 
    handleCover();
  }
  
  public void handleCover() {
    ImageView imageView = this.mCoverPic;
    if (imageView != null)
      imageView.setVisibility(0); 
    imageView = this.mPauseBtn;
    if (imageView != null)
      imageView.setVisibility(0); 
    View view = this.mLoadingView;
    if (view != null)
      view.setVisibility(4); 
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    XNativeViewManager.getInstance().addItem(this);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == 16 || paramView.getId() == 17) {
      INativeViewClickListener iNativeViewClickListener = this.mNativeViewListener;
      if (iNativeViewClickListener != null)
        iNativeViewClickListener.onNativeViewClick(this); 
      if (this.mCurrentNativeItem.isDownloadApp()) {
        this.mCurrentNativeItem.handleClick((View)this);
        play();
        return;
      } 
      this.mCurrentNativeItem.handleClick((View)this);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    XNativeViewManager.getInstance().removeNativeView(this);
  }
  
  public void onScroll() {
    if (!isVisible((View)this, 50))
      pause(); 
  }
  
  public void onScrollStateChanged(int paramInt) {
    if (paramInt == 0)
      render(); 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    if (paramBoolean) {
      resume();
    } else {
      pause();
    } 
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void pause() {
    FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
    if (feedPortraitVideoView != null)
      feedPortraitVideoView.pause(); 
  }
  
  public void render() {
    if (shouldAutoPlay())
      play(); 
  }
  
  public void resume() {
    FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
    if (feedPortraitVideoView != null)
      feedPortraitVideoView.resume(); 
  }
  
  public void setNativeItem(NativeResponse paramNativeResponse) {
    this.mCurrentNativeItem = (XAdNativeResponse)paramNativeResponse;
    renderView();
  }
  
  public void setNativeItem(XAdNativeResponse paramXAdNativeResponse) {
    this.mCurrentNativeItem = paramXAdNativeResponse;
    renderView();
  }
  
  public void setNativeViewClickListener(INativeViewClickListener paramINativeViewClickListener) {
    this.mNativeViewListener = paramINativeViewClickListener;
  }
  
  public void setVideoMute(boolean paramBoolean) {
    this.videoMute = paramBoolean;
    FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
    if (feedPortraitVideoView != null)
      feedPortraitVideoView.setVideoMute(this.videoMute); 
  }
  
  public void stop() {
    FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
    if (feedPortraitVideoView != null)
      feedPortraitVideoView.stop(); 
  }
  
  public static interface INativeViewClickListener {
    void onNativeViewClick(XNativeView param1XNativeView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\component\XNativeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */