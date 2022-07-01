package com.squareup.okhttp.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;

public interface FrameReader extends Closeable {
  boolean nextFrame(Handler paramHandler) throws IOException;
  
  void readConnectionPreface() throws IOException;
  
  public static interface Handler {
    void ackSettings();
    
    void alternateService(int param1Int1, String param1String1, ByteString param1ByteString, String param1String2, int param1Int2, long param1Long);
    
    void data(boolean param1Boolean, int param1Int1, BufferedSource param1BufferedSource, int param1Int2) throws IOException;
    
    void goAway(int param1Int, ErrorCode param1ErrorCode, ByteString param1ByteString);
    
    void headers(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List, HeadersMode param1HeadersMode);
    
    void ping(boolean param1Boolean, int param1Int1, int param1Int2);
    
    void priority(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean);
    
    void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) throws IOException;
    
    void rstStream(int param1Int, ErrorCode param1ErrorCode);
    
    void settings(boolean param1Boolean, Settings param1Settings);
    
    void windowUpdate(int param1Int, long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\FrameReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */