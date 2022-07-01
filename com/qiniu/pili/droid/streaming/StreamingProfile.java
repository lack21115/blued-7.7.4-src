package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import a.a.a.a.a.e.h;
import android.graphics.Point;
import com.qiniu.android.dns.DnsManager;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class StreamingProfile {
  public static final int AUDIO_QUALITY_HIGH1 = 20;
  
  public static final int AUDIO_QUALITY_HIGH2 = 21;
  
  public static final int AUDIO_QUALITY_LOW1 = 0;
  
  public static final int AUDIO_QUALITY_LOW2 = 1;
  
  public static final int AUDIO_QUALITY_MEDIUM1 = 10;
  
  public static final int AUDIO_QUALITY_MEDIUM2 = 11;
  
  public static final int AUDIO_TRACK_INDEX = 0;
  
  public static DnsManager E = h.f();
  
  public static int F = 3;
  
  public static final int[][] G = new int[][] { { 0, 0, 12, 153600, 3 }, { 0, 1, 15, 270336, 3 }, { 0, 2, 15, 358400, 3 }, { 1, 10, 30, 524288, 3 }, { 1, 11, 30, 819200, 3 }, { 1, 12, 30, 1024000, 3 }, { 2, 20, 30, 1228800, 3 }, { 2, 21, 30, 1536000, 3 }, { 2, 22, 30, 2048000, 3 } };
  
  public static final int[][] H = new int[][] { { 0, 0, 44100, 18432 }, { 0, 1, 44100, 24576 }, { 1, 10, 44100, 32768 }, { 1, 11, 44100, 49152 }, { 2, 20, 44100, 98304 }, { 2, 21, 44100, 131072 } };
  
  public static final int HIGH_LEVEL = 2;
  
  public static final VideoEncodingSize[] I = new VideoEncodingSize[] { new VideoEncodingSize(0, 424, 240), new VideoEncodingSize(1, 848, 480), new VideoEncodingSize(2, 960, 544), new VideoEncodingSize(3, 1280, 720), new VideoEncodingSize(4, 1920, 1088) };
  
  public static final VideoEncodingSize[] J = new VideoEncodingSize[] { new VideoEncodingSize(0, 320, 240), new VideoEncodingSize(1, 640, 480), new VideoEncodingSize(2, 720, 544), new VideoEncodingSize(3, 960, 720), new VideoEncodingSize(4, 1440, 1088) };
  
  public static final int LOW_LEVEL = 0;
  
  public static final int MEDIUM_LEVEL = 1;
  
  @Deprecated
  public static final int QUALITY_HIGH1 = 20;
  
  @Deprecated
  public static final int QUALITY_HIGH2 = 21;
  
  @Deprecated
  public static final int QUALITY_HIGH3 = 22;
  
  @Deprecated
  public static final int QUALITY_LOW1 = 0;
  
  @Deprecated
  public static final int QUALITY_LOW2 = 1;
  
  @Deprecated
  public static final int QUALITY_LOW3 = 2;
  
  @Deprecated
  public static final int QUALITY_MEDIUM1 = 10;
  
  @Deprecated
  public static final int QUALITY_MEDIUM2 = 11;
  
  @Deprecated
  public static final int QUALITY_MEDIUM3 = 12;
  
  public static final int VIDEO_ENCODING_HEIGHT_1088 = 4;
  
  public static final int VIDEO_ENCODING_HEIGHT_240 = 0;
  
  public static final int VIDEO_ENCODING_HEIGHT_480 = 1;
  
  public static final int VIDEO_ENCODING_HEIGHT_544 = 2;
  
  public static final int VIDEO_ENCODING_HEIGHT_720 = 3;
  
  @Deprecated
  public static final int VIDEO_ENCODING_SIZE_FHD = 4;
  
  @Deprecated
  public static final int VIDEO_ENCODING_SIZE_HD = 3;
  
  @Deprecated
  public static final int VIDEO_ENCODING_SIZE_QVGA = 0;
  
  @Deprecated
  public static final int VIDEO_ENCODING_SIZE_VGA = 1;
  
  public static final int VIDEO_QUALITY_HIGH1 = 20;
  
  public static final int VIDEO_QUALITY_HIGH2 = 21;
  
  public static final int VIDEO_QUALITY_HIGH3 = 22;
  
  public static final int VIDEO_QUALITY_LOW1 = 0;
  
  public static final int VIDEO_QUALITY_LOW2 = 1;
  
  public static final int VIDEO_QUALITY_LOW3 = 2;
  
  public static final int VIDEO_QUALITY_MEDIUM1 = 10;
  
  public static final int VIDEO_QUALITY_MEDIUM2 = 11;
  
  public static final int VIDEO_QUALITY_MEDIUM3 = 12;
  
  public static final int VIDEO_TRACK_INDEX = 1;
  
  public String A = null;
  
  public int B = -1;
  
  public float C = 5.0F;
  
  public YuvFilterMode D = YuvFilterMode.None;
  
  public int a = 0;
  
  public VideoEncodingSize b;
  
  public Point c;
  
  public f d;
  
  public int e = -1;
  
  public int f = -1;
  
  public int g = -1;
  
  public Stream h;
  
  public String i;
  
  public String j;
  
  public SendingBufferProfile k;
  
  public AVProfile l;
  
  public a m = a.b;
  
  public Map<Integer, Integer> n;
  
  public ENCODING_ORIENTATION o;
  
  public EncoderRCModes p = EncoderRCModes.QUALITY_PRIORITY;
  
  public StreamStatusConfig q;
  
  public volatile StreamStatus r = new StreamStatus();
  
  public boolean s = true;
  
  public boolean t = false;
  
  public BitrateAdjustMode u = BitrateAdjustMode.Disable;
  
  public int v = -1;
  
  public int w = -1;
  
  public String x;
  
  public String y;
  
  public Map<String, String> z = null;
  
  private AudioProfile getAudioProfileByQuality(int paramInt) {
    int[] arrayOfInt2 = a(paramInt, H);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null)
      arrayOfInt1 = H[0]; 
    return new AudioProfile(arrayOfInt1[2], arrayOfInt1[3]);
  }
  
  public static DnsManager getDnsManager() {
    return E;
  }
  
  private int getProfileLow(int paramInt) {
    return paramInt - getQualityLevelByQuality(paramInt) * 10;
  }
  
  private int getQualityLevelByQuality(int paramInt) {
    if (paramInt >= 0 && paramInt < 10)
      return 0; 
    if (paramInt >= 10 && paramInt < 20)
      return 1; 
    if (paramInt < 30)
      return 2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal quality:(");
    stringBuilder.append(paramInt);
    stringBuilder.append("), ");
    stringBuilder.append("the range of the quality is[");
    stringBuilder.append(20);
    stringBuilder.append(",");
    stringBuilder.append(29);
    stringBuilder.append("]");
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public static int getSendTimeout() {
    return F;
  }
  
  private Map<Integer, Integer> getSupportVideoQualitiesByProfile(int[][] paramArrayOfint) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (int i = 0; i < paramArrayOfint.length; i++) {
      int[] arrayOfInt = paramArrayOfint[i];
      if (arrayOfInt[0] == 0) {
        hashMap.put(Integer.valueOf(0), Integer.valueOf(arrayOfInt[1]));
      } else if (arrayOfInt[0] == 1) {
        hashMap.put(Integer.valueOf(1), Integer.valueOf(arrayOfInt[1]));
      } else if (arrayOfInt[0] == 2) {
        hashMap.put(Integer.valueOf(2), Integer.valueOf(arrayOfInt[1]));
      } else {
        throw new IllegalStateException("Never go here!");
      } 
    } 
    return (Map)hashMap;
  }
  
  private VideoProfile getVideoProfileByQuality(int paramInt) {
    int[] arrayOfInt2 = a(paramInt, G);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null)
      arrayOfInt1 = G[0]; 
    return new VideoProfile(arrayOfInt1[2], arrayOfInt1[3], arrayOfInt1[2] * arrayOfInt1[4]);
  }
  
  public final int a(int paramInt1, int paramInt2, int[][] paramArrayOfint) {
    if (e())
      return this.f; 
    int j = paramArrayOfint.length;
    int i;
    for (i = 0; i < j; i++) {
      if (paramArrayOfint[i][1] == paramInt2) {
        paramInt2 = i + paramInt1;
        paramInt1 = paramInt2;
        if (paramInt2 >= j) {
          e e = e.c;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("quality have been out of the MAX:");
          stringBuilder1.append(paramInt2);
          stringBuilder1.append(", choose the max quality!");
          e.d("StreamingProfile", stringBuilder1.toString());
          paramInt1 = j - 1;
        } 
        AVProfile aVProfile = this.l;
        if (aVProfile != null && aVProfile.mVideoProfile != null)
          this.l.mVideoProfile.reqBitrate = (getVideoProfileByQuality(paramArrayOfint[paramInt1][1])).reqBitrate; 
        return paramArrayOfint[paramInt1][1];
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal quality:");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final int a(AVProfile paramAVProfile, int[][] paramArrayOfint) {
    byte b = -1;
    int i = b;
    if (paramAVProfile != null) {
      i = b;
      if (paramArrayOfint != null) {
        String str;
        boolean bool;
        int j;
        if (paramArrayOfint != G && paramArrayOfint != H)
          return -1; 
        int[][] arrayOfInt = G;
        int k = 0;
        if (paramArrayOfint == arrayOfInt) {
          bool = true;
        } else {
          bool = false;
        } 
        if ((bool && paramAVProfile.mVideoProfile == null) || (!bool && paramAVProfile.mAudioProfile == null))
          return -1; 
        i = paramArrayOfint.length;
        if (bool) {
          j = paramAVProfile.mVideoProfile.reqBitrate;
        } else {
          j = paramAVProfile.mAudioProfile.reqBitrate;
        } 
        if (j <= paramArrayOfint[0][3]) {
          i = 0;
        } else {
          int m = i - 1;
          if (j >= paramArrayOfint[m][3]) {
            if (bool) {
              i = 22;
            } else {
              i = 21;
            } 
          } else {
            while (true) {
              i = b;
              if (k < m) {
                if (j >= paramArrayOfint[k][3] && j < paramArrayOfint[k + 1][3]) {
                  i = paramArrayOfint[k][1];
                  break;
                } 
                k++;
                continue;
              } 
              break;
            } 
          } 
        } 
        e e = e.c;
        StringBuilder stringBuilder = new StringBuilder();
        if (bool) {
          str = "target video quality = ";
        } else {
          str = "target audio quality = ";
        } 
        stringBuilder.append(str);
        stringBuilder.append(i);
        e.b("StreamingProfile", stringBuilder.toString());
      } 
    } 
    return i;
  }
  
  public final VideoEncodingSize a(VideoEncodingSize[] paramArrayOfVideoEncodingSize, int paramInt) {
    int j = paramArrayOfVideoEncodingSize.length;
    for (int i = 0; i < j; i++) {
      VideoEncodingSize videoEncodingSize = paramArrayOfVideoEncodingSize[i];
      if (videoEncodingSize.level == paramInt)
        return videoEncodingSize; 
    } 
    return null;
  }
  
  public boolean a() {
    return (this.u == BitrateAdjustMode.Auto);
  }
  
  public final boolean a(int paramInt) {
    if (paramInt >= 0 && paramInt < 30)
      return true; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal quality:(");
    stringBuilder.append(paramInt);
    stringBuilder.append("), ");
    stringBuilder.append("the range of the quality is[");
    stringBuilder.append(20);
    stringBuilder.append(",");
    stringBuilder.append(29);
    stringBuilder.append("]");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final boolean a(Stream paramStream) {
    StringBuilder stringBuilder2;
    String str2 = paramStream.getStreamId();
    String str3 = paramStream.getTitle();
    String str4 = paramStream.getPublishRtmpHost();
    String str5 = paramStream.getPublishKey();
    String str6 = paramStream.getPublishSecurity();
    String str1 = paramStream.getHubName();
    if (h.a(str2)) {
      if (h.a(str3)) {
        if (h.a(str4)) {
          if (h.a(str5)) {
            if (h.a(str6)) {
              if (h.a(str1))
                return true; 
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append("Illegal hub name:");
              stringBuilder2.append(str1);
              throw new IllegalArgumentException(stringBuilder2.toString());
            } 
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Illegal publish security:");
            stringBuilder5.append(str6);
            throw new IllegalArgumentException(stringBuilder5.toString());
          } 
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append("Illegal publish key:");
          stringBuilder4.append(str5);
          throw new IllegalArgumentException(stringBuilder4.toString());
        } 
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Illegal publish host:");
        stringBuilder3.append(str4);
        throw new IllegalArgumentException(stringBuilder3.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Illegal title:");
      stringBuilder.append(str3);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Illegal streamId:");
    stringBuilder1.append((String)stringBuilder2);
    throw new IllegalArgumentException(stringBuilder1.toString());
  }
  
  public final int[] a(int paramInt, int[][] paramArrayOfint) {
    if (paramInt == -1)
      return null; 
    int j = paramArrayOfint.length;
    for (int i = 0; i < j; i++) {
      int[] arrayOfInt = paramArrayOfint[i];
      if (arrayOfInt[1] == paramInt)
        return arrayOfInt; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot support the quality:");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final int b(int paramInt1, int paramInt2, int[][] paramArrayOfint) {
    int j = paramArrayOfint.length;
    int i;
    for (i = 0; i < j; i++) {
      if (paramArrayOfint[i][1] == paramInt2) {
        paramInt2 = i - paramInt1;
        paramInt1 = paramInt2;
        if (paramInt2 < 0)
          paramInt1 = 0; 
        AVProfile aVProfile = this.l;
        if (aVProfile != null && aVProfile.mVideoProfile != null)
          this.l.mVideoProfile.reqBitrate = (getVideoProfileByQuality(paramArrayOfint[paramInt1][1])).reqBitrate; 
        return paramArrayOfint[paramInt1][1];
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal quality:");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean b() {
    return (this.u != BitrateAdjustMode.Disable);
  }
  
  public boolean b(int paramInt) {
    return (paramInt >= 10240 && paramInt <= 10240000);
  }
  
  public boolean c() {
    return (this.o == ENCODING_ORIENTATION.LAND);
  }
  
  public boolean d() {
    return this.s;
  }
  
  public boolean e() {
    return (this.e >= this.f);
  }
  
  public boolean f() {
    return this.t;
  }
  
  public AudioProfile getAudioProfile() {
    AVProfile aVProfile = this.l;
    return (aVProfile != null && aVProfile.mAudioProfile != null) ? this.l.mAudioProfile : getAudioProfileByQuality(this.g);
  }
  
  public int getBestFromVideoQualityRank() {
    Map<Integer, Integer> map = this.n;
    int i = -1;
    int j = i;
    if (map != null) {
      Iterator<Map.Entry> iterator = map.entrySet().iterator();
      j = 0;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        e e1 = e.c;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("key:");
        stringBuilder1.append(((Integer)entry.getKey()).intValue());
        stringBuilder1.append(",value:");
        stringBuilder1.append(((Integer)entry.getValue()).intValue());
        e1.c("StreamingProfile", stringBuilder1.toString());
        if (((Integer)entry.getValue()).intValue() >= 2 && j <= ((Integer)entry.getValue()).intValue()) {
          j = ((Integer)entry.getValue()).intValue();
          i = ((Integer)entry.getKey()).intValue();
        } 
      } 
      e e = e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("best:");
      stringBuilder.append(i);
      e.c("StreamingProfile", stringBuilder.toString());
      j = i;
    } 
    return j;
  }
  
  public BitrateAdjustMode getBitrateAdjustMode() {
    return this.u;
  }
  
  public a getCPUWorkload() {
    return this.m;
  }
  
  public int getCurrentAudioQuality() {
    return this.g;
  }
  
  public int getCurrentVideoQuality() {
    return this.e;
  }
  
  public EncoderRCModes getEncoderRCMode() {
    return this.p;
  }
  
  public ENCODING_ORIENTATION getEncodingOrientation() {
    return this.o;
  }
  
  public int getEncodingSizeLevel() {
    return this.a;
  }
  
  public f getImageSize() {
    return this.d;
  }
  
  public String getLocalFileAbsolutePath() {
    return this.j;
  }
  
  public String getPictureStreamingFilePath() {
    return this.A;
  }
  
  public float getPictureStreamingFps() {
    return this.C;
  }
  
  public int getPictureStreamingResourceId() {
    return this.B;
  }
  
  public String getPublishHost() {
    return this.i;
  }
  
  public String getPublishUrl() {
    return this.x;
  }
  
  public Map<String, String> getRtmpOptions() {
    return this.z;
  }
  
  public SendingBufferProfile getSendingBufferInfo() {
    return this.k;
  }
  
  public Point getStartPoint() {
    return this.c;
  }
  
  public Stream getStream() {
    return this.h;
  }
  
  public String getStreamId() {
    Stream stream = this.h;
    return (stream != null) ? stream.getStreamId() : this.y;
  }
  
  public StreamStatus getStreamStatus() {
    return this.r;
  }
  
  public StreamStatusConfig getStreamStatusConfig() {
    if (this.q == null)
      this.q = new StreamStatusConfig(3); 
    return this.q;
  }
  
  public Map<Integer, Integer> getSupportAudioQualities() {
    return getSupportVideoQualitiesByProfile(H);
  }
  
  public Map<Integer, Integer> getSupportVideoQualities() {
    return getSupportVideoQualitiesByProfile(G);
  }
  
  public int getTargetVideoQuality() {
    return this.f;
  }
  
  public VideoEncodingSize getVideoEncodingSize(CameraStreamingSetting.PREVIEW_SIZE_RATIO paramPREVIEW_SIZE_RATIO) {
    VideoEncodingSize videoEncodingSize = this.b;
    if (videoEncodingSize != null)
      return videoEncodingSize; 
    if (paramPREVIEW_SIZE_RATIO == CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9)
      return a(I, this.a); 
    if (paramPREVIEW_SIZE_RATIO == CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_4_3)
      return a(J, this.a); 
    throw new IllegalArgumentException("Only support 16:9/4:3 ratio!");
  }
  
  public int getVideoMaxBitrate() {
    return this.w;
  }
  
  public int getVideoMinBitrate() {
    return this.v;
  }
  
  public VideoProfile getVideoProfile() {
    AVProfile aVProfile = this.l;
    return (aVProfile != null && aVProfile.mVideoProfile != null) ? this.l.mVideoProfile : getVideoProfileByQuality(this.e);
  }
  
  public Map<Integer, Integer> getVideoQualityRank() {
    return this.n;
  }
  
  public YuvFilterMode getYuvFilterMode() {
    return this.D;
  }
  
  public boolean improveVideoQuality(int paramInt) {
    int i = this.e;
    if (i == -1 || this.k == null) {
      e e1 = e.c;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Fail! mVideoQuality:");
      stringBuilder1.append(this.e);
      stringBuilder1.append(",mSendingBufferInfo:");
      stringBuilder1.append(this.k);
      e1.e("StreamingProfile", stringBuilder1.toString());
      return false;
    } 
    this.e = a(paramInt, i, G);
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("improve video quality:");
    stringBuilder.append(this.e);
    e.b("StreamingProfile", stringBuilder.toString());
    if (this.n.containsKey(Integer.valueOf(i)))
      this.n.put(Integer.valueOf(i), Integer.valueOf(((Integer)this.n.get(Integer.valueOf(i))).intValue() - 1)); 
    if (this.n.containsKey(Integer.valueOf(this.e))) {
      this.n.put(Integer.valueOf(this.e), Integer.valueOf(((Integer)this.n.get(Integer.valueOf(this.e))).intValue() + 1));
      return true;
    } 
    this.n.put(Integer.valueOf(this.e), Integer.valueOf(1));
    return true;
  }
  
  public boolean reduceVideoQuality(int paramInt) {
    int i = this.e;
    if (i == -1 || this.k == null) {
      e e1 = e.c;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Fail! mVideoQuality:");
      stringBuilder1.append(this.e);
      stringBuilder1.append(",mSendingBufferInfo:");
      stringBuilder1.append(this.k);
      e1.e("StreamingProfile", stringBuilder1.toString());
      return false;
    } 
    this.e = b(paramInt, i, G);
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("reduce video quality:");
    stringBuilder.append(this.e);
    e.b("StreamingProfile", stringBuilder.toString());
    if (this.n.containsKey(Integer.valueOf(i)))
      this.n.put(Integer.valueOf(i), Integer.valueOf(((Integer)this.n.get(Integer.valueOf(i))).intValue() - 1)); 
    if (this.n.containsKey(Integer.valueOf(this.e))) {
      this.n.put(Integer.valueOf(this.e), Integer.valueOf(((Integer)this.n.get(Integer.valueOf(this.e))).intValue() + 1));
      return true;
    } 
    this.n.put(Integer.valueOf(this.e), Integer.valueOf(1));
    return true;
  }
  
  public StreamingProfile setAVProfile(AVProfile paramAVProfile) {
    this.l = paramAVProfile;
    this.e = a(paramAVProfile, G);
    this.g = a(paramAVProfile, H);
    this.f = this.e;
    return this;
  }
  
  public StreamingProfile setAdaptiveBitrateAdjustThreshold(int paramInt1, int paramInt2) {
    if (paramInt1 < 1 || paramInt1 > 10 || paramInt2 < 1 || paramInt2 > 20) {
      e.c.e("StreamingProfile", "Out of range: tcpSendTimeMsSafeThreshold: 1~10, fpsDangerousThreshold: 1~20");
      return this;
    } 
    a.a.a.a.a.m.a.a(paramInt1, paramInt2);
    return this;
  }
  
  @Deprecated
  public StreamingProfile setAdaptiveBitrateEnable(boolean paramBoolean) {
    setBitrateAdjustMode(BitrateAdjustMode.Auto);
    return this;
  }
  
  public StreamingProfile setAudioQuality(int paramInt) {
    if (a(paramInt))
      this.g = paramInt; 
    return this;
  }
  
  public StreamingProfile setBitrateAdjustMode(BitrateAdjustMode paramBitrateAdjustMode) {
    this.u = paramBitrateAdjustMode;
    return this;
  }
  
  public StreamingProfile setDnsManager(DnsManager paramDnsManager) {
    E = paramDnsManager;
    return this;
  }
  
  public StreamingProfile setEncoderRCMode(EncoderRCModes paramEncoderRCModes) {
    this.p = paramEncoderRCModes;
    return this;
  }
  
  public StreamingProfile setEncodingOrientation(ENCODING_ORIENTATION paramENCODING_ORIENTATION) {
    this.o = paramENCODING_ORIENTATION;
    return this;
  }
  
  public StreamingProfile setEncodingSizeLevel(int paramInt) {
    if (paramInt >= 0 && paramInt <= 4) {
      if (this.b == null)
        this.a = paramInt; 
      return this;
    } 
    throw new IllegalArgumentException("Illegal encoding size level. The range is:[0,4]");
  }
  
  public StreamingProfile setFpsControllerEnable(boolean paramBoolean) {
    this.s = paramBoolean;
    return this;
  }
  
  public StreamingProfile setLocalFileAbsolutePath(String paramString) {
    this.j = paramString;
    return this;
  }
  
  public StreamingProfile setPictureStreamingFilePath(String paramString) {
    this.A = paramString;
    this.B = -1;
    return this;
  }
  
  public void setPictureStreamingFps(float paramFloat) {
    if (paramFloat <= 0.0F || paramFloat > 30.0F)
      e.d.e("StreamingProfile", "Error: fps range: 0-30"); 
    this.C = paramFloat;
  }
  
  public StreamingProfile setPictureStreamingResourceId(int paramInt) {
    this.B = paramInt;
    this.A = null;
    return this;
  }
  
  public StreamingProfile setPreferredVideoEncodingSize(int paramInt1, int paramInt2) {
    setPreferredVideoEncodingSize(paramInt1, paramInt2, null, 0, 0);
    return this;
  }
  
  public StreamingProfile setPreferredVideoEncodingSize(int paramInt1, int paramInt2, Point paramPoint, int paramInt3, int paramInt4) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPreferredVideoEncodingSize: width = ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", height = ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", image width = ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(", image height = ");
    stringBuilder.append(paramInt4);
    e.c("StreamingProfile", stringBuilder.toString());
    this.a = -1;
    this.b = new VideoEncodingSize(-1, paramInt1, paramInt2);
    this.c = paramPoint;
    if (paramInt3 > 0 && paramInt4 > 0)
      this.d = new f(paramInt3, paramInt4); 
    return this;
  }
  
  public StreamingProfile setPublishUrl(String paramString) throws URISyntaxException {
    this.x = paramString;
    URI uRI = new URI(paramString);
    if (uRI.getHost() != null) {
      this.h = null;
      this.i = uRI.getHost();
      paramString = uRI.getPath();
      this.y = paramString;
      if (h.a(paramString) && this.y.startsWith("/"))
        this.y = this.y.substring(1); 
      return this;
    } 
    throw new URISyntaxException(paramString, "no host");
  }
  
  @Deprecated
  public StreamingProfile setQuality(int paramInt) {
    if (a(paramInt)) {
      this.e = paramInt;
      this.f = paramInt;
    } 
    return this;
  }
  
  public StreamingProfile setQuicEnable(boolean paramBoolean) {
    this.t = paramBoolean;
    return this;
  }
  
  public StreamingProfile setRtmpOptions(String paramString1, String paramString2) {
    if (this.z == null)
      this.z = new HashMap<String, String>(); 
    this.z.put(paramString1, paramString2);
    return this;
  }
  
  public StreamingProfile setSendTimeoutInSecond(int paramInt) {
    if (paramInt >= 3) {
      F = paramInt;
      return this;
    } 
    throw new IllegalArgumentException("RTMPSendTimeout should be greater than 3 seconds!");
  }
  
  public StreamingProfile setSendingBufferProfile(SendingBufferProfile paramSendingBufferProfile) {
    this.k = paramSendingBufferProfile;
    this.n = new HashMap<Integer, Integer>();
    return this;
  }
  
  public StreamingProfile setStream(Stream paramStream) {
    a(paramStream);
    this.h = paramStream;
    this.i = paramStream.getPublishRtmpHost();
    return this;
  }
  
  public StreamingProfile setStreamStatusConfig(StreamStatusConfig paramStreamStatusConfig) {
    this.q = paramStreamStatusConfig;
    return this;
  }
  
  public StreamingProfile setVideoAdaptiveBitrateRange(int paramInt1, int paramInt2) {
    int[][] arrayOfInt = G;
    int i = arrayOfInt[0][3];
    int j = arrayOfInt[arrayOfInt.length - 1][3];
    if (paramInt1 >= i) {
      this.v = paramInt1;
    } else {
      e e1 = e.c;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("bitrate have been out of the MIN:");
      stringBuilder1.append(i);
      stringBuilder1.append("!");
      e1.d("StreamingProfile", stringBuilder1.toString());
    } 
    if (paramInt2 <= j) {
      this.w = paramInt2;
      return this;
    } 
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bitrate have been out of the MAX:");
    stringBuilder.append(j);
    stringBuilder.append("!");
    e.d("StreamingProfile", stringBuilder.toString());
    return this;
  }
  
  public StreamingProfile setVideoQuality(int paramInt) {
    return setQuality(paramInt);
  }
  
  public StreamingProfile setYuvFilterMode(YuvFilterMode paramYuvFilterMode) {
    this.D = paramYuvFilterMode;
    return this;
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      boolean bool1;
      VideoEncodingSize videoEncodingSize = this.b;
      if (videoEncodingSize != null) {
        jSONObject.put("PreferredVideoEncodingWidth", this.b.width);
        jSONObject.put("PreferredVideoEncodingHeight", this.b.height);
      } else {
        jSONObject.put("EncodingSizeLevel", this.a);
      } 
      jSONObject.put("QuicEnable", this.t);
      jSONObject.put("SendTimeout", F);
      jSONObject.put("EncoderRCMode", this.p);
      jSONObject.put("FpsController", this.s);
      BitrateAdjustMode bitrateAdjustMode1 = this.u;
      BitrateAdjustMode bitrateAdjustMode2 = BitrateAdjustMode.Disable;
      boolean bool2 = true;
      if (bitrateAdjustMode1 != bitrateAdjustMode2) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      jSONObject.put("AdjustBitrate", bool1);
      if (this.u == BitrateAdjustMode.Auto) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      jSONObject.put("AdaptiveBitrate", bool1);
      if (this.v > 0) {
        int i = this.w;
        if (i > 0) {
          jSONObject.put("VideoMinBitrate", this.v);
          jSONObject.put("VideoMaxBitrate", this.w);
        } 
      } 
      jSONObject.put("EncodingOrientation", this.o);
      jSONObject.put("VideoQuality", this.e);
      jSONObject.put("AudioQuality", this.g);
      if (this.l != null && this.l.mVideoProfile != null) {
        AudioProfile audioProfile = this.l.mAudioProfile;
        if (audioProfile != null) {
          jSONObject.put("VideoProfile", this.l.mVideoProfile);
          jSONObject.put("AudioProfile", this.l.mAudioProfile);
        } 
      } 
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
  
  public static class AVProfile {
    public StreamingProfile.AudioProfile mAudioProfile;
    
    public StreamingProfile.VideoProfile mVideoProfile;
    
    public AVProfile(StreamingProfile.VideoProfile param1VideoProfile, StreamingProfile.AudioProfile param1AudioProfile) {
      this.mVideoProfile = param1VideoProfile;
      this.mAudioProfile = param1AudioProfile;
    }
  }
  
  public static class AudioProfile {
    public int channelNumber;
    
    public int reqBitrate;
    
    public int sampleRate;
    
    public AudioProfile(int param1Int1, int param1Int2) {
      this.sampleRate = param1Int1;
      this.reqBitrate = param1Int2;
      this.channelNumber = 1;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AudioProfile: [");
      stringBuilder.append(this.sampleRate);
      stringBuilder.append("Hz,");
      stringBuilder.append(this.reqBitrate);
      stringBuilder.append("bps]");
      return stringBuilder.toString();
    }
  }
  
  public enum BitrateAdjustMode {
    Auto, Disable, Manual;
    
    static {
      BitrateAdjustMode bitrateAdjustMode = new BitrateAdjustMode("Disable", 2);
      Disable = bitrateAdjustMode;
      $VALUES = new BitrateAdjustMode[] { Auto, Manual, bitrateAdjustMode };
    }
  }
  
  public enum ENCODING_ORIENTATION {
    PORT, LAND;
    
    static {
      ENCODING_ORIENTATION eNCODING_ORIENTATION = new ENCODING_ORIENTATION("LAND", 1);
      LAND = eNCODING_ORIENTATION;
      $VALUES = new ENCODING_ORIENTATION[] { PORT, eNCODING_ORIENTATION };
    }
  }
  
  public enum EncoderRCModes {
    BITRATE_PRIORITY, QUALITY_PRIORITY;
    
    static {
      EncoderRCModes encoderRCModes = new EncoderRCModes("BITRATE_PRIORITY", 1);
      BITRATE_PRIORITY = encoderRCModes;
      $VALUES = new EncoderRCModes[] { QUALITY_PRIORITY, encoderRCModes };
    }
  }
  
  public enum H264Profile {
    BASELINE, HIGH, MAIN;
    
    static {
      H264Profile h264Profile = new H264Profile("HIGH", 2);
      HIGH = h264Profile;
      $VALUES = new H264Profile[] { BASELINE, MAIN, h264Profile };
    }
  }
  
  public static class SendingBufferProfile {
    public static final long DEFAULT_LOW_THRESHOLD_TIMEOUT = 60000L;
    
    public static final float DURATION_LIMIT_DEFAULT = 3.0F;
    
    public static final float DURATION_LIMIT_MAX = 5.0F;
    
    public static final float DURATION_LIMIT_MIN = 1.1F;
    
    public static final float HIGH_THRESHOLD_DEFAULT = 0.8F;
    
    public static final float HIGH_THRESHOLD_MAX = 1.0F;
    
    public static final float HIGH_THRESHOLD_MIN = 0.0F;
    
    public static final float LOW_THRESHOLD_DEFAULT = 0.2F;
    
    public static final float LOW_THRESHOLD_MAX = 1.0F;
    
    public static final float LOW_THRESHOLD_MIN = 0.0F;
    
    public static final long LOW_THRESHOLD_TIMEOUT_MIN = 10000L;
    
    public float mDurationLimit;
    
    public float mHighThreshold;
    
    public float mLowThreshold;
    
    public long mLowThresholdTimeout;
    
    public SendingBufferProfile(float param1Float1, float param1Float2, float param1Float3, long param1Long) {
      if (param1Float1 >= 0.0F && param1Float1 <= 1.0F) {
        double d1 = param1Float1;
        double d2 = param1Float2;
        if (d1 < d2 - 0.1D) {
          if (param1Float2 >= 0.0F && param1Float2 <= 1.0F && d2 > d1 + 0.1D) {
            if (param1Float3 >= 1.1F && param1Float3 <= 5.0F) {
              if (param1Long >= 10000L) {
                this.mLowThreshold = param1Float1;
                this.mHighThreshold = param1Float2;
                this.mDurationLimit = param1Float3;
                this.mLowThresholdTimeout = param1Long;
                return;
              } 
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append("Illegal timeout value:");
              stringBuilder3.append(param1Long);
              stringBuilder3.append(", should at least:");
              stringBuilder3.append(10000L);
              throw new IllegalArgumentException(stringBuilder3.toString());
            } 
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Illegal durationLimit value:");
            stringBuilder2.append(this.mDurationLimit);
            throw new IllegalArgumentException(stringBuilder2.toString());
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Illegal highThreshold value:");
          stringBuilder1.append(this.mHighThreshold);
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Illegal lowThreshold value:");
      stringBuilder.append(this.mLowThreshold);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public float getDurationLimit() {
      return this.mDurationLimit;
    }
    
    public float getHighThreshold() {
      return this.mHighThreshold;
    }
    
    public float getLowThreshold() {
      return this.mLowThreshold;
    }
    
    public long getLowThresholdTimeout() {
      return this.mLowThresholdTimeout;
    }
  }
  
  public static class Stream {
    public String hubName;
    
    public String publishKey;
    
    public String publishRtmpHost;
    
    public String publishSecurity;
    
    public String streamId;
    
    public String title;
    
    public Stream(JSONObject param1JSONObject) {
      try {
        this.streamId = param1JSONObject.getString("id");
        this.hubName = param1JSONObject.getString("hub");
        this.title = param1JSONObject.getString("title");
        this.publishKey = param1JSONObject.getString("publishKey");
        this.publishSecurity = param1JSONObject.getString("publishSecurity");
        this.publishRtmpHost = param1JSONObject.getJSONObject("hosts").getJSONObject("publish").getString("rtmp");
        return;
      } catch (JSONException jSONException) {
        throw new RuntimeException(jSONException.getMessage());
      } 
    }
    
    public String getHubName() {
      return this.hubName;
    }
    
    public String getPublishKey() {
      return this.publishKey;
    }
    
    public String getPublishRtmpHost() {
      return this.publishRtmpHost;
    }
    
    public String getPublishSecurity() {
      return this.publishSecurity;
    }
    
    public String getStreamId() {
      return this.streamId;
    }
    
    public String getTitle() {
      return this.title;
    }
  }
  
  public static class StreamStatus {
    public int audioBitrate;
    
    public int audioFps;
    
    public float meanTcpSendTimeInMilliseconds;
    
    public int totalAVBitrate;
    
    public int totalAVBitrateProduce;
    
    public int videoBitrate;
    
    public int videoFps;
  }
  
  public static class StreamStatusConfig {
    public static final int DEFAULT_INTERVAL_SECOND = 3;
    
    public static final int MAX_INTERVAL_SECOND = 30;
    
    public static final int MIN_INTERVAL_SECOND = 1;
    
    public int mIntervalMs = 3000;
    
    public StreamStatusConfig(int param1Int) {
      if (param1Int >= 1 && param1Int <= 30) {
        this.mIntervalMs = param1Int * 1000;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Bad Interval value:");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public int getIntervalMs() {
      return this.mIntervalMs;
    }
  }
  
  public static class VideoEncodingSize {
    public int height;
    
    public int level;
    
    public int width;
    
    public VideoEncodingSize(int param1Int1, int param1Int2, int param1Int3) {
      this.level = param1Int1;
      this.width = param1Int2;
      this.height = param1Int3;
    }
  }
  
  public static class VideoProfile {
    public boolean avcc;
    
    public StreamingProfile.H264Profile h264Profile;
    
    public int maxKeyFrameInterval;
    
    public int reqBitrate;
    
    public int reqFps;
    
    public VideoProfile(int param1Int1, int param1Int2) {
      this.reqFps = param1Int1;
      this.reqBitrate = param1Int2;
      this.maxKeyFrameInterval = param1Int1 * 3;
      this.h264Profile = StreamingProfile.H264Profile.BASELINE;
      this.avcc = true;
    }
    
    public VideoProfile(int param1Int1, int param1Int2, int param1Int3) {
      this.reqFps = param1Int1;
      this.reqBitrate = param1Int2;
      this.maxKeyFrameInterval = param1Int3;
      this.h264Profile = StreamingProfile.H264Profile.BASELINE;
      this.avcc = true;
    }
    
    public VideoProfile(int param1Int1, int param1Int2, int param1Int3, StreamingProfile.H264Profile param1H264Profile) {
      this.reqFps = param1Int1;
      this.reqBitrate = param1Int2;
      this.maxKeyFrameInterval = param1Int3;
      this.h264Profile = param1H264Profile;
      this.avcc = true;
    }
    
    public VideoProfile(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      this.reqFps = param1Int1;
      this.reqBitrate = param1Int2;
      this.maxKeyFrameInterval = param1Int3;
      this.h264Profile = StreamingProfile.H264Profile.BASELINE;
      this.avcc = param1Boolean;
    }
    
    public StreamingProfile.H264Profile getH264Profile() {
      return this.h264Profile;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("VideoProfile: [");
      stringBuilder.append(this.reqFps);
      stringBuilder.append("fps,");
      stringBuilder.append(this.reqBitrate);
      stringBuilder.append("bps, GOP:");
      stringBuilder.append(this.maxKeyFrameInterval);
      stringBuilder.append(",");
      stringBuilder.append(this.h264Profile);
      stringBuilder.append(",avcc=");
      stringBuilder.append(this.avcc);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  public enum YuvFilterMode {
    None, Bilinear, Box, Linear;
    
    static {
      Bilinear = new YuvFilterMode("Bilinear", 2);
      YuvFilterMode yuvFilterMode = new YuvFilterMode("Box", 3);
      Box = yuvFilterMode;
      $VALUES = new YuvFilterMode[] { None, Linear, Bilinear, yuvFilterMode };
    }
  }
  
  public enum a {
    a, b, c;
    
    static {
      a a1 = new a("LOW", 2);
      c = a1;
      d = new a[] { a, b, a1 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\StreamingProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */