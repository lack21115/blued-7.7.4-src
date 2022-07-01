package com.qiniu.pili.droid.shortvideo.d;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.nio.ByteBuffer;

public final class a extends b {
  private Handler f;
  
  private MediaCodec.Callback g = new MediaCodec.Callback(this) {
      public void onError(MediaCodec param1MediaCodec, MediaCodec.CodecException param1CodecException) {
        e e = e.u;
        String str = this.a.j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decoder callback onError ");
        stringBuilder.append(param1CodecException.getMessage());
        e.c(str, stringBuilder.toString());
        if (this.a.c != null)
          this.a.c.a(17); 
      }
      
      public void onInputBufferAvailable(MediaCodec param1MediaCodec, int param1Int) {
        try {
          ByteBuffer byteBuffer = this.a.b.getInputBuffer(param1Int);
          int i = this.a.a.readSampleData(byteBuffer, 0);
          if (i > 0) {
            this.a.b.queueInputBuffer(param1Int, 0, i, this.a.a.getSampleTime(), 0);
            this.a.a.advance();
            return;
          } 
          e e = e.u;
          String str = this.a.j();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("read size <= 0 need loop: ");
          stringBuilder.append(this.a.e);
          e.c(str, stringBuilder.toString());
          if (this.a.e) {
            this.a.b();
            this.a.b.flush();
            this.a.b.start();
            return;
          } 
          this.a.b.queueInputBuffer(param1Int, 0, 0, 0L, 4);
          return;
        } catch (IllegalStateException illegalStateException) {
          e.u.e(this.a.j(), illegalStateException.toString());
          return;
        } 
      }
      
      public void onOutputBufferAvailable(MediaCodec param1MediaCodec, int param1Int, MediaCodec.BufferInfo param1BufferInfo) {
        if ((param1BufferInfo.flags & 0x2) != 0) {
          e.i.c(this.a.j(), "codec config frame ignore.");
          return;
        } 
        try {
          ByteBuffer byteBuffer = param1MediaCodec.getOutputBuffer(param1Int);
          this.a.a(param1Int, param1BufferInfo, byteBuffer);
          return;
        } catch (IllegalStateException illegalStateException) {
          e.u.e(this.a.j(), illegalStateException.toString());
          return;
        } 
      }
      
      public void onOutputFormatChanged(MediaCodec param1MediaCodec, MediaFormat param1MediaFormat) {
        e e = e.u;
        String str = this.a.j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decoder output format changed: ");
        stringBuilder.append(param1MediaFormat);
        e.c(str, stringBuilder.toString());
        if (this.a.d != null)
          this.a.d.a(param1MediaFormat); 
      }
    };
  
  public a(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat) {
    super(paramMediaExtractor, paramMediaFormat);
  }
  
  public boolean c() {
    Handler handler = this.f;
    if (handler != null)
      handler.getLooper().quit(); 
    return super.c();
  }
  
  public String j() {
    return "AsyncRawFrameExtractor";
  }
  
  public void run() {
    b();
    Looper.prepare();
    this.f = new Handler(Looper.myLooper());
    if (a(this.g, this.f))
      Looper.loop(); 
    e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */