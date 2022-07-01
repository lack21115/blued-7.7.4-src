package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(8, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams() {
    super(8);
  }
  
  public AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams(byte paramByte) {
    this();
  }
  
  private static AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      return new AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams();
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */