package org.chromium.content.browser.webcontents;

import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsInternals;

final class WebContentsImpl$DefaultInternalsHolder implements WebContents.InternalsHolder {
  private WebContentsInternals mInternals;
  
  private WebContentsImpl$DefaultInternalsHolder() {}
  
  public final WebContentsInternals get() {
    return this.mInternals;
  }
  
  public final void set(WebContentsInternals paramWebContentsInternals) {
    this.mInternals = paramWebContentsInternals;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\webcontents\WebContentsImpl$DefaultInternalsHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */