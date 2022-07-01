package org.chromium.net;

final class ProxyChangeListener$ProxyConfig {
  public final String[] mExclusionList;
  
  public final String mHost;
  
  public final String mPacUrl;
  
  public final int mPort;
  
  public ProxyChangeListener$ProxyConfig(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString) {
    this.mHost = paramString1;
    this.mPort = paramInt;
    this.mPacUrl = paramString2;
    this.mExclusionList = paramArrayOfString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\ProxyChangeListener$ProxyConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */