package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public boolean isPowerEfficient;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams() {
    super(16);
  }
  
  public AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams(byte paramByte) {
    this();
  }
  
  private static AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams = new AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams();
      androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.isPowerEfficient = paramDecoder.readBoolean(8, 0);
      return androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.isPowerEfficient, 8, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */