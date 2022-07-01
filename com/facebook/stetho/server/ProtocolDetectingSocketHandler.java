package com.facebook.stetho.server;

import android.content.Context;
import android.net.LocalSocket;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ProtocolDetectingSocketHandler extends SecureSocketHandler {
  private static final int SENSING_BUFFER_SIZE = 256;
  
  private final ArrayList<HandlerInfo> mHandlers = new ArrayList<HandlerInfo>(2);
  
  public ProtocolDetectingSocketHandler(Context paramContext) {
    super(paramContext);
  }
  
  public void addHandler(MagicMatcher paramMagicMatcher, SocketLikeHandler paramSocketLikeHandler) {
    this.mHandlers.add(new HandlerInfo(paramMagicMatcher, paramSocketLikeHandler));
  }
  
  protected void onSecured(LocalSocket paramLocalSocket) throws IOException {
    LeakyBufferedInputStream leakyBufferedInputStream = new LeakyBufferedInputStream(paramLocalSocket.getInputStream(), 256);
    if (!this.mHandlers.isEmpty()) {
      int i = 0;
      int j = this.mHandlers.size();
      while (i < j) {
        HandlerInfo handlerInfo = this.mHandlers.get(i);
        leakyBufferedInputStream.mark(256);
        boolean bool = handlerInfo.magicMatcher.matches(leakyBufferedInputStream);
        leakyBufferedInputStream.reset();
        if (bool) {
          SocketLike socketLike = new SocketLike(paramLocalSocket, leakyBufferedInputStream);
          handlerInfo.handler.onAccepted(socketLike);
          return;
        } 
        i++;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No matching handler, firstByte=");
      stringBuilder.append(leakyBufferedInputStream.read());
      throw new IOException(stringBuilder.toString());
    } 
    throw new IllegalStateException("No handlers added");
  }
  
  public static class AlwaysMatchMatcher implements MagicMatcher {
    public boolean matches(InputStream param1InputStream) throws IOException {
      return true;
    }
  }
  
  public static class ExactMagicMatcher implements MagicMatcher {
    private final byte[] mMagic;
    
    public ExactMagicMatcher(byte[] param1ArrayOfbyte) {
      this.mMagic = param1ArrayOfbyte;
    }
    
    public boolean matches(InputStream param1InputStream) throws IOException {
      byte[] arrayOfByte = new byte[this.mMagic.length];
      return (param1InputStream.read(arrayOfByte) == arrayOfByte.length && Arrays.equals(arrayOfByte, this.mMagic));
    }
  }
  
  static class HandlerInfo {
    public final SocketLikeHandler handler;
    
    public final ProtocolDetectingSocketHandler.MagicMatcher magicMatcher;
    
    private HandlerInfo(ProtocolDetectingSocketHandler.MagicMatcher param1MagicMatcher, SocketLikeHandler param1SocketLikeHandler) {
      this.magicMatcher = param1MagicMatcher;
      this.handler = param1SocketLikeHandler;
    }
  }
  
  public static interface MagicMatcher {
    boolean matches(InputStream param1InputStream) throws IOException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\ProtocolDetectingSocketHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */