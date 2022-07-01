package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

final class VibrationManager_Internal$VibrationManagerVibrateResponseParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO = (new DataHeader[1])[0];
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private VibrationManager_Internal$VibrationManagerVibrateResponseParams() {
    super(8);
  }
  
  public VibrationManager_Internal$VibrationManagerVibrateResponseParams(byte paramByte) {
    this();
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
  }
  
  static {
    (new DataHeader[1])[0] = new DataHeader(8, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager_Internal$VibrationManagerVibrateResponseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */