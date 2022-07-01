package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.misc.IMediaDataSource;

public abstract class AbstractMediaPlayer implements IMediaPlayer {
  private IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
  
  private IMediaPlayer.OnCompletionListener mOnCompletionListener;
  
  private IMediaPlayer.OnErrorListener mOnErrorListener;
  
  private IMediaPlayer.OnHLSKeyErrorListener mOnHLSKeyErrorListener;
  
  private IMediaPlayer.OnHevcVideoDecoderErrorListener mOnHevcVideoDecoderErrorListener;
  
  private IMediaPlayer.OnInfoListener mOnInfoListener;
  
  private IMediaPlayer.OnPreparedListener mOnPreparedListener;
  
  private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
  
  private IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
  
  private IMediaPlayer.OnVideoDecoderErrorListener mOnVideoDecoderErrorListener;
  
  private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
  
  protected final void notifyHLSKeyError() {
    IMediaPlayer.OnHLSKeyErrorListener onHLSKeyErrorListener = this.mOnHLSKeyErrorListener;
    if (onHLSKeyErrorListener != null)
      onHLSKeyErrorListener.onHLSKeyError(this); 
  }
  
  protected final void notifyHevcVideoDecoderError() {
    IMediaPlayer.OnHevcVideoDecoderErrorListener onHevcVideoDecoderErrorListener = this.mOnHevcVideoDecoderErrorListener;
    if (onHevcVideoDecoderErrorListener != null)
      onHevcVideoDecoderErrorListener.onHevcVideoDecoderError(this); 
  }
  
  protected final void notifyOnBufferingUpdate(int paramInt) {
    IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
    if (onBufferingUpdateListener != null)
      onBufferingUpdateListener.onBufferingUpdate(this, paramInt); 
  }
  
  protected final void notifyOnCompletion() {
    IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
    if (onCompletionListener != null)
      onCompletionListener.onCompletion(this); 
  }
  
  protected final boolean notifyOnError(int paramInt1, int paramInt2) {
    IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
    return (onErrorListener != null && onErrorListener.onError(this, paramInt1, paramInt2));
  }
  
  protected final boolean notifyOnInfo(int paramInt1, int paramInt2) {
    IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
    return (onInfoListener != null && onInfoListener.onInfo(this, paramInt1, paramInt2));
  }
  
  protected final void notifyOnPrepared() {
    IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
    if (onPreparedListener != null)
      onPreparedListener.onPrepared(this); 
  }
  
  protected final void notifyOnSeekComplete() {
    IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
    if (onSeekCompleteListener != null)
      onSeekCompleteListener.onSeekComplete(this); 
  }
  
  protected final void notifyOnTimedText(IjkTimedText paramIjkTimedText) {
    IMediaPlayer.OnTimedTextListener onTimedTextListener = this.mOnTimedTextListener;
    if (onTimedTextListener != null)
      onTimedTextListener.onTimedText(this, paramIjkTimedText); 
  }
  
  protected final void notifyOnVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
    if (onVideoSizeChangedListener != null)
      onVideoSizeChangedListener.onVideoSizeChanged(this, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  protected final void notifyVideoDecoderError() {
    IMediaPlayer.OnVideoDecoderErrorListener onVideoDecoderErrorListener = this.mOnVideoDecoderErrorListener;
    if (onVideoDecoderErrorListener != null)
      onVideoDecoderErrorListener.onVideoDecoderError(this); 
  }
  
  public void resetListeners() {
    this.mOnPreparedListener = null;
    this.mOnBufferingUpdateListener = null;
    this.mOnCompletionListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnVideoSizeChangedListener = null;
    this.mOnErrorListener = null;
    this.mOnInfoListener = null;
    this.mOnTimedTextListener = null;
    this.mOnHLSKeyErrorListener = null;
    this.mOnHevcVideoDecoderErrorListener = null;
    this.mOnVideoDecoderErrorListener = null;
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource) {
    throw new UnsupportedOperationException();
  }
  
  public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {
    this.mOnBufferingUpdateListener = paramOnBufferingUpdateListener;
  }
  
  public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener paramOnCompletionListener) {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public final void setOnErrorListener(IMediaPlayer.OnErrorListener paramOnErrorListener) {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public final void setOnHLSKeyErrorListener(IMediaPlayer.OnHLSKeyErrorListener paramOnHLSKeyErrorListener) {
    this.mOnHLSKeyErrorListener = paramOnHLSKeyErrorListener;
  }
  
  public final void setOnHevcVideoDecoderErrorListener(IMediaPlayer.OnHevcVideoDecoderErrorListener paramOnHevcVideoDecoderErrorListener) {
    this.mOnHevcVideoDecoderErrorListener = paramOnHevcVideoDecoderErrorListener;
  }
  
  public final void setOnInfoListener(IMediaPlayer.OnInfoListener paramOnInfoListener) {
    this.mOnInfoListener = paramOnInfoListener;
  }
  
  public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener paramOnPreparedListener) {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public final void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener paramOnTimedTextListener) {
    this.mOnTimedTextListener = paramOnTimedTextListener;
  }
  
  public final void setOnVideoDecoderErrorListener(IMediaPlayer.OnVideoDecoderErrorListener paramOnVideoDecoderErrorListener) {
    this.mOnVideoDecoderErrorListener = paramOnVideoDecoderErrorListener;
  }
  
  public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {
    this.mOnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\AbstractMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */