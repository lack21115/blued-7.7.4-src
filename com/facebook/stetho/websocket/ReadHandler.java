package com.facebook.stetho.websocket;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class ReadHandler {
  private final BufferedInputStream mBufferedInput;
  
  private final ByteArrayOutputStream mCurrentPayload = new ByteArrayOutputStream();
  
  private final SimpleEndpoint mEndpoint;
  
  public ReadHandler(InputStream paramInputStream, SimpleEndpoint paramSimpleEndpoint) {
    this.mBufferedInput = new BufferedInputStream(paramInputStream, 1024);
    this.mEndpoint = paramSimpleEndpoint;
  }
  
  public void readLoop(ReadCallback paramReadCallback) throws IOException {
    Frame frame = new Frame();
    do {
      frame.readFrom(this.mBufferedInput);
      this.mCurrentPayload.write(frame.payloadData, 0, (int)frame.payloadLen);
      if (!frame.fin)
        continue; 
      byte[] arrayOfByte = this.mCurrentPayload.toByteArray();
      paramReadCallback.onCompleteFrame(frame.opcode, arrayOfByte, arrayOfByte.length);
      this.mCurrentPayload.reset();
    } while (frame.opcode != 8);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\ReadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */