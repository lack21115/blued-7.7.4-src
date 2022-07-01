package com.airbnb.lottie.parser;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionParser {
  public static LottieComposition a(JsonReader paramJsonReader) throws IOException {
    float f4 = Utils.a();
    LongSparseArray<Layer> longSparseArray = new LongSparseArray();
    ArrayList<Layer> arrayList1 = new ArrayList();
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    ArrayList<Marker> arrayList = new ArrayList();
    SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat();
    LottieComposition lottieComposition = new LottieComposition();
    paramJsonReader.beginObject();
    int j = 0;
    int i = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (paramJsonReader.hasNext()) {
      byte b;
      String[] arrayOfString;
      String str = paramJsonReader.nextName();
      switch (str.hashCode()) {
        default:
          b = -1;
          break;
        case 839250809:
          if (str.equals("markers")) {
            b = 10;
            break;
          } 
        case 97615364:
          if (str.equals("fonts")) {
            b = 8;
            break;
          } 
        case 94623709:
          if (str.equals("chars")) {
            b = 9;
            break;
          } 
        case 3553:
          if (str.equals("op")) {
            b = 3;
            break;
          } 
        case 3367:
          if (str.equals("ip")) {
            b = 2;
            break;
          } 
        case 3276:
          if (str.equals("fr")) {
            b = 4;
            break;
          } 
        case 119:
          if (str.equals("w")) {
            b = 0;
            break;
          } 
        case 118:
          if (str.equals("v")) {
            b = 5;
            break;
          } 
        case 104:
          if (str.equals("h")) {
            b = 1;
            break;
          } 
        case -1109732030:
          if (str.equals("layers")) {
            b = 6;
            break;
          } 
        case -1408207997:
          if (str.equals("assets")) {
            b = 7;
            break;
          } 
      } 
      switch (b) {
        default:
          paramJsonReader.skipValue();
          continue;
        case 10:
          a(paramJsonReader, lottieComposition, arrayList);
          continue;
        case 9:
          a(paramJsonReader, lottieComposition, sparseArrayCompat);
          continue;
        case 8:
          a(paramJsonReader, (Map)hashMap1);
          continue;
        case 7:
          a(paramJsonReader, lottieComposition, (Map)hashMap2, (Map)hashMap3);
          continue;
        case 6:
          a(paramJsonReader, lottieComposition, arrayList1, longSparseArray);
          continue;
        case 5:
          arrayOfString = paramJsonReader.nextString().split("\\.");
          if (!Utils.a(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]), Integer.parseInt(arrayOfString[2]), 4, 4, 0))
            lottieComposition.a("Lottie only supports bodymovin >= 4.4.0"); 
          continue;
        case 4:
          f1 = (float)paramJsonReader.nextDouble();
          continue;
        case 3:
          f2 = (float)paramJsonReader.nextDouble() - 0.01F;
          continue;
        case 2:
          f3 = (float)paramJsonReader.nextDouble();
          continue;
        case 1:
          i = paramJsonReader.nextInt();
          continue;
        case 0:
          break;
      } 
      j = paramJsonReader.nextInt();
    } 
    paramJsonReader.endObject();
    lottieComposition.a(new Rect(0, 0, (int)(j * f4), (int)(i * f4)), f3, f2, f1, arrayList1, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap1, arrayList);
    return lottieComposition;
  }
  
  private static void a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, SparseArrayCompat<FontCharacter> paramSparseArrayCompat) throws IOException {
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      FontCharacter fontCharacter = FontCharacterParser.a(paramJsonReader, paramLottieComposition);
      paramSparseArrayCompat.put(fontCharacter.hashCode(), fontCharacter);
    } 
    paramJsonReader.endArray();
  }
  
  private static void a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, List<Marker> paramList) throws IOException {
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      String str;
      paramLottieComposition = null;
      paramJsonReader.beginObject();
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (paramJsonReader.hasNext()) {
        String str1 = paramJsonReader.nextName();
        byte b = -1;
        int i = str1.hashCode();
        if (i != 3178) {
          if (i != 3214) {
            if (i == 3705 && str1.equals("tm"))
              b = 1; 
          } else if (str1.equals("dr")) {
            b = 2;
          } 
        } else if (str1.equals("cm")) {
          b = 0;
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              paramJsonReader.skipValue();
              continue;
            } 
            f1 = (float)paramJsonReader.nextDouble();
            continue;
          } 
          f2 = (float)paramJsonReader.nextDouble();
          continue;
        } 
        str = paramJsonReader.nextString();
      } 
      paramJsonReader.endObject();
      paramList.add(new Marker(str, f2, f1));
    } 
    paramJsonReader.endArray();
  }
  
  private static void a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray) throws IOException {
    paramJsonReader.beginArray();
    int i = 0;
    while (paramJsonReader.hasNext()) {
      Layer layer = LayerParser.a(paramJsonReader, paramLottieComposition);
      int j = i;
      if (layer.k() == Layer.LayerType.c)
        j = i + 1; 
      paramList.add(layer);
      paramLongSparseArray.put(layer.e(), layer);
      i = j;
      if (j > 4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You have ");
        stringBuilder.append(j);
        stringBuilder.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
        Logger.b(stringBuilder.toString());
        i = j;
      } 
    } 
    paramJsonReader.endArray();
  }
  
  private static void a(JsonReader paramJsonReader, LottieComposition paramLottieComposition, Map<String, List<Layer>> paramMap, Map<String, LottieImageAsset> paramMap1) throws IOException {
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      ArrayList<Layer> arrayList = new ArrayList();
      LongSparseArray longSparseArray = new LongSparseArray();
      paramJsonReader.beginObject();
      String str3 = null;
      String str1 = str3;
      String str2 = str1;
      int j = 0;
      int i = 0;
      while (paramJsonReader.hasNext()) {
        String str = paramJsonReader.nextName();
        byte b = -1;
        int k = str.hashCode();
        if (k != -1109732030) {
          if (k != 104) {
            if (k != 112) {
              if (k != 117) {
                if (k != 119) {
                  if (k == 3355 && str.equals("id"))
                    b = 0; 
                } else if (str.equals("w")) {
                  b = 2;
                } 
              } else if (str.equals("u")) {
                b = 5;
              } 
            } else if (str.equals("p")) {
              b = 4;
            } 
          } else if (str.equals("h")) {
            b = 3;
          } 
        } else if (str.equals("layers")) {
          b = 1;
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b != 3) {
                if (b != 4) {
                  if (b != 5) {
                    paramJsonReader.skipValue();
                    continue;
                  } 
                  str2 = paramJsonReader.nextString();
                  continue;
                } 
                str1 = paramJsonReader.nextString();
                continue;
              } 
              i = paramJsonReader.nextInt();
              continue;
            } 
            j = paramJsonReader.nextInt();
            continue;
          } 
          paramJsonReader.beginArray();
          while (paramJsonReader.hasNext()) {
            Layer layer = LayerParser.a(paramJsonReader, paramLottieComposition);
            longSparseArray.put(layer.e(), layer);
            arrayList.add(layer);
          } 
          paramJsonReader.endArray();
          continue;
        } 
        str3 = paramJsonReader.nextString();
      } 
      paramJsonReader.endObject();
      if (str1 != null) {
        LottieImageAsset lottieImageAsset = new LottieImageAsset(j, i, str3, str1, str2);
        paramMap1.put(lottieImageAsset.a(), lottieImageAsset);
        continue;
      } 
      paramMap.put(str3, arrayList);
    } 
    paramJsonReader.endArray();
  }
  
  private static void a(JsonReader paramJsonReader, Map<String, Font> paramMap) throws IOException {
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext()) {
      String str = paramJsonReader.nextName();
      byte b = -1;
      if (str.hashCode() == 3322014 && str.equals("list"))
        b = 0; 
      if (b != 0) {
        paramJsonReader.skipValue();
        continue;
      } 
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext()) {
        Font font = FontParser.a(paramJsonReader);
        paramMap.put(font.b(), font);
      } 
      paramJsonReader.endArray();
    } 
    paramJsonReader.endObject();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\LottieCompositionParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */