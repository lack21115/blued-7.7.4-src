package a.a.a.a.a.a.j;

import a.a.a.a.a.a.c;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.f.c;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

public abstract class f {
  public volatile c t = c.a;
  
  public volatile a.a.a.a.a.f.a u = a.a.a.a.a.f.a.a;
  
  public c v;
  
  public a w;
  
  public a x;
  
  public long y = 0L;
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt, long paramLong, boolean paramBoolean) {}
  
  public void a(c paramc) {
    this.v = paramc;
  }
  
  public abstract void a(a parama);
  
  public void a(StreamingPreviewCallback paramStreamingPreviewCallback) {}
  
  public void a(WatermarkSetting paramWatermarkSetting) {}
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {}
  
  public void a(byte[] paramArrayOfbyte, long paramLong) {}
  
  public boolean a(boolean paramBoolean) {
    return false;
  }
  
  public Surface b(a parama) {
    return null;
  }
  
  public abstract void b(boolean paramBoolean);
  
  public void c(boolean paramBoolean) {}
  
  public void e() {
    if (this.u == a.a.a.a.a.f.a.b) {
      a(this.x);
      this.u = a.a.a.a.a.f.a.a;
      return;
    } 
    if (this.u == a.a.a.a.a.f.a.c) {
      b(false);
      this.u = a.a.a.a.a.f.a.a;
      return;
    } 
    if (this.u == a.a.a.a.a.f.a.d) {
      b(false);
      a(this.x);
    } 
  }
  
  public boolean f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: astore_2
    //   7: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne -> 21
    //   16: iconst_1
    //   17: istore_1
    //   18: goto -> 23
    //   21: iconst_0
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  public static final class a {
    public final c a;
    
    public final int b;
    
    public final int c;
    
    public final int d;
    
    public final int e;
    
    public final int f;
    
    public final boolean g;
    
    public WatermarkSetting h;
    
    public final Object i;
    
    public final boolean j;
    
    public int k;
    
    public int l;
    
    public boolean m;
    
    public int n;
    
    public PreviewAppearance o;
    
    public a(c param1c, int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean1, int param1Int4, int param1Int5, WatermarkSetting param1WatermarkSetting, boolean param1Boolean2) {
      this.g = param1Boolean2;
      this.l = param1Int3;
      this.f = param1Int5;
      this.a = param1c;
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Int1 * param1Int2 * 3 / 2;
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("srcWidth:");
      stringBuilder.append(param1Int1);
      stringBuilder.append(",srcHeight:");
      stringBuilder.append(param1Int2);
      stringBuilder.append(",srcSize:");
      stringBuilder.append(this.d);
      e.c("VideoTransfer", stringBuilder.toString());
      this.e = param1Int4;
      this.j = false;
      this.m = b(param1Boolean1);
      this.h = param1WatermarkSetting;
      this.i = null;
    }
    
    public a(c param1c, int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean1, int param1Int4, int param1Int5, Object param1Object, WatermarkSetting param1WatermarkSetting, boolean param1Boolean2) {
      this.a = param1c;
      this.i = param1Object;
      this.l = param1Int3;
      this.g = param1Boolean2;
      this.f = param1Int5;
      this.b = param1Int1;
      this.c = param1Int2;
      this.j = true;
      a.a.a.a.a.e.f f = param1c.d().a();
      if (param1Int5 == PLFourCC.FOURCC_ABGR) {
        this.d = f.a() * f.b() * 4;
      } else {
        this.d = (int)((f.a() * f.b()) * 1.5D);
      } 
      this.e = param1Int4;
      this.m = b(param1Boolean1);
      this.h = param1WatermarkSetting;
    }
    
    public void a(PreviewAppearance param1PreviewAppearance) {
      this.o = param1PreviewAppearance;
    }
    
    public void a(WatermarkSetting param1WatermarkSetting) {
      this.h = param1WatermarkSetting;
    }
    
    public void a(boolean param1Boolean) {
      this.m = param1Boolean;
    }
    
    public boolean b(boolean param1Boolean) {
      if (!this.j)
        if (!param1Boolean) {
          param1Boolean = true;
        } else {
          param1Boolean = false;
        }  
      return (h.b(this.l) && param1Boolean);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */