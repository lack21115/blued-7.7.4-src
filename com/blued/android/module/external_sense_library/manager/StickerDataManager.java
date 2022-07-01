package com.blued.android.module.external_sense_library.manager;

import android.text.TextUtils;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.contract.IStickerInitListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.external_sense_library.sticker.StickerLoader;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.SenseLibThreadPoolHelper;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StickerDataManager {
  private static final String TAG;
  
  private static StickerLoader stickerLoader;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_");
    stringBuilder.append(StickerDataManager.class.getSimpleName());
    TAG = stringBuilder.toString();
  }
  
  public static void clearData() {
    stickerLoader = null;
  }
  
  private static void getStickerPath(String paramString1, String paramString2) {
    getStickerPath(paramString1, paramString2, null);
  }
  
  public static void getStickerPath(String paramString1, String paramString2, IGetStickerListener paramIGetStickerListener) {
    if (stickerLoader == null)
      stickerLoader = (new StickerLoader.Builder()).a(); 
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      LogUtils.d(TAG, "name or path null", new Object[0]);
      if (paramIGetStickerListener != null)
        paramIGetStickerListener.onFailed(ErrorCode.PlayStickerCode.a, "name or path null"); 
      return;
    } 
    if (stickerLoader.a(paramString1)) {
      if (paramIGetStickerListener != null) {
        paramIGetStickerListener.onSuccess(paramString1, StickerConfig.a(paramString1));
        return;
      } 
    } else {
      stickerLoader.a(paramString1, paramString2, paramIGetStickerListener, null);
    } 
  }
  
  public static Map<String, Integer> getStickerStateMap() {
    StickerLoader stickerLoader = stickerLoader;
    if (stickerLoader != null)
      return stickerLoader.a(); 
    LogUtils.d(TAG, "StickerDataManager init no finish", new Object[0]);
    return new HashMap<String, Integer>();
  }
  
  public static void init(List<StickerBaseModel> paramList, IStickerInitListener paramIStickerInitListener) {
    init(paramList, true, paramIStickerInitListener);
  }
  
  public static void init(final List<StickerBaseModel> stickerList, boolean paramBoolean, final IStickerInitListener listener) {
    if (stickerLoader == null)
      stickerLoader = (new StickerLoader.Builder()).a(); 
    stickerLoader.a(stickerList);
    if (paramBoolean)
      SenseLibThreadPoolHelper.a().a((Runnable)new SenseLibThreadPoolHelper.SenseLibThread(new Runnable() {
              public void run() {
                List list = stickerList;
                if (list == null || list.isEmpty()) {
                  LogUtils.d(StickerDataManager.TAG, "filterList is null", new Object[0]);
                  return;
                } 
                for (StickerBaseModel stickerBaseModel : stickerList) {
                  if (stickerBaseModel != null && StickerDataManager.stickerLoader != null && !StickerDataManager.stickerLoader.a(stickerBaseModel.name))
                    StickerDataManager.getStickerPath(stickerBaseModel.name, stickerBaseModel.path); 
                } 
                LogUtils.c(StickerDataManager.TAG, "StickerDataManager init finish", new Object[0]);
                IStickerInitListener iStickerInitListener = listener;
                if (iStickerInitListener != null)
                  iStickerInitListener.onFinish(StickerDataManager.getStickerStateMap()); 
              }
            })); 
  }
  
  public static boolean isDownLoad(String paramString) {
    if (stickerLoader == null)
      stickerLoader = (new StickerLoader.Builder()).a(); 
    return stickerLoader.a(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\manager\StickerDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */