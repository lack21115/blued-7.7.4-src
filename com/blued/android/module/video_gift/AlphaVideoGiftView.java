package com.blued.android.module.video_gift;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import java.io.File;
import java.io.FileDescriptor;

public class AlphaVideoGiftView extends AlphaMovieView implements LifecycleObserver {
  private static final String b = AlphaVideoGiftView.class.getSimpleName();
  
  private static Handler c = new Handler(Looper.getMainLooper());
  
  private Lifecycle d = null;
  
  private OnVideoStateChangedListener e = null;
  
  private Status f = Status.a;
  
  public AlphaVideoGiftView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    k();
  }
  
  private void b(Context paramContext, IRequestHost paramIRequestHost, String paramString) {
    AppInfo.n().post(new Runnable(this, paramIRequestHost, paramContext, paramString) {
          public void run() {
            IRequestHost iRequestHost = this.a;
            if (iRequestHost == null || iRequestHost.isActive())
              this.d.a(this.b, this.c); 
          }
        });
  }
  
  private void k() {
    setLooping(false);
    setOnVideoEndedListener(new AlphaMovieView.OnVideoEndedListener(this) {
          public void a() {
            this.a.setVisibility(8);
            this.a.a(0);
            AlphaVideoGiftView.i().postDelayed(new Runnable(this) {
                  public void run() {
                    this.a.a.e();
                    AlphaVideoGiftView.a(this.a.a, AlphaVideoGiftView.Status.a);
                    if (AlphaVideoGiftView.a(this.a.a) != null)
                      AlphaVideoGiftView.a(this.a.a).b(); 
                  }
                }100L);
          }
        });
    setOnVideoStartedListener(new AlphaMovieView.OnVideoStartedListener(this) {
          public void a() {
            AlphaVideoGiftView.a(this.a, AlphaVideoGiftView.Status.c);
          }
        });
  }
  
  private void l() {
    OnVideoStateChangedListener onVideoStateChangedListener = this.e;
    if (onVideoStateChangedListener != null)
      onVideoStateChangedListener.a(); 
    setVisibility(0);
    try {
      c();
      return;
    } catch (Exception exception) {
      this.f = Status.a;
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a(Context paramContext, IRequestHost paramIRequestHost, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return; 
      File file = new File(paramContext.getExternalCacheDir(), "gift");
      if (!file.exists())
        file.mkdirs(); 
      file = new File(file, Md5.a(paramString));
      if (file.exists()) {
        b(paramContext, paramIRequestHost, file.getPath());
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file.getPath());
      stringBuilder.append(".temp");
      String str = stringBuilder.toString();
      FileDownloader.a(paramString, str, new FileHttpResponseHandler(this, file, paramContext, paramIRequestHost, str) {
            public void a(File param1File) {
              if (param1File != null && param1File.exists() && param1File.renameTo(this.a) && this.a.exists())
                AlphaVideoGiftView.a(this.e, this.b, this.c, this.a.getPath()); 
            }
            
            public void onFinish() {
              (new File(this.d)).deleteOnExit();
            }
          }paramIRequestHost);
    } 
  }
  
  public void a(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return; 
      if (Status.a != this.f)
        return; 
      this.f = Status.b;
      String str = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("videoPath:");
      stringBuilder.append(paramString);
      Log.e(str, stringBuilder.toString());
      a(paramContext, Uri.parse(paramString));
      l();
    } 
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  protected void onEventDestroy() {
    f();
    this.f = Status.a;
    Lifecycle lifecycle = this.d;
    if (lifecycle != null) {
      lifecycle.removeObserver(this);
      this.d = null;
    } 
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  protected void onEventPause() {
    b();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  protected void onEventResume() {
    a();
    if (g())
      c(); 
  }
  
  public void setLifecycle(Lifecycle paramLifecycle) {
    if (paramLifecycle != null) {
      this.d = paramLifecycle;
      this.d.addObserver(this);
    } 
  }
  
  public void setOnVideoStateChangedListener(OnVideoStateChangedListener paramOnVideoStateChangedListener) {
    this.e = paramOnVideoStateChangedListener;
  }
  
  public static interface OnVideoStateChangedListener {
    void a();
    
    void b();
  }
  
  enum Status {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\video_gift\AlphaVideoGiftView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */