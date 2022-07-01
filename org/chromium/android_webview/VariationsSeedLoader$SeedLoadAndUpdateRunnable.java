package org.chromium.android_webview;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.FutureTask;
import org.chromium.base.Log;
import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

public final class VariationsSeedLoader$SeedLoadAndUpdateRunnable implements Runnable {
  private long mCurrentSeedDate = Long.MIN_VALUE;
  
  private boolean mEnabledByCmd;
  
  private volatile boolean mEnabledByExperiment;
  
  private boolean mFoundNewSeed;
  
  FutureTask mLoadTask = new FutureTask(new VariationsSeedLoader$SeedLoadAndUpdateRunnable$$Lambda$0(this));
  
  private boolean mNeedNewSeed;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public VariationsSeedLoader$SeedLoadAndUpdateRunnable(boolean paramBoolean) {
    this.mEnabledByCmd = paramBoolean;
  }
  
  public final boolean isVariationsEnabled() {
    assert false;
    throw new AssertionError();
  }
  
  public final void run() {
    this.mLoadTask.run();
    if (this.mFoundNewSeed)
      VariationsUtils.replaceOldWithNewSeed(); 
    if (this.mNeedNewSeed) {
      long l = this.mCurrentSeedDate;
      File file = VariationsUtils.getNewSeedFile();
      try {
        file.createNewFile();
        try {
          ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open(file, 536870912);
          (new VariationsSeedLoader$SeedServerConnection(parcelFileDescriptor, l)).start();
        } catch (FileNotFoundException fileNotFoundException) {
          StringBuilder stringBuilder = new StringBuilder("Failed to open seed file ");
          stringBuilder.append(file);
          Log.e("VariationsSeedLoader", stringBuilder.toString(), new Object[0]);
        } 
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder("Failed to create seed file ");
        stringBuilder.append(file);
        Log.e("VariationsSeedLoader", stringBuilder.toString(), new Object[0]);
      } 
      VariationsUtils.updateStampTime();
    } 
    VariationsSeedLoader.onBackgroundWorkFinished();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\VariationsSeedLoader$SeedLoadAndUpdateRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */