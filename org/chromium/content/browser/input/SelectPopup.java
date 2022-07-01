package org.chromium.content.browser.input;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.PopupController;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

public class SelectPopup implements PopupController.HideablePopup, WindowEventObserver, ViewAndroidDelegate.ContainerViewObserver {
  private View mContainerView;
  
  private Context mContext;
  
  private boolean mInitialized;
  
  private long mNativeSelectPopup;
  
  private long mNativeSelectPopupSourceFrame;
  
  private SelectPopup$Ui mPopupView;
  
  private final WebContentsImpl mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SelectPopup(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
  }
  
  public static SelectPopup create(Context paramContext, WebContents paramWebContents) {
    SelectPopup selectPopup = (SelectPopup)paramWebContents.getOrSetUserData(SelectPopup.class, SelectPopup$UserDataFactoryLazyHolder.access$000());
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void destroy() {
    this.mNativeSelectPopup = 0L;
  }
  
  private native WindowAndroid nativeGetWindowAndroid(long paramLong);
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeSelectMenuItems(long paramLong1, long paramLong2, int[] paramArrayOfint);
  
  @CalledByNative
  private void show(View paramView, long paramLong, String[] paramArrayOfString, int[] paramArrayOfint1, boolean paramBoolean1, int[] paramArrayOfint2, boolean paramBoolean2) {
    ViewParent viewParent = this.mContainerView.getParent();
    View view = null;
    if (viewParent == null || this.mContainerView.getVisibility() != 0) {
      this.mNativeSelectPopupSourceFrame = paramLong;
      selectMenuItems(null);
      return;
    } 
    PopupController.hidePopupsAndClearSelection((WebContents)this.mWebContents);
    assert false;
    throw new AssertionError("Zombie popup did not clear the frame source");
  }
  
  public final void hide() {
    if (this.mPopupView != null)
      this.mPopupView.hide(true); 
  }
  
  @CalledByNative
  public void hideWithoutCancel() {
    if (this.mPopupView == null)
      return; 
    this.mPopupView.hide(false);
    this.mPopupView = null;
    this.mNativeSelectPopupSourceFrame = 0L;
  }
  
  public final void onAttachedToWindow() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public final void onDetachedFromWindow() {}
  
  public final void onRotationChanged(int paramInt) {}
  
  public final void onUpdateContainerView(ViewGroup paramViewGroup) {
    this.mContainerView = (View)paramViewGroup;
    hide();
  }
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {
    this.mPopupView = null;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
  
  public final void selectMenuItems(int[] paramArrayOfint) {
    if (this.mNativeSelectPopup != 0L)
      nativeSelectMenuItems(this.mNativeSelectPopup, this.mNativeSelectPopupSourceFrame, paramArrayOfint); 
    this.mNativeSelectPopupSourceFrame = 0L;
    this.mPopupView = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SelectPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */