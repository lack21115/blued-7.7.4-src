package com.blued.android.module.shortvideo.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.model.VideoFrameInfo;
import com.blued.android.module.shortvideo.view.StvFileUtils;

public class VideoExtractFrameAsyncUtils {
  private int a = 0;
  
  private int b = 0;
  
  private volatile boolean c;
  
  public VideoExtractFrameAsyncUtils() {}
  
  public VideoExtractFrameAsyncUtils(int paramInt1, int paramInt2) {}
  
  private Bitmap a(Bitmap paramBitmap) {
    if (paramBitmap == null)
      return null; 
    if (this.a != 0 && this.b != 0) {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      float f = this.a * 2.0F / i;
      int k = this.b;
      Matrix matrix = new Matrix();
      matrix.postScale(f, f);
      Bitmap bitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, matrix, false);
      if (!paramBitmap.isRecycled())
        paramBitmap.recycle(); 
      return bitmap;
    } 
    return paramBitmap;
  }
  
  private String a(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, String paramString) {
    Bitmap bitmap = paramMediaMetadataRetriever.getFrameAtTime(1000L * paramLong, 2);
    if (bitmap != null) {
      bitmap = a(bitmap);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append("_");
      stringBuilder.append(paramLong);
      stringBuilder.append(".jpeg");
      paramString = StvFileUtils.a(bitmap, paramString, stringBuilder.toString());
      if (bitmap != null && !bitmap.isRecycled())
        bitmap.recycle(); 
      return paramString;
    } 
    return null;
  }
  
  private void a(int paramInt, String paramString, long paramLong, IGetFrameCallback paramIGetFrameCallback) {
    VideoFrameInfo videoFrameInfo = new VideoFrameInfo();
    videoFrameInfo.index = paramInt;
    videoFrameInfo.path = paramString;
    videoFrameInfo.time = paramLong;
    if (paramIGetFrameCallback != null)
      paramIGetFrameCallback.a(videoFrameInfo); 
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt, IGetFrameCallback paramIGetFrameCallback) {
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(paramString1);
    int j = paramInt - 1;
    long l = (paramLong2 - paramLong1) / j;
    int i;
    for (i = 0; i < paramInt; i++) {
      if (this.c) {
        Log.d("ExtractFrame", "-------ok-stop-stop--");
        mediaMetadataRetriever.release();
        break;
      } 
      long l1 = paramLong1 + i * l;
      if (i == j) {
        if (l > 1000L) {
          l1 = paramLong2 - 800L;
          a(i, a(mediaMetadataRetriever, l1, paramString2), l1, paramIGetFrameCallback);
        } else {
          a(i, a(mediaMetadataRetriever, paramLong2, paramString2), paramLong2, paramIGetFrameCallback);
        } 
      } else {
        a(i, a(mediaMetadataRetriever, l1, paramString2), l1, paramIGetFrameCallback);
      } 
    } 
    mediaMetadataRetriever.release();
  }
  
  public void a(String paramString1, String paramString2, long paramLong, IStvVideoFrameForTimeCallback paramIStvVideoFrameForTimeCallback) {
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    mediaMetadataRetriever.setDataSource(paramString1);
    paramString1 = a(mediaMetadataRetriever, paramLong, paramString2);
    VideoFrameInfo videoFrameInfo = new VideoFrameInfo();
    videoFrameInfo.index = 0;
    videoFrameInfo.path = paramString1;
    videoFrameInfo.time = paramLong;
    mediaMetadataRetriever.release();
    if (paramIStvVideoFrameForTimeCallback != null)
      paramIStvVideoFrameForTimeCallback.a(paramString1); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\VideoExtractFrameAsyncUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */