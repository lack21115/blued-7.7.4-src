package com.blued.android.framework.utils.upload.qiniu;

import android.text.TextUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import java.io.File;

public class QiniuUploadUtils {
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, QiniuUploadTools.QiNiuListener paramQiNiuListener) {
    if (TextUtils.isEmpty(paramString3)) {
      if (paramQiNiuListener != null)
        paramQiNiuListener.a(paramString4); 
      return;
    } 
    QiniuUploadTools.a(QiniuUploadTools.a(paramInt, paramString1, paramString2), new File(paramString3), paramString4, paramString5, paramQiNiuListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\QiniuUploadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */