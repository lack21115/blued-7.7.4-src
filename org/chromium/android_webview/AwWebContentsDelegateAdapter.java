package org.chromium.android_webview;

import android.content.Context;
import android.media.AudioManager;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import org.chromium.base.ThreadUtils;
import org.chromium.content_public.common.ResourceRequestBody;

class AwWebContentsDelegateAdapter extends AwWebContentsDelegate {
  final AwContents mAwContents;
  
  private final AwSettings mAwSettings;
  
  private View mContainerView;
  
  private final AwContentsClient mContentsClient;
  
  private final Context mContext;
  
  FrameLayout mCustomView;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwWebContentsDelegateAdapter(AwContents paramAwContents, AwContentsClient paramAwContentsClient, AwSettings paramAwSettings, Context paramContext, View paramView) {
    this.mAwContents = paramAwContents;
    this.mContentsClient = paramAwContentsClient;
    this.mAwSettings = paramAwSettings;
    this.mContext = paramContext;
    setContainerView(paramView);
  }
  
  private boolean tryToMoveFocus(int paramInt) {
    View view = this.mContainerView.focusSearch(paramInt);
    return (view != null && view != this.mContainerView && view.requestFocus());
  }
  
  public void activateContents() {
    this.mContentsClient.onRequestFocus();
  }
  
  public boolean addMessageToConsole(int paramInt1, String paramString1, int paramInt2, String paramString2) {
    switch (paramInt1) {
      default:
        Log.w("AwWebContentsDelegateAdapter", "Unknown message level, defaulting to DEBUG");
        paramInt1 = 4;
        break;
      case 3:
        paramInt1 = 3;
        break;
      case 2:
        paramInt1 = 2;
        break;
      case 1:
        paramInt1 = 1;
        break;
      case 0:
        paramInt1 = 0;
        break;
    } 
    boolean bool = this.mContentsClient.onConsoleMessage(new AwConsoleMessage(paramString1, paramString2, paramInt2, paramInt1));
    if (bool && paramString1 != null && paramString1.startsWith("[blocked]")) {
      StringBuilder stringBuilder = new StringBuilder("Blocked URL: ");
      stringBuilder.append(paramString1);
      Log.e("AwWebContentsDelegateAdapter", stringBuilder.toString());
    } 
    return bool;
  }
  
  public boolean addNewContents(boolean paramBoolean1, boolean paramBoolean2) {
    return this.mContentsClient.onCreateWindow(paramBoolean1, paramBoolean2);
  }
  
  public void closeContents() {
    this.mContentsClient.onCloseWindow();
  }
  
  public void enterFullscreenModeForTab(boolean paramBoolean) {
    if (!this.mAwContents.isFullScreen()) {
      AwContents awContents = this.mAwContents;
      if (AwContents.$assertionsDisabled || !awContents.isFullScreen()) {
        FullScreenView fullScreenView;
        if (awContents.isDestroyedOrNoOperation(0)) {
          fullScreenView = null;
        } else {
          awContents.onDetachedFromWindow();
          fullScreenView = new FullScreenView(awContents.mContext, awContents.mAwViewMethods, awContents);
          fullScreenView.setFocusable(true);
          fullScreenView.setFocusableInTouchMode(true);
          paramBoolean = awContents.mContainerView.isFocused();
          if (paramBoolean)
            fullScreenView.requestFocus(); 
          awContents.mFullScreenFunctor = new AwGLFunctor(awContents.mNativeDrawGLFunctorFactory, (ViewGroup)fullScreenView);
          AwContents$FullScreenTransitionsState awContents$FullScreenTransitionsState = awContents.mFullScreenTransitionsState;
          awContents$FullScreenTransitionsState.mFullScreenView = fullScreenView;
          awContents$FullScreenTransitionsState.mWasInitialContainerViewFocused = paramBoolean;
          awContents.mAwViewMethods = new NullAwViewMethods(awContents, awContents.mInternalAccessAdapter, (View)awContents.mContainerView);
          awContents.setInternalAccessAdapter(fullScreenView.mInternalAccessAdapter);
          awContents.setContainerView((ViewGroup)fullScreenView, awContents.mFullScreenFunctor);
        } 
        if (fullScreenView != null) {
          AwWebContentsDelegateAdapter$$Lambda$0 awWebContentsDelegateAdapter$$Lambda$0 = new AwWebContentsDelegateAdapter$$Lambda$0(this);
          this.mCustomView = new FrameLayout(this.mContext);
          this.mCustomView.addView((View)fullScreenView);
          this.mContentsClient.onShowCustomView((View)this.mCustomView, awWebContentsDelegateAdapter$$Lambda$0);
        } 
        return;
      } 
      throw new AssertionError();
    } 
  }
  
  public void exitFullscreenModeForTab() {
    if (this.mCustomView != null) {
      this.mCustomView = null;
      AwContents awContents = this.mAwContents;
      if (awContents.isFullScreen() && !awContents.isDestroyedOrNoOperation(0)) {
        AwViewMethods awViewMethods = awContents.mFullScreenTransitionsState.mInitialAwViewMethods;
        awViewMethods.onDetachedFromWindow();
        FullScreenView fullScreenView = awContents.mFullScreenTransitionsState.mFullScreenView;
        fullScreenView.mAwViewMethods = new NullAwViewMethods(awContents, fullScreenView.mInternalAccessAdapter, (View)fullScreenView);
        awContents.mAwViewMethods = awViewMethods;
        ViewGroup viewGroup = awContents.mFullScreenTransitionsState.mInitialContainerView;
        awContents.setInternalAccessAdapter(awContents.mFullScreenTransitionsState.mInitialInternalAccessAdapter);
        awContents.setContainerView(viewGroup, awContents.mInitialFunctor);
        if (awContents.mFullScreenTransitionsState.mWasInitialContainerViewFocused)
          awContents.mContainerView.requestFocus(); 
        awContents.mFullScreenTransitionsState.mFullScreenView = null;
        awContents.mFullScreenFunctor = null;
      } 
      this.mContentsClient.onHideCustomView();
    } 
  }
  
  public void handleKeyboardEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0) {
      char c;
      switch (paramKeyEvent.getKeyCode()) {
        default:
          c = Character.MIN_VALUE;
          break;
        case 22:
          c = 'B';
          break;
        case 21:
          c = '\021';
          break;
        case 20:
          c = '';
          break;
        case 19:
          c = '!';
          break;
      } 
      if (c != '\000' && tryToMoveFocus(c))
        return; 
    } 
    int i = paramKeyEvent.getKeyCode();
    if (i != 79 && i != 222) {
      switch (i) {
        default:
          switch (i) {
            default:
              break;
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
              break;
          } 
        case 85:
        case 86:
        case 87:
        case 88:
        case 89:
        case 90:
        case 91:
          ((AudioManager)this.mContext.getSystemService("audio")).dispatchMediaKeyEvent(paramKeyEvent);
          break;
      } 
      this.mContentsClient.onUnhandledKeyEvent(paramKeyEvent);
      return;
    } 
  }
  
  public void loadingStateChanged() {
    this.mContentsClient.updateTitle(this.mAwContents.getTitle(), false);
  }
  
  public void navigationStateChanged(int paramInt) {
    if ((paramInt & 0x1) != 0 && this.mAwContents.mIsPopupWindow) {
      boolean bool;
      AwContents awContents = this.mAwContents;
      if (awContents.isDestroyedOrNoOperation(0)) {
        bool = false;
      } else {
        bool = awContents.mWebContents.hasAccessedInitialDocument();
      } 
      if (bool) {
        String str1;
        AwContents awContents1 = this.mAwContents;
        bool = awContents1.isDestroyedOrNoOperation(0);
        awContents = null;
        if (!bool) {
          String str = awContents1.mWebContents.getLastCommittedUrl();
          if (str != null && !str.trim().isEmpty())
            str1 = str; 
        } 
        String str2 = str1;
        if (TextUtils.isEmpty(str1))
          str2 = "about:blank"; 
        AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mContentsClient.mCallbackHelper;
        awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(12, str2));
      } 
    } 
  }
  
  public final void onLoadProgressChanged(int paramInt) {
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mContentsClient.mCallbackHelper;
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(11, paramInt, 0));
  }
  
  public void onUpdateUrl(String paramString) {}
  
  public void openNewTab(String paramString1, String paramString2, ResourceRequestBody paramResourceRequestBody, int paramInt, boolean paramBoolean) {
    assert false;
    throw new AssertionError();
  }
  
  public void runFileChooser(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    AwContentsClient$FileChooserParamsImpl awContentsClient$FileChooserParamsImpl = new AwContentsClient$FileChooserParamsImpl(paramInt3, paramString1, paramString2, paramString3, paramBoolean);
    this.mContentsClient.showFileChooser(new AwWebContentsDelegateAdapter$2(this, paramInt1, paramInt2, paramInt3), awContentsClient$FileChooserParamsImpl);
  }
  
  public final void setContainerView(View paramView) {
    this.mContainerView = paramView;
    this.mContainerView.setClickable(true);
  }
  
  public boolean shouldBlockMediaRequest(String paramString) {
    return !(this.mAwSettings != null && (!this.mAwSettings.getBlockNetworkLoads() || !URLUtil.isNetworkUrl(paramString)));
  }
  
  public void showRepostFormWarningDialog() {
    AwWebContentsDelegateAdapter$1 awWebContentsDelegateAdapter$1 = new AwWebContentsDelegateAdapter$1(this, ThreadUtils.getUiThreadLooper());
    Message message1 = awWebContentsDelegateAdapter$1.obtainMessage(1);
    Message message2 = awWebContentsDelegateAdapter$1.obtainMessage(2);
    AwContentsClientCallbackHelper awContentsClientCallbackHelper = this.mContentsClient.mCallbackHelper;
    AwContentsClientCallbackHelper$OnFormResubmissionInfo awContentsClientCallbackHelper$OnFormResubmissionInfo = new AwContentsClientCallbackHelper$OnFormResubmissionInfo(message2, message1);
    awContentsClientCallbackHelper.mHandler.sendMessage(awContentsClientCallbackHelper.mHandler.obtainMessage(14, awContentsClientCallbackHelper$OnFormResubmissionInfo));
  }
  
  public boolean takeFocus(boolean paramBoolean) {
    boolean bool1;
    int i = this.mContainerView.getLayoutDirection();
    boolean bool = true;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramBoolean == bool1) {
      i = 66;
    } else {
      i = 17;
    } 
    if (tryToMoveFocus(i))
      return true; 
    if (paramBoolean) {
      i = bool;
    } else {
      i = 2;
    } 
    return tryToMoveFocus(i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwWebContentsDelegateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */