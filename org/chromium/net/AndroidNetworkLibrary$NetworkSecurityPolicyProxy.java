package org.chromium.net;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.NetworkSecurityPolicy;

public final class AndroidNetworkLibrary$NetworkSecurityPolicyProxy {
  private static AndroidNetworkLibrary$NetworkSecurityPolicyProxy sInstance = new AndroidNetworkLibrary$NetworkSecurityPolicyProxy();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static AndroidNetworkLibrary$NetworkSecurityPolicyProxy getInstance() {
    return sInstance;
  }
  
  @TargetApi(23)
  public static boolean isCleartextTrafficPermitted() {
    return (Build.VERSION.SDK_INT < 23) ? true : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidNetworkLibrary$NetworkSecurityPolicyProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */