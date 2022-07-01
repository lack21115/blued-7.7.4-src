package com.tencent.ijk.media.player;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class IjkMediaMeta {
  public static final long AV_CH_BACK_CENTER = 256L;
  
  public static final long AV_CH_BACK_LEFT = 16L;
  
  public static final long AV_CH_BACK_RIGHT = 32L;
  
  public static final long AV_CH_FRONT_CENTER = 4L;
  
  public static final long AV_CH_FRONT_LEFT = 1L;
  
  public static final long AV_CH_FRONT_LEFT_OF_CENTER = 64L;
  
  public static final long AV_CH_FRONT_RIGHT = 2L;
  
  public static final long AV_CH_FRONT_RIGHT_OF_CENTER = 128L;
  
  public static final long AV_CH_LAYOUT_2POINT1 = 11L;
  
  public static final long AV_CH_LAYOUT_2_1 = 259L;
  
  public static final long AV_CH_LAYOUT_2_2 = 1539L;
  
  public static final long AV_CH_LAYOUT_3POINT1 = 15L;
  
  public static final long AV_CH_LAYOUT_4POINT0 = 263L;
  
  public static final long AV_CH_LAYOUT_4POINT1 = 271L;
  
  public static final long AV_CH_LAYOUT_5POINT0 = 1543L;
  
  public static final long AV_CH_LAYOUT_5POINT0_BACK = 55L;
  
  public static final long AV_CH_LAYOUT_5POINT1 = 1551L;
  
  public static final long AV_CH_LAYOUT_5POINT1_BACK = 63L;
  
  public static final long AV_CH_LAYOUT_6POINT0 = 1799L;
  
  public static final long AV_CH_LAYOUT_6POINT0_FRONT = 1731L;
  
  public static final long AV_CH_LAYOUT_6POINT1 = 1807L;
  
  public static final long AV_CH_LAYOUT_6POINT1_BACK = 319L;
  
  public static final long AV_CH_LAYOUT_6POINT1_FRONT = 1739L;
  
  public static final long AV_CH_LAYOUT_7POINT0 = 1591L;
  
  public static final long AV_CH_LAYOUT_7POINT0_FRONT = 1735L;
  
  public static final long AV_CH_LAYOUT_7POINT1 = 1599L;
  
  public static final long AV_CH_LAYOUT_7POINT1_WIDE = 1743L;
  
  public static final long AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255L;
  
  public static final long AV_CH_LAYOUT_HEXAGONAL = 311L;
  
  public static final long AV_CH_LAYOUT_MONO = 4L;
  
  public static final long AV_CH_LAYOUT_OCTAGONAL = 1847L;
  
  public static final long AV_CH_LAYOUT_QUAD = 51L;
  
  public static final long AV_CH_LAYOUT_STEREO = 3L;
  
  public static final long AV_CH_LAYOUT_STEREO_DOWNMIX = 1610612736L;
  
  public static final long AV_CH_LAYOUT_SURROUND = 7L;
  
  public static final long AV_CH_LOW_FREQUENCY = 8L;
  
  public static final long AV_CH_LOW_FREQUENCY_2 = 34359738368L;
  
  public static final long AV_CH_SIDE_LEFT = 512L;
  
  public static final long AV_CH_SIDE_RIGHT = 1024L;
  
  public static final long AV_CH_STEREO_LEFT = 536870912L;
  
  public static final long AV_CH_STEREO_RIGHT = 1073741824L;
  
  public static final long AV_CH_SURROUND_DIRECT_LEFT = 8589934592L;
  
  public static final long AV_CH_SURROUND_DIRECT_RIGHT = 17179869184L;
  
  public static final long AV_CH_TOP_BACK_CENTER = 65536L;
  
  public static final long AV_CH_TOP_BACK_LEFT = 32768L;
  
  public static final long AV_CH_TOP_BACK_RIGHT = 131072L;
  
  public static final long AV_CH_TOP_CENTER = 2048L;
  
  public static final long AV_CH_TOP_FRONT_CENTER = 8192L;
  
  public static final long AV_CH_TOP_FRONT_LEFT = 4096L;
  
  public static final long AV_CH_TOP_FRONT_RIGHT = 16384L;
  
  public static final long AV_CH_WIDE_LEFT = 2147483648L;
  
  public static final long AV_CH_WIDE_RIGHT = 4294967296L;
  
  public static final int FF_PROFILE_H264_BASELINE = 66;
  
  public static final int FF_PROFILE_H264_CAVLC_444 = 44;
  
  public static final int FF_PROFILE_H264_CONSTRAINED = 512;
  
  public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
  
  public static final int FF_PROFILE_H264_EXTENDED = 88;
  
  public static final int FF_PROFILE_H264_HIGH = 100;
  
  public static final int FF_PROFILE_H264_HIGH_10 = 110;
  
  public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
  
  public static final int FF_PROFILE_H264_HIGH_422 = 122;
  
  public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
  
  public static final int FF_PROFILE_H264_HIGH_444 = 144;
  
  public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
  
  public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
  
  public static final int FF_PROFILE_H264_INTRA = 2048;
  
  public static final int FF_PROFILE_H264_MAIN = 77;
  
  public static final String IJKM_KEY_AUDIO_STREAM = "audio";
  
  public static final String IJKM_KEY_BITRATE = "bitrate";
  
  public static final String IJKM_KEY_BITRATE_INDEX = "bitrate_index";
  
  public static final String IJKM_KEY_CHANNEL_LAYOUT = "channel_layout";
  
  public static final String IJKM_KEY_CODEC_LEVEL = "codec_level";
  
  public static final String IJKM_KEY_CODEC_LONG_NAME = "codec_long_name";
  
  public static final String IJKM_KEY_CODEC_NAME = "codec_name";
  
  public static final String IJKM_KEY_CODEC_PIXEL_FORMAT = "codec_pixel_format";
  
  public static final String IJKM_KEY_CODEC_PROFILE = "codec_profile";
  
  public static final String IJKM_KEY_CODEC_PROFILE_ID = "codec_profile_id";
  
  public static final String IJKM_KEY_DURATION_US = "duration_us";
  
  public static final String IJKM_KEY_FORMAT = "format";
  
  public static final String IJKM_KEY_FPS_DEN = "fps_den";
  
  public static final String IJKM_KEY_FPS_NUM = "fps_num";
  
  public static final String IJKM_KEY_HEIGHT = "height";
  
  public static final String IJKM_KEY_LANGUAGE = "language";
  
  public static final String IJKM_KEY_M3U8 = "m3u8";
  
  public static final String IJKM_KEY_PROGRAMS = "programs";
  
  public static final String IJKM_KEY_SAMPLE_RATE = "sample_rate";
  
  public static final String IJKM_KEY_SAR_DEN = "sar_den";
  
  public static final String IJKM_KEY_SAR_NUM = "sar_num";
  
  public static final String IJKM_KEY_START_US = "start_us";
  
  public static final String IJKM_KEY_STREAMS = "streams";
  
  public static final String IJKM_KEY_TBR_DEN = "tbr_den";
  
  public static final String IJKM_KEY_TBR_NUM = "tbr_num";
  
  public static final String IJKM_KEY_TIMEDTEXT_STREAM = "timedtext";
  
  public static final String IJKM_KEY_TYPE = "type";
  
  public static final String IJKM_KEY_VIDEO_STREAM = "video";
  
  public static final String IJKM_KEY_WIDTH = "width";
  
  public static final String IJKM_VAL_TYPE__AUDIO = "audio";
  
  public static final String IJKM_VAL_TYPE__TIMEDTEXT = "timedtext";
  
  public static final String IJKM_VAL_TYPE__UNKNOWN = "unknown";
  
  public static final String IJKM_VAL_TYPE__VIDEO = "video";
  
  public IjkStreamMeta mAudioStream;
  
  public long mBitrate;
  
  public ArrayList<IjkBitrateItem> mBitrateItems;
  
  public long mDurationUS;
  
  public String mFormat;
  
  public Bundle mMediaMeta;
  
  public long mStartUS;
  
  public final ArrayList<IjkStreamMeta> mStreams = new ArrayList<IjkStreamMeta>();
  
  public IjkStreamMeta mVideoStream;
  
  public static IjkMediaMeta parse(Bundle paramBundle) {
    if (paramBundle == null)
      return null; 
    IjkMediaMeta ijkMediaMeta = new IjkMediaMeta();
    ijkMediaMeta.mMediaMeta = paramBundle;
    ijkMediaMeta.mFormat = ijkMediaMeta.getString("format");
    ijkMediaMeta.mDurationUS = ijkMediaMeta.getLong("duration_us");
    ijkMediaMeta.mStartUS = ijkMediaMeta.getLong("start_us");
    ijkMediaMeta.mBitrate = ijkMediaMeta.getLong("bitrate");
    int i = -1;
    int j = ijkMediaMeta.getInt("video", -1);
    int k = ijkMediaMeta.getInt("audio", -1);
    ijkMediaMeta.getInt("timedtext", -1);
    ArrayList<Bundle> arrayList = ijkMediaMeta.getParcelableArrayList("streams");
    if (arrayList == null)
      return ijkMediaMeta; 
    ijkMediaMeta.mBitrateItems = new ArrayList<IjkBitrateItem>();
    for (Bundle bundle : arrayList) {
      i++;
      if (bundle == null)
        continue; 
      IjkStreamMeta ijkStreamMeta = new IjkStreamMeta(i);
      ijkStreamMeta.mMeta = bundle;
      ijkStreamMeta.mType = ijkStreamMeta.getString("type");
      ijkStreamMeta.mLanguage = ijkStreamMeta.getString("language");
      if (TextUtils.isEmpty(ijkStreamMeta.mType))
        continue; 
      ijkStreamMeta.mCodecName = ijkStreamMeta.getString("codec_name");
      ijkStreamMeta.mCodecProfile = ijkStreamMeta.getString("codec_profile");
      ijkStreamMeta.mCodecLongName = ijkStreamMeta.getString("codec_long_name");
      ijkStreamMeta.mBitrate = ijkStreamMeta.getInt("bitrate");
      if (ijkStreamMeta.mType.equalsIgnoreCase("video")) {
        ijkStreamMeta.mWidth = ijkStreamMeta.getInt("width");
        ijkStreamMeta.mHeight = ijkStreamMeta.getInt("height");
        ijkStreamMeta.mFpsNum = ijkStreamMeta.getInt("fps_num");
        ijkStreamMeta.mFpsDen = ijkStreamMeta.getInt("fps_den");
        ijkStreamMeta.mTbrNum = ijkStreamMeta.getInt("tbr_num");
        ijkStreamMeta.mTbrDen = ijkStreamMeta.getInt("tbr_den");
        ijkStreamMeta.mSarNum = ijkStreamMeta.getInt("sar_num");
        ijkStreamMeta.mSarDen = ijkStreamMeta.getInt("sar_den");
        if (j == i)
          ijkMediaMeta.mVideoStream = ijkStreamMeta; 
      } else if (ijkStreamMeta.mType.equalsIgnoreCase("audio")) {
        ijkStreamMeta.mSampleRate = ijkStreamMeta.getInt("sample_rate");
        ijkStreamMeta.mChannelLayout = ijkStreamMeta.getLong("channel_layout");
        if (k == i)
          ijkMediaMeta.mAudioStream = ijkStreamMeta; 
      } 
      ijkMediaMeta.mStreams.add(ijkStreamMeta);
    } 
    arrayList = ijkMediaMeta.getParcelableArrayList("programs");
    if (arrayList == null)
      return ijkMediaMeta; 
    for (Bundle bundle : arrayList) {
      if (bundle == null)
        continue; 
      IjkBitrateItem ijkBitrateItem = new IjkBitrateItem();
      ijkBitrateItem.index = Integer.parseInt(bundle.getString("bitrate_index", "0"));
      ijkBitrateItem.width = Integer.parseInt(bundle.getString("width", "0"));
      ijkBitrateItem.height = Integer.parseInt(bundle.getString("height", "0"));
      ijkBitrateItem.bitrate = Integer.parseInt(bundle.getString("bitrate", "0"));
      ijkMediaMeta.mBitrateItems.add(ijkBitrateItem);
    } 
    return ijkMediaMeta;
  }
  
  public String getDurationInline() {
    long l1 = (this.mDurationUS + 5000L) / 1000000L;
    long l2 = l1 / 60L;
    long l3 = l2 / 60L;
    return String.format(Locale.US, "%02d:%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l2 % 60L), Long.valueOf(l1 % 60L) });
  }
  
  public int getInt(String paramString) {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt) {
    paramString = getString(paramString);
    if (TextUtils.isEmpty(paramString))
      return paramInt; 
    try {
      return Integer.parseInt(paramString);
    } catch (NumberFormatException numberFormatException) {
      return paramInt;
    } 
  }
  
  public long getLong(String paramString) {
    return getLong(paramString, 0L);
  }
  
  public long getLong(String paramString, long paramLong) {
    paramString = getString(paramString);
    if (TextUtils.isEmpty(paramString))
      return paramLong; 
    try {
      return Long.parseLong(paramString);
    } catch (NumberFormatException numberFormatException) {
      return paramLong;
    } 
  }
  
  public Map<String, String> getMetaM3U8() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : this.mMediaMeta.keySet()) {
      if (str.startsWith("m3u8:"))
        hashMap.put(str, this.mMediaMeta.getString(str)); 
    } 
    return (Map)hashMap;
  }
  
  public ArrayList<Bundle> getParcelableArrayList(String paramString) {
    return this.mMediaMeta.getParcelableArrayList(paramString);
  }
  
  public String getString(String paramString) {
    return this.mMediaMeta.getString(paramString);
  }
  
  public static class IjkStreamMeta {
    public long mBitrate;
    
    public long mChannelLayout;
    
    public String mCodecLongName;
    
    public String mCodecName;
    
    public String mCodecProfile;
    
    public int mFpsDen;
    
    public int mFpsNum;
    
    public int mHeight;
    
    public final int mIndex;
    
    public String mLanguage;
    
    public Bundle mMeta;
    
    public int mSampleRate;
    
    public int mSarDen;
    
    public int mSarNum;
    
    public int mTbrDen;
    
    public int mTbrNum;
    
    public String mType;
    
    public int mWidth;
    
    public IjkStreamMeta(int param1Int) {
      this.mIndex = param1Int;
    }
    
    public String getBitrateInline() {
      long l = this.mBitrate;
      return (l <= 0L) ? "N/A" : ((l < 1000L) ? String.format(Locale.US, "%d bit/s", new Object[] { Long.valueOf(this.mBitrate) }) : String.format(Locale.US, "%d kb/s", new Object[] { Long.valueOf(this.mBitrate / 1000L) }));
    }
    
    public String getChannelLayoutInline() {
      long l = this.mChannelLayout;
      return (l <= 0L) ? "N/A" : ((l == 4L) ? "mono" : ((l == 3L) ? "stereo" : String.format(Locale.US, "%x", new Object[] { Long.valueOf(this.mChannelLayout) })));
    }
    
    public String getCodecLongNameInline() {
      return !TextUtils.isEmpty(this.mCodecLongName) ? this.mCodecLongName : (!TextUtils.isEmpty(this.mCodecName) ? this.mCodecName : "N/A");
    }
    
    public String getCodecShortNameInline() {
      return !TextUtils.isEmpty(this.mCodecName) ? this.mCodecName : "N/A";
    }
    
    public String getFpsInline() {
      int i = this.mFpsNum;
      if (i > 0) {
        int j = this.mFpsDen;
        if (j > 0)
          return String.valueOf(i / j); 
      } 
      return "N/A";
    }
    
    public int getInt(String param1String) {
      return getInt(param1String, 0);
    }
    
    public int getInt(String param1String, int param1Int) {
      param1String = getString(param1String);
      if (TextUtils.isEmpty(param1String))
        return param1Int; 
      try {
        return Integer.parseInt(param1String);
      } catch (NumberFormatException numberFormatException) {
        return param1Int;
      } 
    }
    
    public long getLong(String param1String) {
      return getLong(param1String, 0L);
    }
    
    public long getLong(String param1String, long param1Long) {
      param1String = getString(param1String);
      if (TextUtils.isEmpty(param1String))
        return param1Long; 
      try {
        return Long.parseLong(param1String);
      } catch (NumberFormatException numberFormatException) {
        return param1Long;
      } 
    }
    
    public String getResolutionInline() {
      return (this.mWidth <= 0 || this.mHeight <= 0) ? "N/A" : ((this.mSarNum <= 0 || this.mSarDen <= 0) ? String.format(Locale.US, "%d x %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }) : String.format(Locale.US, "%d x %d [SAR %d:%d]", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mSarNum), Integer.valueOf(this.mSarDen) }));
    }
    
    public String getSampleRateInline() {
      return (this.mSampleRate <= 0) ? "N/A" : String.format(Locale.US, "%d Hz", new Object[] { Integer.valueOf(this.mSampleRate) });
    }
    
    public String getString(String param1String) {
      return this.mMeta.getString(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\IjkMediaMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */