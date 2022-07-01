package org.chromium.net;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import org.chromium.base.annotations.CalledByNative;

public class HttpNegotiateAuthenticator {
  private final String mAccountType;
  
  private Bundle mSpnegoContext;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private HttpNegotiateAuthenticator(String paramString) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  static HttpNegotiateAuthenticator create(String paramString) {
    return new HttpNegotiateAuthenticator(paramString);
  }
  
  static boolean lacksPermission(Context paramContext, String paramString, boolean paramBoolean) {
    return (paramBoolean && Build.VERSION.SDK_INT >= 23) ? false : ((paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) != 0));
  }
  
  @CalledByNative
  void getNextAuthToken(long paramLong, String paramString1, String paramString2, boolean paramBoolean) {
    assert false;
    throw new AssertionError();
  }
  
  native void nativeSetResult(long paramLong, int paramInt, String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\HttpNegotiateAuthenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */