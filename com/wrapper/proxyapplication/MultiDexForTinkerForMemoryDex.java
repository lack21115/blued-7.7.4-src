package com.wrapper.proxyapplication;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class MultiDexForTinkerForMemoryDex {
  static final String TAG = "MultiDexForTinkerForMemoryDex";
  
  static int hasInjected;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MultiDexForTinkerForMemoryDex() {
    throw new VerifyError("bad dex opcode");
  }
  
  private static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    findField(paramObject, paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  private static Field findField(Object paramObject, String paramString) throws NoSuchFieldException {
    throw new VerifyError("bad dex opcode");
  }
  
  private static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    throw new VerifyError("bad dex opcode");
  }
  
  private static Method findMethodinClazz(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    if (paramClass != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new VerifyError("bad dex opcode");
      }  
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
  
  private static String getprefixname(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static void installDexes(ClassLoader paramClassLoader, ByteBuffer[] paramArrayOfByteBuffer) throws IOException {
    try {
      Field field = findField(paramClassLoader, "pathList");
      try {
        V26.access$000(paramClassLoader, field, paramArrayOfByteBuffer);
        throw new VerifyError("bad dex opcode");
      } catch (IllegalArgumentException illegalArgumentException) {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalAccessException illegalAccessException) {
        throw new VerifyError("bad dex opcode");
      } catch (InvocationTargetException invocationTargetException) {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {}
      throw new IOException("v26,load dex fail");
    } catch (NoSuchFieldException noSuchFieldException) {}
    throw new VerifyError("bad dex opcode");
  }
  
  private static ArrayList<Object> openallDexes(ClassLoader paramClassLoader, String paramString1, String paramString2) {
    splitPaths(paramString1);
    new File(paramString2);
    try {
      findField(paramClassLoader, "pathList");
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalAccessException illegalAccessException) {
        throw new VerifyError("bad dex opcode");
      } catch (IllegalArgumentException illegalArgumentException) {}
      throw new VerifyError("bad dex opcode");
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private static ArrayList<File> splitPaths(String paramString) {
    ArrayList<File> arrayList = new ArrayList();
    if (paramString != null) {
      paramString = File.pathSeparator;
      throw new VerifyError("bad dex opcode");
    } 
    return arrayList;
  }
  
  private static final class V26 {
    private V26() {
      throw new VerifyError("bad dex opcode");
    }
    
    private static void install(ClassLoader param1ClassLoader, Field param1Field, ByteBuffer[] param1ArrayOfByteBuffer) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
      throw new VerifyError("bad dex opcode");
    }
    
    private static Object[] makeDexElements(Object param1Object, ByteBuffer[] param1ArrayOfByteBuffer, ArrayList<IOException> param1ArrayList) {
      try {
        MultiDexForTinkerForMemoryDex.findMethod(param1Object, "makeInMemoryDexElements", new Class[] { ByteBuffer[].class, List.class });
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalAccessException illegalAccessException) {
          throw new VerifyError("bad dex opcode");
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new VerifyError("bad dex opcode");
        } catch (InvocationTargetException invocationTargetException) {
          throw new VerifyError("bad dex opcode");
        } catch (RuntimeException runtimeException) {
          throw new VerifyError("bad dex opcode");
        } 
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new VerifyError("bad dex opcode");
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\wrapper\proxyapplication\MultiDexForTinkerForMemoryDex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */