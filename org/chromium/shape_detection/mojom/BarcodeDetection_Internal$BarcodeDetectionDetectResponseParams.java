package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public BarcodeDetectionResult[] results;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams() {
    super(16);
  }
  
  public BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams(byte paramByte) {
    this();
  }
  
  private static BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams barcodeDetection_Internal$BarcodeDetectionDetectResponseParams = new BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams();
      Decoder decoder = paramDecoder.readPointer(8, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      barcodeDetection_Internal$BarcodeDetectionDetectResponseParams.results = new BarcodeDetectionResult[dataHeader.elementsOrVersion];
      for (int i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        barcodeDetection_Internal$BarcodeDetectionDetectResponseParams.results[i] = BarcodeDetectionResult.decode(decoder1);
      } 
      return barcodeDetection_Internal$BarcodeDetectionDetectResponseParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.results == null) {
      paramEncoder.encodeNullPointer(8, false);
      return;
    } 
    paramEncoder = paramEncoder.encodePointerArray(this.results.length, 8, -1);
    for (int i = 0; i < this.results.length; i++)
      paramEncoder.encode(this.results[i], (i << 3) + 8, false); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetection_Internal$BarcodeDetectionDetectResponseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */