package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public FaceDetectorOptions options;
  
  public InterfaceRequest request;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams() {
    super(24);
  }
  
  public FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams(byte paramByte) {
    this();
  }
  
  private static FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams = new FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams();
      faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.request = paramDecoder.readInterfaceRequest(8, false);
      faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.options = FaceDetectorOptions.decode(paramDecoder.readPointer(16, false));
      return faceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.request, 8, false);
    paramEncoder.encode(this.options, 16, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\FaceDetectionProvider_Internal$FaceDetectionProviderCreateFaceDetectionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */