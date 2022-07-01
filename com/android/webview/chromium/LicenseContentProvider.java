package com.android.webview.chromium;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@TargetApi(19)
public class LicenseContentProvider extends ContentProvider implements ContentProvider.PipeDataWriter {
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
    throw new UnsupportedOperationException();
  }
  
  public String getType(Uri paramUri) {
    return (paramUri != null && paramUri.toString().endsWith("LicenseContentProvider/webview_licenses")) ? "text/html" : null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues) {
    throw new UnsupportedOperationException();
  }
  
  public boolean onCreate() {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString) {
    return (paramUri != null && paramUri.toString().endsWith("LicenseContentProvider/webview_licenses")) ? openPipeHelper(null, null, null, "webview_licenses.notice", this) : null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    throw new UnsupportedOperationException();
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\LicenseContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */