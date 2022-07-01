package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink extends ForwardingSink {
  private boolean hasErrors;
  
  public FaultHidingSink(Sink paramSink) {
    super(paramSink);
  }
  
  public void close() throws IOException {
    if (this.hasErrors)
      return; 
    try {
      super.close();
      return;
    } catch (IOException iOException) {
      this.hasErrors = true;
      onException(iOException);
      return;
    } 
  }
  
  public void flush() throws IOException {
    if (this.hasErrors)
      return; 
    try {
      super.flush();
      return;
    } catch (IOException iOException) {
      this.hasErrors = true;
      onException(iOException);
      return;
    } 
  }
  
  protected void onException(IOException paramIOException) {}
  
  public void write(Buffer paramBuffer, long paramLong) throws IOException {
    if (this.hasErrors) {
      paramBuffer.skip(paramLong);
      return;
    } 
    try {
      super.write(paramBuffer, paramLong);
      return;
    } catch (IOException iOException) {
      this.hasErrors = true;
      onException(iOException);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\FaultHidingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */