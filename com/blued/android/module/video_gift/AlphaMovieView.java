package com.blued.android.module.video_gift;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;

class AlphaMovieView extends GLTextureView {
  VideoRenderer a;
  
  private float b = 1.3333334F;
  
  private MediaPlayer c;
  
  private OnVideoStartedListener d;
  
  private OnVideoEndedListener e;
  
  private boolean f;
  
  private boolean g;
  
  private FitViewHelper h;
  
  private PlayerState i = PlayerState.a;
  
  public AlphaMovieView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    if (!isInEditMode())
      a(paramContext, paramAttributeSet); 
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    setEGLContextClientVersion(2);
    a(8, 8, 8, 8, 16, 0);
    this.h = new FitViewHelper();
    k();
    this.a = new VideoRenderer();
    b(paramContext, paramAttributeSet);
    l();
    setRenderer(this.a);
    bringToFront();
    setPreserveEGLContextOnPause(true);
    setOpaque(false);
  }
  
  private void a(MediaMetadataRetriever paramMediaMetadataRetriever) {
    int i = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(18)) / 2;
    int j = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(19));
    FitViewHelper fitViewHelper = this.h;
    if (fitViewHelper != null)
      fitViewHelper.a(i * 1.0F / j, 0, 0); 
    this.g = true;
    i();
    if (this.f)
      m(); 
  }
  
  private void a(MediaPlayer.OnPreparedListener paramOnPreparedListener) {
    if ((this.c != null && this.i == PlayerState.a) || this.i == PlayerState.e) {
      this.c.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this, paramOnPreparedListener) {
            public void onPrepared(MediaPlayer param1MediaPlayer) {
              AlphaMovieView.a(this.b, AlphaMovieView.PlayerState.b);
              this.a.onPrepared(param1MediaPlayer);
            }
          });
      try {
        this.c.prepareAsync();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet) {
    this.a.a(paramContext.getString(R.string.video_gift_shader));
  }
  
  private void i() {
    requestLayout();
    invalidate();
  }
  
  private void k() {
    this.c = new MediaPlayer();
    setScreenOnWhilePlaying(true);
    setLooping(true);
    this.c.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) {
          public void onCompletion(MediaPlayer param1MediaPlayer) {
            AlphaMovieView.a(this.a, AlphaMovieView.PlayerState.d);
            if (AlphaMovieView.a(this.a) != null)
              AlphaMovieView.a(this.a).a(); 
          }
        });
  }
  
  private void l() {
    VideoRenderer videoRenderer = this.a;
    if (videoRenderer != null)
      videoRenderer.a(new VideoRenderer.OnSurfacePrepareListener(this) {
            public void a(Surface param1Surface) {
              AlphaMovieView.a(this.a, true);
              AlphaMovieView.b(this.a).setSurface(param1Surface);
              if (AlphaMovieView.c(this.a))
                AlphaMovieView.d(this.a); 
            }
          }); 
  }
  
  private void m() {
    a(new MediaPlayer.OnPreparedListener(this) {
          public void onPrepared(MediaPlayer param1MediaPlayer) {
            this.a.c();
          }
        });
  }
  
  public void a() {
    super.a();
  }
  
  public void a(int paramInt) {
    this.c.seekTo(paramInt);
  }
  
  public void a(Context paramContext, Uri paramUri) {
    e();
    try {
      this.c.setDataSource(paramContext, paramUri);
      MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
      mediaMetadataRetriever.setDataSource(paramContext, paramUri);
      a(mediaMetadataRetriever);
      return;
    } catch (IOException iOException) {
      Log.e("VideoSurfaceView", iOException.getMessage(), iOException);
      return;
    } 
  }
  
  public void b() {
    super.b();
    d();
  }
  
  public void c() {
    if (this.c != null) {
      int i = null.a[this.i.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          a(new MediaPlayer.OnPreparedListener(this) {
                public void onPrepared(MediaPlayer param1MediaPlayer) {
                  AlphaMovieView.b(this.a).start();
                  AlphaMovieView.a(this.a, AlphaMovieView.PlayerState.c);
                  if (AlphaMovieView.e(this.a) != null)
                    AlphaMovieView.e(this.a).a(); 
                }
              });
          return;
        } 
        this.c.start();
        this.i = PlayerState.c;
        return;
      } 
      this.c.start();
      this.i = PlayerState.c;
      OnVideoStartedListener onVideoStartedListener = this.d;
      if (onVideoStartedListener != null)
        onVideoStartedListener.a(); 
    } 
  }
  
  public void d() {
    if (this.c != null && this.i == PlayerState.c) {
      this.c.pause();
      this.i = PlayerState.d;
    } 
  }
  
  public void e() {
    if (this.c != null && (this.i == PlayerState.c || this.i == PlayerState.d || this.i == PlayerState.e)) {
      this.c.reset();
      this.i = PlayerState.a;
    } 
  }
  
  public void f() {
    MediaPlayer mediaPlayer = this.c;
    if (mediaPlayer != null) {
      mediaPlayer.release();
      this.i = PlayerState.f;
    } 
  }
  
  public boolean g() {
    return (this.i == PlayerState.d);
  }
  
  public int getCurrentPosition() {
    return this.c.getCurrentPosition();
  }
  
  public MediaPlayer getMediaPlayer() {
    return this.c;
  }
  
  public PlayerState getState() {
    return this.i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    FitViewHelper fitViewHelper = this.h;
    if (fitViewHelper != null)
      fitViewHelper.a(paramInt1, paramInt2); 
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.h.a(), i), View.MeasureSpec.makeMeasureSpec(this.h.b(), j));
  }
  
  public void setLooping(boolean paramBoolean) {
    this.c.setLooping(paramBoolean);
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener) {
    this.c.setOnErrorListener(paramOnErrorListener);
  }
  
  public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {
    this.c.setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  public void setOnVideoEndedListener(OnVideoEndedListener paramOnVideoEndedListener) {
    this.e = paramOnVideoEndedListener;
  }
  
  public void setOnVideoStartedListener(OnVideoStartedListener paramOnVideoStartedListener) {
    this.d = paramOnVideoStartedListener;
  }
  
  public void setScaleType(FitViewHelper.ScaleType paramScaleType) {
    FitViewHelper fitViewHelper = this.h;
    if (fitViewHelper != null) {
      fitViewHelper.a(paramScaleType);
      i();
    } 
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean) {
    this.c.setScreenOnWhilePlaying(paramBoolean);
  }
  
  public void setVideoByUrl(String paramString) {
    e();
    try {
      this.c.setDataSource(paramString);
      MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
      mediaMetadataRetriever.setDataSource(paramString, new HashMap<Object, Object>());
      a(mediaMetadataRetriever);
      return;
    } catch (IOException iOException) {
      Log.e("VideoSurfaceView", iOException.getMessage(), iOException);
      return;
    } 
  }
  
  public void setVideoFromAssets(String paramString) {
    e();
    try {
      AssetFileDescriptor assetFileDescriptor = getContext().getAssets().openFd(paramString);
      this.c.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
      MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
      mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
      a(mediaMetadataRetriever);
      return;
    } catch (IOException iOException) {
      Log.e("VideoSurfaceView", iOException.getMessage(), iOException);
      return;
    } 
  }
  
  public void setVideoFromFile(FileDescriptor paramFileDescriptor) {
    e();
    try {
      this.c.setDataSource(paramFileDescriptor);
      MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
      mediaMetadataRetriever.setDataSource(paramFileDescriptor);
      a(mediaMetadataRetriever);
      return;
    } catch (IOException iOException) {
      Log.e("VideoSurfaceView", iOException.getMessage(), iOException);
      return;
    } 
  }
  
  public void setVideoFromMediaDataSource(MediaDataSource paramMediaDataSource) {
    e();
    this.c.setDataSource(paramMediaDataSource);
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(paramMediaDataSource);
    a(mediaMetadataRetriever);
  }
  
  public static interface OnVideoEndedListener {
    void a();
  }
  
  public static interface OnVideoStartedListener {
    void a();
  }
  
  enum PlayerState {
    a, b, c, d, e, f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\video_gift\AlphaMovieView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */