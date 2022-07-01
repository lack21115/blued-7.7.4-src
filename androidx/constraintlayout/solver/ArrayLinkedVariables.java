package androidx.constraintlayout.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables {
  int a = 0;
  
  private final ArrayRow b;
  
  private final Cache c;
  
  private int d = 8;
  
  private SolverVariable e = null;
  
  private int[] f;
  
  private int[] g;
  
  private float[] h;
  
  private int i;
  
  private int j;
  
  private boolean k;
  
  ArrayLinkedVariables(ArrayRow paramArrayRow, Cache paramCache) {
    int i = this.d;
    this.f = new int[i];
    this.g = new int[i];
    this.h = new float[i];
    this.i = -1;
    this.j = -1;
    this.k = false;
    this.b = paramArrayRow;
    this.c = paramCache;
  }
  
  private boolean a(SolverVariable paramSolverVariable, LinearSystem paramLinearSystem) {
    return (paramSolverVariable.usageInRowCount <= 1);
  }
  
  final SolverVariable a(int paramInt) {
    int j = this.i;
    for (int i = 0; j != -1 && i < this.a; i++) {
      if (i == paramInt)
        return this.c.c[this.f[j]]; 
      j = this.g[j];
    } 
    return null;
  }
  
  SolverVariable a(LinearSystem paramLinearSystem) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : I
    //   4: istore #8
    //   6: aconst_null
    //   7: astore #17
    //   9: iconst_0
    //   10: istore #7
    //   12: aconst_null
    //   13: astore #16
    //   15: fconst_0
    //   16: fstore #6
    //   18: iconst_0
    //   19: istore #12
    //   21: fconst_0
    //   22: fstore #5
    //   24: iconst_0
    //   25: istore #11
    //   27: iload #8
    //   29: iconst_m1
    //   30: if_icmpeq -> 547
    //   33: iload #7
    //   35: aload_0
    //   36: getfield a : I
    //   39: if_icmpge -> 547
    //   42: aload_0
    //   43: getfield h : [F
    //   46: iload #8
    //   48: faload
    //   49: fstore_3
    //   50: aload_0
    //   51: getfield c : Landroidx/constraintlayout/solver/Cache;
    //   54: getfield c : [Landroidx/constraintlayout/solver/SolverVariable;
    //   57: aload_0
    //   58: getfield f : [I
    //   61: iload #8
    //   63: iaload
    //   64: aaload
    //   65: astore #13
    //   67: fload_3
    //   68: fconst_0
    //   69: fcmpg
    //   70: ifge -> 102
    //   73: fload_3
    //   74: fstore_2
    //   75: fload_3
    //   76: ldc -0.001
    //   78: fcmpl
    //   79: ifle -> 130
    //   82: aload_0
    //   83: getfield h : [F
    //   86: iload #8
    //   88: fconst_0
    //   89: fastore
    //   90: aload #13
    //   92: aload_0
    //   93: getfield b : Landroidx/constraintlayout/solver/ArrayRow;
    //   96: invokevirtual removeFromRow : (Landroidx/constraintlayout/solver/ArrayRow;)V
    //   99: goto -> 128
    //   102: fload_3
    //   103: fstore_2
    //   104: fload_3
    //   105: ldc 0.001
    //   107: fcmpg
    //   108: ifge -> 130
    //   111: aload_0
    //   112: getfield h : [F
    //   115: iload #8
    //   117: fconst_0
    //   118: fastore
    //   119: aload #13
    //   121: aload_0
    //   122: getfield b : Landroidx/constraintlayout/solver/ArrayRow;
    //   125: invokevirtual removeFromRow : (Landroidx/constraintlayout/solver/ArrayRow;)V
    //   128: fconst_0
    //   129: fstore_2
    //   130: aload #17
    //   132: astore #14
    //   134: aload #16
    //   136: astore #15
    //   138: fload #6
    //   140: fstore_3
    //   141: iload #12
    //   143: istore #9
    //   145: fload #5
    //   147: fstore #4
    //   149: iload #11
    //   151: istore #10
    //   153: fload_2
    //   154: fconst_0
    //   155: fcmpl
    //   156: ifeq -> 506
    //   159: aload #13
    //   161: getfield c : Landroidx/constraintlayout/solver/SolverVariable$Type;
    //   164: getstatic androidx/constraintlayout/solver/SolverVariable$Type.UNRESTRICTED : Landroidx/constraintlayout/solver/SolverVariable$Type;
    //   167: if_acmpne -> 309
    //   170: aload #16
    //   172: ifnonnull -> 205
    //   175: aload_0
    //   176: aload #13
    //   178: aload_1
    //   179: invokespecial a : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/LinearSystem;)Z
    //   182: istore #9
    //   184: aload #17
    //   186: astore #14
    //   188: aload #13
    //   190: astore #15
    //   192: fload_2
    //   193: fstore_3
    //   194: fload #5
    //   196: fstore #4
    //   198: iload #11
    //   200: istore #10
    //   202: goto -> 506
    //   205: fload #6
    //   207: fload_2
    //   208: fcmpl
    //   209: ifle -> 224
    //   212: aload_0
    //   213: aload #13
    //   215: aload_1
    //   216: invokespecial a : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/LinearSystem;)Z
    //   219: istore #9
    //   221: goto -> 184
    //   224: aload #17
    //   226: astore #14
    //   228: aload #16
    //   230: astore #15
    //   232: fload #6
    //   234: fstore_3
    //   235: iload #12
    //   237: istore #9
    //   239: fload #5
    //   241: fstore #4
    //   243: iload #11
    //   245: istore #10
    //   247: iload #12
    //   249: ifne -> 506
    //   252: aload #17
    //   254: astore #14
    //   256: aload #16
    //   258: astore #15
    //   260: fload #6
    //   262: fstore_3
    //   263: iload #12
    //   265: istore #9
    //   267: fload #5
    //   269: fstore #4
    //   271: iload #11
    //   273: istore #10
    //   275: aload_0
    //   276: aload #13
    //   278: aload_1
    //   279: invokespecial a : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/LinearSystem;)Z
    //   282: ifeq -> 506
    //   285: iconst_1
    //   286: istore #9
    //   288: aload #17
    //   290: astore #14
    //   292: aload #13
    //   294: astore #15
    //   296: fload_2
    //   297: fstore_3
    //   298: fload #5
    //   300: fstore #4
    //   302: iload #11
    //   304: istore #10
    //   306: goto -> 506
    //   309: aload #17
    //   311: astore #14
    //   313: aload #16
    //   315: astore #15
    //   317: fload #6
    //   319: fstore_3
    //   320: iload #12
    //   322: istore #9
    //   324: fload #5
    //   326: fstore #4
    //   328: iload #11
    //   330: istore #10
    //   332: aload #16
    //   334: ifnonnull -> 506
    //   337: aload #17
    //   339: astore #14
    //   341: aload #16
    //   343: astore #15
    //   345: fload #6
    //   347: fstore_3
    //   348: iload #12
    //   350: istore #9
    //   352: fload #5
    //   354: fstore #4
    //   356: iload #11
    //   358: istore #10
    //   360: fload_2
    //   361: fconst_0
    //   362: fcmpg
    //   363: ifge -> 506
    //   366: aload #17
    //   368: ifnonnull -> 405
    //   371: aload_0
    //   372: aload #13
    //   374: aload_1
    //   375: invokespecial a : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/LinearSystem;)Z
    //   378: istore #9
    //   380: iload #9
    //   382: istore #10
    //   384: aload #13
    //   386: astore #14
    //   388: aload #16
    //   390: astore #15
    //   392: fload #6
    //   394: fstore_3
    //   395: iload #12
    //   397: istore #9
    //   399: fload_2
    //   400: fstore #4
    //   402: goto -> 506
    //   405: fload #5
    //   407: fload_2
    //   408: fcmpl
    //   409: ifle -> 424
    //   412: aload_0
    //   413: aload #13
    //   415: aload_1
    //   416: invokespecial a : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/LinearSystem;)Z
    //   419: istore #9
    //   421: goto -> 380
    //   424: aload #17
    //   426: astore #14
    //   428: aload #16
    //   430: astore #15
    //   432: fload #6
    //   434: fstore_3
    //   435: iload #12
    //   437: istore #9
    //   439: fload #5
    //   441: fstore #4
    //   443: iload #11
    //   445: istore #10
    //   447: iload #11
    //   449: ifne -> 506
    //   452: aload #17
    //   454: astore #14
    //   456: aload #16
    //   458: astore #15
    //   460: fload #6
    //   462: fstore_3
    //   463: iload #12
    //   465: istore #9
    //   467: fload #5
    //   469: fstore #4
    //   471: iload #11
    //   473: istore #10
    //   475: aload_0
    //   476: aload #13
    //   478: aload_1
    //   479: invokespecial a : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/LinearSystem;)Z
    //   482: ifeq -> 506
    //   485: iconst_1
    //   486: istore #10
    //   488: fload_2
    //   489: fstore #4
    //   491: iload #12
    //   493: istore #9
    //   495: fload #6
    //   497: fstore_3
    //   498: aload #16
    //   500: astore #15
    //   502: aload #13
    //   504: astore #14
    //   506: aload_0
    //   507: getfield g : [I
    //   510: iload #8
    //   512: iaload
    //   513: istore #8
    //   515: iload #7
    //   517: iconst_1
    //   518: iadd
    //   519: istore #7
    //   521: aload #14
    //   523: astore #17
    //   525: aload #15
    //   527: astore #16
    //   529: fload_3
    //   530: fstore #6
    //   532: iload #9
    //   534: istore #12
    //   536: fload #4
    //   538: fstore #5
    //   540: iload #10
    //   542: istore #11
    //   544: goto -> 27
    //   547: aload #16
    //   549: ifnull -> 555
    //   552: aload #16
    //   554: areturn
    //   555: aload #17
    //   557: areturn
  }
  
  SolverVariable a(boolean[] paramArrayOfboolean, SolverVariable paramSolverVariable) {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : I
    //   4: istore #7
    //   6: iconst_0
    //   7: istore #6
    //   9: aconst_null
    //   10: astore #8
    //   12: fconst_0
    //   13: fstore_3
    //   14: iload #7
    //   16: iconst_m1
    //   17: if_icmpeq -> 184
    //   20: iload #6
    //   22: aload_0
    //   23: getfield a : I
    //   26: if_icmpge -> 184
    //   29: aload #8
    //   31: astore #9
    //   33: fload_3
    //   34: fstore #4
    //   36: aload_0
    //   37: getfield h : [F
    //   40: iload #7
    //   42: faload
    //   43: fconst_0
    //   44: fcmpg
    //   45: ifge -> 159
    //   48: aload_0
    //   49: getfield c : Landroidx/constraintlayout/solver/Cache;
    //   52: getfield c : [Landroidx/constraintlayout/solver/SolverVariable;
    //   55: aload_0
    //   56: getfield f : [I
    //   59: iload #7
    //   61: iaload
    //   62: aaload
    //   63: astore #10
    //   65: aload_1
    //   66: ifnull -> 86
    //   69: aload #8
    //   71: astore #9
    //   73: fload_3
    //   74: fstore #4
    //   76: aload_1
    //   77: aload #10
    //   79: getfield id : I
    //   82: baload
    //   83: ifne -> 159
    //   86: aload #8
    //   88: astore #9
    //   90: fload_3
    //   91: fstore #4
    //   93: aload #10
    //   95: aload_2
    //   96: if_acmpeq -> 159
    //   99: aload #10
    //   101: getfield c : Landroidx/constraintlayout/solver/SolverVariable$Type;
    //   104: getstatic androidx/constraintlayout/solver/SolverVariable$Type.SLACK : Landroidx/constraintlayout/solver/SolverVariable$Type;
    //   107: if_acmpeq -> 128
    //   110: aload #8
    //   112: astore #9
    //   114: fload_3
    //   115: fstore #4
    //   117: aload #10
    //   119: getfield c : Landroidx/constraintlayout/solver/SolverVariable$Type;
    //   122: getstatic androidx/constraintlayout/solver/SolverVariable$Type.ERROR : Landroidx/constraintlayout/solver/SolverVariable$Type;
    //   125: if_acmpne -> 159
    //   128: aload_0
    //   129: getfield h : [F
    //   132: iload #7
    //   134: faload
    //   135: fstore #5
    //   137: aload #8
    //   139: astore #9
    //   141: fload_3
    //   142: fstore #4
    //   144: fload #5
    //   146: fload_3
    //   147: fcmpg
    //   148: ifge -> 159
    //   151: aload #10
    //   153: astore #9
    //   155: fload #5
    //   157: fstore #4
    //   159: aload_0
    //   160: getfield g : [I
    //   163: iload #7
    //   165: iaload
    //   166: istore #7
    //   168: iload #6
    //   170: iconst_1
    //   171: iadd
    //   172: istore #6
    //   174: aload #9
    //   176: astore #8
    //   178: fload #4
    //   180: fstore_3
    //   181: goto -> 14
    //   184: aload #8
    //   186: areturn
  }
  
  void a() {
    int j = this.i;
    for (int i = 0; j != -1 && i < this.a; i++) {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[j] = arrayOfFloat[j] * -1.0F;
      j = this.g[j];
    } 
  }
  
  void a(float paramFloat) {
    int j = this.i;
    for (int i = 0; j != -1 && i < this.a; i++) {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[j] = arrayOfFloat[j] / paramFloat;
      j = this.g[j];
    } 
  }
  
  final void a(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2, boolean paramBoolean) {
    int i = this.i;
    label22: while (true) {
      int j;
      for (j = 0; i != -1 && j < this.a; j++) {
        if (this.f[i] == paramArrayRow2.a.id) {
          float f = this.h[i];
          remove(paramArrayRow2.a, paramBoolean);
          ArrayLinkedVariables arrayLinkedVariables = paramArrayRow2.variables;
          j = arrayLinkedVariables.i;
          for (i = 0; j != -1 && i < arrayLinkedVariables.a; i++) {
            a(this.c.c[arrayLinkedVariables.f[j]], arrayLinkedVariables.h[j] * f, paramBoolean);
            j = arrayLinkedVariables.g[j];
          } 
          paramArrayRow1.b += paramArrayRow2.b * f;
          if (paramBoolean)
            paramArrayRow2.a.removeFromRow(paramArrayRow1); 
          i = this.i;
          continue label22;
        } 
        i = this.g[i];
      } 
      break;
    } 
  }
  
  void a(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow) {
    int i = this.i;
    label22: while (true) {
      int j;
      for (j = 0; i != -1 && j < this.a; j++) {
        SolverVariable solverVariable = this.c.c[this.f[i]];
        if (solverVariable.a != -1) {
          float f = this.h[i];
          remove(solverVariable, true);
          ArrayRow arrayRow = paramArrayOfArrayRow[solverVariable.a];
          if (!arrayRow.d) {
            ArrayLinkedVariables arrayLinkedVariables = arrayRow.variables;
            j = arrayLinkedVariables.i;
            for (i = 0; j != -1 && i < arrayLinkedVariables.a; i++) {
              a(this.c.c[arrayLinkedVariables.f[j]], arrayLinkedVariables.h[j] * f, true);
              j = arrayLinkedVariables.g[j];
            } 
          } 
          paramArrayRow.b += arrayRow.b * f;
          arrayRow.a.removeFromRow(paramArrayRow);
          i = this.i;
          continue label22;
        } 
        i = this.g[i];
      } 
      break;
    } 
  }
  
  final void a(SolverVariable paramSolverVariable, float paramFloat, boolean paramBoolean) {
    if (paramFloat == 0.0F)
      return; 
    int i = this.i;
    if (i == -1) {
      this.i = 0;
      float[] arrayOfFloat = this.h;
      i = this.i;
      arrayOfFloat[i] = paramFloat;
      this.f[i] = paramSolverVariable.id;
      this.g[this.i] = -1;
      paramSolverVariable.usageInRowCount++;
      paramSolverVariable.addToRow(this.b);
      this.a++;
      if (!this.k) {
        i = ++this.j;
        arrayOfInt1 = this.f;
        if (i >= arrayOfInt1.length) {
          this.k = true;
          this.j = arrayOfInt1.length - 1;
        } 
      } 
      return;
    } 
    int j = 0;
    int k = -1;
    while (i != -1 && j < this.a) {
      if (this.f[i] == ((SolverVariable)arrayOfInt1).id) {
        float[] arrayOfFloat = this.h;
        arrayOfFloat[i] = arrayOfFloat[i] + paramFloat;
        if (arrayOfFloat[i] == 0.0F) {
          if (i == this.i) {
            this.i = this.g[i];
          } else {
            int[] arrayOfInt = this.g;
            arrayOfInt[k] = arrayOfInt[i];
          } 
          if (paramBoolean)
            arrayOfInt1.removeFromRow(this.b); 
          if (this.k)
            this.j = i; 
          ((SolverVariable)arrayOfInt1).usageInRowCount--;
          this.a--;
        } 
        return;
      } 
      if (this.f[i] < ((SolverVariable)arrayOfInt1).id)
        k = i; 
      i = this.g[i];
      j++;
    } 
    i = this.j;
    if (this.k) {
      int[] arrayOfInt = this.f;
      if (arrayOfInt[i] != -1)
        i = arrayOfInt.length; 
    } else {
      i++;
    } 
    int[] arrayOfInt2 = this.f;
    j = i;
    if (i >= arrayOfInt2.length) {
      j = i;
      if (this.a < arrayOfInt2.length) {
        int m = 0;
        while (true) {
          arrayOfInt2 = this.f;
          j = i;
          if (m < arrayOfInt2.length) {
            if (arrayOfInt2[m] == -1) {
              j = m;
              break;
            } 
            m++;
            continue;
          } 
          break;
        } 
      } 
    } 
    arrayOfInt2 = this.f;
    i = j;
    if (j >= arrayOfInt2.length) {
      i = arrayOfInt2.length;
      this.d *= 2;
      this.k = false;
      this.j = i - 1;
      this.h = Arrays.copyOf(this.h, this.d);
      this.f = Arrays.copyOf(this.f, this.d);
      this.g = Arrays.copyOf(this.g, this.d);
    } 
    this.f[i] = ((SolverVariable)arrayOfInt1).id;
    this.h[i] = paramFloat;
    if (k != -1) {
      arrayOfInt2 = this.g;
      arrayOfInt2[i] = arrayOfInt2[k];
      arrayOfInt2[k] = i;
    } else {
      this.g[i] = this.i;
      this.i = i;
    } 
    ((SolverVariable)arrayOfInt1).usageInRowCount++;
    arrayOfInt1.addToRow(this.b);
    this.a++;
    if (!this.k)
      this.j++; 
    i = this.j;
    int[] arrayOfInt1 = this.f;
    if (i >= arrayOfInt1.length) {
      this.k = true;
      this.j = arrayOfInt1.length - 1;
    } 
  }
  
  final boolean a(SolverVariable paramSolverVariable) {
    int j = this.i;
    if (j == -1)
      return false; 
    for (int i = 0; j != -1 && i < this.a; i++) {
      if (this.f[j] == paramSolverVariable.id)
        return true; 
      j = this.g[j];
    } 
    return false;
  }
  
  final float b(int paramInt) {
    int j = this.i;
    for (int i = 0; j != -1 && i < this.a; i++) {
      if (i == paramInt)
        return this.h[j]; 
      j = this.g[j];
    } 
    return 0.0F;
  }
  
  int b() {
    return this.f.length * 4 * 3 + 0 + 36;
  }
  
  public final void clear() {
    int j = this.i;
    for (int i = 0; j != -1 && i < this.a; i++) {
      SolverVariable solverVariable = this.c.c[this.f[j]];
      if (solverVariable != null)
        solverVariable.removeFromRow(this.b); 
      j = this.g[j];
    } 
    this.i = -1;
    this.j = -1;
    this.k = false;
    this.a = 0;
  }
  
  public void display() {
    int j = this.a;
    System.out.print("{ ");
    for (int i = 0; i < j; i++) {
      SolverVariable solverVariable = a(i);
      if (solverVariable != null) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(solverVariable);
        stringBuilder.append(" = ");
        stringBuilder.append(b(i));
        stringBuilder.append(" ");
        printStream.print(stringBuilder.toString());
      } 
    } 
    System.out.println(" }");
  }
  
  public final float get(SolverVariable paramSolverVariable) {
    int j = this.i;
    for (int i = 0; j != -1 && i < this.a; i++) {
      if (this.f[j] == paramSolverVariable.id)
        return this.h[j]; 
      j = this.g[j];
    } 
    return 0.0F;
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat) {
    if (paramFloat == 0.0F) {
      remove(paramSolverVariable, true);
      return;
    } 
    int i = this.i;
    if (i == -1) {
      this.i = 0;
      float[] arrayOfFloat = this.h;
      i = this.i;
      arrayOfFloat[i] = paramFloat;
      this.f[i] = paramSolverVariable.id;
      this.g[this.i] = -1;
      paramSolverVariable.usageInRowCount++;
      paramSolverVariable.addToRow(this.b);
      this.a++;
      if (!this.k) {
        i = ++this.j;
        arrayOfInt1 = this.f;
        if (i >= arrayOfInt1.length) {
          this.k = true;
          this.j = arrayOfInt1.length - 1;
        } 
      } 
      return;
    } 
    int j = 0;
    int k = -1;
    while (i != -1 && j < this.a) {
      if (this.f[i] == ((SolverVariable)arrayOfInt1).id) {
        this.h[i] = paramFloat;
        return;
      } 
      if (this.f[i] < ((SolverVariable)arrayOfInt1).id)
        k = i; 
      i = this.g[i];
      j++;
    } 
    i = this.j;
    if (this.k) {
      int[] arrayOfInt = this.f;
      if (arrayOfInt[i] != -1)
        i = arrayOfInt.length; 
    } else {
      i++;
    } 
    int[] arrayOfInt2 = this.f;
    j = i;
    if (i >= arrayOfInt2.length) {
      j = i;
      if (this.a < arrayOfInt2.length) {
        int m = 0;
        while (true) {
          arrayOfInt2 = this.f;
          j = i;
          if (m < arrayOfInt2.length) {
            if (arrayOfInt2[m] == -1) {
              j = m;
              break;
            } 
            m++;
            continue;
          } 
          break;
        } 
      } 
    } 
    arrayOfInt2 = this.f;
    i = j;
    if (j >= arrayOfInt2.length) {
      i = arrayOfInt2.length;
      this.d *= 2;
      this.k = false;
      this.j = i - 1;
      this.h = Arrays.copyOf(this.h, this.d);
      this.f = Arrays.copyOf(this.f, this.d);
      this.g = Arrays.copyOf(this.g, this.d);
    } 
    this.f[i] = ((SolverVariable)arrayOfInt1).id;
    this.h[i] = paramFloat;
    if (k != -1) {
      arrayOfInt2 = this.g;
      arrayOfInt2[i] = arrayOfInt2[k];
      arrayOfInt2[k] = i;
    } else {
      this.g[i] = this.i;
      this.i = i;
    } 
    ((SolverVariable)arrayOfInt1).usageInRowCount++;
    arrayOfInt1.addToRow(this.b);
    this.a++;
    if (!this.k)
      this.j++; 
    if (this.a >= this.f.length)
      this.k = true; 
    i = this.j;
    int[] arrayOfInt1 = this.f;
    if (i >= arrayOfInt1.length) {
      this.k = true;
      this.j = arrayOfInt1.length - 1;
    } 
  }
  
  public final float remove(SolverVariable paramSolverVariable, boolean paramBoolean) {
    if (this.e == paramSolverVariable)
      this.e = null; 
    int i = this.i;
    if (i == -1)
      return 0.0F; 
    int j = 0;
    int k = -1;
    while (i != -1 && j < this.a) {
      if (this.f[i] == paramSolverVariable.id) {
        if (i == this.i) {
          this.i = this.g[i];
        } else {
          int[] arrayOfInt = this.g;
          arrayOfInt[k] = arrayOfInt[i];
        } 
        if (paramBoolean)
          paramSolverVariable.removeFromRow(this.b); 
        paramSolverVariable.usageInRowCount--;
        this.a--;
        this.f[i] = -1;
        if (this.k)
          this.j = i; 
        return this.h[i];
      } 
      int m = this.g[i];
      j++;
      k = i;
      i = m;
    } 
    return 0.0F;
  }
  
  public String toString() {
    int j = this.i;
    String str = "";
    for (int i = 0; j != -1 && i < this.a; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(" -> ");
      str = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(this.h[j]);
      stringBuilder.append(" : ");
      str = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(this.c.c[this.f[j]]);
      str = stringBuilder.toString();
      j = this.g[j];
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\ArrayLinkedVariables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */