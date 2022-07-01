package com.qiniu.android.storage;

import android.os.Process;
import android.util.Log;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.DnsPrefetcher;
import com.qiniu.android.http.PostArgs;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.StringMap;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

final class FormUploader {
  private static void post(final LogHandler logHandler, byte[] paramArrayOfbyte, File paramFile, final String key, final UpToken token, final UpCompletionHandler completionHandler, final UploadOptions options, final Client client, final Configuration config) {
    StringMap stringMap = new StringMap();
    final PostArgs args = new PostArgs();
    if (key != null) {
      stringMap.put("key", key);
      postArgs.fileName = key;
    } else {
      postArgs.fileName = "?";
    } 
    if (paramFile != null)
      postArgs.fileName = paramFile.getName(); 
    stringMap.put("token", token.token);
    if (options == null)
      options = UploadOptions.defaultOptions(); 
    stringMap.putFileds(options.params);
    long l = 0L;
    if (paramFile != null) {
      try {
        long l1 = Crc32.file(paramFile);
        l = l1;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } else {
      l = Crc32.bytes(paramArrayOfbyte);
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(l);
    stringMap.put("crc32", stringBuilder2.toString());
    final ProgressHandler progress = new ProgressHandler() {
        public void onProgress(long param1Long1, long param1Long2) {
          double d2 = param1Long1 / param1Long2;
          double d1 = d2;
          if (d2 > 0.95D)
            d1 = 0.95D; 
          options.progressHandler.progress(key, d1);
        }
      };
    postArgs.data = paramArrayOfbyte;
    postArgs.file = paramFile;
    postArgs.mimeType = options.mimeType;
    postArgs.params = stringMap;
    final String upHost = config.zone.upHost(token.token, config.useHttps, null);
    logHandler.send("target_key", key);
    logHandler.send("up_type", "form");
    logHandler.send("tid", Long.valueOf(Process.myTid()));
    UpToken.setCurrent_region_id(logHandler, str);
    logHandler.send("target_region_id", DnsPrefetcher.target_region_id);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("upload use up host ");
    stringBuilder1.append(str);
    Log.d("Qiniu.FormUploader", stringBuilder1.toString());
    client.asyncMultipartPost(logHandler, str, postArgs, token, progressHandler, new CompletionHandler() {
          public void complete(ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
            final String upHostRetry;
            CompletionHandler completionHandler;
            if (param1ResponseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
              options.netReadyHandler.waitReady();
              if (!AndroidNetwork.isNetWorkReady()) {
                completionHandler.complete(key, param1ResponseInfo, param1JSONObject);
                return;
              } 
            } 
            if (param1ResponseInfo.isOK()) {
              options.progressHandler.progress(key, 1.0D);
              completionHandler.complete(key, param1ResponseInfo, param1JSONObject);
              return;
            } 
            if (param1ResponseInfo.needRetry()) {
              str = config.zone.upHost(token.token, config.useHttps, upHost);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("retry upload first time use up host ");
              stringBuilder.append(str);
              Log.d("Qiniu.FormUploader", stringBuilder.toString());
              completionHandler = new CompletionHandler() {
                  public void complete(ResponseInfo param2ResponseInfo, JSONObject param2JSONObject) {
                    final String upHostRetry2;
                    CompletionHandler completionHandler;
                    if (param2ResponseInfo.isOK()) {
                      options.progressHandler.progress(key, 1.0D);
                      completionHandler.complete(key, param2ResponseInfo, param2JSONObject);
                      return;
                    } 
                    if (param2ResponseInfo.needRetry()) {
                      str = config.zone.upHost(token.token, config.useHttps, upHostRetry);
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("retry upload second time use up host ");
                      stringBuilder.append(str);
                      Log.d("Qiniu.FormUploader", stringBuilder.toString());
                      completionHandler = new CompletionHandler() {
                          public void complete(ResponseInfo param3ResponseInfo, JSONObject param3JSONObject) {
                            if (param3ResponseInfo.isOK()) {
                              options.progressHandler.progress(key, 1.0D);
                            } else if (param3ResponseInfo.needRetry()) {
                              config.zone.frozenDomain(upHostRetry2);
                            } 
                            completionHandler.complete(key, param3ResponseInfo, param3JSONObject);
                          }
                        };
                      client.asyncMultipartPost(logHandler, str, args, token, progress, completionHandler, options.cancellationSignal);
                      return;
                    } 
                    completionHandler.complete(key, (ResponseInfo)str, (JSONObject)completionHandler);
                  }
                };
              client.asyncMultipartPost(logHandler, str, args, token, progress, completionHandler, options.cancellationSignal);
              return;
            } 
            completionHandler.complete(key, (ResponseInfo)str, (JSONObject)completionHandler);
          }
        }options.cancellationSignal);
  }
  
  public static ResponseInfo syncUpload(Client paramClient, Configuration paramConfiguration, File paramFile, String paramString, UpToken paramUpToken, UploadOptions paramUploadOptions) {
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    try {
      return syncUpload0(logHandler, paramClient, paramConfiguration, null, paramFile, paramString, paramUpToken, paramUploadOptions);
    } catch (Exception exception) {
      long l;
      String str = exception.getMessage();
      if (paramFile != null) {
        l = paramFile.length();
      } else {
        l = 0L;
      } 
      return ResponseInfo.create(logHandler, null, 0, "", "", "", "", "", "", 0, 0L, 0L, str, paramUpToken, l);
    } 
  }
  
  public static ResponseInfo syncUpload(Client paramClient, Configuration paramConfiguration, byte[] paramArrayOfbyte, String paramString, UpToken paramUpToken, UploadOptions paramUploadOptions) {
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    try {
      return syncUpload0(logHandler, paramClient, paramConfiguration, paramArrayOfbyte, null, paramString, paramUpToken, paramUploadOptions);
    } catch (Exception exception) {
      long l;
      String str = exception.getMessage();
      if (paramArrayOfbyte != null) {
        l = paramArrayOfbyte.length;
      } else {
        l = 0L;
      } 
      return ResponseInfo.create(logHandler, null, 0, "", "", "", "", "", "", 0, 0L, 0L, str, paramUpToken, l);
    } 
  }
  
  private static ResponseInfo syncUpload0(LogHandler paramLogHandler, Client paramClient, Configuration paramConfiguration, byte[] paramArrayOfbyte, File paramFile, String paramString, UpToken paramUpToken, UploadOptions paramUploadOptions) {
    StringMap stringMap = new StringMap();
    PostArgs postArgs = new PostArgs();
    if (paramString != null) {
      stringMap.put("key", paramString);
      postArgs.fileName = paramString;
    } else {
      postArgs.fileName = "?";
    } 
    if (paramFile != null)
      postArgs.fileName = paramFile.getName(); 
    stringMap.put("token", paramUpToken.token);
    if (paramUploadOptions == null)
      paramUploadOptions = UploadOptions.defaultOptions(); 
    stringMap.putFileds(paramUploadOptions.params);
    long l = 0L;
    if (paramFile != null) {
      try {
        long l1 = Crc32.file(paramFile);
        l = l1;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } else {
      l = Crc32.bytes(paramArrayOfbyte);
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(l);
    stringMap.put("crc32", stringBuilder2.toString());
    postArgs.data = paramArrayOfbyte;
    postArgs.file = paramFile;
    postArgs.mimeType = paramUploadOptions.mimeType;
    postArgs.params = stringMap;
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("up_type", "uc_query");
    if (!paramConfiguration.zone.preQuery(logHandler, paramUpToken.token))
      return ResponseInfo.invalidToken("failed to get up host"); 
    String str = paramConfiguration.zone.upHost(paramUpToken.token, paramConfiguration.useHttps, null);
    paramLogHandler.send("target_key", paramString);
    paramLogHandler.send("up_type", "form");
    paramLogHandler.send("tid", Long.valueOf(Process.myTid()));
    UpToken.setCurrent_region_id(paramLogHandler, str);
    paramLogHandler.send("target_region_id", DnsPrefetcher.target_region_id);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("sync upload use up host ");
    stringBuilder1.append(str);
    Log.d("Qiniu.FormUploader", stringBuilder1.toString());
    ResponseInfo responseInfo2 = paramClient.syncMultipartPost(paramLogHandler, str, postArgs, paramUpToken);
    if (responseInfo2.isOK())
      return responseInfo2; 
    ResponseInfo responseInfo1 = responseInfo2;
    if (responseInfo2.needRetry()) {
      if (responseInfo2.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
        paramUploadOptions.netReadyHandler.waitReady();
        if (!AndroidNetwork.isNetWorkReady())
          return responseInfo2; 
      } 
      paramString = paramConfiguration.zone.upHost(paramUpToken.token, paramConfiguration.useHttps, str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sync upload retry first time use up host ");
      stringBuilder.append(paramString);
      Log.d("Qiniu.FormUploader", stringBuilder.toString());
      responseInfo2 = paramClient.syncMultipartPost(paramLogHandler, paramString, postArgs, paramUpToken);
      ResponseInfo responseInfo = responseInfo2;
      if (responseInfo2.needRetry()) {
        if (responseInfo2.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
          paramUploadOptions.netReadyHandler.waitReady();
          if (!AndroidNetwork.isNetWorkReady())
            return responseInfo2; 
        } 
        String str1 = paramConfiguration.zone.upHost(paramUpToken.token, paramConfiguration.useHttps, paramString);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("sync upload retry second time use up host ");
        stringBuilder3.append(str1);
        Log.d("Qiniu.FormUploader", stringBuilder3.toString());
        ResponseInfo responseInfo3 = paramClient.syncMultipartPost(paramLogHandler, str1, postArgs, paramUpToken);
        responseInfo1 = responseInfo3;
        if (responseInfo3.needRetry()) {
          paramConfiguration.zone.frozenDomain(str1);
          responseInfo1 = responseInfo3;
        } 
      } 
    } 
    return responseInfo1;
  }
  
  static void upload(Client paramClient, Configuration paramConfiguration, File paramFile, String paramString, UpToken paramUpToken, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions) {
    post(UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo()), null, paramFile, paramString, paramUpToken, paramUpCompletionHandler, paramUploadOptions, paramClient, paramConfiguration);
  }
  
  static void upload(Client paramClient, Configuration paramConfiguration, byte[] paramArrayOfbyte, String paramString, UpToken paramUpToken, UpCompletionHandler paramUpCompletionHandler, UploadOptions paramUploadOptions) {
    post(UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo()), paramArrayOfbyte, null, paramString, paramUpToken, paramUpCompletionHandler, paramUploadOptions, paramClient, paramConfiguration);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\FormUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */