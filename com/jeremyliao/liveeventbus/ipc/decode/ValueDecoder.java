package com.jeremyliao.liveeventbus.ipc.decode;

import android.content.Intent;
import com.jeremyliao.liveeventbus.ipc.DataType;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;

public class ValueDecoder implements IDecoder {
  private final JsonConverter jsonConverter;
  
  public ValueDecoder(JsonConverter paramJsonConverter) {
    this.jsonConverter = paramJsonConverter;
  }
  
  public Object decode(Intent paramIntent) throws DecodeException {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'leb_ipc_value_type'
    //   3: iconst_m1
    //   4: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   7: istore_2
    //   8: iload_2
    //   9: iflt -> 300
    //   12: invokestatic values : ()[Lcom/jeremyliao/liveeventbus/ipc/DataType;
    //   15: iload_2
    //   16: aaload
    //   17: astore_3
    //   18: getstatic com/jeremyliao/liveeventbus/ipc/decode/ValueDecoder$1.$SwitchMap$com$jeremyliao$liveeventbus$ipc$DataType : [I
    //   21: aload_3
    //   22: invokevirtual ordinal : ()I
    //   25: iaload
    //   26: tableswitch default -> 80, 1 -> 293, 2 -> 282, 3 -> 271, 4 -> 258, 5 -> 246, 6 -> 233, 7 -> 226, 8 -> 219, 9 -> 212, 10 -> 88
    //   80: new com/jeremyliao/liveeventbus/ipc/decode/DecodeException
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: athrow
    //   88: aload_1
    //   89: ldc 'leb_ipc_value'
    //   91: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   94: astore #4
    //   96: aload_1
    //   97: ldc 'leb_ipc_class_name'
    //   99: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   102: astore #5
    //   104: aconst_null
    //   105: astore_1
    //   106: aload #5
    //   108: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   111: astore_3
    //   112: aload_3
    //   113: astore_1
    //   114: goto -> 187
    //   117: aload #5
    //   119: bipush #46
    //   121: invokevirtual lastIndexOf : (I)I
    //   124: istore_2
    //   125: iload_2
    //   126: iconst_m1
    //   127: if_icmpeq -> 187
    //   130: aload #5
    //   132: iconst_0
    //   133: iload_2
    //   134: invokevirtual substring : (II)Ljava/lang/String;
    //   137: astore_1
    //   138: aload #5
    //   140: iload_2
    //   141: iconst_1
    //   142: iadd
    //   143: invokevirtual substring : (I)Ljava/lang/String;
    //   146: astore_3
    //   147: new java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial <init> : ()V
    //   154: astore #5
    //   156: aload #5
    //   158: aload_1
    //   159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload #5
    //   165: ldc '$'
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #5
    //   173: aload_3
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #5
    //   180: invokevirtual toString : ()Ljava/lang/String;
    //   183: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   186: astore_1
    //   187: aload_0
    //   188: getfield jsonConverter : Lcom/jeremyliao/liveeventbus/ipc/json/JsonConverter;
    //   191: aload #4
    //   193: aload_1
    //   194: invokeinterface fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   199: astore_1
    //   200: aload_1
    //   201: areturn
    //   202: astore_1
    //   203: new com/jeremyliao/liveeventbus/ipc/decode/DecodeException
    //   206: dup
    //   207: aload_1
    //   208: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   211: athrow
    //   212: aload_1
    //   213: ldc 'leb_ipc_value'
    //   215: invokevirtual getBundleExtra : (Ljava/lang/String;)Landroid/os/Bundle;
    //   218: areturn
    //   219: aload_1
    //   220: ldc 'leb_ipc_value'
    //   222: invokevirtual getSerializableExtra : (Ljava/lang/String;)Ljava/io/Serializable;
    //   225: areturn
    //   226: aload_1
    //   227: ldc 'leb_ipc_value'
    //   229: invokevirtual getParcelableExtra : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   232: areturn
    //   233: aload_1
    //   234: ldc 'leb_ipc_value'
    //   236: ldc2_w -1.0
    //   239: invokevirtual getDoubleExtra : (Ljava/lang/String;D)D
    //   242: invokestatic valueOf : (D)Ljava/lang/Double;
    //   245: areturn
    //   246: aload_1
    //   247: ldc 'leb_ipc_value'
    //   249: ldc -1.0
    //   251: invokevirtual getFloatExtra : (Ljava/lang/String;F)F
    //   254: invokestatic valueOf : (F)Ljava/lang/Float;
    //   257: areturn
    //   258: aload_1
    //   259: ldc 'leb_ipc_value'
    //   261: ldc2_w -1
    //   264: invokevirtual getLongExtra : (Ljava/lang/String;J)J
    //   267: invokestatic valueOf : (J)Ljava/lang/Long;
    //   270: areturn
    //   271: aload_1
    //   272: ldc 'leb_ipc_value'
    //   274: iconst_0
    //   275: invokevirtual getBooleanExtra : (Ljava/lang/String;Z)Z
    //   278: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   281: areturn
    //   282: aload_1
    //   283: ldc 'leb_ipc_value'
    //   285: iconst_m1
    //   286: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   289: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   292: areturn
    //   293: aload_1
    //   294: ldc 'leb_ipc_value'
    //   296: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   299: areturn
    //   300: new com/jeremyliao/liveeventbus/ipc/decode/DecodeException
    //   303: dup
    //   304: ldc 'Index Error'
    //   306: invokespecial <init> : (Ljava/lang/String;)V
    //   309: athrow
    //   310: astore_3
    //   311: goto -> 117
    // Exception table:
    //   from	to	target	type
    //   88	104	202	java/lang/Exception
    //   106	112	310	java/lang/ClassNotFoundException
    //   106	112	202	java/lang/Exception
    //   117	125	202	java/lang/Exception
    //   130	187	202	java/lang/Exception
    //   187	200	202	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\ipc\decode\ValueDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */