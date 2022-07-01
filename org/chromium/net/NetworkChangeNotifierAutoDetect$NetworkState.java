package org.chromium.net;

public final class NetworkChangeNotifierAutoDetect$NetworkState {
  private final boolean mConnected;
  
  final String mNetworkIdentifier;
  
  private final int mSubtype;
  
  private final int mType;
  
  public NetworkChangeNotifierAutoDetect$NetworkState(boolean paramBoolean, int paramInt1, int paramInt2, String paramString) {
    this.mConnected = paramBoolean;
    this.mType = paramInt1;
    this.mSubtype = paramInt2;
    String str = paramString;
    if (paramString == null)
      str = ""; 
    this.mNetworkIdentifier = str;
  }
  
  public final int getConnectionSubtype() {
    if (!this.mConnected)
      return 1; 
    switch (this.mType) {
      default:
        return 0;
      case 1:
      case 6:
      case 7:
      case 9:
        return 0;
      case 0:
        break;
    } 
    switch (this.mSubtype) {
      default:
        return 0;
      case 15:
        return 17;
      case 14:
        return 16;
      case 13:
        return 18;
      case 12:
        return 13;
      case 11:
        return 4;
      case 10:
        return 12;
      case 9:
        return 15;
      case 8:
        return 14;
      case 7:
        return 6;
      case 6:
        return 11;
      case 5:
        return 10;
      case 4:
        return 5;
      case 3:
        return 9;
      case 2:
        return 8;
      case 1:
        break;
    } 
    return 7;
  }
  
  public final int getConnectionType() {
    return !this.mConnected ? 6 : NetworkChangeNotifierAutoDetect.access$000(this.mType, this.mSubtype);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$NetworkState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */