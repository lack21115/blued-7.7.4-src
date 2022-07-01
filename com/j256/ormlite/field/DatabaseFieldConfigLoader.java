package com.j256.ormlite.field;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;

public class DatabaseFieldConfigLoader {
  private static final String CONFIG_FILE_END_MARKER = "# --field-end--";
  
  private static final String CONFIG_FILE_START_MARKER = "# --field-start--";
  
  private static final DataPersister DEFAULT_DATA_PERSISTER = DatabaseFieldConfig.DEFAULT_DATA_TYPE.getDataPersister();
  
  private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
  
  private static final String FIELD_NAME_ALLOW_GENERATED_ID_INSERT = "allowGeneratedIdInsert";
  
  private static final String FIELD_NAME_CAN_BE_NULL = "canBeNull";
  
  private static final String FIELD_NAME_COLUMN_DEFINITION = "columnDefinition";
  
  private static final String FIELD_NAME_COLUMN_NAME = "columnName";
  
  private static final String FIELD_NAME_DATA_PERSISTER = "dataPersister";
  
  private static final String FIELD_NAME_DEFAULT_VALUE = "defaultValue";
  
  private static final String FIELD_NAME_FIELD_NAME = "fieldName";
  
  private static final String FIELD_NAME_FOREIGN = "foreign";
  
  private static final String FIELD_NAME_FOREIGN_AUTO_CREATE = "foreignAutoCreate";
  
  private static final String FIELD_NAME_FOREIGN_AUTO_REFRESH = "foreignAutoRefresh";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION = "foreignCollection";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME = "foreignCollectionColumnName";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION_EAGER = "foreignCollectionEager";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME = "foreignCollectionForeignFieldName";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME_OLD = "foreignCollectionForeignColumnName";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING = "foreignCollectionOrderAscending";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME = "foreignCollectionOrderColumnName";
  
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME_OLD = "foreignCollectionOrderColumn";
  
  private static final String FIELD_NAME_FOREIGN_COLUMN_NAME = "foreignColumnName";
  
  private static final String FIELD_NAME_FORMAT = "format";
  
  private static final String FIELD_NAME_GENERATED_ID = "generatedId";
  
  private static final String FIELD_NAME_GENERATED_ID_SEQUENCE = "generatedIdSequence";
  
  private static final String FIELD_NAME_ID = "id";
  
  private static final String FIELD_NAME_INDEX = "index";
  
  private static final String FIELD_NAME_INDEX_NAME = "indexName";
  
  private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = "foreignCollectionMaxEagerLevel";
  
  private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL_OLD = "maxEagerForeignCollectionLevel";
  
  private static final String FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL = "maxForeignAutoRefreshLevel";
  
  private static final String FIELD_NAME_PERSISTER_CLASS = "persisterClass";
  
  private static final String FIELD_NAME_READ_ONLY = "readOnly";
  
  private static final String FIELD_NAME_THROW_IF_NULL = "throwIfNull";
  
  private static final String FIELD_NAME_UNIQUE = "unique";
  
  private static final String FIELD_NAME_UNIQUE_COMBO = "uniqueCombo";
  
  private static final String FIELD_NAME_UNIQUE_INDEX = "uniqueIndex";
  
  private static final String FIELD_NAME_UNIQUE_INDEX_NAME = "uniqueIndexName";
  
  private static final String FIELD_NAME_UNKNOWN_ENUM_VALUE = "unknownEnumValue";
  
  private static final String FIELD_NAME_USE_GET_SET = "useGetSet";
  
  private static final String FIELD_NAME_VERSION = "version";
  
  private static final String FIELD_NAME_WIDTH = "width";
  
  public static DatabaseFieldConfig fromReader(BufferedReader paramBufferedReader) throws SQLException {
    DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
    boolean bool = false;
    try {
      while (true) {
        String str = paramBufferedReader.readLine();
        if (str == null || str.equals("# --field-end--"))
          return bool ? databaseFieldConfig : null; 
        if (str.length() == 0 || str.startsWith("#") || str.equals("# --field-start--"))
          continue; 
        String[] arrayOfString = str.split("=", -2);
        if (arrayOfString.length == 2) {
          readField(databaseFieldConfig, arrayOfString[0], arrayOfString[1]);
          bool = true;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DatabaseFieldConfig reading from stream cannot parse line: ");
        stringBuilder.append(str);
        throw new SQLException(stringBuilder.toString());
      } 
    } catch (IOException iOException) {
      throw SqlExceptionUtil.create("Could not read DatabaseFieldConfig from stream", iOException);
    } 
  }
  
  private static void readField(DatabaseFieldConfig paramDatabaseFieldConfig, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'fieldName'
    //   3: invokevirtual equals : (Ljava/lang/Object;)Z
    //   6: ifeq -> 15
    //   9: aload_0
    //   10: aload_2
    //   11: invokevirtual setFieldName : (Ljava/lang/String;)V
    //   14: return
    //   15: aload_1
    //   16: ldc 'columnName'
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifeq -> 30
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual setColumnName : (Ljava/lang/String;)V
    //   29: return
    //   30: aload_1
    //   31: ldc 'dataPersister'
    //   33: invokevirtual equals : (Ljava/lang/Object;)Z
    //   36: ifeq -> 51
    //   39: aload_0
    //   40: aload_2
    //   41: invokestatic valueOf : (Ljava/lang/String;)Lcom/j256/ormlite/field/DataType;
    //   44: invokevirtual getDataPersister : ()Lcom/j256/ormlite/field/DataPersister;
    //   47: invokevirtual setDataPersister : (Lcom/j256/ormlite/field/DataPersister;)V
    //   50: return
    //   51: aload_1
    //   52: ldc 'defaultValue'
    //   54: invokevirtual equals : (Ljava/lang/Object;)Z
    //   57: ifeq -> 66
    //   60: aload_0
    //   61: aload_2
    //   62: invokevirtual setDefaultValue : (Ljava/lang/String;)V
    //   65: return
    //   66: aload_1
    //   67: ldc 'width'
    //   69: invokevirtual equals : (Ljava/lang/Object;)Z
    //   72: ifeq -> 84
    //   75: aload_0
    //   76: aload_2
    //   77: invokestatic parseInt : (Ljava/lang/String;)I
    //   80: invokevirtual setWidth : (I)V
    //   83: return
    //   84: aload_1
    //   85: ldc 'canBeNull'
    //   87: invokevirtual equals : (Ljava/lang/Object;)Z
    //   90: ifeq -> 102
    //   93: aload_0
    //   94: aload_2
    //   95: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   98: invokevirtual setCanBeNull : (Z)V
    //   101: return
    //   102: aload_1
    //   103: ldc 'id'
    //   105: invokevirtual equals : (Ljava/lang/Object;)Z
    //   108: ifeq -> 120
    //   111: aload_0
    //   112: aload_2
    //   113: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   116: invokevirtual setId : (Z)V
    //   119: return
    //   120: aload_1
    //   121: ldc 'generatedId'
    //   123: invokevirtual equals : (Ljava/lang/Object;)Z
    //   126: ifeq -> 138
    //   129: aload_0
    //   130: aload_2
    //   131: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   134: invokevirtual setGeneratedId : (Z)V
    //   137: return
    //   138: aload_1
    //   139: ldc 'generatedIdSequence'
    //   141: invokevirtual equals : (Ljava/lang/Object;)Z
    //   144: ifeq -> 153
    //   147: aload_0
    //   148: aload_2
    //   149: invokevirtual setGeneratedIdSequence : (Ljava/lang/String;)V
    //   152: return
    //   153: aload_1
    //   154: ldc 'foreign'
    //   156: invokevirtual equals : (Ljava/lang/Object;)Z
    //   159: ifeq -> 171
    //   162: aload_0
    //   163: aload_2
    //   164: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   167: invokevirtual setForeign : (Z)V
    //   170: return
    //   171: aload_1
    //   172: ldc 'useGetSet'
    //   174: invokevirtual equals : (Ljava/lang/Object;)Z
    //   177: ifeq -> 189
    //   180: aload_0
    //   181: aload_2
    //   182: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   185: invokevirtual setUseGetSet : (Z)V
    //   188: return
    //   189: aload_1
    //   190: ldc 'unknownEnumValue'
    //   192: invokevirtual equals : (Ljava/lang/Object;)Z
    //   195: ifeq -> 437
    //   198: aload_2
    //   199: ldc '#'
    //   201: bipush #-2
    //   203: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   206: astore_1
    //   207: aload_1
    //   208: arraylength
    //   209: iconst_2
    //   210: if_icmpne -> 403
    //   213: iconst_0
    //   214: istore_3
    //   215: aload_1
    //   216: iconst_0
    //   217: aaload
    //   218: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   221: astore #6
    //   223: aload #6
    //   225: invokevirtual getEnumConstants : ()[Ljava/lang/Object;
    //   228: astore #6
    //   230: aload #6
    //   232: ifnull -> 335
    //   235: aload #6
    //   237: checkcast [Ljava/lang/Enum;
    //   240: checkcast [Ljava/lang/Enum;
    //   243: astore #6
    //   245: aload #6
    //   247: arraylength
    //   248: istore #5
    //   250: iconst_0
    //   251: istore #4
    //   253: iload_3
    //   254: iload #5
    //   256: if_icmpge -> 295
    //   259: aload #6
    //   261: iload_3
    //   262: aaload
    //   263: astore #7
    //   265: aload #7
    //   267: invokevirtual name : ()Ljava/lang/String;
    //   270: aload_1
    //   271: iconst_1
    //   272: aaload
    //   273: invokevirtual equals : (Ljava/lang/Object;)Z
    //   276: ifeq -> 288
    //   279: aload_0
    //   280: aload #7
    //   282: invokevirtual setUnknownEnumValue : (Ljava/lang/Enum;)V
    //   285: iconst_1
    //   286: istore #4
    //   288: iload_3
    //   289: iconst_1
    //   290: iadd
    //   291: istore_3
    //   292: goto -> 253
    //   295: iload #4
    //   297: ifeq -> 301
    //   300: return
    //   301: new java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial <init> : ()V
    //   308: astore_0
    //   309: aload_0
    //   310: ldc_w 'Invalid enum value name for unknownEnumvalue: '
    //   313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_0
    //   318: aload_2
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: new java/lang/IllegalArgumentException
    //   326: dup
    //   327: aload_0
    //   328: invokevirtual toString : ()Ljava/lang/String;
    //   331: invokespecial <init> : (Ljava/lang/String;)V
    //   334: athrow
    //   335: new java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial <init> : ()V
    //   342: astore_0
    //   343: aload_0
    //   344: ldc_w 'Invalid class is not an Enum for unknownEnumValue: '
    //   347: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_0
    //   352: aload_2
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: new java/lang/IllegalArgumentException
    //   360: dup
    //   361: aload_0
    //   362: invokevirtual toString : ()Ljava/lang/String;
    //   365: invokespecial <init> : (Ljava/lang/String;)V
    //   368: athrow
    //   369: new java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial <init> : ()V
    //   376: astore_0
    //   377: aload_0
    //   378: ldc_w 'Unknown class specified for unknownEnumValue: '
    //   381: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_0
    //   386: aload_2
    //   387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: new java/lang/IllegalArgumentException
    //   394: dup
    //   395: aload_0
    //   396: invokevirtual toString : ()Ljava/lang/String;
    //   399: invokespecial <init> : (Ljava/lang/String;)V
    //   402: athrow
    //   403: new java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial <init> : ()V
    //   410: astore_0
    //   411: aload_0
    //   412: ldc_w 'Invalid value for unknownEnumValue which should be in class#name format: '
    //   415: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_0
    //   420: aload_2
    //   421: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: new java/lang/IllegalArgumentException
    //   428: dup
    //   429: aload_0
    //   430: invokevirtual toString : ()Ljava/lang/String;
    //   433: invokespecial <init> : (Ljava/lang/String;)V
    //   436: athrow
    //   437: aload_1
    //   438: ldc 'throwIfNull'
    //   440: invokevirtual equals : (Ljava/lang/Object;)Z
    //   443: ifeq -> 455
    //   446: aload_0
    //   447: aload_2
    //   448: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   451: invokevirtual setThrowIfNull : (Z)V
    //   454: return
    //   455: aload_1
    //   456: ldc 'format'
    //   458: invokevirtual equals : (Ljava/lang/Object;)Z
    //   461: ifeq -> 470
    //   464: aload_0
    //   465: aload_2
    //   466: invokevirtual setFormat : (Ljava/lang/String;)V
    //   469: return
    //   470: aload_1
    //   471: ldc 'unique'
    //   473: invokevirtual equals : (Ljava/lang/Object;)Z
    //   476: ifeq -> 488
    //   479: aload_0
    //   480: aload_2
    //   481: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   484: invokevirtual setUnique : (Z)V
    //   487: return
    //   488: aload_1
    //   489: ldc 'uniqueCombo'
    //   491: invokevirtual equals : (Ljava/lang/Object;)Z
    //   494: ifeq -> 506
    //   497: aload_0
    //   498: aload_2
    //   499: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   502: invokevirtual setUniqueCombo : (Z)V
    //   505: return
    //   506: aload_1
    //   507: ldc 'index'
    //   509: invokevirtual equals : (Ljava/lang/Object;)Z
    //   512: ifeq -> 524
    //   515: aload_0
    //   516: aload_2
    //   517: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   520: invokevirtual setIndex : (Z)V
    //   523: return
    //   524: aload_1
    //   525: ldc 'indexName'
    //   527: invokevirtual equals : (Ljava/lang/Object;)Z
    //   530: ifeq -> 544
    //   533: aload_0
    //   534: iconst_1
    //   535: invokevirtual setIndex : (Z)V
    //   538: aload_0
    //   539: aload_2
    //   540: invokevirtual setIndexName : (Ljava/lang/String;)V
    //   543: return
    //   544: aload_1
    //   545: ldc 'uniqueIndex'
    //   547: invokevirtual equals : (Ljava/lang/Object;)Z
    //   550: ifeq -> 562
    //   553: aload_0
    //   554: aload_2
    //   555: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   558: invokevirtual setUniqueIndex : (Z)V
    //   561: return
    //   562: aload_1
    //   563: ldc 'uniqueIndexName'
    //   565: invokevirtual equals : (Ljava/lang/Object;)Z
    //   568: ifeq -> 582
    //   571: aload_0
    //   572: iconst_1
    //   573: invokevirtual setUniqueIndex : (Z)V
    //   576: aload_0
    //   577: aload_2
    //   578: invokevirtual setUniqueIndexName : (Ljava/lang/String;)V
    //   581: return
    //   582: aload_1
    //   583: ldc 'foreignAutoRefresh'
    //   585: invokevirtual equals : (Ljava/lang/Object;)Z
    //   588: ifeq -> 600
    //   591: aload_0
    //   592: aload_2
    //   593: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   596: invokevirtual setForeignAutoRefresh : (Z)V
    //   599: return
    //   600: aload_1
    //   601: ldc 'maxForeignAutoRefreshLevel'
    //   603: invokevirtual equals : (Ljava/lang/Object;)Z
    //   606: ifeq -> 618
    //   609: aload_0
    //   610: aload_2
    //   611: invokestatic parseInt : (Ljava/lang/String;)I
    //   614: invokevirtual setMaxForeignAutoRefreshLevel : (I)V
    //   617: return
    //   618: aload_1
    //   619: ldc 'persisterClass'
    //   621: invokevirtual equals : (Ljava/lang/Object;)Z
    //   624: ifeq -> 670
    //   627: aload_0
    //   628: aload_2
    //   629: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   632: invokevirtual setPersisterClass : (Ljava/lang/Class;)V
    //   635: return
    //   636: new java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial <init> : ()V
    //   643: astore_0
    //   644: aload_0
    //   645: ldc_w 'Could not find persisterClass: '
    //   648: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload_0
    //   653: aload_2
    //   654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: new java/lang/IllegalArgumentException
    //   661: dup
    //   662: aload_0
    //   663: invokevirtual toString : ()Ljava/lang/String;
    //   666: invokespecial <init> : (Ljava/lang/String;)V
    //   669: athrow
    //   670: aload_1
    //   671: ldc 'allowGeneratedIdInsert'
    //   673: invokevirtual equals : (Ljava/lang/Object;)Z
    //   676: ifeq -> 688
    //   679: aload_0
    //   680: aload_2
    //   681: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   684: invokevirtual setAllowGeneratedIdInsert : (Z)V
    //   687: return
    //   688: aload_1
    //   689: ldc 'columnDefinition'
    //   691: invokevirtual equals : (Ljava/lang/Object;)Z
    //   694: ifeq -> 703
    //   697: aload_0
    //   698: aload_2
    //   699: invokevirtual setColumnDefinition : (Ljava/lang/String;)V
    //   702: return
    //   703: aload_1
    //   704: ldc 'foreignAutoCreate'
    //   706: invokevirtual equals : (Ljava/lang/Object;)Z
    //   709: ifeq -> 721
    //   712: aload_0
    //   713: aload_2
    //   714: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   717: invokevirtual setForeignAutoCreate : (Z)V
    //   720: return
    //   721: aload_1
    //   722: ldc 'version'
    //   724: invokevirtual equals : (Ljava/lang/Object;)Z
    //   727: ifeq -> 739
    //   730: aload_0
    //   731: aload_2
    //   732: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   735: invokevirtual setVersion : (Z)V
    //   738: return
    //   739: aload_1
    //   740: ldc 'foreignColumnName'
    //   742: invokevirtual equals : (Ljava/lang/Object;)Z
    //   745: ifeq -> 754
    //   748: aload_0
    //   749: aload_2
    //   750: invokevirtual setForeignColumnName : (Ljava/lang/String;)V
    //   753: return
    //   754: aload_1
    //   755: ldc 'readOnly'
    //   757: invokevirtual equals : (Ljava/lang/Object;)Z
    //   760: ifeq -> 772
    //   763: aload_0
    //   764: aload_2
    //   765: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   768: invokevirtual setReadOnly : (Z)V
    //   771: return
    //   772: aload_1
    //   773: ldc 'foreignCollection'
    //   775: invokevirtual equals : (Ljava/lang/Object;)Z
    //   778: ifeq -> 790
    //   781: aload_0
    //   782: aload_2
    //   783: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   786: invokevirtual setForeignCollection : (Z)V
    //   789: return
    //   790: aload_1
    //   791: ldc 'foreignCollectionEager'
    //   793: invokevirtual equals : (Ljava/lang/Object;)Z
    //   796: ifeq -> 808
    //   799: aload_0
    //   800: aload_2
    //   801: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   804: invokevirtual setForeignCollectionEager : (Z)V
    //   807: return
    //   808: aload_1
    //   809: ldc 'maxEagerForeignCollectionLevel'
    //   811: invokevirtual equals : (Ljava/lang/Object;)Z
    //   814: ifeq -> 826
    //   817: aload_0
    //   818: aload_2
    //   819: invokestatic parseInt : (Ljava/lang/String;)I
    //   822: invokevirtual setForeignCollectionMaxEagerLevel : (I)V
    //   825: return
    //   826: aload_1
    //   827: ldc 'foreignCollectionMaxEagerLevel'
    //   829: invokevirtual equals : (Ljava/lang/Object;)Z
    //   832: ifeq -> 844
    //   835: aload_0
    //   836: aload_2
    //   837: invokestatic parseInt : (Ljava/lang/String;)I
    //   840: invokevirtual setForeignCollectionMaxEagerLevel : (I)V
    //   843: return
    //   844: aload_1
    //   845: ldc 'foreignCollectionColumnName'
    //   847: invokevirtual equals : (Ljava/lang/Object;)Z
    //   850: ifeq -> 859
    //   853: aload_0
    //   854: aload_2
    //   855: invokevirtual setForeignCollectionColumnName : (Ljava/lang/String;)V
    //   858: return
    //   859: aload_1
    //   860: ldc 'foreignCollectionOrderColumn'
    //   862: invokevirtual equals : (Ljava/lang/Object;)Z
    //   865: ifeq -> 874
    //   868: aload_0
    //   869: aload_2
    //   870: invokevirtual setForeignCollectionOrderColumnName : (Ljava/lang/String;)V
    //   873: return
    //   874: aload_1
    //   875: ldc 'foreignCollectionOrderColumnName'
    //   877: invokevirtual equals : (Ljava/lang/Object;)Z
    //   880: ifeq -> 889
    //   883: aload_0
    //   884: aload_2
    //   885: invokevirtual setForeignCollectionOrderColumnName : (Ljava/lang/String;)V
    //   888: return
    //   889: aload_1
    //   890: ldc 'foreignCollectionOrderAscending'
    //   892: invokevirtual equals : (Ljava/lang/Object;)Z
    //   895: ifeq -> 907
    //   898: aload_0
    //   899: aload_2
    //   900: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   903: invokevirtual setForeignCollectionOrderAscending : (Z)V
    //   906: return
    //   907: aload_1
    //   908: ldc 'foreignCollectionForeignColumnName'
    //   910: invokevirtual equals : (Ljava/lang/Object;)Z
    //   913: ifeq -> 922
    //   916: aload_0
    //   917: aload_2
    //   918: invokevirtual setForeignCollectionForeignFieldName : (Ljava/lang/String;)V
    //   921: return
    //   922: aload_1
    //   923: ldc 'foreignCollectionForeignFieldName'
    //   925: invokevirtual equals : (Ljava/lang/Object;)Z
    //   928: ifeq -> 936
    //   931: aload_0
    //   932: aload_2
    //   933: invokevirtual setForeignCollectionForeignFieldName : (Ljava/lang/String;)V
    //   936: return
    //   937: astore_0
    //   938: goto -> 369
    //   941: astore_0
    //   942: goto -> 636
    // Exception table:
    //   from	to	target	type
    //   215	223	937	java/lang/ClassNotFoundException
    //   627	635	941	java/lang/ClassNotFoundException
  }
  
  public static void write(BufferedWriter paramBufferedWriter, DatabaseFieldConfig paramDatabaseFieldConfig, String paramString) throws SQLException {
    try {
      writeConfig(paramBufferedWriter, paramDatabaseFieldConfig, paramString);
      return;
    } catch (IOException iOException) {
      throw SqlExceptionUtil.create("Could not write config to writer", iOException);
    } 
  }
  
  public static void writeConfig(BufferedWriter paramBufferedWriter, DatabaseFieldConfig paramDatabaseFieldConfig, String paramString) throws IOException {
    StringBuilder stringBuilder;
    paramBufferedWriter.append("# --field-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseFieldConfig.getFieldName() != null) {
      paramBufferedWriter.append("fieldName").append('=').append(paramDatabaseFieldConfig.getFieldName());
      paramBufferedWriter.newLine();
    } 
    if (paramDatabaseFieldConfig.getColumnName() != null) {
      paramBufferedWriter.append("columnName").append('=').append(paramDatabaseFieldConfig.getColumnName());
      paramBufferedWriter.newLine();
    } 
    if (paramDatabaseFieldConfig.getDataPersister() != DEFAULT_DATA_PERSISTER) {
      boolean bool1;
      DataType[] arrayOfDataType = DataType.values();
      int j = arrayOfDataType.length;
      boolean bool2 = false;
      int i = 0;
      while (true) {
        bool1 = bool2;
        if (i < j) {
          DataType dataType = arrayOfDataType[i];
          if (dataType.getDataPersister() == paramDatabaseFieldConfig.getDataPersister()) {
            paramBufferedWriter.append("dataPersister").append('=').append(dataType.name());
            paramBufferedWriter.newLine();
            bool1 = true;
            break;
          } 
          i++;
          continue;
        } 
        break;
      } 
      if (!bool1) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown data persister field: ");
        stringBuilder.append(paramDatabaseFieldConfig.getDataPersister());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
    } 
    if (paramDatabaseFieldConfig.getDefaultValue() != null) {
      stringBuilder.append("defaultValue").append('=').append(paramDatabaseFieldConfig.getDefaultValue());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getWidth() != 0) {
      stringBuilder.append("width").append('=').append(Integer.toString(paramDatabaseFieldConfig.getWidth()));
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isCanBeNull() != true) {
      stringBuilder.append("canBeNull").append('=').append(Boolean.toString(paramDatabaseFieldConfig.isCanBeNull()));
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isId()) {
      stringBuilder.append("id").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isGeneratedId()) {
      stringBuilder.append("generatedId").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getGeneratedIdSequence() != null) {
      stringBuilder.append("generatedIdSequence").append('=').append(paramDatabaseFieldConfig.getGeneratedIdSequence());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isForeign()) {
      stringBuilder.append("foreign").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isUseGetSet()) {
      stringBuilder.append("useGetSet").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getUnknownEnumValue() != null) {
      stringBuilder.append("unknownEnumValue").append('=').append(paramDatabaseFieldConfig.getUnknownEnumValue().getClass().getName()).append("#").append(paramDatabaseFieldConfig.getUnknownEnumValue().name());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isThrowIfNull()) {
      stringBuilder.append("throwIfNull").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getFormat() != null) {
      stringBuilder.append("format").append('=').append(paramDatabaseFieldConfig.getFormat());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isUnique()) {
      stringBuilder.append("unique").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isUniqueCombo()) {
      stringBuilder.append("uniqueCombo").append('=').append("true");
      stringBuilder.newLine();
    } 
    String str = paramDatabaseFieldConfig.getIndexName(paramString);
    if (str != null) {
      stringBuilder.append("indexName").append('=').append(str);
      stringBuilder.newLine();
    } 
    paramString = paramDatabaseFieldConfig.getUniqueIndexName(paramString);
    if (paramString != null) {
      stringBuilder.append("uniqueIndexName").append('=').append(paramString);
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isForeignAutoRefresh()) {
      stringBuilder.append("foreignAutoRefresh").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel() != -1) {
      stringBuilder.append("maxForeignAutoRefreshLevel").append('=').append(Integer.toString(paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel()));
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getPersisterClass() != DatabaseFieldConfig.DEFAULT_PERSISTER_CLASS) {
      stringBuilder.append("persisterClass").append('=').append(paramDatabaseFieldConfig.getPersisterClass().getName());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isAllowGeneratedIdInsert()) {
      stringBuilder.append("allowGeneratedIdInsert").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getColumnDefinition() != null) {
      stringBuilder.append("columnDefinition").append('=').append(paramDatabaseFieldConfig.getColumnDefinition());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isForeignAutoCreate()) {
      stringBuilder.append("foreignAutoCreate").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isVersion()) {
      stringBuilder.append("version").append('=').append("true");
      stringBuilder.newLine();
    } 
    paramString = paramDatabaseFieldConfig.getForeignColumnName();
    if (paramString != null) {
      stringBuilder.append("foreignColumnName").append('=').append(paramString);
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isReadOnly()) {
      stringBuilder.append("readOnly").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isForeignCollection()) {
      stringBuilder.append("foreignCollection").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isForeignCollectionEager()) {
      stringBuilder.append("foreignCollectionEager").append('=').append("true");
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getForeignCollectionMaxEagerLevel() != 1) {
      stringBuilder.append("foreignCollectionMaxEagerLevel").append('=').append(Integer.toString(paramDatabaseFieldConfig.getForeignCollectionMaxEagerLevel()));
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getForeignCollectionColumnName() != null) {
      stringBuilder.append("foreignCollectionColumnName").append('=').append(paramDatabaseFieldConfig.getForeignCollectionColumnName());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getForeignCollectionOrderColumnName() != null) {
      stringBuilder.append("foreignCollectionOrderColumnName").append('=').append(paramDatabaseFieldConfig.getForeignCollectionOrderColumnName());
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.isForeignCollectionOrderAscending() != true) {
      stringBuilder.append("foreignCollectionOrderAscending").append('=').append(Boolean.toString(paramDatabaseFieldConfig.isForeignCollectionOrderAscending()));
      stringBuilder.newLine();
    } 
    if (paramDatabaseFieldConfig.getForeignCollectionForeignFieldName() != null) {
      stringBuilder.append("foreignCollectionForeignFieldName").append('=').append(paramDatabaseFieldConfig.getForeignCollectionForeignFieldName());
      stringBuilder.newLine();
    } 
    stringBuilder.append("# --field-end--");
    stringBuilder.newLine();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\DatabaseFieldConfigLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */