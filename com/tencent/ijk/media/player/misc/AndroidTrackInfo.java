package com.tencent.ijk.media.player.misc;

import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.os.Build;

public class AndroidTrackInfo implements ITrackInfo {
  private final MediaPlayer.TrackInfo mTrackInfo;
  
  private AndroidTrackInfo(MediaPlayer.TrackInfo paramTrackInfo) {
    this.mTrackInfo = paramTrackInfo;
  }
  
  public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer paramMediaPlayer) {
    return (Build.VERSION.SDK_INT >= 16) ? fromTrackInfo(paramMediaPlayer.getTrackInfo()) : null;
  }
  
  private static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] paramArrayOfTrackInfo) {
    if (paramArrayOfTrackInfo == null)
      return null; 
    AndroidTrackInfo[] arrayOfAndroidTrackInfo = new AndroidTrackInfo[paramArrayOfTrackInfo.length];
    for (int i = 0; i < paramArrayOfTrackInfo.length; i++)
      arrayOfAndroidTrackInfo[i] = new AndroidTrackInfo(paramArrayOfTrackInfo[i]); 
    return arrayOfAndroidTrackInfo;
  }
  
  public IMediaFormat getFormat() {
    if (this.mTrackInfo == null)
      return null; 
    if (Build.VERSION.SDK_INT < 19)
      return null; 
    MediaFormat mediaFormat = this.mTrackInfo.getFormat();
    return (mediaFormat == null) ? null : new AndroidMediaFormat(mediaFormat);
  }
  
  public String getInfoInline() {
    MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
    return (trackInfo != null) ? trackInfo.toString() : "null";
  }
  
  public String getLanguage() {
    MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
    return (trackInfo == null) ? "und" : trackInfo.getLanguage();
  }
  
  public int getTrackType() {
    MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
    return (trackInfo == null) ? 0 : trackInfo.getTrackType();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append('{');
    MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
    if (trackInfo != null) {
      stringBuilder.append(trackInfo.toString());
    } else {
      stringBuilder.append("null");
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\misc\AndroidTrackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */