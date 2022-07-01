package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class NfcPushTarget {
  public static void validate(int paramInt) {
    switch (paramInt) {
      default:
        paramInt = 0;
        break;
      case 0:
      case 1:
      case 2:
        paramInt = 1;
        break;
    } 
    if (paramInt != 0)
      return; 
    throw new DeserializationException("Invalid enum value.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcPushTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */