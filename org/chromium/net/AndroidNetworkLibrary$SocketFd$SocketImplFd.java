package org.chromium.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;

final class AndroidNetworkLibrary$SocketFd$SocketImplFd extends SocketImpl {
  AndroidNetworkLibrary$SocketFd$SocketImplFd(FileDescriptor paramFileDescriptor) {
    this.fd = paramFileDescriptor;
  }
  
  protected final void accept(SocketImpl paramSocketImpl) {
    throw new RuntimeException("accept not implemented");
  }
  
  protected final int available() {
    throw new RuntimeException("accept not implemented");
  }
  
  protected final void bind(InetAddress paramInetAddress, int paramInt) {
    throw new RuntimeException("accept not implemented");
  }
  
  protected final void close() {}
  
  protected final void connect(String paramString, int paramInt) {
    throw new RuntimeException("connect not implemented");
  }
  
  protected final void connect(InetAddress paramInetAddress, int paramInt) {
    throw new RuntimeException("connect not implemented");
  }
  
  protected final void connect(SocketAddress paramSocketAddress, int paramInt) {
    throw new RuntimeException("connect not implemented");
  }
  
  protected final void create(boolean paramBoolean) {}
  
  protected final InputStream getInputStream() {
    throw new RuntimeException("getInputStream not implemented");
  }
  
  public final Object getOption(int paramInt) {
    throw new RuntimeException("getOption not implemented");
  }
  
  protected final OutputStream getOutputStream() {
    throw new RuntimeException("getOutputStream not implemented");
  }
  
  protected final void listen(int paramInt) {
    throw new RuntimeException("listen not implemented");
  }
  
  protected final void sendUrgentData(int paramInt) {
    throw new RuntimeException("sendUrgentData not implemented");
  }
  
  public final void setOption(int paramInt, Object paramObject) {
    throw new RuntimeException("setOption not implemented");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidNetworkLibrary$SocketFd$SocketImplFd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */