package com.facebook.stetho.dumpapp;

import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import com.facebook.stetho.server.http.PathMatcher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

@Deprecated
public class DumpappHttpSocketLikeHandler implements SocketLikeHandler {
  private final LightHttpServer mServer;
  
  public DumpappHttpSocketLikeHandler(Dumper paramDumper) {
    HandlerRegistry handlerRegistry = new HandlerRegistry();
    handlerRegistry.register((PathMatcher)new ExactPathMatcher("/dumpapp"), new DumpappLegacyHttpHandler(paramDumper));
    this.mServer = new LightHttpServer(handlerRegistry);
  }
  
  public void onAccepted(SocketLike paramSocketLike) throws IOException {
    this.mServer.serve(paramSocketLike);
  }
  
  static class DumpappLegacyHttpHandler implements HttpHandler {
    private static final String CONTENT_TYPE = "application/octet-stream";
    
    private static final String QUERY_PARAM_ARGV = "argv";
    
    private static final String RESPONSE_HEADER_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    
    private final Dumper mDumper;
    
    public DumpappLegacyHttpHandler(Dumper param1Dumper) {
      this.mDumper = param1Dumper;
    }
    
    public boolean handleRequest(SocketLike param1SocketLike, LightHttpRequest param1LightHttpRequest, LightHttpResponse param1LightHttpResponse) throws IOException {
      List list;
      boolean bool;
      boolean bool1 = "POST".equals(param1LightHttpRequest.method);
      if (!bool1 && "GET".equals(param1LightHttpRequest.method)) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool || bool1) {
        String str;
        list = param1LightHttpRequest.uri.getQueryParameters("argv");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Framer framer = new Framer(new ByteArrayInputStream(new byte[0]), byteArrayOutputStream);
        if (bool1) {
          str = "ERROR";
        } else {
          str = "WARNING";
        } 
        PrintStream printStream = framer.getStderr();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("*** ");
        stringBuilder1.append(str);
        stringBuilder1.append(": Using legacy HTTP protocol; update dumpapp script! ***");
        printStream.println(stringBuilder1.toString());
        if (bool) {
          DumpappSocketLikeHandler.dump(this.mDumper, framer, (String[])list.toArray((Object[])new String[list.size()]));
        } else {
          framer.writeExitCode(1);
        } 
        param1LightHttpResponse.code = 200;
        param1LightHttpResponse.reasonPhrase = "OK";
        param1LightHttpResponse.addHeader("Access-Control-Allow-Origin", "*");
        param1LightHttpResponse.body = LightHttpBody.create(byteArrayOutputStream.toByteArray(), "application/octet-stream");
        return true;
      } 
      param1LightHttpResponse.code = 501;
      param1LightHttpResponse.reasonPhrase = "Not implemented";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((LightHttpRequest)list).method);
      stringBuilder.append(" not implemented");
      param1LightHttpResponse.body = LightHttpBody.create(stringBuilder.toString(), "text/plain");
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\DumpappHttpSocketLikeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */