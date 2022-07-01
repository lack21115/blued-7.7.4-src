package com.blued.android.module.external_sense_library.display;

import android.opengl.GLES20;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class STGLRender {
  public static final String CAMERA_INPUT_FRAGMENT_SHADER = "precision mediump float;\nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  
  private static final String CAMERA_INPUT_FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\n\nvoid main()\n{\n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  
  private static final String CAMERA_INPUT_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\tgl_Position = position;\n}";
  
  private static final String DRAW_POINTS_COLOR = "uColor";
  
  public static final String DRAW_POINTS_FRAGMENT_SHADER = "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}";
  
  private static final String DRAW_POINTS_POSITION = "aPosition";
  
  private static final String DRAW_POINTS_PROGRAM = "mPointProgram";
  
  public static final String DRAW_POINTS_VERTEX_SHADER = "attribute vec4 aPosition;\nvoid main() {\n  gl_PointSize = 2.0;  gl_Position = aPosition;\n}";
  
  private static final String POSITION_COORDINATE = "position";
  
  private static final String PROGRAM_ID = "program";
  
  private static final String TAG = "STGLRender";
  
  private static final String TEXTURE_COORDINATE = "inputTextureCoordinate";
  
  private static final String TEXTURE_UNIFORM = "inputImageTexture";
  
  private static final String UV_TEXTURE = "uv_texture";
  
  private static final String YUV_TEXTURE = "precision mediump float;                           \nvarying vec2 textureCoordinate;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void){                                  \n   float y = texture2D(y_texture, textureCoordinate).r;        \n   vec2 uv = texture2D(uv_texture, textureCoordinate).xw - 0.5;       \n   float r = y + 1.370705 * uv.x;\n   float g = y - 0.698001 * uv.x - 0.337633 * uv.y;\n   float b = y + 1.732446 * uv.y;\n                          \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n";
  
  private static final String Y_TEXTURE = "y_texture";
  
  private int YUVToRGBAProgramId = -1;
  
  private boolean activityModelLandscape = true;
  
  private int glError;
  
  private ArrayList<HashMap<String, Integer>> mArrayPrograms = new ArrayList<HashMap<String, Integer>>(2) {
    
    };
  
  private int mColor = -1;
  
  private int mDrawPointsProgram = 0;
  
  private int[] mFrameBufferTextures;
  
  private int[] mFrameBufferTexturesResize;
  
  private int[] mFrameBuffers;
  
  private int[] mFrameBuffersResize;
  
  private final FloatBuffer mGLCubeBuffer;
  
  private final FloatBuffer mGLSaveTextureBuffer;
  
  private final FloatBuffer mGLTextureBuffer;
  
  private int mHeightResize = 320;
  
  private boolean mIsInitialized;
  
  private boolean mNeedResize = false;
  
  private int[] mPointsFrameBuffers;
  
  private int mPosition = -1;
  
  private int[] mSavePictureFrameBufferTextures;
  
  private int[] mSavePictureFrameBuffers;
  
  private FloatBuffer mTextureBuffer;
  
  private FloatBuffer mVertexBuffer;
  
  private int mViewPortHeight;
  
  private int mViewPortWidth;
  
  private int mWidthResize = 180;
  
  private int uvTextureLoc = -1;
  
  private int yTextureLoc = -1;
  
  public STGLRender() {
    this(true);
  }
  
  public STGLRender(boolean paramBoolean) {
    this.activityModelLandscape = paramBoolean;
    this.mGLCubeBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.f.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLCubeBuffer.put(TextureRotationUtil.f).position(0);
    this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLTextureBuffer.put(TextureRotationUtil.b).position(0);
    this.mGLSaveTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLSaveTextureBuffer.put(TextureRotationUtil.c(0, false, true)).position(0);
    if (paramBoolean) {
      this.mTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.mTextureBuffer.put(TextureRotationUtil.d).position(0);
    } 
  }
  
  private void bindFrameBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void initFrameBuffers(int paramInt1, int paramInt2) {
    destroyFrameBuffers();
    destroyResizeFrameBuffers();
    if (this.mFrameBuffers == null) {
      this.mFrameBuffers = new int[2];
      this.mFrameBufferTextures = new int[2];
      GLES20.glGenFramebuffers(2, this.mFrameBuffers, 0);
      GLES20.glGenTextures(2, this.mFrameBufferTextures, 0);
      bindFrameBuffer(this.mFrameBufferTextures[0], this.mFrameBuffers[0], paramInt1, paramInt2);
      bindFrameBuffer(this.mFrameBufferTextures[1], this.mFrameBuffers[1], paramInt1, paramInt2);
    } 
    if (this.mSavePictureFrameBuffers == null) {
      this.mSavePictureFrameBuffers = new int[1];
      this.mSavePictureFrameBufferTextures = new int[1];
      GLES20.glGenFramebuffers(1, this.mSavePictureFrameBuffers, 0);
      GLES20.glGenTextures(1, this.mSavePictureFrameBufferTextures, 0);
      bindFrameBuffer(this.mSavePictureFrameBufferTextures[0], this.mSavePictureFrameBuffers[0], paramInt1, paramInt2);
    } 
    if (this.mNeedResize && this.mFrameBuffersResize == null) {
      this.mFrameBuffersResize = new int[2];
      this.mFrameBufferTexturesResize = new int[2];
      GLES20.glGenFramebuffers(2, this.mFrameBuffersResize, 0);
      GLES20.glGenTextures(2, this.mFrameBufferTexturesResize, 0);
      bindFrameBuffer(this.mFrameBufferTexturesResize[0], this.mFrameBuffersResize[0], this.mWidthResize, this.mHeightResize);
      bindFrameBuffer(this.mFrameBufferTexturesResize[1], this.mFrameBuffersResize[1], this.mWidthResize, this.mHeightResize);
    } 
  }
  
  private void initInner(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mViewPortWidth == paramInt1 && this.mViewPortHeight == paramInt2)
      return; 
    initProgram("#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\n\nvoid main()\n{\n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", this.mArrayPrograms.get(0));
    initProgram("precision mediump float;\nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", this.mArrayPrograms.get(1));
    initYUVProgram("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\tgl_Position = position;\n}", "precision mediump float;                           \nvarying vec2 textureCoordinate;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void){                                  \n   float y = texture2D(y_texture, textureCoordinate).r;        \n   vec2 uv = texture2D(uv_texture, textureCoordinate).xw - 0.5;       \n   float r = y + 1.370705 * uv.x;\n   float g = y - 0.698001 * uv.x - 0.337633 * uv.y;\n   float b = y + 1.732446 * uv.y;\n                          \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    this.mViewPortWidth = paramInt1;
    this.mViewPortHeight = paramInt2;
    this.mWidthResize = paramInt3;
    this.mHeightResize = paramInt4;
    if (this.mWidthResize > 0 && this.mHeightResize > 0)
      this.mNeedResize = true; 
    initFrameBuffers(paramInt1, paramInt2);
    this.mIsInitialized = true;
  }
  
  private void initProgram(String paramString, HashMap<String, Integer> paramHashMap) {
    if (((Integer)paramHashMap.get("program")).intValue() == 0) {
      int i = OpenGLUtils.a("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n\ttextureCoordinate = inputTextureCoordinate.xy;\n\tgl_Position = position;\n}", paramString);
      paramHashMap.put("program", Integer.valueOf(i));
      paramHashMap.put("position", Integer.valueOf(GLES20.glGetAttribLocation(i, "position")));
      paramHashMap.put("inputImageTexture", Integer.valueOf(GLES20.glGetUniformLocation(i, "inputImageTexture")));
      paramHashMap.put("inputTextureCoordinate", Integer.valueOf(GLES20.glGetAttribLocation(i, "inputTextureCoordinate")));
    } 
  }
  
  private void initYUVProgram(String paramString1, String paramString2) {
    this.YUVToRGBAProgramId = OpenGLUtils.a(paramString1, paramString2);
    this.yTextureLoc = GLES20.glGetUniformLocation(this.YUVToRGBAProgramId, "y_texture");
    this.uvTextureLoc = GLES20.glGetUniformLocation(this.YUVToRGBAProgramId, "uv_texture");
  }
  
  public int YUV2RGB(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (this.mFrameBuffers == null || !this.mIsInitialized)
      return -2; 
    GLES20.glUseProgram(this.YUVToRGBAProgramId);
    GlUtil.a("glUseProgram");
    this.mGLCubeBuffer.position(0);
    int i = ((Integer)((HashMap)this.mArrayPrograms.get(0)).get("position")).intValue();
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.mGLCubeBuffer);
    GLES20.glEnableVertexAttribArray(i);
    this.mTextureBuffer.position(0);
    int j = ((Integer)((HashMap)this.mArrayPrograms.get(0)).get("inputTextureCoordinate")).intValue();
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, this.mTextureBuffer);
    GLES20.glEnableVertexAttribArray(j);
    if (paramInt1 != -1) {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.yTextureLoc, 0);
    } 
    if (paramInt2 != -1) {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glUniform1i(this.uvTextureLoc, 1);
    } 
    if (paramBoolean) {
      GLES20.glBindFramebuffer(36160, this.mFrameBuffers[0]);
    } else {
      GLES20.glBindFramebuffer(36160, this.mFrameBuffers[1]);
    } 
    GlUtil.a("glBindFramebuffer");
    GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(i);
    GLES20.glDisableVertexAttribArray(j);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glUseProgram(0);
    return paramBoolean ? this.mFrameBufferTextures[0] : this.mFrameBufferTextures[1];
  }
  
  public void adjustTextureBuffer(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    float[] arrayOfFloat = TextureRotationUtil.a(paramInt, paramBoolean1, paramBoolean2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("==========rotation: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" flipVertical: ");
    stringBuilder.append(paramBoolean2);
    stringBuilder.append(" texturePos: ");
    stringBuilder.append(Arrays.toString(arrayOfFloat));
    LogUtils.b("STGLRender", stringBuilder.toString());
    if (this.mTextureBuffer == null)
      this.mTextureBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer(); 
    this.mTextureBuffer.clear();
    this.mTextureBuffer.put(arrayOfFloat).position(0);
  }
  
  public void adjustVideoTextureBuffer(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    float[] arrayOfFloat = TextureRotationUtil.d(paramInt, paramBoolean1, paramBoolean2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("==========rotation: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" flipVertical: ");
    stringBuilder.append(paramBoolean2);
    stringBuilder.append(" texturePos: ");
    stringBuilder.append(Arrays.toString(arrayOfFloat));
    LogUtils.b("STGLRender", stringBuilder.toString());
    if (this.mTextureBuffer == null)
      this.mTextureBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer(); 
    this.mTextureBuffer.clear();
    this.mTextureBuffer.put(arrayOfFloat).position(0);
  }
  
  public void adjustZegoTextureBuffer(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    float[] arrayOfFloat = TextureRotationUtil.b(paramInt, paramBoolean1, paramBoolean2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("==========rotation: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" flipVertical: ");
    stringBuilder.append(paramBoolean2);
    stringBuilder.append(" texturePos: ");
    stringBuilder.append(Arrays.toString(arrayOfFloat));
    LogUtils.b("STGLRender", stringBuilder.toString());
    if (this.mTextureBuffer == null)
      this.mTextureBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer(); 
    this.mTextureBuffer.clear();
    this.mTextureBuffer.put(arrayOfFloat).position(0);
  }
  
  public void calculateVertexBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f2 = paramInt1;
    float f3 = paramInt3;
    float f5 = f2 / f3;
    float f1 = paramInt2;
    float f4 = paramInt4;
    f5 = Math.min(f5, f1 / f4);
    paramInt1 = Math.round(f3 * f5);
    paramInt2 = Math.round(f4 * f5);
    f2 = paramInt1 / f2;
    f1 = paramInt2 / f1;
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = TextureRotationUtil.f[0] / f1;
    arrayOfFloat[1] = TextureRotationUtil.f[1] / f2;
    arrayOfFloat[2] = TextureRotationUtil.f[2] / f1;
    arrayOfFloat[3] = TextureRotationUtil.f[3] / f2;
    arrayOfFloat[4] = TextureRotationUtil.f[4] / f1;
    arrayOfFloat[5] = TextureRotationUtil.f[5] / f2;
    arrayOfFloat[6] = TextureRotationUtil.f[6] / f1;
    arrayOfFloat[7] = TextureRotationUtil.f[7] / f2;
    if (this.mVertexBuffer == null)
      this.mVertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer(); 
    this.mVertexBuffer.clear();
    this.mVertexBuffer.put(arrayOfFloat).position(0);
  }
  
  public void calculateZegoVertexBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f2 = paramInt1;
    float f3 = paramInt3;
    float f5 = f2 / f3;
    float f1 = paramInt2;
    float f4 = paramInt4;
    f5 = Math.min(f5, f1 / f4);
    paramInt1 = Math.round(f3 * f5);
    paramInt2 = Math.round(f4 * f5);
    f2 = paramInt1 / f2;
    f1 = paramInt2 / f1;
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = TextureRotationUtil.f[0] / f1;
    arrayOfFloat[1] = TextureRotationUtil.f[1] / f2;
    arrayOfFloat[2] = TextureRotationUtil.f[2] / f1;
    arrayOfFloat[3] = TextureRotationUtil.f[3] / f2;
    arrayOfFloat[4] = TextureRotationUtil.f[4] / f1;
    arrayOfFloat[5] = TextureRotationUtil.f[5] / f2;
    arrayOfFloat[6] = TextureRotationUtil.f[6] / f1;
    arrayOfFloat[7] = TextureRotationUtil.f[7] / f2;
    if (this.mVertexBuffer == null)
      this.mVertexBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer(); 
    this.mVertexBuffer.clear();
    this.mVertexBuffer.put(arrayOfFloat).position(0);
  }
  
  public final void destroy() {
    this.mIsInitialized = false;
    destroyFrameBuffers();
    GLES20.glDeleteProgram(((Integer)((HashMap)this.mArrayPrograms.get(0)).get("program")).intValue());
    GLES20.glDeleteProgram(((Integer)((HashMap)this.mArrayPrograms.get(1)).get("program")).intValue());
    if (!this.activityModelLandscape)
      GLES20.glDeleteProgram(((Integer)((HashMap)this.mArrayPrograms.get(2)).get("program")).intValue()); 
  }
  
  public void destroyFrameBuffers() {
    int[] arrayOfInt = this.mFrameBufferTextures;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.mFrameBufferTextures = null;
    } 
    arrayOfInt = this.mFrameBuffers;
    if (arrayOfInt != null) {
      GLES20.glDeleteFramebuffers(2, arrayOfInt, 0);
      this.mFrameBuffers = null;
    } 
    arrayOfInt = this.mSavePictureFrameBufferTextures;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mSavePictureFrameBufferTextures = null;
    } 
    arrayOfInt = this.mSavePictureFrameBuffers;
    if (arrayOfInt != null) {
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      this.mSavePictureFrameBuffers = null;
    } 
    arrayOfInt = this.mPointsFrameBuffers;
    if (arrayOfInt != null) {
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      this.mPointsFrameBuffers = null;
    } 
  }
  
  public void destroyResizeFrameBuffers() {
    int[] arrayOfInt = this.mFrameBufferTexturesResize;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.mFrameBufferTexturesResize = null;
    } 
    arrayOfInt = this.mFrameBuffersResize;
    if (arrayOfInt != null) {
      GLES20.glDeleteFramebuffers(2, arrayOfInt, 0);
      this.mFrameBuffersResize = null;
    } 
  }
  
  public void init(int paramInt1, int paramInt2) {
    initInner(paramInt1, paramInt2, -1, -1);
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    initInner(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void initDrawPoints() {
    this.mDrawPointsProgram = OpenGLUtils.a("attribute vec4 aPosition;\nvoid main() {\n  gl_PointSize = 2.0;  gl_Position = aPosition;\n}", "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}");
    this.mColor = GLES20.glGetAttribLocation(this.mDrawPointsProgram, "aPosition");
    this.mPosition = GLES20.glGetUniformLocation(this.mDrawPointsProgram, "uColor");
    if (this.mPointsFrameBuffers == null) {
      this.mPointsFrameBuffers = new int[1];
      GLES20.glGenFramebuffers(1, this.mPointsFrameBuffers, 0);
    } 
  }
  
  public int onDrawFrame(int paramInt) {
    if (!this.mIsInitialized)
      return -1; 
    GLES20.glUseProgram(((Integer)((HashMap)this.mArrayPrograms.get(1)).get("program")).intValue());
    this.mVertexBuffer.position(0);
    int i = ((Integer)((HashMap)this.mArrayPrograms.get(1)).get("position")).intValue();
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.mVertexBuffer);
    GLES20.glEnableVertexAttribArray(i);
    this.mGLTextureBuffer.position(0);
    int j = ((Integer)((HashMap)this.mArrayPrograms.get(1)).get("inputTextureCoordinate")).intValue();
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, this.mGLTextureBuffer);
    GLES20.glEnableVertexAttribArray(j);
    if (paramInt != -1) {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(((Integer)((HashMap)this.mArrayPrograms.get(1)).get("inputImageTexture")).intValue(), 0);
    } 
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(i);
    GLES20.glDisableVertexAttribArray(j);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, 0);
    return 1;
  }
  
  public void onDrawPoints(int paramInt, float[] paramArrayOffloat) {
    if (this.mDrawPointsProgram == 0)
      initDrawPoints(); 
    GLES20.glUseProgram(this.mDrawPointsProgram);
    GLES20.glUniform4f(this.mColor, 0.0F, 1.0F, 0.0F, 1.0F);
    FloatBuffer floatBuffer = ByteBuffer.allocateDirect(paramArrayOffloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    floatBuffer.clear();
    floatBuffer.put(paramArrayOffloat).position(0);
    GLES20.glVertexAttribPointer(this.mPosition, 2, 5126, false, 0, floatBuffer);
    GLES20.glEnableVertexAttribArray(this.mPosition);
    GLES20.glBindFramebuffer(36160, this.mPointsFrameBuffers[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    GlUtil.a("glBindFramebuffer");
    GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
    GLES20.glDrawArrays(0, 0, paramArrayOffloat.length / 2);
    GLES20.glDisableVertexAttribArray(this.mPosition);
    this.glError = GLES20.glGetError();
    if (this.glError != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CatchGLError : ");
      stringBuilder.append(this.glError);
      LogUtils.b("STGLRender", stringBuilder.toString());
    } 
  }
  
  public int preProcess(int paramInt, ByteBuffer paramByteBuffer) {
    return preProcess(paramInt, paramByteBuffer, 0);
  }
  
  public int preProcess(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2) {
    if (this.mFrameBuffers != null) {
      if (!this.mIsInitialized)
        return -1; 
      GLES20.glUseProgram(((Integer)((HashMap)this.mArrayPrograms.get(0)).get("program")).intValue());
      GlUtil.a("glUseProgram");
      this.mGLCubeBuffer.position(0);
      int i = ((Integer)((HashMap)this.mArrayPrograms.get(0)).get("position")).intValue();
      GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.mGLCubeBuffer);
      GLES20.glEnableVertexAttribArray(i);
      this.mTextureBuffer.position(0);
      int j = ((Integer)((HashMap)this.mArrayPrograms.get(0)).get("inputTextureCoordinate")).intValue();
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, this.mTextureBuffer);
      GLES20.glEnableVertexAttribArray(j);
      if (paramInt1 != -1) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, paramInt1);
        GLES20.glUniform1i(((Integer)((HashMap)this.mArrayPrograms.get(0)).get("inputImageTexture")).intValue(), 0);
      } 
      GLES20.glBindFramebuffer(36160, this.mFrameBuffers[paramInt2]);
      GlUtil.a("glBindFramebuffer");
      GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
      GLES20.glDrawArrays(5, 0, 4);
      if (paramByteBuffer != null)
        if (this.mNeedResize) {
          GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[paramInt2]);
          GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTexturesResize[paramInt2], 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindFramebuffer(36160, this.mFrameBuffers[paramInt2]);
          GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[paramInt2]);
          GLES20.glViewport(0, 0, this.mWidthResize, this.mHeightResize);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[paramInt2]);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glReadPixels(0, 0, this.mWidthResize, this.mHeightResize, 6408, 5121, paramByteBuffer);
          GLES20.glBindFramebuffer(36160, 0);
        } else {
          GLES20.glReadPixels(0, 0, this.mViewPortWidth, this.mViewPortHeight, 6408, 5121, paramByteBuffer);
        }  
      if (this.mNeedResize)
        GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight); 
      GLES20.glDisableVertexAttribArray(i);
      GLES20.glDisableVertexAttribArray(j);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, 0);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glUseProgram(0);
      return this.mFrameBufferTextures[paramInt2];
    } 
    return -1;
  }
  
  public void saveTextureToFrameBuffer(int paramInt, ByteBuffer paramByteBuffer) {
    int[] arrayOfInt = this.mSavePictureFrameBuffers;
    if (arrayOfInt == null)
      return; 
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glViewport(0, 0, this.mViewPortWidth, this.mViewPortHeight);
    GLES20.glUseProgram(((Integer)((HashMap)this.mArrayPrograms.get(1)).get("program")).intValue());
    if (!this.mIsInitialized)
      return; 
    this.mGLCubeBuffer.position(0);
    int i = ((Integer)((HashMap)this.mArrayPrograms.get(1)).get("position")).intValue();
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.mGLCubeBuffer);
    GLES20.glEnableVertexAttribArray(i);
    this.mGLSaveTextureBuffer.position(0);
    int j = ((Integer)((HashMap)this.mArrayPrograms.get(1)).get("inputTextureCoordinate")).intValue();
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, this.mGLSaveTextureBuffer);
    GLES20.glEnableVertexAttribArray(j);
    if (paramInt != -1) {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(((Integer)((HashMap)this.mArrayPrograms.get(1)).get("inputImageTexture")).intValue(), 0);
    } 
    GLES20.glDrawArrays(5, 0, 4);
    if (paramByteBuffer != null)
      GLES20.glReadPixels(0, 0, this.mViewPortWidth, this.mViewPortHeight, 6408, 5121, paramByteBuffer); 
    GLES20.glDisableVertexAttribArray(i);
    GLES20.glDisableVertexAttribArray(j);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\STGLRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */