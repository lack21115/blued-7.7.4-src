package com.tencent.ijk.media.player.misc;

import android.text.TextUtils;
import com.tencent.ijk.media.player.IjkMediaMeta;

public class IjkTrackInfo implements ITrackInfo {
  private IjkMediaMeta.IjkStreamMeta mStreamMeta;
  
  private int mTrackType = 0;
  
  public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta paramIjkStreamMeta) {
    this.mStreamMeta = paramIjkStreamMeta;
  }
  
  public IMediaFormat getFormat() {
    return new IjkMediaFormat(this.mStreamMeta);
  }
  
  public String getInfoInline() {
    StringBuilder stringBuilder = new StringBuilder(128);
    int i = this.mTrackType;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            stringBuilder.append("UNKNOWN");
          } else {
            stringBuilder.append("SUBTITLE");
          } 
        } else {
          stringBuilder.append("TIMEDTEXT");
          stringBuilder.append(", ");
          stringBuilder.append(this.mStreamMeta.mLanguage);
        } 
      } else {
        stringBuilder.append("AUDIO");
        stringBuilder.append(", ");
        stringBuilder.append(this.mStreamMeta.getCodecShortNameInline());
        stringBuilder.append(", ");
        stringBuilder.append(this.mStreamMeta.getBitrateInline());
        stringBuilder.append(", ");
        stringBuilder.append(this.mStreamMeta.getSampleRateInline());
      } 
    } else {
      stringBuilder.append("VIDEO");
      stringBuilder.append(", ");
      stringBuilder.append(this.mStreamMeta.getCodecShortNameInline());
      stringBuilder.append(", ");
      stringBuilder.append(this.mStreamMeta.getBitrateInline());
      stringBuilder.append(", ");
      stringBuilder.append(this.mStreamMeta.getResolutionInline());
    } 
    return stringBuilder.toString();
  }
  
  public String getLanguage() {
    IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
    return (ijkStreamMeta == null || TextUtils.isEmpty(ijkStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
  }
  
  public int getTrackType() {
    return this.mTrackType;
  }
  
  public void setMediaMeta(IjkMediaMeta.IjkStreamMeta paramIjkStreamMeta) {
    this.mStreamMeta = paramIjkStreamMeta;
  }
  
  public void setTrackType(int paramInt) {
    this.mTrackType = paramInt;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append('{');
    stringBuilder.append(getInfoInline());
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\misc\IjkTrackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */