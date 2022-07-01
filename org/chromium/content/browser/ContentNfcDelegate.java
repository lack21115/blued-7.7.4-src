package org.chromium.content.browser;

import android.app.Activity;
import org.chromium.base.Callback;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.device.nfc.NfcDelegate;
import org.chromium.ui.base.WindowAndroid;

public class ContentNfcDelegate implements NfcDelegate {
  @CalledByNative
  private static ContentNfcDelegate create() {
    return new ContentNfcDelegate();
  }
  
  public final void stopTrackingActivityForHost(int paramInt) {
    NfcHost nfcHost = NfcHost.fromContextId(paramInt);
    if (nfcHost == null)
      return; 
    nfcHost.stopTrackingActivityChanges();
  }
  
  public final void trackActivityForHost(int paramInt, Callback paramCallback) {
    NfcHost nfcHost = NfcHost.fromContextId(paramInt);
    if (nfcHost == null)
      return; 
    if (NfcHost.$assertionsDisabled || nfcHost.mCallback == null) {
      nfcHost.mCallback = paramCallback;
      WindowEventObserverManager.from(nfcHost.mWebContents).addObserver(nfcHost);
      WindowAndroid windowAndroid = nfcHost.mWebContents.getTopLevelNativeWindow();
      Callback callback = nfcHost.mCallback;
      if (windowAndroid != null) {
        Activity activity = windowAndroid.getActivity().get();
      } else {
        windowAndroid = null;
      } 
      callback.onResult(windowAndroid);
      return;
    } 
    throw new AssertionError("Unexpected request to track activity changes");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ContentNfcDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */