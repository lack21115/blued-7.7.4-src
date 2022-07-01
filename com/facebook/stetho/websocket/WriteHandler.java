package com.facebook.stetho.websocket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class WriteHandler {
  private final BufferedOutputStream mBufferedOutput;
  
  public WriteHandler(OutputStream paramOutputStream) {
    this.mBufferedOutput = new BufferedOutputStream(paramOutputStream, 1024);
  }
  
  public void write(Frame paramFrame, WriteCallback paramWriteCallback) {
    /* monitor enter ThisExpression{ObjectType{com/facebook/stetho/websocket/WriteHandler}} */
    try {
      paramFrame.writeTo(this.mBufferedOutput);
      this.mBufferedOutput.flush();
      paramWriteCallback.onSuccess();
    } catch (IOException iOException) {
      paramWriteCallback.onFailure(iOException);
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/facebook/stetho/websocket/WriteHandler}} */
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\WriteHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */