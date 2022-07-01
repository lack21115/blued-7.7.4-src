package com.blued.android.module.external_sense_library.contract;

import com.blued.android.module.external_sense_library.model.ErrorCode;

public interface IGetStickerListener {
  void onFailed(ErrorCode.PlayStickerCode paramPlayStickerCode, String paramString);
  
  void onSuccess(String paramString1, String paramString2);
  
  void onSyncStart();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\contract\IGetStickerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */