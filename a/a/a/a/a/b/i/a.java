package a.a.a.a.a.b.i;

public class a extends l {
  public int a() {
    return 36197;
  }
  
  public String[] b() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_tex;\nvarying vec2 v_tex;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex);\n}\n" };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */