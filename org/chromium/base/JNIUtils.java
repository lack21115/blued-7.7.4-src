package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

public class JNIUtils {
  private static Boolean sSelectiveJniRegistrationEnabled;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void enableSelectiveJniRegistration() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  public static Object getClassLoader() {
    return JNIUtils.class.getClassLoader();
  }
  
  @CalledByNative
  public static boolean isSelectiveJniRegistrationEnabled() {
    if (sSelectiveJniRegistrationEnabled == null)
      sSelectiveJniRegistrationEnabled = Boolean.valueOf(false); 
    return sSelectiveJniRegistrationEnabled.booleanValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\JNIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */