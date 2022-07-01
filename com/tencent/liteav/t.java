package com.tencent.liteav;

import android.content.Context;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

public abstract class t {
  protected j b = null;
  
  protected Context c = null;
  
  protected TXCloudVideoView d = null;
  
  protected WeakReference<b> e;
  
  public t(Context paramContext) {
    if (paramContext != null)
      this.c = paramContext.getApplicationContext(); 
  }
  
  public int a(String paramString) {
    return -1;
  }
  
  public abstract int a(String paramString, int paramInt);
  
  public abstract int a(boolean paramBoolean);
  
  public void a() {
    TXCLog.w("TXIPlayer", "pause not support");
  }
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Surface paramSurface) {}
  
  public void a(b paramb) {
    this.e = new WeakReference<b>(paramb);
  }
  
  public abstract void a(p paramp);
  
  public void a(j paramj) {
    this.b = paramj;
    if (this.b == null)
      this.b = new j(); 
  }
  
  public void a(u paramu, b paramb, Object paramObject) {}
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener) {}
  
  public void a(TXCloudVideoView paramTXCloudVideoView) {
    this.d = paramTXCloudVideoView;
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener) {}
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public void b() {
    TXCLog.w("TXIPlayer", "resume not support");
  }
  
  public void b(float paramFloat) {
    TXCLog.w("TXIPlayer", "rate not implement");
  }
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract int d(int paramInt);
  
  public TextureView d() {
    return null;
  }
  
  public boolean d(boolean paramBoolean) {
    return false;
  }
  
  public abstract int e();
  
  public void e(int paramInt) {
    TXCLog.w("TXIPlayer", "seek not support");
  }
  
  public void e(boolean paramBoolean) {
    TXCLog.w("TXIPlayer", "autoPlay not implement");
  }
  
  public boolean f() {
    return false;
  }
  
  public void g() {}
  
  public abstract int i();
  
  public j q() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */