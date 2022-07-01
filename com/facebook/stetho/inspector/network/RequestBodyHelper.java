package com.facebook.stetho.inspector.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import javax.annotation.Nullable;

public class RequestBodyHelper {
  private ByteArrayOutputStream mDeflatedOutput;
  
  private CountingOutputStream mDeflatingOutput;
  
  private final NetworkEventReporter mEventReporter;
  
  private final String mRequestId;
  
  public RequestBodyHelper(NetworkEventReporter paramNetworkEventReporter, String paramString) {
    this.mEventReporter = paramNetworkEventReporter;
    this.mRequestId = paramString;
  }
  
  private void throwIfNoBody() {
    if (hasBody())
      return; 
    throw new IllegalStateException("No body found; has createBodySink been called?");
  }
  
  public OutputStream createBodySink(@Nullable String paramString) throws IOException {
    GunzippingOutputStream gunzippingOutputStream;
    ByteArrayOutputStream byteArrayOutputStream1;
    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
    if ("gzip".equals(paramString)) {
      gunzippingOutputStream = GunzippingOutputStream.create(byteArrayOutputStream2);
    } else if ("deflate".equals(gunzippingOutputStream)) {
      InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream2);
    } else {
      byteArrayOutputStream1 = byteArrayOutputStream2;
    } 
    this.mDeflatingOutput = new CountingOutputStream(byteArrayOutputStream1);
    this.mDeflatedOutput = byteArrayOutputStream2;
    return this.mDeflatingOutput;
  }
  
  public byte[] getDisplayBody() {
    throwIfNoBody();
    return this.mDeflatedOutput.toByteArray();
  }
  
  public boolean hasBody() {
    return (this.mDeflatedOutput != null);
  }
  
  public void reportDataSent() {
    throwIfNoBody();
    this.mEventReporter.dataSent(this.mRequestId, this.mDeflatedOutput.size(), (int)this.mDeflatingOutput.getCount());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\RequestBodyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */