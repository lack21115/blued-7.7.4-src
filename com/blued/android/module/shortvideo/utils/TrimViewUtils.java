package com.blued.android.module.shortvideo.utils;

import com.blued.android.module.shortvideo.model.TrimDataModel;

public class TrimViewUtils {
  public static int a(TrimDataModel paramTrimDataModel) {
    return (paramTrimDataModel != null) ? (int)(paramTrimDataModel.getPaddingSize() + (paramTrimDataModel.getLeftProgress() - paramTrimDataModel.getScrollMs()) * paramTrimDataModel.getAverageMsPx()) : 0;
  }
  
  public static int b(TrimDataModel paramTrimDataModel) {
    return (paramTrimDataModel != null) ? (int)((float)c(paramTrimDataModel) * paramTrimDataModel.getAverageMsPx() + paramTrimDataModel.getPaddingSize() - paramTrimDataModel.getSlidingBlockPxWidth()) : 0;
  }
  
  public static long c(TrimDataModel paramTrimDataModel) {
    return (paramTrimDataModel != null) ? (long)(paramTrimDataModel.getRightProgress() - paramTrimDataModel.getScrollMs() - paramTrimDataModel.getLeftProgress() - paramTrimDataModel.getScrollMs()) : 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\TrimViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */