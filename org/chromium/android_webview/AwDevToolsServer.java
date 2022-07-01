package org.chromium.android_webview;

public class AwDevToolsServer {
  public long mNativeDevToolsServer = nativeInitRemoteDebugging();
  
  private native void nativeDestroyRemoteDebugging(long paramLong);
  
  private native long nativeInitRemoteDebugging();
  
  public native void nativeSetRemoteDebuggingEnabled(long paramLong, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwDevToolsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */