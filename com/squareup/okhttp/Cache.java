package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache {
  private static final int ENTRY_BODY = 1;
  
  private static final int ENTRY_COUNT = 2;
  
  private static final int ENTRY_METADATA = 0;
  
  private static final int VERSION = 201105;
  
  private final DiskLruCache cache;
  
  private int hitCount;
  
  final InternalCache internalCache = new InternalCache() {
      public Response get(Request param1Request) throws IOException {
        return Cache.this.get(param1Request);
      }
      
      public CacheRequest put(Response param1Response) throws IOException {
        return Cache.this.put(param1Response);
      }
      
      public void remove(Request param1Request) throws IOException {
        Cache.this.remove(param1Request);
      }
      
      public void trackConditionalCacheHit() {
        Cache.this.trackConditionalCacheHit();
      }
      
      public void trackResponse(CacheStrategy param1CacheStrategy) {
        Cache.this.trackResponse(param1CacheStrategy);
      }
      
      public void update(Response param1Response1, Response param1Response2) throws IOException {
        Cache.this.update(param1Response1, param1Response2);
      }
    };
  
  private int networkCount;
  
  private int requestCount;
  
  private int writeAbortCount;
  
  private int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong) {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  Cache(File paramFile, long paramLong, FileSystem paramFileSystem) {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(DiskLruCache.Editor paramEditor) {
    if (paramEditor != null)
      try {
        paramEditor.abort();
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
  
  private CacheRequest put(Response paramResponse) throws IOException {
    String str = paramResponse.request().method();
    if (HttpMethod.invalidatesCache(paramResponse.request().method()))
      try {
        remove(paramResponse.request());
        return null;
      } catch (IOException null) {
        return null;
      }  
    if (!str.equals("GET"))
      return null; 
    if (OkHeaders.hasVaryAll((Response)iOException))
      return null; 
    Entry entry = new Entry((Response)iOException);
    try {
      DiskLruCache.Editor editor = this.cache.edit(urlToKey(iOException.request()));
      if (editor == null)
        return null; 
      try {
        entry.writeTo(editor);
        return new CacheRequestImpl(editor);
      } catch (IOException iOException1) {}
    } catch (IOException iOException) {
      iOException = null;
    } 
    abortQuietly((DiskLruCache.Editor)iOException);
    return null;
  }
  
  private static int readInt(BufferedSource paramBufferedSource) throws IOException {
    try {
      long l = paramBufferedSource.readDecimalLong();
      String str = paramBufferedSource.readUtf8LineStrict();
      if (l >= 0L && l <= 2147483647L && str.isEmpty())
        return (int)l; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("expected an int but was \"");
      stringBuilder.append(l);
      stringBuilder.append(str);
      stringBuilder.append("\"");
      throw new IOException(stringBuilder.toString());
    } catch (NumberFormatException numberFormatException) {
      throw new IOException(numberFormatException.getMessage());
    } 
  }
  
  private void remove(Request paramRequest) throws IOException {
    this.cache.remove(urlToKey(paramRequest));
  }
  
  private void trackConditionalCacheHit() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield hitCount : I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield hitCount : I
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
  }
  
  private void trackResponse(CacheStrategy paramCacheStrategy) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield requestCount : I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield requestCount : I
    //   12: aload_1
    //   13: getfield networkRequest : Lcom/squareup/okhttp/Request;
    //   16: ifnull -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield networkCount : I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield networkCount : I
    //   29: goto -> 49
    //   32: aload_1
    //   33: getfield cacheResponse : Lcom/squareup/okhttp/Response;
    //   36: ifnull -> 49
    //   39: aload_0
    //   40: aload_0
    //   41: getfield hitCount : I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield hitCount : I
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  private void update(Response paramResponse1, Response paramResponse2) {
    Entry entry = new Entry(paramResponse2);
    DiskLruCache.Snapshot snapshot = ((CacheResponseBody)paramResponse1.body()).snapshot;
    try {
      DiskLruCache.Editor editor = snapshot.edit();
      if (editor != null) {
        try {
          entry.writeTo(editor);
          editor.commit();
          return;
        } catch (IOException iOException1) {}
      } else {
        return;
      } 
    } catch (IOException iOException) {
      iOException = null;
    } 
    abortQuietly((DiskLruCache.Editor)iOException);
  }
  
  private static String urlToKey(Request paramRequest) {
    return Util.md5Hex(paramRequest.urlString());
  }
  
  public void close() throws IOException {
    this.cache.close();
  }
  
  public void delete() throws IOException {
    this.cache.delete();
  }
  
  public void evictAll() throws IOException {
    this.cache.evictAll();
  }
  
  public void flush() throws IOException {
    this.cache.flush();
  }
  
  Response get(Request paramRequest) {
    String str = urlToKey(paramRequest);
    try {
      Response response;
      DiskLruCache.Snapshot snapshot = this.cache.get(str);
      if (snapshot == null)
        return null; 
      try {
        Entry entry = new Entry(snapshot.getSource(0));
        response = entry.response(paramRequest, snapshot);
        if (!entry.matches(paramRequest, response)) {
          Util.closeQuietly(response.body());
          return null;
        } 
        return response;
      } catch (IOException iOException) {}
      Util.closeQuietly((Closeable)response);
      return null;
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  public File getDirectory() {
    return this.cache.getDirectory();
  }
  
  public int getHitCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield hitCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public long getMaxSize() {
    return this.cache.getMaxSize();
  }
  
  public int getNetworkCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield networkCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getRequestCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield requestCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public long getSize() throws IOException {
    return this.cache.size();
  }
  
  public int getWriteAbortCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield writeAbortCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getWriteSuccessCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield writeSuccessCount : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void initialize() throws IOException {
    this.cache.initialize();
  }
  
  public boolean isClosed() {
    return this.cache.isClosed();
  }
  
  public Iterator<String> urls() throws IOException {
    return new Iterator<String>() {
        boolean canRemove;
        
        final Iterator<DiskLruCache.Snapshot> delegate = Cache.this.cache.snapshots();
        
        String nextUrl;
        
        public boolean hasNext() {
          if (this.nextUrl != null)
            return true; 
          this.canRemove = false;
          while (true) {
            if (this.delegate.hasNext()) {
              DiskLruCache.Snapshot snapshot = this.delegate.next();
              try {
                this.nextUrl = Okio.buffer(snapshot.getSource(0)).readUtf8LineStrict();
                return true;
              } catch (IOException iOException) {
                continue;
              } finally {
                snapshot.close();
              } 
            } 
            return false;
          } 
        }
        
        public String next() {
          if (hasNext()) {
            String str = this.nextUrl;
            this.nextUrl = null;
            this.canRemove = true;
            return str;
          } 
          throw new NoSuchElementException();
        }
        
        public void remove() {
          if (this.canRemove) {
            this.delegate.remove();
            return;
          } 
          throw new IllegalStateException("remove() before next()");
        }
      };
  }
  
  final class CacheRequestImpl implements CacheRequest {
    private Sink body;
    
    private Sink cacheOut;
    
    private boolean done;
    
    private final DiskLruCache.Editor editor;
    
    public CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
      this.editor = editor;
      this.cacheOut = editor.newSink(1);
      this.body = (Sink)new ForwardingSink(this.cacheOut) {
          public void close() throws IOException {
            synchronized (Cache.this) {
              if (Cache.CacheRequestImpl.this.done)
                return; 
              Cache.CacheRequestImpl.access$702(Cache.CacheRequestImpl.this, true);
              Cache.access$808(Cache.this);
              super.close();
              editor.commit();
              return;
            } 
          }
        };
    }
    
    public void abort() {
      Cache cache;
      synchronized (Cache.this) {
        if (this.done)
          return; 
        this.done = true;
        Cache.access$908(Cache.this);
        Util.closeQuietly((Closeable)this.cacheOut);
        try {
          this.editor.abort();
          return;
        } catch (IOException iOException) {}
      } 
    }
    
    public Sink body() {
      return this.body;
    }
  }
  
  class null extends ForwardingSink {
    null(Sink param1Sink) {
      super(param1Sink);
    }
    
    public void close() throws IOException {
      synchronized (Cache.this) {
        if (this.this$1.done)
          return; 
        Cache.CacheRequestImpl.access$702(this.this$1, true);
        Cache.access$808(Cache.this);
        super.close();
        editor.commit();
        return;
      } 
    }
  }
  
  static class CacheResponseBody extends ResponseBody {
    private final BufferedSource bodySource;
    
    private final String contentLength;
    
    private final String contentType;
    
    private final DiskLruCache.Snapshot snapshot;
    
    public CacheResponseBody(final DiskLruCache.Snapshot snapshot, String param1String1, String param1String2) {
      this.snapshot = snapshot;
      this.contentType = param1String1;
      this.contentLength = param1String2;
      this.bodySource = Okio.buffer((Source)new ForwardingSource(snapshot.getSource(1)) {
            public void close() throws IOException {
              snapshot.close();
              super.close();
            }
          });
    }
    
    public long contentLength() {
      long l = -1L;
      try {
        if (this.contentLength != null)
          l = Long.parseLong(this.contentLength); 
        return l;
      } catch (NumberFormatException numberFormatException) {
        return -1L;
      } 
    }
    
    public MediaType contentType() {
      String str = this.contentType;
      return (str != null) ? MediaType.parse(str) : null;
    }
    
    public BufferedSource source() {
      return this.bodySource;
    }
  }
  
  class null extends ForwardingSource {
    null(Source param1Source) {
      super(param1Source);
    }
    
    public void close() throws IOException {
      snapshot.close();
      super.close();
    }
  }
  
  static final class Entry {
    private final int code;
    
    private final Handshake handshake;
    
    private final String message;
    
    private final Protocol protocol;
    
    private final String requestMethod;
    
    private final Headers responseHeaders;
    
    private final String url;
    
    private final Headers varyHeaders;
    
    public Entry(Response param1Response) {
      this.url = param1Response.request().urlString();
      this.varyHeaders = OkHeaders.varyHeaders(param1Response);
      this.requestMethod = param1Response.request().method();
      this.protocol = param1Response.protocol();
      this.code = param1Response.code();
      this.message = param1Response.message();
      this.responseHeaders = param1Response.headers();
      this.handshake = param1Response.handshake();
    }
    
    public Entry(Source param1Source) throws IOException {
      try {
        BufferedSource bufferedSource = Okio.buffer(param1Source);
        this.url = bufferedSource.readUtf8LineStrict();
        this.requestMethod = bufferedSource.readUtf8LineStrict();
        Headers.Builder builder2 = new Headers.Builder();
        int j = Cache.readInt(bufferedSource);
        boolean bool = false;
        int i;
        for (i = 0; i < j; i++)
          builder2.addLenient(bufferedSource.readUtf8LineStrict()); 
        this.varyHeaders = builder2.build();
        StatusLine statusLine = StatusLine.parse(bufferedSource.readUtf8LineStrict());
        this.protocol = statusLine.protocol;
        this.code = statusLine.code;
        this.message = statusLine.message;
        Headers.Builder builder1 = new Headers.Builder();
        j = Cache.readInt(bufferedSource);
        for (i = bool; i < j; i++)
          builder1.addLenient(bufferedSource.readUtf8LineStrict()); 
        this.responseHeaders = builder1.build();
        if (isHttps()) {
          String str = bufferedSource.readUtf8LineStrict();
          if (str.length() <= 0) {
            this.handshake = Handshake.get(bufferedSource.readUtf8LineStrict(), readCertificateList(bufferedSource), readCertificateList(bufferedSource));
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected \"\" but was \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IOException(stringBuilder.toString());
          } 
        } else {
          this.handshake = null;
        } 
        return;
      } finally {
        param1Source.close();
      } 
    }
    
    private boolean isHttps() {
      return this.url.startsWith("https://");
    }
    
    private List<Certificate> readCertificateList(BufferedSource param1BufferedSource) throws IOException {
      int i = Cache.readInt(param1BufferedSource);
      if (i == -1)
        return Collections.emptyList(); 
      try {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ArrayList<Certificate> arrayList = new ArrayList(i);
        for (int j = 0; j < i; j++) {
          String str = param1BufferedSource.readUtf8LineStrict();
          Buffer buffer = new Buffer();
          buffer.write(ByteString.decodeBase64(str));
          arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
        } 
        return arrayList;
      } catch (CertificateException certificateException) {
        throw new IOException(certificateException.getMessage());
      } 
    }
    
    private void writeCertList(BufferedSink param1BufferedSink, List<Certificate> param1List) throws IOException {
      try {
        param1BufferedSink.writeDecimalLong(param1List.size());
        param1BufferedSink.writeByte(10);
        int i = 0;
        int j = param1List.size();
        while (i < j) {
          param1BufferedSink.writeUtf8(ByteString.of(((Certificate)param1List.get(i)).getEncoded()).base64());
          param1BufferedSink.writeByte(10);
          i++;
        } 
        return;
      } catch (CertificateEncodingException certificateEncodingException) {
        throw new IOException(certificateEncodingException.getMessage());
      } 
    }
    
    public boolean matches(Request param1Request, Response param1Response) {
      return (this.url.equals(param1Request.urlString()) && this.requestMethod.equals(param1Request.method()) && OkHeaders.varyMatches(param1Response, this.varyHeaders, param1Request));
    }
    
    public Response response(Request param1Request, DiskLruCache.Snapshot param1Snapshot) {
      String str1 = this.responseHeaders.get("Content-Type");
      String str2 = this.responseHeaders.get("Content-Length");
      Request request = (new Request.Builder()).url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
      return (new Response.Builder()).request(request).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(param1Snapshot, str1, str2)).handshake(this.handshake).build();
    }
    
    public void writeTo(DiskLruCache.Editor param1Editor) throws IOException {
      boolean bool = false;
      BufferedSink bufferedSink = Okio.buffer(param1Editor.newSink(0));
      bufferedSink.writeUtf8(this.url);
      bufferedSink.writeByte(10);
      bufferedSink.writeUtf8(this.requestMethod);
      bufferedSink.writeByte(10);
      bufferedSink.writeDecimalLong(this.varyHeaders.size());
      bufferedSink.writeByte(10);
      int j = this.varyHeaders.size();
      int i;
      for (i = 0; i < j; i++) {
        bufferedSink.writeUtf8(this.varyHeaders.name(i));
        bufferedSink.writeUtf8(": ");
        bufferedSink.writeUtf8(this.varyHeaders.value(i));
        bufferedSink.writeByte(10);
      } 
      bufferedSink.writeUtf8((new StatusLine(this.protocol, this.code, this.message)).toString());
      bufferedSink.writeByte(10);
      bufferedSink.writeDecimalLong(this.responseHeaders.size());
      bufferedSink.writeByte(10);
      j = this.responseHeaders.size();
      for (i = bool; i < j; i++) {
        bufferedSink.writeUtf8(this.responseHeaders.name(i));
        bufferedSink.writeUtf8(": ");
        bufferedSink.writeUtf8(this.responseHeaders.value(i));
        bufferedSink.writeByte(10);
      } 
      if (isHttps()) {
        bufferedSink.writeByte(10);
        bufferedSink.writeUtf8(this.handshake.cipherSuite());
        bufferedSink.writeByte(10);
        writeCertList(bufferedSink, this.handshake.peerCertificates());
        writeCertList(bufferedSink, this.handshake.localCertificates());
      } 
      bufferedSink.close();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */