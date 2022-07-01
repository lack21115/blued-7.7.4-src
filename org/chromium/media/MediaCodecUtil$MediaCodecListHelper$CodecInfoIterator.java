package org.chromium.media;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class MediaCodecUtil$MediaCodecListHelper$CodecInfoIterator implements Iterator {
  private int mPosition = 0;
  
  private MediaCodecUtil$MediaCodecListHelper$CodecInfoIterator() {}
  
  public final boolean hasNext() {
    return (this.mPosition < MediaCodecUtil$MediaCodecListHelper.access$100(MediaCodecUtil$MediaCodecListHelper.this));
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecUtil$MediaCodecListHelper$CodecInfoIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */