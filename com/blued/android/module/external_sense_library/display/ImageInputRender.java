package com.blued.android.module.external_sense_library.display;

import android.opengl.GLES20;
import android.util.Log;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class ImageInputRender {
  public static final String NO_FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  
  public static final String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  
  protected boolean DEBUG = true;
  
  private final String mFragmentShader = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  
  protected int mGLAttribPosition;
  
  protected int mGLAttribTextureCoordinate;
  
  protected FloatBuffer mGLCubeBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.f.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  
  protected int mGLProgId;
  
  protected FloatBuffer mGLTextureBuffer;
  
  protected int mGLUniformTexture;
  
  protected boolean mIsInitialized;
  
  protected int mOutputHeight;
  
  protected int mOutputWidth;
  
  private final LinkedList<Runnable> mRunOnDraw = new LinkedList<Runnable>();
  
  protected int mSurfaceHeight;
  
  protected int mSurfaceWidth;
  
  protected int mTableTextureID = -1;
  
  private final String mVertexShader = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  
  private final float[] texturePoint = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  
  private final float[] vertexPoint = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  
  public ImageInputRender() {
    this.mGLCubeBuffer.put(TextureRotationUtil.f).position(0);
    this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mGLTextureBuffer.put(TextureRotationUtil.a(0, false, true)).position(0);
  }
  
  public final void destroy() {
    this.mIsInitialized = false;
    GLES20.glDeleteProgram(this.mGLProgId);
  }
  
  public void init() {
    onInit();
    this.mIsInitialized = true;
  }
  
  public void onDisplaySizeChanged(int paramInt1, int paramInt2) {
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
  }
  
  public int onDrawFrame(int paramInt) {
    GLES20.glUseProgram(this.mGLProgId);
    runPendingOnDrawTasks();
    if (!this.mIsInitialized)
      return -1; 
    this.mGLCubeBuffer.position(0);
    GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, this.mGLCubeBuffer);
    GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
    this.mGLTextureBuffer.position(0);
    GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, this.mGLTextureBuffer);
    GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
    if (paramInt != -1) {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(this.mGLUniformTexture, 0);
    } 
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
    GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
    GLES20.glBindTexture(3553, 0);
    return 1;
  }
  
  public int onDrawFrame(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2) {
    GLES20.glUseProgram(this.mGLProgId);
    runPendingOnDrawTasks();
    if (!this.mIsInitialized)
      return -1; 
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
    if (paramInt != -1) {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(this.mGLUniformTexture, 0);
    } 
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
    GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, 0);
    return 1;
  }
  
  protected void onInit() {
    this.mGLProgId = OpenGLUtils.a(this.mVertexShader, this.mFragmentShader);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The program ID for image is ");
    stringBuilder.append(this.mGLProgId);
    Log.d("fenghx", stringBuilder.toString());
    this.mGLAttribPosition = GLES20.glGetAttribLocation(this.mGLProgId, "position");
    this.mGLUniformTexture = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture");
    this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mGLProgId, "inputTextureCoordinate");
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2) {
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
  }
  
  protected void runOnDraw(Runnable paramRunnable) {
    synchronized (this.mRunOnDraw) {
      this.mRunOnDraw.addLast(paramRunnable);
      return;
    } 
  }
  
  protected void runPendingOnDrawTasks() {
    synchronized (this.mRunOnDraw) {
      while (!this.mRunOnDraw.isEmpty())
        ((Runnable)this.mRunOnDraw.removeFirst()).run(); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\ImageInputRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */