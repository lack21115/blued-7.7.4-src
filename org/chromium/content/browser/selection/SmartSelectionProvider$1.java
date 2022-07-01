package org.chromium.content.browser.selection;

import org.chromium.content_public.browser.SelectionClient;

final class SmartSelectionProvider$1 implements Runnable {
  public final void run() {
    SmartSelectionProvider.this.mResultCallback.onClassified(new SelectionClient.Result());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SmartSelectionProvider$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */