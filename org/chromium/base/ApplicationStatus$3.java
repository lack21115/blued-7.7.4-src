package org.chromium.base;

final class ApplicationStatus$3 implements Runnable {
  public final void run() {
    if (ApplicationStatus.access$400() != null)
      return; 
    ApplicationStatus.access$402(new ApplicationStatus$3$1());
    ApplicationStatus.registerApplicationStateListener(ApplicationStatus.access$400());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ApplicationStatus$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */