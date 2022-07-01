package com.blued.android.module.shortvideo.model;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import java.io.Serializable;

public class TrimDataModel extends CommonModel {
  public static final int SLICE_COUNT = 7;
  
  private static final String TAG;
  
  private long durationMs;
  
  private int marginSize;
  
  private int maxWidth;
  
  private PLMediaFile mediaFile;
  
  private int paddingSize;
  
  private double rangeWidth;
  
  private SerializableData serializableData = new SerializableData();
  
  private int singleRangeWidth;
  
  private int slidingBlockPxHeight;
  
  private int slidingBlockPxWidth;
  
  private int thumbnailsCount;
  
  private int videoHeigh;
  
  private int videoRotation;
  
  private int videoWidth;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TrimDataModel.class.getSimpleName());
    stringBuilder.append(" ");
    TAG = stringBuilder.toString();
  }
  
  private void initTrimViewData() {
    if (this.durationMs > 0L) {
      setLeftProgress(0.0D);
      setRightProgress(Math.min(getDurationMs(), getMaxVideoDuration()));
      if (getDurationMs() <= getMaxVideoDuration()) {
        this.thumbnailsCount = 10;
        this.rangeWidth = this.maxWidth;
      } else {
        this.thumbnailsCount = (int)Math.ceil(((float)this.durationMs * 1.0F / (float)getMaxVideoDuration() * 1.0F * 10.0F));
        float f = (float)getMaxVideoDuration() * 1.0F / (float)this.durationMs;
        this.rangeWidth = (this.maxWidth / f);
      } 
      this.singleRangeWidth = (int)Math.round(this.rangeWidth / this.thumbnailsCount);
      SerializableData.a(this.serializableData, (float)(this.rangeWidth / this.durationMs * 1.0D));
      SerializableData.b(this.serializableData, (float)(((float)this.durationMs * 1.0F) / this.rangeWidth * 1.0D));
    } 
  }
  
  public void clear() {
    super.clear();
    this.serializableData.a();
    this.mediaFile = null;
    this.durationMs = 0L;
    this.videoWidth = 0;
    this.videoHeigh = 0;
    this.videoRotation = 0;
    this.maxWidth = 0;
    this.marginSize = 0;
    this.paddingSize = 0;
    this.slidingBlockPxWidth = 0;
    this.slidingBlockPxHeight = 0;
    this.thumbnailsCount = 0;
    this.rangeWidth = 0.0D;
    this.singleRangeWidth = 0;
  }
  
  public void copyModel(CommonModel paramCommonModel, SerializableData paramSerializableData) {
    copyModel(paramCommonModel, true);
    if (this.serializableData == null)
      this.serializableData = new SerializableData(); 
    this.serializableData.a(paramSerializableData);
    setCurrentPage(3);
    setMediaFile(paramCommonModel.getVideoPath());
  }
  
  public int getAudioChannels() {
    return this.mediaFile.getAudioChannels();
  }
  
  public int getAudioSampleRate() {
    return this.mediaFile.getAudioSampleRate();
  }
  
  public float getAverageMsPx() {
    return SerializableData.b(this.serializableData);
  }
  
  public float getAveragePxMs() {
    return SerializableData.c(this.serializableData);
  }
  
  public long getDurationMs() {
    return this.durationMs;
  }
  
  public String getFilepath() {
    return this.mediaFile.getFilepath();
  }
  
  public double getLeftProgress() {
    return SerializableData.d(this.serializableData);
  }
  
  public int getMarginSize() {
    return this.marginSize;
  }
  
  public int getMaxWidth() {
    return this.maxWidth;
  }
  
  public PLMediaFile getMediaFile() {
    return this.mediaFile;
  }
  
  public int getPaddingSize() {
    return this.paddingSize;
  }
  
  public double getRightProgress() {
    return SerializableData.e(this.serializableData);
  }
  
  public long getScrollMs() {
    return SerializableData.f(this.serializableData);
  }
  
  public long getSelectedBeginMs() {
    return this.serializableData.a;
  }
  
  public long getSelectedDurationMs() {
    return this.serializableData.b - this.serializableData.a;
  }
  
  public long getSelectedEndMs() {
    return this.serializableData.b;
  }
  
  public SerializableData getSerializableData() {
    return this.serializableData;
  }
  
  public int getSingleRangeWidth() {
    return this.singleRangeWidth;
  }
  
  public int getSlidingBlockPxHeight() {
    return this.slidingBlockPxHeight;
  }
  
  public int getSlidingBlockPxWidth() {
    return this.slidingBlockPxWidth;
  }
  
  public int getThumbnailsCount() {
    return this.thumbnailsCount;
  }
  
  public int getVideoBitrate() {
    return this.mediaFile.getVideoBitrate();
  }
  
  public int getVideoFrameRate() {
    return this.mediaFile.getVideoFrameRate();
  }
  
  public int getVideoHeight() {
    return this.videoHeigh;
  }
  
  public int getVideoIFrameInterval() {
    return this.mediaFile.getVideoIFrameInterval();
  }
  
  public int getVideoRotation() {
    return this.mediaFile.getVideoRotation();
  }
  
  public int getVideoWidth() {
    return this.videoWidth;
  }
  
  public void initViewData() {
    this.slidingBlockPxWidth = DensityUtils.a(AppInfo.d(), 11.0F);
    this.slidingBlockPxHeight = DensityUtils.a(AppInfo.d(), 55.0F);
    this.paddingSize = DensityUtils.a(AppInfo.d(), 39.0F);
    this.marginSize = this.paddingSize + DensityUtils.a(AppInfo.d(), 11.0F);
    this.maxWidth = AppInfo.l - this.marginSize * 2;
  }
  
  public void release() {
    this.mediaFile.release();
  }
  
  public void setLeftProgress(double paramDouble) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TAG);
    stringBuilder.append("setLeftProgress:%f");
    StvLogUtils.a(stringBuilder.toString(), new Object[] { Double.valueOf(paramDouble) });
    SerializableData.a(this.serializableData, paramDouble);
  }
  
  public void setMaxVideoDuration(long paramLong) {
    super.setMaxVideoDuration(paramLong);
    initTrimViewData();
  }
  
  public void setMediaFile(String paramString) {
    this.mediaFile = new PLMediaFile(paramString);
    this.durationMs = this.mediaFile.getDurationMs();
    this.videoRotation = this.mediaFile.getVideoRotation();
    int i = this.videoRotation;
    if (i == 90 || i == 270) {
      this.videoWidth = this.mediaFile.getVideoHeight();
      this.videoHeigh = this.mediaFile.getVideoWidth();
    } else {
      this.videoWidth = this.mediaFile.getVideoWidth();
      this.videoHeigh = this.mediaFile.getVideoHeight();
    } 
    initViewData();
  }
  
  public void setRightProgress(double paramDouble) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TAG);
    stringBuilder.append("setRightProgress:%f");
    StvLogUtils.a(stringBuilder.toString(), new Object[] { Double.valueOf(paramDouble) });
    SerializableData.b(this.serializableData, paramDouble);
  }
  
  public void setScrollMs(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TAG);
    stringBuilder.append(" scrollMs:");
    stringBuilder.append(paramLong);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    SerializableData.a(this.serializableData, paramLong);
  }
  
  public void setSelectedBeginMs(long paramLong) {
    this.serializableData.a = paramLong;
  }
  
  public void setSelectedEndMs(long paramLong) {
    this.serializableData.b = paramLong;
  }
  
  public static class SerializableData implements Serializable {
    public long a;
    
    public long b = 60000L;
    
    private float c;
    
    private float d;
    
    private double e;
    
    private double f;
    
    private long g = 0L;
    
    public void a() {
      this.a = 0L;
      this.b = 60000L;
      this.c = 0.0F;
      this.d = 0.0F;
      this.e = 0.0D;
      this.f = 0.0D;
      this.g = 0L;
    }
    
    public void a(SerializableData param1SerializableData) {
      if (param1SerializableData != null) {
        this.a = param1SerializableData.a;
        this.b = param1SerializableData.b;
        this.c = param1SerializableData.c;
        this.d = param1SerializableData.d;
        this.e = param1SerializableData.e;
        this.f = param1SerializableData.f;
        this.g = param1SerializableData.g;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\TrimDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */