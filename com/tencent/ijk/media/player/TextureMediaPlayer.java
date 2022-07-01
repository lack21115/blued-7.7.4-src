package com.tencent.ijk.media.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.ArrayList;

public class TextureMediaPlayer extends MediaPlayerProxy implements IMediaPlayer, ISurfaceTextureHolder {
  private IMediaPlayer mBackEndMediaPlayer;
  
  private boolean mReuseSurfaceTexture;
  
  private Surface mSurface;
  
  private SurfaceTexture mSurfaceTexture;
  
  private ISurfaceTextureHost mSurfaceTextureHost;
  
  public TextureMediaPlayer(IMediaPlayer paramIMediaPlayer) {
    super(paramIMediaPlayer);
    this.mBackEndMediaPlayer = paramIMediaPlayer;
  }
  
  public IMediaPlayer getBackEndMediaPlayer() {
    return this.mBackEndMediaPlayer;
  }
  
  public int getBitrateIndex() {
    return this.mBackEndMediaPlayer.getBitrateIndex();
  }
  
  public ArrayList<IjkBitrateItem> getSupportedBitrates() {
    return this.mBackEndMediaPlayer.getSupportedBitrates();
  }
  
  public Surface getSurface() {
    return super.getSurface();
  }
  
  public SurfaceTexture getSurfaceTexture() {
    return this.mSurfaceTexture;
  }
  
  public void release() {
    super.release();
    releaseSurfaceTexture();
  }
  
  public void releaseSurfaceTexture() {
    SurfaceTexture surfaceTexture = this.mSurfaceTexture;
    if (surfaceTexture != null && !this.mReuseSurfaceTexture) {
      ISurfaceTextureHost iSurfaceTextureHost = this.mSurfaceTextureHost;
      if (iSurfaceTextureHost != null) {
        iSurfaceTextureHost.releaseSurfaceTexture(surfaceTexture);
      } else {
        surfaceTexture.release();
      } 
      this.mSurfaceTexture = null;
    } 
  }
  
  public void reset() {
    super.reset();
    releaseSurfaceTexture();
  }
  
  public void setBitrateIndex(int paramInt) {
    this.mBackEndMediaPlayer.setBitrateIndex(paramInt);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder) {
    if (this.mSurfaceTexture == null)
      super.setDisplay(paramSurfaceHolder); 
  }
  
  public void setReuseSurfaceTexture(boolean paramBoolean) {
    this.mReuseSurfaceTexture = paramBoolean;
  }
  
  public void setSurface(Surface paramSurface) {
    if (this.mSurfaceTexture == null)
      super.setSurface(paramSurface); 
    this.mSurface = paramSurface;
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture) {
    if (this.mSurfaceTexture == paramSurfaceTexture)
      return; 
    releaseSurfaceTexture();
    this.mSurfaceTexture = paramSurfaceTexture;
    if (paramSurfaceTexture == null) {
      this.mSurface = null;
      super.setSurface(null);
      return;
    } 
    if (this.mSurface == null)
      this.mSurface = new Surface(paramSurfaceTexture); 
    super.setSurface(this.mSurface);
  }
  
  public void setSurfaceTextureHost(ISurfaceTextureHost paramISurfaceTextureHost) {
    this.mSurfaceTextureHost = paramISurfaceTextureHost;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\TextureMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */