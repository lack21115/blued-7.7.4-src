package org.chromium.content.app;

import android.os.Bundle;
import java.util.Locale;

public final class ChromiumLinkerParams {
  public final long mBaseLoadAddress;
  
  public final String mTestRunnerClassNameForTesting;
  
  public final boolean mWaitForSharedRelro;
  
  public ChromiumLinkerParams(long paramLong, boolean paramBoolean) {
    this.mBaseLoadAddress = paramLong;
    this.mWaitForSharedRelro = paramBoolean;
    this.mTestRunnerClassNameForTesting = null;
  }
  
  public ChromiumLinkerParams(long paramLong, boolean paramBoolean, String paramString) {
    this.mBaseLoadAddress = paramLong;
    this.mWaitForSharedRelro = paramBoolean;
    this.mTestRunnerClassNameForTesting = paramString;
  }
  
  ChromiumLinkerParams(Bundle paramBundle) {
    this.mBaseLoadAddress = paramBundle.getLong("org.chromium.content.common.linker_params.base_load_address", 0L);
    this.mWaitForSharedRelro = paramBundle.getBoolean("org.chromium.content.common.linker_params.wait_for_shared_relro", false);
    this.mTestRunnerClassNameForTesting = paramBundle.getString("org.chromium.content.common.linker_params.test_runner_class_name");
  }
  
  public final String toString() {
    return String.format(Locale.US, "LinkerParams(baseLoadAddress:0x%x, waitForSharedRelro:%s, testRunnerClassName:%s", new Object[] { Long.valueOf(this.mBaseLoadAddress), Boolean.toString(this.mWaitForSharedRelro), this.mTestRunnerClassNameForTesting });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\app\ChromiumLinkerParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */