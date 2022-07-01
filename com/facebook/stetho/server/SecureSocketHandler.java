package com.facebook.stetho.server;

import android.content.Context;
import android.net.Credentials;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import java.io.IOException;

public abstract class SecureSocketHandler implements SocketHandler {
  private final Context mContext;
  
  public SecureSocketHandler(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private static void enforcePermission(Context paramContext, LocalSocket paramLocalSocket) throws IOException, PeerAuthorizationException {
    Credentials credentials = paramLocalSocket.getPeerCredentials();
    int i = credentials.getUid();
    int j = credentials.getPid();
    if (LogUtil.isLoggable(2))
      LogUtil.v("Got request from uid=%d, pid=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }); 
    if (paramContext.checkPermission("android.permission.DUMP", j, i) == 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Peer pid=");
    stringBuilder.append(j);
    stringBuilder.append(", uid=");
    stringBuilder.append(i);
    stringBuilder.append(" does not have ");
    stringBuilder.append("android.permission.DUMP");
    throw new PeerAuthorizationException(stringBuilder.toString());
  }
  
  public final void onAccepted(LocalSocket paramLocalSocket) throws IOException {
    try {
      enforcePermission(this.mContext, paramLocalSocket);
      onSecured(paramLocalSocket);
      return;
    } catch (PeerAuthorizationException peerAuthorizationException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unauthorized request: ");
      stringBuilder.append(peerAuthorizationException.getMessage());
      LogUtil.e(stringBuilder.toString());
      return;
    } 
  }
  
  protected abstract void onSecured(LocalSocket paramLocalSocket) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\SecureSocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */