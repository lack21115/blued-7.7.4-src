package com.android.webview.chromium;

import android.content.Intent;
import android.webkit.WebChromeClient;
import org.chromium.android_webview.AwContentsClient;

final class WebViewContentsClientAdapter$6 extends WebChromeClient.FileChooserParams {
  public final Intent createIntent() {
    AwContentsClient.FileChooserParamsImpl fileChooserParamsImpl = value;
    String str2 = "*/*";
    String str1 = str2;
    if (fileChooserParamsImpl.mAcceptTypes != null) {
      str1 = str2;
      if (!fileChooserParamsImpl.mAcceptTypes.trim().isEmpty())
        str1 = fileChooserParamsImpl.mAcceptTypes.split(",")[0]; 
    } 
    Intent intent = new Intent("android.intent.action.GET_CONTENT");
    intent.addCategory("android.intent.category.OPENABLE");
    intent.setType(str1);
    return intent;
  }
  
  public final String[] getAcceptTypes() {
    AwContentsClient.FileChooserParamsImpl fileChooserParamsImpl = value;
    return (fileChooserParamsImpl.mAcceptTypes == null) ? new String[0] : fileChooserParamsImpl.mAcceptTypes.split(",");
  }
  
  public final String getFilenameHint() {
    return value.mDefaultFilename;
  }
  
  public final int getMode() {
    return value.mMode;
  }
  
  public final CharSequence getTitle() {
    return value.mTitle;
  }
  
  public final boolean isCaptureEnabled() {
    return value.mCapture;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */