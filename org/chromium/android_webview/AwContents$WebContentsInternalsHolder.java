package org.chromium.android_webview;

import java.lang.ref.WeakReference;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsInternals;

final class AwContents$WebContentsInternalsHolder implements WebContents.InternalsHolder {
  final WeakReference mAwContentsRef;
  
  private AwContents$WebContentsInternalsHolder(AwContents paramAwContents) {
    this.mAwContentsRef = new WeakReference<AwContents>(paramAwContents);
  }
  
  public final WebContentsInternals get() {
    AwContents awContents = this.mAwContentsRef.get();
    return (awContents == null) ? null : AwContents.access$100(awContents);
  }
  
  public final void set(WebContentsInternals paramWebContentsInternals) {
    AwContents awContents = this.mAwContentsRef.get();
    if (awContents != null) {
      AwContents.access$102(awContents, paramWebContentsInternals);
      return;
    } 
    throw new IllegalStateException("AwContents should be available at this time");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$WebContentsInternalsHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */