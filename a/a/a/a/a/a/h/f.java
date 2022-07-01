package a.a.a.a.a.a.h;

import a.a.a.a.a.e.e;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class f {
  public static int a = 2;
  
  public static boolean b = false;
  
  public static final float[] c;
  
  public static Object d = new Object();
  
  public static int a(int paramInt) {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10242, 33071.0F);
    GLES20.glTexParameterf(paramInt, 10243, 33071.0F);
    a("generateTexture");
    return i;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    int[] arrayOfInt = new int[1];
    boolean bool = false;
    GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
    GLES20.glBindRenderbuffer(36161, arrayOfInt[0]);
    GLES20.glRenderbufferStorage(36161, paramInt1, paramInt2, paramInt3);
    GLES20.glBindRenderbuffer(36161, 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("glRenderbufferStorage ");
    stringBuilder.append(arrayOfInt[0]);
    paramInt1 = bool;
    if (b(stringBuilder.toString()))
      paramInt1 = arrayOfInt[0]; 
    return paramInt1;
  }
  
  public static int a(int paramInt, String paramString) {
    int j = GLES20.glCreateShader(paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("glCreateShader type=");
    stringBuilder.append(paramInt);
    b(stringBuilder.toString());
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    int[] arrayOfInt = new int[1];
    GLES20.glGetShaderiv(j, 35713, arrayOfInt, 0);
    int i = j;
    if (arrayOfInt[0] == 0) {
      e e = e.c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Could not compile shader ");
      stringBuilder.append(paramInt);
      stringBuilder.append(":");
      e.e("GlUtil", stringBuilder.toString());
      e = e.c;
      stringBuilder = new StringBuilder();
      stringBuilder.append(" ");
      stringBuilder.append(GLES20.glGetShaderInfoLog(j));
      e.e("GlUtil", stringBuilder.toString());
      GLES20.glDeleteShader(j);
      i = 0;
    } 
    return i;
  }
  
  public static int a(String paramString1, String paramString2) {
    int i = a(35633, paramString1);
    if (i == 0)
      return 0; 
    int j = a(35632, paramString2);
    if (j == 0)
      return 0; 
    int k = GLES20.glCreateProgram();
    b("glCreateProgram");
    if (k == 0)
      e.c.e("GlUtil", "Could not create program"); 
    GLES20.glAttachShader(k, i);
    b("glAttachShader");
    GLES20.glAttachShader(k, j);
    b("glAttachShader");
    GLES20.glLinkProgram(k);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1) {
      e.c.e("GlUtil", "Could not link program: ");
      e.c.e("GlUtil", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    } 
    return k;
  }
  
  public static int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    b("glGenTextures");
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    b("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramByteBuffer);
    b("loadImageTexture");
    return i;
  }
  
  public static FloatBuffer a(float[] paramArrayOffloat) {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(paramArrayOffloat.length * 4);
    byteBuffer.order(ByteOrder.nativeOrder());
    FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
    floatBuffer.put(paramArrayOffloat);
    floatBuffer.position(0);
    return floatBuffer;
  }
  
  public static void a(Context paramContext) {
    ConfigurationInfo configurationInfo = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    if (configurationInfo != null && configurationInfo.reqGlEsVersion >= 196608)
      try {
        a = 7938;
        e.c.a("GlUtil", "In case of java code optimization");
        a = 3;
        b = true;
      } catch (NoClassDefFoundError noClassDefFoundError) {
        e.c.d("GlUtil", "System said it is 3.0, but it is not !!!");
      }  
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GL info, version:");
    stringBuilder.append(a);
    stringBuilder.append(", supports rg ext:");
    stringBuilder.append(b);
    e.c("GlUtil", stringBuilder.toString());
  }
  
  public static void a(String paramString) {
    int i = GLES20.glGetError();
    if (i == 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": GLES20 error: ");
    stringBuilder.append(i);
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public static boolean a() {
    return b;
  }
  
  public static int b(int paramInt) {
    int[] arrayOfInt = new int[1];
    boolean bool = false;
    GLES20.glGenBuffers(1, arrayOfInt, 0);
    GLES20.glBindBuffer(35051, arrayOfInt[0]);
    GLES20.glBufferData(35051, paramInt, null, 35049);
    GLES20.glBindBuffer(35051, 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("glBufferData ");
    stringBuilder.append(arrayOfInt[0]);
    paramInt = bool;
    if (b(stringBuilder.toString()))
      paramInt = arrayOfInt[0]; 
    return paramInt;
  }
  
  public static boolean b() {
    return (a > 2);
  }
  
  public static boolean b(String paramString) {
    int i = GLES20.glGetError();
    if (i != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(": glError 0x");
      stringBuilder.append(Integer.toHexString(i));
      paramString = stringBuilder.toString();
      e.c.e("GlUtil", paramString);
      return false;
    } 
    return true;
  }
  
  public static int c() {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public static int d() {
    int[] arrayOfInt = new int[1];
    GLES30.glGenVertexArrays(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public static int e() {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  static {
    float[] arrayOfFloat = new float[16];
    c = arrayOfFloat;
    Matrix.setIdentityM(arrayOfFloat, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */