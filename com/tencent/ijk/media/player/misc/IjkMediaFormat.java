package com.tencent.ijk.media.player.misc;

import android.text.TextUtils;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class IjkMediaFormat implements IMediaFormat {
  public static final String CODEC_NAME_H264 = "h264";
  
  public static final String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
  
  public static final String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
  
  public static final String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
  
  public static final String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
  
  public static final String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
  
  public static final String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
  
  public static final String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
  
  public static final String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
  
  public static final String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
  
  private static final Map<String, Formatter> sFormatterMap = new HashMap<String, Formatter>();
  
  public final IjkMediaMeta.IjkStreamMeta mMediaFormat;
  
  public IjkMediaFormat(IjkMediaMeta.IjkStreamMeta paramIjkStreamMeta) {
    sFormatterMap.put("ijk-codec-long-name-ui", new Formatter() {
          public String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            return IjkMediaFormat.this.mMediaFormat.getString("codec_long_name");
          }
        });
    sFormatterMap.put("ijk-codec-name-ui", new Formatter() {
          public String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            return IjkMediaFormat.this.mMediaFormat.getString("codec_name");
          }
        });
    sFormatterMap.put("ijk-bit-rate-ui", new Formatter() {
          protected String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            int i = param1IjkMediaFormat.getInteger("bitrate");
            return (i <= 0) ? null : ((i < 1000) ? String.format(Locale.US, "%d bit/s", new Object[] { Integer.valueOf(i) }) : String.format(Locale.US, "%d kb/s", new Object[] { Integer.valueOf(i / 1000) }));
          }
        });
    sFormatterMap.put("ijk-profile-level-ui", new Formatter() {
          protected String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            switch (param1IjkMediaFormat.getInteger("codec_profile_id")) {
              default:
                return null;
              case 2292:
                str = "High 4:4:4 Intra";
                break;
              case 2170:
                str = "High 4:2:2 Intra";
                break;
              case 2158:
                str = "High 10 Intra";
                break;
              case 578:
                str = "Constrained Baseline";
                break;
              case 244:
                str = "High 4:4:4 Predictive";
                break;
              case 144:
                str = "High 4:4:4";
                break;
              case 122:
                str = "High 4:2:2";
                break;
              case 110:
                str = "High 10";
                break;
              case 100:
                str = "High";
                break;
              case 88:
                str = "Extended";
                break;
              case 77:
                str = "Main";
                break;
              case 66:
                str = "Baseline";
                break;
              case 44:
                str = "CAVLC 4:4:4";
                break;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            String str = param1IjkMediaFormat.getString("codec_name");
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("h264")) {
              int i = param1IjkMediaFormat.getInteger("codec_level");
              if (i < 10)
                return stringBuilder.toString(); 
              stringBuilder.append(" Profile Level ");
              stringBuilder.append(i / 10 % 10);
              i %= 10;
              if (i != 0) {
                stringBuilder.append(".");
                stringBuilder.append(i);
              } 
            } 
            return stringBuilder.toString();
          }
        });
    sFormatterMap.put("ijk-pixel-format-ui", new Formatter() {
          protected String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            return param1IjkMediaFormat.getString("codec_pixel_format");
          }
        });
    sFormatterMap.put("ijk-resolution-ui", new Formatter() {
          protected String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            int i = param1IjkMediaFormat.getInteger("width");
            int j = param1IjkMediaFormat.getInteger("height");
            int k = param1IjkMediaFormat.getInteger("sar_num");
            int m = param1IjkMediaFormat.getInteger("sar_den");
            return (i <= 0 || j <= 0) ? null : ((k <= 0 || m <= 0) ? String.format(Locale.US, "%d x %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }) : String.format(Locale.US, "%d x %d [SAR %d:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
          }
        });
    sFormatterMap.put("ijk-frame-rate-ui", new Formatter() {
          protected String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            int i = param1IjkMediaFormat.getInteger("fps_num");
            int j = param1IjkMediaFormat.getInteger("fps_den");
            return (i <= 0 || j <= 0) ? null : String.valueOf(i / j);
          }
        });
    sFormatterMap.put("ijk-sample-rate-ui", new Formatter() {
          protected String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            int i = param1IjkMediaFormat.getInteger("sample_rate");
            return (i <= 0) ? null : String.format(Locale.US, "%d Hz", new Object[] { Integer.valueOf(i) });
          }
        });
    sFormatterMap.put("ijk-channel-ui", new Formatter() {
          protected String doFormat(IjkMediaFormat param1IjkMediaFormat) {
            int i = param1IjkMediaFormat.getInteger("channel_layout");
            if (i <= 0)
              return null; 
            long l = i;
            return (l == 4L) ? "mono" : ((l == 3L) ? "stereo" : String.format(Locale.US, "%x", new Object[] { Integer.valueOf(i) }));
          }
        });
    this.mMediaFormat = paramIjkStreamMeta;
  }
  
  public int getInteger(String paramString) {
    IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mMediaFormat;
    return (ijkStreamMeta == null) ? 0 : ijkStreamMeta.getInt(paramString);
  }
  
  public String getString(String paramString) {
    return (this.mMediaFormat == null) ? null : (sFormatterMap.containsKey(paramString) ? ((Formatter)sFormatterMap.get(paramString)).format(this) : this.mMediaFormat.getString(paramString));
  }
  
  static abstract class Formatter {
    private Formatter() {}
    
    protected abstract String doFormat(IjkMediaFormat param1IjkMediaFormat);
    
    public String format(IjkMediaFormat param1IjkMediaFormat) {
      String str2 = doFormat(param1IjkMediaFormat);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = getDefaultString(); 
      return str1;
    }
    
    protected String getDefaultString() {
      return "N/A";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\misc\IjkMediaFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */