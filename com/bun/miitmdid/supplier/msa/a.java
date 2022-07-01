package com.bun.miitmdid.supplier.msa;

import android.os.AsyncTask;
import com.bun.lib.c;

public class a extends AsyncTask<Void, Void, Boolean> {
  public c a;
  
  public com.bun.miitmdid.c.e.a b;
  
  public a(c paramc, com.bun.miitmdid.c.e.a parama) {
    this.a = paramc;
    this.b = parama;
  }
  
  protected Boolean a(Void... paramVarArgs) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #5
    //   3: aload_0
    //   4: getfield a : Lcom/bun/lib/c;
    //   7: ifnonnull -> 15
    //   10: iconst_0
    //   11: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   14: areturn
    //   15: iconst_0
    //   16: istore_2
    //   17: iload #5
    //   19: istore #6
    //   21: aload_0
    //   22: getfield a : Lcom/bun/lib/c;
    //   25: invokeinterface c : ()Z
    //   30: istore #4
    //   32: iload #4
    //   34: ifeq -> 64
    //   37: iload #4
    //   39: ifeq -> 58
    //   42: aload_0
    //   43: getfield b : Lcom/bun/miitmdid/c/e/a;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull -> 58
    //   51: aload_1
    //   52: iconst_1
    //   53: invokeinterface a : (Z)V
    //   58: iload #4
    //   60: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   63: areturn
    //   64: iload #4
    //   66: istore #6
    //   68: iload #4
    //   70: istore #5
    //   72: ldc2_w 10
    //   75: invokestatic sleep : (J)V
    //   78: iload_2
    //   79: iconst_1
    //   80: iadd
    //   81: istore_3
    //   82: iload #4
    //   84: istore #5
    //   86: iload_3
    //   87: istore_2
    //   88: iload_3
    //   89: bipush #30
    //   91: if_icmplt -> 17
    //   94: goto -> 37
    //   97: astore_1
    //   98: iload #6
    //   100: istore #5
    //   102: ldc 'MsaAsyncTask'
    //   104: ldc 'doInBackground'
    //   106: aload_1
    //   107: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: iload #5
    //   112: istore #4
    //   114: goto -> 37
    //   117: astore_1
    //   118: goto -> 102
    // Exception table:
    //   from	to	target	type
    //   21	32	97	android/os/RemoteException
    //   21	32	117	java/lang/InterruptedException
    //   72	78	97	android/os/RemoteException
    //   72	78	117	java/lang/InterruptedException
  }
  
  protected void a(Boolean paramBoolean) {
    super.onPostExecute(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\supplier\msa\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */