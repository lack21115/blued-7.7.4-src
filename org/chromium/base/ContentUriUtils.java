package org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;

public abstract class ContentUriUtils {
  private static ContentUriUtils$FileProviderUtil sFileProviderUtil;
  
  private static final Object sLock = new Object();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  public static boolean contentUriExists(String paramString) {
    try {
      boolean bool;
      AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(paramString);
      if (assetFileDescriptor != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (assetFileDescriptor != null)
        try {
          assetFileDescriptor.close();
          return bool;
        } catch (IOException iOException) {} 
      return bool;
    } finally {}
  }
  
  private static AssetFileDescriptor getAssetFileDescriptor(String paramString) {
    ContentResolver contentResolver = ContextUtils.sApplicationContext.getContentResolver();
    Uri uri = Uri.parse(paramString);
    try {
      if (isVirtualDocument(uri)) {
        String[] arrayOfString = contentResolver.getStreamTypes(uri, "*/*");
        if (arrayOfString != null && arrayOfString.length > 0) {
          AssetFileDescriptor assetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uri, arrayOfString[0], null);
          if (assetFileDescriptor != null) {
            long l = assetFileDescriptor.getStartOffset();
            if (l == 0L)
              return assetFileDescriptor; 
            try {
              assetFileDescriptor.close();
            } catch (IOException iOException) {}
            throw new SecurityException("Cannot open files with non-zero offset type.");
          } 
          return (AssetFileDescriptor)iOException;
        } 
      } else {
        ParcelFileDescriptor parcelFileDescriptor = iOException.openFileDescriptor(uri, "r");
        return (parcelFileDescriptor != null) ? new AssetFileDescriptor(parcelFileDescriptor, 0L, -1L) : null;
      } 
    } catch (FileNotFoundException fileNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder("Cannot find content uri: ");
      stringBuilder.append(paramString);
      Log.w("ContentUriUtils", stringBuilder.toString(), fileNotFoundException);
      return null;
    } catch (SecurityException securityException) {
      StringBuilder stringBuilder = new StringBuilder("Cannot open content uri: ");
      stringBuilder.append(paramString);
      Log.w("ContentUriUtils", stringBuilder.toString(), securityException);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Unknown content uri: ");
      stringBuilder.append(paramString);
      Log.w("ContentUriUtils", stringBuilder.toString(), exception);
      return null;
    } 
    return null;
  }
  
  public static Uri getContentUriFromFile$3dde563() {
    synchronized (sLock) {
      if (sFileProviderUtil != null)
        return sFileProviderUtil.getContentUriFromFile$3dde563(); 
      return null;
    } 
  }
  
  public static String getDisplayName(Uri paramUri, Context paramContext, String paramString) {
    if (paramUri == null)
      return ""; 
    ContentResolver contentResolver = paramContext.getContentResolver();
    try {
      Cursor cursor = contentResolver.query(paramUri, null, null, null, null);
      Context context = null;
      if (cursor != null) {
        paramContext = context;
        try {
          if (cursor.getCount() > 0) {
            String str1;
            paramContext = context;
            cursor.moveToFirst();
            paramContext = context;
            int i = cursor.getColumnIndex(paramString);
            if (i == -1) {
              if (cursor != null)
                $closeResource(null, cursor); 
              return "";
            } 
            paramContext = context;
            String str2 = cursor.getString(i);
            paramString = str2;
            paramContext = context;
            if (hasVirtualFlag(cursor)) {
              paramContext = context;
              String[] arrayOfString = contentResolver.getStreamTypes(paramUri, "*/*");
              paramString = str2;
              if (arrayOfString != null) {
                paramString = str2;
                paramContext = context;
                if (arrayOfString.length > 0) {
                  paramContext = context;
                  String str = MimeTypeMap.getSingleton().getExtensionFromMimeType(arrayOfString[0]);
                  paramString = str2;
                  if (str != null) {
                    paramContext = context;
                    StringBuilder stringBuilder = new StringBuilder();
                    paramContext = context;
                    stringBuilder.append(str2);
                    paramContext = context;
                    stringBuilder.append(".");
                    paramContext = context;
                    stringBuilder.append(str);
                    paramContext = context;
                    str1 = stringBuilder.toString();
                  } 
                } 
              } 
            } 
            if (cursor != null)
              $closeResource(null, cursor); 
            return str1;
          } 
        } catch (Throwable throwable1) {
          Throwable throwable2 = throwable1;
          throw throwable1;
        } finally {}
      } 
      if (cursor != null)
        $closeResource(null, cursor); 
      return "";
    } catch (NullPointerException nullPointerException) {
      return "";
    } 
  }
  
  @CalledByNative
  public static String getMimeType(String paramString) {
    String[] arrayOfString;
    ContentResolver contentResolver = ContextUtils.sApplicationContext.getContentResolver();
    Uri uri = Uri.parse(paramString);
    if (isVirtualDocument(uri)) {
      arrayOfString = contentResolver.getStreamTypes(uri, "*/*");
      return (arrayOfString != null && arrayOfString.length > 0) ? arrayOfString[0] : null;
    } 
    return contentResolver.getType((Uri)arrayOfString);
  }
  
  private static boolean hasVirtualFlag(Cursor paramCursor) {
    if (Build.VERSION.SDK_INT < 24)
      return false; 
    int i = paramCursor.getColumnIndex("flags");
    return (i >= 0 && (paramCursor.getLong(i) & 0x200L) != 0L);
  }
  
  private static boolean isVirtualDocument(Uri paramUri) {
    if (Build.VERSION.SDK_INT < 19)
      return false; 
    if (paramUri == null)
      return false; 
    if (!DocumentsContract.isDocumentUri(ContextUtils.sApplicationContext, paramUri))
      return false; 
    ContentResolver contentResolver = ContextUtils.sApplicationContext.getContentResolver();
    try {
      Cursor cursor = contentResolver.query(paramUri, null, null, null, null);
      contentResolver = null;
      if (cursor != null) {
        ContentResolver contentResolver1 = contentResolver;
        try {
          if (cursor.getCount() > 0) {
            contentResolver1 = contentResolver;
            cursor.moveToFirst();
            contentResolver1 = contentResolver;
            boolean bool = hasVirtualFlag(cursor);
            if (cursor != null)
              $closeResource(null, cursor); 
            return bool;
          } 
        } catch (Throwable throwable2) {
          Throwable throwable1 = throwable2;
          throw throwable2;
        } finally {}
      } 
      if (cursor != null) {
        $closeResource(null, cursor);
        return false;
      } 
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  @CalledByNative
  public static String maybeGetDisplayName(String paramString) {
    Uri uri = Uri.parse(paramString);
    try {
      String str = getDisplayName(uri, ContextUtils.sApplicationContext, "_display_name");
      boolean bool = TextUtils.isEmpty(str);
      return bool ? null : str;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Cannot open content uri: ");
      stringBuilder.append(paramString);
      Log.w("ContentUriUtils", stringBuilder.toString(), exception);
      return null;
    } 
  }
  
  @CalledByNative
  public static int openContentUriForRead(String paramString) {
    AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(paramString);
    return (assetFileDescriptor != null) ? assetFileDescriptor.getParcelFileDescriptor().detachFd() : -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ContentUriUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */