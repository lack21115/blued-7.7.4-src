package com.tencent.tbs.sdk.extension.partner.incrupdate;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class b {
  private static b a;
  
  private static Context b;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  static b a(Context paramContext) {
    b = paramContext.getApplicationContext();
    if (a == null)
      a = new b(); 
    return a;
  }
  
  private File c(boolean paramBoolean) {
    File file1;
    if (paramBoolean) {
      file1 = new File(new File(new File(TbsSDKExtension.getTbsFolderDir(b), "share"), "miniqb"), "miniqbinstall.txt");
    } else {
      file1 = new File(new File(TbsSDKExtension.getTbsFolderDir(b), "core_private"), "tbscoreinstall.txt");
    } 
    File file2 = file1;
    if (!file1.exists())
      try {
        file1.createNewFile();
        return file1;
      } catch (IOException iOException) {
        iOException.printStackTrace();
        file2 = null;
      }  
    return file2;
  }
  
  private Properties d(boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore #4
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: iload_1
    //   12: invokespecial c : (Z)Ljava/io/File;
    //   15: astore #6
    //   17: new java/util/Properties
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #7
    //   26: aload #6
    //   28: ifnull -> 97
    //   31: new java/io/FileInputStream
    //   34: dup
    //   35: aload #6
    //   37: invokespecial <init> : (Ljava/io/File;)V
    //   40: astore_2
    //   41: aload_3
    //   42: astore #4
    //   44: aload_2
    //   45: astore #6
    //   47: new java/io/BufferedInputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial <init> : (Ljava/io/InputStream;)V
    //   55: astore_3
    //   56: aload #7
    //   58: aload_3
    //   59: invokevirtual load : (Ljava/io/InputStream;)V
    //   62: goto -> 99
    //   65: astore #5
    //   67: aload_3
    //   68: astore #4
    //   70: aload #5
    //   72: astore_3
    //   73: goto -> 199
    //   76: astore #4
    //   78: aload_3
    //   79: astore #5
    //   81: aload #4
    //   83: astore_3
    //   84: goto -> 147
    //   87: astore_3
    //   88: goto -> 147
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_2
    //   94: goto -> 147
    //   97: aconst_null
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull -> 115
    //   103: aload_3
    //   104: invokevirtual close : ()V
    //   107: goto -> 115
    //   110: astore_3
    //   111: aload_3
    //   112: invokevirtual printStackTrace : ()V
    //   115: aload_2
    //   116: ifnull -> 131
    //   119: aload_2
    //   120: invokevirtual close : ()V
    //   123: aload #7
    //   125: areturn
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual printStackTrace : ()V
    //   131: aload #7
    //   133: areturn
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_2
    //   137: goto -> 199
    //   140: astore_3
    //   141: aconst_null
    //   142: astore #7
    //   144: aload #7
    //   146: astore_2
    //   147: aload #5
    //   149: astore #4
    //   151: aload_2
    //   152: astore #6
    //   154: aload_3
    //   155: invokevirtual printStackTrace : ()V
    //   158: aload #5
    //   160: ifnull -> 176
    //   163: aload #5
    //   165: invokevirtual close : ()V
    //   168: goto -> 176
    //   171: astore_3
    //   172: aload_3
    //   173: invokevirtual printStackTrace : ()V
    //   176: aload_2
    //   177: ifnull -> 192
    //   180: aload_2
    //   181: invokevirtual close : ()V
    //   184: aload #7
    //   186: areturn
    //   187: astore_2
    //   188: aload_2
    //   189: invokevirtual printStackTrace : ()V
    //   192: aload #7
    //   194: areturn
    //   195: astore_3
    //   196: aload #6
    //   198: astore_2
    //   199: aload #4
    //   201: ifnull -> 219
    //   204: aload #4
    //   206: invokevirtual close : ()V
    //   209: goto -> 219
    //   212: astore #4
    //   214: aload #4
    //   216: invokevirtual printStackTrace : ()V
    //   219: aload_2
    //   220: ifnull -> 235
    //   223: aload_2
    //   224: invokevirtual close : ()V
    //   227: goto -> 235
    //   230: astore_2
    //   231: aload_2
    //   232: invokevirtual printStackTrace : ()V
    //   235: aload_3
    //   236: athrow
    // Exception table:
    //   from	to	target	type
    //   10	26	140	java/lang/Exception
    //   10	26	134	finally
    //   31	41	91	java/lang/Exception
    //   31	41	134	finally
    //   47	56	87	java/lang/Exception
    //   47	56	195	finally
    //   56	62	76	java/lang/Exception
    //   56	62	65	finally
    //   103	107	110	java/io/IOException
    //   119	123	126	java/io/IOException
    //   154	158	195	finally
    //   163	168	171	java/io/IOException
    //   180	184	187	java/io/IOException
    //   204	209	212	java/io/IOException
    //   223	227	230	java/io/IOException
  }
  
  int a(boolean paramBoolean) {
    Properties properties = d(paramBoolean);
    return (properties != null && properties.getProperty("patch_retry_num") != null) ? Integer.parseInt(properties.getProperty("patch_retry_num")) : 0;
  }
  
  void a(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #4
    //   6: aconst_null
    //   7: astore #8
    //   9: aload_0
    //   10: iload_2
    //   11: invokespecial d : (Z)Ljava/util/Properties;
    //   14: astore #7
    //   16: aload #7
    //   18: ifnull -> 108
    //   21: aload #7
    //   23: ldc 'patch_retry_num'
    //   25: iload_1
    //   26: invokestatic valueOf : (I)Ljava/lang/String;
    //   29: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   32: pop
    //   33: aload_0
    //   34: iload_2
    //   35: invokespecial c : (Z)Ljava/io/File;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull -> 108
    //   43: new java/io/FileOutputStream
    //   46: dup
    //   47: aload_3
    //   48: invokespecial <init> : (Ljava/io/File;)V
    //   51: astore_3
    //   52: aload #5
    //   54: astore #4
    //   56: aload_3
    //   57: astore #5
    //   59: new java/io/BufferedOutputStream
    //   62: dup
    //   63: aload_3
    //   64: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   67: astore #6
    //   69: aload #7
    //   71: aload #6
    //   73: ldc 'update patch retry num!'
    //   75: invokevirtual store : (Ljava/io/OutputStream;Ljava/lang/String;)V
    //   78: aload #6
    //   80: astore #4
    //   82: goto -> 114
    //   85: astore #5
    //   87: aload #6
    //   89: astore #4
    //   91: goto -> 214
    //   94: astore #7
    //   96: goto -> 164
    //   99: astore #7
    //   101: aload #8
    //   103: astore #6
    //   105: goto -> 164
    //   108: aconst_null
    //   109: astore #4
    //   111: aload #4
    //   113: astore_3
    //   114: aload #4
    //   116: ifnull -> 134
    //   119: aload #4
    //   121: invokevirtual close : ()V
    //   124: goto -> 134
    //   127: astore #4
    //   129: aload #4
    //   131: invokevirtual printStackTrace : ()V
    //   134: aload_3
    //   135: ifnull -> 204
    //   138: aload_3
    //   139: invokevirtual close : ()V
    //   142: return
    //   143: astore_3
    //   144: aload_3
    //   145: invokevirtual printStackTrace : ()V
    //   148: return
    //   149: astore #5
    //   151: aconst_null
    //   152: astore_3
    //   153: goto -> 214
    //   156: astore #7
    //   158: aconst_null
    //   159: astore_3
    //   160: aload #8
    //   162: astore #6
    //   164: aload #6
    //   166: astore #4
    //   168: aload_3
    //   169: astore #5
    //   171: aload #7
    //   173: invokevirtual printStackTrace : ()V
    //   176: aload #6
    //   178: ifnull -> 196
    //   181: aload #6
    //   183: invokevirtual close : ()V
    //   186: goto -> 196
    //   189: astore #4
    //   191: aload #4
    //   193: invokevirtual printStackTrace : ()V
    //   196: aload_3
    //   197: ifnull -> 204
    //   200: aload_3
    //   201: invokevirtual close : ()V
    //   204: return
    //   205: astore #6
    //   207: aload #5
    //   209: astore_3
    //   210: aload #6
    //   212: astore #5
    //   214: aload #4
    //   216: ifnull -> 234
    //   219: aload #4
    //   221: invokevirtual close : ()V
    //   224: goto -> 234
    //   227: astore #4
    //   229: aload #4
    //   231: invokevirtual printStackTrace : ()V
    //   234: aload_3
    //   235: ifnull -> 250
    //   238: aload_3
    //   239: invokevirtual close : ()V
    //   242: goto -> 250
    //   245: astore_3
    //   246: aload_3
    //   247: invokevirtual printStackTrace : ()V
    //   250: aload #5
    //   252: athrow
    // Exception table:
    //   from	to	target	type
    //   9	16	156	java/lang/Exception
    //   9	16	149	finally
    //   21	39	156	java/lang/Exception
    //   21	39	149	finally
    //   43	52	156	java/lang/Exception
    //   43	52	149	finally
    //   59	69	99	java/lang/Exception
    //   59	69	205	finally
    //   69	78	94	java/lang/Exception
    //   69	78	85	finally
    //   119	124	127	java/io/IOException
    //   138	142	143	java/io/IOException
    //   171	176	205	finally
    //   181	186	189	java/io/IOException
    //   200	204	143	java/io/IOException
    //   219	224	227	java/io/IOException
    //   238	242	245	java/io/IOException
  }
  
  void a(Bundle paramBundle, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore #7
    //   8: aload_0
    //   9: iload_2
    //   10: invokespecial d : (Z)Ljava/util/Properties;
    //   13: astore #6
    //   15: aload #6
    //   17: ifnull -> 168
    //   20: aload #6
    //   22: ldc 'patch_old_core_ver'
    //   24: aload_1
    //   25: ldc 'old_core_ver'
    //   27: invokevirtual getInt : (Ljava/lang/String;)I
    //   30: invokestatic valueOf : (I)Ljava/lang/String;
    //   33: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   36: pop
    //   37: aload #6
    //   39: ldc 'patch_new_core_ver'
    //   41: aload_1
    //   42: ldc 'new_core_ver'
    //   44: invokevirtual getInt : (Ljava/lang/String;)I
    //   47: invokestatic valueOf : (I)Ljava/lang/String;
    //   50: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   53: pop
    //   54: aload #6
    //   56: ldc 'patch_old_apk_path'
    //   58: aload_1
    //   59: ldc 'old_apk_location'
    //   61: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   67: pop
    //   68: aload #6
    //   70: ldc 'patch_new_apk_path'
    //   72: aload_1
    //   73: ldc 'new_apk_location'
    //   75: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   78: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   81: pop
    //   82: aload #6
    //   84: ldc 'patch_diff_file_path'
    //   86: aload_1
    //   87: ldc 'diff_file_location'
    //   89: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   95: pop
    //   96: aload_0
    //   97: iload_2
    //   98: invokespecial c : (Z)Ljava/io/File;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull -> 168
    //   106: new java/io/FileOutputStream
    //   109: dup
    //   110: aload_1
    //   111: invokespecial <init> : (Ljava/io/File;)V
    //   114: astore_1
    //   115: aload #4
    //   117: astore_3
    //   118: aload_1
    //   119: astore #4
    //   121: new java/io/BufferedOutputStream
    //   124: dup
    //   125: aload_1
    //   126: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   129: astore #5
    //   131: aload #6
    //   133: aload #5
    //   135: ldc 'save patch bundle!'
    //   137: invokevirtual store : (Ljava/io/OutputStream;Ljava/lang/String;)V
    //   140: aload #5
    //   142: astore_3
    //   143: goto -> 172
    //   146: astore #4
    //   148: aload #5
    //   150: astore_3
    //   151: goto -> 265
    //   154: astore #6
    //   156: goto -> 218
    //   159: astore #6
    //   161: aload #7
    //   163: astore #5
    //   165: goto -> 218
    //   168: aconst_null
    //   169: astore_3
    //   170: aload_3
    //   171: astore_1
    //   172: aload_3
    //   173: ifnull -> 188
    //   176: aload_3
    //   177: invokevirtual close : ()V
    //   180: goto -> 188
    //   183: astore_3
    //   184: aload_3
    //   185: invokevirtual printStackTrace : ()V
    //   188: aload_1
    //   189: ifnull -> 255
    //   192: aload_1
    //   193: invokevirtual close : ()V
    //   196: return
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual printStackTrace : ()V
    //   202: return
    //   203: astore #4
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -> 265
    //   210: astore #6
    //   212: aconst_null
    //   213: astore_1
    //   214: aload #7
    //   216: astore #5
    //   218: aload #5
    //   220: astore_3
    //   221: aload_1
    //   222: astore #4
    //   224: aload #6
    //   226: invokevirtual printStackTrace : ()V
    //   229: aload #5
    //   231: ifnull -> 247
    //   234: aload #5
    //   236: invokevirtual close : ()V
    //   239: goto -> 247
    //   242: astore_3
    //   243: aload_3
    //   244: invokevirtual printStackTrace : ()V
    //   247: aload_1
    //   248: ifnull -> 255
    //   251: aload_1
    //   252: invokevirtual close : ()V
    //   255: return
    //   256: astore #5
    //   258: aload #4
    //   260: astore_1
    //   261: aload #5
    //   263: astore #4
    //   265: aload_3
    //   266: ifnull -> 281
    //   269: aload_3
    //   270: invokevirtual close : ()V
    //   273: goto -> 281
    //   276: astore_3
    //   277: aload_3
    //   278: invokevirtual printStackTrace : ()V
    //   281: aload_1
    //   282: ifnull -> 297
    //   285: aload_1
    //   286: invokevirtual close : ()V
    //   289: goto -> 297
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual printStackTrace : ()V
    //   297: aload #4
    //   299: athrow
    // Exception table:
    //   from	to	target	type
    //   8	15	210	java/lang/Exception
    //   8	15	203	finally
    //   20	102	210	java/lang/Exception
    //   20	102	203	finally
    //   106	115	210	java/lang/Exception
    //   106	115	203	finally
    //   121	131	159	java/lang/Exception
    //   121	131	256	finally
    //   131	140	154	java/lang/Exception
    //   131	140	146	finally
    //   176	180	183	java/io/IOException
    //   192	196	197	java/io/IOException
    //   224	229	256	finally
    //   234	239	242	java/io/IOException
    //   251	255	197	java/io/IOException
    //   269	273	276	java/io/IOException
    //   285	289	292	java/io/IOException
  }
  
  Bundle b(boolean paramBoolean) {
    Properties properties = d(paramBoolean);
    Bundle bundle = new Bundle();
    if (properties != null) {
      bundle.putString("diff_file_location", properties.getProperty("patch_diff_file_path"));
      bundle.putString("old_core_ver", properties.getProperty("patch_old_core_ver"));
      bundle.putString("new_core_ver", properties.getProperty("patch_new_core_ver"));
      bundle.putString("old_apk_location", properties.getProperty("patch_old_apk_path"));
      bundle.putString("new_apk_location", properties.getProperty("patch_new_apk_path"));
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */