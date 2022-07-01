package org.chromium.media;

import java.util.ArrayList;
import java.util.Iterator;

final class MediaDrmBridge$SessionEventDeferrer {
  final ArrayList mEventHandlers;
  
  final MediaDrmSessionManager$SessionId mSessionId;
  
  MediaDrmBridge$SessionEventDeferrer(MediaDrmSessionManager$SessionId paramMediaDrmSessionManager$SessionId) {
    this.mSessionId = paramMediaDrmSessionManager$SessionId;
    this.mEventHandlers = new ArrayList();
  }
  
  final void fire() {
    Iterator<Runnable> iterator = this.mEventHandlers.iterator();
    while (iterator.hasNext())
      ((Runnable)iterator.next()).run(); 
    this.mEventHandlers.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$SessionEventDeferrer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */