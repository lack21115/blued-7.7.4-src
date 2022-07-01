package org.chromium.content_public.common;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class MediaMetadata$MediaImage {
  private List mSizes = new ArrayList();
  
  private String mSrc;
  
  private String mType;
  
  public MediaMetadata$MediaImage(String paramString1, String paramString2, List paramList) {
    this.mSrc = paramString1;
    this.mType = paramString2;
    this.mSizes = paramList;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof MediaMetadata$MediaImage))
      return false; 
    paramObject = paramObject;
    return (TextUtils.equals(this.mSrc, ((MediaMetadata$MediaImage)paramObject).mSrc) && TextUtils.equals(this.mType, ((MediaMetadata$MediaImage)paramObject).mType) && this.mSizes.equals(((MediaMetadata$MediaImage)paramObject).mSizes));
  }
  
  public final int hashCode() {
    return (this.mSrc.hashCode() * 31 + this.mType.hashCode()) * 31 + this.mSizes.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\common\MediaMetadata$MediaImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */