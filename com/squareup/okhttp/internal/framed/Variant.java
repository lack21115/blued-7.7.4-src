package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import okio.BufferedSink;
import okio.BufferedSource;

public interface Variant {
  Protocol getProtocol();
  
  FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean);
  
  FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */