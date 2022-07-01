package org.chromium.shape_detection.mojom;

import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class FaceDetectionResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public RectF boundingBox;
  
  public Landmark[] landmarks;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private FaceDetectionResult() {
    super(24);
  }
  
  public FaceDetectionResult(byte paramByte) {
    this();
  }
  
  public static FaceDetectionResult decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      FaceDetectionResult faceDetectionResult = new FaceDetectionResult();
      faceDetectionResult.boundingBox = RectF.decode(paramDecoder.readPointer(8, false));
      Decoder decoder = paramDecoder.readPointer(16, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      faceDetectionResult.landmarks = new Landmark[dataHeader.elementsOrVersion];
      for (int i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        faceDetectionResult.landmarks[i] = Landmark.decode(decoder1);
      } 
      return faceDetectionResult;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode((Struct)this.boundingBox, 8, false);
    if (this.landmarks == null) {
      paramEncoder.encodeNullPointer(16, false);
      return;
    } 
    paramEncoder = paramEncoder.encodePointerArray(this.landmarks.length, 16, -1);
    for (int i = 0; i < this.landmarks.length; i++)
      paramEncoder.encode(this.landmarks[i], (i << 3) + 8, false); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */