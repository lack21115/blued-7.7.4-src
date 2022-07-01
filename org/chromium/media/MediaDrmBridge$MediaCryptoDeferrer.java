package org.chromium.media;

import java.util.ArrayDeque;
import java.util.Queue;

final class MediaDrmBridge$MediaCryptoDeferrer {
  final Queue mEventHandlers = new ArrayDeque();
  
  boolean mIsProvisioning = false;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  final void onProvisionDone() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$MediaCryptoDeferrer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */