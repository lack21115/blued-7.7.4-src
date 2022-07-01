package org.chromium.policy;

import android.os.Bundle;
import org.chromium.base.ThreadUtils;

public abstract class PolicyProvider {
  private CombinedPolicyProvider mCombinedPolicyProvider;
  
  private int mSource = -1;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public void notifySettingsAvailable(Bundle paramBundle) {
    ThreadUtils.assertOnUiThread();
    this.mCombinedPolicyProvider.onSettingsAvailable(this.mSource, paramBundle);
  }
  
  public abstract void refresh();
  
  public final void setManagerAndSource(CombinedPolicyProvider paramCombinedPolicyProvider, int paramInt) {
    assert false;
    throw new AssertionError();
  }
  
  protected void startListeningForPolicyChanges() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\policy\PolicyProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */