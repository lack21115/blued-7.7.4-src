package org.chromium.android_webview;

import android.content.Intent;
import android.os.SystemClock;
import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.chromium.android_webview.services.VariationsSeedServer;
import org.chromium.base.CommandLine;
import org.chromium.base.ContextUtils;
import org.chromium.base.metrics.CachedMetrics;
import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

public class VariationsSeedLoader {
  private static final long MAX_REQUEST_PERIOD_MILLIS = 0L;
  
  private static final long SEED_EXPIRATION_MILLIS = 0L;
  
  private static boolean sVariationsAlwaysEnabled;
  
  public int mEnableState = -1;
  
  public VariationsSeedLoader$SeedLoadAndUpdateRunnable mRunnable;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  protected static Intent getServerIntent() {
    return new Intent(ContextUtils.sApplicationContext.createPackageContext(AwBrowserProcess.getWebViewPackageName(), 0), VariationsSeedServer.class);
  }
  
  public static boolean isEnabledByCmd() {
    return CommandLine.getInstance().hasSwitch("enable-webview-variations");
  }
  
  protected static void onBackgroundWorkFinished() {}
  
  private static void recordLoadSeedResult(int paramInt) {
    (new CachedMetrics.EnumeratedHistogramSample("Variations.SeedLoadResult", 10)).record(paramInt);
  }
  
  public final VariationsSeedFetcher.SeedInfo getSeedBlockingAndLog() {
    long l = SystemClock.elapsedRealtime();
    try {
      VariationsSeedLoader$SeedLoadAndUpdateRunnable variationsSeedLoader$SeedLoadAndUpdateRunnable = this.mRunnable;
      TimeUnit timeUnit = TimeUnit.MILLISECONDS;
      VariationsSeedFetcher.SeedInfo seedInfo = variationsSeedLoader$SeedLoadAndUpdateRunnable.mLoadTask.get(20L, timeUnit);
    } finally {
      if (this.mRunnable.isVariationsEnabled()) {
        long l1 = SystemClock.elapsedRealtime();
        (new CachedMetrics.TimesHistogramSample("Variations.SeedLoadBlockingTime", TimeUnit.MILLISECONDS)).record(l1 - l);
      } 
    } 
    if (this.mRunnable.isVariationsEnabled())
      recordLoadSeedResult(9); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\VariationsSeedLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */