package a.a.a.a.a.a.e.e;

import a.a.a.a.a.a.e.c;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;
import java.nio.ByteBuffer;

public class b extends c {
  public Object a = new Object();
  
  public volatile PLAACEncoder b = null;
  
  public volatile a c;
  
  public ByteBuffer d;
  
  public void a() {
    e.f.c("SoftMicrophoneTransfer", "stopEncoding");
    synchronized (this.a) {
      if (this.c != null) {
        this.c.a();
        this.c.a(true);
        this.c.b();
        this.c = null;
        this.b = null;
      } 
      return;
    } 
  }
  
  public void a(c paramc) {
    e.f.c("SoftMicrophoneTransfer", "startEncoding");
    synchronized (this.a) {
      this.c = new a(paramc);
      this.b = this.c.d();
      return;
    } 
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean) {
    synchronized (this.a) {
      if (this.b != null)
        this.b.encode(paramByteBuffer, paramInt, paramLong); 
      return;
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, long paramLong, boolean paramBoolean) {
    ByteBuffer byteBuffer = this.d;
    if (byteBuffer == null || byteBuffer.capacity() < paramArrayOfbyte.length)
      this.d = ByteBuffer.allocateDirect(paramArrayOfbyte.length); 
    this.d.clear();
    this.d.put(paramArrayOfbyte);
    a(this.d, paramArrayOfbyte.length, paramLong, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\e\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */