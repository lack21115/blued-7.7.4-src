package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.o;
import java.util.List;

public class PLShortVideoMixer {
  private o mShortVideoMixerCore;
  
  public PLShortVideoMixer(Context paramContext, String paramString, long paramLong) {
    this.mShortVideoMixerCore = new o(paramContext, paramString, paramLong);
  }
  
  public void cancel() {
    this.mShortVideoMixerCore.a();
  }
  
  public void mix(List<PLVideoMixItem> paramList, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoMixerCore.a(paramList, paramPLVideoSaveListener);
    QosManager.a().a(QosManager.KeyPoint.mix_video);
    QosManager.a().a(this.mShortVideoMixerCore.a(paramList.size()));
  }
  
  public void setVideoEncodeSetting(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.mShortVideoMixerCore.a(paramPLVideoEncodeSetting);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoMixer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */