package com.android.webview.chromium;

import android.net.Uri;
import android.webkit.PermissionRequest;
import org.chromium.android_webview.permission.AwPermissionRequest;

public final class WebViewContentsClientAdapter$PermissionRequestAdapter extends PermissionRequest {
  private AwPermissionRequest mAwPermissionRequest;
  
  private final String[] mResources;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public WebViewContentsClientAdapter$PermissionRequestAdapter(AwPermissionRequest paramAwPermissionRequest) {
    assert false;
    throw new AssertionError();
  }
  
  public final void deny() {
    this.mAwPermissionRequest.deny();
  }
  
  public final Uri getOrigin() {
    return this.mAwPermissionRequest.mOrigin;
  }
  
  public final String[] getResources() {
    return (String[])this.mResources.clone();
  }
  
  public final void grant(String[] paramArrayOfString) {
    long l2 = this.mAwPermissionRequest.mResources;
    int j = paramArrayOfString.length;
    int i = 0;
    long l1;
    for (l1 = 0L; i < j; l1 = l) {
      long l;
      String str = paramArrayOfString[i];
      if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
        l = l1 | 0x2L;
      } else if (str.equals("android.webkit.resource.AUDIO_CAPTURE")) {
        l = l1 | 0x4L;
      } else if (str.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
        l = l1 | 0x8L;
      } else {
        l = l1;
        if (str.equals("android.webkit.resource.MIDI_SYSEX"))
          l = l1 | 0x10L; 
      } 
      i++;
    } 
    if ((l1 & l2) == l2) {
      AwPermissionRequest awPermissionRequest = this.mAwPermissionRequest;
      awPermissionRequest.validate();
      if (awPermissionRequest.mNativeAwPermissionRequest != 0L) {
        awPermissionRequest.nativeOnAccept(awPermissionRequest.mNativeAwPermissionRequest, true);
        awPermissionRequest.destroyNative();
      } 
      awPermissionRequest.mProcessed = true;
      return;
    } 
    this.mAwPermissionRequest.deny();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$PermissionRequestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */