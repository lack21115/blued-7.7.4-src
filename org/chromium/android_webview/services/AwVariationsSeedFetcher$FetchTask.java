package org.chromium.android_webview.services;

import android.app.job.JobParameters;
import java.io.IOException;
import org.chromium.android_webview.VariationsUtils;
import org.chromium.base.AsyncTask;
import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

final class AwVariationsSeedFetcher$FetchTask extends AsyncTask {
  private JobParameters mParams;
  
  AwVariationsSeedFetcher$FetchTask(JobParameters paramJobParameters) {
    this.mParams = paramJobParameters;
  }
  
  private Void doInBackground$10299ca() {
    try {
      boolean bool;
      VariationsUtils.updateStampTime();
      if (AwVariationsSeedFetcher.access$000() != null) {
        AwVariationsSeedFetcher.access$000();
      } else {
        VariationsSeedFetcher.get();
      } 
      VariationsSeedFetcher.SeedInfo seedInfo = VariationsSeedFetcher.downloadContent(VariationsSeedFetcher.VariationsPlatform.ANDROID_WEBVIEW, null, "69", AwVariationsSeedFetcher.access$100());
      boolean bool1 = this.mCancelled.get();
      if (bool1)
        return null; 
      if (seedInfo != null) {
        VariationsSeedHolder variationsSeedHolder = AwVariationsSeedFetcher.access$200(AwVariationsSeedFetcher.this);
        AwVariationsSeedFetcher$FetchTask$$Lambda$0 awVariationsSeedFetcher$FetchTask$$Lambda$0 = new AwVariationsSeedFetcher$FetchTask$$Lambda$0(this);
        variationsSeedHolder.mSeedHandler.post(new VariationsSeedHolder$SeedUpdater(variationsSeedHolder, seedInfo, awVariationsSeedFetcher$FetchTask$$Lambda$0));
        bool = false;
      } else {
        bool = true;
      } 
    } catch (IOException iOException) {
    
    } finally {
      AwVariationsSeedFetcher.this.jobFinished(this.mParams);
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\AwVariationsSeedFetcher$FetchTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */