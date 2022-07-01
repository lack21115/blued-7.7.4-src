package org.chromium.android_webview;

public final class AwConsoleMessage {
  public int mLevel;
  
  public int mLineNumber;
  
  public String mMessage;
  
  public String mSourceId;
  
  public AwConsoleMessage(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    this.mMessage = paramString1;
    this.mSourceId = paramString2;
    this.mLineNumber = paramInt1;
    this.mLevel = paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwConsoleMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */