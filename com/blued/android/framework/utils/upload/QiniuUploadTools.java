package com.blued.android.framework.utils.upload;

import android.text.TextUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.ThreadUtils;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QiniuUploadTools {
  public static Configuration a(int paramInt, String paramString1, String paramString2) {
    Configuration.Builder builder = new Configuration.Builder();
    builder.useHttps(true);
    if (1 != paramInt)
      builder.chunkSize(1048576); 
    if (!TextUtils.isEmpty(paramString1))
      builder.zone((Zone)new FixedZone(new String[] { paramString1, paramString2 })); 
    return builder.build();
  }
  
  public static Configuration a(String paramString1, String paramString2) {
    Configuration.Builder builder = new Configuration.Builder();
    builder.useHttps(true);
    builder.chunkSize(1048576);
    if (!TextUtils.isEmpty(paramString1))
      builder.zone((Zone)new FixedZone(new String[] { paramString1, paramString2 })); 
    return builder.build();
  }
  
  public static void a(Configuration paramConfiguration, File paramFile, String paramString1, String paramString2, QiNiuListener paramQiNiuListener) {
    UploadManager uploadManager;
    if (paramConfiguration == null) {
      uploadManager = new UploadManager();
    } else {
      uploadManager = new UploadManager((Configuration)uploadManager, 3);
    } 
    uploadManager.put(paramFile, paramString1, paramString2, new UpCompletionHandler(paramQiNiuListener) {
          public void complete(String param1String, ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
            String str1;
            String str2;
            String str3 = "null";
            if (param1JSONObject == null) {
              str2 = "null";
            } else {
              str2 = param1JSONObject.toString();
            } 
            if (param1ResponseInfo != null && param1ResponseInfo.isOK()) {
              Logger.a("QiniuUploadUtils", new Object[] { "response = ", str2 });
              try {
                str1 = param1JSONObject.getString("name");
                Logger.a("QiniuUploadUtils", new Object[] { "name = ", str1 });
                if (this.a != null) {
                  this.a.a(str1, param1String);
                  return;
                } 
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
                return;
              } catch (NullPointerException nullPointerException) {
                nullPointerException.printStackTrace();
                return;
              } 
            } else {
              if (str1 == null) {
                str1 = str3;
              } else {
                str1 = str1.toString();
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(" Fail info = ");
              stringBuilder.append(str1);
              stringBuilder.append(" | response = ");
              stringBuilder.append(str2);
              Logger.a("QiniuUploadUtils", new Object[] { stringBuilder.toString() });
              QiniuUploadTools.QiNiuListener qiNiuListener = this.a;
              if (qiNiuListener != null)
                qiNiuListener.a((String)nullPointerException); 
            } 
          }
        }new UploadOptions(new HashMap<Object, Object>(), null, false, new UpProgressHandler(paramQiNiuListener) {
            public void progress(String param1String, double param1Double) {
              QiniuUploadTools.QiNiuListener qiNiuListener = this.a;
              if (qiNiuListener != null)
                qiNiuListener.a(param1String, param1Double); 
            }
          }new UpCancellationSignal(paramQiNiuListener) {
            public boolean isCancelled() {
              return this.a.a();
            }
          }));
  }
  
  public static void a(Configuration paramConfiguration, byte[] paramArrayOfbyte, String paramString1, String paramString2, QiNiuListener paramQiNiuListener) {
    UploadManager uploadManager;
    if (paramConfiguration == null) {
      uploadManager = new UploadManager();
    } else {
      uploadManager = new UploadManager((Configuration)uploadManager, 3);
    } 
    uploadManager.put(paramArrayOfbyte, paramString1, paramString2, new UpCompletionHandler(paramQiNiuListener) {
          public void complete(String param1String, ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
            String str1;
            String str2;
            String str3 = "null";
            if (param1JSONObject == null) {
              str2 = "null";
            } else {
              str2 = param1JSONObject.toString();
            } 
            if (param1ResponseInfo != null && param1ResponseInfo.isOK()) {
              Logger.a("QiniuUploadUtils", new Object[] { "response = ", str2 });
              try {
                str1 = param1JSONObject.getString("name");
                Logger.a("QiniuUploadUtils", new Object[] { "name = ", str1 });
                ThreadUtils.a(new Runnable(this, str1, param1String) {
                      public void run() {
                        if (this.c.a != null)
                          this.c.a.a(this.a, this.b); 
                      }
                    });
                return;
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
                return;
              } catch (NullPointerException nullPointerException) {
                nullPointerException.printStackTrace();
                return;
              } 
            } 
            if (str1 == null) {
              str1 = str3;
            } else {
              str1 = str1.toString();
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" Fail info = ");
            stringBuilder.append(str1);
            stringBuilder.append(" | response = ");
            stringBuilder.append(str2);
            Logger.a("QiniuUploadUtils", new Object[] { stringBuilder.toString() });
            ThreadUtils.a(new Runnable(this, (String)nullPointerException) {
                  public void run() {
                    if (this.b.a != null)
                      this.b.a.a(this.a); 
                  }
                });
          }
        }new UploadOptions(new HashMap<Object, Object>(), null, false, new UpProgressHandler(paramQiNiuListener) {
            public void progress(String param1String, double param1Double) {
              ThreadUtils.a(new Runnable(this, param1String, param1Double) {
                    public void run() {
                      if (this.c.a != null)
                        this.c.a.a(this.a, this.b); 
                    }
                  });
            }
          }new UpCancellationSignal(paramQiNiuListener) {
            public boolean isCancelled() {
              return this.a.a();
            }
          }));
  }
  
  public static interface QiNiuListener {
    void a(String param1String);
    
    void a(String param1String, double param1Double);
    
    void a(String param1String1, String param1String2);
    
    boolean a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\QiniuUploadTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */