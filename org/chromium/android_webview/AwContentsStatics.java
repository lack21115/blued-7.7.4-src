package org.chromium.android_webview;

import android.content.Context;
import android.net.Uri;
import java.util.List;
import org.chromium.base.Callback;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class AwContentsStatics {
  private static ClientCertLookupTable sClientCertLookupTable;
  
  private static boolean sRecordFullDocument;
  
  private static String sUnreachableWebDataUrl;
  
  public static void clearClientCertPreferences(Runnable paramRunnable) {
    ThreadUtils.assertOnUiThread();
    ClientCertLookupTable clientCertLookupTable = getClientCertLookupTable();
    clientCertLookupTable.mCerts.clear();
    clientCertLookupTable.mDenieds.clear();
    nativeClearClientCertPreferences(paramRunnable);
  }
  
  @CalledByNative
  private static void clientCertificatesCleared(Runnable paramRunnable) {
    if (paramRunnable == null)
      return; 
    paramRunnable.run();
  }
  
  public static String findAddress(String paramString) {
    if (paramString != null)
      return FindAddress.findAddress(paramString); 
    throw new NullPointerException("addr is null");
  }
  
  public static ClientCertLookupTable getClientCertLookupTable() {
    ThreadUtils.assertOnUiThread();
    if (sClientCertLookupTable == null)
      sClientCertLookupTable = new ClientCertLookupTable(); 
    return sClientCertLookupTable;
  }
  
  public static String getProductVersion() {
    return nativeGetProductVersion();
  }
  
  static boolean getRecordFullDocument() {
    return sRecordFullDocument;
  }
  
  public static Uri getSafeBrowsingPrivacyPolicyUrl() {
    return Uri.parse(nativeGetSafeBrowsingPrivacyPolicyUrl());
  }
  
  public static String getUnreachableWebDataUrl() {
    if (sUnreachableWebDataUrl == null)
      sUnreachableWebDataUrl = nativeGetUnreachableWebDataUrl(); 
    return sUnreachableWebDataUrl;
  }
  
  public static void initSafeBrowsing(Context paramContext, Callback paramCallback) {
    paramContext.getApplicationContext();
    AwContentsStatics$$Lambda$1 awContentsStatics$$Lambda$1 = new AwContentsStatics$$Lambda$1(paramCallback);
    PlatformServiceBridge.getInstance();
    PlatformServiceBridge.warmUpSafeBrowsing$3fc49b33(awContentsStatics$$Lambda$1);
  }
  
  private static native void nativeClearClientCertPreferences(Runnable paramRunnable);
  
  private static native String nativeGetProductVersion();
  
  private static native String nativeGetSafeBrowsingPrivacyPolicyUrl();
  
  private static native String nativeGetUnreachableWebDataUrl();
  
  private static native void nativeSetCheckClearTextPermitted(boolean paramBoolean);
  
  private static native void nativeSetSafeBrowsingWhitelist(String[] paramArrayOfString, Callback paramCallback);
  
  private static native void nativeSetServiceWorkerIoThreadClient(AwContentsIoThreadClient paramAwContentsIoThreadClient, AwBrowserContext paramAwBrowserContext);
  
  @CalledByNative
  private static void safeBrowsingWhitelistAssigned(Callback paramCallback, boolean paramBoolean) {
    if (paramCallback == null)
      return; 
    paramCallback.onResult(Boolean.valueOf(paramBoolean));
  }
  
  public static void setCheckClearTextPermitted(boolean paramBoolean) {
    nativeSetCheckClearTextPermitted(paramBoolean);
  }
  
  public static void setRecordFullDocument(boolean paramBoolean) {
    sRecordFullDocument = paramBoolean;
  }
  
  public static void setSafeBrowsingWhitelist(List paramList, Callback paramCallback) {
    String[] arrayOfString = (String[])paramList.toArray((Object[])new String[paramList.size()]);
    Callback callback = paramCallback;
    if (paramCallback == null)
      callback = AwContentsStatics$$Lambda$0.$instance; 
    nativeSetSafeBrowsingWhitelist(arrayOfString, callback);
  }
  
  public static void setServiceWorkerIoThreadClient(AwContentsIoThreadClient paramAwContentsIoThreadClient, AwBrowserContext paramAwBrowserContext) {
    nativeSetServiceWorkerIoThreadClient(paramAwContentsIoThreadClient, paramAwBrowserContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContentsStatics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */