package com.baidu.idl.facesdk;

public class FaceInfo {
  public int face_id;
  
  public float[] headPose;
  
  public int[] is_live;
  
  public int[] landmarks;
  
  public int mAngle;
  
  public int mCenter_x;
  
  public int mCenter_y;
  
  public float mConf;
  
  public int mWidth;
  
  public FaceInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat) {
    this.mWidth = paramInt1;
    this.mAngle = paramInt2;
    this.mCenter_y = paramInt3;
    this.mCenter_x = paramInt4;
    this.mConf = paramFloat;
    this.landmarks = null;
    this.face_id = 0;
  }
  
  public FaceInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, int[] paramArrayOfint) {
    this.mWidth = paramInt1;
    this.mAngle = paramInt2;
    this.mCenter_y = paramInt3;
    this.mCenter_x = paramInt4;
    this.mConf = paramFloat;
    this.landmarks = paramArrayOfint;
    this.face_id = paramInt5;
  }
  
  public FaceInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, int[] paramArrayOfint1, float[] paramArrayOffloat, int[] paramArrayOfint2) {
    this.mWidth = paramInt1;
    this.mAngle = paramInt2;
    this.mCenter_y = paramInt3;
    this.mCenter_x = paramInt4;
    this.mConf = paramFloat;
    this.landmarks = paramArrayOfint1;
    this.face_id = paramInt5;
    this.headPose = paramArrayOffloat;
    this.is_live = paramArrayOfint2;
  }
  
  public void getRectPoints(int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAngle : I
    //   4: i2d
    //   5: ldc2_w 3.14159
    //   8: dmul
    //   9: ldc2_w 180.0
    //   12: ddiv
    //   13: dstore #4
    //   15: dload #4
    //   17: invokestatic cos : (D)D
    //   20: dstore_2
    //   21: dload #4
    //   23: invokestatic sin : (D)D
    //   26: dstore #4
    //   28: aload_0
    //   29: getfield mCenter_x : I
    //   32: i2d
    //   33: dstore #6
    //   35: aload_0
    //   36: getfield mWidth : I
    //   39: istore #11
    //   41: dload #6
    //   43: iload #11
    //   45: i2d
    //   46: dload_2
    //   47: dmul
    //   48: ldc2_w 2.0
    //   51: ddiv
    //   52: dadd
    //   53: iload #11
    //   55: i2d
    //   56: dload #4
    //   58: dmul
    //   59: ldc2_w 2.0
    //   62: ddiv
    //   63: dsub
    //   64: d2i
    //   65: istore #10
    //   67: aload_0
    //   68: getfield mCenter_y : I
    //   71: i2d
    //   72: dload #4
    //   74: iload #11
    //   76: i2d
    //   77: dmul
    //   78: ldc2_w 2.0
    //   81: ddiv
    //   82: dadd
    //   83: dload_2
    //   84: iload #11
    //   86: i2d
    //   87: dmul
    //   88: ldc2_w 2.0
    //   91: ddiv
    //   92: dadd
    //   93: d2i
    //   94: istore #11
    //   96: aload_0
    //   97: getfield mAngle : I
    //   100: i2d
    //   101: ldc2_w 3.14159
    //   104: dmul
    //   105: ldc2_w 180.0
    //   108: ddiv
    //   109: dstore #4
    //   111: dload #4
    //   113: invokestatic cos : (D)D
    //   116: ldc2_w 0.5
    //   119: dmul
    //   120: dstore_2
    //   121: dload #4
    //   123: invokestatic sin : (D)D
    //   126: ldc2_w 0.5
    //   129: dmul
    //   130: dstore #4
    //   132: aload_1
    //   133: ifnull -> 144
    //   136: aload_1
    //   137: astore #13
    //   139: aload_1
    //   140: arraylength
    //   141: ifne -> 150
    //   144: bipush #8
    //   146: newarray int
    //   148: astore #13
    //   150: iload #10
    //   152: i2d
    //   153: dstore #6
    //   155: aload_0
    //   156: getfield mWidth : I
    //   159: istore #12
    //   161: aload #13
    //   163: iconst_0
    //   164: dload #6
    //   166: iload #12
    //   168: i2d
    //   169: dload #4
    //   171: dmul
    //   172: dsub
    //   173: iload #12
    //   175: i2d
    //   176: dload_2
    //   177: dmul
    //   178: dsub
    //   179: d2i
    //   180: iastore
    //   181: iload #11
    //   183: i2d
    //   184: dstore #8
    //   186: aload #13
    //   188: iconst_1
    //   189: iload #12
    //   191: i2d
    //   192: dload_2
    //   193: dmul
    //   194: dload #8
    //   196: dadd
    //   197: iload #12
    //   199: i2d
    //   200: dload #4
    //   202: dmul
    //   203: dsub
    //   204: d2i
    //   205: iastore
    //   206: aload #13
    //   208: iconst_2
    //   209: dload #6
    //   211: iload #12
    //   213: i2d
    //   214: dload #4
    //   216: dmul
    //   217: dadd
    //   218: iload #12
    //   220: i2d
    //   221: dload_2
    //   222: dmul
    //   223: dsub
    //   224: d2i
    //   225: iastore
    //   226: aload #13
    //   228: iconst_3
    //   229: dload #8
    //   231: dload_2
    //   232: iload #12
    //   234: i2d
    //   235: dmul
    //   236: dsub
    //   237: dload #4
    //   239: iload #12
    //   241: i2d
    //   242: dmul
    //   243: dsub
    //   244: d2i
    //   245: iastore
    //   246: iload #10
    //   248: iconst_2
    //   249: imul
    //   250: istore #10
    //   252: aload #13
    //   254: iconst_4
    //   255: iload #10
    //   257: aload #13
    //   259: iconst_0
    //   260: iaload
    //   261: isub
    //   262: iastore
    //   263: iload #11
    //   265: iconst_2
    //   266: imul
    //   267: istore #11
    //   269: aload #13
    //   271: iconst_5
    //   272: iload #11
    //   274: aload #13
    //   276: iconst_1
    //   277: iaload
    //   278: isub
    //   279: iastore
    //   280: aload #13
    //   282: bipush #6
    //   284: iload #10
    //   286: aload #13
    //   288: iconst_2
    //   289: iaload
    //   290: isub
    //   291: iastore
    //   292: aload #13
    //   294: bipush #7
    //   296: iload #11
    //   298: aload #13
    //   300: iconst_3
    //   301: iaload
    //   302: isub
    //   303: iastore
    //   304: return
  }
  
  public int get_leftEyeState() {
    int[] arrayOfInt = this.is_live;
    return (arrayOfInt == null || arrayOfInt.length != 11) ? 0 : arrayOfInt[1];
  }
  
  public int get_mouthState() {
    int[] arrayOfInt = this.is_live;
    return (arrayOfInt == null || arrayOfInt.length != 11) ? 0 : arrayOfInt[4];
  }
  
  public int get_rightEyeState() {
    int[] arrayOfInt = this.is_live;
    return (arrayOfInt == null || arrayOfInt.length != 11) ? 0 : arrayOfInt[2];
  }
  
  public boolean is_live() {
    int[] arrayOfInt = this.is_live;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfInt != null) {
      if (arrayOfInt.length != 11)
        return false; 
      bool1 = bool2;
      if (1 == arrayOfInt[0])
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean is_live_head_down() {
    int[] arrayOfInt = this.is_live;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfInt != null) {
      if (arrayOfInt.length != 11)
        return false; 
      bool1 = bool2;
      if (1 == arrayOfInt[9])
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean is_live_head_turn_left() {
    int[] arrayOfInt = this.is_live;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfInt != null) {
      if (arrayOfInt.length != 11)
        return false; 
      bool1 = bool2;
      if (1 == arrayOfInt[5])
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean is_live_head_turn_right() {
    int[] arrayOfInt = this.is_live;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfInt != null) {
      if (arrayOfInt.length != 11)
        return false; 
      bool1 = bool2;
      if (1 == arrayOfInt[6])
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean is_live_head_up() {
    int[] arrayOfInt = this.is_live;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfInt != null) {
      if (arrayOfInt.length != 11)
        return false; 
      bool1 = bool2;
      if (1 == arrayOfInt[8])
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean is_live_mouth() {
    int[] arrayOfInt = this.is_live;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfInt != null) {
      if (arrayOfInt.length != 11)
        return false; 
      bool1 = bool2;
      if (1 == arrayOfInt[3])
        bool1 = true; 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\facesdk\FaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */