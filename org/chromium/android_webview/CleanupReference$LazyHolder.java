package org.chromium.android_webview;

import android.os.Handler;
import org.chromium.base.ThreadUtils;

final class CleanupReference$LazyHolder {
  static final Handler sHandler = new CleanupReference$LazyHolder$1(ThreadUtils.getUiThreadLooper());
  
  static {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\CleanupReference$LazyHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */