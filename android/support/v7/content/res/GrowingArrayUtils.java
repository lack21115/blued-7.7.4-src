package android.support.v7.content.res;

final class GrowingArrayUtils {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int[] append(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    assert false;
    throw new AssertionError();
  }
  
  public static Object[] append(Object[] paramArrayOfObject, int paramInt, Object paramObject) {
    assert false;
    throw new AssertionError();
  }
  
  private static int growSize(int paramInt) {
    return (paramInt <= 4) ? 8 : (paramInt << 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\content\res\GrowingArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */