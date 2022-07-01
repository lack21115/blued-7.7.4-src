package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;

public interface AndroidOverlay extends Interface {
  public static final Interface.Manager MANAGER = AndroidOverlay_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void scheduleLayout(Rect paramRect);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */