package com.blued.android.framework.utils;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.Zip;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.BluedQiniuToken;
import com.blued.android.framework.utils.upload.QiniuUpload;
import com.blued.android.framework.utils.upload.QiniuUploadExtra;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.qiniu.android.storage.Configuration;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LogUploadHelper {
  private ExecutorService a = Executors.newSingleThreadExecutor();
  
  private Future<?> b;
  
  private boolean c = false;
  
  private Application d;
  
  private File e;
  
  private String f;
  
  private OnUploadListener g;
  
  private String h;
  
  public LogUploadHelper(Application paramApplication) {
    this.d = paramApplication;
  }
  
  private void a() {
    b();
    this.e = c();
    File file = this.e;
    if (file == null || !file.exists()) {
      e();
      return;
    } 
    Logger.a("LogUploadHelper", new Object[] { "uploadFile.size=", Long.valueOf(this.e.length()), "\n  path=", this.e.getPath() });
    d();
  }
  
  private void a(Configuration paramConfiguration, String paramString1, String paramString2) {
    QiniuUploadTools.a(paramConfiguration, this.e, paramString1, paramString2, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {
            Logger.b("LogUploadHelper", new Object[] { "uploadQiNiu = onFailure", param1String });
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    LogUploadHelper.b(this.a.a);
                  }
                });
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            Logger.b("LogUploadHelper", new Object[] { "uploadQiNiu = onSuccess", param1String1 });
            AppInfo.n().post(new Runnable(this, param1String1) {
                  public void run() {
                    if (TextUtils.isEmpty(this.a)) {
                      LogUploadHelper.b(this.b.a);
                      return;
                    } 
                    LogUploadHelper.a(this.b.a, this.a);
                  }
                });
          }
          
          public boolean a() {
            Logger.b("LogUploadHelper", new Object[] { "uploadQiNiu = isCanceled", Boolean.valueOf(LogUploadHelper.c(this.a) ^ true) });
            return LogUploadHelper.c(this.a) ^ true;
          }
        });
  }
  
  private void a(String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("zip", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f);
    stringBuilder.append("/blued/zip");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<UploadZipResult>>(this, null) {
          protected void a(BluedEntityA<LogUploadHelper.UploadZipResult> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              LogUploadHelper.UploadZipResult uploadZipResult = param1BluedEntityA.data.get(0);
              if (uploadZipResult == null || TextUtils.isEmpty(uploadZipResult.zip)) {
                Logger.d("LogUploadHelper", new Object[] { "upload result zip is empty!!" });
                LogUploadHelper.b(this.a);
                return;
              } 
              if (LogUploadHelper.d(this.a) != null) {
                LogUploadHelper.d(this.a).a(uploadZipResult.zip);
                return;
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            LogUploadHelper.b(this.a);
            return super.onUIFailure(param1Int, param1String);
          }
        }).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  private boolean b() {
    // Byte code:
    //   0: ldc 'mounted'
    //   2: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   5: invokevirtual equals : (Ljava/lang/Object;)Z
    //   8: istore_1
    //   9: iconst_0
    //   10: istore #4
    //   12: iload_1
    //   13: ifne -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield d : Landroid/app/Application;
    //   22: invokestatic a : (Landroid/content/Context;)Ljava/io/File;
    //   25: astore #8
    //   27: aload #8
    //   29: invokevirtual exists : ()Z
    //   32: ifne -> 41
    //   35: aload #8
    //   37: invokevirtual mkdirs : ()Z
    //   40: pop
    //   41: new java/io/File
    //   44: dup
    //   45: aload #8
    //   47: ldc 'blued_core.txt'
    //   49: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   52: astore #5
    //   54: invokestatic d : ()Landroid/content/Context;
    //   57: ldc 'blued_core.txt'
    //   59: invokevirtual getExternalFilesDir : (Ljava/lang/String;)Ljava/io/File;
    //   62: astore #6
    //   64: ldc 'LogUploadHelper'
    //   66: iconst_4
    //   67: anewarray java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: ldc 'copyDebugFileToExternal:'
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload #5
    //   79: invokevirtual getPath : ()Ljava/lang/String;
    //   82: aastore
    //   83: dup
    //   84: iconst_2
    //   85: ldc ' -> '
    //   87: aastore
    //   88: dup
    //   89: iconst_3
    //   90: aload #6
    //   92: aastore
    //   93: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload #5
    //   98: invokevirtual exists : ()Z
    //   101: ifeq -> 143
    //   104: aload #5
    //   106: invokevirtual getPath : ()Ljava/lang/String;
    //   109: aload #6
    //   111: invokevirtual getPath : ()Ljava/lang/String;
    //   114: iconst_1
    //   115: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Z)Z
    //   118: istore_1
    //   119: ldc 'LogUploadHelper'
    //   121: iconst_2
    //   122: anewarray java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: ldc 'copyDebugFileToExternal:'
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: iload_1
    //   133: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   136: aastore
    //   137: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: goto -> 145
    //   143: iconst_0
    //   144: istore_1
    //   145: new java/io/File
    //   148: dup
    //   149: aload #8
    //   151: ldc 'blued_chat.txt'
    //   153: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   156: astore #5
    //   158: invokestatic d : ()Landroid/content/Context;
    //   161: ldc 'blued_chat.txt'
    //   163: invokevirtual getExternalFilesDir : (Ljava/lang/String;)Ljava/io/File;
    //   166: astore #6
    //   168: ldc 'LogUploadHelper'
    //   170: iconst_4
    //   171: anewarray java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: ldc 'copyDebugFileToExternal:'
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload #5
    //   183: invokevirtual getPath : ()Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: ldc ' -> '
    //   191: aastore
    //   192: dup
    //   193: iconst_3
    //   194: aload #6
    //   196: aastore
    //   197: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload #5
    //   202: invokevirtual exists : ()Z
    //   205: ifeq -> 247
    //   208: aload #5
    //   210: invokevirtual getPath : ()Ljava/lang/String;
    //   213: aload #6
    //   215: invokevirtual getPath : ()Ljava/lang/String;
    //   218: iconst_1
    //   219: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Z)Z
    //   222: istore_2
    //   223: ldc 'LogUploadHelper'
    //   225: iconst_2
    //   226: anewarray java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: ldc 'copyDebugFileToExternal:'
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: iload_2
    //   237: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   240: aastore
    //   241: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: goto -> 249
    //   247: iconst_0
    //   248: istore_2
    //   249: aload_0
    //   250: getfield h : Ljava/lang/String;
    //   253: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   256: ifne -> 439
    //   259: aconst_null
    //   260: astore #7
    //   262: aconst_null
    //   263: astore #6
    //   265: aload #6
    //   267: astore #5
    //   269: new java/io/File
    //   272: dup
    //   273: aload #8
    //   275: ldc 'blued_extra.txt'
    //   277: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   280: astore #8
    //   282: aload #6
    //   284: astore #5
    //   286: aload #8
    //   288: invokevirtual exists : ()Z
    //   291: ifeq -> 304
    //   294: aload #6
    //   296: astore #5
    //   298: aload #8
    //   300: invokevirtual delete : ()Z
    //   303: pop
    //   304: aload #6
    //   306: astore #5
    //   308: aload #8
    //   310: invokevirtual createNewFile : ()Z
    //   313: pop
    //   314: aload #6
    //   316: astore #5
    //   318: new java/io/FileOutputStream
    //   321: dup
    //   322: aload #8
    //   324: invokespecial <init> : (Ljava/io/File;)V
    //   327: astore #6
    //   329: aload #6
    //   331: aload_0
    //   332: getfield h : Ljava/lang/String;
    //   335: ldc 'UTF-8'
    //   337: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   340: invokevirtual write : ([B)V
    //   343: aload #6
    //   345: invokevirtual flush : ()V
    //   348: aload #6
    //   350: invokevirtual close : ()V
    //   353: aload #6
    //   355: invokestatic a : (Ljava/io/OutputStream;)V
    //   358: goto -> 408
    //   361: astore #7
    //   363: aload #6
    //   365: astore #5
    //   367: aload #7
    //   369: astore #6
    //   371: goto -> 431
    //   374: astore #7
    //   376: goto -> 394
    //   379: astore #6
    //   381: goto -> 431
    //   384: astore #5
    //   386: aload #7
    //   388: astore #6
    //   390: aload #5
    //   392: astore #7
    //   394: aload #6
    //   396: astore #5
    //   398: aload #7
    //   400: invokevirtual printStackTrace : ()V
    //   403: aload #6
    //   405: invokestatic a : (Ljava/io/OutputStream;)V
    //   408: ldc 'LogUploadHelper'
    //   410: iconst_2
    //   411: anewarray java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: ldc_w 'write: '
    //   419: aastore
    //   420: dup
    //   421: iconst_1
    //   422: ldc 'blued_extra.txt'
    //   424: aastore
    //   425: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: goto -> 439
    //   431: aload #5
    //   433: invokestatic a : (Ljava/io/OutputStream;)V
    //   436: aload #6
    //   438: athrow
    //   439: iload #4
    //   441: istore_3
    //   442: iload_1
    //   443: ifeq -> 455
    //   446: iload #4
    //   448: istore_3
    //   449: iload_2
    //   450: ifeq -> 455
    //   453: iconst_1
    //   454: istore_3
    //   455: iload_3
    //   456: ireturn
    // Exception table:
    //   from	to	target	type
    //   269	282	384	java/io/IOException
    //   269	282	379	finally
    //   286	294	384	java/io/IOException
    //   286	294	379	finally
    //   298	304	384	java/io/IOException
    //   298	304	379	finally
    //   308	314	384	java/io/IOException
    //   308	314	379	finally
    //   318	329	384	java/io/IOException
    //   318	329	379	finally
    //   329	353	374	java/io/IOException
    //   329	353	361	finally
    //   398	403	379	finally
  }
  
  private File c() {
    File file2 = AppInfo.a((Context)this.d);
    File file1 = new File(this.d.getFilesDir(), "blued_log.zip");
    if (file1.exists())
      file1.delete(); 
    try {
      Zip.b(file2.getPath(), file1.getPath());
      return file1;
    } catch (Exception exception) {
      exception.printStackTrace();
      return file1;
    } 
  }
  
  private void d() {
    Map map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f);
    stringBuilder.append("/blued/qiniu?filter=token&action=zip");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)new BluedUIHttpResponse<BluedEntity<BluedQiniuToken, QiniuUploadExtra>>(this, null) {
          public boolean onUIFailure(int param1Int, String param1String) {
            LogUploadHelper.b(this.a);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity<BluedQiniuToken, QiniuUploadExtra> param1BluedEntity) {
            if (param1BluedEntity.hasData()) {
              Configuration configuration;
              BluedQiniuToken bluedQiniuToken = param1BluedEntity.data.get(0);
              if (bluedQiniuToken == null || TextUtils.isEmpty(bluedQiniuToken.key) || TextUtils.isEmpty(bluedQiniuToken.token)) {
                Logger.d("LogUploadHelper", new Object[] { "token is empty!!" });
                LogUploadHelper.b(this.a);
                return;
              } 
              QiniuUploadExtra qiniuUploadExtra = (QiniuUploadExtra)param1BluedEntity.extra;
              BluedEntity<BluedQiniuToken, QiniuUploadExtra> bluedEntity = null;
              param1BluedEntity = bluedEntity;
              if (qiniuUploadExtra != null) {
                QiniuUpload qiniuUpload = qiniuUploadExtra.upload;
                param1BluedEntity = bluedEntity;
                if (qiniuUpload != null)
                  configuration = QiniuUploadTools.a(qiniuUpload.host, qiniuUpload.backup); 
              } 
              LogUploadHelper.a(this.a, configuration, bluedQiniuToken.key, bluedQiniuToken.token);
              return;
            } 
          }
        }).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  private void e() {
    OnUploadListener onUploadListener = this.g;
    if (onUploadListener != null)
      onUploadListener.a(); 
  }
  
  public void a(String paramString1, String paramString2, OnUploadListener paramOnUploadListener) {
    this.f = paramString1;
    this.h = paramString2;
    this.g = paramOnUploadListener;
    if (this.b == null)
      this.b = this.a.submit(new Runnable(this) {
            public void run() {
              LogUploadHelper.a(this.a, true);
              LogUploadHelper.a(this.a);
            }
          }); 
  }
  
  public static interface OnUploadListener {
    void a();
    
    void a(String param1String);
  }
  
  public static class UploadZipResult {
    String zip;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\LogUploadHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */