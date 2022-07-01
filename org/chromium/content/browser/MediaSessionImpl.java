package org.chromium.content.browser;

import java.util.HashSet;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.MediaSession;
import org.chromium.content_public.browser.MediaSessionObserver;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.common.MediaMetadata;

public class MediaSessionImpl extends MediaSession {
  private ObserverList mObservers = new ObserverList();
  
  private ObserverList.RewindableIterator mObserversIterator = this.mObservers.rewindableIterator();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static MediaSessionImpl create(long paramLong) {
    return new MediaSessionImpl();
  }
  
  @CalledByNative
  private boolean hasObservers() {
    return !this.mObservers.isEmpty();
  }
  
  @CalledByNative
  private void mediaSessionActionsChanged(int[] paramArrayOfint) {
    HashSet<Integer> hashSet = new HashSet();
    int j = paramArrayOfint.length;
    for (int i = 0; i < j; i++)
      hashSet.add(Integer.valueOf(paramArrayOfint[i])); 
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      this.mObserversIterator.next(); 
  }
  
  @CalledByNative
  private void mediaSessionDestroyed() {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      this.mObserversIterator.next(); 
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext()) {
      MediaSessionObserver mediaSessionObserver = (MediaSessionObserver)this.mObserversIterator.next();
      if (mediaSessionObserver.mMediaSession != null) {
        mediaSessionObserver.mMediaSession.mObservers.removeObserver(mediaSessionObserver);
        mediaSessionObserver.mMediaSession = null;
      } 
    } 
    this.mObservers.clear();
  }
  
  @CalledByNative
  private void mediaSessionMetadataChanged(MediaMetadata paramMediaMetadata) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      this.mObserversIterator.next(); 
  }
  
  @CalledByNative
  private void mediaSessionStateChanged(boolean paramBoolean1, boolean paramBoolean2) {
    this.mObserversIterator.rewind();
    while (this.mObserversIterator.hasNext())
      this.mObserversIterator.next(); 
  }
  
  private native void nativeDidReceiveAction(long paramLong, int paramInt);
  
  private static native MediaSessionImpl nativeGetMediaSessionFromWebContents(WebContents paramWebContents);
  
  private native void nativeRequestSystemAudioFocus(long paramLong);
  
  private native void nativeResume(long paramLong);
  
  private native void nativeSeekBackward(long paramLong1, long paramLong2);
  
  private native void nativeSeekForward(long paramLong1, long paramLong2);
  
  private native void nativeStop(long paramLong);
  
  private native void nativeSuspend(long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\MediaSessionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */