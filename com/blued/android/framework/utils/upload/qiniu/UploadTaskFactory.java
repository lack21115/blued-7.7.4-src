package com.blued.android.framework.utils.upload.qiniu;

import androidx.core.util.Pair;
import java.util.List;

public class UploadTaskFactory {
  public static IUploadTask a(String paramString1, String paramString2, String paramString3, Pair<String, String> paramPair1, Pair<String, String> paramPair2, SenderListener paramSenderListener) {
    return new UploadVideoTask(paramString1, paramString2, paramString3, paramPair1, paramPair2, paramSenderListener);
  }
  
  public static IUploadTask a(String paramString1, List<Pair<String, String>> paramList, String paramString2, SenderListener paramSenderListener) {
    return new UploadAudioTask(paramString1, paramList, paramString2, paramSenderListener);
  }
  
  public static IUploadTask a(String paramString1, List<Pair<String, String>> paramList, String paramString2, boolean paramBoolean, SenderListener paramSenderListener) {
    return new UploadImageTask(paramString1, paramList, paramString2, paramBoolean, paramSenderListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadTaskFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */