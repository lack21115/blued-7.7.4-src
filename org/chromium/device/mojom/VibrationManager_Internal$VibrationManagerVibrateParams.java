package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class VibrationManager_Internal$VibrationManagerVibrateParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public long milliseconds;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private VibrationManager_Internal$VibrationManagerVibrateParams() {
    super(16);
  }
  
  public VibrationManager_Internal$VibrationManagerVibrateParams(byte paramByte) {
    this();
  }
  
  private static VibrationManager_Internal$VibrationManagerVibrateParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      VibrationManager_Internal$VibrationManagerVibrateParams vibrationManager_Internal$VibrationManagerVibrateParams = new VibrationManager_Internal$VibrationManagerVibrateParams();
      vibrationManager_Internal$VibrationManagerVibrateParams.milliseconds = paramDecoder.readLong(8);
      return vibrationManager_Internal$VibrationManagerVibrateParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static VibrationManager_Internal$VibrationManagerVibrateParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.milliseconds, 8);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\VibrationManager_Internal$VibrationManagerVibrateParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */