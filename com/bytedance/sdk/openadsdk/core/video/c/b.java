package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class b extends a {
  private final MediaPlayer a;
  
  private final a b;
  
  private MediaDataSource c;
  
  private Surface d;
  
  private final Object e = new Object();
  
  private boolean f;
  
  public b() {
    synchronized (this.e) {
      this.a = new MediaPlayer();
      a(this.a);
      try {
        this.a.setAudioStreamType(3);
      } finally {
        null = null;
      } 
      n();
      return;
    } 
  }
  
  private void a(MediaPlayer paramMediaPlayer) {
    if (Build.VERSION.SDK_INT >= 19) {
      if (Build.VERSION.SDK_INT >= 28)
        return; 
      try {
        Class<?> clazz1 = Class.forName("android.media.MediaTimeProvider");
        Class<?> clazz2 = Class.forName("android.media.SubtitleController");
        Class<?> clazz3 = Class.forName("android.media.SubtitleController$Anchor");
        Object object = clazz2.getConstructor(new Class[] { Context.class, clazz1, Class.forName("android.media.SubtitleController$Listener") }).newInstance(new Object[] { o.a(), null, null });
        Field field = clazz2.getDeclaredField("mHandler");
        field.setAccessible(true);
      } finally {
        paramMediaPlayer = null;
      } 
    } 
  }
  
  private void m() {
    MediaDataSource mediaDataSource = this.c;
    if (mediaDataSource != null)
      try {
        mediaDataSource.close();
      } finally {
        mediaDataSource = null;
      }  
  }
  
  private void n() {
    this.a.setOnPreparedListener(this.b);
    this.a.setOnBufferingUpdateListener(this.b);
    this.a.setOnCompletionListener(this.b);
    this.a.setOnSeekCompleteListener(this.b);
    this.a.setOnVideoSizeChangedListener(this.b);
    this.a.setOnErrorListener(this.b);
    this.a.setOnInfoListener(this.b);
  }
  
  private void o() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(float paramFloat1, float paramFloat2) throws Throwable {
    this.a.setVolume(paramFloat1, paramFloat2);
  }
  
  public void a(long paramLong) throws Throwable {
    this.a.seekTo((int)paramLong);
  }
  
  public void a(Context paramContext, int paramInt) throws Throwable {
    this.a.setWakeMode(paramContext, paramInt);
  }
  
  public void a(Surface paramSurface) {
    o();
    this.d = paramSurface;
    this.a.setSurface(paramSurface);
  }
  
  public void a(SurfaceHolder paramSurfaceHolder) throws Throwable {
    synchronized (this.e) {
      if (!this.f)
        this.a.setDisplay(paramSurfaceHolder); 
      return;
    } 
  }
  
  public void a(FileDescriptor paramFileDescriptor) throws Throwable {
    this.a.setDataSource(paramFileDescriptor);
  }
  
  public void a(String paramString) throws Throwable {
    Uri uri = Uri.parse(paramString);
    String str = uri.getScheme();
    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("file")) {
      this.a.setDataSource(uri.getPath());
      return;
    } 
    this.a.setDataSource(paramString);
  }
  
  public void a(boolean paramBoolean) throws Throwable {
    this.a.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void b(boolean paramBoolean) throws Throwable {
    this.a.setLooping(paramBoolean);
  }
  
  public MediaPlayer e() {
    return this.a;
  }
  
  public void f() throws Throwable {
    this.a.start();
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
    o();
  }
  
  public void g() throws Throwable {
    this.a.stop();
  }
  
  public void h() throws Throwable {
    this.a.pause();
  }
  
  public long i() {
    try {
      return i;
    } finally {
      Exception exception = null;
      t.c("AndroidMediaPlayer", "getCurrentPosition error: ", exception);
    } 
  }
  
  public long j() {
    try {
      return i;
    } finally {
      Exception exception = null;
      t.c("AndroidMediaPlayer", "getDuration error: ", exception);
    } 
  }
  
  public void k() throws Throwable {
    this.f = true;
    this.a.release();
    o();
    m();
    a();
    n();
  }
  
  public void l() throws Throwable {
    try {
      this.a.reset();
    } finally {
      Exception exception = null;
    } 
    a();
    n();
  }
  
  class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    private final WeakReference<b> b;
    
    public a(b this$0, b param1b1) {
      this.b = new WeakReference<b>(param1b1);
    }
    
    public void onBufferingUpdate(MediaPlayer param1MediaPlayer, int param1Int) {
      try {
        if ((b)this.b.get() != null)
          return; 
      } finally {
        param1MediaPlayer = null;
      } 
    }
    
    public void onCompletion(MediaPlayer param1MediaPlayer) {
      try {
        if ((b)this.b.get() != null)
          return; 
      } finally {
        param1MediaPlayer = null;
      } 
    }
    
    public boolean onError(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
      boolean bool2 = false;
      boolean bool1 = bool2;
      try {
        return bool1;
      } finally {
        param1MediaPlayer = null;
        t.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onError error: ", (Throwable)param1MediaPlayer);
      } 
    }
    
    public boolean onInfo(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
      boolean bool2 = false;
      boolean bool1 = bool2;
      try {
        return bool1;
      } finally {
        param1MediaPlayer = null;
        t.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onInfo error: ", (Throwable)param1MediaPlayer);
      } 
    }
    
    public void onPrepared(MediaPlayer param1MediaPlayer) {
      try {
        if ((b)this.b.get() != null)
          return; 
      } finally {
        param1MediaPlayer = null;
      } 
    }
    
    public void onSeekComplete(MediaPlayer param1MediaPlayer) {
      try {
        if ((b)this.b.get() != null)
          return; 
      } finally {
        param1MediaPlayer = null;
      } 
    }
    
    public void onVideoSizeChanged(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
      try {
        if ((b)this.b.get() != null)
          return; 
      } finally {
        param1MediaPlayer = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */