package a.a.a.a.a.k.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Locale;

public final class a implements b {
  public static int a(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i;
    for (i = 0; i < paramInt2; i += j) {
      int j = paramInputStream.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
      if (j < 0)
        return i; 
    } 
    return i;
  }
  
  public static Socket a(InetSocketAddress paramInetSocketAddress, int paramInt) throws IOException {
    Socket socket = new Socket();
    socket.setTcpNoDelay(true);
    socket.setSoTimeout(30000);
    try {
      socket.connect(paramInetSocketAddress, paramInt);
      return socket;
    } catch (Exception exception) {
      socket.close();
      throw exception;
    } 
  }
  
  public static void a(OutputStream paramOutputStream, InputStream paramInputStream, int paramInt1, int paramInt2) throws IOException {
    byte[] arrayOfByte = new byte[paramInt1];
    paramOutputStream.write(String.format(Locale.getDefault(), "POST /ping HTTP/1.1\r\nHost: pilitest.qiniucdn.com:%d\r\nContent-Length: %d\r\n\r\n", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }).getBytes());
    a(paramOutputStream, arrayOfByte, 0, paramInt1);
    a(paramInputStream, arrayOfByte, 0, 32);
  }
  
  public static void a(OutputStream paramOutputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramOutputStream.write(paramArrayOfbyte, paramInt1, paramInt2);
    paramOutputStream.flush();
  }
  
  public c.e a(String paramString, int paramInt) {
    try {
      URI uRI = new URI(paramString);
      try {
        int i;
        Socket socket;
        InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(uRI.getHost());
        String str = arrayOfInetAddress[0].getHostAddress();
        if (uRI.getPort() == -1) {
          i = 1230;
        } else {
          i = uRI.getPort();
        } 
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        long l1 = System.currentTimeMillis();
        try {
          socket = a(inetSocketAddress, 30000);
          inetSocketAddress = null;
        } catch (IOException iOException1) {
          null = "connect failed";
          socket = null;
        } 
        long l2 = System.currentTimeMillis();
        if (socket == null)
          return new c.e(uRI.getHost(), str, (int)(l2 - l1), 0, null); 
        try {
          a(socket.getOutputStream(), socket.getInputStream(), paramInt, i);
        } catch (IOException iOException1) {
        
        } finally {
          try {
            socket.close();
          } catch (IOException iOException) {}
        } 
      } catch (UnknownHostException unknownHostException) {}
      return new c.e(uRI.getHost(), "", 0, 0, "unknownhost");
    } catch (URISyntaxException uRISyntaxException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */