package com.qiniu.android.storage;

import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.collect.UploadInfoElement;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.DnsPrefetcher;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.Json;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class UploadManager {
  private static int DEF_THREAD_NUM = 3;
  
  static AtomicBoolean atomicLocalPrefetch = new AtomicBoolean(false);
  
  private final Client client;
  
  private final Configuration config;
  
  private int multithreads = 1;
  
  public UploadManager() {
    this((new Configuration.Builder()).build(), DEF_THREAD_NUM);
  }
  
  public UploadManager(Configuration paramConfiguration) {
    this.config = paramConfiguration;
    this.client = new Client(paramConfiguration.proxy, paramConfiguration.connectTimeout, paramConfiguration.responseTimeout, paramConfiguration.urlConverter, paramConfiguration.dns);
    startLocalPrefetch(paramConfiguration);
  }
  
  public UploadManager(Configuration paramConfiguration, int paramInt) {
    this.config = paramConfiguration;
    if (paramInt < 1)
      paramInt = DEF_THREAD_NUM; 
    this.multithreads = paramInt;
    this.client = new Client(paramConfiguration.proxy, paramConfiguration.connectTimeout, paramConfiguration.responseTimeout, paramConfiguration.urlConverter, paramConfiguration.dns);
    startLocalPrefetch(paramConfiguration);
  }
  
  public UploadManager(Recorder paramRecorder) {
    this(paramRecorder, (KeyGenerator)null);
  }
  
  public UploadManager(Recorder paramRecorder, int paramInt) {
    this(paramRecorder, null, paramInt);
  }
  
  public UploadManager(Recorder paramRecorder, KeyGenerator paramKeyGenerator) {
    this((new Configuration.Builder()).recorder(paramRecorder, paramKeyGenerator).build());
  }
  
  public UploadManager(Recorder paramRecorder, KeyGenerator paramKeyGenerator, int paramInt) {
    this((new Configuration.Builder()).recorder(paramRecorder, paramKeyGenerator).build(), paramInt);
  }
  
  private static ResponseInfo areInvalidArg(String paramString1, byte[] paramArrayOfbyte, File paramFile, String paramString2, UpToken paramUpToken) {
    String str = null;
    if (paramFile == null && paramArrayOfbyte == null) {
      paramString1 = "no input data";
    } else if (paramString2 == null || paramString2.equals("")) {
      paramString1 = "no token";
    } else {
      paramString1 = null;
    } 
    if (paramString1 != null)
      return ResponseInfo.invalidArgument(paramString1, paramUpToken); 
    if (UpToken.isInvalid(paramUpToken))
      return ResponseInfo.invalidToken("invalid token"); 
    if (paramFile == null || paramFile.length() != 0L) {
      paramString1 = str;
      if (paramArrayOfbyte != null) {
        paramString1 = str;
        if (paramArrayOfbyte.length == 0)
          return ResponseInfo.zeroSize(paramUpToken); 
      } 
      return (ResponseInfo)paramString1;
    } 
    return ResponseInfo.zeroSize(paramUpToken);
  }
  
  private static boolean areInvalidArg(String paramString1, byte[] paramArrayOfbyte, File paramFile, String paramString2, UpToken paramUpToken, UpCompletionHandler paramUpCompletionHandler) {
    if (paramUpCompletionHandler != null) {
      ResponseInfo responseInfo;
      if (paramFile == null && paramArrayOfbyte == null) {
        paramString2 = "no input data";
      } else if (paramString2 == null || paramString2.equals("")) {
        paramString2 = "no token";
      } else {
        paramString2 = null;
      } 
      if (paramString2 != null) {
        responseInfo = ResponseInfo.invalidArgument(paramString2, paramUpToken);
      } else if (UpToken.isInvalid(paramUpToken)) {
        responseInfo = ResponseInfo.invalidToken("invalid token");
      } else if ((paramFile != null && paramFile.length() == 0L) || (responseInfo != null && responseInfo.length == 0)) {
        responseInfo = ResponseInfo.zeroSize(paramUpToken);
      } else {
        responseInfo = null;
      } 
      if (responseInfo != null) {
        paramUpCompletionHandler.complete(paramString1, responseInfo, null);
        return true;
      } 
      return false;
    } 
    throw new IllegalArgumentException("no UpCompletionHandler");
  }
  
  private void startLocalPrefetch(Configuration paramConfiguration) {
    if (atomicLocalPrefetch.compareAndSet(false, true) && DnsPrefetcher.recoverCache(paramConfiguration))
      (new Thread(new Runnable() {
            public void run() {
              DnsPrefetcher.getDnsPrefetcher().localFetch();
            }
          })).start(); 
  }
  
  private static WarpHandler warpHandler(UpCompletionHandler paramUpCompletionHandler, long paramLong) {
    return new WarpHandler(paramUpCompletionHandler, paramLong);
  }
  
  public void put(final File file, final String key, final String token, final UpCompletionHandler complete, final UploadOptions options) {
    final UpToken decodedToken = UpToken.parse(token);
    if (areInvalidArg(key, null, file, token, upToken, complete))
      return; 
    if (DnsPrefetcher.checkRePrefetchDns(token, this.config))
      (new Thread(new Runnable() {
            public void run() {
              DnsPrefetcher.startPrefetchDns(token, UploadManager.this.config);
            }
          })).start(); 
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("up_type", "uc_query");
    this.config.zone.preQuery(logHandler, token, new Zone.QueryHandler() {
          public void onFailure(int param1Int) {
            ResponseInfo responseInfo;
            if (ResponseInfo.isStatusCodeForBrokenNetwork(param1Int)) {
              responseInfo = ResponseInfo.networkError(param1Int, decodedToken);
            } else {
              responseInfo = ResponseInfo.invalidToken("invalid token");
            } 
            complete.complete(key, responseInfo, null);
          }
          
          public void onSuccess() {
            long l1;
            long l2 = file.length();
            UpCompletionHandler upCompletionHandler = complete;
            File file = file;
            if (file != null) {
              l1 = file.length();
            } else {
              l1 = 0L;
            } 
            upCompletionHandler = UploadManager.warpHandler(upCompletionHandler, l1);
            if (l2 <= UploadManager.this.config.putThreshold) {
              FormUploader.upload(UploadManager.this.client, UploadManager.this.config, file, key, decodedToken, upCompletionHandler, options);
              return;
            } 
            String str = UploadManager.this.config.keyGen.gen(key, file);
            if (UploadManager.this.multithreads == 1) {
              AsyncRun.runInMain(new ResumeUploader(UploadManager.this.client, UploadManager.this.config, file, key, decodedToken, upCompletionHandler, options, str));
              return;
            } 
            AsyncRun.runInMain(new ResumeUploaderFast(UploadManager.this.client, UploadManager.this.config, file, key, decodedToken, upCompletionHandler, options, str, UploadManager.this.multithreads));
          }
        });
  }
  
  public void put(String paramString1, String paramString2, String paramString3, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions) {
    put(new File(paramString1), paramString2, paramString3, paramUpCompletionHandler, paramUploadOptions);
  }
  
  public void put(final byte[] data, final String key, final String token, final UpCompletionHandler complete, final UploadOptions options) {
    long l;
    final UpToken decodedToken = UpToken.parse(token);
    if (areInvalidArg(key, data, null, token, upToken, complete))
      return; 
    if (DnsPrefetcher.checkRePrefetchDns(token, this.config))
      (new Thread(new Runnable() {
            public void run() {
              DnsPrefetcher.startPrefetchDns(token, UploadManager.this.config);
            }
          })).start(); 
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("up_type", "uc_query");
    if (data != null) {
      l = data.length;
    } else {
      l = 0L;
    } 
    final WarpHandler completionHandler = warpHandler(complete, l);
    this.config.zone.preQuery(logHandler, token, new Zone.QueryHandler() {
          public void onFailure(int param1Int) {
            ResponseInfo responseInfo;
            if (ResponseInfo.isStatusCodeForBrokenNetwork(param1Int)) {
              responseInfo = ResponseInfo.networkError(param1Int, decodedToken);
            } else {
              responseInfo = ResponseInfo.invalidToken("invalid token");
            } 
            complete.complete(key, responseInfo, null);
          }
          
          public void onSuccess() {
            FormUploader.upload(UploadManager.this.client, UploadManager.this.config, data, key, decodedToken, completionHandler, options);
          }
        });
  }
  
  public ResponseInfo syncPut(File paramFile, String paramString1, String paramString2, UploadOptions paramUploadOptions) {
    UpToken upToken = UpToken.parse(paramString2);
    ResponseInfo responseInfo = areInvalidArg(paramString1, null, paramFile, paramString2, upToken);
    return (responseInfo != null) ? responseInfo : FormUploader.syncUpload(this.client, this.config, paramFile, paramString1, upToken, paramUploadOptions);
  }
  
  public ResponseInfo syncPut(String paramString1, String paramString2, String paramString3, UploadOptions paramUploadOptions) {
    return syncPut(new File(paramString1), paramString2, paramString3, paramUploadOptions);
  }
  
  public ResponseInfo syncPut(byte[] paramArrayOfbyte, String paramString1, String paramString2, UploadOptions paramUploadOptions) {
    UpToken upToken = UpToken.parse(paramString2);
    ResponseInfo responseInfo = areInvalidArg(paramString1, paramArrayOfbyte, null, paramString2, upToken);
    return (responseInfo != null) ? responseInfo : FormUploader.syncUpload(this.client, this.config, paramArrayOfbyte, paramString1, upToken, paramUploadOptions);
  }
  
  static class WarpHandler implements UpCompletionHandler {
    final long before = System.currentTimeMillis();
    
    final UpCompletionHandler complete;
    
    final long size;
    
    WarpHandler(UpCompletionHandler param1UpCompletionHandler, long param1Long) {
      this.complete = param1UpCompletionHandler;
      this.size = param1Long;
    }
    
    public void complete(final String key, final ResponseInfo res, final JSONObject response) {
      if (Config.isRecord) {
        final long after = System.currentTimeMillis();
        UploadInfoCollector.handleUpload(res.upToken, new UploadInfoCollector.RecordMsg() {
              public String toRecordMsg() {
                LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getUploadQuality());
                logHandler.send("result", UploadInfoElement.resultCode(res.statusCode, res.error));
                logHandler.send("total_elapsed_time", Long.valueOf(after - UploadManager.WarpHandler.this.before));
                ResponseInfo responseInfo = res;
                logHandler.send("requests_counts", Long.valueOf(ResponseInfo.requests_count));
                responseInfo = res;
                logHandler.send("bytes_sent", Long.valueOf(ResponseInfo.bytes_sent));
                logHandler.send("up_time", Long.valueOf(System.currentTimeMillis() / 1000L));
                ResponseInfo.requests_count = 0L;
                ResponseInfo.bytes_sent = 0L;
                return Json.object2Json(logHandler.getUploadInfo());
              }
            });
      } 
      AsyncRun.runInMain(new Runnable() {
            public void run() {
              try {
                return;
              } finally {
                Exception exception = null;
                exception.printStackTrace();
              } 
            }
          });
    }
  }
  
  class null extends UploadInfoCollector.RecordMsg {
    public String toRecordMsg() {
      LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getUploadQuality());
      logHandler.send("result", UploadInfoElement.resultCode(res.statusCode, res.error));
      logHandler.send("total_elapsed_time", Long.valueOf(after - this.this$0.before));
      ResponseInfo responseInfo = res;
      logHandler.send("requests_counts", Long.valueOf(ResponseInfo.requests_count));
      responseInfo = res;
      logHandler.send("bytes_sent", Long.valueOf(ResponseInfo.bytes_sent));
      logHandler.send("up_time", Long.valueOf(System.currentTimeMillis() / 1000L));
      ResponseInfo.requests_count = 0L;
      ResponseInfo.bytes_sent = 0L;
      return Json.object2Json(logHandler.getUploadInfo());
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        exception.printStackTrace();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\UploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */