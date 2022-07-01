package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class FaceDetectorOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public boolean fastMode;
  
  public int maxDetectedFaces;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private FaceDetectorOptions() {
    super(16);
  }
  
  public FaceDetectorOptions(byte paramByte) {
    this();
  }
  
  public static FaceDetectorOptions decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      FaceDetectorOptions faceDetectorOptions = new FaceDetectorOptions();
      faceDetectorOptions.maxDetectedFaces = paramDecoder.readInt(8);
      faceDetectorOptions.fastMode = paramDecoder.readBoolean(12, 0);
      return faceDetectorOptions;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.maxDetectedFaces, 8);
    paramEncoder.encode(this.fastMode, 12, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetectorOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */