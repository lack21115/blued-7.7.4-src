package com.blued.android.module.video_gift;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class VideoRenderer implements SurfaceTexture.OnFrameAvailableListener, GLTextureView.Renderer {
  private static String a = "VideoRender";
  
  private static int r = 36197;
  
  private final float[] b = new float[] { 
      -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, 
      -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  
  private FloatBuffer c = ByteBuffer.allocateDirect(this.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  
  private final String d = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  
  private final String e = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";
  
  private double f = 0.95D;
  
  private String g = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";
  
  private float[] h = new float[16];
  
  private float[] i = new float[16];
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private SurfaceTexture p;
  
  private boolean q = false;
  
  private OnSurfacePrepareListener s;
  
  private boolean t;
  
  private float u = 0.0F;
  
  private float v = 1.0F;
  
  private float w = 0.0F;
  
  VideoRenderer() {
    this.c.put(this.b).position(0);
    Matrix.setIdentityM(this.i, 0);
  }
  
  private int a(int paramInt, String paramString) {
    int j = GLES20.glCreateShader(paramInt);
    int i = j;
    if (j != 0) {
      GLES20.glShaderSource(j, paramString);
      GLES20.glCompileShader(j);
      int[] arrayOfInt = new int[1];
      GLES20.glGetShaderiv(j, 35713, arrayOfInt, 0);
      i = j;
      if (arrayOfInt[0] == 0) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not compile shader ");
        stringBuilder.append(paramInt);
        stringBuilder.append(":");
        Log.e(str, stringBuilder.toString());
        Log.e(a, GLES20.glGetShaderInfoLog(j));
        GLES20.glDeleteShader(j);
        i = 0;
      } 
    } 
    return i;
  }
  
  private int a(String paramString1, String paramString2) {
    int i = a(35633, paramString1);
    if (i == 0)
      return 0; 
    int j = a(35632, paramString2);
    if (j == 0)
      return 0; 
    int k = GLES20.glCreateProgram();
    if (k != 0) {
      GLES20.glAttachShader(k, i);
      b("glAttachShader");
      GLES20.glAttachShader(k, j);
      b("glAttachShader");
      GLES20.glLinkProgram(k);
      int[] arrayOfInt = new int[1];
      GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
      if (arrayOfInt[0] != 1) {
        Log.e(a, "Could not link program: ");
        Log.e(a, GLES20.glGetProgramInfoLog(k));
        GLES20.glDeleteProgram(k);
        return 0;
      } 
    } 
    return k;
  }
  
  private void a() {
    // Byte code:
    //   0: iconst_1
    //   1: newarray int
    //   3: astore_1
    //   4: iconst_1
    //   5: aload_1
    //   6: iconst_0
    //   7: invokestatic glGenTextures : (I[II)V
    //   10: aload_0
    //   11: aload_1
    //   12: iconst_0
    //   13: iaload
    //   14: putfield k : I
    //   17: getstatic com/blued/android/module/video_gift/VideoRenderer.r : I
    //   20: aload_0
    //   21: getfield k : I
    //   24: invokestatic glBindTexture : (II)V
    //   27: aload_0
    //   28: ldc 'glBindTexture textureID'
    //   30: invokespecial b : (Ljava/lang/String;)V
    //   33: getstatic com/blued/android/module/video_gift/VideoRenderer.r : I
    //   36: sipush #10241
    //   39: ldc 9728.0
    //   41: invokestatic glTexParameterf : (IIF)V
    //   44: getstatic com/blued/android/module/video_gift/VideoRenderer.r : I
    //   47: sipush #10240
    //   50: ldc 9729.0
    //   52: invokestatic glTexParameterf : (IIF)V
    //   55: aload_0
    //   56: new android/graphics/SurfaceTexture
    //   59: dup
    //   60: aload_0
    //   61: getfield k : I
    //   64: invokespecial <init> : (I)V
    //   67: putfield p : Landroid/graphics/SurfaceTexture;
    //   70: aload_0
    //   71: getfield p : Landroid/graphics/SurfaceTexture;
    //   74: aload_0
    //   75: invokevirtual setOnFrameAvailableListener : (Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   78: new android/view/Surface
    //   81: dup
    //   82: aload_0
    //   83: getfield p : Landroid/graphics/SurfaceTexture;
    //   86: invokespecial <init> : (Landroid/graphics/SurfaceTexture;)V
    //   89: astore_1
    //   90: aload_0
    //   91: getfield s : Lcom/blued/android/module/video_gift/VideoRenderer$OnSurfacePrepareListener;
    //   94: aload_1
    //   95: invokeinterface a : (Landroid/view/Surface;)V
    //   100: aload_0
    //   101: monitorenter
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield q : Z
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Exception table:
    //   from	to	target	type
    //   102	109	110	finally
    //   111	113	110	finally
  }
  
  private String b() {
    return this.t ? this.g : String.format(Locale.ENGLISH, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n", new Object[] { Float.valueOf(this.u), Float.valueOf(this.v), Float.valueOf(this.w), Double.valueOf(1.0D - this.f) });
  }
  
  private void b(String paramString) {
    int i = GLES20.glGetError();
    if (i == 0)
      return; 
    String str = a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append(": glError ");
    stringBuilder2.append(i);
    Log.e(str, stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString);
    stringBuilder1.append(": glError ");
    stringBuilder1.append(i);
    throw new RuntimeException(stringBuilder1.toString());
  }
  
  void a(OnSurfacePrepareListener paramOnSurfacePrepareListener) {
    this.s = paramOnSurfacePrepareListener;
  }
  
  void a(String paramString) {
    this.t = true;
    this.g = paramString;
  }
  
  public void a(GL10 paramGL10) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield q : Z
    //   6: ifeq -> 32
    //   9: aload_0
    //   10: getfield p : Landroid/graphics/SurfaceTexture;
    //   13: invokevirtual updateTexImage : ()V
    //   16: aload_0
    //   17: getfield p : Landroid/graphics/SurfaceTexture;
    //   20: aload_0
    //   21: getfield i : [F
    //   24: invokevirtual getTransformMatrix : ([F)V
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield q : Z
    //   32: aload_0
    //   33: monitorexit
    //   34: sipush #16640
    //   37: invokestatic glClear : (I)V
    //   40: sipush #3042
    //   43: invokestatic glEnable : (I)V
    //   46: sipush #770
    //   49: sipush #771
    //   52: invokestatic glBlendFunc : (II)V
    //   55: fconst_0
    //   56: fconst_0
    //   57: fconst_0
    //   58: fconst_0
    //   59: invokestatic glClearColor : (FFFF)V
    //   62: aload_0
    //   63: getfield j : I
    //   66: invokestatic glUseProgram : (I)V
    //   69: aload_0
    //   70: ldc_w 'glUseProgram'
    //   73: invokespecial b : (Ljava/lang/String;)V
    //   76: ldc_w 33984
    //   79: invokestatic glActiveTexture : (I)V
    //   82: getstatic com/blued/android/module/video_gift/VideoRenderer.r : I
    //   85: aload_0
    //   86: getfield k : I
    //   89: invokestatic glBindTexture : (II)V
    //   92: aload_0
    //   93: getfield c : Ljava/nio/FloatBuffer;
    //   96: iconst_0
    //   97: invokevirtual position : (I)Ljava/nio/Buffer;
    //   100: pop
    //   101: aload_0
    //   102: getfield n : I
    //   105: iconst_3
    //   106: sipush #5126
    //   109: iconst_0
    //   110: bipush #20
    //   112: aload_0
    //   113: getfield c : Ljava/nio/FloatBuffer;
    //   116: invokestatic glVertexAttribPointer : (IIIZILjava/nio/Buffer;)V
    //   119: aload_0
    //   120: ldc_w 'glVertexAttribPointer maPosition'
    //   123: invokespecial b : (Ljava/lang/String;)V
    //   126: aload_0
    //   127: getfield n : I
    //   130: invokestatic glEnableVertexAttribArray : (I)V
    //   133: aload_0
    //   134: ldc_w 'glEnableVertexAttribArray aPositionHandle'
    //   137: invokespecial b : (Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield c : Ljava/nio/FloatBuffer;
    //   144: iconst_3
    //   145: invokevirtual position : (I)Ljava/nio/Buffer;
    //   148: pop
    //   149: aload_0
    //   150: getfield o : I
    //   153: iconst_3
    //   154: sipush #5126
    //   157: iconst_0
    //   158: bipush #20
    //   160: aload_0
    //   161: getfield c : Ljava/nio/FloatBuffer;
    //   164: invokestatic glVertexAttribPointer : (IIIZILjava/nio/Buffer;)V
    //   167: aload_0
    //   168: ldc_w 'glVertexAttribPointer aTextureHandle'
    //   171: invokespecial b : (Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield o : I
    //   178: invokestatic glEnableVertexAttribArray : (I)V
    //   181: aload_0
    //   182: ldc_w 'glEnableVertexAttribArray aTextureHandle'
    //   185: invokespecial b : (Ljava/lang/String;)V
    //   188: aload_0
    //   189: getfield h : [F
    //   192: iconst_0
    //   193: invokestatic setIdentityM : ([FI)V
    //   196: aload_0
    //   197: getfield l : I
    //   200: iconst_1
    //   201: iconst_0
    //   202: aload_0
    //   203: getfield h : [F
    //   206: iconst_0
    //   207: invokestatic glUniformMatrix4fv : (IIZ[FI)V
    //   210: aload_0
    //   211: getfield m : I
    //   214: iconst_1
    //   215: iconst_0
    //   216: aload_0
    //   217: getfield i : [F
    //   220: iconst_0
    //   221: invokestatic glUniformMatrix4fv : (IIZ[FI)V
    //   224: iconst_5
    //   225: iconst_0
    //   226: iconst_4
    //   227: invokestatic glDrawArrays : (III)V
    //   230: aload_0
    //   231: ldc_w 'glDrawArrays'
    //   234: invokespecial b : (Ljava/lang/String;)V
    //   237: invokestatic glFinish : ()V
    //   240: return
    //   241: astore_1
    //   242: aload_0
    //   243: monitorexit
    //   244: aload_1
    //   245: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	241	finally
    //   32	34	241	finally
    //   242	244	241	finally
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2) {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void a(GL10 paramGL10, EGLConfig paramEGLConfig) {
    this.j = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", b());
    int i = this.j;
    if (i == 0)
      return; 
    this.n = GLES20.glGetAttribLocation(i, "aPosition");
    b("glGetAttribLocation aPosition");
    if (this.n != -1) {
      this.o = GLES20.glGetAttribLocation(this.j, "aTextureCoord");
      b("glGetAttribLocation aTextureCoord");
      if (this.o != -1) {
        this.l = GLES20.glGetUniformLocation(this.j, "uMVPMatrix");
        b("glGetUniformLocation uMVPMatrix");
        if (this.l != -1) {
          this.m = GLES20.glGetUniformLocation(this.j, "uSTMatrix");
          b("glGetUniformLocation uSTMatrix");
          if (this.m != -1) {
            a();
            return;
          } 
          throw new RuntimeException("Could not get attrib location for uSTMatrix");
        } 
        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
      } 
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    } 
    throw new RuntimeException("Could not get attrib location for aPosition");
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield q : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  static interface OnSurfacePrepareListener {
    void a(Surface param1Surface);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\video_gift\VideoRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */