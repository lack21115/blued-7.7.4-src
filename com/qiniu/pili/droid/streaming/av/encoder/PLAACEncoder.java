package com.qiniu.pili.droid.streaming.av.encoder;

import a.a.a.a.a.a.f.a;
import a.a.a.a.a.a.g.a;
import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import java.nio.ByteBuffer;

public class PLAACEncoder {
  public static final boolean c = SharedLibraryNameHelper.getInstance().a();
  
  public a a = new a(2);
  
  public a b;
  
  public PLAACEncoder(Parameters paramParameters) {
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isLoggingEnabled:");
    stringBuilder.append(paramParameters.isLoggingEnabled);
    e.c("PLAACEncoder", stringBuilder.toString());
    initialize(paramParameters);
  }
  
  private void audioSpecificConfigCallback(PLAVFrame paramPLAVFrame) {
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("audioSpecificConfigCallback size:");
    stringBuilder.append(paramPLAVFrame.mSize);
    stringBuilder.append(",encodedBuffer:");
    stringBuilder.append(paramPLAVFrame.mBuffer);
    e.c("PLAACEncoder", stringBuilder.toString());
    paramPLAVFrame.mBuffer.position(0);
    paramPLAVFrame.mBuffer.limit(paramPLAVFrame.mSize);
    PLBufferInfo pLBufferInfo = new PLBufferInfo();
    int i = pLBufferInfo.flags | 0x2;
    pLBufferInfo.flags = i;
    int j = paramPLAVFrame.mSize;
    long l = paramPLAVFrame.mPresentationTimeUs;
    pLBufferInfo.set(0, j, l, l, i);
    pLBufferInfo.isNeedAddHeader = false;
    a a1 = this.b;
    if (a1 != null)
      a1.a(paramPLAVFrame, pLBufferInfo); 
  }
  
  private void encodeCallback(PLAVFrame paramPLAVFrame, int paramInt) {
    e e2 = e.i;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("encodeCallback + size:");
    stringBuilder2.append(paramPLAVFrame.mSize);
    stringBuilder2.append(",frameType:");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(",ts:");
    stringBuilder2.append(paramPLAVFrame.mPresentationTimeUs);
    e2.a("PLAACEncoder", stringBuilder2.toString());
    long l1 = System.currentTimeMillis();
    PLBufferInfo pLBufferInfo = new PLBufferInfo();
    paramInt = paramPLAVFrame.mSize;
    long l2 = paramPLAVFrame.mPresentationTimeUs;
    pLBufferInfo.set(0, paramInt, l2, l2, pLBufferInfo.flags);
    pLBufferInfo.isNeedAddHeader = false;
    paramPLAVFrame.mBuffer.position(0);
    paramPLAVFrame.mBuffer.limit(paramPLAVFrame.mSize);
    e e3 = e.i;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("encodeCallback buffer:");
    stringBuilder3.append(paramPLAVFrame.mBuffer);
    stringBuilder3.append(",mCallback:");
    stringBuilder3.append(this.b);
    stringBuilder3.append(",frame:");
    stringBuilder3.append(paramPLAVFrame);
    e3.a("PLAACEncoder", stringBuilder3.toString());
    a a1 = this.b;
    if (a1 != null)
      a1.a(paramPLAVFrame, pLBufferInfo); 
    e e1 = e.i;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("encodeCallback - cost:");
    stringBuilder1.append(System.currentTimeMillis() - l1);
    e1.a("PLAACEncoder", stringBuilder1.toString());
  }
  
  private PLAVFrame getOutputFrame(int paramInt) {
    PLAVFrame pLAVFrame = this.a.a(paramInt);
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getOutputFrame reqSize:");
    stringBuilder.append(paramInt);
    stringBuilder.append(",mBuffer:");
    stringBuilder.append(pLAVFrame.mBuffer);
    e.a("PLAACEncoder", stringBuilder.toString());
    pLAVFrame.mBuffer.clear();
    return pLAVFrame;
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public void a(PLAVFrame paramPLAVFrame) {
    paramPLAVFrame.mBuffer.limit(0);
    paramPLAVFrame.mBuffer.clear();
    this.a.a(paramPLAVFrame);
  }
  
  public void b(PLAVFrame paramPLAVFrame) {
    a(paramPLAVFrame);
  }
  
  public native int encode(ByteBuffer paramByteBuffer, int paramInt, long paramLong);
  
  public native void initialize(Parameters paramParameters);
  
  public native void release();
  
  public static class Parameters {
    public int bitrate;
    
    public int bitsPerSample;
    
    public int channels;
    
    public boolean isLoggingEnabled = e.a();
    
    public int sampleRate;
    
    public Parameters(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.channels = param1Int2;
      this.sampleRate = param1Int3;
      this.bitsPerSample = param1Int4;
      this.bitrate = param1Int1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\av\encoder\PLAACEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */