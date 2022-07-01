package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public AndroidOverlayClient client;
  
  public AndroidOverlayConfig config;
  
  public InterfaceRequest overlay;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(32, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams() {
    super(32);
  }
  
  public AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams(byte paramByte) {
    this();
  }
  
  private static AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams = new AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams();
      androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.overlay = paramDecoder.readInterfaceRequest(8, false);
      androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.client = (AndroidOverlayClient)paramDecoder.readServiceInterface(12, false, AndroidOverlayClient.MANAGER);
      androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.config = AndroidOverlayConfig.decode(paramDecoder.readPointer(24, false));
      return androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.overlay, 8, false);
    paramEncoder.encode(this.client, 12, false, AndroidOverlayClient.MANAGER);
    paramEncoder.encode(this.config, 24, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */