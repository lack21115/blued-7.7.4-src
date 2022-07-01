package com.blued.android.framework.utils.upload.qiniu;

import androidx.core.util.Pair;
import java.util.List;

public interface SenderListener {
  void a(String paramString, int paramInt);
  
  void a(String paramString, Pair<String, UploadModel> paramPair);
  
  void a(String paramString, boolean paramBoolean, List<Pair<String, String>> paramList);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\SenderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */