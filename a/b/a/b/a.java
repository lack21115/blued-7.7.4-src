package a.b.a.b;

import java.util.HashMap;

public class a<K, V> extends b<K, V> {
  public HashMap<K, b.c<K, V>> f;
  
  public a() {
    new HashMap<Object, Object>();
    throw new VerifyError("bad dex opcode");
  }
  
  public b.c<K, V> a(K paramK) {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean contains(K paramK) {
    throw new VerifyError("bad dex opcode");
  }
  
  public V remove(K paramK) {
    super.remove(paramK);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\b\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */