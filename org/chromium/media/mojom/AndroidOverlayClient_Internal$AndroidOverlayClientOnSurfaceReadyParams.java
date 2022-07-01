package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public long surfaceKey;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams() {
    super(16);
  }
  
  public AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams(byte paramByte) {
    this();
  }
  
  private static AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams = new AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams();
      androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams.surfaceKey = paramDecoder.readLong(8);
      return androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.surfaceKey, 8);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */