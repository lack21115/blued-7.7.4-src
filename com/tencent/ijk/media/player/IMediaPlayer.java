package com.tencent.ijk.media.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.ijk.media.player.misc.IMediaDataSource;
import com.tencent.ijk.media.player.misc.ITrackInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface IMediaPlayer {
  public static final int MEDIA_ERROR_IO = -1004;
  
  public static final int MEDIA_ERROR_MALFORMED = -1007;
  
  public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
  
  public static final int MEDIA_ERROR_SERVER_DIED = 100;
  
  public static final int MEDIA_ERROR_TIMED_OUT = -110;
  
  public static final int MEDIA_ERROR_UNKNOWN = 1;
  
  public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
  
  public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
  
  public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
  
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  
  public static final int MEDIA_INFO_FIRST_VIDEO_PACKET = 10011;
  
  public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
  
  public static final int MEDIA_INFO_METADATA_UPDATE = 802;
  
  public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
  
  public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
  
  public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
  
  public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
  
  public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
  
  public static final int MEDIA_INFO_UNKNOWN = 1;
  
  public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
  
  public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
  
  public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
  
  public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
  
  int getAudioSessionId();
  
  int getBitrateIndex();
  
  long getCurrentPosition();
  
  String getDataSource();
  
  long getDuration();
  
  MediaInfo getMediaInfo();
  
  float getRate();
  
  ArrayList<IjkBitrateItem> getSupportedBitrates();
  
  Surface getSurface();
  
  ITrackInfo[] getTrackInfo();
  
  int getVideoHeight();
  
  int getVideoSarDen();
  
  int getVideoSarNum();
  
  int getVideoWidth();
  
  boolean isLooping();
  
  @Deprecated
  boolean isPlayable();
  
  boolean isPlaying();
  
  void pause() throws IllegalStateException;
  
  void prepareAsync() throws IllegalStateException;
  
  void release();
  
  void reset();
  
  void seekTo(long paramLong) throws IllegalStateException;
  
  void setAudioStreamType(int paramInt);
  
  void setAudioVolume(int paramInt);
  
  void setBitrateIndex(int paramInt);
  
  void setDataSource(Context paramContext, Uri paramUri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  void setDataSource(IMediaDataSource paramIMediaDataSource);
  
  void setDataSource(FileDescriptor paramFileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException;
  
  void setDataSource(String paramString) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
  
  void setDisplay(SurfaceHolder paramSurfaceHolder);
  
  @Deprecated
  void setKeepInBackground(boolean paramBoolean);
  
  @Deprecated
  void setLogEnabled(boolean paramBoolean);
  
  void setLooping(boolean paramBoolean);
  
  void setOnBufferingUpdateListener(OnBufferingUpdateListener paramOnBufferingUpdateListener);
  
  void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  void setOnErrorListener(OnErrorListener paramOnErrorListener);
  
  void setOnHLSKeyErrorListener(OnHLSKeyErrorListener paramOnHLSKeyErrorListener);
  
  void setOnHevcVideoDecoderErrorListener(OnHevcVideoDecoderErrorListener paramOnHevcVideoDecoderErrorListener);
  
  void setOnInfoListener(OnInfoListener paramOnInfoListener);
  
  void setOnPreparedListener(OnPreparedListener paramOnPreparedListener);
  
  void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  void setOnTimedTextListener(OnTimedTextListener paramOnTimedTextListener);
  
  void setOnVideoDecoderErrorListener(OnVideoDecoderErrorListener paramOnVideoDecoderErrorListener);
  
  void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  void setRate(float paramFloat);
  
  void setScreenOnWhilePlaying(boolean paramBoolean);
  
  void setSurface(Surface paramSurface);
  
  void setVolume(float paramFloat1, float paramFloat2);
  
  @Deprecated
  void setWakeMode(Context paramContext, int paramInt);
  
  void start() throws IllegalStateException;
  
  void stop() throws IllegalStateException;
  
  public static interface OnBufferingUpdateListener {
    void onBufferingUpdate(IMediaPlayer param1IMediaPlayer, int param1Int);
  }
  
  public static interface OnCompletionListener {
    void onCompletion(IMediaPlayer param1IMediaPlayer);
  }
  
  public static interface OnErrorListener {
    boolean onError(IMediaPlayer param1IMediaPlayer, int param1Int1, int param1Int2);
  }
  
  public static interface OnHLSKeyErrorListener {
    void onHLSKeyError(IMediaPlayer param1IMediaPlayer);
  }
  
  public static interface OnHevcVideoDecoderErrorListener {
    void onHevcVideoDecoderError(IMediaPlayer param1IMediaPlayer);
  }
  
  public static interface OnInfoListener {
    boolean onInfo(IMediaPlayer param1IMediaPlayer, int param1Int1, int param1Int2);
  }
  
  public static interface OnPreparedListener {
    void onPrepared(IMediaPlayer param1IMediaPlayer);
  }
  
  public static interface OnSeekCompleteListener {
    void onSeekComplete(IMediaPlayer param1IMediaPlayer);
  }
  
  public static interface OnTimedTextListener {
    void onTimedText(IMediaPlayer param1IMediaPlayer, IjkTimedText param1IjkTimedText);
  }
  
  public static interface OnVideoDecoderErrorListener {
    void onVideoDecoderError(IMediaPlayer param1IMediaPlayer);
  }
  
  public static interface OnVideoSizeChangedListener {
    void onVideoSizeChanged(IMediaPlayer param1IMediaPlayer, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\IMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */