package org.chromium.content.browser;

final class TapDisambiguator$1$2 implements Runnable {
  public final void run() {
    if (containerView.indexOfChild(zoomer) != -1) {
      containerView.removeView(zoomer);
      containerView.invalidate();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\TapDisambiguator$1$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */