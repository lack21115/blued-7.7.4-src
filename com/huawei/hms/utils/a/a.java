package com.huawei.hms.utils.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class a {
  private static String a(String paramString1, String paramString2) {
    String str = paramString1.toUpperCase(Locale.getDefault());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("=");
    int i = str.indexOf(stringBuilder.toString());
    if (i == -1)
      return null; 
    int j = paramString1.indexOf(",", i);
    return (j != -1) ? paramString1.substring(i + paramString2.length() + 1, j) : paramString1.substring(i + paramString2.length() + 1);
  }
  
  public static X509Certificate a(Context paramContext) {
    return a(paramContext, "052root");
  }
  
  public static X509Certificate a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 241
    //   4: aload_1
    //   5: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   8: ifeq -> 14
    //   11: goto -> 241
    //   14: ldc 'bks'
    //   16: invokestatic getInstance : (Ljava/lang/String;)Ljava/security/KeyStore;
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   24: ldc 'updatesdkcas.bks'
    //   26: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_0
    //   30: aload_0
    //   31: astore_2
    //   32: aload_3
    //   33: aload_0
    //   34: ldc ''
    //   36: invokevirtual toCharArray : ()[C
    //   39: invokevirtual load : (Ljava/io/InputStream;[C)V
    //   42: aload_0
    //   43: astore_2
    //   44: aload_3
    //   45: aload_1
    //   46: invokevirtual containsAlias : (Ljava/lang/String;)Z
    //   49: ifne -> 96
    //   52: aload_0
    //   53: astore_2
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore_3
    //   62: aload_0
    //   63: astore_2
    //   64: aload_3
    //   65: ldc 'Not include alias '
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_0
    //   72: astore_2
    //   73: aload_3
    //   74: aload_1
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: astore_2
    //   81: ldc 'X509CertUtil'
    //   83: aload_3
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_0
    //   97: astore_2
    //   98: aload_3
    //   99: aload_1
    //   100: invokevirtual getCertificate : (Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   103: astore_3
    //   104: aload_0
    //   105: astore_1
    //   106: aload_0
    //   107: astore_2
    //   108: aload_3
    //   109: instanceof java/security/cert/X509Certificate
    //   112: ifeq -> 228
    //   115: aload_0
    //   116: astore_2
    //   117: aload_3
    //   118: checkcast java/security/cert/X509Certificate
    //   121: astore_1
    //   122: aload_0
    //   123: astore_2
    //   124: aload_1
    //   125: invokevirtual checkValidity : ()V
    //   128: aload_0
    //   129: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   132: aload_1
    //   133: areturn
    //   134: astore_2
    //   135: aload_0
    //   136: astore_1
    //   137: aload_2
    //   138: astore_0
    //   139: goto -> 187
    //   142: astore_2
    //   143: aload_0
    //   144: astore_1
    //   145: aload_2
    //   146: astore_0
    //   147: goto -> 187
    //   150: astore_2
    //   151: aload_0
    //   152: astore_1
    //   153: aload_2
    //   154: astore_0
    //   155: goto -> 187
    //   158: astore_2
    //   159: aload_0
    //   160: astore_1
    //   161: aload_2
    //   162: astore_0
    //   163: goto -> 187
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -> 235
    //   172: astore_0
    //   173: goto -> 185
    //   176: astore_0
    //   177: goto -> 185
    //   180: astore_0
    //   181: goto -> 185
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: astore_2
    //   189: new java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial <init> : ()V
    //   196: astore_3
    //   197: aload_1
    //   198: astore_2
    //   199: aload_3
    //   200: ldc 'exception:'
    //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: astore_2
    //   208: aload_3
    //   209: aload_0
    //   210: invokevirtual getMessage : ()Ljava/lang/String;
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_1
    //   218: astore_2
    //   219: ldc 'X509CertUtil'
    //   221: aload_3
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_1
    //   229: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aload_2
    //   236: invokestatic closeQuietly : (Ljava/io/InputStream;)V
    //   239: aload_0
    //   240: athrow
    //   241: ldc 'X509CertUtil'
    //   243: ldc 'args are error'
    //   245: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   248: aconst_null
    //   249: areturn
    // Exception table:
    //   from	to	target	type
    //   14	30	184	java/security/KeyStoreException
    //   14	30	180	java/io/IOException
    //   14	30	176	java/security/cert/CertificateException
    //   14	30	172	java/security/NoSuchAlgorithmException
    //   14	30	166	finally
    //   32	42	158	java/security/KeyStoreException
    //   32	42	150	java/io/IOException
    //   32	42	142	java/security/cert/CertificateException
    //   32	42	134	java/security/NoSuchAlgorithmException
    //   32	42	234	finally
    //   44	52	158	java/security/KeyStoreException
    //   44	52	150	java/io/IOException
    //   44	52	142	java/security/cert/CertificateException
    //   44	52	134	java/security/NoSuchAlgorithmException
    //   44	52	234	finally
    //   54	62	158	java/security/KeyStoreException
    //   54	62	150	java/io/IOException
    //   54	62	142	java/security/cert/CertificateException
    //   54	62	134	java/security/NoSuchAlgorithmException
    //   54	62	234	finally
    //   64	71	158	java/security/KeyStoreException
    //   64	71	150	java/io/IOException
    //   64	71	142	java/security/cert/CertificateException
    //   64	71	134	java/security/NoSuchAlgorithmException
    //   64	71	234	finally
    //   73	79	158	java/security/KeyStoreException
    //   73	79	150	java/io/IOException
    //   73	79	142	java/security/cert/CertificateException
    //   73	79	134	java/security/NoSuchAlgorithmException
    //   73	79	234	finally
    //   81	90	158	java/security/KeyStoreException
    //   81	90	150	java/io/IOException
    //   81	90	142	java/security/cert/CertificateException
    //   81	90	134	java/security/NoSuchAlgorithmException
    //   81	90	234	finally
    //   98	104	158	java/security/KeyStoreException
    //   98	104	150	java/io/IOException
    //   98	104	142	java/security/cert/CertificateException
    //   98	104	134	java/security/NoSuchAlgorithmException
    //   98	104	234	finally
    //   108	115	158	java/security/KeyStoreException
    //   108	115	150	java/io/IOException
    //   108	115	142	java/security/cert/CertificateException
    //   108	115	134	java/security/NoSuchAlgorithmException
    //   108	115	234	finally
    //   117	122	158	java/security/KeyStoreException
    //   117	122	150	java/io/IOException
    //   117	122	142	java/security/cert/CertificateException
    //   117	122	134	java/security/NoSuchAlgorithmException
    //   117	122	234	finally
    //   124	128	158	java/security/KeyStoreException
    //   124	128	150	java/io/IOException
    //   124	128	142	java/security/cert/CertificateException
    //   124	128	134	java/security/NoSuchAlgorithmException
    //   124	128	234	finally
    //   189	197	234	finally
    //   199	206	234	finally
    //   208	217	234	finally
    //   219	228	234	finally
  }
  
  public static X509Certificate a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      return a(Base64.decode(paramString));
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCert failed : ");
      stringBuilder.append(illegalArgumentException.getMessage());
      HMSLog.e("X509CertUtil", stringBuilder.toString());
      return null;
    } 
  }
  
  public static X509Certificate a(byte[] paramArrayOfbyte) {
    try {
      return (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramArrayOfbyte));
    } catch (CertificateException certificateException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to get cert: ");
      stringBuilder.append(certificateException.getMessage());
      HMSLog.e("X509CertUtil", stringBuilder.toString());
      return null;
    } 
  }
  
  public static List<X509Certificate> a(List<String> paramList) {
    ArrayList<X509Certificate> arrayList = new ArrayList(paramList.size());
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(a(iterator.next())); 
    return arrayList;
  }
  
  public static boolean a(X509Certificate paramX509Certificate) {
    if (paramX509Certificate == null)
      return false; 
    if (paramX509Certificate.getBasicConstraints() == -1)
      return false; 
    boolean[] arrayOfBoolean = paramX509Certificate.getKeyUsage();
    return (5 < arrayOfBoolean.length) ? arrayOfBoolean[5] : false;
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString) {
    return a(paramX509Certificate, "CN", paramString);
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString1, String paramString2) {
    return (paramX509Certificate == null || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) ? false : paramString2.equals(a(paramX509Certificate.getSubjectDN().getName(), paramString1));
  }
  
  public static boolean a(X509Certificate paramX509Certificate, List<X509Certificate> paramList) {
    if (paramList != null) {
      StringBuilder stringBuilder;
      if (paramList.size() == 0)
        return false; 
      if (paramX509Certificate == null) {
        HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
        return false;
      } 
      PublicKey publicKey = paramX509Certificate.getPublicKey();
      for (X509Certificate x509Certificate : paramList) {
        if (x509Certificate != null)
          try {
            x509Certificate.verify(publicKey);
            publicKey = x509Certificate.getPublicKey();
            continue;
          } catch (CertificateException certificateException) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("verify failed ");
            stringBuilder.append(certificateException.getMessage());
            HMSLog.e("X509CertUtil", stringBuilder.toString());
          } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            continue;
          } catch (InvalidKeyException invalidKeyException) {
            continue;
          } catch (NoSuchProviderException noSuchProviderException) {
            continue;
          } catch (SignatureException signatureException) {
            continue;
          }  
        return false;
      } 
      return b((List<X509Certificate>)stringBuilder);
    } 
    return false;
  }
  
  public static boolean a(X509Certificate paramX509Certificate, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      Signature signature = Signature.getInstance(paramX509Certificate.getSigAlgName());
      signature.initVerify(paramX509Certificate.getPublicKey());
      signature.update(paramArrayOfbyte1);
      return signature.verify(paramArrayOfbyte2);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
    
    } catch (SignatureException signatureException) {
    
    } catch (InvalidKeyException invalidKeyException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed checkSignature : ");
    stringBuilder.append(invalidKeyException.getMessage());
    HMSLog.e("X509CertUtil", stringBuilder.toString());
    return false;
  }
  
  public static List<X509Certificate> b(String paramString) {
    return a(c(paramString));
  }
  
  public static boolean b(X509Certificate paramX509Certificate, String paramString) {
    return a(paramX509Certificate, "OU", paramString);
  }
  
  public static boolean b(X509Certificate paramX509Certificate, String paramString1, String paramString2) {
    try {
      return a(paramX509Certificate, paramString1.getBytes("UTF-8"), Base64.decode(paramString2));
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" plainText exception: ");
    stringBuilder.append(illegalArgumentException.getMessage());
    HMSLog.e("X509CertUtil", stringBuilder.toString());
    return false;
  }
  
  public static boolean b(List<X509Certificate> paramList) {
    for (int i = 0; i < paramList.size() - 1; i++) {
      if (!a(paramList.get(i)))
        return false; 
    } 
    return true;
  }
  
  private static List<String> c(String paramString) {
    try {
      JSONArray jSONArray = new JSONArray(paramString);
      if (jSONArray.length() <= 1)
        return Collections.emptyList(); 
      ArrayList<String> arrayList = new ArrayList(jSONArray.length());
      for (int i = 0; i < jSONArray.length(); i++)
        arrayList.add(jSONArray.getString(i)); 
      return arrayList;
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to getCertChain: ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("X509CertUtil", stringBuilder.toString());
      return Collections.emptyList();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */