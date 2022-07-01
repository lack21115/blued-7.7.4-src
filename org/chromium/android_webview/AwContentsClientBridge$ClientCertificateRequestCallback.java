package org.chromium.android_webview;

import java.security.PrivateKey;

public final class AwContentsClientBridge$ClientCertificateRequestCallback {
  final String mHost;
  
  private final int mId;
  
  private boolean mIsCalled;
  
  final int mPort;
  
  public AwContentsClientBridge$ClientCertificateRequestCallback(int paramInt1, String paramString, int paramInt2) {
    this.mId = paramInt1;
    this.mHost = paramString;
    this.mPort = paramInt2;
  }
  
  final void checkIfCalled() {
    if (!this.mIsCalled) {
      this.mIsCalled = true;
      return;
    } 
    throw new IllegalStateException("The callback was already called.");
  }
  
  final void provideResponse(PrivateKey paramPrivateKey, byte[][] paramArrayOfbyte) {
    if (AwContentsClientBridge.access$100(AwContentsClientBridge.this) == 0L)
      return; 
    AwContentsClientBridge.access$200(AwContentsClientBridge.this, AwContentsClientBridge.access$100(AwContentsClientBridge.this), this.mId, paramArrayOfbyte, paramPrivateKey);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsClientBridge$ClientCertificateRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */