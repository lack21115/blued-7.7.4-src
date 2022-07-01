package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class TextDetection_Internal$TextDetectionDetectResponseParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public TextDetectionResult[] results;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private TextDetection_Internal$TextDetectionDetectResponseParams() {
    super(16);
  }
  
  public TextDetection_Internal$TextDetectionDetectResponseParams(byte paramByte) {
    this();
  }
  
  private static TextDetection_Internal$TextDetectionDetectResponseParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      TextDetection_Internal$TextDetectionDetectResponseParams textDetection_Internal$TextDetectionDetectResponseParams = new TextDetection_Internal$TextDetectionDetectResponseParams();
      Decoder decoder = paramDecoder.readPointer(8, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      textDetection_Internal$TextDetectionDetectResponseParams.results = new TextDetectionResult[dataHeader.elementsOrVersion];
      for (int i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        textDetection_Internal$TextDetectionDetectResponseParams.results[i] = TextDetectionResult.decode(decoder1);
      } 
      return textDetection_Internal$TextDetectionDetectResponseParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static TextDetection_Internal$TextDetectionDetectResponseParams deserialize(Message paramMessage) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\TextDetection_Internal$TextDetectionDetectResponseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */