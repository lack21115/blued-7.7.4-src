package org.chromium.content_public.common;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;

public final class MediaMetadata {
  private String mAlbum;
  
  private String mArtist;
  
  private List mArtwork = new ArrayList();
  
  private String mTitle;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MediaMetadata(String paramString1, String paramString2, String paramString3) {
    this.mTitle = paramString1;
    this.mArtist = paramString2;
    this.mAlbum = paramString3;
  }
  
  @CalledByNative
  private static MediaMetadata create(String paramString1, String paramString2, String paramString3) {
    String str = paramString1;
    if (paramString1 == null)
      str = ""; 
    paramString1 = paramString2;
    if (paramString2 == null)
      paramString1 = ""; 
    paramString2 = paramString3;
    if (paramString3 == null)
      paramString2 = ""; 
    return new MediaMetadata(str, paramString1, paramString2);
  }
  
  @CalledByNative
  private void createAndAddMediaImage(String paramString1, String paramString2, int[] paramArrayOfint) {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof MediaMetadata))
      return false; 
    paramObject = paramObject;
    return (TextUtils.equals(this.mTitle, ((MediaMetadata)paramObject).mTitle) && TextUtils.equals(this.mArtist, ((MediaMetadata)paramObject).mArtist) && TextUtils.equals(this.mAlbum, ((MediaMetadata)paramObject).mAlbum) && this.mArtwork.equals(((MediaMetadata)paramObject).mArtwork));
  }
  
  public final int hashCode() {
    return ((this.mTitle.hashCode() * 31 + this.mArtist.hashCode()) * 31 + this.mAlbum.hashCode()) * 31 + this.mArtwork.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\common\MediaMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */