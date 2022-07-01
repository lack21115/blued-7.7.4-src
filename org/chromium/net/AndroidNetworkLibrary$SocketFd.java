package org.chromium.net;

import java.io.FileDescriptor;
import java.net.Socket;

final class AndroidNetworkLibrary$SocketFd extends Socket {
  AndroidNetworkLibrary$SocketFd(FileDescriptor paramFileDescriptor) {
    super(new AndroidNetworkLibrary$SocketFd$SocketImplFd(paramFileDescriptor));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidNetworkLibrary$SocketFd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */