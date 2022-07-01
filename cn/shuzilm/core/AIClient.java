package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.security.MessageDigest;

public class AIClient {
  private static int[] A;
  
  private static int[] B;
  
  private static int[] C;
  
  private static int[] D;
  
  private static int[] E;
  
  private static int[] F;
  
  private static int[] G;
  
  private static int[] H;
  
  private static int[] I;
  
  private static int[] J;
  
  private static int[] K;
  
  private static int[] L;
  
  private static int[] M;
  
  private static int[] N;
  
  private static int[] O;
  
  private static int[] P;
  
  private static int[] Q;
  
  private static int[] R;
  
  private static int[] S;
  
  private static int[] T;
  
  private static int[] U;
  
  private static int[] V;
  
  private static int[] W;
  
  private static int[] X;
  
  private static int[] Y;
  
  private static int[] Z;
  
  private static int[] a = new int[] { 
      245, 252, 251, 246, 252, 247, 228, 188, 246, 251, 
      253, 224, 246, 252, 243, 188, 255, 253, 241, 0 };
  
  private static int[] aa;
  
  private static int[] ab;
  
  private static int[] ac;
  
  private static int[] ad;
  
  private static int[] ae;
  
  private static int[] af;
  
  private static int[] b = new int[] { 
      230, 224, 243, 230, 225, 156, 215, 209, 219, 196, 
      192, 215, 193, 156, 192, 215, 219, 212, 219, 198, 
      220, 215, 214, 219, 156, 193, 214, 211, 156, 193, 
      223, 213, 156, 214, 219, 221, 192, 214, 220, 211, 
      156, 215, 222, 213, 221, 221, 213, 156, 223, 221, 
      209, 0 };
  
  private static int[] c = new int[] { 
      230, 248, 242, 187, 241, 252, 250, 231, 241, 251, 
      244, 187, 240, 249, 242, 250, 250, 242, 187, 248, 
      250, 246, 0 };
  
  private static int[] d = new int[] { 
      166, 160, 170, 181, 177, 166, 144, 167, 138, 164, 
      173, 170, 176, 170, 183, 177, 166, 181, 167, 130, 
      138, 237, 175, 162, 173, 177, 166, 183, 173, 170, 
      237, 177, 166, 170, 165, 170, 183, 173, 166, 167, 
      170, 237, 176, 167, 162, 237, 176, 174, 164, 237, 
      167, 170, 172, 177, 167, 173, 162, 237, 166, 175, 
      164, 172, 172, 164, 237, 174, 172, 160, 0 };
  
  private static int[] e = new int[] { 
      218, 171, 169, 172, 218, 222, 170, 172, 168, 218, 
      222, 222, 171, 166, 170, 217, 168, 221, 174, 166, 
      168, 217, 169, 217, 175, 218, 173, 219, 173, 217, 
      173, 218, 0 };
  
  private static int[] f = new int[] { 246, 227, 224, 247, 245, 218, 0 };
  
  private static int[] g = new int[] { 
      234, 231, 249, 230, 160, 231, 235, 249, 239, 251, 
      230, 160, 227, 225, 237, 0 };
  
  private static int[] h = new int[] { 
      230, 224, 234, 245, 241, 230, 240, 252, 240, 231, 
      234, 237, 230, 243, 236, 141, 198, 192, 202, 213, 
      198, 199, 205, 198, 211, 204, 141, 208, 202, 199, 
      204, 214, 141, 206, 204, 192, 0 };
  
  private static int[] i = new int[] { 
      209, 215, 221, 194, 198, 209, 231, 198, 209, 221, 
      210, 221, 192, 218, 209, 208, 253, 209, 215, 221, 
      194, 209, 240, 218, 209, 196, 251, 154, 216, 208, 
      221, 213, 154, 209, 215, 221, 194, 209, 208, 218, 
      209, 196, 219, 154, 199, 221, 208, 219, 193, 154, 
      217, 219, 215, 0 };
  
  private static int[] j = new int[] { 
      219, 220, 218, 170, 167, 218, 170, 170, 221, 170, 
      219, 170, 167, 172, 167, 219, 173, 175, 173, 221, 
      217, 219, 220, 171, 222, 173, 168, 217, 218, 219, 
      217, 174, 0 };
  
  private static int[] k = new int[] { 
      243, 245, 255, 224, 228, 243, 229, 242, 255, 243, 
      245, 255, 224, 243, 242, 184, 255, 227, 236, 184, 
      251, 249, 245, 0 };
  
  private static int[] l = new int[] { 
      195, 197, 207, 208, 212, 195, 245, 194, 207, 195, 
      197, 207, 208, 195, 226, 136, 195, 197, 207, 208, 
      212, 195, 213, 194, 207, 195, 197, 207, 208, 195, 
      194, 136, 207, 211, 220, 136, 203, 201, 197, 0 };
  
  private static int[] m = new int[] { 
      204, 202, 200, 207, 219, 204, 221, 199, 224, 205, 
      192, 204, 202, 192, 223, 204, 237, 224, 135, 204, 
      202, 192, 223, 219, 204, 218, 205, 192, 204, 202, 
      192, 223, 204, 205, 135, 192, 220, 211, 135, 196, 
      198, 202, 0 };
  
  private static int[] n = new int[] { 
      221, 174, 175, 171, 167, 219, 220, 170, 168, 220, 
      167, 222, 219, 166, 221, 220, 219, 166, 217, 168, 
      172, 168, 222, 219, 217, 173, 219, 222, 219, 174, 
      174, 174, 0 };
  
  private static int[] o = new int[] { 
      222, 167, 217, 167, 172, 217, 220, 222, 219, 166, 
      170, 221, 168, 168, 170, 220, 172, 174, 171, 173, 
      174, 217, 175, 174, 221, 221, 219, 218, 222, 221, 
      168, 219, 0 };
  
  private static int[] p = new int[] { 
      197, 196, 213, 211, 206, 209, 209, 212, 210, 143, 
      197, 200, 211, 196, 200, 199, 200, 213, 207, 196, 
      197, 200, 143, 210, 216, 210, 143, 213, 210, 200, 
      210, 211, 196, 209, 0 };
  
  private static int[] q = new int[] { 
      233, 255, 243, 238, 232, 255, 234, 245, 232, 202, 
      247, 255, 238, 233, 227, 201, 180, 233, 245, 180, 
      254, 243, 245, 232, 254, 244, 251, 0 };
  
  private static int[] r = new int[] { 
      244, 249, 254, 245, 224, 255, 190, 224, 241, 228, 
      233, 245, 248, 190, 253, 255, 243, 0 };
  
  private static int[] s = new int[] { 
      197, 195, 201, 214, 210, 197, 243, 217, 198, 201, 
      212, 206, 197, 196, 233, 142, 196, 201, 206, 197, 
      208, 207, 142, 208, 193, 212, 217, 197, 200, 142, 
      205, 207, 195, 0 };
  
  private static int[] t = new int[] { 199, 202, 214, 204, 0 };
  
  private static int[] u = new int[] { 
      220, 209, 246, 253, 232, 215, 209, 182, 252, 241, 
      246, 253, 232, 247, 182, 232, 249, 236, 225, 253, 
      240, 182, 245, 247, 251, 0 };
  
  private static int[] v = new int[] { 
      222, 174, 168, 169, 219, 170, 175, 221, 218, 221, 
      170, 218, 170, 168, 173, 169, 217, 169, 174, 166, 
      175, 171, 220, 168, 172, 220, 222, 166, 175, 167, 
      170, 170, 0 };
  
  private static int[] w = new int[] { 
      226, 228, 238, 241, 245, 226, 244, 248, 227, 238, 
      248, 233, 226, 247, 232, 137, 195, 206, 201, 194, 
      215, 200, 137, 215, 198, 211, 222, 194, 207, 137, 
      202, 200, 196, 137, 201, 200, 206, 211, 196, 198, 
      0 };
  
  private static int[] x = new int[] { 
      173, 169, 167, 217, 219, 219, 218, 221, 220, 167, 
      218, 220, 217, 167, 222, 169, 172, 172, 220, 217, 
      219, 217, 172, 168, 221, 168, 221, 173, 167, 175, 
      171, 166, 0 };
  
  private static int[] y = new int[] { 
      234, 248, 230, 165, 248, 254, 248, 234, 165, 230, 
      228, 232, 0 };
  
  private static int[] z = new int[] { 
      217, 212, 217, 194, 206, 206, 216, 222, 222, 220, 
      179, 243, 242, 244, 233, 254, 252, 179, 252, 238, 
      240, 179, 238, 232, 238, 252, 179, 240, 242, 254, 
      0 };
  
  private Context ag;
  
  private String ah = null;
  
  private final int ai = 0;
  
  private final int aj = 1;
  
  private final int ak = 2;
  
  private final int al = 3;
  
  private final int am = 4;
  
  private final int an = 5;
  
  private final int ao = 6;
  
  public boolean isf = false;
  
  static {
    A = new int[] { 
        216, 213, 216, 229, 238, 253, 232, 242, 249, 241, 
        249, 240, 236, 236, 233, 207, 178, 253, 239, 241, 
        178, 239, 233, 239, 253, 178, 241, 243, 255, 0 };
    B = new int[] { 
        209, 215, 221, 194, 198, 209, 231, 240, 253, 240, 
        205, 198, 213, 192, 218, 209, 217, 209, 216, 196, 
        196, 193, 231, 154, 240, 253, 240, 205, 198, 213, 
        192, 218, 209, 217, 209, 216, 196, 196, 193, 231, 
        154, 213, 199, 217, 154, 199, 193, 199, 213, 154, 
        217, 219, 215, 0 };
    C = new int[] { 
        203, 205, 207, 200, 220, 203, 218, 192, 231, 194, 
        202, 199, 239, 202, 199, 234, 231, 128, 234, 231, 
        234, 215, 220, 207, 218, 192, 203, 195, 203, 194, 
        222, 222, 219, 253, 128, 207, 221, 195, 128, 221, 
        219, 221, 207, 128, 195, 193, 205, 0 };
    D = new int[] { 
        217, 170, 217, 218, 166, 174, 221, 222, 174, 167, 
        171, 174, 173, 217, 221, 170, 171, 169, 217, 221, 
        171, 166, 167, 171, 173, 218, 170, 217, 172, 167, 
        170, 171, 0 };
    E = new int[] { 
        199, 193, 203, 212, 208, 199, 209, 198, 203, 199, 
        193, 203, 212, 199, 198, 140, 198, 203, 205, 208, 
        198, 204, 195, 140, 197, 204, 215, 209, 207, 195, 
        209, 140, 207, 205, 193, 0 };
    F = new int[] { 
        215, 209, 219, 196, 192, 215, 225, 214, 251, 215, 
        209, 219, 196, 215, 246, 156, 215, 209, 219, 196, 
        192, 215, 193, 214, 219, 215, 209, 219, 196, 215, 
        214, 156, 214, 219, 221, 192, 214, 220, 211, 156, 
        213, 220, 199, 193, 223, 211, 193, 156, 223, 221, 
        209, 0 };
    G = new int[] { 
        214, 208, 218, 197, 193, 214, 224, 215, 250, 214, 
        208, 218, 197, 214, 247, 250, 157, 214, 208, 218, 
        197, 193, 214, 192, 215, 218, 214, 208, 218, 197, 
        214, 215, 157, 215, 218, 220, 193, 215, 221, 210, 
        157, 212, 221, 198, 192, 222, 210, 192, 157, 222, 
        220, 208, 0 };
    H = new int[] { 
        175, 220, 167, 172, 175, 219, 170, 173, 173, 222, 
        175, 219, 168, 219, 217, 170, 221, 167, 218, 175, 
        172, 218, 217, 218, 221, 219, 217, 217, 172, 173, 
        221, 174, 0 };
    I = new int[] { 
        140, 200, 199, 208, 199, 202, 205, 198, 211, 204, 
        141, 198, 206, 218, 207, 197, 141, 214, 217, 202, 
        198, 206, 141, 206, 204, 192, 140, 140, 153, 215, 
        205, 198, 215, 205, 204, 192, 0 };
    J = new int[] { 
        243, 252, 235, 252, 241, 246, 253, 232, 247, 182, 
        253, 245, 225, 244, 254, 182, 237, 226, 241, 253, 
        245, 182, 245, 247, 251, 0 };
    K = new int[] { 
        175, 166, 222, 169, 175, 167, 172, 222, 218, 174, 
        174, 218, 168, 175, 169, 217, 167, 171, 222, 170, 
        217, 169, 173, 219, 221, 219, 168, 172, 172, 221, 
        172, 175, 0 };
    L = new int[] { 
        218, 215, 202, 215, 205, 198, 199, 202, 140, 218, 
        215, 202, 215, 205, 198, 199, 202, 141, 194, 202, 
        193, 214, 205, 141, 205, 192, 140, 140, 153, 215, 
        205, 198, 215, 205, 204, 192, 0 };
    M = new int[] { 
        220, 174, 168, 218, 174, 217, 220, 219, 218, 168, 
        170, 167, 169, 221, 169, 222, 166, 218, 220, 222, 
        217, 172, 170, 167, 219, 172, 221, 218, 172, 173, 
        221, 170, 0 };
    N = new int[] { 
        205, 209, 204, 232, 211, 196, 197, 200, 215, 206, 
        211, 241, 197, 232, 143, 205, 209, 204, 200, 143, 
        197, 200, 143, 197, 200, 206, 211, 197, 207, 192, 
        143, 204, 206, 194, 0 };
    O = new int[] { 204, 200, 202, 196, 204, 221, 0 };
    P = new int[] { 
        194, 219, 200, 193, 218, 194, 202, 200, 197, 203, 
        0 };
    Q = new int[] { 
        234, 248, 230, 165, 239, 226, 239, 230, 165, 230, 
        228, 232, 0 };
    R = new int[] { 
        197, 195, 201, 214, 210, 197, 243, 204, 235, 193, 
        211, 237, 142, 197, 195, 201, 214, 210, 197, 211, 
        142, 193, 211, 205, 142, 196, 201, 196, 205, 142, 
        205, 207, 195, 0 };
    S = new int[] { 
        250, 252, 246, 233, 237, 250, 236, 177, 235, 237, 
        254, 235, 236, 177, 241, 240, 246, 235, 252, 254, 
        177, 254, 236, 242, 177, 241, 234, 253, 177, 242, 
        240, 252, 0 };
    T = new int[] { 
        253, 245, 249, 246, 255, 243, 232, 182, 245, 249, 
        234, 249, 232, 182, 249, 235, 245, 182, 246, 237, 
        250, 182, 245, 247, 251, 0 };
    U = new int[] { 
        220, 170, 221, 175, 218, 175, 173, 175, 217, 172, 
        175, 220, 169, 222, 217, 175, 175, 172, 166, 222, 
        174, 222, 173, 218, 217, 171, 166, 172, 221, 218, 
        218, 174, 0 };
    V = new int[] { 
        237, 252, 234, 247, 240, 247, 236, 235, 183, 244, 
        248, 235, 248, 233, 183, 248, 234, 244, 183, 247, 
        236, 251, 183, 244, 246, 250, 0 };
    W = new int[] { 
        197, 195, 201, 214, 210, 197, 243, 196, 233, 193, 
        211, 237, 142, 197, 195, 201, 214, 210, 197, 211, 
        142, 193, 211, 205, 142, 196, 201, 196, 205, 142, 
        205, 207, 195, 0 };
    X = new int[] { 
        197, 195, 201, 214, 210, 197, 211, 142, 207, 212, 
        196, 206, 201, 194, 142, 206, 207, 201, 212, 195, 
        193, 142, 193, 211, 205, 142, 206, 213, 194, 142, 
        205, 207, 195, 0 };
    Y = new int[] { 
        252, 250, 248, 255, 235, 252, 237, 247, 208, 253, 
        208, 248, 234, 212, 183, 251, 240, 245, 183, 247, 
        236, 251, 183, 244, 246, 250, 0 };
    Z = new int[] { 
        250, 237, 251, 234, 225, 252, 254, 160, 231, 251, 
        253, 253, 160, 225, 252, 0 };
    aa = new int[] { 202, 214, 208, 208, 0 };
    ab = new int[] { 
        167, 222, 222, 171, 171, 167, 168, 217, 174, 219, 
        166, 175, 174, 168, 166, 169, 217, 174, 220, 218, 
        168, 168, 217, 174, 175, 174, 220, 217, 175, 222, 
        222, 220, 0 };
    ac = new int[] { 212, 200, 194, 202, 194, 194, 213, 193, 0 };
    ad = new int[] { 
        248, 241, 246, 245, 248, 186, 241, 249, 241, 241, 
        230, 242, 186, 240, 248, 253, 225, 246, 186, 251, 
        230, 0 };
    ae = new int[] { 
        169, 172, 222, 170, 172, 170, 171, 173, 173, 218, 
        167, 173, 170, 173, 217, 171, 166, 171, 218, 222, 
        168, 169, 166, 217, 171, 217, 166, 171, 220, 168, 
        168, 166, 0 };
    af = new int[] { 
        168, 170, 173, 221, 172, 171, 169, 167, 172, 222, 
        222, 217, 217, 222, 172, 175, 221, 167, 173, 173, 
        172, 222, 217, 172, 220, 219, 172, 174, 218, 169, 
        222, 217, 0 };
  }
  
  public AIClient(Context paramContext) {
    this.ag = paramContext;
  }
  
  private String a(String paramString) {
    if (paramString == null)
      return null; 
    try {
      Class<?> clazz = Class.forName(a(q));
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { paramString, "unknown" });
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private String a(int[] paramArrayOfint) {
    if (paramArrayOfint == null)
      return null; 
    int j = paramArrayOfint.length;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < j; i++) {
      if (i != 0)
        stringBuilder.append(Character.toString((char)(paramArrayOfint[j - i - 1] ^ j + 126))); 
    } 
    return stringBuilder.toString();
  }
  
  private void a(String paramString1, String paramString2) {
    if (paramString1 != null) {
      if (paramString2 == null)
        return; 
      try {
        Context context = this.ag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.ag.getPackageName());
        stringBuilder.append(a(f));
        SharedPreferences sharedPreferences = context.getSharedPreferences(stringBuilder.toString(), 0);
        if (sharedPreferences != null) {
          if (sharedPreferences.getString(paramString2, "a").equals(paramString1))
            return; 
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString(paramString2, paramString1);
          editor.apply();
        } 
        return;
      } catch (Exception exception) {
        return;
      } 
    } 
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: new cn/shuzilm/core/AIClient$AC
    //   6: dup
    //   7: aconst_null
    //   8: invokespecial <init> : (Lcn/shuzilm/core/AIClient$1;)V
    //   11: astore #9
    //   13: iload #6
    //   15: ifne -> 38
    //   18: new android/content/Intent
    //   21: dup
    //   22: aload_2
    //   23: invokespecial <init> : (Ljava/lang/String;)V
    //   26: astore #8
    //   28: aload #8
    //   30: aload_3
    //   31: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   34: pop
    //   35: goto -> 198
    //   38: iload #6
    //   40: iconst_1
    //   41: if_icmpne -> 64
    //   44: new android/content/Intent
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #8
    //   53: aload #8
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual setClassName : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   60: pop
    //   61: goto -> 198
    //   64: iload #6
    //   66: iconst_2
    //   67: if_icmpne -> 104
    //   70: new android/content/Intent
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore #8
    //   79: aload #8
    //   81: new android/content/ComponentName
    //   84: dup
    //   85: aload_1
    //   86: aload_2
    //   87: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   90: invokevirtual setComponent : (Landroid/content/ComponentName;)Landroid/content/Intent;
    //   93: pop
    //   94: aload #8
    //   96: aload_3
    //   97: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   100: pop
    //   101: goto -> 198
    //   104: iload #6
    //   106: iconst_3
    //   107: if_icmpne -> 144
    //   110: new android/content/Intent
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore #8
    //   119: aload #8
    //   121: aload_3
    //   122: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   125: pop
    //   126: aload #8
    //   128: new android/content/ComponentName
    //   131: dup
    //   132: aload_1
    //   133: aload_1
    //   134: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   137: invokevirtual setComponent : (Landroid/content/ComponentName;)Landroid/content/Intent;
    //   140: pop
    //   141: goto -> 198
    //   144: iload #6
    //   146: bipush #6
    //   148: if_icmpne -> 198
    //   151: new android/content/Intent
    //   154: dup
    //   155: invokespecial <init> : ()V
    //   158: astore #8
    //   160: aload #8
    //   162: aload_1
    //   163: aload_2
    //   164: invokevirtual setClassName : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   167: pop
    //   168: aload #8
    //   170: aload_3
    //   171: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   174: pop
    //   175: aload #8
    //   177: aload_0
    //   178: getstatic cn/shuzilm/core/AIClient.T : [I
    //   181: invokespecial a : ([I)Ljava/lang/String;
    //   184: aload_0
    //   185: getfield ag : Landroid/content/Context;
    //   188: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   191: getfield packageName : Ljava/lang/String;
    //   194: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   197: pop
    //   198: aload_0
    //   199: getfield ag : Landroid/content/Context;
    //   202: aload #8
    //   204: aload #9
    //   206: iconst_1
    //   207: invokevirtual bindService : (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   210: istore #7
    //   212: iload #7
    //   214: ifeq -> 347
    //   217: iload #6
    //   219: iconst_2
    //   220: if_icmpne -> 355
    //   223: new cn/shuzilm/core/AIClient$AIO
    //   226: dup
    //   227: aload_0
    //   228: aload #9
    //   230: invokevirtual getBinder : ()Landroid/os/IBinder;
    //   233: aload #4
    //   235: invokespecial <init> : (Lcn/shuzilm/core/AIClient;Landroid/os/IBinder;Ljava/lang/String;)V
    //   238: astore_1
    //   239: aload_0
    //   240: invokespecial c : ()Ljava/lang/String;
    //   243: astore_2
    //   244: aload_1
    //   245: aload_0
    //   246: getfield ag : Landroid/content/Context;
    //   249: invokevirtual getPackageName : ()Ljava/lang/String;
    //   252: aload_2
    //   253: aload_0
    //   254: getstatic cn/shuzilm/core/AIClient.t : [I
    //   257: invokespecial a : ([I)Ljava/lang/String;
    //   260: invokevirtual getId : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull -> 327
    //   268: aload_0
    //   269: aload_1
    //   270: aload #5
    //   272: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)V
    //   275: goto -> 327
    //   278: new cn/shuzilm/core/AIClient$AI
    //   281: dup
    //   282: aload_0
    //   283: aload #9
    //   285: invokevirtual getBinder : ()Landroid/os/IBinder;
    //   288: aload #4
    //   290: iconst_1
    //   291: invokespecial <init> : (Lcn/shuzilm/core/AIClient;Landroid/os/IBinder;Ljava/lang/String;I)V
    //   294: astore_1
    //   295: goto -> 315
    //   298: new cn/shuzilm/core/AIClient$AI
    //   301: dup
    //   302: aload_0
    //   303: aload #9
    //   305: invokevirtual getBinder : ()Landroid/os/IBinder;
    //   308: aload #4
    //   310: iconst_3
    //   311: invokespecial <init> : (Lcn/shuzilm/core/AIClient;Landroid/os/IBinder;Ljava/lang/String;I)V
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual getId : ()Ljava/lang/String;
    //   319: astore_1
    //   320: aload_1
    //   321: ifnull -> 327
    //   324: goto -> 268
    //   327: aload_0
    //   328: getfield ag : Landroid/content/Context;
    //   331: astore_1
    //   332: aload_1
    //   333: aload #9
    //   335: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   338: return
    //   339: aload_0
    //   340: getfield ag : Landroid/content/Context;
    //   343: astore_1
    //   344: goto -> 332
    //   347: return
    //   348: astore_1
    //   349: aload_1
    //   350: athrow
    //   351: astore_1
    //   352: goto -> 339
    //   355: iload #6
    //   357: iconst_3
    //   358: if_icmpeq -> 298
    //   361: iload #6
    //   363: bipush #6
    //   365: if_icmpne -> 278
    //   368: goto -> 298
    // Exception table:
    //   from	to	target	type
    //   3	13	348	java/lang/Exception
    //   18	35	348	java/lang/Exception
    //   44	61	348	java/lang/Exception
    //   70	101	348	java/lang/Exception
    //   110	141	348	java/lang/Exception
    //   151	198	348	java/lang/Exception
    //   198	212	348	java/lang/Exception
    //   223	264	351	finally
    //   268	275	351	finally
    //   278	295	351	finally
    //   298	315	351	finally
    //   315	320	351	finally
    //   327	332	348	java/lang/Exception
    //   332	338	348	java/lang/Exception
    //   339	344	348	java/lang/Exception
  }
  
  private boolean a(String paramString, int paramInt) {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramString == null)
      return false; 
    try {
      PackageInfo packageInfo = this.ag.getPackageManager().getPackageInfo(paramString, 0);
      if (packageInfo != null)
        bool1 = true; 
      if (paramInt == 2) {
        long l;
        bool2 = bool1;
        if (Build.VERSION.SDK_INT >= 28) {
          bool2 = bool1;
          l = packageInfo.getLongVersionCode();
        } else {
          bool2 = bool1;
          paramInt = packageInfo.versionCode;
          l = paramInt;
        } 
        if (l < 1L);
      } 
      return bool1;
    } catch (Exception exception) {
      return bool2;
    } 
  }
  
  private String b(String paramString) {
    if (paramString == null)
      return null; 
    byte[] arrayOfByte = paramString.getBytes();
    int j = arrayOfByte.length;
    for (int i = 0; i < j; i++)
      arrayOfByte[i] = (byte)(arrayOfByte[i] + 17); 
    return new String(arrayOfByte);
  }
  
  private String c() {
    if (this.ah == null) {
      String str = this.ag.getPackageName();
      try {
        Signature[] arrayOfSignature = (this.ag.getPackageManager().getPackageInfo(str, 64)).signatures;
      } catch (Exception exception) {
        exception = null;
      } 
      if (exception != null && exception.length > 0) {
        int i = 0;
        byte[] arrayOfByte = exception[0].toByteArray();
        try {
          MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
          if (messageDigest != null) {
            arrayOfByte = messageDigest.digest(arrayOfByte);
            StringBuilder stringBuilder = new StringBuilder();
            int j = arrayOfByte.length;
            while (i < j) {
              stringBuilder.append(Integer.toHexString(arrayOfByte[i] & 0xFF | 0x100).substring(1, 3));
              i++;
            } 
            this.ah = stringBuilder.toString();
          } 
        } catch (Exception exception1) {}
      } 
    } 
    return this.ah;
  }
  
  private boolean c(String paramString) {
    boolean bool = false;
    if (paramString == null)
      return false; 
    try {
      String str = Build.MANUFACTURER;
      boolean bool1 = bool;
      if (str != null) {
        str = str.toUpperCase();
        paramString = b(paramString);
        bool1 = bool;
        if (paramString != null) {
          boolean bool2 = str.equals(paramString);
          bool1 = bool;
          if (bool2)
            bool1 = true; 
        } 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private boolean d() {
    String str = a(a(p));
    return (!TextUtils.isEmpty(str) && str.equals("1"));
  }
  
  private boolean e() {
    String str = a(a(ad));
    return (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(a(ac)));
  }
  
  private boolean f() {
    String str = a(a(Z));
    return (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase("unknown"));
  }
  
  private boolean g() {
    boolean bool = false;
    try {
      if (!c("<48ID"))
        return false; 
      PackageManager packageManager = this.ag.getPackageManager();
      boolean bool1 = bool;
      if (packageManager != null) {
        ProviderInfo providerInfo = packageManager.resolveContentProvider(a(J), 0);
        bool1 = bool;
        if (providerInfo != null)
          bool1 = true; 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private boolean h() {
    try {
      if (!c("=D180"))
        return false; 
      if (Build.VERSION.SDK_INT >= 17) {
        Uri uri = Uri.parse(a(L));
        ContentProviderClient contentProviderClient = this.ag.getContentResolver().acquireUnstableContentProviderClient(uri);
        Bundle bundle = contentProviderClient.call("isSupport", null, null);
        if (bundle != null) {
          if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClient.close();
          } else {
            contentProviderClient.release();
          } 
          if (bundle.getInt("code", -1) == 0)
            return bundle.getBoolean("isSupport", true); 
        } 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private void i() {
    Intent intent = new Intent();
    intent.setClassName(a(Q), a(R));
    intent.setAction(a(S));
    intent.putExtra(a(T), (this.ag.getApplicationInfo()).packageName);
    try {
      intent.putExtra(a(V), true);
      ComponentName componentName = this.ag.startService(intent);
      if (componentName != null);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void asynAI() {
    this.isf = false;
    try {
      if (a(a(g), 0))
        a(a(g), a(h), a(g), a(i), a(j), 0); 
    } catch (Exception exception) {}
    try {
      if (a(a(a), 0))
        a(a(a), a(b), a(c), a(d), a(e), 0); 
    } catch (Exception exception) {}
    if (d())
      a(AIClient$AO.a(new AIClient$AO(this, this.ag, null), 4), a(o)); 
    try {
      if (c(";4=>E>") && a(a(k), 0))
        a(a(k), a(l), null, a(m), a(n), 1); 
    } catch (Exception exception) {}
    try {
      if (c("<>C>A>;0") && a(a(k), 0))
        a(a(k), a(l), null, a(m), a(af), 1); 
    } catch (Exception exception) {}
    try {
      if (c(">??>") && a(a(r), 0))
        a(a(r), a(s), a(w), a(u), a(v), 2); 
    } catch (Exception exception) {}
    try {
      if (c(">=4?;DB") && a(a(r), 2))
        a(a(r), a(s), a(w), a(u), a(x), 2); 
    } catch (Exception exception) {}
    try {
      if (c("0BDB"))
        a(a(A), a(B), a(z), a(C), a(D), 3); 
    } catch (Exception exception) {}
    try {
      if (a(a(E), 0))
        a(a(E), a(F), null, a(G), a(H), 1); 
    } catch (Exception exception) {}
    if (g())
      a(AIClient$AO.a(new AIClient$AO(this, this.ag, null), 5), a(K)); 
    if (h())
      a(AIClient$AO.a(new AIClient$AO(this, this.ag, null)), a(M)); 
    try {
      if (c("IC4") && a(a(Q), 2)) {
        i();
        a(a(Q), a(W), a(X), a(Y), a(ab), 6);
      } 
    } catch (Exception exception) {}
    try {
      if ((e() || c("5A44<4>B")) && a(a(Q), 2)) {
        i();
        a(a(Q), a(W), a(X), a(Y), a(ae), 6);
      } 
    } catch (Exception exception) {}
    try {
      if ((f() || c("BBD8")) && a(a(Q), 2)) {
        i();
        a(a(Q), a(W), a(X), a(Y), a(U), 6);
      } 
    } catch (Exception exception) {}
    this.isf = true;
  }
  
  public String cm(String paramString) {
    if (f())
      return a(aa); 
    if (e())
      paramString = a(ac); 
    return paramString;
  }
  
  public boolean m(String paramString) {
    if (paramString.equals(a(O)) || paramString.equals(a(P))) {
      try {
        paramString = (String)Class.forName(a(N)).newInstance();
        if (paramString != null)
          return true; 
      } catch (Exception exception) {}
      return false;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\AIClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */