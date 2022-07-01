package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBuilder {
  public static final MediaType ALTERNATIVE;
  
  private static final byte[] COLONSPACE;
  
  private static final byte[] CRLF;
  
  private static final byte[] DASHDASH;
  
  public static final MediaType DIGEST;
  
  public static final MediaType FORM;
  
  public static final MediaType MIXED = MediaType.parse("multipart/mixed");
  
  public static final MediaType PARALLEL;
  
  private final ByteString boundary;
  
  private final List<RequestBody> partBodies = new ArrayList<RequestBody>();
  
  private final List<Headers> partHeaders = new ArrayList<Headers>();
  
  private MediaType type = MIXED;
  
  static {
    ALTERNATIVE = MediaType.parse("multipart/alternative");
    DIGEST = MediaType.parse("multipart/digest");
    PARALLEL = MediaType.parse("multipart/parallel");
    FORM = MediaType.parse("multipart/form-data");
    COLONSPACE = new byte[] { 58, 32 };
    CRLF = new byte[] { 13, 10 };
    DASHDASH = new byte[] { 45, 45 };
  }
  
  public MultipartBuilder() {
    this(UUID.randomUUID().toString());
  }
  
  public MultipartBuilder(String paramString) {
    this.boundary = ByteString.encodeUtf8(paramString);
  }
  
  private static StringBuilder appendQuotedString(StringBuilder paramStringBuilder, String paramString) {
    paramStringBuilder.append('"');
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c != '\n') {
        if (c != '\r') {
          if (c != '"') {
            paramStringBuilder.append(c);
          } else {
            paramStringBuilder.append("%22");
          } 
        } else {
          paramStringBuilder.append("%0D");
        } 
      } else {
        paramStringBuilder.append("%0A");
      } 
    } 
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public MultipartBuilder addFormDataPart(String paramString1, String paramString2) {
    return addFormDataPart(paramString1, null, RequestBody.create((MediaType)null, paramString2));
  }
  
  public MultipartBuilder addFormDataPart(String paramString1, String paramString2, RequestBody paramRequestBody) {
    if (paramString1 != null) {
      StringBuilder stringBuilder = new StringBuilder("form-data; name=");
      appendQuotedString(stringBuilder, paramString1);
      if (paramString2 != null) {
        stringBuilder.append("; filename=");
        appendQuotedString(stringBuilder, paramString2);
      } 
      return addPart(Headers.of(new String[] { "Content-Disposition", stringBuilder.toString() }, ), paramRequestBody);
    } 
    throw new NullPointerException("name == null");
  }
  
  public MultipartBuilder addPart(Headers paramHeaders, RequestBody paramRequestBody) {
    if (paramRequestBody != null) {
      if (paramHeaders == null || paramHeaders.get("Content-Type") == null) {
        if (paramHeaders == null || paramHeaders.get("Content-Length") == null) {
          this.partHeaders.add(paramHeaders);
          this.partBodies.add(paramRequestBody);
          return this;
        } 
        throw new IllegalArgumentException("Unexpected header: Content-Length");
      } 
      throw new IllegalArgumentException("Unexpected header: Content-Type");
    } 
    throw new NullPointerException("body == null");
  }
  
  public MultipartBuilder addPart(RequestBody paramRequestBody) {
    return addPart(null, paramRequestBody);
  }
  
  public RequestBody build() {
    if (!this.partHeaders.isEmpty())
      return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies); 
    throw new IllegalStateException("Multipart body must have at least one part.");
  }
  
  public MultipartBuilder type(MediaType paramMediaType) {
    if (paramMediaType != null) {
      if (paramMediaType.type().equals("multipart")) {
        this.type = paramMediaType;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("multipart != ");
      stringBuilder.append(paramMediaType);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new NullPointerException("type == null");
  }
  
  static final class MultipartRequestBody extends RequestBody {
    private final ByteString boundary;
    
    private long contentLength = -1L;
    
    private final MediaType contentType;
    
    private final List<RequestBody> partBodies;
    
    private final List<Headers> partHeaders;
    
    public MultipartRequestBody(MediaType param1MediaType, ByteString param1ByteString, List<Headers> param1List, List<RequestBody> param1List1) {
      if (param1MediaType != null) {
        this.boundary = param1ByteString;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1MediaType);
        stringBuilder.append("; boundary=");
        stringBuilder.append(param1ByteString.utf8());
        this.contentType = MediaType.parse(stringBuilder.toString());
        this.partHeaders = Util.immutableList(param1List);
        this.partBodies = Util.immutableList(param1List1);
        return;
      } 
      throw new NullPointerException("type == null");
    }
    
    private long writeOrCountBytes(BufferedSink param1BufferedSink, boolean param1Boolean) throws IOException {
      Buffer buffer1;
      Buffer buffer2;
      if (param1Boolean) {
        buffer2 = new Buffer();
        buffer1 = buffer2;
      } else {
        Buffer buffer = null;
        buffer2 = buffer1;
        buffer1 = buffer;
      } 
      int j = this.partHeaders.size();
      long l1 = 0L;
      for (int i = 0; i < j; i++) {
        Headers headers = this.partHeaders.get(i);
        RequestBody requestBody = this.partBodies.get(i);
        buffer2.write(MultipartBuilder.DASHDASH);
        buffer2.write(this.boundary);
        buffer2.write(MultipartBuilder.CRLF);
        if (headers != null) {
          int m = headers.size();
          int k;
          for (k = 0; k < m; k++)
            buffer2.writeUtf8(headers.name(k)).write(MultipartBuilder.COLONSPACE).writeUtf8(headers.value(k)).write(MultipartBuilder.CRLF); 
        } 
        MediaType mediaType = requestBody.contentType();
        if (mediaType != null)
          buffer2.writeUtf8("Content-Type: ").writeUtf8(mediaType.toString()).write(MultipartBuilder.CRLF); 
        long l = requestBody.contentLength();
        if (l != -1L) {
          buffer2.writeUtf8("Content-Length: ").writeDecimalLong(l).write(MultipartBuilder.CRLF);
        } else if (param1Boolean) {
          buffer1.clear();
          return -1L;
        } 
        buffer2.write(MultipartBuilder.CRLF);
        if (param1Boolean) {
          l1 += l;
        } else {
          ((RequestBody)this.partBodies.get(i)).writeTo((BufferedSink)buffer2);
        } 
        buffer2.write(MultipartBuilder.CRLF);
      } 
      buffer2.write(MultipartBuilder.DASHDASH);
      buffer2.write(this.boundary);
      buffer2.write(MultipartBuilder.DASHDASH);
      buffer2.write(MultipartBuilder.CRLF);
      long l2 = l1;
      if (param1Boolean) {
        l2 = l1 + buffer1.size();
        buffer1.clear();
      } 
      return l2;
    }
    
    public long contentLength() throws IOException {
      long l = this.contentLength;
      if (l != -1L)
        return l; 
      l = writeOrCountBytes(null, true);
      this.contentLength = l;
      return l;
    }
    
    public MediaType contentType() {
      return this.contentType;
    }
    
    public void writeTo(BufferedSink param1BufferedSink) throws IOException {
      writeOrCountBytes(param1BufferedSink, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\MultipartBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */