package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import java.nio.FloatBuffer;
import java.util.IdentityHashMap;
import java.util.Map;

public class GlRectDrawer {
  private static final FloatBuffer a = GlUtil.a(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
  
  private static final FloatBuffer b = GlUtil.a(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
  
  private final Map<String, Shader> c = new IdentityHashMap<String, Shader>();
  
  static class Shader {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\zegoVideoCapture\ve_gl\GlRectDrawer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */