package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.Bitmap;

final class FaceDetection_Internal$FaceDetectionDetectParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public Bitmap bitmapData;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private FaceDetection_Internal$FaceDetectionDetectParams() {
    super(16);
  }
  
  public FaceDetection_Internal$FaceDetectionDetectParams(byte paramByte) {
    this();
  }
  
  private static FaceDetection_Internal$FaceDetectionDetectParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      FaceDetection_Internal$FaceDetectionDetectParams faceDetection_Internal$FaceDetectionDetectParams = new FaceDetection_Internal$FaceDetectionDetectParams();
      faceDetection_Internal$FaceDetectionDetectParams.bitmapData = Bitmap.decode(paramDecoder.readPointer(8, false));
      return faceDetection_Internal$FaceDetectionDetectParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static FaceDetection_Internal$FaceDetectionDetectParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode((Struct)this.bitmapData, 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetection_Internal$FaceDetectionDetectParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */