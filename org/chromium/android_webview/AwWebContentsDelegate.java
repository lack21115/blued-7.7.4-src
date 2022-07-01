package org.chromium.android_webview;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid;

public abstract class AwWebContentsDelegate extends WebContentsDelegateAndroid {
  protected static native void nativeFilesSelectedInChooser(int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  @CalledByNative
  public abstract void activateContents();
  
  @CalledByNative
  public abstract boolean addNewContents(boolean paramBoolean1, boolean paramBoolean2);
  
  @CalledByNative
  public abstract void closeContents();
  
  @CalledByNative
  public abstract void loadingStateChanged();
  
  @CalledByNative
  public abstract void navigationStateChanged(int paramInt);
  
  @CalledByNative
  public abstract void runFileChooser(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwWebContentsDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */