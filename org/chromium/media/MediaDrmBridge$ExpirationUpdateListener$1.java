package org.chromium.media;

final class MediaDrmBridge$ExpirationUpdateListener$1 implements Runnable {
  public final void run() {
    StringBuilder stringBuilder = new StringBuilder("ExpirationUpdate: ");
    stringBuilder.append(sessionId.toHexString());
    stringBuilder.append(", ");
    stringBuilder.append(expirationTime);
    MediaDrmBridge.access$1700(this.this$1.this$0, sessionId, expirationTime);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaDrmBridge$ExpirationUpdateListener$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */