package org.chromium.android_webview.services;

import android.os.IInterface;
import android.os.ParcelFileDescriptor;

public interface ICrashReceiverService extends IInterface {
  void transmitCrashes(ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\ICrashReceiverService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */