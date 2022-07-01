package com.blued.android.module.media.selector.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.media.selector.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class Tools {
  public static final String a;
  
  private static final String b = Tools.class.getSimpleName();
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(FileUtils.a);
    stringBuilder.append("/blued/BLPlayer");
    a = stringBuilder.toString();
  }
  
  public static final Dialog a(Context paramContext) {
    Dialog dialog = new Dialog(paramContext, R.style.TranslucentBackground);
    dialog.setContentView(R.layout.common_loading_layout);
    StatusBarHelper.a(dialog.getWindow());
    dialog.setCancelable(true);
    return dialog;
  }
  
  public static String a(long paramLong) {
    try {
      return (new DecimalFormat("##########0.0")).format(paramLong * 1.0D / 1000.0D);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean) {
    if (!StringUtils.a(paramString)) {
      Uri uri;
      if (Build.VERSION.SDK_INT <= 19) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        uri = Uri.fromFile(new File(paramString));
        intent.addFlags(1);
        intent.addFlags(2);
        intent.setData(uri);
        paramContext.sendBroadcast(intent);
        if (paramBoolean) {
          AppMethods.a(paramContext.getResources().getString(R.string.video_save));
          return;
        } 
      } else {
        -$$Lambda$Tools$OyD9YUPft93crDoDN4CypFbojuk -$$Lambda$Tools$OyD9YUPft93crDoDN4CypFbojuk = new -$$Lambda$Tools$OyD9YUPft93crDoDN4CypFbojuk(paramBoolean, paramContext);
        MediaScannerConnection.scanFile(paramContext, new String[] { (String)uri }, null, -$$Lambda$Tools$OyD9YUPft93crDoDN4CypFbojuk);
      } 
    } 
  }
  
  public static void a(String paramString) {
    try {
      File file = new File(paramString);
      if (!file.exists()) {
        file.mkdirs();
        return;
      } 
      if (!file.isDirectory()) {
        file.delete();
        file.mkdirs();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static byte[] a(Bitmap paramBitmap, String paramString, int paramInt) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, byteArrayOutputStream);
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      fileOutputStream.write(byteArrayOutputStream.toByteArray());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("baos.size() = ");
      stringBuilder.append(byteArrayOutputStream.size());
      Log.a("drb", stringBuilder.toString());
      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return byteArrayOutputStream.toByteArray();
  }
  
  public static void b(String paramString) {
    File file = new File(paramString);
    if (!file.exists())
      try {
        file.createNewFile();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static int[] c(String paramString) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    int[] arrayOfInt = new int[3];
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    try {
      if (!TextUtils.isEmpty(paramString) && !paramString.contains("http"))
        mediaMetadataRetriever.setDataSource(paramString); 
      String str1 = mediaMetadataRetriever.extractMetadata(18);
      String str2 = mediaMetadataRetriever.extractMetadata(19);
      paramString = mediaMetadataRetriever.extractMetadata(24);
      if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
        bool2 = Integer.parseInt(str1);
        bool1 = Integer.parseInt(str2);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append(" widthStr");
        stringBuilder.append(str1);
        stringBuilder.append(",heightStr");
        stringBuilder.append(str2);
        LogUtils.a(stringBuilder.toString());
        bool2 = false;
        bool1 = false;
      } 
      if (!TextUtils.isEmpty(paramString)) {
        bool3 = Integer.parseInt(paramString);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append(" rotation");
        stringBuilder.append(paramString);
        LogUtils.a(stringBuilder.toString());
        bool3 = false;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append(" MediaMetadataRetriever exception ");
      stringBuilder.append(exception);
      LogUtils.a(stringBuilder.toString());
      exception.printStackTrace();
      mediaMetadataRetriever.release();
      return arrayOfInt;
    } finally {}
    if (bool3 == 90 || bool3 == 'Ď') {
      arrayOfInt[0] = bool1;
      arrayOfInt[1] = bool2;
    } else {
      arrayOfInt[0] = bool2;
      arrayOfInt[1] = bool1;
    } 
    arrayOfInt[2] = bool3;
    mediaMetadataRetriever.release();
    return arrayOfInt;
  }
  
  public static void d(String paramString) {
    if (StringUtils.a(paramString))
      return; 
    String str2 = RecyclingUtils.a();
    if (TextUtils.isEmpty(str2))
      return; 
    File file1 = new File(str2);
    if (!file1.exists())
      file1.mkdir(); 
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString.toLowerCase().trim());
    stringBuilder2.append(Math.random());
    stringBuilder1.append(Md5.a(stringBuilder2.toString()));
    stringBuilder1.append(".mp4");
    String str1 = stringBuilder1.toString();
    str2 = (new File(str2, str1)).getAbsolutePath();
    String str3 = b;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("to download finalVideoPath   ");
    stringBuilder3.append(paramString);
    Logger.b(str3, new Object[] { stringBuilder3.toString() });
    File file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(file2.getAbsolutePath());
    stringBuilder3.append(File.separator);
    stringBuilder3.append("blued");
    stringBuilder3.append(File.separator);
    stringBuilder3.append(str1);
    String str4 = stringBuilder3.toString();
    if (paramString.startsWith("http") || paramString.startsWith("https")) {
      FileDownloader.a(paramString, str2, new FileHttpResponseHandler(str2, str4, str1) {
            public void a(File param1File) {
              String str = Tools.a();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onSuccess file ");
              stringBuilder.append(param1File.getPath());
              Logger.b(str, new Object[] { stringBuilder.toString() });
              ThreadManager.a().a(new ThreadExecutor(this, "CopyVideoToPicDir") {
                    public void execute() {
                      FileUtils.a(this.a.a, this.a.b, this.a.c);
                      AppInfo.n().post(new Runnable(this) {
                            public void run() {
                              Tools.a(AppInfo.d(), this.a.a.b, true);
                            }
                          });
                    }
                  });
            }
            
            public void a(Throwable param1Throwable, int param1Int, File param1File) {}
            
            public void onFinish() {
              Logger.b(Tools.a(), new Object[] { "onFinish " });
            }
          }null);
      return;
    } 
    if (!paramString.startsWith(file2.getAbsolutePath()))
      FileUtils.a(paramString, str4, str1, 2); 
    AppInfo.n().post(new Runnable(str4) {
          public void run() {
            Tools.a(AppInfo.d(), this.a, true);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selecto\\utils\Tools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */