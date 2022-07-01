package org.chromium.components.minidump_uploader;

import org.chromium.base.ThreadUtils;

final class MinidumpUploaderImpl$1 implements Runnable {
  public final void run() {
    ThreadUtils.assertOnUiThread();
    MinidumpUploaderImpl.this.mWorkerThread.start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploaderImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */