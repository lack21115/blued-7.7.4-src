package org.chromium.net;

import java.io.FileDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class AndroidNetworkLibrary$SetFileDescriptor {
  private static final Method sFileDescriptorSetInt;
  
  static {
    try {
      Class<int> clazz = int.class;
      throw new VerifyError("bad dex opcode");
    } catch (NoSuchMethodException|SecurityException noSuchMethodException) {
      throw new RuntimeException("Unable to get FileDescriptor.setInt$", noSuchMethodException);
    } 
  }
  
  public static FileDescriptor createWithFd(int paramInt) {
    try {
      FileDescriptor fileDescriptor = new FileDescriptor();
      sFileDescriptorSetInt.invoke(fileDescriptor, new Object[] { Integer.valueOf(paramInt) });
      return fileDescriptor;
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("FileDescriptor.setInt$() failed", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException("FileDescriptor.setInt$() failed", invocationTargetException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidNetworkLibrary$SetFileDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */