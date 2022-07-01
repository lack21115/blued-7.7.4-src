package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public BarcodeDetectorOptions options;
  
  public InterfaceRequest request;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams() {
    super(24);
  }
  
  public BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams(byte paramByte) {
    this();
  }
  
  private static BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams = new BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams();
      barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.request = paramDecoder.readInterfaceRequest(8, false);
      barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.options = BarcodeDetectorOptions.decode(paramDecoder.readPointer(16, false));
      return barcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.request, 8, false);
    paramEncoder.encode(this.options, 16, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */