package org.chromium.net;

import org.chromium.base.ApplicationStatus;

public final class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect$RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
  private boolean mDestroyed;
  
  protected final void destroy() {
    if (this.mDestroyed)
      return; 
    ApplicationStatus.unregisterApplicationStateListener(this);
    this.mDestroyed = true;
  }
  
  protected final void init(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect) {
    super.init(paramNetworkChangeNotifierAutoDetect);
    ApplicationStatus.registerApplicationStateListener(this);
    int i = ApplicationStatus.getStateForApplication();
    if (i == 1) {
      register();
      return;
    } 
    if (i == 2)
      unregister(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\RegistrationPolicyApplicationStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */