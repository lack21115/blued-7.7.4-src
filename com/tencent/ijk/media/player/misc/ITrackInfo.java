package com.tencent.ijk.media.player.misc;

public interface ITrackInfo {
  public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
  
  public static final int MEDIA_TRACK_TYPE_METADATA = 5;
  
  public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
  
  public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
  
  public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
  
  public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
  
  IMediaFormat getFormat();
  
  String getInfoInline();
  
  String getLanguage();
  
  int getTrackType();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\misc\ITrackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */