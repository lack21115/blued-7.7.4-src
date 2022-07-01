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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResumeUploaderFast implements Runnable {
  private Map<Long, Integer> blockInfo;
  
  private final Client client;
  
  private final UpCompletionHandler completionHandler;
  
  private final Configuration config;
  
  private final String[] contexts;
  
  private final int domainRetry = 3;
  
  private File f;
  
  private RandomAccessFile file;
  
  private final StringMap headers;
  
  private boolean isFirstTask = true;
  
  private boolean isInterrupted = false;
  
  private final String key;
  
  private final long modifyTime;
  
  private int multithread;
  
  private Long[] offsets;
  
  private final UploadOptions options;
  
  private final String recorderKey;
  
  private long recover_from;
  
  AtomicInteger retried = new AtomicInteger(0);
  
  AtomicInteger singleDomainRetry = new AtomicInteger(0);
  
  AtomicInteger tblock;
  
  private UpToken token;
  
  private final long totalSize;
  
  private int upBlock = 0;
  
  AtomicReference upHost = new AtomicReference();
  
  ResumeUploaderFast(Client paramClient, Configuration paramConfiguration, File paramFile, String paramString1, UpToken paramUpToken, final UpCompletionHandler completionHandler, UploadOptions paramUploadOptions, String paramString2, int paramInt) {
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
    this.multithread = paramInt;
    this.completionHandler = new UpCompletionHandler() {
        public void complete(String param1String, ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
          // Byte code:
          //   0: aload_0
          //   1: getfield this$0 : Lcom/qiniu/android/storage/ResumeUploaderFast;
          //   4: invokestatic access$000 : (Lcom/qiniu/android/storage/ResumeUploaderFast;)Ljava/io/RandomAccessFile;
          //   7: ifnull -> 30
          //   10: aload_0
          //   11: getfield this$0 : Lcom/qiniu/android/storage/ResumeUploaderFast;
          //   14: invokestatic access$000 : (Lcom/qiniu/android/storage/ResumeUploaderFast;)Ljava/io/RandomAccessFile;
          //   17: invokevirtual close : ()V
          //   20: goto -> 30
          //   23: astore #4
          //   25: aload #4
          //   27: invokevirtual printStackTrace : ()V
          //   30: aload_0
          //   31: monitorenter
          //   32: aload_0
          //   33: getfield this$0 : Lcom/qiniu/android/storage/ResumeUploaderFast;
          //   36: invokestatic access$100 : (Lcom/qiniu/android/storage/ResumeUploaderFast;)Z
          //   39: ifne -> 66
          //   42: aload_0
          //   43: getfield this$0 : Lcom/qiniu/android/storage/ResumeUploaderFast;
          //   46: iconst_1
          //   47: invokestatic access$102 : (Lcom/qiniu/android/storage/ResumeUploaderFast;Z)Z
          //   50: pop
          //   51: aload_0
          //   52: getfield val$completionHandler : Lcom/qiniu/android/storage/UpCompletionHandler;
          //   55: aload_1
          //   56: aload_2
          //   57: aload_3
          //   58: invokeinterface complete : (Ljava/lang/String;Lcom/qiniu/android/http/ResponseInfo;Lorg/json/JSONObject;)V
          //   63: aload_0
          //   64: monitorexit
          //   65: return
          //   66: aload_0
          //   67: monitorexit
          //   68: return
          //   69: astore_1
          //   70: aload_0
          //   71: monitorexit
          //   72: aload_1
          //   73: athrow
          // Exception table:
          //   from	to	target	type
          //   10	20	23	java/io/IOException
          //   32	65	69	finally
          //   66	68	69	finally
          //   70	72	69	finally
        }
      };
    if (paramUploadOptions == null)
      paramUploadOptions = UploadOptions.defaultOptions(); 
    this.options = paramUploadOptions;
    this.tblock = new AtomicInteger((int)(this.totalSize + 4194304L - 1L) / 4194304);
    this.offsets = new Long[this.tblock.get()];
    this.contexts = new String[this.tblock.get()];
    this.modifyTime = paramFile.lastModified();
    this.token = paramUpToken;
    this.blockInfo = new LinkedHashMap<Long, Integer>();
  }
  
  private boolean checkRetried() {
    return (this.retried.get() < 3);
  }
  
  private BlockElement getBlockInfo() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield blockInfo : Ljava/util/Map;
    //   6: invokeinterface entrySet : ()Ljava/util/Set;
    //   11: invokeinterface iterator : ()Ljava/util/Iterator;
    //   16: astore #4
    //   18: lconst_0
    //   19: lstore_2
    //   20: iconst_0
    //   21: istore_1
    //   22: aload #4
    //   24: invokeinterface hasNext : ()Z
    //   29: ifeq -> 86
    //   32: aload #4
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: checkcast java/util/Map$Entry
    //   42: astore #4
    //   44: aload #4
    //   46: invokeinterface getKey : ()Ljava/lang/Object;
    //   51: checkcast java/lang/Long
    //   54: invokevirtual longValue : ()J
    //   57: lstore_2
    //   58: aload #4
    //   60: invokeinterface getValue : ()Ljava/lang/Object;
    //   65: checkcast java/lang/Integer
    //   68: invokevirtual intValue : ()I
    //   71: istore_1
    //   72: aload_0
    //   73: getfield blockInfo : Ljava/util/Map;
    //   76: lload_2
    //   77: invokestatic valueOf : (J)Ljava/lang/Long;
    //   80: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: new com/qiniu/android/storage/ResumeUploaderFast$BlockElement
    //   89: dup
    //   90: aload_0
    //   91: lload_2
    //   92: iload_1
    //   93: invokespecial <init> : (Lcom/qiniu/android/storage/ResumeUploaderFast;JI)V
    //   96: astore #4
    //   98: aload_0
    //   99: monitorexit
    //   100: aload #4
    //   102: areturn
    //   103: astore #4
    //   105: aload_0
    //   106: monitorexit
    //   107: aload #4
    //   109: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	103	finally
    //   22	86	103	finally
    //   86	98	103	finally
  }
  
  private CompletionHandler getCompletionHandler(final long offset, final int blockSize, final long crc32) {
    return new CompletionHandler() {
        public void complete(final ResponseInfo info, JSONObject param1JSONObject) {
          final long tid = Process.myTid();
          UploadInfoCollector.handleHttp(ResumeUploaderFast.this.token, new UploadInfoCollector.RecordMsg() {
                public String toRecordMsg() {
                  LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getBlockInfo());
                  UpToken.setCurrent_region_id(logHandler, ResumeUploaderFast.this.upHost.get().toString());
                  logHandler.send("target_region_id", DnsPrefetcher.target_region_id);
                  logHandler.send("total_elapsed_time", Long.valueOf(info.duration));
                  logHandler.send("bytes_sent", Long.valueOf(info.sent));
                  logHandler.send("recovered_from", Long.valueOf(ResumeUploaderFast.this.recover_from));
                  logHandler.send("file_size", Long.valueOf(ResumeUploaderFast.this.totalSize));
                  logHandler.send("pid", Long.valueOf(Process.myPid()));
                  logHandler.send("tid", Long.valueOf(tid));
                  logHandler.send("up_api_version", Integer.valueOf(1));
                  logHandler.send("up_time", Long.valueOf(System.currentTimeMillis() / 1000L));
                  return Json.object2Json(logHandler.getUploadInfo());
                }
              });
          if (info.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
            ResumeUploaderFast.this.options.netReadyHandler.waitReady();
            if (!AndroidNetwork.isNetWorkReady()) {
              ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, info, param1JSONObject);
              return;
            } 
          } 
          if (info.isCancelled()) {
            ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, info, param1JSONObject);
            return;
          } 
          if (!ResumeUploaderFast.this.isChunkOK(info, param1JSONObject)) {
            ResumeUploaderFast resumeUploaderFast;
            if (info.statusCode == 701 && ResumeUploaderFast.this.checkRetried()) {
              ResumeUploaderFast.this.updateRetried();
              resumeUploaderFast = ResumeUploaderFast.this;
              resumeUploaderFast.mkblk(offset, blockSize, resumeUploaderFast.upHost.get().toString());
              return;
            } 
            if (ResumeUploaderFast.this.upHost != null && (ResumeUploaderFast.this.isNotChunkToQiniu((ResponseInfo)resumeUploaderFast, param1JSONObject) || resumeUploaderFast.needRetry()) && ResumeUploaderFast.this.checkRetried()) {
              ResumeUploaderFast.this.updateRetried();
              resumeUploaderFast = ResumeUploaderFast.this;
              resumeUploaderFast.mkblk(offset, blockSize, resumeUploaderFast.upHost.get().toString());
              return;
            } 
            ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, (ResponseInfo)resumeUploaderFast, param1JSONObject);
            return;
          } 
          if (param1JSONObject == null && ResumeUploaderFast.this.checkRetried()) {
            ResumeUploaderFast.this.updateRetried();
            ResumeUploaderFast resumeUploaderFast = ResumeUploaderFast.this;
            resumeUploaderFast.mkblk(offset, blockSize, resumeUploaderFast.upHost.get().toString());
            return;
          } 
          exception = null;
          try {
            String str = param1JSONObject.getString("ctx");
            try {
              l = param1JSONObject.getLong("crc32");
            } catch (Exception exception1) {}
          } catch (Exception exception) {
            Object object = null;
          } 
          exception.printStackTrace();
          l = 0L;
        }
      };
  }
  
  private CompletionHandler getMkfileCompletionHandler() {
    return new CompletionHandler() {
        public void complete(ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
          ResumeUploaderFast resumeUploaderFast;
          if (param1ResponseInfo.isNetworkBroken() && !AndroidNetwork.isNetWorkReady()) {
            ResumeUploaderFast.this.options.netReadyHandler.waitReady();
            if (!AndroidNetwork.isNetWorkReady()) {
              ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, param1ResponseInfo, param1JSONObject);
              return;
            } 
          } 
          if (param1ResponseInfo.isOK()) {
            ResumeUploaderFast.this.removeRecord();
            ResumeUploaderFast.this.options.progressHandler.progress(ResumeUploaderFast.this.key, 1.0D);
            ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, param1ResponseInfo, param1JSONObject);
            return;
          } 
          if (param1ResponseInfo.needRetry() && ResumeUploaderFast.this.retried.get() < ResumeUploaderFast.this.config.retryMax + 1) {
            resumeUploaderFast = ResumeUploaderFast.this;
            resumeUploaderFast.makeFile(resumeUploaderFast.upHost.get().toString(), ResumeUploaderFast.this.getMkfileCompletionHandler(), ResumeUploaderFast.this.options.cancellationSignal);
            ResumeUploaderFast.this.retried.addAndGet(1);
            return;
          } 
          ResumeUploaderFast.this.completionHandler.complete(ResumeUploaderFast.this.key, (ResponseInfo)resumeUploaderFast, param1JSONObject);
        }
      };
  }
  
  private ProgressHandler getProgressHandler() {
    return new ProgressHandler() {
        public void onProgress(long param1Long1, long param1Long2) {
          Long[] arrayOfLong = ResumeUploaderFast.this.offsets;
          int j = arrayOfLong.length;
          int i = 0;
          for (param1Long1 = 0L; i < j; param1Long1 = l) {
            Long long_ = arrayOfLong[i];
            long l = param1Long1;
            if (long_ != null) {
              l = param1Long1;
              if (long_.longValue() > 0L)
                l = param1Long1 + 1L; 
            } 
            i++;
          } 
          double d2 = param1Long1 * 4194304.0D / param1Long2;
          double d1 = d2;
          if (d2 > 0.95D)
            d1 = 0.95D; 
          ResumeUploaderFast.this.options.progressHandler.progress(ResumeUploaderFast.this.key, d1);
        }
      };
  }
  
  private boolean isChunkOK(ResponseInfo paramResponseInfo, JSONObject paramJSONObject) {
    return (paramResponseInfo.statusCode == 200 && paramResponseInfo.error == null && (paramResponseInfo.hasReqId() || isChunkResOK(paramJSONObject)));
  }
  
  private boolean isChunkResOK(JSONObject paramJSONObject) {
    try {
      paramJSONObject.getString("ctx");
      paramJSONObject.getLong("crc32");
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private boolean isNotChunkToQiniu(ResponseInfo paramResponseInfo, JSONObject paramJSONObject) {
    return (paramResponseInfo.statusCode < 500 && paramResponseInfo.statusCode >= 200 && !paramResponseInfo.hasReqId() && !isChunkResOK(paramJSONObject));
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
    logHandler.send("bytes_total", Long.valueOf(arrayOfByte.length));
    post(logHandler, paramString, arrayOfByte, 0, arrayOfByte.length, null, paramCompletionHandler, paramUpCancellationSignal);
  }
  
  private void mkblk(long paramLong, int paramInt, String paramString) {
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("target_key", this.key);
    logHandler.send("up_type", "mkblk");
    logHandler.send("tid", Long.valueOf(Process.myTid()));
    logHandler.send("file_offset", Long.valueOf(paramLong));
    logHandler.send("bytes_total", Long.valueOf(paramInt));
    String str = String.format(Locale.ENGLISH, "/mkblk/%d", new Object[] { Integer.valueOf(paramInt) });
    byte[] arrayOfByte = new byte[paramInt];
    /* monitor enter ThisExpression{ObjectType{com/qiniu/android/storage/ResumeUploaderFast}} */
    try {
      this.file.seek(paramLong);
      this.file.read(arrayOfByte, 0, paramInt);
      /* monitor exit ThisExpression{ObjectType{com/qiniu/android/storage/ResumeUploaderFast}} */
      long l = Crc32.bytes(arrayOfByte, 0, paramInt);
      post(logHandler, String.format("%s%s", new Object[] { paramString, str }), arrayOfByte, 0, paramInt, getProgressHandler(), getCompletionHandler(paramLong, paramInt, l), this.options.cancellationSignal);
      return;
    } catch (IOException iOException) {
      this.completionHandler.complete(this.key, ResponseInfo.fileError(iOException, this.token), null);
      /* monitor exit ThisExpression{ObjectType{com/qiniu/android/storage/ResumeUploaderFast}} */
      return;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/qiniu/android/storage/ResumeUploaderFast}} */
    throw paramString;
  }
  
  private void post(LogHandler paramLogHandler, String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ProgressHandler paramProgressHandler, CompletionHandler paramCompletionHandler, UpCancellationSignal paramUpCancellationSignal) {
    this.client.asyncPost(paramLogHandler, paramString, paramArrayOfbyte, paramInt1, paramInt2, this.headers, this.token, this.totalSize, paramProgressHandler, paramCompletionHandler, paramUpCancellationSignal);
  }
  
  private void putBlockInfo() {
    Long[] arrayOfLong = recoveryFromRecord();
    int j = this.tblock.get() - 1;
    boolean bool = false;
    int i = 0;
    Integer integer = Integer.valueOf(4194304);
    if (arrayOfLong == null) {
      this.recover_from = 0L;
      while (i < j) {
        this.blockInfo.put(Long.valueOf(i * 4194304L), integer);
        i++;
      } 
      this.blockInfo.put(Long.valueOf(j * 4194304L), Integer.valueOf((int)(this.totalSize - (j * 4194304))));
      return;
    } 
    this.recover_from = (arrayOfLong.length * 4194304);
    HashSet hashSet = new HashSet(Arrays.asList((Object[])arrayOfLong));
    for (i = bool; i < j; i++) {
      Long long_1 = Long.valueOf(i * 4194304L);
      if (!hashSet.contains(long_1)) {
        this.blockInfo.put(long_1, integer);
      } else {
        this.offsets[i] = long_1;
        this.upBlock++;
      } 
    } 
    Long long_ = Long.valueOf(j * 4194304L);
    if (!hashSet.contains(long_)) {
      this.blockInfo.put(long_, Integer.valueOf((int)(this.totalSize - (j * 4194304))));
      return;
    } 
    this.offsets[j] = long_;
    this.upBlock++;
  }
  
  private void record(Long[] paramArrayOfLong) {
    if (this.config.recorder != null) {
      if (paramArrayOfLong.length == 0)
        return; 
      String str = String.format(Locale.ENGLISH, "{\"size\":%d,\"offsets\":[%s], \"modify_time\":%d, \"contexts\":[%s]}", new Object[] { Long.valueOf(this.totalSize), StringUtils.jsonJoin(paramArrayOfLong), Long.valueOf(this.modifyTime), StringUtils.jsonJoin(this.contexts) });
      this.config.recorder.set(this.recorderKey, str.getBytes());
    } 
  }
  
  private Long[] recoveryFromRecord() {
    if (this.config.recorder == null)
      return null; 
    byte[] arrayOfByte = this.config.recorder.get(this.recorderKey);
    if (arrayOfByte == null)
      return null; 
    String str = new String(arrayOfByte);
    try {
      JSONObject jSONObject = new JSONObject(str);
      JSONArray jSONArray1 = jSONObject.optJSONArray("offsets");
      long l1 = jSONObject.optLong("modify_time", 0L);
      long l2 = jSONObject.optLong("size", 0L);
      JSONArray jSONArray2 = jSONObject.optJSONArray("contexts");
      if (jSONArray1.length() != 0 && l1 == this.modifyTime && l2 == this.totalSize && jSONArray2 != null) {
        int j;
        if (jSONArray2.length() == 0)
          return null; 
        byte b = 0;
        int i = 0;
        while (true) {
          j = b;
          if (i < jSONArray2.length()) {
            this.contexts[i] = jSONArray2.optString(i);
            i++;
            continue;
          } 
          break;
        } 
        while (j < jSONArray2.length()) {
          String str1 = jSONArray1.optString(j);
          if (str1 != null && !str1.equals("null"))
            this.offsets[j] = Long.valueOf(Long.parseLong(str1)); 
          j++;
        } 
        return this.offsets;
      } 
      return null;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return null;
    } 
  }
  
  private void removeRecord() {
    if (this.config.recorder != null)
      this.config.recorder.del(this.recorderKey); 
  }
  
  private void updateRetried() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield singleDomainRetry : Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual get : ()I
    //   9: aload_0
    //   10: getfield config : Lcom/qiniu/android/storage/Configuration;
    //   13: getfield retryMax : I
    //   16: if_icmpge -> 31
    //   19: aload_0
    //   20: getfield singleDomainRetry : Ljava/util/concurrent/atomic/AtomicInteger;
    //   23: iconst_1
    //   24: invokevirtual getAndAdd : (I)I
    //   27: pop
    //   28: goto -> 102
    //   31: aload_0
    //   32: getfield retried : Ljava/util/concurrent/atomic/AtomicInteger;
    //   35: invokevirtual get : ()I
    //   38: iconst_3
    //   39: if_icmpge -> 102
    //   42: aload_0
    //   43: getfield singleDomainRetry : Ljava/util/concurrent/atomic/AtomicInteger;
    //   46: iconst_1
    //   47: invokevirtual getAndSet : (I)I
    //   50: pop
    //   51: aload_0
    //   52: getfield retried : Ljava/util/concurrent/atomic/AtomicInteger;
    //   55: iconst_1
    //   56: invokevirtual getAndAdd : (I)I
    //   59: pop
    //   60: aload_0
    //   61: getfield upHost : Ljava/util/concurrent/atomic/AtomicReference;
    //   64: aload_0
    //   65: getfield config : Lcom/qiniu/android/storage/Configuration;
    //   68: getfield zone : Lcom/qiniu/android/common/Zone;
    //   71: aload_0
    //   72: getfield token : Lcom/qiniu/android/storage/UpToken;
    //   75: getfield token : Ljava/lang/String;
    //   78: aload_0
    //   79: getfield config : Lcom/qiniu/android/storage/Configuration;
    //   82: getfield useHttps : Z
    //   85: aload_0
    //   86: getfield upHost : Ljava/util/concurrent/atomic/AtomicReference;
    //   89: invokevirtual get : ()Ljava/lang/Object;
    //   92: invokevirtual toString : ()Ljava/lang/String;
    //   95: invokevirtual upHost : (Ljava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   98: invokevirtual getAndSet : (Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	105	finally
    //   31	102	105	finally
  }
  
  public void run() {
    try {
      this.file = new RandomAccessFile(this.f, "r");
      putBlockInfo();
      this.upHost.set(this.config.zone.upHost(this.token.token, this.config.useHttps, null));
      if (this.blockInfo.size() < this.multithread)
        this.multithread = this.blockInfo.size(); 
      for (int i = 0; i < this.multithread; i++) {
        BlockElement blockElement = getBlockInfo();
        (new UploadThread(blockElement.getOffset(), blockElement.getBlocksize(), this.upHost.get().toString())).start();
      } 
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      this.completionHandler.complete(this.key, ResponseInfo.fileError(fileNotFoundException, this.token), null);
      return;
    } 
  }
  
  class BlockElement {
    private int blocksize;
    
    private long offset;
    
    BlockElement(long param1Long, int param1Int) {
      this.offset = param1Long;
      this.blocksize = param1Int;
    }
    
    public int getBlocksize() {
      return this.blocksize;
    }
    
    public long getOffset() {
      return this.offset;
    }
  }
  
  class UploadThread extends Thread {
    private int blockSize;
    
    private long offset;
    
    private String upHost;
    
    UploadThread(long param1Long, int param1Int, String param1String) {
      this.offset = param1Long;
      this.blockSize = param1Int;
      this.upHost = param1String;
    }
    
    public void run() {
      super.run();
      ResumeUploaderFast.this.mkblk(this.offset, this.blockSize, this.upHost);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\ResumeUploaderFast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */