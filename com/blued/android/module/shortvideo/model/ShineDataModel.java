package com.blued.android.module.shortvideo.model;

import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import java.io.Serializable;

public class ShineDataModel extends CommonModel {
  public static final int SHOW_V_COUNTDOWN = 5;
  
  private long durationMs;
  
  private boolean isRecording = false;
  
  private PLMediaFile mediaFile;
  
  private SerializableData serializableData = new SerializableData();
  
  private int videoHeigh;
  
  private int videoRotation;
  
  private int videoWidth;
  
  public void clear() {
    super.clear();
    this.serializableData.a();
    this.mediaFile = null;
    this.durationMs = 0L;
    this.videoWidth = 0;
    this.videoHeigh = 0;
    this.videoRotation = 0;
    this.isRecording = false;
  }
  
  public void copyModel(CommonModel paramCommonModel, SerializableData paramSerializableData) {
    copyModel(paramCommonModel, true);
    if (this.serializableData == null)
      this.serializableData = new SerializableData(); 
    this.serializableData.a(paramSerializableData);
  }
  
  public int getAudioChannels() {
    return this.mediaFile.getAudioChannels();
  }
  
  public int getAudioSampleRate() {
    return this.mediaFile.getAudioSampleRate();
  }
  
  public int getCurrentCameraId() {
    return this.serializableData.d;
  }
  
  public long getDurationMs() {
    return this.durationMs;
  }
  
  public String getFramePath() {
    return this.serializableData.g;
  }
  
  public PLMediaFile getMediaFile() {
    return this.mediaFile;
  }
  
  public double getRecordSpeed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield serializableData : Lcom/blued/android/module/shortvideo/model/ShineDataModel$SerializableData;
    //   6: getfield a : D
    //   9: dstore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: dload_1
    //   13: dreturn
    //   14: astore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_3
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public SerializableData getSerializableData() {
    return this.serializableData;
  }
  
  public long getTotalDuration() {
    return this.serializableData.f;
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
  
  public boolean isBeginSection() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield serializableData : Lcom/blued/android/module/shortvideo/model/ShineDataModel$SerializableData;
    //   6: getfield b : Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean isConcatSections() {
    return (getTotalDuration() >= getMinRecordDuration() * getRecordSpeed());
  }
  
  public boolean isMaxTime() {
    return (this.serializableData.f >= getMaxRecordDuration());
  }
  
  public boolean isRecordCompleted() {
    return this.serializableData.c;
  }
  
  public boolean isRecordSection() {
    return !(this.serializableData.e <= 0);
  }
  
  public boolean isRecording() {
    return this.isRecording;
  }
  
  public void onSectionCountChanged(long paramLong, int paramInt) {
    SerializableData serializableData = this.serializableData;
    serializableData.f = paramLong;
    serializableData.e = paramInt;
  }
  
  public void release() {
    this.mediaFile.release();
  }
  
  public void setBeginSection(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield serializableData : Lcom/blued/android/module/shortvideo/model/ShineDataModel$SerializableData;
    //   6: iload_1
    //   7: putfield b : Z
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void setCurrentCameraId(int paramInt) {
    this.serializableData.d = paramInt;
  }
  
  public void setFramePath(String paramString) {
    this.serializableData.g = paramString;
  }
  
  public void setMediaFile(String paramString) {
    this.mediaFile = new PLMediaFile(paramString);
    this.durationMs = this.mediaFile.getDurationMs();
    this.videoRotation = this.mediaFile.getVideoRotation();
    int i = this.videoRotation;
    if (i == 90 || i == 270) {
      this.videoWidth = this.mediaFile.getVideoHeight();
      this.videoHeigh = this.mediaFile.getVideoWidth();
      return;
    } 
    this.videoWidth = this.mediaFile.getVideoWidth();
    this.videoHeigh = this.mediaFile.getVideoHeight();
  }
  
  public void setRecordCompleted(boolean paramBoolean) {
    this.serializableData.c = paramBoolean;
  }
  
  public void setRecordSpeed(double paramDouble) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield serializableData : Lcom/blued/android/module/shortvideo/model/ShineDataModel$SerializableData;
    //   6: dload_1
    //   7: putfield a : D
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_3
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_3
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void setRecording(boolean paramBoolean) {
    this.isRecording = paramBoolean;
  }
  
  public static class SerializableData implements Serializable {
    public double a = 1.0D;
    
    public boolean b = false;
    
    public boolean c = false;
    
    public int d = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
    
    public int e;
    
    public long f;
    
    public String g;
    
    public void a() {
      this.a = 1.0D;
      this.b = false;
      this.d = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal();
      this.c = false;
      this.e = 0;
      this.f = 0L;
      this.g = null;
    }
    
    public void a(SerializableData param1SerializableData) {
      if (param1SerializableData != null) {
        this.a = param1SerializableData.a;
        this.b = param1SerializableData.b;
        this.d = param1SerializableData.d;
        this.c = param1SerializableData.c;
        this.e = param1SerializableData.e;
        this.f = param1SerializableData.f;
        this.g = param1SerializableData.g;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\ShineDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */