package com.qiniu.android.storage;

import android.os.Process;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.DnsPrefetcher;
import com.qiniu.android.http.ProgressHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Crc32;
import com.qiniu.android.utils.Json;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ResumeUploader implements Runnable {
  private final byte[] chunkBuffer;
  
  private final Client client;
  
  private final UpCompletionHandler completionHandler;
  
  private final Configuration config;
  
  private final String[] contexts;
  
  private long crc32;
  
  private File f;
  
  private RandomAccessFile file;
  
  private final StringMap headers;
  
  private final String key;
  
  private final long modifyTime;
  
  private final UploadOptions options;
  
  private final String recorderKey;
  
  private long recover_from;
  
  private UpToken token;
  
  private final long totalSize;
  
  ResumeUploader(Client paramClient, Configuration paramConfiguration, File paramFile, String paramString1, UpToken paramUpToken, final UpCompletionHandler completionHandler, UploadOptions paramUploadOptions, String paramString2) {
    this.client = paramClient;
    this.config = paramConfiguration;
    this.f = paramFile;
    this.recorderKey = paramString2;
    this.totalSize = paramFile.length();
    this.key = paramString1;
    StringMap stringMap = new StringMap();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UpToken ");
    stringBuilder.append(paramUpToken.token);
    this.headers = stringMap.put("Authorization", stringBuilder.toString());
    this.file = null;
    this.completionHandler = new UpCompletionHandler() {
        public void complete(String param1String, ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
          if (ResumeUploader.this.file != null)
            try {
              ResumeUploader.this.file.close();
            } catch (IOException iOException) {
              iOException.printStackTrace();
            }  
          completionHandler.complete(param1String, param1ResponseInfo, param1JSONObject);
        }
      };
    if (paramUploadOptions == null)
      paramUploadOptions = UploadOptions.defaultOptions(); 
    this.options = paramUploadOptions;
    this.chunkBuffer = new byte[paramConfiguration.chunkSize];
    this.contexts = new String[(int)((this.totalSize + 4194304L - 1L) / 4194304L)];
    this.modifyTime = paramFile.lastModified();
    this.token = paramUpToken;
  }
  
  private long calcBlockSize(long paramLong) {
    long l = this.totalSize - paramLong;
    paramLong = 4194304L;
    if (l < 4194304L)
      paramLong = l; 
    return paramLong;
  }
  
  private long calcPutSize(long paramLong) {
    paramLong = this.totalSize - paramLong;
    return (paramLong < this.config.chunkSize) ? paramLong : this.config.chunkSize;
  }
  
  private boolean isCancelled() {
    return this.options.cancellationSignal.isCancelled();
  }
  
  private static boolean isChunkOK(ResponseInfo paramResponseInfo, JSONObject paramJSONObject) {
    return (paramResponseInfo.statusCode == 200 && paramResponseInfo.error == null && (paramResponseInfo.hasReqId() || isChunkResOK(paramJSONObject)));
  }
  
  private static boolean isChunkResOK(JSONObject paramJSONObject) {
    try {
      paramJSONObject.getString("ctx");
      paramJSONObject.getLong("crc32");
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private static boolean isNotChunkToQiniu(ResponseInfo paramResponseInfo, JSONObject paramJSONObject) {
    return (paramResponseInfo.statusCode < 500 && paramResponseInfo.statusCode >= 200 && !paramResponseInfo.hasReqId() && !isChunkResOK(paramJSONObject));
  }
  
  private void makeBlock(String paramString, long paramLong, int paramInt1, int paramInt2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("target_key", this.key);
    logHandler.send("up_type", "mkblk");
    logHandler.send("tid", Long.valueOf(Process.myTid()));
    logHandler.send("file_offset", Long.valueOf(paramLong));
    logHandler.send("bytes_total", Long.valueOf(paramInt2));
    String str = String.format(Locale.ENGLISH, "/mkblk/%d", new Object[] { Integer.valueOf(paramInt1) });
    try {
      this.file.seek(paramLong);
      this.file.read(this.chunkBuffer, 0, paramInt2);
      this.crc32 = Crc32.bytes(this.chunkBuffer, 0, paramInt2);
      post(logHandler, String.format("%s%s", new Object[] { paramString, str }), this.chunkBuffer, 0, paramInt2, paramProgressHandler, paramCompletionHandler, paramUpCancellationSignal);
      return;
    } catch (IOException iOException) {
      this.completionHandler.complete(this.key, ResponseInfo.fileError(iOException, this.token), null);
      return;
    } 
  }
  
  private void makeFile(String paramString, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("target_key", this.key);
    logHandler.send("up_type", "mkfile");
    logHandler.send("tid", Long.valueOf(Process.myTid()));
    String str3 = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", new Object[] { UrlSafeBase64.encodeToString(this.options.mimeType), UrlSafeBase64.encodeToString(this.f.getName()) });
    String str1 = this.key;
    String str2 = "";
    if (str1 != null) {
      str1 = String.format("/key/%s", new Object[] { UrlSafeBase64.encodeToString(str1) });
    } else {
      str1 = "";
    } 
    if (this.options.params.size() != 0) {
      String[] arrayOfString = new String[this.options.params.size()];
      Iterator<Map.Entry> iterator = this.options.params.entrySet().iterator();
      int i;
      for (i = 0; iterator.hasNext(); i++) {
        Map.Entry entry = iterator.next();
        arrayOfString[i] = String.format(Locale.ENGLISH, "%s/%s", new Object[] { entry.getKey(), UrlSafeBase64.encodeToString((String)entry.getValue()) });
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/");
      stringBuilder.append(StringUtils.join(arrayOfString, "/"));
      str2 = stringBuilder.toString();
    } 
    str2 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", new Object[] { Long.valueOf(this.totalSize), str3, str1, str2 });
    byte[] arrayOfByte = StringUtils.join(this.contexts, ",").getBytes();
    paramString = String.format("%s%s", new Object[] { paramString, str2 });
    logHandler.send("file_offset", Integer.valueOf(0));
    logHandler.send("bytes_total", Long.valueOf(arrayOfByte.length));
    post(logHandler, paramString, arrayOfByte, 0, arrayOfByte.length, null, paramCompletionHandler, paramUpCancellationSignal);
  }
  
  private URI newURI(URI paramURI, String paramString) {
    try {
      return new URI(paramURI.getScheme(), null, paramURI.getHost(), paramURI.getPort(), paramString, null, null);
    } catch (URISyntaxException uRISyntaxException) {
      uRISyntaxException.printStackTrace();
      return paramURI;
    } 
  }
  
  private void nextTask(final long offset, final int retried, String paramString) {
    final ResponseInfo upHost;
    if (isCancelled()) {
      responseInfo = ResponseInfo.cancelled(this.token);
      this.completionHandler.complete(this.key, responseInfo, null);
      return;
    } 
    if (offset == this.totalSize) {
      makeFile((String)responseInfo, new CompletionHandler() {
            public void complete(ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
              if (param1ResponseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
                ResumeUploader.this.options.netReadyHandler.waitReady();
                if (!AndroidNetwork.isNetWorkReady()) {
                  ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
                  return;
                } 
              } 
              if (param1ResponseInfo.isOK()) {
                ResumeUploader.this.removeRecord();
                ResumeUploader.this.options.progressHandler.progress(ResumeUploader.this.key, 1.0D);
                ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
                return;
              } 
              if (param1ResponseInfo.needRetry() && retried < ResumeUploader.this.config.retryMax + 1) {
                String str = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, upHost);
                if (str != null) {
                  ResumeUploader.this.nextTask(offset, retried + 1, str);
                  return;
                } 
              } 
              ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, param1ResponseInfo, param1JSONObject);
            }
          }this.options.cancellationSignal);
      return;
    } 
    final int chunkSize = (int)calcPutSize(offset);
    ProgressHandler progressHandler = new ProgressHandler() {
        public void onProgress(long param1Long1, long param1Long2) {
          double d2 = (offset + param1Long1) / param1Long2;
          double d1 = d2;
          if (d2 > 0.95D)
            d1 = 0.95D; 
          ResumeUploader.this.options.progressHandler.progress(ResumeUploader.this.key, d1);
        }
      };
    CompletionHandler completionHandler = new CompletionHandler() {
        public void complete(final ResponseInfo info, JSONObject param1JSONObject) {
          final long tid = Process.myTid();
          UploadInfoCollector.handleHttp(ResumeUploader.this.token, new UploadInfoCollector.RecordMsg() {
                public String toRecordMsg() {
                  LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getBlockInfo());
                  UpToken.setCurrent_region_id(logHandler, upHost);
                  logHandler.send("target_region_id", DnsPrefetcher.target_region_id);
                  logHandler.send("total_elapsed_time", Long.valueOf(info.duration));
                  logHandler.send("bytes_sent", Long.valueOf(info.sent));
                  logHandler.send("recovered_from", Long.valueOf(ResumeUploader.this.recover_from));
                  logHandler.send("file_size", Long.valueOf(ResumeUploader.this.totalSize));
                  logHandler.send("pid", Long.valueOf(Process.myPid()));
                  logHandler.send("tid", Long.valueOf(tid));
                  logHandler.send("up_api_version", Integer.valueOf(1));
                  logHandler.send("up_time", Long.valueOf(System.currentTimeMillis() / 1000L));
                  return Json.object2Json(logHandler.getUploadInfo());
                }
              });
          if (info.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
            ResumeUploader.this.options.netReadyHandler.waitReady();
            if (!AndroidNetwork.isNetWorkReady()) {
              ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, info, param1JSONObject);
              return;
            } 
          } 
          if (info.isCancelled()) {
            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, info, param1JSONObject);
            return;
          } 
          if (!ResumeUploader.isChunkOK(info, param1JSONObject)) {
            String str = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, upHost);
            if (info.statusCode == 701 && retried < ResumeUploader.this.config.retryMax) {
              ResumeUploader.this.nextTask(offset / 4194304L * 4194304L, retried + 1, upHost);
              return;
            } 
            if (str != null && (ResumeUploader.isNotChunkToQiniu(info, param1JSONObject) || info.needRetry()) && retried < ResumeUploader.this.config.retryMax) {
              ResumeUploader.this.nextTask(offset, retried + 1, str);
              return;
            } 
            ResumeUploader.this.completionHandler.complete(ResumeUploader.this.key, info, param1JSONObject);
            return;
          } 
          if (param1JSONObject == null && retried < ResumeUploader.this.config.retryMax) {
            String str = ResumeUploader.this.config.zone.upHost(ResumeUploader.this.token.token, ResumeUploader.this.config.useHttps, upHost);
            ResumeUploader.this.nextTask(offset, retried + 1, str);
            return;
          } 
          l = 0L;
          exception = null;
          try {
            String str = param1JSONObject.getString("ctx");
            try {
              long l1 = param1JSONObject.getLong("crc32");
              l = l1;
            } catch (Exception exception1) {}
          } catch (Exception exception) {
            Object object = null;
          } 
          exception.printStackTrace();
        }
      };
    if (offset % 4194304L == 0L) {
      makeBlock((String)responseInfo, offset, (int)calcBlockSize(offset), i, progressHandler, completionHandler, this.options.cancellationSignal);
      return;
    } 
    putChunk((String)responseInfo, offset, i, this.contexts[(int)(offset / 4194304L)], progressHandler, completionHandler, this.options.cancellationSignal);
  }
  
  private void post(LogHandler paramLogHandler, String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    this.client.asyncPost(paramLogHandler, paramString, paramArrayOfbyte, paramInt1, paramInt2, this.headers, this.token, this.totalSize, paramProgressHandler, paramCompletionHandler, paramUpCancellationSignal);
  }
  
  private void putChunk(String paramString1, long paramLong, int paramInt, String paramString2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("target_key", this.key);
    logHandler.send("up_type", "bput");
    logHandler.send("tid", Long.valueOf(Process.myTid()));
    logHandler.send("file_offset", Long.valueOf(paramLong));
    logHandler.send("bytes_total", Long.valueOf(paramInt));
    int i = (int)(paramLong % 4194304L);
    paramString2 = String.format(Locale.ENGLISH, "/bput/%s/%d", new Object[] { paramString2, Integer.valueOf(i) });
    try {
      this.file.seek(paramLong);
      this.file.read(this.chunkBuffer, 0, paramInt);
      this.crc32 = Crc32.bytes(this.chunkBuffer, 0, paramInt);
      post(logHandler, String.format("%s%s", new Object[] { paramString1, paramString2 }), this.chunkBuffer, 0, paramInt, paramProgressHandler, paramCompletionHandler, paramUpCancellationSignal);
      return;
    } catch (IOException iOException) {
      this.completionHandler.complete(this.key, ResponseInfo.fileError(iOException, this.token), null);
      return;
    } 
  }
  
  private void record(long paramLong) {
    if (this.config.recorder != null) {
      if (paramLong == 0L)
        return; 
      String str = String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", new Object[] { Long.valueOf(this.totalSize), Long.valueOf(paramLong), Long.valueOf(this.modifyTime), StringUtils.jsonJoin(this.contexts) });
      this.config.recorder.set(this.recorderKey, str.getBytes());
    } 
  }
  
  private long recoveryFromRecord() {
    if (this.config.recorder == null)
      return 0L; 
    byte[] arrayOfByte = this.config.recorder.get(this.recorderKey);
    if (arrayOfByte == null)
      return 0L; 
    String str = new String(arrayOfByte);
    try {
      JSONObject jSONObject = new JSONObject(str);
      long l1 = jSONObject.optLong("offset", 0L);
      long l2 = jSONObject.optLong("modify_time", 0L);
      long l3 = jSONObject.optLong("size", 0L);
      JSONArray jSONArray = jSONObject.optJSONArray("contexts");
      if (l1 != 0L && l2 == this.modifyTime && l3 == this.totalSize && jSONArray != null) {
        if (jSONArray.length() == 0)
          return 0L; 
        for (int i = 0; i < jSONArray.length(); i++)
          this.contexts[i] = jSONArray.optString(i); 
        return l1;
      } 
      return 0L;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return 0L;
    } 
  }
  
  private void removeRecord() {
    if (this.config.recorder != null)
      this.config.recorder.del(this.recorderKey); 
  }
  
  public void run() {
    long l = recoveryFromRecord();
    if (l > 0L)
      this.recover_from = l; 
    try {
      this.file = new RandomAccessFile(this.f, "r");
      nextTask(l, 0, this.config.zone.upHost(this.token.token, this.config.useHttps, null));
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      this.completionHandler.complete(this.key, ResponseInfo.fileError(fileNotFoundException, this.token), null);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\ResumeUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */