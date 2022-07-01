package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class l {
  static final Logger a = Logger.getLogger(l.class.getName());
  
  public static d a(r paramr) {
    return new m(paramr);
  }
  
  public static e a(s params) {
    return new n(params);
  }
  
  private static r a(OutputStream paramOutputStream, t paramt) {
    if (paramOutputStream != null) {
      if (paramt != null)
        return new r(paramt, paramOutputStream) {
            public t a() {
              return this.a;
            }
            
            public void a_(c param1c, long param1Long) throws IOException {
              u.a(param1c.b, 0L, param1Long);
              while (param1Long > 0L) {
                this.a.g();
                o o = param1c.a;
                int i = (int)Math.min(param1Long, (o.c - o.b));
                this.b.write(o.a, o.b, i);
                o.b += i;
                long l2 = i;
                long l1 = param1Long - l2;
                param1c.b -= l2;
                param1Long = l1;
                if (o.b == o.c) {
                  param1c.a = o.b();
                  p.a(o);
                  param1Long = l1;
                } 
              } 
            }
            
            public void close() throws IOException {
              this.b.close();
            }
            
            public void flush() throws IOException {
              this.b.flush();
            }
            
            public String toString() {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("sink(");
              stringBuilder.append(this.b);
              stringBuilder.append(")");
              return stringBuilder.toString();
            }
          }; 
      throw new IllegalArgumentException("timeout == null");
    } 
    throw new IllegalArgumentException("out == null");
  }
  
  public static r a(Socket paramSocket) throws IOException {
    if (paramSocket != null) {
      if (paramSocket.getOutputStream() != null) {
        a a = c(paramSocket);
        return a.a(a(paramSocket.getOutputStream(), a));
      } 
      throw new IOException("socket's output stream == null");
    } 
    throw new IllegalArgumentException("socket == null");
  }
  
  public static s a(InputStream paramInputStream) {
    return a(paramInputStream, new t());
  }
  
  private static s a(InputStream paramInputStream, t paramt) {
    if (paramInputStream != null) {
      if (paramt != null)
        return new s(paramt, paramInputStream) {
            public long a(c param1c, long param1Long) throws IOException {
              int i = param1Long cmp 0L;
              if (i >= 0) {
                if (i == 0)
                  return 0L; 
                try {
                  this.a.g();
                  o o = param1c.e(1);
                  i = (int)Math.min(param1Long, (8192 - o.c));
                  i = this.b.read(o.a, o.c, i);
                  if (i == -1)
                    return -1L; 
                  o.c += i;
                  param1Long = param1c.b;
                  long l = i;
                  param1c.b = param1Long + l;
                  return l;
                } catch (AssertionError assertionError) {
                  if (l.a(assertionError))
                    throw new IOException(assertionError); 
                  throw assertionError;
                } 
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("byteCount < 0: ");
              stringBuilder.append(param1Long);
              throw new IllegalArgumentException(stringBuilder.toString());
            }
            
            public t a() {
              return this.a;
            }
            
            public void close() throws IOException {
              this.b.close();
            }
            
            public String toString() {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("source(");
              stringBuilder.append(this.b);
              stringBuilder.append(")");
              return stringBuilder.toString();
            }
          }; 
      throw new IllegalArgumentException("timeout == null");
    } 
    throw new IllegalArgumentException("in == null");
  }
  
  static boolean a(AssertionError paramAssertionError) {
    return (paramAssertionError.getCause() != null && paramAssertionError.getMessage() != null && paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static s b(Socket paramSocket) throws IOException {
    if (paramSocket != null) {
      if (paramSocket.getInputStream() != null) {
        a a = c(paramSocket);
        return a.a(a(paramSocket.getInputStream(), a));
      } 
      throw new IOException("socket's input stream == null");
    } 
    throw new IllegalArgumentException("socket == null");
  }
  
  private static a c(Socket paramSocket) {
    return new a(paramSocket) {
        protected IOException b(IOException param1IOException) {
          SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
          if (param1IOException != null)
            socketTimeoutException.initCause(param1IOException); 
          return socketTimeoutException;
        }
        
        protected void c() {
          try {
            this.b.close();
            return;
          } catch (Exception exception) {
            Logger logger = l.a;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to close timed out socket ");
            stringBuilder.append(this.b);
            logger.log(level, stringBuilder.toString(), exception);
            return;
          } catch (AssertionError assertionError) {
            if (l.a(assertionError)) {
              Logger logger = l.a;
              Level level = Level.WARNING;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Failed to close timed out socket ");
              stringBuilder.append(this.b);
              logger.log(level, stringBuilder.toString(), assertionError);
              return;
            } 
            throw assertionError;
          } 
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */