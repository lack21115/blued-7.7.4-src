package org.chromium.content.browser.input;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.PopupController;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

public class TextSuggestionHost implements PopupController.HideablePopup, WindowEventObserver {
  private Context mContext;
  
  private boolean mInitialized;
  
  private boolean mIsAttachedToWindow;
  
  long mNativeTextSuggestionHost;
  
  private SpellCheckPopupWindow mSpellCheckPopupWindow;
  
  private TextSuggestionsPopupWindow mTextSuggestionsPopupWindow;
  
  private ViewAndroidDelegate mViewDelegate;
  
  private final WebContentsImpl mWebContents;
  
  private WindowAndroid mWindowAndroid;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public TextSuggestionHost(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
  }
  
  public static TextSuggestionHost create(Context paramContext, WebContents paramWebContents, WindowAndroid paramWindowAndroid) {
    TextSuggestionHost textSuggestionHost = (TextSuggestionHost)paramWebContents.getOrSetUserData(TextSuggestionHost.class, TextSuggestionHost$UserDataFactoryLazyHolder.access$000());
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void destroy() {
    hidePopups();
    this.mNativeTextSuggestionHost = 0L;
  }
  
  private float getContentOffsetYPix() {
    return this.mWebContents.mRenderCoordinates.mTopContentOffsetYPix;
  }
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeOnSuggestionMenuClosed(long paramLong);
  
  @CalledByNative
  private void showSpellCheckSuggestionMenu(double paramDouble1, double paramDouble2, String paramString, String[] paramArrayOfString) {
    if (!this.mIsAttachedToWindow) {
      onSuggestionMenuClosed(false);
      return;
    } 
    hidePopups();
    this.mSpellCheckPopupWindow = new SpellCheckPopupWindow(this.mContext, this, this.mWindowAndroid, (View)this.mViewDelegate.getContainerView());
    this.mSpellCheckPopupWindow.show(paramDouble1, paramDouble2 + getContentOffsetYPix(), paramString, paramArrayOfString);
  }
  
  @CalledByNative
  private void showTextSuggestionMenu(double paramDouble1, double paramDouble2, String paramString, SuggestionInfo[] paramArrayOfSuggestionInfo) {
    if (!this.mIsAttachedToWindow) {
      onSuggestionMenuClosed(false);
      return;
    } 
    hidePopups();
    this.mTextSuggestionsPopupWindow = new TextSuggestionsPopupWindow(this.mContext, this, this.mWindowAndroid, (View)this.mViewDelegate.getContainerView());
    this.mTextSuggestionsPopupWindow.show(paramDouble1, paramDouble2 + getContentOffsetYPix(), paramString, paramArrayOfSuggestionInfo);
  }
  
  public final void hide() {
    hidePopups();
  }
  
  @CalledByNative
  public void hidePopups() {
    if (this.mTextSuggestionsPopupWindow != null && this.mTextSuggestionsPopupWindow.mPopupWindow.isShowing()) {
      this.mTextSuggestionsPopupWindow.mPopupWindow.dismiss();
      this.mTextSuggestionsPopupWindow = null;
    } 
    if (this.mSpellCheckPopupWindow != null && this.mSpellCheckPopupWindow.mPopupWindow.isShowing()) {
      this.mSpellCheckPopupWindow.mPopupWindow.dismiss();
      this.mSpellCheckPopupWindow = null;
    } 
  }
  
  native void nativeApplySpellCheckSuggestion(long paramLong, String paramString);
  
  native void nativeApplyTextSuggestion(long paramLong, int paramInt1, int paramInt2);
  
  native void nativeDeleteActiveSuggestionRange(long paramLong);
  
  native void nativeOnNewWordAddedToDictionary(long paramLong, String paramString);
  
  public final void onAttachedToWindow() {
    this.mIsAttachedToWindow = true;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public final void onDetachedFromWindow() {
    this.mIsAttachedToWindow = false;
  }
  
  public final void onRotationChanged(int paramInt) {
    hidePopups();
  }
  
  public final void onSuggestionMenuClosed(boolean paramBoolean) {
    if (!paramBoolean)
      nativeOnSuggestionMenuClosed(this.mNativeTextSuggestionHost); 
    this.mSpellCheckPopupWindow = null;
    this.mTextSuggestionsPopupWindow = null;
  }
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {
    this.mWindowAndroid = paramWindowAndroid;
    if (this.mSpellCheckPopupWindow != null)
      this.mSpellCheckPopupWindow.mWindowAndroid = this.mWindowAndroid; 
    if (this.mTextSuggestionsPopupWindow != null)
      this.mTextSuggestionsPopupWindow.mWindowAndroid = this.mWindowAndroid; 
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\TextSuggestionHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */