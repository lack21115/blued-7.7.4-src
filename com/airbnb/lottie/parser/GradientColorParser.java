package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.model.content.GradientColor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradientColorParser implements ValueParser<GradientColor> {
  private int a;
  
  public GradientColorParser(int paramInt) {
    this.a = paramInt;
  }
  
  private int a(double paramDouble, double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #9
    //   3: iload #9
    //   5: aload_3
    //   6: arraylength
    //   7: if_icmpge -> 79
    //   10: iload #9
    //   12: iconst_1
    //   13: isub
    //   14: istore #10
    //   16: aload_3
    //   17: iload #10
    //   19: daload
    //   20: dstore #5
    //   22: aload_3
    //   23: iload #9
    //   25: daload
    //   26: dstore #7
    //   28: aload_3
    //   29: iload #9
    //   31: daload
    //   32: dload_1
    //   33: dcmpl
    //   34: iflt -> 70
    //   37: dload_1
    //   38: dload #5
    //   40: dsub
    //   41: dload #7
    //   43: dload #5
    //   45: dsub
    //   46: ddiv
    //   47: dstore_1
    //   48: aload #4
    //   50: iload #10
    //   52: daload
    //   53: aload #4
    //   55: iload #9
    //   57: daload
    //   58: dload_1
    //   59: invokestatic a : (DDD)D
    //   62: dstore_1
    //   63: dload_1
    //   64: ldc2_w 255.0
    //   67: dmul
    //   68: d2i
    //   69: ireturn
    //   70: iload #9
    //   72: iconst_1
    //   73: iadd
    //   74: istore #9
    //   76: goto -> 3
    //   79: aload #4
    //   81: aload #4
    //   83: arraylength
    //   84: iconst_1
    //   85: isub
    //   86: daload
    //   87: dstore_1
    //   88: goto -> 63
  }
  
  private void a(GradientColor paramGradientColor, List<Float> paramList) {
    int i = this.a * 4;
    if (paramList.size() <= i)
      return; 
    int j = (paramList.size() - i) / 2;
    double[] arrayOfDouble1 = new double[j];
    double[] arrayOfDouble2 = new double[j];
    boolean bool = false;
    int k = 0;
    while (true) {
      j = bool;
      if (i < paramList.size()) {
        if (i % 2 == 0) {
          arrayOfDouble1[k] = ((Float)paramList.get(i)).floatValue();
        } else {
          arrayOfDouble2[k] = ((Float)paramList.get(i)).floatValue();
          k++;
        } 
        i++;
        continue;
      } 
      break;
    } 
    while (j < paramGradientColor.c()) {
      i = paramGradientColor.b()[j];
      i = Color.argb(a(paramGradientColor.a()[j], arrayOfDouble1, arrayOfDouble2), Color.red(i), Color.green(i), Color.blue(i));
      paramGradientColor.b()[j] = i;
      j++;
    } 
  }
  
  public GradientColor a(JsonReader paramJsonReader, float paramFloat) throws IOException {
    ArrayList<Float> arrayList = new ArrayList();
    JsonToken jsonToken1 = paramJsonReader.peek();
    JsonToken jsonToken2 = JsonToken.BEGIN_ARRAY;
    int k = 0;
    if (jsonToken1 == jsonToken2) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i)
      paramJsonReader.beginArray(); 
    while (paramJsonReader.hasNext())
      arrayList.add(Float.valueOf((float)paramJsonReader.nextDouble())); 
    if (i)
      paramJsonReader.endArray(); 
    if (this.a == -1)
      this.a = arrayList.size() / 4; 
    int i = this.a;
    float[] arrayOfFloat = new float[i];
    int[] arrayOfInt = new int[i];
    int m = 0;
    int j = 0;
    i = k;
    k = m;
    while (i < this.a * 4) {
      m = i / 4;
      double d = ((Float)arrayList.get(i)).floatValue();
      int n = i % 4;
      if (n != 0) {
        if (n != 1) {
          if (n != 2) {
            if (n == 3)
              arrayOfInt[m] = Color.argb(255, k, j, (int)(d * 255.0D)); 
          } else {
            j = (int)(d * 255.0D);
          } 
        } else {
          k = (int)(d * 255.0D);
        } 
      } else {
        arrayOfFloat[m] = (float)d;
      } 
      i++;
    } 
    GradientColor gradientColor = new GradientColor(arrayOfFloat, arrayOfInt);
    a(gradientColor, arrayList);
    return gradientColor;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\GradientColorParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */