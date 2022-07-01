package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.graphics.Bitmap;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.k;
import java.util.List;

public class PLShortVideoComposer {
  private k mShortVideoComposerCore;
  
  public PLShortVideoComposer(Context paramContext) {
    this.mShortVideoComposerCore = new k(paramContext);
  }
  
  public void cancelComposeImages() {
    this.mShortVideoComposerCore.d();
  }
  
  public void cancelComposeItems() {
    this.mShortVideoComposerCore.c();
  }
  
  public void cancelComposeToGIF() {
    this.mShortVideoComposerCore.a();
  }
  
  public void cancelComposeVideos() {
    this.mShortVideoComposerCore.b();
  }
  
  public boolean composeImages(List<PLComposeItem> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_image, "operation_compose_image", paramList.size());
    return this.mShortVideoComposerCore.a(paramList, null, false, paramString, PLDisplayMode.FIT, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public boolean composeImages(List<PLComposeItem> paramList, String paramString1, boolean paramBoolean, String paramString2, PLDisplayMode paramPLDisplayMode, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_image, "operation_compose_image", paramList.size());
    return this.mShortVideoComposerCore.a(paramList, paramString1, paramBoolean, paramString2, paramPLDisplayMode, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public boolean composeImages(List<PLComposeItem> paramList, String paramString1, boolean paramBoolean, String paramString2, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_image, "operation_compose_image", paramList.size());
    return this.mShortVideoComposerCore.a(paramList, paramString1, paramBoolean, paramString2, PLDisplayMode.FIT, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public boolean composeItems(List<PLComposeItem> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_item, "operation_compose_item", paramList.size());
    return this.mShortVideoComposerCore.a(paramList, paramString, paramPLVideoEncodeSetting, null, 1.0F, 1.0F, paramPLVideoSaveListener);
  }
  
  public boolean composeItems(List<PLComposeItem> paramList, String paramString1, PLVideoEncodeSetting paramPLVideoEncodeSetting, String paramString2, float paramFloat1, float paramFloat2, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_item, "operation_compose_item", paramList.size());
    return this.mShortVideoComposerCore.a(paramList, paramString1, paramPLVideoEncodeSetting, paramString2, paramFloat1, paramFloat2, paramPLVideoSaveListener);
  }
  
  public void composeToGIF(List<Bitmap> paramList, int paramInt, boolean paramBoolean, String paramString, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_gif, "operation_compose_gif", paramList.size());
    this.mShortVideoComposerCore.a(paramList, paramInt, paramBoolean, paramString, paramPLVideoSaveListener);
  }
  
  public boolean composeVideoRanges(List<PLVideoRange> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_trim_video, "operation_compose_video", paramList.size());
    return this.mShortVideoComposerCore.b(paramList, paramString, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public boolean composeVideos(List<String> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_video, "operation_compose_video", paramList.size());
    return this.mShortVideoComposerCore.a(paramList, paramString, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public void extractVideoToGIF(String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString2, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_gif, "operation_compose_gif", 1);
    this.mShortVideoComposerCore.a(paramString1, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString2, paramPLVideoSaveListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoComposer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */