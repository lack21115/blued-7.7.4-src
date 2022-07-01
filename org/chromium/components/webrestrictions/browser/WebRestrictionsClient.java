package org.chromium.components.webrestrictions.browser;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.net.Uri;
import org.chromium.base.annotations.CalledByNative;

public class WebRestrictionsClient {
  private static WebRestrictionsClient sMock;
  
  private ContentObserver mContentObserver;
  
  private ContentResolver mContentResolver;
  
  private Uri mQueryUri;
  
  private Uri mRequestUri;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static WebRestrictionsClient create(String paramString, long paramLong) {
    WebRestrictionsClient webRestrictionsClient;
    if (sMock == null) {
      webRestrictionsClient = new WebRestrictionsClient();
    } else {
      webRestrictionsClient = sMock;
    } 
    assert false;
    throw new AssertionError();
  }
  
  native void nativeOnWebRestrictionsChanged(long paramLong);
  
  @CalledByNative
  void onDestroy() {
    this.mContentResolver.unregisterContentObserver(this.mContentObserver);
  }
  
  @CalledByNative
  boolean requestPermission(String paramString) {
    ContentValues contentValues = new ContentValues(1);
    contentValues.put("url", paramString);
    return (this.mContentResolver.insert(this.mRequestUri, contentValues) != null);
  }
  
  @CalledByNative
  WebRestrictionsClientResult shouldProceed(String paramString) {
    paramString = String.format("url = '%s'", new Object[] { paramString });
    return new WebRestrictionsClientResult(this.mContentResolver.query(this.mQueryUri, null, paramString, null, null));
  }
  
  @CalledByNative
  boolean supportsRequest() {
    return (this.mContentResolver != null && this.mContentResolver.getType(this.mRequestUri) != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\webrestrictions\browser\WebRestrictionsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */