package com.blued.android.module.shortvideo.model;

import android.media.MediaExtractor;
import android.text.TextUtils;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import java.io.File;
import java.io.IOException;

public class EditDataModel {
  public static final String DEFAULT_MUTE_AUDIO_NAME = "silent_audio.mp3";
  
  public static final int SHOW_V_COVER = 3;
  
  public static final int SHOW_V_EDITCONTENT = 1;
  
  public static final int SHOW_V_VOLUME = 4;
  
  public static final int SLICE_COUNT = 7;
  
  public static final int VOLUME_MAX = 100;
  
  private PLMediaFile mediaFile;
  
  private PLMediaFile saveMediaFile;
  
  private SerializableData serializableData = new SerializableData();
  
  private void setEncodingH(int paramInt) {
    this.serializableData.j = paramInt;
  }
  
  private void setEncodingVideoBitrate(int paramInt) {
    this.serializableData.k = paramInt;
  }
  
  private void setEncodingW(int paramInt) {
    this.serializableData.i = paramInt;
  }
  
  private void setTranscode(boolean paramBoolean) {
    this.serializableData.p = paramBoolean;
  }
  
  public void calculateEncodingSize(int paramInt1, int paramInt2, int paramInt3) {
    float f2 = paramInt2;
    float f1 = 1.0F;
    float f3 = f2 * 1.0F;
    float f4 = paramInt3;
    float f5 = f3 / f4;
    paramInt3 = f5 cmp 1.0D;
    if (paramInt3 == 0) {
      setEncodingW(720);
      setEncodingH(720);
    } else if (paramInt3 > 0) {
      if (f3 / 1280.0F > f4 * 1.0F / 720.0F) {
        setEncodingW(1280);
        setEncodingH((int)(Math.ceil((1280.0F / f5) / 8.0D) * 8.0D));
      } else {
        setEncodingH(720);
        setEncodingW((int)(Math.ceil((f5 * 720.0F) / 8.0D) * 8.0D));
      } 
    } else if (f3 / 720.0F > f4 * 1.0F / 1280.0F) {
      setEncodingW(720);
      setEncodingH((int)(Math.ceil((720.0F / f5) / 8.0D) * 8.0D));
    } else {
      setEncodingH(1280);
      setEncodingW((int)(Math.ceil((f5 * 1280.0F) / 8.0D) * 8.0D));
    } 
    if (paramInt2 > getEncodingW())
      f1 = getEncodingW() * 1.0F / f2; 
    paramInt1 = (int)(paramInt1 * f1);
    if (paramInt1 >= 2800000) {
      setEncodingVideoBitrate(2800000);
      return;
    } 
    setEncodingVideoBitrate(paramInt1);
  }
  
  public void clear() {
    this.serializableData.clear();
    this.mediaFile = null;
  }
  
  public void copyModel(CommonModel paramCommonModel, SerializableData paramSerializableData) {
    if (this.serializableData == null)
      this.serializableData = new SerializableData(); 
    this.serializableData.a(paramCommonModel);
    this.serializableData.a(paramSerializableData);
    this.serializableData.setCurrentPage(4);
    setMediaFile(this.serializableData.getVideoPath());
  }
  
  public int getAudioChannels() {
    return this.mediaFile.getAudioChannels();
  }
  
  public int getAudioSampleRate() {
    return this.mediaFile.getAudioSampleRate();
  }
  
  public int getCoverCurrentLeftPosition() {
    return this.serializableData.g;
  }
  
  public int getCoverEndPosition() {
    return this.serializableData.h;
  }
  
  public String getCoverImgPath() {
    return this.serializableData.m;
  }
  
  public int getCoverStartPositon() {
    return this.serializableData.f;
  }
  
  public int getCoverVLenght() {
    return this.serializableData.e;
  }
  
  public int getCurrentBgVolume() {
    return this.serializableData.b;
  }
  
  public long getCurrentCoverTime() {
    return this.serializableData.c;
  }
  
  public int getCurrentFgVolume() {
    return this.serializableData.a;
  }
  
  public long getDurationMs() {
    return this.serializableData.q;
  }
  
  public int getEncodingH() {
    return this.serializableData.j;
  }
  
  public int getEncodingVideoBitrate() {
    return this.serializableData.k;
  }
  
  public int getEncodingW() {
    return this.serializableData.i;
  }
  
  public String getFilepath() {
    return this.mediaFile.getFilepath();
  }
  
  public String getFirstImgPath() {
    return this.serializableData.n;
  }
  
  public PLMediaFile getMediaFile() {
    return this.mediaFile;
  }
  
  public String getNeedDeleteVideoPath() {
    return SerializableData.j(this.serializableData);
  }
  
  public long getSaveDurationMs() {
    return SerializableData.h(this.serializableData);
  }
  
  public int getSaveVideoHeight() {
    return SerializableData.g(this.serializableData);
  }
  
  public String getSaveVideoPath() {
    return this.serializableData.o;
  }
  
  public int getSaveVideoWidth() {
    return SerializableData.f(this.serializableData);
  }
  
  public SerializableData getSerializableData() {
    return this.serializableData;
  }
  
  public int getVideoBitrate() {
    return this.mediaFile.getVideoBitrate();
  }
  
  public int getVideoFrameRate() {
    return this.mediaFile.getVideoFrameRate();
  }
  
  public int getVideoHeight() {
    return SerializableData.d(this.serializableData);
  }
  
  public int getVideoIFrameInterval() {
    return this.mediaFile.getVideoIFrameInterval();
  }
  
  public int getVideoRotation() {
    return this.mediaFile.getVideoRotation();
  }
  
  public long getVideoSize() {
    return SerializableData.i(this.serializableData);
  }
  
  public int getVideoWidth() {
    return SerializableData.c(this.serializableData);
  }
  
  public boolean isAutoDelete() {
    return this.serializableData.l;
  }
  
  public boolean isNeedTranscodeAgain(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (!(new File(paramString)).exists())
        return false; 
      this.mediaFile = new PLMediaFile(paramString);
      PLMediaFile pLMediaFile = this.mediaFile;
      if (pLMediaFile == null)
        return false; 
      this.serializableData.q = pLMediaFile.getDurationMs();
      SerializableData.a(this.serializableData, this.mediaFile.getVideoRotation());
      SerializableData.b(this.serializableData, this.mediaFile.getVideoWidth());
      SerializableData.c(this.serializableData, this.mediaFile.getVideoHeight());
      if (SerializableData.c(this.serializableData) > 720 || SerializableData.d(this.serializableData) > 1280) {
        setTranscode(true);
        return true;
      } 
      MediaExtractor mediaExtractor = new MediaExtractor();
      try {
        mediaExtractor.setDataSource(paramString);
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
          paramString = mediaExtractor.getTrackFormat(i).getString("mime");
          if (paramString.startsWith("video/")) {
            if (paramString.equals("video/avc")) {
              setTranscode(false);
              return false;
            } 
            setTranscode(true);
            return true;
          } 
        } 
        setTranscode(false);
        return false;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        setTranscode(false);
        return false;
      } 
    } 
    return false;
  }
  
  public boolean isTranscode() {
    return this.serializableData.p;
  }
  
  public void release() {
    this.mediaFile.release();
  }
  
  public void setAutoDelete(boolean paramBoolean) {
    this.serializableData.l = paramBoolean;
  }
  
  public void setCoverCurrentLeftPosition(int paramInt) {
    this.serializableData.g = paramInt;
  }
  
  public void setCoverEndPosition(int paramInt) {
    this.serializableData.h = paramInt;
  }
  
  public void setCoverImgPath(String paramString) {
    this.serializableData.m = paramString;
  }
  
  public void setCoverStartPositon(int paramInt) {
    this.serializableData.f = paramInt;
  }
  
  public void setCoverVLenght(int paramInt) {
    this.serializableData.e = paramInt;
  }
  
  public void setCurrentBgVolume(int paramInt) {
    this.serializableData.b = paramInt;
  }
  
  public void setCurrentCoverTime(long paramLong) {
    this.serializableData.c = paramLong;
  }
  
  public void setCurrentFgVolume(int paramInt) {
    this.serializableData.a = paramInt;
  }
  
  public void setFirstImgPath(String paramString) {
    this.serializableData.n = paramString;
  }
  
  public void setMediaFile(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      if (!(new File(paramString)).exists())
        return; 
      this.mediaFile = new PLMediaFile(paramString);
      this.serializableData.q = this.mediaFile.getDurationMs();
      SerializableData.a(this.serializableData, this.mediaFile.getVideoRotation());
      if (SerializableData.b(this.serializableData) == 90 || SerializableData.b(this.serializableData) == 270) {
        SerializableData.b(this.serializableData, this.mediaFile.getVideoHeight());
        SerializableData.c(this.serializableData, this.mediaFile.getVideoWidth());
      } else {
        SerializableData.b(this.serializableData, this.mediaFile.getVideoWidth());
        SerializableData.c(this.serializableData, this.mediaFile.getVideoHeight());
      } 
      if (SerializableData.c(this.serializableData) > 720 || SerializableData.d(this.serializableData) > 1280 || this.mediaFile.getVideoBitrate() > 2800000) {
        setTranscode(true);
        return;
      } 
      setTranscode(false);
      return;
    } 
  }
  
  public void setNeedDeleteVideoPath(String paramString) {
    SerializableData.a(this.serializableData, paramString);
  }
  
  public void setSaveVideoPath(String paramString) {
    this.serializableData.o = paramString;
    this.saveMediaFile = new PLMediaFile(paramString);
    SerializableData.a(this.serializableData, this.saveMediaFile.getDurationMs());
    File file = new File(paramString);
    if (file.exists() && file.isFile())
      SerializableData.b(this.serializableData, Math.round(file.length() * 1.0D / 1024.0D)); 
    SerializableData.d(this.serializableData, this.saveMediaFile.getVideoRotation());
    if (SerializableData.e(this.serializableData) == 90 || SerializableData.e(this.serializableData) == 270) {
      SerializableData.e(this.serializableData, this.saveMediaFile.getVideoHeight());
      SerializableData.f(this.serializableData, this.saveMediaFile.getVideoWidth());
      return;
    } 
    SerializableData.e(this.serializableData, this.saveMediaFile.getVideoWidth());
    SerializableData.f(this.serializableData, this.saveMediaFile.getVideoHeight());
  }
  
  public void setScreenWidth(int paramInt) {
    this.serializableData.d = paramInt;
  }
  
  public static class SerializableData extends CommonModel {
    public int a = 100;
    
    public int b = 100;
    
    public long c = -1L;
    
    public int d;
    
    public int e;
    
    public int f;
    
    public int g;
    
    public int h;
    
    public int i;
    
    public int j;
    
    public int k;
    
    public boolean l = false;
    
    public String m;
    
    public String n;
    
    public String o;
    
    public boolean p = true;
    
    public long q;
    
    private int r;
    
    private int s;
    
    private int t;
    
    private long u;
    
    private long v;
    
    private int w;
    
    private int x;
    
    private int y;
    
    private String z;
    
    public void a(CommonModel param1CommonModel) {
      if (param1CommonModel != null)
        copyModel(param1CommonModel, true); 
    }
    
    public void a(SerializableData param1SerializableData) {
      if (param1SerializableData != null) {
        copyModel(param1SerializableData);
        this.a = param1SerializableData.a;
        this.b = param1SerializableData.b;
        this.c = param1SerializableData.c;
        this.d = param1SerializableData.d;
        this.e = param1SerializableData.e;
        this.f = param1SerializableData.f;
        this.h = param1SerializableData.h;
        this.g = param1SerializableData.g;
        this.l = param1SerializableData.l;
        this.m = param1SerializableData.m;
        this.n = param1SerializableData.n;
        this.o = param1SerializableData.o;
        this.i = param1SerializableData.i;
        this.j = param1SerializableData.j;
        this.k = param1SerializableData.k;
        this.p = param1SerializableData.p;
        this.q = param1SerializableData.q;
        this.r = param1SerializableData.r;
        this.s = param1SerializableData.s;
        this.t = param1SerializableData.t;
        this.u = param1SerializableData.u;
        this.v = param1SerializableData.v;
        this.w = param1SerializableData.w;
        this.x = param1SerializableData.x;
        this.y = param1SerializableData.y;
        this.z = param1SerializableData.z;
      } 
    }
    
    public boolean a() {
      return !(this.c == -1L);
    }
    
    public void clear() {
      super.clear();
      this.a = 100;
      this.b = 100;
      this.c = -1L;
      this.e = 0;
      this.f = 0;
      this.h = 0;
      this.g = 0;
      this.i = 0;
      this.j = 0;
      this.k = 0;
      this.l = false;
      this.o = null;
      this.m = null;
      this.n = null;
      this.p = true;
      this.q = 0L;
      this.r = 0;
      this.s = 0;
      this.t = 0;
      this.v = 0L;
      this.u = 0L;
      this.w = 0;
      this.x = 0;
      this.y = 0;
      this.z = null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\EditDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */