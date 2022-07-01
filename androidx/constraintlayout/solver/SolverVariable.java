package androidx.constraintlayout.solver;

import java.util.Arrays;

public class SolverVariable {
  public static final int STRENGTH_BARRIER = 7;
  
  public static final int STRENGTH_EQUALITY = 5;
  
  public static final int STRENGTH_FIXED = 6;
  
  public static final int STRENGTH_HIGH = 3;
  
  public static final int STRENGTH_HIGHEST = 4;
  
  public static final int STRENGTH_LOW = 1;
  
  public static final int STRENGTH_MEDIUM = 2;
  
  public static final int STRENGTH_NONE = 0;
  
  private static int f = 1;
  
  private static int g = 1;
  
  private static int h = 1;
  
  private static int i = 1;
  
  private static int j = 1;
  
  int a = -1;
  
  float[] b = new float[7];
  
  Type c;
  
  public float computedValue;
  
  ArrayRow[] d = new ArrayRow[8];
  
  int e = 0;
  
  public int id = -1;
  
  private String k;
  
  public int strength = 0;
  
  public int usageInRowCount = 0;
  
  public SolverVariable(Type paramType, String paramString) {
    this.c = paramType;
  }
  
  public SolverVariable(String paramString, Type paramType) {
    this.k = paramString;
    this.c = paramType;
  }
  
  static void a() {
    g++;
  }
  
  public final void addToRow(ArrayRow paramArrayRow) {
    int i = 0;
    while (true) {
      int j = this.e;
      if (i < j) {
        if (this.d[i] == paramArrayRow)
          return; 
        i++;
        continue;
      } 
      ArrayRow[] arrayOfArrayRow = this.d;
      if (j >= arrayOfArrayRow.length)
        this.d = Arrays.<ArrayRow>copyOf(arrayOfArrayRow, arrayOfArrayRow.length * 2); 
      arrayOfArrayRow = this.d;
      i = this.e;
      arrayOfArrayRow[i] = paramArrayRow;
      this.e = i + 1;
      return;
    } 
  }
  
  public String getName() {
    return this.k;
  }
  
  public final void removeFromRow(ArrayRow paramArrayRow) {
    int k = this.e;
    int j = 0;
    for (int i = 0; i < k; i++) {
      if (this.d[i] == paramArrayRow) {
        while (j < k - i - 1) {
          ArrayRow[] arrayOfArrayRow = this.d;
          int m = i + j;
          arrayOfArrayRow[m] = arrayOfArrayRow[m + 1];
          j++;
        } 
        this.e--;
        return;
      } 
    } 
  }
  
  public void reset() {
    this.k = null;
    this.c = Type.UNKNOWN;
    this.strength = 0;
    this.id = -1;
    this.a = -1;
    this.computedValue = 0.0F;
    this.e = 0;
    this.usageInRowCount = 0;
  }
  
  public void setName(String paramString) {
    this.k = paramString;
  }
  
  public void setType(Type paramType, String paramString) {
    this.c = paramType;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.k);
    return stringBuilder.toString();
  }
  
  public final void updateReferencesWithNewDefinition(ArrayRow paramArrayRow) {
    int j = this.e;
    for (int i = 0; i < j; i++)
      (this.d[i]).variables.a(this.d[i], paramArrayRow, false); 
    this.e = 0;
  }
  
  public enum Type {
    CONSTANT, ERROR, SLACK, UNKNOWN, UNRESTRICTED;
    
    static {
      ERROR = new Type("ERROR", 3);
      UNKNOWN = new Type("UNKNOWN", 4);
      a = new Type[] { UNRESTRICTED, CONSTANT, SLACK, ERROR, UNKNOWN };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\SolverVariable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */