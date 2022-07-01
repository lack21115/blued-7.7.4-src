package com.blued.android.module.external_sense_library.test.gles;

import android.opengl.GLES20;
import android.util.Log;

public class FlatShadedProgram {
  private int a = -1;
  
  private int b = -1;
  
  private int c = -1;
  
  private int d = -1;
  
  public FlatShadedProgram() {
    this.a = GlUtil.a("uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}", "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}");
    if (this.a != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Created program ");
      stringBuilder.append(this.a);
      Log.d("Grafika", stringBuilder.toString());
      this.d = GLES20.glGetAttribLocation(this.a, "aPosition");
      GlUtil.b(this.d, "aPosition");
      this.c = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
      GlUtil.b(this.c, "uMVPMatrix");
      this.b = GLES20.glGetUniformLocation(this.a, "uColor");
      GlUtil.b(this.b, "uColor");
      return;
    } 
    throw new RuntimeException("Unable to create program");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\gles\FlatShadedProgram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */