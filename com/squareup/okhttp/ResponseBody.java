package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;

public abstract class ResponseBody implements Closeable {
  private Reader reader;
  
  private Charset charset() {
    MediaType mediaType = contentType();
    return (mediaType != null) ? mediaType.charset(Util.UTF_8) : Util.UTF_8;
  }
  
  public static ResponseBody create(final MediaType contentType, final long contentLength, final BufferedSource content) {
    if (content != null)
      return new ResponseBody() {
          public long contentLength() {
            return contentLength;
          }
          
          public MediaType contentType() {
            return contentType;
          }
          
          public BufferedSource source() {
            return content;
          }
        }; 
    throw new NullPointerException("source == null");
  }
  
  public static ResponseBody create(MediaType paramMediaType, String paramString) {
    Charset charset = Util.UTF_8;
    MediaType mediaType = paramMediaType;
    if (paramMediaType != null) {
      Charset charset1 = paramMediaType.charset();
      charset = charset1;
      mediaType = paramMediaType;
      if (charset1 == null) {
        charset = Util.UTF_8;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramMediaType);
        stringBuilder.append("; charset=utf-8");
        mediaType = MediaType.parse(stringBuilder.toString());
      } 
    } 
    Buffer buffer = (new Buffer()).writeString(paramString, charset);
    return create(mediaType, buffer.size(), (BufferedSource)buffer);
  }
  
  public static ResponseBody create(MediaType paramMediaType, byte[] paramArrayOfbyte) {
    Buffer buffer = (new Buffer()).write(paramArrayOfbyte);
    return create(paramMediaType, paramArrayOfbyte.length, (BufferedSource)buffer);
  }
  
  public final InputStream byteStream() throws IOException {
    return source().inputStream();
  }
  
  public final byte[] bytes() throws IOException {
    long l = contentLength();
    if (l <= 2147483647L) {
      BufferedSource bufferedSource = source();
      try {
        byte[] arrayOfByte = bufferedSource.readByteArray();
        Util.closeQuietly((Closeable)bufferedSource);
        return arrayOfByte;
      } finally {
        Util.closeQuietly((Closeable)bufferedSource);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot buffer entire body for content length: ");
    stringBuilder.append(l);
    throw new IOException(stringBuilder.toString());
  }
  
  public final Reader charStream() throws IOException {
    Reader reader = this.reader;
    if (reader != null)
      return reader; 
    reader = new InputStreamReader(byteStream(), charset());
    this.reader = reader;
    return reader;
  }
  
  public void close() throws IOException {
    source().close();
  }
  
  public abstract long contentLength() throws IOException;
  
  public abstract MediaType contentType();
  
  public abstract BufferedSource source() throws IOException;
  
  public final String string() throws IOException {
    return new String(bytes(), charset().name());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\ResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */