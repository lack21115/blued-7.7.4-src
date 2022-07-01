package org.chromium.media;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import java.util.Iterator;

final class MediaCodecUtil$MediaCodecListHelper implements Iterable {
  private MediaCodecInfo[] mCodecList;
  
  @TargetApi(21)
  public MediaCodecUtil$MediaCodecListHelper() {
    if (supportsNewMediaCodecList())
      try {
        this.mCodecList = (new MediaCodecList(1)).getCodecInfos();
        return;
      } catch (RuntimeException runtimeException) {} 
  }
  
  private int getCodecCount() {
    if (hasNewMediaCodecList())
      return this.mCodecList.length; 
    try {
      return MediaCodecList.getCodecCount();
    } catch (RuntimeException runtimeException) {
      return 0;
    } 
  }
  
  private boolean hasNewMediaCodecList() {
    return (supportsNewMediaCodecList() && this.mCodecList != null);
  }
  
  private static boolean supportsNewMediaCodecList() {
    return (Build.VERSION.SDK_INT >= 21);
  }
  
  public final Iterator iterator() {
    return new MediaCodecUtil$MediaCodecListHelper$CodecInfoIterator(this, (byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecUtil$MediaCodecListHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */