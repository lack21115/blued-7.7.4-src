package org.chromium.android_webview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import org.chromium.ui.base.ViewAndroidDelegate;

public final class AwViewAndroidDelegate extends ViewAndroidDelegate {
  private final Map mAnchorViews = new LinkedHashMap<Object, Object>();
  
  private final AwContentsClient mContentsClient;
  
  private final AwScrollOffsetManager mScrollManager;
  
  public AwViewAndroidDelegate(ViewGroup paramViewGroup, AwContentsClient paramAwContentsClient, AwScrollOffsetManager paramAwScrollOffsetManager) {
    super(paramViewGroup);
    this.mContentsClient = paramAwContentsClient;
    this.mScrollManager = paramAwScrollOffsetManager;
  }
  
  public final View acquireView() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return null; 
    View view = new View(viewGroup.getContext());
    viewGroup.addView(view);
    this.mAnchorViews.put(view, null);
    return view;
  }
  
  public final void onBackgroundColorChanged(int paramInt) {
    AwContentsClient awContentsClient = this.mContentsClient;
    int i = paramInt;
    if (paramInt == 0)
      i = 1; 
    awContentsClient.mCachedRendererBackgroundColor = i;
  }
  
  public final void removeView(View paramView) {
    this.mAnchorViews.remove(paramView);
    ViewGroup viewGroup = getContainerView();
    if (viewGroup != null)
      viewGroup.removeView(paramView); 
  }
  
  public final void setViewPosition(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2) {
    ViewGroup viewGroup = getContainerView();
    if (this.mAnchorViews.containsKey(paramView)) {
      if (viewGroup == null)
        return; 
      this.mAnchorViews.put(paramView, new AwViewAndroidDelegate$Position(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2));
      if (viewGroup instanceof android.widget.FrameLayout) {
        super.setViewPosition(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
        return;
      } 
      int i = this.mScrollManager.mNativeScrollX;
      int j = this.mScrollManager.mNativeScrollY;
      paramView.setLayoutParams((ViewGroup.LayoutParams)new AbsoluteLayout.LayoutParams(Math.round(paramFloat3), Math.round(paramFloat4), paramInt1 + i, paramInt2 + j));
      return;
    } 
  }
  
  public final void updateAnchorViews(ViewGroup paramViewGroup) {
    for (Map.Entry entry : this.mAnchorViews.entrySet()) {
      View view = (View)entry.getKey();
      AwViewAndroidDelegate$Position awViewAndroidDelegate$Position = (AwViewAndroidDelegate$Position)entry.getValue();
      if (paramViewGroup != null)
        paramViewGroup.removeView(view); 
      this.mContainerView.addView(view);
      if (awViewAndroidDelegate$Position != null)
        setViewPosition(view, awViewAndroidDelegate$Position.mX, awViewAndroidDelegate$Position.mY, awViewAndroidDelegate$Position.mWidth, awViewAndroidDelegate$Position.mHeight, awViewAndroidDelegate$Position.mLeftMargin, awViewAndroidDelegate$Position.mTopMargin); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwViewAndroidDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */