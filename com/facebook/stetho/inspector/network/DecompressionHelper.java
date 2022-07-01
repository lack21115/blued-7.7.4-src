package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import javax.annotation.Nullable;

public class DecompressionHelper {
  static final String DEFLATE_ENCODING = "deflate";
  
  static final String GZIP_ENCODING = "gzip";
  
  public static InputStream teeInputWithDecompression(NetworkPeerManager paramNetworkPeerManager, String paramString1, InputStream paramInputStream, OutputStream paramOutputStream, @Nullable String paramString2, ResponseHandler paramResponseHandler) throws IOException {
    if (paramString2 != null) {
      CountingOutputStream countingOutputStream;
      boolean bool1 = "gzip".equals(paramString2);
      boolean bool2 = "deflate".equals(paramString2);
      if (bool1 || bool2) {
        CountingOutputStream countingOutputStream1 = new CountingOutputStream(paramOutputStream);
        if (bool1) {
          paramOutputStream = GunzippingOutputStream.create(countingOutputStream1);
          countingOutputStream = countingOutputStream1;
        } else {
          countingOutputStream = countingOutputStream1;
          if (bool2) {
            paramOutputStream = new InflaterOutputStream(countingOutputStream1);
            countingOutputStream = countingOutputStream1;
          } 
        } 
        return new ResponseHandlingInputStream(paramInputStream, paramString1, paramOutputStream, countingOutputStream, paramNetworkPeerManager, paramResponseHandler);
      } 
      Console.MessageLevel messageLevel = Console.MessageLevel.WARNING;
      Console.MessageSource messageSource = Console.MessageSource.NETWORK;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unsupported Content-Encoding in response for request #");
      stringBuilder.append(paramString1);
      stringBuilder.append(": ");
      stringBuilder.append((String)countingOutputStream);
      CLog.writeToConsole(paramNetworkPeerManager, messageLevel, messageSource, stringBuilder.toString());
    } 
    paramString2 = null;
    return new ResponseHandlingInputStream(paramInputStream, paramString1, paramOutputStream, (CountingOutputStream)paramString2, paramNetworkPeerManager, paramResponseHandler);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\DecompressionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */