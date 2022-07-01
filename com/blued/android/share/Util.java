package com.blued.android.share;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module_share_china.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Util {
  private static final String TAG = "SDK_Sample.Util";
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
    if (paramBoolean)
      paramBitmap.recycle(); 
    byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
    try {
      byteArrayOutputStream.close();
      return arrayOfByte;
    } catch (Exception exception) {
      exception.printStackTrace();
      return arrayOfByte;
    } 
  }
  
  public static byte[] getHtmlByteArray(String paramString) {
    String str1;
    String str2 = null;
    try {
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString)).openConnection();
      paramString = str2;
      if (httpURLConnection.getResponseCode() == 200)
        InputStream inputStream = httpURLConnection.getInputStream(); 
    } catch (MalformedURLException malformedURLException) {
      malformedURLException.printStackTrace();
      str1 = str2;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      str1 = str2;
    } 
    return inputStreamToByte((InputStream)str1);
  }
  
  public static void hideProgressDialog(ProgressDialog paramProgressDialog) {
    if (paramProgressDialog != null)
      paramProgressDialog.cancel(); 
  }
  
  public static Bitmap imageZoomToSize(Bitmap paramBitmap, int paramInt) {
    byte[] arrayOfByte;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
    double d1 = ((byteArrayOutputStream.toByteArray()).length / 1024);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("origin bitmap size___:");
    stringBuilder.append(d1);
    Logger.b("xpf", new Object[] { stringBuilder.toString() });
    double d2 = paramInt;
    if (d1 > d2 && paramInt > 0) {
      d2 = d1 / d2;
      d1 = paramBitmap.getWidth() / Math.sqrt(d2);
      d2 = paramBitmap.getHeight() / Math.sqrt(d2);
      Bitmap bitmap = Bitmap.createScaledBitmap(paramBitmap, (int)d1, (int)d2, true);
      if (paramBitmap != null && !paramBitmap.equals(bitmap))
        paramBitmap.recycle(); 
      ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream1);
      arrayOfByte = byteArrayOutputStream1.toByteArray();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("new bitmap size:");
      stringBuilder1.append(arrayOfByte.length / 1024);
      Logger.b("xpf", new Object[] { stringBuilder1.toString() });
      return bitmap;
    } 
    return (Bitmap)arrayOfByte;
  }
  
  public static Bitmap imageZoomToSize(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      Bitmap bitmap = BitmapFactory.decodeFile(paramString);
      return (bitmap == null) ? bitmap : imageZoomToSize(bitmap, paramInt);
    } catch (OutOfMemoryError outOfMemoryError) {
      MemoryRequest.a().b();
      return null;
    } 
  }
  
  public static byte[] inputStreamToByte(InputStream paramInputStream) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      while (true) {
        int i = paramInputStream.read();
        if (i != -1) {
          byteArrayOutputStream.write(i);
          continue;
        } 
        byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return arrayOfByte;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static boolean isClientAvailable(Context paramContext, String paramString) {
    if (paramString != null) {
      if ("".equals(paramString))
        return false; 
      try {
        paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
        return true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        return false;
      } 
    } 
    return false;
  }
  
  public static byte[] readFromFile(String paramString, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder1;
    byte[] arrayOfByte;
    File file2 = null;
    if (paramString == null)
      return null; 
    File file1 = new File(paramString);
    if (!file1.exists()) {
      Logger.b("SDK_Sample.Util", new Object[] { "readFromFile: file not found" });
      return null;
    } 
    int i = paramInt2;
    if (paramInt2 == -1)
      i = (int)file1.length(); 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("readFromFile : offset = ");
    stringBuilder2.append(paramInt1);
    stringBuilder2.append(" len = ");
    stringBuilder2.append(i);
    stringBuilder2.append(" offset + len = ");
    paramInt2 = paramInt1 + i;
    stringBuilder2.append(paramInt2);
    Logger.c("SDK_Sample.Util", new Object[] { stringBuilder2.toString() });
    if (paramInt1 < 0) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("readFromFile invalid offset:");
      stringBuilder1.append(paramInt1);
      Logger.e("SDK_Sample.Util", new Object[] { stringBuilder1.toString() });
      return null;
    } 
    if (i <= 0) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("readFromFile invalid len:");
      stringBuilder1.append(i);
      Logger.e("SDK_Sample.Util", new Object[] { stringBuilder1.toString() });
      return null;
    } 
    if (paramInt2 > (int)file1.length()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("readFromFile invalid file len:");
      stringBuilder1.append(file1.length());
      Logger.e("SDK_Sample.Util", new Object[] { stringBuilder1.toString() });
      return null;
    } 
    file1 = file2;
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile((String)stringBuilder1, "r");
      file1 = file2;
      byte[] arrayOfByte1 = new byte[i];
      arrayOfByte = arrayOfByte1;
      randomAccessFile.seek(paramInt1);
      arrayOfByte = arrayOfByte1;
      randomAccessFile.readFully(arrayOfByte1);
      arrayOfByte = arrayOfByte1;
      randomAccessFile.close();
      return arrayOfByte1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("readFromFile : errMsg = ");
      stringBuilder.append(exception.getMessage());
      Logger.e("SDK_Sample.Util", new Object[] { stringBuilder.toString() });
      exception.printStackTrace();
      return arrayOfByte;
    } 
  }
  
  public static File saveBitmapToFile(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aconst_null
    //   4: astore #4
    //   6: aload_1
    //   7: ifnonnull -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: astore #7
    //   22: aload #7
    //   24: invokevirtual exists : ()Z
    //   27: ifne -> 53
    //   30: aload #7
    //   32: invokevirtual getParentFile : ()Ljava/io/File;
    //   35: invokevirtual exists : ()Z
    //   38: ifne -> 59
    //   41: aload #7
    //   43: invokevirtual getParentFile : ()Ljava/io/File;
    //   46: invokevirtual mkdirs : ()Z
    //   49: pop
    //   50: goto -> 59
    //   53: aload #7
    //   55: invokevirtual delete : ()Z
    //   58: pop
    //   59: aload #7
    //   61: invokevirtual createNewFile : ()Z
    //   64: pop
    //   65: goto -> 73
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual printStackTrace : ()V
    //   73: aload #4
    //   75: astore_0
    //   76: new java/io/BufferedOutputStream
    //   79: dup
    //   80: new java/io/FileOutputStream
    //   83: dup
    //   84: aload #7
    //   86: invokespecial <init> : (Ljava/io/File;)V
    //   89: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   92: astore #4
    //   94: aload_1
    //   95: getstatic android/graphics/Bitmap$CompressFormat.JPEG : Landroid/graphics/Bitmap$CompressFormat;
    //   98: iload_2
    //   99: aload #4
    //   101: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   104: pop
    //   105: iload_3
    //   106: ifeq -> 113
    //   109: aload_1
    //   110: invokevirtual recycle : ()V
    //   113: aload #4
    //   115: invokevirtual flush : ()V
    //   118: aload #4
    //   120: invokevirtual close : ()V
    //   123: aload #7
    //   125: areturn
    //   126: astore #5
    //   128: aload #4
    //   130: astore_0
    //   131: aload #5
    //   133: astore #4
    //   135: goto -> 196
    //   138: astore #5
    //   140: goto -> 154
    //   143: astore #4
    //   145: goto -> 196
    //   148: astore #5
    //   150: aload #6
    //   152: astore #4
    //   154: aload #4
    //   156: astore_0
    //   157: aload #5
    //   159: invokevirtual printStackTrace : ()V
    //   162: aload #4
    //   164: ifnull -> 193
    //   167: iload_3
    //   168: ifeq -> 175
    //   171: aload_1
    //   172: invokevirtual recycle : ()V
    //   175: aload #4
    //   177: invokevirtual flush : ()V
    //   180: aload #4
    //   182: invokevirtual close : ()V
    //   185: aload #7
    //   187: areturn
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual printStackTrace : ()V
    //   193: aload #7
    //   195: areturn
    //   196: aload_0
    //   197: ifnull -> 224
    //   200: iload_3
    //   201: ifeq -> 208
    //   204: aload_1
    //   205: invokevirtual recycle : ()V
    //   208: aload_0
    //   209: invokevirtual flush : ()V
    //   212: aload_0
    //   213: invokevirtual close : ()V
    //   216: goto -> 224
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual printStackTrace : ()V
    //   224: aload #4
    //   226: athrow
    // Exception table:
    //   from	to	target	type
    //   59	65	68	java/io/IOException
    //   76	94	148	java/io/IOException
    //   76	94	143	finally
    //   94	105	138	java/io/IOException
    //   94	105	126	finally
    //   109	113	188	java/io/IOException
    //   113	123	188	java/io/IOException
    //   157	162	143	finally
    //   171	175	188	java/io/IOException
    //   175	185	188	java/io/IOException
    //   204	208	219	java/io/IOException
    //   208	216	219	java/io/IOException
  }
  
  public static String saveBitmapToLocal(Bitmap paramBitmap, boolean paramBoolean) {
    if (paramBitmap == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RecyclingUtils.e("shareImg"));
    stringBuilder.append(".jpg");
    String str = stringBuilder.toString();
    saveBitmapToFile(str, paramBitmap, 100, paramBoolean);
    return str;
  }
  
  public static ProgressDialog showProgressDialog(Context paramContext) {
    ProgressDialog progressDialog = new ProgressDialog(paramContext);
    progressDialog.setProgressStyle(0);
    progressDialog.setTitle(paramContext.getString(R.string.share_loading));
    progressDialog.setMessage(paramContext.getString(R.string.initializing_content));
    progressDialog.setIndeterminate(true);
    progressDialog.setCancelable(false);
    progressDialog.show();
    return progressDialog;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */