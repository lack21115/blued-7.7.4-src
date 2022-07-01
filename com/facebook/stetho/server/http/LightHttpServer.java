package com.facebook.stetho.server.http;

import android.net.Uri;
import com.facebook.stetho.server.LeakyBufferedInputStream;
import com.facebook.stetho.server.SocketLike;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LightHttpServer {
  private static final String TAG = "LightHttpServer";
  
  private final HandlerRegistry mHandlerRegistry;
  
  public LightHttpServer(HandlerRegistry paramHandlerRegistry) {
    this.mHandlerRegistry = paramHandlerRegistry;
  }
  
  private boolean dispatchToHandler(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse) throws IOException {
    HttpHandler httpHandler = this.mHandlerRegistry.lookup(paramLightHttpRequest.uri.getPath());
    if (httpHandler == null) {
      paramLightHttpResponse.code = 404;
      paramLightHttpResponse.reasonPhrase = "Not found";
      paramLightHttpResponse.body = LightHttpBody.create("No handler found\n", "text/plain");
      return true;
    } 
    try {
      return httpHandler.handleRequest(paramSocketLike, paramLightHttpRequest, paramLightHttpResponse);
    } catch (RuntimeException null) {
      paramLightHttpResponse.code = 500;
      paramLightHttpResponse.reasonPhrase = "Internal Server Error";
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      try {
        null.printStackTrace(printWriter);
        printWriter.close();
        return true;
      } finally {
        printWriter.close();
      } 
    } 
  }
  
  private static void readHeaders(LightHttpMessage paramLightHttpMessage, HttpMessageReader paramHttpMessageReader) throws IOException {
    while (true) {
      String str = paramHttpMessageReader.readLine();
      if (str != null) {
        if ("".equals(str))
          return; 
        String[] arrayOfString = str.split(": ", 2);
        if (arrayOfString.length == 2) {
          str = arrayOfString[0];
          String str1 = arrayOfString[1];
          paramLightHttpMessage.headerNames.add(str);
          paramLightHttpMessage.headerValues.add(str1);
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Malformed header: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
      } 
      throw new EOFException();
    } 
  }
  
  private static LightHttpRequest readRequestMessage(LightHttpRequest paramLightHttpRequest, HttpMessageReader paramHttpMessageReader) throws IOException {
    paramLightHttpRequest.reset();
    String str = paramHttpMessageReader.readLine();
    if (str == null)
      return null; 
    String[] arrayOfString = str.split(" ", 3);
    if (arrayOfString.length == 3) {
      paramLightHttpRequest.method = arrayOfString[0];
      paramLightHttpRequest.uri = Uri.parse(arrayOfString[1]);
      paramLightHttpRequest.protocol = arrayOfString[2];
      readHeaders(paramLightHttpRequest, paramHttpMessageReader);
      return paramLightHttpRequest;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid request line: ");
    stringBuilder.append(str);
    throw new IOException(stringBuilder.toString());
  }
  
  private static void writeFullResponse(LightHttpResponse paramLightHttpResponse, HttpMessageWriter paramHttpMessageWriter, OutputStream paramOutputStream) throws IOException {
    paramLightHttpResponse.prepare();
    writeResponseMessage(paramLightHttpResponse, paramHttpMessageWriter);
    if (paramLightHttpResponse.body != null)
      paramLightHttpResponse.body.writeTo(paramOutputStream); 
  }
  
  public static void writeResponseMessage(LightHttpResponse paramLightHttpResponse, HttpMessageWriter paramHttpMessageWriter) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HTTP/1.1 ");
    stringBuilder.append(paramLightHttpResponse.code);
    stringBuilder.append(" ");
    stringBuilder.append(paramLightHttpResponse.reasonPhrase);
    paramHttpMessageWriter.writeLine(stringBuilder.toString());
    int j = paramLightHttpResponse.headerNames.size();
    for (int i = 0; i < j; i++) {
      String str1 = paramLightHttpResponse.headerNames.get(i);
      String str2 = paramLightHttpResponse.headerValues.get(i);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(": ");
      stringBuilder1.append(str2);
      paramHttpMessageWriter.writeLine(stringBuilder1.toString());
    } 
    paramHttpMessageWriter.writeLine();
    paramHttpMessageWriter.flush();
  }
  
  public void serve(SocketLike paramSocketLike) throws IOException {
    LeakyBufferedInputStream leakyBufferedInputStream = new LeakyBufferedInputStream(paramSocketLike.getInput(), 1024);
    OutputStream outputStream = paramSocketLike.getOutput();
    HttpMessageReader httpMessageReader = new HttpMessageReader((BufferedInputStream)leakyBufferedInputStream);
    HttpMessageWriter httpMessageWriter = new HttpMessageWriter(new BufferedOutputStream(outputStream));
    paramSocketLike = new SocketLike(paramSocketLike, leakyBufferedInputStream);
    LightHttpRequest lightHttpRequest = new LightHttpRequest();
    LightHttpResponse lightHttpResponse = new LightHttpResponse();
    while (true) {
      LightHttpRequest lightHttpRequest1 = readRequestMessage(lightHttpRequest, httpMessageReader);
      if (lightHttpRequest1 != null) {
        lightHttpResponse.reset();
        if (!dispatchToHandler(paramSocketLike, lightHttpRequest1, lightHttpResponse))
          return; 
        writeFullResponse(lightHttpResponse, httpMessageWriter, outputStream);
        continue;
      } 
      break;
    } 
  }
  
  static class HttpMessageReader {
    private final StringBuilder mBuffer = new StringBuilder();
    
    private final BufferedInputStream mIn;
    
    private final NewLineDetector mNewLineDetector = new NewLineDetector();
    
    public HttpMessageReader(BufferedInputStream param1BufferedInputStream) {
      this.mIn = param1BufferedInputStream;
    }
    
    public String readLine() throws IOException {
      while (true) {
        int i = this.mIn.read();
        if (i < 0)
          return null; 
        char c = (char)i;
        this.mNewLineDetector.accept(c);
        i = this.mNewLineDetector.state();
        if (i != 1) {
          if (i == 2 || i != 3)
            continue; 
          String str = this.mBuffer.toString();
          this.mBuffer.setLength(0);
          return str;
        } 
        this.mBuffer.append(c);
      } 
    }
    
    static class NewLineDetector {
      private static final int STATE_ON_CR = 2;
      
      private static final int STATE_ON_CRLF = 3;
      
      private static final int STATE_ON_OTHER = 1;
      
      private int state = 1;
      
      private NewLineDetector() {}
      
      public void accept(char param2Char) {
        int i = this.state;
        if (i != 1) {
          if (i != 2) {
            if (i == 3) {
              if (param2Char == '\r') {
                this.state = 2;
                return;
              } 
              this.state = 1;
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown state: ");
            stringBuilder.append(this.state);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
          if (param2Char == '\n') {
            this.state = 3;
            return;
          } 
          this.state = 1;
          return;
        } 
        if (param2Char == '\r')
          this.state = 2; 
      }
      
      public int state() {
        return this.state;
      }
    }
  }
  
  static class NewLineDetector {
    private static final int STATE_ON_CR = 2;
    
    private static final int STATE_ON_CRLF = 3;
    
    private static final int STATE_ON_OTHER = 1;
    
    private int state = 1;
    
    private NewLineDetector() {}
    
    public void accept(char param1Char) {
      int i = this.state;
      if (i != 1) {
        if (i != 2) {
          if (i == 3) {
            if (param1Char == '\r') {
              this.state = 2;
              return;
            } 
            this.state = 1;
            return;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown state: ");
          stringBuilder.append(this.state);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        if (param1Char == '\n') {
          this.state = 3;
          return;
        } 
        this.state = 1;
        return;
      } 
      if (param1Char == '\r')
        this.state = 2; 
    }
    
    public int state() {
      return this.state;
    }
  }
  
  public static class HttpMessageWriter {
    private static final byte[] CRLF = "\r\n".getBytes();
    
    private final BufferedOutputStream mOut;
    
    public HttpMessageWriter(BufferedOutputStream param1BufferedOutputStream) {
      this.mOut = param1BufferedOutputStream;
    }
    
    public void flush() throws IOException {
      this.mOut.flush();
    }
    
    public void writeLine() throws IOException {
      this.mOut.write(CRLF);
    }
    
    public void writeLine(String param1String) throws IOException {
      int j = param1String.length();
      for (int i = 0; i < j; i++) {
        char c = param1String.charAt(i);
        this.mOut.write(c);
      } 
      this.mOut.write(CRLF);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */