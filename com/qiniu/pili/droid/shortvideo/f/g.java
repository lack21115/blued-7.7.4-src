package com.qiniu.pili.droid.shortvideo.f;

import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import java.io.IOException;

public class g {
  public static int a(MediaExtractor paramMediaExtractor, String paramString) {
    if (paramMediaExtractor == null || paramString == null) {
      e.w.e("MediaUtils", "find track error : extractor or mimeType can't be null!");
      return -1;
    } 
    int j = paramMediaExtractor.getTrackCount();
    for (int i = 0; i < j; i++) {
      MediaFormat mediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = mediaFormat.getString("mime");
      if (str.startsWith(paramString)) {
        e e = e.w;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Extractor found track ");
        stringBuilder.append(i);
        stringBuilder.append(" (");
        stringBuilder.append(str);
        stringBuilder.append("): ");
        stringBuilder.append(mediaFormat);
        e.c("MediaUtils", stringBuilder.toString());
        return i;
      } 
    } 
    return -1;
  }
  
  public static int a(PLVideoEncodeSetting.ProfileMode paramProfileMode) {
    int i = null.a[paramProfileMode.ordinal()];
    byte b = 2;
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return 1; 
        b = 8;
      } 
    } else {
      return 1;
    } 
    return b;
  }
  
  public static long a(Object paramObject) {
    paramObject = a(paramObject, 9);
    return (paramObject == null) ? 0L : Long.parseLong((String)paramObject);
  }
  
  public static MediaExtractor a(AssetFileDescriptor paramAssetFileDescriptor) {
    if (paramAssetFileDescriptor == null) {
      e.w.e("MediaUtils", "create media extractor failed, assetFileDescriptor can't be null !");
      return null;
    } 
    try {
      MediaExtractor mediaExtractor = new MediaExtractor();
      if (paramAssetFileDescriptor.getDeclaredLength() < 0L) {
        mediaExtractor.setDataSource(paramAssetFileDescriptor.getFileDescriptor());
      } else {
        mediaExtractor.setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getDeclaredLength());
      } 
      return mediaExtractor;
    } catch (IOException iOException) {
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create media extractor failed, setDataSource error : ");
      stringBuilder.append(iOException.getMessage());
      e.e("MediaUtils", stringBuilder.toString());
      return null;
    } 
  }
  
  public static MediaExtractor a(String paramString) {
    if (paramString == null) {
      e.w.e("MediaUtils", "create media extractor failed, path can't be null !");
      return null;
    } 
    try {
      MediaExtractor mediaExtractor = new MediaExtractor();
      mediaExtractor.setDataSource(paramString);
      return mediaExtractor;
    } catch (IOException iOException) {
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create media extractor failed, setDataSource error : ");
      stringBuilder.append(iOException.getMessage());
      e.e("MediaUtils", stringBuilder.toString());
      return null;
    } 
  }
  
  public static MediaFormat a(MediaExtractor paramMediaExtractor) {
    if (paramMediaExtractor == null) {
      e.w.e("MediaUtils", "select audio track failed, mediaExtractor can't be null !");
      return null;
    } 
    int i = a(paramMediaExtractor, "audio/");
    if (i >= 0) {
      paramMediaExtractor.selectTrack(i);
      MediaFormat mediaFormat = paramMediaExtractor.getTrackFormat(i);
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select audio track and get audio media format: ");
      stringBuilder.append(mediaFormat);
      e.c("MediaUtils", stringBuilder.toString());
      return mediaFormat;
    } 
    e.w.e("MediaUtils", "select audio track failed, can't find audio track!");
    return null;
  }
  
  public static PLVideoEncodeSetting.ProfileMode a(int paramInt) {
    PLVideoEncodeSetting.ProfileMode profileMode = PLVideoEncodeSetting.ProfileMode.BASELINE;
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 8) ? profileMode : PLVideoEncodeSetting.ProfileMode.HIGH) : PLVideoEncodeSetting.ProfileMode.MAIN) : PLVideoEncodeSetting.ProfileMode.BASELINE;
  }
  
  private static String a(Object paramObject, int paramInt) {
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    try {
      e e;
      if (paramObject instanceof String) {
        mediaMetadataRetriever.setDataSource((String)paramObject);
      } else {
        if (paramObject instanceof AssetFileDescriptor) {
          AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor)paramObject;
          mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
          return mediaMetadataRetriever.extractMetadata(paramInt);
        } 
        e = e.w;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class of path is invalid: ");
        stringBuilder.append(paramObject.getClass().getName());
        stringBuilder.append(", only accept String or AssetFileDescriptor");
        e.e("MediaUtils", stringBuilder.toString());
        return null;
      } 
      return e.extractMetadata(paramInt);
    } catch (Exception exception) {
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("path not exist: ");
      stringBuilder.append(paramObject);
      e.e("MediaUtils", stringBuilder.toString());
      return null;
    } 
  }
  
  public static int b(int paramInt) {
    if (paramInt % 16 != 0) {
      int i = (paramInt / 16 + 1) * 16;
      e e = e.h;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("num: ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" not multiple of 16, resize to: ");
      stringBuilder.append(i);
      e.d("MediaUtils", stringBuilder.toString());
      return i;
    } 
    return paramInt;
  }
  
  public static int b(MediaExtractor paramMediaExtractor, String paramString) {
    int j = paramMediaExtractor.getTrackCount();
    for (int i = 0; i < j; i++) {
      MediaFormat mediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = mediaFormat.getString("mime");
      if (str.startsWith(paramString)) {
        e e = e.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Extractor selected track ");
        stringBuilder.append(i);
        stringBuilder.append(" (");
        stringBuilder.append(str);
        stringBuilder.append("): ");
        stringBuilder.append(mediaFormat);
        e.c("MediaUtils", stringBuilder.toString());
        return i;
      } 
    } 
    return -1;
  }
  
  public static int b(Object paramObject) {
    paramObject = a(paramObject, 18);
    return (paramObject == null) ? 0 : Integer.parseInt((String)paramObject);
  }
  
  public static int c(Object paramObject) {
    paramObject = a(paramObject, 19);
    return (paramObject == null) ? 0 : Integer.parseInt((String)paramObject);
  }
  
  public static int d(Object paramObject) {
    paramObject = a(paramObject, 24);
    return (paramObject == null) ? 0 : Integer.parseInt((String)paramObject);
  }
  
  public static int e(Object paramObject) {
    paramObject = a(paramObject, 20);
    return (paramObject == null) ? 0 : Integer.parseInt((String)paramObject);
  }
  
  public static int f(Object paramObject) {
    paramObject = new f(paramObject.toString());
    int i = paramObject.j();
    paramObject.a();
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */