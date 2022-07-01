package org.chromium.android_webview.services;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import java.io.FileOutputStream;
import org.chromium.android_webview.VariationsUtils;
import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

public class VariationsSeedHolder {
  private static VariationsSeedHolder sInstance;
  
  private boolean mFailedReadingSeed;
  
  private VariationsSeedFetcher.SeedInfo mSeed;
  
  final Handler mSeedHandler;
  
  private final HandlerThread mSeedThread = new HandlerThread("seed_holder");
  
  protected VariationsSeedHolder() {
    this.mSeedThread.start();
    this.mSeedHandler = new Handler(this.mSeedThread.getLooper());
  }
  
  static VariationsSeedHolder getInstance() {
    if (sInstance == null)
      sInstance = new VariationsSeedHolder(); 
    return sInstance;
  }
  
  public static void scheduleFetchIfNeeded() {
    AwVariationsSeedFetcher.scheduleIfNeeded();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\VariationsSeedHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */