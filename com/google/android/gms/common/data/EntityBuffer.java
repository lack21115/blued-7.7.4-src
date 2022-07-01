package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
  private boolean zaa = false;
  
  private ArrayList<Integer> zab;
  
  protected EntityBuffer(DataHolder paramDataHolder) {
    super(paramDataHolder);
  }
  
  private final int zaa(int paramInt) {
    if (paramInt >= 0 && paramInt < this.zab.size())
      return ((Integer)this.zab.get(paramInt)).intValue(); 
    StringBuilder stringBuilder = new StringBuilder(53);
    stringBuilder.append("Position ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" is out of bounds for this buffer");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private final void zaa() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zaa : Z
    //   6: ifne -> 229
    //   9: aload_0
    //   10: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   13: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast com/google/android/gms/common/data/DataHolder
    //   19: invokevirtual getCount : ()I
    //   22: istore_2
    //   23: aload_0
    //   24: new java/util/ArrayList
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: putfield zab : Ljava/util/ArrayList;
    //   34: iload_2
    //   35: ifle -> 224
    //   38: aload_0
    //   39: getfield zab : Ljava/util/ArrayList;
    //   42: iconst_0
    //   43: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   46: invokevirtual add : (Ljava/lang/Object;)Z
    //   49: pop
    //   50: aload_0
    //   51: invokevirtual getPrimaryDataMarkerColumn : ()Ljava/lang/String;
    //   54: astore #7
    //   56: aload_0
    //   57: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   60: iconst_0
    //   61: invokevirtual getWindowIndex : (I)I
    //   64: istore_1
    //   65: aload_0
    //   66: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   69: aload #7
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual getString : (Ljava/lang/String;II)Ljava/lang/String;
    //   76: astore #4
    //   78: iconst_1
    //   79: istore_1
    //   80: iload_1
    //   81: iload_2
    //   82: if_icmpge -> 224
    //   85: aload_0
    //   86: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   89: iload_1
    //   90: invokevirtual getWindowIndex : (I)I
    //   93: istore_3
    //   94: aload_0
    //   95: getfield mDataHolder : Lcom/google/android/gms/common/data/DataHolder;
    //   98: aload #7
    //   100: iload_1
    //   101: iload_3
    //   102: invokevirtual getString : (Ljava/lang/String;II)Ljava/lang/String;
    //   105: astore #6
    //   107: aload #6
    //   109: ifnull -> 145
    //   112: aload #4
    //   114: astore #5
    //   116: aload #6
    //   118: aload #4
    //   120: invokevirtual equals : (Ljava/lang/Object;)Z
    //   123: ifne -> 239
    //   126: aload_0
    //   127: getfield zab : Ljava/util/ArrayList;
    //   130: iload_1
    //   131: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   134: invokevirtual add : (Ljava/lang/Object;)Z
    //   137: pop
    //   138: aload #6
    //   140: astore #5
    //   142: goto -> 239
    //   145: new java/lang/StringBuilder
    //   148: dup
    //   149: aload #7
    //   151: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   154: invokevirtual length : ()I
    //   157: bipush #78
    //   159: iadd
    //   160: invokespecial <init> : (I)V
    //   163: astore #4
    //   165: aload #4
    //   167: ldc 'Missing value for markerColumn: '
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload #4
    //   175: aload #7
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #4
    //   183: ldc ', at row: '
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #4
    //   191: iload_1
    //   192: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload #4
    //   198: ldc ', for window: '
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload #4
    //   206: iload_3
    //   207: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: new java/lang/NullPointerException
    //   214: dup
    //   215: aload #4
    //   217: invokevirtual toString : ()Ljava/lang/String;
    //   220: invokespecial <init> : (Ljava/lang/String;)V
    //   223: athrow
    //   224: aload_0
    //   225: iconst_1
    //   226: putfield zaa : Z
    //   229: aload_0
    //   230: monitorexit
    //   231: return
    //   232: astore #4
    //   234: aload_0
    //   235: monitorexit
    //   236: aload #4
    //   238: athrow
    //   239: iload_1
    //   240: iconst_1
    //   241: iadd
    //   242: istore_1
    //   243: aload #5
    //   245: astore #4
    //   247: goto -> 80
    // Exception table:
    //   from	to	target	type
    //   2	34	232	finally
    //   38	78	232	finally
    //   85	107	232	finally
    //   116	138	232	finally
    //   145	224	232	finally
    //   224	229	232	finally
    //   229	231	232	finally
    //   234	236	232	finally
  }
  
  public final T get(int paramInt) {
    zaa();
    int j = zaa(paramInt);
    byte b = 0;
    int i = b;
    if (paramInt >= 0)
      if (paramInt == this.zab.size()) {
        i = b;
      } else {
        int k;
        if (paramInt == this.zab.size() - 1) {
          i = ((DataHolder)Preconditions.checkNotNull(this.mDataHolder)).getCount();
          k = ((Integer)this.zab.get(paramInt)).intValue();
        } else {
          i = ((Integer)this.zab.get(paramInt + 1)).intValue();
          k = ((Integer)this.zab.get(paramInt)).intValue();
        } 
        i -= k;
        if (i == 1) {
          paramInt = zaa(paramInt);
          k = ((DataHolder)Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(paramInt);
          String str = getChildDataMarkerColumn();
          if (str != null && this.mDataHolder.getString(str, paramInt, k) == null)
            i = b; 
        } 
      }  
    return getEntry(j, i);
  }
  
  protected String getChildDataMarkerColumn() {
    return null;
  }
  
  public int getCount() {
    zaa();
    return this.zab.size();
  }
  
  protected abstract T getEntry(int paramInt1, int paramInt2);
  
  protected abstract String getPrimaryDataMarkerColumn();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\data\EntityBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */