package com.qiniu.pili.droid.shortvideo.c.a;

import android.content.Context;
import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.gl.c.k;

public class a extends k {
  private Context c;
  
  private String d;
  
  private int e;
  
  private int f;
  
  private boolean o = true;
  
  public a(Context paramContext, String paramString, boolean paramBoolean) {
    this.c = paramContext;
    this.d = paramString;
    this.o = paramBoolean;
  }
  
  public String[] a() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "varying highp vec2 v_tex_coord;\n \n uniform sampler2D u_tex;\n uniform sampler2D u_filter;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(u_tex, v_tex_coord);\n     \n     mediump float blueColor = textureColor.b * 63.0;\n     \n     mediump vec2 quad1;\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     mediump vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     highp vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     highp vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     lowp vec4 newColor1 = texture2D(u_filter, texPos1);\n     lowp vec4 newColor2 = texture2D(u_filter, texPos2);\n     \n     lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     gl_FragColor = vec4(newColor.rgb, textureColor.w);\n }" };
  }
  
  public boolean b() {
    this.f = b.a(this.c, this.d, this.o);
    return (this.f == 0) ? false : super.b();
  }
  
  public boolean c() {
    this.e = GLES20.glGetUniformLocation(this.l, "u_filter");
    return super.c();
  }
  
  public void d() {
    super.d();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.f);
    GLES20.glUniform1i(this.e, 1);
  }
  
  public void e() {
    super.e();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void f() {
    super.f();
    GLES20.glDeleteTextures(1, new int[] { this.f }, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */