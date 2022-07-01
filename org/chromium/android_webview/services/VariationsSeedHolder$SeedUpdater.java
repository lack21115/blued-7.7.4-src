package org.chromium.android_webview.services;

import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

final class VariationsSeedHolder$SeedUpdater implements Runnable {
  private VariationsSeedFetcher.SeedInfo mNewSeed;
  
  private Runnable mOnFinished;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public VariationsSeedHolder$SeedUpdater(VariationsSeedFetcher.SeedInfo paramSeedInfo, Runnable paramRunnable) {
    this.mNewSeed = paramSeedInfo;
    this.mOnFinished = paramRunnable;
  }
  
  public final void run() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\VariationsSeedHolder$SeedUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */