package com.qiniu.android.collect;

import com.qiniu.android.http.UserAgent;
import com.qiniu.android.storage.UpToken;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class UploadInfoCollector {
  private static OkHttpClient httpClient;
  
  private static UploadInfoCollector httpCollector;
  
  private static ExecutorService singleServer;
  
  private long lastUpload;
  
  private File recordFile = null;
  
  private final String recordFileName;
  
  private final String serverURL;
  
  private UploadInfoCollector(String paramString1, String paramString2) {
    this.recordFileName = paramString1;
    this.serverURL = paramString2;
    try {
      reset0();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void clean() {
    try {
      if (singleServer != null)
        singleServer.shutdown(); 
    } catch (Exception exception) {}
    singleServer = null;
    httpClient = null;
    try {
      getHttpCollector().clean0();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    httpCollector = null;
  }
  
  private void clean0() {
    try {
      if (this.recordFile != null) {
        this.recordFile.delete();
      } else {
        (new File(getRecordDir(Config.recordDir), this.recordFileName)).delete();
      } 
    } catch (Exception exception) {}
    this.recordFile = null;
  }
  
  private static OkHttpClient getHttpClient() {
    if (httpClient == null) {
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      builder.a(10L, TimeUnit.SECONDS);
      builder.b(15L, TimeUnit.SECONDS);
      builder.c(((Config.interval / 2 + 1) * 60 - 10), TimeUnit.SECONDS);
      httpClient = builder.b();
    } 
    return httpClient;
  }
  
  private static UploadInfoCollector getHttpCollector() {
    if (httpCollector == null)
      httpCollector = new UploadInfoCollector("_qiniu_record_file_hs5z9lo7anx03", "https://uplog.qbox.me/log/4"); 
    return httpCollector;
  }
  
  private File getRecordDir(String paramString) {
    return new File(paramString);
  }
  
  private void handle0(final UpToken upToken, final RecordMsg record) {
    ExecutorService executorService = singleServer;
    if (executorService != null && !executorService.isShutdown()) {
      Runnable runnable = new Runnable() {
          public void run() {
            if (Config.isRecord)
              try {
                return;
              } finally {
                Exception exception = null;
              }  
          }
        };
      singleServer.submit(runnable);
      if (Config.isUpload && !UpToken.isInvalid(upToken)) {
        Runnable runnable1 = new Runnable() {
            public void run() {
              if (Config.isRecord && Config.isUpload)
                try {
                  return;
                } finally {
                  Exception exception = null;
                }  
            }
          };
        singleServer.submit(runnable1);
      } 
    } 
  }
  
  public static void handleHttp(UpToken paramUpToken, RecordMsg paramRecordMsg) {
    try {
      return;
    } finally {
      paramUpToken = null;
    } 
  }
  
  public static void handleUpload(UpToken paramUpToken, RecordMsg paramRecordMsg) {
    handleHttp(paramUpToken, paramRecordMsg);
  }
  
  private void initRecordFile(File paramFile) throws IOException {
    if (paramFile != null) {
      if (!paramFile.exists()) {
        if (paramFile.mkdirs())
          return; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("mkdir failed: ");
        stringBuilder1.append(paramFile.getAbsolutePath());
        throw new IOException(stringBuilder1.toString());
      } 
      if (paramFile.isDirectory()) {
        this.recordFile = new File(paramFile, this.recordFileName);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramFile.getAbsolutePath());
      stringBuilder.append(" is not a dir");
      throw new IOException(stringBuilder.toString());
    } 
    throw new IOException("record's dir is not setted");
  }
  
  private boolean isOk(Response paramResponse) {
    return (paramResponse.d() && paramResponse.a("X-Reqid") != null);
  }
  
  public static void reset() {
    try {
      getHttpCollector().reset0();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void reset0() throws IOException {
    if (Config.isRecord)
      initRecordFile(getRecordDir(Config.recordDir)); 
    if (!Config.isRecord) {
      ExecutorService executorService = singleServer;
      if (executorService != null)
        executorService.shutdown(); 
    } 
    if (Config.isRecord) {
      ExecutorService executorService = singleServer;
      if (executorService == null || executorService.isShutdown())
        singleServer = Executors.newSingleThreadExecutor(); 
    } 
  }
  
  private void tryRecode(String paramString, File paramFile) {
    if (Config.isRecord && paramFile.length() < Config.maxRecordFileSize) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("\n");
      writeToFile(paramFile, stringBuilder.toString(), true);
    } 
  }
  
  private void tryUploadAndClean(UpToken paramUpToken, File paramFile) {
    if (Config.isUpload && paramFile.length() > Config.uploadThreshold) {
      long l = (new Date()).getTime();
      if (l > this.lastUpload + (Config.interval * 60 * 1000)) {
        this.lastUpload = l;
        if (upload(paramUpToken, paramFile)) {
          writeToFile(paramFile, "", false);
          writeToFile(paramFile, "", false);
        } 
      } 
    } 
  }
  
  private boolean upload(UpToken paramUpToken, File paramFile) {
    try {
      OkHttpClient okHttpClient = getHttpClient();
      RequestBody requestBody = RequestBody.create(MediaType.b("text/plain"), paramFile);
      Request.Builder builder = (new Request.Builder()).a(this.serverURL);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("UpToken ");
      stringBuilder.append(paramUpToken.token);
      null = builder.b("Authorization", stringBuilder.toString()).b("User-Agent", UserAgent.instance().getUa(paramUpToken.accessKey)).a(requestBody);
      String str = UploadInfoElement.x_log_client_id;
      if (str != "")
        null.b("X-Log-Client-Id", UploadInfoElement.x_log_client_id); 
      Response response = okHttpClient.a(null.d()).b();
      UploadInfoElement.x_log_client_id = response.a("X-Log-Client-Id");
      try {
        boolean bool = isOk(response);
      } finally {
        try {
          response.h().close();
        } catch (Exception exception) {}
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  private static void writeToFile(File paramFile, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore #5
    //   6: aconst_null
    //   7: astore_3
    //   8: new java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: iload_2
    //   14: invokespecial <init> : (Ljava/io/File;Z)V
    //   17: astore_0
    //   18: aload_0
    //   19: aload_1
    //   20: ldc_w 'UTF-8'
    //   23: invokestatic forName : (Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   26: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   29: invokevirtual write : ([B)V
    //   32: aload_0
    //   33: invokevirtual flush : ()V
    //   36: aload_0
    //   37: invokevirtual close : ()V
    //   40: return
    //   41: astore_1
    //   42: goto -> 96
    //   45: astore_1
    //   46: goto -> 63
    //   49: astore_1
    //   50: goto -> 82
    //   53: astore_1
    //   54: aload_3
    //   55: astore_0
    //   56: goto -> 96
    //   59: astore_1
    //   60: aload #4
    //   62: astore_0
    //   63: aload_0
    //   64: astore_3
    //   65: aload_1
    //   66: invokevirtual printStackTrace : ()V
    //   69: aload_0
    //   70: ifnull -> 95
    //   73: aload_0
    //   74: invokevirtual close : ()V
    //   77: return
    //   78: astore_1
    //   79: aload #5
    //   81: astore_0
    //   82: aload_0
    //   83: astore_3
    //   84: aload_1
    //   85: invokevirtual printStackTrace : ()V
    //   88: aload_0
    //   89: ifnull -> 95
    //   92: goto -> 73
    //   95: return
    //   96: aload_0
    //   97: ifnull -> 104
    //   100: aload_0
    //   101: invokevirtual close : ()V
    //   104: aload_1
    //   105: athrow
    //   106: astore_0
    //   107: return
    //   108: astore_0
    //   109: goto -> 104
    // Exception table:
    //   from	to	target	type
    //   8	18	78	java/io/FileNotFoundException
    //   8	18	59	java/io/IOException
    //   8	18	53	finally
    //   18	36	49	java/io/FileNotFoundException
    //   18	36	45	java/io/IOException
    //   18	36	41	finally
    //   36	40	106	java/io/IOException
    //   65	69	53	finally
    //   73	77	106	java/io/IOException
    //   84	88	53	finally
    //   100	104	108	java/io/IOException
  }
  
  public static abstract class RecordMsg {
    public abstract String toRecordMsg();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\collect\UploadInfoCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */