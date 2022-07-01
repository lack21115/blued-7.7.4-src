package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class PushProvider extends ContentProvider {
  public static final String TAG = "PushProvider";
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
    return 0;
  }
  
  public String getType(Uri paramUri) {
    return paramUri.toString().endsWith(".xml") ? "xml" : null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues) {
    return null;
  }
  
  public boolean onCreate() {
    return false;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString) throws FileNotFoundException {
    HMSLog.i("PushProvider", "use sdk PushProvider openFile");
    if ("xml".equals(getType(paramUri))) {
      if (Build.VERSION.SDK_INT >= 24) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(((Context)Objects.<Context>requireNonNull(getContext())).createDeviceProtectedStorageContext().getDataDir());
        stringBuilder2.append("/shared_prefs/push_notify_flag.xml");
        File file2 = new File(stringBuilder2.toString());
        if (file2.exists())
          return ParcelFileDescriptor.open(file2, 268435456); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(getContext().getDataDir());
        stringBuilder1.append("/shared_prefs/push_notify_flag.xml");
        File file1 = new File(stringBuilder1.toString());
        if (file1.exists())
          return ParcelFileDescriptor.open(file1, 268435456); 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getContext().getFilesDir());
        stringBuilder.append("");
        String str = stringBuilder.toString();
        if (!TextUtils.isEmpty(str)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str.substring(0, str.length() - 6));
          stringBuilder1.append("/shared_prefs/push_notify_flag.xml");
          File file = new File(stringBuilder1.toString());
          if (file.exists())
            return ParcelFileDescriptor.open(file, 268435456); 
        } 
      } 
      throw new FileNotFoundException(paramUri.getPath());
    } 
    HMSLog.w("PushProvider", "Incorrect file uri");
    throw new FileNotFoundException(paramUri.getPath());
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\PushProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */