package android.support.v4.provider;

import android.net.Uri;
import android.support.v4.util.Preconditions;

public final class FontsContractCompat$FontInfo {
  public final boolean mItalic;
  
  final int mResultCode;
  
  public final int mTtcIndex;
  
  public final Uri mUri;
  
  public final int mWeight;
  
  public FontsContractCompat$FontInfo(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
    this.mUri = (Uri)Preconditions.checkNotNull(paramUri);
    this.mTtcIndex = paramInt1;
    this.mWeight = paramInt2;
    this.mItalic = paramBoolean;
    this.mResultCode = paramInt3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\provider\FontsContractCompat$FontInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */