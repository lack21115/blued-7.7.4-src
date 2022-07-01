package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class FaceDetection_Internal$FaceDetectionDetectResponseParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public FaceDetectionResult[] results;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private FaceDetection_Internal$FaceDetectionDetectResponseParams() {
    super(16);
  }
  
  public FaceDetection_Internal$FaceDetectionDetectResponseParams(byte paramByte) {
    this();
  }
  
  private static FaceDetection_Internal$FaceDetectionDetectResponseParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      FaceDetection_Internal$FaceDetectionDetectResponseParams faceDetection_Internal$FaceDetectionDetectResponseParams = new FaceDetection_Internal$FaceDetectionDetectResponseParams();
      Decoder decoder = paramDecoder.readPointer(8, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      faceDetection_Internal$FaceDetectionDetectResponseParams.results = new FaceDetectionResult[dataHeader.elementsOrVersion];
      for (int i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        faceDetection_Internal$FaceDetectionDetectResponseParams.results[i] = FaceDetectionResult.decode(decoder1);
      } 
      return faceDetection_Internal$FaceDetectionDetectResponseParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static FaceDetection_Internal$FaceDetectionDetectResponseParams deserialize(Message paramMessage) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetection_Internal$FaceDetectionDetectResponseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */