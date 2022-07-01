package com.soft.blued.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.soft.blued.utils.Logger;

public class TextureVideoView extends TextureView implements TextureView.SurfaceTextureListener {
  MediaState a;
  
  OnStateChangeListener b;
  
  private MediaPlayer c;
  
  private Context d;
  
  private MediaPlayer.OnInfoListener e = new MediaPlayer.OnInfoListener(this) {
      public boolean onInfo(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
        Logger.a("ddrb", new Object[] { "onInfo" });
        if (this.a.b != null) {
          this.a.b.b();
          if (param1Int1 == 701) {
            this.a.b.c();
            return false;
          } 
          if (param1Int1 == 702)
            this.a.b.b(); 
        } 
        return false;
      }
    };
  
  private MediaPlayer.OnBufferingUpdateListener f = new MediaPlayer.OnBufferingUpdateListener(this) {
      public void onBufferingUpdate(MediaPlayer param1MediaPlayer, int param1Int) {
        Logger.a("ddrb", new Object[] { "onBufferingUpdate" });
        if (this.a.b != null && this.a.a == TextureVideoView.MediaState.c) {
          if (TextureVideoView.a(this.a) == null)
            return; 
          this.a.b.a(TextureVideoView.a(this.a).getDuration(), TextureVideoView.a(this.a).getCurrentPosition());
        } 
      }
    };
  
  public TextureVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    a();
  }
  
  public void a() {
    setSurfaceTextureListener(this);
  }
  
  public void a(String paramString) {
    if (this.a == MediaState.b) {
      b();
      return;
    } 
    MediaPlayer mediaPlayer = this.c;
    if (mediaPlayer == null)
      return; 
    mediaPlayer.reset();
    this.c.setLooping(true);
    try {
      this.c.setDataSource(paramString);
      this.c.prepareAsync();
      this.a = MediaState.b;
    } catch (Exception exception) {
      exception.printStackTrace();
      if (this.b != null) {
        Logger.a("ddrb", new Object[] { "play =", exception });
        this.b.e();
      } 
    } 
    Logger.a("ddrb", new Object[] { "play end" });
  }
  
  public void b() {
    if (this.c == null)
      return; 
    ThreadManager.a().a(new ThreadExecutor(this, "TextureVideoStop") {
          public void execute() {
            try {
              TextureVideoView.MediaState mediaState1 = this.a.a;
              TextureVideoView.MediaState mediaState2 = TextureVideoView.MediaState.a;
              if (mediaState1 == mediaState2)
                return; 
              if (this.a.a == TextureVideoView.MediaState.b) {
                TextureVideoView.a(this.a).reset();
                this.a.a = TextureVideoView.MediaState.a;
                System.out.println("prepare->reset");
                return;
              } 
              if (this.a.a == TextureVideoView.MediaState.d) {
                TextureVideoView.a(this.a).stop();
                TextureVideoView.a(this.a).reset();
                this.a.a = TextureVideoView.MediaState.a;
                System.out.println("pause->init");
                return;
              } 
              if (this.a.a == TextureVideoView.MediaState.c) {
                TextureVideoView.a(this.a).pause();
                TextureVideoView.a(this.a).stop();
                TextureVideoView.a(this.a).reset();
                this.a.a = TextureVideoView.MediaState.a;
                System.out.println("playing->init");
                return;
              } 
            } catch (Exception exception) {
              TextureVideoView.a(this.a).reset();
              this.a.a = TextureVideoView.MediaState.a;
            } finally {
              if (this.a.b != null)
                this.a.b.d(); 
            } 
          }
        });
  }
  
  public MediaPlayer getMediaPlayer() {
    return this.c;
  }
  
  public MediaState getState() {
    return this.a;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    Surface surface = new Surface(paramSurfaceTexture);
    if (this.c == null) {
      this.c = new MediaPlayer();
      this.c.setVolume(0.0F, 0.0F);
    } 
    this.c.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) {
          public void onPrepared(MediaPlayer param1MediaPlayer) {
            param1MediaPlayer.start();
            this.a.a = TextureVideoView.MediaState.c;
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    if (this.a.a.b != null)
                      this.a.a.b.b(); 
                  }
                },  300L);
          }
        });
    this.c.setOnErrorListener(new MediaPlayer.OnErrorListener(this) {
          public boolean onError(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
            this.a.a = TextureVideoView.MediaState.a;
            if (this.a.b != null)
              this.a.b.e(); 
            return false;
          }
        });
    this.c.setOnInfoListener(this.e);
    this.c.setOnBufferingUpdateListener(this.f);
    this.c.setSurface(surface);
    this.a = MediaState.a;
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture) {
    OnStateChangeListener onStateChangeListener = this.b;
    if (onStateChangeListener != null)
      onStateChangeListener.a(); 
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setOnStateChangeListener(OnStateChangeListener paramOnStateChangeListener) {
    this.b = paramOnStateChangeListener;
  }
  
  public enum MediaState {
    a, b, c, d, e;
  }
  
  public static interface OnStateChangeListener {
    void a();
    
    void a(int param1Int1, int param1Int2);
    
    void b();
    
    void c();
    
    void d();
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\TextureVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */