package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LayerParser {
  public static Layer a(JsonReader paramJsonReader, LottieComposition paramLottieComposition) throws IOException {
    Layer.LayerType layerType;
    AnimatableFloatValue animatableFloatValue;
    AnimatableTransform animatableTransform;
    Layer.MatteType matteType = Layer.MatteType.a;
    ArrayList<Mask> arrayList1 = new ArrayList();
    ArrayList<ContentModel> arrayList2 = new ArrayList();
    paramJsonReader.beginObject();
    Float float_1 = Float.valueOf(1.0F);
    Float float_2 = Float.valueOf(0.0F);
    String str9 = null;
    String str3 = str9;
    String str4 = str3;
    String str1 = str4;
    String str2 = str1;
    String str5 = str2;
    long l2 = 0L;
    long l1 = -1L;
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f2 = 1.0F;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    float f1 = 0.0F;
    boolean bool = false;
    String str8 = str5;
    String str10 = "UNSET";
    String str6 = str4;
    String str7 = str3;
    str4 = str9;
    str3 = str8;
    for (str8 = str10; paramJsonReader.hasNext(); str8 = paramJsonReader.nextString()) {
      int i1;
      ArrayList<String> arrayList3;
      StringBuilder stringBuilder;
      str9 = paramJsonReader.nextName();
      switch (str9.hashCode()) {
        default:
          i1 = -1;
          break;
        case 1441620890:
          if (str9.equals("masksProperties")) {
            i1 = 10;
            break;
          } 
        case 108390670:
          if (str9.equals("refId")) {
            i1 = 2;
            break;
          } 
        case 104415:
          if (str9.equals("ind")) {
            i1 = 1;
            break;
          } 
        case 3717:
          if (str9.equals("ty")) {
            i1 = 3;
            break;
          } 
        case 3712:
          if (str9.equals("tt")) {
            i1 = 9;
            break;
          } 
        case 3705:
          if (str9.equals("tm")) {
            i1 = 20;
            break;
          } 
        case 3684:
          if (str9.equals("sw")) {
            i1 = 5;
            break;
          } 
        case 3681:
          if (str9.equals("st")) {
            i1 = 15;
            break;
          } 
        case 3679:
          if (str9.equals("sr")) {
            i1 = 14;
            break;
          } 
        case 3669:
          if (str9.equals("sh")) {
            i1 = 6;
            break;
          } 
        case 3664:
          if (str9.equals("sc")) {
            i1 = 7;
            break;
          } 
        case 3553:
          if (str9.equals("op")) {
            i1 = 19;
            break;
          } 
        case 3519:
          if (str9.equals("nm")) {
            i1 = 0;
            break;
          } 
        case 3432:
          if (str9.equals("ks")) {
            i1 = 8;
            break;
          } 
        case 3367:
          if (str9.equals("ip")) {
            i1 = 18;
            break;
          } 
        case 3324:
          if (str9.equals("hd")) {
            i1 = 22;
            break;
          } 
        case 3233:
          if (str9.equals("ef")) {
            i1 = 13;
            break;
          } 
        case 3177:
          if (str9.equals("cl")) {
            i1 = 21;
            break;
          } 
        case 119:
          if (str9.equals("w")) {
            i1 = 16;
            break;
          } 
        case 116:
          if (str9.equals("t")) {
            i1 = 12;
            break;
          } 
        case 104:
          if (str9.equals("h")) {
            i1 = 17;
            break;
          } 
        case -903568142:
          if (str9.equals("shapes")) {
            i1 = 11;
            break;
          } 
        case -995424086:
          if (str9.equals("parent")) {
            i1 = 4;
            break;
          } 
      } 
      switch (i1) {
        default:
          paramJsonReader.skipValue();
          continue;
        case 22:
          bool = paramJsonReader.nextBoolean();
          continue;
        case 21:
          str3 = paramJsonReader.nextString();
          continue;
        case 20:
          animatableFloatValue = AnimatableValueParser.a(paramJsonReader, paramLottieComposition, false);
          continue;
        case 19:
          f3 = (float)paramJsonReader.nextDouble();
          continue;
        case 18:
          f4 = (float)paramJsonReader.nextDouble();
          continue;
        case 17:
          i = (int)(paramJsonReader.nextInt() * Utils.a());
          continue;
        case 16:
          j = (int)(paramJsonReader.nextInt() * Utils.a());
          continue;
        case 15:
          f1 = (float)paramJsonReader.nextDouble();
          continue;
        case 14:
          f2 = (float)paramJsonReader.nextDouble();
          continue;
        case 13:
          paramJsonReader.beginArray();
          arrayList3 = new ArrayList();
          while (paramJsonReader.hasNext()) {
            paramJsonReader.beginObject();
            while (paramJsonReader.hasNext()) {
              str10 = paramJsonReader.nextName();
              if (str10.hashCode() == 3519 && str10.equals("nm")) {
                i1 = 0;
              } else {
                i1 = -1;
              } 
              if (i1 != 0) {
                paramJsonReader.skipValue();
                continue;
              } 
              arrayList3.add(paramJsonReader.nextString());
            } 
            paramJsonReader.endObject();
          } 
          paramJsonReader.endArray();
          stringBuilder = new StringBuilder();
          stringBuilder.append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
          stringBuilder.append(arrayList3);
          paramLottieComposition.a(stringBuilder.toString());
          continue;
        case 12:
          paramJsonReader.beginObject();
          while (true)
            paramJsonReader.skipValue(); 
          paramJsonReader.endObject();
          continue;
        case 11:
          paramJsonReader.beginArray();
          while (paramJsonReader.hasNext()) {
            ContentModel contentModel = ContentModelParser.a(paramJsonReader, paramLottieComposition);
            if (contentModel != null)
              arrayList2.add(contentModel); 
          } 
          paramJsonReader.endArray();
          continue;
        case 10:
          paramJsonReader.beginArray();
          while (paramJsonReader.hasNext())
            arrayList1.add(MaskParser.a(paramJsonReader, paramLottieComposition)); 
          paramLottieComposition.a(arrayList1.size());
          paramJsonReader.endArray();
          continue;
        case 9:
          matteType = Layer.MatteType.values()[paramJsonReader.nextInt()];
          paramLottieComposition.a(1);
          continue;
        case 8:
          animatableTransform = AnimatableTransformParser.a(paramJsonReader, paramLottieComposition);
          continue;
        case 7:
          k = Color.parseColor(paramJsonReader.nextString());
          continue;
        case 6:
          m = (int)(paramJsonReader.nextInt() * Utils.a());
          continue;
        case 5:
          n = (int)(paramJsonReader.nextInt() * Utils.a());
          continue;
        case 4:
          l1 = paramJsonReader.nextInt();
          continue;
        case 3:
          i1 = paramJsonReader.nextInt();
          if (i1 < Layer.LayerType.g.ordinal()) {
            Layer.LayerType layerType1 = Layer.LayerType.values()[i1];
            continue;
          } 
          layerType = Layer.LayerType.g;
          continue;
        case 2:
          str7 = paramJsonReader.nextString();
          continue;
        case 1:
          l2 = paramJsonReader.nextInt();
          continue;
        case 0:
          break;
      } 
      continue;
    } 
    paramJsonReader.endObject();
    f4 /= f2;
    f3 /= f2;
    ArrayList<Keyframe> arrayList = new ArrayList();
    if (f4 > 0.0F)
      arrayList.add(new Keyframe(paramLottieComposition, float_2, float_2, null, 0.0F, Float.valueOf(f4))); 
    if (f3 <= 0.0F)
      f3 = paramLottieComposition.g(); 
    arrayList.add(new Keyframe(paramLottieComposition, float_1, float_1, null, f4, Float.valueOf(f3)));
    arrayList.add(new Keyframe(paramLottieComposition, float_2, float_2, null, f3, Float.valueOf(Float.MAX_VALUE)));
    if (str8.endsWith(".ai") || "ai".equals(str3))
      paramLottieComposition.a("Convert your Illustrator layers to shape layers."); 
    return new Layer(arrayList2, paramLottieComposition, str8, l2, layerType, l1, str7, arrayList1, animatableTransform, n, m, k, f2, f1, j, i, (AnimatableTextFrame)str1, (AnimatableTextProperties)str2, arrayList, matteType, animatableFloatValue, bool);
  }
  
  public static Layer a(LottieComposition paramLottieComposition) {
    Rect rect = paramLottieComposition.d();
    return new Layer(Collections.emptyList(), paramLottieComposition, "__container", -1L, Layer.LayerType.a, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0F, 0.0F, rect.width(), rect.height(), null, null, Collections.emptyList(), Layer.MatteType.a, null, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\parser\LayerParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */