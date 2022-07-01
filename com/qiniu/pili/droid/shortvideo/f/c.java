package com.qiniu.pili.droid.shortvideo.f;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.core.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
  private static c a;
  
  private Context b;
  
  private List<b> c;
  
  private c(Context paramContext) {
    this.b = paramContext.getApplicationContext();
    if (b()) {
      List<b> list = d();
      if (list == null) {
        e.d.d("Error on construct DraftBox, parse file failed, creating empty DraftBox");
        this.c = new ArrayList<b>();
        return;
      } 
      this.c = list;
      return;
    } 
    this.c = new ArrayList<b>();
  }
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: ldc com/qiniu/pili/droid/shortvideo/f/c
    //   2: monitorenter
    //   3: getstatic com/qiniu/pili/droid/shortvideo/f/c.a : Lcom/qiniu/pili/droid/shortvideo/f/c;
    //   6: ifnonnull -> 20
    //   9: new com/qiniu/pili/droid/shortvideo/f/c
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/qiniu/pili/droid/shortvideo/f/c.a : Lcom/qiniu/pili/droid/shortvideo/f/c;
    //   20: getstatic com/qiniu/pili/droid/shortvideo/f/c.a : Lcom/qiniu/pili/droid/shortvideo/f/c;
    //   23: astore_0
    //   24: ldc com/qiniu/pili/droid/shortvideo/f/c
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/qiniu/pili/droid/shortvideo/f/c
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private boolean b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getFilesDir().getPath());
    stringBuilder.append("/");
    stringBuilder.append("drafts.json");
    return (new File(stringBuilder.toString())).exists();
  }
  
  private boolean c() {
    if (b()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.getFilesDir().getPath());
      stringBuilder.append("/");
      stringBuilder.append("drafts.json");
      (new File(stringBuilder.toString())).delete();
    } 
    try {
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.b.openFileOutput("drafts.json", 0));
      Iterator<b> iterator = this.c.iterator();
      while (iterator.hasNext()) {
        JSONObject jSONObject = ((b)iterator.next()).i();
        if (jSONObject == null)
          return false; 
        outputStreamWriter.write(jSONObject.toString());
        outputStreamWriter.write("\n");
      } 
      outputStreamWriter.close();
      return true;
    } catch (IOException iOException) {
      e.d.e("DraftBox", "Error on drafts saveToLocalStorage");
      return false;
    } 
  }
  
  private List<b> d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getFilesDir().getPath());
    stringBuilder.append("/");
    stringBuilder.append("drafts.json");
    File file = new File(stringBuilder.toString());
    ArrayList<b> arrayList = new ArrayList();
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          JSONObject jSONObject = new JSONObject(str);
          b b = new b();
          Stack<h> stack = new Stack();
          Iterator<String> iterator = jSONObject.keys();
          while (iterator.hasNext()) {
            String str1 = iterator.next();
            if (str1.equals("tag"))
              b.a(jSONObject.optString("tag")); 
            if (str1.equals("PLCameraSetting"))
              b.a(PLCameraSetting.fromJSON(jSONObject.optJSONObject("PLCameraSetting"))); 
            if (str1.equals("PLMicrophoneSetting"))
              b.a(PLMicrophoneSetting.fromJSON(jSONObject.optJSONObject("PLMicrophoneSetting"))); 
            if (str1.equals("PLVideoEncodeSetting"))
              b.a(PLVideoEncodeSetting.fromJSON(this.b, jSONObject.optJSONObject("PLVideoEncodeSetting"))); 
            if (str1.equals("PLAudioEncodeSetting"))
              b.a(PLAudioEncodeSetting.fromJSON(jSONObject.optJSONObject("PLAudioEncodeSetting"))); 
            if (str1.equals("PLFaceBeautySetting"))
              b.a(PLFaceBeautySetting.fromJSON(jSONObject.optJSONObject("PLFaceBeautySetting"))); 
            if (str1.equals("PLRecordSetting"))
              b.a(PLRecordSetting.fromJSON(jSONObject.optJSONObject("PLRecordSetting"))); 
            if (str1.equals("sections")) {
              JSONArray jSONArray = jSONObject.optJSONArray("sections");
              for (int i = 0; i < jSONArray.length(); i++)
                stack.push(h.a(jSONArray.getJSONObject(i))); 
              b.a(stack);
            } 
          } 
          arrayList.add(b);
          continue;
        } 
        bufferedReader.close();
        return arrayList;
      } 
    } catch (IOException|org.json.JSONException iOException) {
      e.d.e("DraftBox", "Error on recoverFromFile");
      return null;
    } 
  }
  
  public b a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 51
    //   21: aload_3
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/qiniu/pili/droid/shortvideo/f/b
    //   30: astore #4
    //   32: aload #4
    //   34: invokevirtual a : ()Ljava/lang/String;
    //   37: aload_1
    //   38: invokevirtual equals : (Ljava/lang/Object;)Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq -> 12
    //   46: aload_0
    //   47: monitorexit
    //   48: aload #4
    //   50: areturn
    //   51: aload_0
    //   52: monitorexit
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	55	finally
    //   12	42	55	finally
  }
  
  public List<b> a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/List;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void a(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield c : Ljava/util/List;
    //   8: invokeinterface iterator : ()Ljava/util/Iterator;
    //   13: astore #5
    //   15: aload #5
    //   17: invokeinterface hasNext : ()Z
    //   22: ifeq -> 55
    //   25: aload #5
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: checkcast com/qiniu/pili/droid/shortvideo/f/b
    //   35: astore #4
    //   37: aload #4
    //   39: invokevirtual a : ()Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifeq -> 15
    //   49: aload #4
    //   51: astore_3
    //   52: goto -> 15
    //   55: aload_3
    //   56: ifnull -> 207
    //   59: aload_0
    //   60: getfield c : Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface remove : (Ljava/lang/Object;)Z
    //   69: pop
    //   70: iload_2
    //   71: ifeq -> 207
    //   74: aload_3
    //   75: invokevirtual b : ()Ljava/util/Stack;
    //   78: invokevirtual iterator : ()Ljava/util/Iterator;
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface hasNext : ()Z
    //   88: ifeq -> 207
    //   91: aload_1
    //   92: invokeinterface next : ()Ljava/lang/Object;
    //   97: checkcast com/qiniu/pili/droid/shortvideo/core/h
    //   100: astore_3
    //   101: aload_3
    //   102: getfield a : Ljava/io/File;
    //   105: invokevirtual delete : ()Z
    //   108: ifeq -> 159
    //   111: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   114: astore #4
    //   116: new java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial <init> : ()V
    //   123: astore #5
    //   125: aload #5
    //   127: ldc_w 'deleted section:'
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload #5
    //   136: aload_3
    //   137: getfield a : Ljava/io/File;
    //   140: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload #4
    //   146: ldc 'DraftBox'
    //   148: aload #5
    //   150: invokevirtual toString : ()Ljava/lang/String;
    //   153: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -> 82
    //   159: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   162: astore #4
    //   164: new java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial <init> : ()V
    //   171: astore #5
    //   173: aload #5
    //   175: ldc_w 'deleted section failed:'
    //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload #5
    //   184: aload_3
    //   185: getfield a : Ljava/io/File;
    //   188: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #4
    //   194: ldc 'DraftBox'
    //   196: aload #5
    //   198: invokevirtual toString : ()Ljava/lang/String;
    //   201: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto -> 82
    //   207: aload_0
    //   208: invokespecial c : ()Z
    //   211: pop
    //   212: aload_0
    //   213: monitorexit
    //   214: return
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Exception table:
    //   from	to	target	type
    //   4	15	215	finally
    //   15	49	215	finally
    //   59	70	215	finally
    //   74	82	215	finally
    //   82	156	215	finally
    //   159	204	215	finally
    //   207	212	215	finally
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 170
    //   6: aload_0
    //   7: getfield c : Ljava/util/List;
    //   10: invokeinterface iterator : ()Ljava/util/Iterator;
    //   15: astore_2
    //   16: aload_2
    //   17: invokeinterface hasNext : ()Z
    //   22: ifeq -> 170
    //   25: aload_2
    //   26: invokeinterface next : ()Ljava/lang/Object;
    //   31: checkcast com/qiniu/pili/droid/shortvideo/f/b
    //   34: invokevirtual b : ()Ljava/util/Stack;
    //   37: invokevirtual iterator : ()Ljava/util/Iterator;
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface hasNext : ()Z
    //   47: ifeq -> 16
    //   50: aload_3
    //   51: invokeinterface next : ()Ljava/lang/Object;
    //   56: checkcast com/qiniu/pili/droid/shortvideo/core/h
    //   59: astore #4
    //   61: aload #4
    //   63: getfield a : Ljava/io/File;
    //   66: invokevirtual delete : ()Z
    //   69: ifeq -> 121
    //   72: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   75: astore #5
    //   77: new java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial <init> : ()V
    //   84: astore #6
    //   86: aload #6
    //   88: ldc_w 'deleted section:'
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #6
    //   97: aload #4
    //   99: getfield a : Ljava/io/File;
    //   102: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #5
    //   108: ldc 'DraftBox'
    //   110: aload #6
    //   112: invokevirtual toString : ()Ljava/lang/String;
    //   115: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -> 41
    //   121: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   124: astore #5
    //   126: new java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial <init> : ()V
    //   133: astore #6
    //   135: aload #6
    //   137: ldc_w 'deleted section failed:'
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload #6
    //   146: aload #4
    //   148: getfield a : Ljava/io/File;
    //   151: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload #5
    //   157: ldc 'DraftBox'
    //   159: aload #6
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   167: goto -> 41
    //   170: aload_0
    //   171: getfield c : Ljava/util/List;
    //   174: invokeinterface clear : ()V
    //   179: aload_0
    //   180: invokespecial b : ()Z
    //   183: ifeq -> 238
    //   186: new java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial <init> : ()V
    //   193: astore_2
    //   194: aload_2
    //   195: aload_0
    //   196: getfield b : Landroid/content/Context;
    //   199: invokevirtual getFilesDir : ()Ljava/io/File;
    //   202: invokevirtual getPath : ()Ljava/lang/String;
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_2
    //   210: ldc '/'
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_2
    //   217: ldc 'drafts.json'
    //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: new java/io/File
    //   226: dup
    //   227: aload_2
    //   228: invokevirtual toString : ()Ljava/lang/String;
    //   231: invokespecial <init> : (Ljava/lang/String;)V
    //   234: invokevirtual delete : ()Z
    //   237: pop
    //   238: aload_0
    //   239: monitorexit
    //   240: return
    //   241: astore_2
    //   242: aload_0
    //   243: monitorexit
    //   244: aload_2
    //   245: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	241	finally
    //   16	41	241	finally
    //   41	118	241	finally
    //   121	167	241	finally
    //   170	238	241	finally
  }
  
  public boolean a(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield c : Ljava/util/List;
    //   8: invokeinterface iterator : ()Ljava/util/Iterator;
    //   13: astore #5
    //   15: aload #5
    //   17: invokeinterface hasNext : ()Z
    //   22: ifeq -> 100
    //   25: aload #5
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: checkcast com/qiniu/pili/droid/shortvideo/f/b
    //   35: astore #4
    //   37: aload #4
    //   39: invokevirtual a : ()Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual a : ()Ljava/lang/String;
    //   46: invokevirtual equals : (Ljava/lang/Object;)Z
    //   49: ifeq -> 15
    //   52: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   55: astore_3
    //   56: new java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore #6
    //   65: aload #6
    //   67: ldc_w 'Delete old draft: '
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #6
    //   76: aload #4
    //   78: invokevirtual a : ()Ljava/lang/String;
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: aload #6
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: invokevirtual c : (Ljava/lang/String;)V
    //   94: aload #4
    //   96: astore_3
    //   97: goto -> 15
    //   100: aload_3
    //   101: ifnull -> 115
    //   104: aload_0
    //   105: getfield c : Ljava/util/List;
    //   108: aload_3
    //   109: invokeinterface remove : (Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield c : Ljava/util/List;
    //   119: aload_1
    //   120: invokeinterface add : (Ljava/lang/Object;)Z
    //   125: pop
    //   126: aload_0
    //   127: invokespecial c : ()Z
    //   130: istore_2
    //   131: aload_0
    //   132: monitorexit
    //   133: iload_2
    //   134: ireturn
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Exception table:
    //   from	to	target	type
    //   4	15	135	finally
    //   15	94	135	finally
    //   104	115	135	finally
    //   115	131	135	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */