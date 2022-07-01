package com.ss.android.socialbase.downloader.m;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;

public class e {
  public static void a(int paramInt, SparseArray<w> paramSparseArray, boolean paramBoolean, c paramc, a parama) {
    // Byte code:
    //   0: iload_2
    //   1: ifeq -> 286
    //   4: aload_1
    //   5: ifnull -> 286
    //   8: aload_1
    //   9: invokevirtual size : ()I
    //   12: ifgt -> 16
    //   15: return
    //   16: aload_1
    //   17: monitorenter
    //   18: aload_1
    //   19: invokevirtual clone : ()Landroid/util/SparseArray;
    //   22: astore #6
    //   24: aload_1
    //   25: monitorexit
    //   26: iconst_0
    //   27: istore #5
    //   29: iload #5
    //   31: aload #6
    //   33: invokevirtual size : ()I
    //   36: if_icmpge -> 286
    //   39: aload #6
    //   41: aload #6
    //   43: iload #5
    //   45: invokevirtual keyAt : (I)I
    //   48: invokevirtual get : (I)Ljava/lang/Object;
    //   51: checkcast com/ss/android/socialbase/downloader/d/w
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull -> 267
    //   59: iload_0
    //   60: tableswitch default -> 287, -7 -> 252, -6 -> 242, -5 -> 232, -4 -> 222, -3 -> 212, -2 -> 232, -1 -> 200, 0 -> 287, 1 -> 190, 2 -> 180, 3 -> 287, 4 -> 170, 5 -> 158, 6 -> 148, 7 -> 136
    //   136: aload_1
    //   137: aload_3
    //   138: aload #4
    //   140: invokeinterface c : (Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;)V
    //   145: goto -> 267
    //   148: aload_1
    //   149: aload_3
    //   150: invokeinterface g : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   155: goto -> 267
    //   158: aload_1
    //   159: aload_3
    //   160: aload #4
    //   162: invokeinterface b : (Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;)V
    //   167: goto -> 267
    //   170: aload_1
    //   171: aload_3
    //   172: invokeinterface c : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   177: goto -> 267
    //   180: aload_1
    //   181: aload_3
    //   182: invokeinterface b : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   187: goto -> 267
    //   190: aload_1
    //   191: aload_3
    //   192: invokeinterface a : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   197: goto -> 267
    //   200: aload_1
    //   201: aload_3
    //   202: aload #4
    //   204: invokeinterface a : (Lcom/ss/android/socialbase/downloader/g/c;Lcom/ss/android/socialbase/downloader/e/a;)V
    //   209: goto -> 267
    //   212: aload_1
    //   213: aload_3
    //   214: invokeinterface e : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   219: goto -> 267
    //   222: aload_1
    //   223: aload_3
    //   224: invokeinterface f : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   229: goto -> 267
    //   232: aload_1
    //   233: aload_3
    //   234: invokeinterface d : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   239: goto -> 267
    //   242: aload_1
    //   243: aload_3
    //   244: invokeinterface h : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   249: goto -> 267
    //   252: aload_1
    //   253: instanceof com/ss/android/socialbase/downloader/d/b
    //   256: ifeq -> 267
    //   259: aload_1
    //   260: checkcast com/ss/android/socialbase/downloader/d/b
    //   263: aload_3
    //   264: invokevirtual i : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   267: iload #5
    //   269: iconst_1
    //   270: iadd
    //   271: istore #5
    //   273: goto -> 29
    //   276: astore_3
    //   277: aload_1
    //   278: monitorexit
    //   279: aload_3
    //   280: athrow
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual printStackTrace : ()V
    //   286: return
    //   287: goto -> 267
    // Exception table:
    //   from	to	target	type
    //   8	15	281	finally
    //   16	18	281	finally
    //   18	26	276	finally
    //   29	55	281	finally
    //   136	145	281	finally
    //   148	155	281	finally
    //   158	167	281	finally
    //   170	177	281	finally
    //   180	187	281	finally
    //   190	197	281	finally
    //   200	209	281	finally
    //   212	219	281	finally
    //   222	229	281	finally
    //   232	239	281	finally
    //   242	249	281	finally
    //   252	267	281	finally
    //   277	279	276	finally
    //   279	281	281	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */