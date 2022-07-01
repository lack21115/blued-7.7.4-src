package org.chromium.ui.base;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;

public class ViewAndroidDelegate {
  public ViewGroup mContainerView;
  
  public ObserverList mContainerViewObservers = new ObserverList();
  
  private int[] mTemporaryContainerLocation = new int[2];
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ViewAndroidDelegate(ViewGroup paramViewGroup) {
    this.mContainerView = paramViewGroup;
  }
  
  @CalledByNative
  private int getXLocationOfContainerViewInWindow() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return 0; 
    viewGroup.getLocationInWindow(this.mTemporaryContainerLocation);
    return this.mTemporaryContainerLocation[0];
  }
  
  @CalledByNative
  private int getXLocationOnScreen() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return 0; 
    viewGroup.getLocationOnScreen(this.mTemporaryContainerLocation);
    return this.mTemporaryContainerLocation[0];
  }
  
  @CalledByNative
  private int getYLocationOfContainerViewInWindow() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return 0; 
    viewGroup.getLocationInWindow(this.mTemporaryContainerLocation);
    return this.mTemporaryContainerLocation[1];
  }
  
  @CalledByNative
  private int getYLocationOnScreen() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return 0; 
    viewGroup.getLocationOnScreen(this.mTemporaryContainerLocation);
    return this.mTemporaryContainerLocation[1];
  }
  
  @CalledByNative
  private boolean hasFocus() {
    ViewGroup viewGroup = getContainerView();
    return (viewGroup == null) ? false : ViewUtils.hasFocus((View)viewGroup);
  }
  
  @CalledByNative
  private void requestDisallowInterceptTouchEvent() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup != null)
      viewGroup.requestDisallowInterceptTouchEvent(true); 
  }
  
  @CalledByNative
  private void requestFocus() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup != null && ViewUtils.isFocusable((View)viewGroup) && !viewGroup.isFocused())
      viewGroup.requestFocus(); 
  }
  
  @TargetApi(21)
  @CalledByNative
  private void requestUnbufferedDispatch(MotionEvent paramMotionEvent) {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup != null)
      viewGroup.requestUnbufferedDispatch(paramMotionEvent); 
  }
  
  @TargetApi(24)
  @CalledByNative
  private boolean startDragAndDrop(String paramString, Bitmap paramBitmap) {
    if (Build.VERSION.SDK_INT <= 23)
      return false; 
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return false; 
    ImageView imageView = new ImageView(viewGroup.getContext());
    imageView.setImageBitmap(paramBitmap);
    imageView.layout(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    return viewGroup.startDragAndDrop(ClipData.newPlainText(null, paramString), new View.DragShadowBuilder((View)imageView), null, 256);
  }
  
  @CalledByNative
  public View acquireView() {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null || viewGroup.getParent() == null)
      return null; 
    View view = new View(viewGroup.getContext());
    viewGroup.addView(view);
    return view;
  }
  
  public final void addObserver(ViewAndroidDelegate$ContainerViewObserver paramViewAndroidDelegate$ContainerViewObserver) {
    this.mContainerViewObservers.addObserver(paramViewAndroidDelegate$ContainerViewObserver);
  }
  
  @CalledByNative
  public final ViewGroup getContainerView() {
    return this.mContainerView;
  }
  
  @CalledByNative
  public int getSystemWindowInsetBottom() {
    return 0;
  }
  
  @CalledByNative
  public void onBackgroundColorChanged(int paramInt) {}
  
  @CalledByNative
  public void onBottomControlsChanged(float paramFloat1, float paramFloat2) {}
  
  @CalledByNative
  public void onCursorChanged(int paramInt) {
    if (Build.VERSION.SDK_INT < 24)
      return; 
    char c = 'ϴ';
    switch (paramInt) {
      default:
        paramInt = 1000;
        break;
      case 43:
        assert false : "onCursorChangedToCustom must be called instead";
      case 42:
        paramInt = 1021;
        break;
      case 41:
        paramInt = 1020;
        break;
      case 40:
        paramInt = 1019;
        break;
      case 39:
        paramInt = 1018;
        break;
      case 38:
        paramInt = c;
        break;
      case 37:
        paramInt = 0;
        break;
      case 36:
        paramInt = 1011;
        break;
      case 35:
        paramInt = c;
        break;
      case 34:
        paramInt = 1004;
        break;
      case 33:
        paramInt = 1010;
        break;
      case 32:
        paramInt = 1001;
        break;
      case 31:
        paramInt = 1006;
        break;
      case 30:
        paramInt = 1009;
        break;
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
        assert false : "These pointer icon types are not supported";
      case 20:
      case 29:
        paramInt = 1013;
        break;
      case 19:
        paramInt = 1015;
        break;
      case 18:
        paramInt = 1014;
        break;
      case 17:
        paramInt = 1017;
        break;
      case 16:
        paramInt = 1016;
        break;
      case 15:
        paramInt = 1014;
        break;
      case 14:
        paramInt = 1015;
        break;
      case 13:
        paramInt = 1014;
        break;
      case 12:
        paramInt = 1016;
        break;
      case 11:
        paramInt = 1017;
        break;
      case 10:
        paramInt = 1015;
        break;
      case 9:
        paramInt = 1017;
        break;
      case 8:
        paramInt = 1016;
        break;
      case 7:
        paramInt = 1015;
        break;
      case 6:
        paramInt = 1014;
        break;
      case 5:
        paramInt = 1003;
        break;
      case 4:
        paramInt = 1004;
        break;
      case 3:
        paramInt = 1008;
        break;
      case 2:
        paramInt = 1002;
        break;
      case 1:
        paramInt = 1007;
        break;
      case 0:
        paramInt = 1000;
        break;
    } 
    ViewGroup viewGroup = getContainerView();
    viewGroup.setPointerIcon(PointerIcon.getSystemIcon(viewGroup.getContext(), paramInt));
  }
  
  @CalledByNative
  public void onCursorChangedToCustom(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    if (Build.VERSION.SDK_INT >= 24) {
      PointerIcon pointerIcon = PointerIcon.create(paramBitmap, paramInt1, paramInt2);
      getContainerView().setPointerIcon(pointerIcon);
    } 
  }
  
  @CalledByNative
  public void onTopControlsChanged(float paramFloat1, float paramFloat2) {}
  
  @CalledByNative
  public void removeView(View paramView) {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return; 
    viewGroup.removeView(paramView);
  }
  
  @CalledByNative
  public void setViewPosition(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2) {
    ViewGroup viewGroup = getContainerView();
    if (viewGroup == null)
      return; 
    int j = Math.round(paramFloat3);
    int k = Math.round(paramFloat4);
    if (ApiCompatibilityUtils.isLayoutRtl((View)viewGroup))
      paramInt1 = viewGroup.getMeasuredWidth() - Math.round(paramFloat3 + paramFloat1); 
    int i = j;
    if (j + paramInt1 > viewGroup.getWidth())
      i = viewGroup.getWidth() - paramInt1; 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, k);
    MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)layoutParams, paramInt1);
    layoutParams.topMargin = paramInt2;
    paramView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void updateAnchorViews(ViewGroup paramViewGroup) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\ViewAndroidDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */