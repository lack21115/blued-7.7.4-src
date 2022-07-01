package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

public abstract class c {
  protected String a;
  
  protected int b = -1;
  
  protected int c = -1;
  
  protected long d = -1L;
  
  protected long e = -1L;
  
  public abstract void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString, MediaFormat paramMediaFormat1, MediaFormat paramMediaFormat2, int paramInt);
  
  public int b() {
    return this.b;
  }
  
  public int c() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\muxer\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */