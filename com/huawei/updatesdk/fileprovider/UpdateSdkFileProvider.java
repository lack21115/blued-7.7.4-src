package com.huawei.updatesdk.fileprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.File;
import java.io.FileNotFoundException;

public class UpdateSdkFileProvider extends ContentProvider {
  public static final String AUTHORITIES_SUFFIX = ".updateSdk.fileProvider";
  
  private static final String[] COLUMNS = new String[] { "_display_name", "_size" };
  
  private static final String TAG = "UpdateSdkFileProvider";
  
  private static a mWStrategy;
  
  private String authority;
  
  private static File buildPath(File paramFile, String... paramVarArgs) {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j) {
      String str = paramVarArgs[i];
      File file = paramFile;
      if (str != null)
        file = new File(paramFile, str); 
      i++;
      paramFile = file;
    } 
    return paramFile;
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt) {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt) {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static a createWiseDistPathStrategy(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/huawei/updatesdk/fileprovider/UpdateSdkFileProvider
    //   2: monitorenter
    //   3: getstatic com/huawei/updatesdk/fileprovider/UpdateSdkFileProvider.mWStrategy : Lcom/huawei/updatesdk/fileprovider/a;
    //   6: ifnonnull -> 55
    //   9: new com/huawei/updatesdk/fileprovider/b
    //   12: dup
    //   13: aload_1
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: putstatic com/huawei/updatesdk/fileprovider/UpdateSdkFileProvider.mWStrategy : Lcom/huawei/updatesdk/fileprovider/a;
    //   20: aload_0
    //   21: invokevirtual getFilesDir : ()Ljava/io/File;
    //   24: ifnull -> 55
    //   27: aload_0
    //   28: invokevirtual getFilesDir : ()Ljava/io/File;
    //   31: iconst_1
    //   32: anewarray java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc '/'
    //   39: aastore
    //   40: invokestatic buildPath : (Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;
    //   43: astore_0
    //   44: getstatic com/huawei/updatesdk/fileprovider/UpdateSdkFileProvider.mWStrategy : Lcom/huawei/updatesdk/fileprovider/a;
    //   47: ldc 'updatesdkapk'
    //   49: aload_0
    //   50: invokeinterface a : (Ljava/lang/String;Ljava/io/File;)V
    //   55: getstatic com/huawei/updatesdk/fileprovider/UpdateSdkFileProvider.mWStrategy : Lcom/huawei/updatesdk/fileprovider/a;
    //   58: astore_0
    //   59: ldc com/huawei/updatesdk/fileprovider/UpdateSdkFileProvider
    //   61: monitorexit
    //   62: aload_0
    //   63: areturn
    //   64: astore_0
    //   65: ldc com/huawei/updatesdk/fileprovider/UpdateSdkFileProvider
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   3	55	64	finally
    //   55	59	64	finally
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile) {
    createWiseDistPathStrategy(paramContext, paramString);
    return mWStrategy.a(paramFile);
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo) {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported) {
      if (paramProviderInfo.grantUriPermissions) {
        String str = paramProviderInfo.authority;
        this.authority = str;
        createWiseDistPathStrategy(paramContext, str);
        return;
      } 
      throw new SecurityException("WiseDist Provider must grant uri permissions");
    } 
    throw new SecurityException("WiseDist Provider must not be exported");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
    throw new UnsupportedOperationException("No external updates");
  }
  
  public String getType(Uri paramUri) {
    if (paramUri != null && !TextUtils.isEmpty(paramUri.toString()) && paramUri.toString().endsWith("apk")) {
      String str = MimeTypeMap.getSingleton().getMimeTypeFromExtension("apk");
      if (str != null)
        return str; 
    } 
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues) {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate() {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString) throws FileNotFoundException {
    if (paramUri == null)
      return null; 
    if (paramUri.getAuthority() != null) {
      if (!paramUri.getAuthority().equals(this.authority))
        return null; 
      File file = mWStrategy.a(paramUri);
      if (!file.getName().endsWith("apk")) {
        a.b("UpdateSdkFileProvider", "can not open this file.");
        return null;
      } 
      return ParcelFileDescriptor.open(file, 268435456);
    } 
    return null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    Object object;
    int i;
    File file = mWStrategy.a(paramUri);
    String[] arrayOfString = paramArrayOfString1;
    if (paramArrayOfString1 == null)
      arrayOfString = COLUMNS; 
    paramArrayOfString2 = new String[arrayOfString.length];
    Object[] arrayOfObject = new Object[arrayOfString.length];
    int k = arrayOfString.length;
    int j = 0;
    boolean bool = false;
    while (j < k) {
      paramString2 = arrayOfString[j];
      if ("_display_name".equals(paramString2)) {
        paramArrayOfString2[object] = "_display_name";
        int n = object + 1;
        arrayOfObject[object] = file.getName();
        i = n;
      } else {
        int n = i;
        if ("_size".equals(paramString2)) {
          paramArrayOfString2[i] = "_size";
          n = i + 1;
          arrayOfObject[i] = Long.valueOf(file.length());
          i = n;
        } else {
          continue;
        } 
      } 
      int m = i;
      continue;
      j++;
      object = SYNTHETIC_LOCAL_VARIABLE_8;
    } 
    arrayOfString = copyOf(paramArrayOfString2, i);
    arrayOfObject = copyOf(arrayOfObject, i);
    MatrixCursor matrixCursor = new MatrixCursor(arrayOfString, 1);
    matrixCursor.addRow(arrayOfObject);
    return (Cursor)matrixCursor;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\fileprovider\UpdateSdkFileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */