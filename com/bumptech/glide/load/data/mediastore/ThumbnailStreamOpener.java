package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
  private static final FileService a = new FileService();
  
  private final FileService b;
  
  private final ThumbnailQuery c;
  
  private final ArrayPool d;
  
  private final ContentResolver e;
  
  private final List<ImageHeaderParser> f;
  
  ThumbnailStreamOpener(List<ImageHeaderParser> paramList, FileService paramFileService, ThumbnailQuery paramThumbnailQuery, ArrayPool paramArrayPool, ContentResolver paramContentResolver) {
    this.b = paramFileService;
    this.c = paramThumbnailQuery;
    this.d = paramArrayPool;
    this.e = paramContentResolver;
    this.f = paramList;
  }
  
  ThumbnailStreamOpener(List<ImageHeaderParser> paramList, ThumbnailQuery paramThumbnailQuery, ArrayPool paramArrayPool, ContentResolver paramContentResolver) {
    this(paramList, a, paramThumbnailQuery, paramArrayPool, paramContentResolver);
  }
  
  private boolean a(File paramFile) {
    return (this.b.a(paramFile) && 0L < this.b.b(paramFile));
  }
  
  private String c(Uri paramUri) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/bumptech/glide/load/data/mediastore/ThumbnailQuery;
    //   4: aload_1
    //   5: invokeinterface a : (Landroid/net/Uri;)Landroid/database/Cursor;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull -> 55
    //   15: aload_3
    //   16: astore_2
    //   17: aload_3
    //   18: invokeinterface moveToFirst : ()Z
    //   23: ifeq -> 55
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: iconst_0
    //   30: invokeinterface getString : (I)Ljava/lang/String;
    //   35: astore #4
    //   37: aload_3
    //   38: ifnull -> 47
    //   41: aload_3
    //   42: invokeinterface close : ()V
    //   47: aload #4
    //   49: areturn
    //   50: astore #4
    //   52: goto -> 77
    //   55: aload_3
    //   56: ifnull -> 65
    //   59: aload_3
    //   60: invokeinterface close : ()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_2
    //   70: goto -> 146
    //   73: astore #4
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_3
    //   78: astore_2
    //   79: ldc 'ThumbStreamOpener'
    //   81: iconst_3
    //   82: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   85: ifeq -> 133
    //   88: aload_3
    //   89: astore_2
    //   90: new java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial <init> : ()V
    //   97: astore #5
    //   99: aload_3
    //   100: astore_2
    //   101: aload #5
    //   103: ldc 'Failed to query for thumbnail for Uri: '
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_3
    //   110: astore_2
    //   111: aload #5
    //   113: aload_1
    //   114: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: astore_2
    //   120: ldc 'ThumbStreamOpener'
    //   122: aload #5
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: aload #4
    //   129: invokestatic d : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   132: pop
    //   133: aload_3
    //   134: ifnull -> 143
    //   137: aload_3
    //   138: invokeinterface close : ()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull -> 156
    //   150: aload_2
    //   151: invokeinterface close : ()V
    //   156: aload_1
    //   157: athrow
    // Exception table:
    //   from	to	target	type
    //   0	11	73	java/lang/SecurityException
    //   0	11	67	finally
    //   17	26	50	java/lang/SecurityException
    //   17	26	145	finally
    //   28	37	50	java/lang/SecurityException
    //   28	37	145	finally
    //   79	88	145	finally
    //   90	99	145	finally
    //   101	109	145	finally
    //   111	118	145	finally
    //   120	133	145	finally
  }
  
  int a(Uri paramUri) {
    InputStream inputStream2 = null;
    InputStream inputStream3 = null;
    InputStream inputStream1 = null;
    try {
      InputStream inputStream = this.e.openInputStream(paramUri);
      inputStream1 = inputStream;
      inputStream2 = inputStream;
      inputStream3 = inputStream;
      int i = ImageHeaderParserUtils.b(this.f, inputStream, this.d);
      if (inputStream != null)
        try {
          inputStream.close();
          return i;
        } catch (IOException iOException) {
          return i;
        }  
      return i;
    } catch (IOException iOException) {
      inputStream2 = inputStream3;
    } catch (NullPointerException nullPointerException) {
    
    } finally {}
    inputStream1 = inputStream2;
    if (Log.isLoggable("ThumbStreamOpener", 3)) {
      inputStream1 = inputStream2;
      StringBuilder stringBuilder = new StringBuilder();
      inputStream1 = inputStream2;
      stringBuilder.append("Failed to open uri: ");
      inputStream1 = inputStream2;
      stringBuilder.append(paramUri);
      inputStream1 = inputStream2;
      Log.d("ThumbStreamOpener", stringBuilder.toString(), nullPointerException);
    } 
    if (inputStream2 != null)
      try {
        inputStream2.close();
      } catch (IOException iOException) {} 
    return -1;
  }
  
  public InputStream b(Uri paramUri) throws FileNotFoundException {
    String str = c(paramUri);
    if (TextUtils.isEmpty(str))
      return null; 
    File file = this.b.a(str);
    if (!a(file))
      return null; 
    Uri uri = Uri.fromFile(file);
    try {
      return this.e.openInputStream(uri);
    } catch (NullPointerException nullPointerException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("NPE opening uri: ");
      stringBuilder.append(paramUri);
      stringBuilder.append(" -> ");
      stringBuilder.append(uri);
      throw (FileNotFoundException)(new FileNotFoundException(stringBuilder.toString())).initCause(nullPointerException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\mediastore\ThumbnailStreamOpener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */