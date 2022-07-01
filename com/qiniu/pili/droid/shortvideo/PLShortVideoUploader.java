package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.KeyGenerator;
import com.qiniu.android.storage.Recorder;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import com.qiniu.android.storage.persistent.FileRecorder;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import org.json.JSONObject;

public final class PLShortVideoUploader {
  private static final String TAG = "PLShortVideoUploader";
  
  private volatile boolean mIsCancelled = false;
  
  private Recorder mRecorder = null;
  
  private UpCancellationSignal mUpLoadCancellationSignal = new UpCancellationSignal(this) {
      public boolean isCancelled() {
        return this.a.mIsCancelled;
      }
    };
  
  private UpCompletionHandler mUpLoadCompletionHandler = new UpCompletionHandler(this) {
      public void complete(String param1String, ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
        if (this.a.mUploadResultListener != null) {
          if (param1ResponseInfo.isOK()) {
            this.a.mUploadResultListener.onUploadVideoSuccess(param1JSONObject);
            return;
          } 
          this.a.mUploadResultListener.onUploadVideoFailed(param1ResponseInfo.statusCode, param1ResponseInfo.error);
        } 
      }
    };
  
  private UpProgressHandler mUpLoadProgressHandler = new UpProgressHandler(this) {
      public void progress(String param1String, double param1Double) {
        if (this.a.mUploadProgressListener != null)
          this.a.mUploadProgressListener.onUploadProgress(param1String, param1Double); 
      }
    };
  
  private UploadManager mUploadManager;
  
  private UploadOptions mUploadOptions;
  
  private PLUploadProgressListener mUploadProgressListener;
  
  private PLUploadResultListener mUploadResultListener;
  
  public PLShortVideoUploader(Context paramContext, PLUploadSetting paramPLUploadSetting) {
    QosManager.a(paramContext).a(QosManager.KeyPoint.upload_init);
    try {
      this.mRecorder = (Recorder)new FileRecorder(paramContext.getCacheDir().getPath());
    } catch (Exception exception) {
      e.o.e("PLShortVideoUploader", exception.getMessage());
    } 
    KeyGenerator keyGenerator = new KeyGenerator(this) {
        public String gen(String param1String, File param1File) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1String);
          stringBuilder.append("_._");
          stringBuilder.append((new StringBuffer(param1File.getAbsolutePath())).reverse());
          return stringBuilder.toString();
        }
      };
    if (this.mUploadManager == null)
      this.mUploadManager = new UploadManager((new Configuration.Builder()).chunkSize(paramPLUploadSetting.getChunkSize()).putThreshhold(paramPLUploadSetting.getPutThreshhold()).connectTimeout(paramPLUploadSetting.getConnectTimeout()).responseTimeout(paramPLUploadSetting.getResponseTimeout()).recorder(this.mRecorder, keyGenerator).zone(paramPLUploadSetting.getZone()).useHttps(paramPLUploadSetting.isHttpsEnabled()).build()); 
    this.mUploadOptions = new UploadOptions(paramPLUploadSetting.getParams(), null, false, this.mUpLoadProgressHandler, this.mUpLoadCancellationSignal);
  }
  
  public void cancelUpload() {
    e.o.c("PLShortVideoUploader", "cancel upload");
    this.mIsCancelled = true;
  }
  
  public void setUploadProgressListener(PLUploadProgressListener paramPLUploadProgressListener) {
    this.mUploadProgressListener = paramPLUploadProgressListener;
  }
  
  public void setUploadResultListener(PLUploadResultListener paramPLUploadResultListener) {
    this.mUploadResultListener = paramPLUploadResultListener;
  }
  
  public void startUpload(String paramString1, String paramString2) {
    startUpload(paramString1, null, paramString2);
  }
  
  public void startUpload(String paramString1, String paramString2, String paramString3) {
    QosManager.a().a(QosManager.KeyPoint.upload_video);
    e.o.c("PLShortVideoUploader", "start upload");
    this.mIsCancelled = false;
    this.mUploadManager.put(paramString1, paramString2, paramString3, this.mUpLoadCompletionHandler, this.mUploadOptions);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLShortVideoUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */