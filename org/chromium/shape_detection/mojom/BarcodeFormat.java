package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class BarcodeFormat {
  public static void validate(int paramInt) {
    switch (paramInt) {
      default:
        paramInt = 0;
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
        paramInt = 1;
        break;
    } 
    if (paramInt != 0)
      return; 
    throw new DeserializationException("Invalid enum value.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */