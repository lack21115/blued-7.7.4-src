package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import java.nio.ByteBuffer;

public class i {
  public n a;
  
  public n b;
  
  public n c;
  
  public void a() {
    this.a.n();
    this.b.n();
    this.c.n();
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    int j = paramInt1 / 2;
    int k = paramInt2 / 2;
    this.a = new n();
    this.b = new n();
    this.c = new n();
    f.b();
    f.b();
    return (this.a.a(paramInt1, paramInt2, 1, 33321, 6403, "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nfloat Y(vec3 c)  {\n  float result = (0.257 * c.r) + (0.504 * c.g) + (0.098 * c.b) + 0.0625;\n  return result;\n}\nvoid main() {\n  float y = Y(texture2D(u_tex, v_tex).rgb);\n  gl_FragColor = vec4(y);\n}\n") && this.b.a(j, k, 1, 33321, 6403, "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nfloat U(vec3 c) {\n  float result = -(0.148 * c.r) - (0.291 * c.g) + (0.439 * c.b) + 0.5;\n  return result;\n}\nvoid main() {\n  float u = U(texture2D(u_tex, v_tex).rgb);\n  gl_FragColor = vec4(u);\n}\n") && this.c.a(j, k, 1, 33321, 6403, "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nfloat V(vec3 c) {\n  float result = (0.439 * c.r) - (0.368 * c.g) - (0.071 * c.b) + 0.5;\n  return result;\n}\nvoid main() {\n  float v = V(texture2D(u_tex, v_tex).rgb);\n  gl_FragColor = vec4(v);\n}\n"));
  }
  
  public ByteBuffer[] a(int paramInt) {
    this.a.b(paramInt);
    this.b.b(paramInt);
    this.c.b(paramInt);
    ByteBuffer[] arrayOfByteBuffer = new ByteBuffer[3];
    arrayOfByteBuffer[0] = this.a.m();
    arrayOfByteBuffer[1] = this.b.m();
    arrayOfByteBuffer[2] = this.c.m();
    if (arrayOfByteBuffer[0] != null && arrayOfByteBuffer[1] != null) {
      ByteBuffer[] arrayOfByteBuffer1 = arrayOfByteBuffer;
      return (arrayOfByteBuffer[2] == null) ? null : arrayOfByteBuffer1;
    } 
    return null;
  }
  
  public void b() {
    n n1 = this.a;
    if (n1 != null) {
      n1.g();
      this.a = null;
    } 
    n1 = this.b;
    if (n1 != null) {
      n1.g();
      this.b = null;
    } 
    n1 = this.c;
    if (n1 != null) {
      n1.g();
      this.c = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */