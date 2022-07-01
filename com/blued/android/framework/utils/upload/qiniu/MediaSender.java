package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

public class MediaSender {
  public static final String a = MediaSender.class.getSimpleName();
  
  private static String a() {
    // Byte code:
    //   0: ldc com/blued/android/framework/utils/upload/qiniu/MediaSender
    //   2: monitorenter
    //   3: invokestatic currentTimeMillis : ()J
    //   6: lstore_0
    //   7: ldc com/blued/android/framework/utils/upload/qiniu/MediaSender
    //   9: monitorexit
    //   10: lload_0
    //   11: invokestatic valueOf : (J)Ljava/lang/String;
    //   14: areturn
    //   15: astore_2
    //   16: ldc com/blued/android/framework/utils/upload/qiniu/MediaSender
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	15	finally
  }
  
  public static String a(String paramString, Pair<String, String> paramPair, SenderListener paramSenderListener) {
    return a((String)null, paramString, (Pair<String, String>)null, paramPair, paramSenderListener);
  }
  
  public static String a(String paramString1, String paramString2, Pair<String, String> paramPair1, Pair<String, String> paramPair2, SenderListener paramSenderListener) {
    boolean bool;
    String str = a();
    ArrayList<Pair<String, String>> arrayList = new ArrayList();
    if (!NetworkUtils.b() || TextUtils.isEmpty(paramString2) || paramPair2 == null || (AppInfo.p() && paramPair1 != null && !TextUtils.isEmpty((CharSequence)paramPair1.first) && TextUtils.isEmpty(paramString1))) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      if (paramSenderListener != null) {
        if (paramPair1 != null)
          arrayList.add(paramPair1); 
        arrayList.add(paramPair2);
        paramSenderListener.a(str, false, arrayList);
      } 
      return str;
    } 
    if (AppInfo.m()) {
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("上传视频, taskId:");
      stringBuilder.append(str);
      Logger.c(str1, new Object[] { stringBuilder.toString() });
    } 
    IUploadTask iUploadTask = UploadTaskFactory.a(str, paramString1, paramString2, paramPair1, paramPair2, paramSenderListener);
    iUploadTask.a(false);
    UploadTaskHandle.a().a(iUploadTask);
    return str;
  }
  
  public static String a(String paramString, List<Pair<String, String>> paramList, SenderListener paramSenderListener) {
    String str = a();
    if (!NetworkUtils.b()) {
      if (paramSenderListener != null)
        paramSenderListener.a(str, false, paramList); 
      return str;
    } 
    if (TextUtils.isEmpty(paramString) || paramList == null || paramList.size() <= 0) {
      if (paramSenderListener != null)
        paramSenderListener.a(str, false, paramList); 
      return str;
    } 
    if (AppInfo.m()) {
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("上传语音, taskId:");
      stringBuilder.append(str);
      Logger.c(str1, new Object[] { stringBuilder.toString() });
    } 
    IUploadTask iUploadTask = UploadTaskFactory.a(str, paramList, paramString, paramSenderListener);
    iUploadTask.a(false);
    UploadTaskHandle.a().a(iUploadTask);
    return str;
  }
  
  public static String a(String paramString, List<Pair<String, String>> paramList, boolean paramBoolean, SenderListener paramSenderListener) {
    return a(paramString, paramList, paramBoolean, false, paramSenderListener);
  }
  
  public static String a(String paramString, List<Pair<String, String>> paramList, boolean paramBoolean1, boolean paramBoolean2, SenderListener paramSenderListener) {
    String str = a();
    if (!NetworkUtils.b()) {
      if (paramSenderListener != null)
        paramSenderListener.a(str, false, paramList); 
      return str;
    } 
    if (TextUtils.isEmpty(paramString) || paramList == null || paramList.size() <= 0) {
      if (paramSenderListener != null)
        paramSenderListener.a(str, false, paramList); 
      return str;
    } 
    if (AppInfo.m()) {
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("上传图片, taskId:");
      stringBuilder.append(str);
      Logger.c(str1, new Object[] { stringBuilder.toString() });
    } 
    IUploadTask iUploadTask = UploadTaskFactory.a(str, paramList, paramString, paramBoolean2, paramSenderListener);
    iUploadTask.a(paramBoolean1);
    UploadTaskHandle.a().a(iUploadTask);
    return str;
  }
  
  public static void a(String paramString) {
    UploadTaskHandle.a().a(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\MediaSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */