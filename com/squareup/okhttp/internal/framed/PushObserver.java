package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public interface PushObserver {
  public static final PushObserver CANCEL = new PushObserver() {
      public boolean onData(int param1Int1, BufferedSource param1BufferedSource, int param1Int2, boolean param1Boolean) throws IOException {
        param1BufferedSource.skip(param1Int2);
        return true;
      }
      
      public boolean onHeaders(int param1Int, List<Header> param1List, boolean param1Boolean) {
        return true;
      }
      
      public boolean onRequest(int param1Int, List<Header> param1List) {
        return true;
      }
      
      public void onReset(int param1Int, ErrorCode param1ErrorCode) {}
    };
  
  boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean) throws IOException;
  
  boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean);
  
  boolean onRequest(int paramInt, List<Header> paramList);
  
  void onReset(int paramInt, ErrorCode paramErrorCode);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\PushObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */