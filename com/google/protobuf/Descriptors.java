package com.google.protobuf;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

public final class Descriptors {
  private static final Logger logger = Logger.getLogger(Descriptors.class.getName());
  
  private static String computeFullName(FileDescriptor paramFileDescriptor, Descriptor paramDescriptor, String paramString) {
    StringBuilder stringBuilder;
    if (paramDescriptor != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramDescriptor.getFullName());
      stringBuilder.append('.');
      stringBuilder.append(paramString);
      return stringBuilder.toString();
    } 
    String str = stringBuilder.getPackage();
    if (!str.isEmpty()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append('.');
      stringBuilder1.append(paramString);
      return stringBuilder1.toString();
    } 
    return paramString;
  }
  
  public static final class Descriptor extends GenericDescriptor {
    private final Descriptor containingType;
    
    private final Descriptors.EnumDescriptor[] enumTypes;
    
    private final Descriptors.FieldDescriptor[] extensions;
    
    private final Descriptors.FieldDescriptor[] fields;
    
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final int index;
    
    private final Descriptor[] nestedTypes;
    
    private final Descriptors.OneofDescriptor[] oneofs;
    
    private DescriptorProtos.DescriptorProto proto;
    
    private final int realOneofCount;
    
    private Descriptor(DescriptorProtos.DescriptorProto param1DescriptorProto, Descriptors.FileDescriptor param1FileDescriptor, Descriptor param1Descriptor, int param1Int) throws Descriptors.DescriptorValidationException {
      this.index = param1Int;
      this.proto = param1DescriptorProto;
      this.fullName = Descriptors.computeFullName(param1FileDescriptor, param1Descriptor, param1DescriptorProto.getName());
      this.file = param1FileDescriptor;
      this.containingType = param1Descriptor;
      this.oneofs = new Descriptors.OneofDescriptor[param1DescriptorProto.getOneofDeclCount()];
      int i = 0;
      for (param1Int = 0; param1Int < param1DescriptorProto.getOneofDeclCount(); param1Int++)
        this.oneofs[param1Int] = new Descriptors.OneofDescriptor(param1DescriptorProto.getOneofDecl(param1Int), param1FileDescriptor, this, param1Int); 
      this.nestedTypes = new Descriptor[param1DescriptorProto.getNestedTypeCount()];
      for (param1Int = 0; param1Int < param1DescriptorProto.getNestedTypeCount(); param1Int++)
        this.nestedTypes[param1Int] = new Descriptor(param1DescriptorProto.getNestedType(param1Int), param1FileDescriptor, this, param1Int); 
      this.enumTypes = new Descriptors.EnumDescriptor[param1DescriptorProto.getEnumTypeCount()];
      for (param1Int = 0; param1Int < param1DescriptorProto.getEnumTypeCount(); param1Int++)
        this.enumTypes[param1Int] = new Descriptors.EnumDescriptor(param1DescriptorProto.getEnumType(param1Int), param1FileDescriptor, this, param1Int); 
      this.fields = new Descriptors.FieldDescriptor[param1DescriptorProto.getFieldCount()];
      for (param1Int = 0; param1Int < param1DescriptorProto.getFieldCount(); param1Int++)
        this.fields[param1Int] = new Descriptors.FieldDescriptor(param1DescriptorProto.getField(param1Int), param1FileDescriptor, this, param1Int, false); 
      this.extensions = new Descriptors.FieldDescriptor[param1DescriptorProto.getExtensionCount()];
      for (param1Int = 0; param1Int < param1DescriptorProto.getExtensionCount(); param1Int++)
        this.extensions[param1Int] = new Descriptors.FieldDescriptor(param1DescriptorProto.getExtension(param1Int), param1FileDescriptor, this, param1Int, true); 
      for (param1Int = 0; param1Int < param1DescriptorProto.getOneofDeclCount(); param1Int++) {
        Descriptors.OneofDescriptor[] arrayOfOneofDescriptor1 = this.oneofs;
        Descriptors.OneofDescriptor.access$1902(arrayOfOneofDescriptor1[param1Int], new Descriptors.FieldDescriptor[arrayOfOneofDescriptor1[param1Int].getFieldCount()]);
        Descriptors.OneofDescriptor.access$2002(this.oneofs[param1Int], 0);
      } 
      for (param1Int = 0; param1Int < param1DescriptorProto.getFieldCount(); param1Int++) {
        Descriptors.OneofDescriptor oneofDescriptor = this.fields[param1Int].getContainingOneof();
        if (oneofDescriptor != null)
          oneofDescriptor.fields[Descriptors.OneofDescriptor.access$2008(oneofDescriptor)] = this.fields[param1Int]; 
      } 
      Descriptors.OneofDescriptor[] arrayOfOneofDescriptor = this.oneofs;
      int j = arrayOfOneofDescriptor.length;
      byte b = 0;
      param1Int = i;
      i = b;
      while (param1Int < j) {
        if (arrayOfOneofDescriptor[param1Int].isSynthetic()) {
          i++;
        } else if (i > 0) {
          throw new Descriptors.DescriptorValidationException(this, "Synthetic oneofs must come last.");
        } 
        param1Int++;
      } 
      this.realOneofCount = this.oneofs.length - i;
      param1FileDescriptor.pool.addSymbol(this);
    }
    
    Descriptor(String param1String) throws Descriptors.DescriptorValidationException {
      String str1;
      String str2;
      int i = param1String.lastIndexOf('.');
      if (i != -1) {
        str2 = param1String.substring(i + 1);
        str1 = param1String.substring(0, i);
      } else {
        str1 = "";
        str2 = param1String;
      } 
      this.index = 0;
      this.proto = DescriptorProtos.DescriptorProto.newBuilder().setName(str2).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
      this.fullName = param1String;
      this.containingType = null;
      this.nestedTypes = new Descriptor[0];
      this.enumTypes = new Descriptors.EnumDescriptor[0];
      this.fields = new Descriptors.FieldDescriptor[0];
      this.extensions = new Descriptors.FieldDescriptor[0];
      this.oneofs = new Descriptors.OneofDescriptor[0];
      this.realOneofCount = 0;
      this.file = new Descriptors.FileDescriptor(str1, this);
    }
    
    private void crossLink() throws Descriptors.DescriptorValidationException {
      Descriptor[] arrayOfDescriptor = this.nestedTypes;
      int j = arrayOfDescriptor.length;
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++)
        arrayOfDescriptor[i].crossLink(); 
      Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.fields;
      j = arrayOfFieldDescriptor.length;
      for (i = 0; i < j; i++)
        arrayOfFieldDescriptor[i].crossLink(); 
      arrayOfFieldDescriptor = this.extensions;
      j = arrayOfFieldDescriptor.length;
      for (i = bool; i < j; i++)
        arrayOfFieldDescriptor[i].crossLink(); 
    }
    
    private void setProto(DescriptorProtos.DescriptorProto param1DescriptorProto) {
      this.proto = param1DescriptorProto;
      byte b = 0;
      int i = 0;
      while (true) {
        Descriptor[] arrayOfDescriptor = this.nestedTypes;
        if (i < arrayOfDescriptor.length) {
          arrayOfDescriptor[i].setProto(param1DescriptorProto.getNestedType(i));
          i++;
          continue;
        } 
        i = 0;
        while (true) {
          Descriptors.OneofDescriptor[] arrayOfOneofDescriptor = this.oneofs;
          if (i < arrayOfOneofDescriptor.length) {
            arrayOfOneofDescriptor[i].setProto(param1DescriptorProto.getOneofDecl(i));
            i++;
            continue;
          } 
          i = 0;
          while (true) {
            int j;
            Descriptors.EnumDescriptor[] arrayOfEnumDescriptor = this.enumTypes;
            if (i < arrayOfEnumDescriptor.length) {
              arrayOfEnumDescriptor[i].setProto(param1DescriptorProto.getEnumType(i));
              i++;
              continue;
            } 
            i = 0;
            while (true) {
              Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.fields;
              j = b;
              if (i < arrayOfFieldDescriptor.length) {
                arrayOfFieldDescriptor[i].setProto(param1DescriptorProto.getField(i));
                i++;
                continue;
              } 
              break;
            } 
            while (true) {
              Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.extensions;
              if (j < arrayOfFieldDescriptor.length) {
                arrayOfFieldDescriptor[j].setProto(param1DescriptorProto.getExtension(j));
                j++;
                continue;
              } 
              break;
            } 
            return;
          } 
          break;
        } 
        break;
      } 
    }
    
    public Descriptors.EnumDescriptor findEnumTypeByName(String param1String) {
      Descriptors.DescriptorPool descriptorPool = this.file.pool;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.fullName);
      stringBuilder.append('.');
      stringBuilder.append(param1String);
      Descriptors.GenericDescriptor genericDescriptor = descriptorPool.findSymbol(stringBuilder.toString());
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.EnumDescriptor) ? (Descriptors.EnumDescriptor)genericDescriptor : null;
    }
    
    public Descriptors.FieldDescriptor findFieldByName(String param1String) {
      Descriptors.DescriptorPool descriptorPool = this.file.pool;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.fullName);
      stringBuilder.append('.');
      stringBuilder.append(param1String);
      Descriptors.GenericDescriptor genericDescriptor = descriptorPool.findSymbol(stringBuilder.toString());
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.FieldDescriptor) ? (Descriptors.FieldDescriptor)genericDescriptor : null;
    }
    
    public Descriptors.FieldDescriptor findFieldByNumber(int param1Int) {
      return (Descriptors.FieldDescriptor)this.file.pool.fieldsByNumber.get(new Descriptors.DescriptorPool.DescriptorIntPair(this, param1Int));
    }
    
    public Descriptor findNestedTypeByName(String param1String) {
      Descriptors.DescriptorPool descriptorPool = this.file.pool;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.fullName);
      stringBuilder.append('.');
      stringBuilder.append(param1String);
      Descriptors.GenericDescriptor genericDescriptor = descriptorPool.findSymbol(stringBuilder.toString());
      return (genericDescriptor != null && genericDescriptor instanceof Descriptor) ? (Descriptor)genericDescriptor : null;
    }
    
    public Descriptor getContainingType() {
      return this.containingType;
    }
    
    public List<Descriptors.EnumDescriptor> getEnumTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
    }
    
    public List<Descriptors.FieldDescriptor> getExtensions() {
      return Collections.unmodifiableList(Arrays.asList(this.extensions));
    }
    
    public List<Descriptors.FieldDescriptor> getFields() {
      return Collections.unmodifiableList(Arrays.asList(this.fields));
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public int getIndex() {
      return this.index;
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public List<Descriptor> getNestedTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
    }
    
    public List<Descriptors.OneofDescriptor> getOneofs() {
      return Collections.unmodifiableList(Arrays.asList(this.oneofs));
    }
    
    public DescriptorProtos.MessageOptions getOptions() {
      return this.proto.getOptions();
    }
    
    public List<Descriptors.OneofDescriptor> getRealOneofs() {
      return Collections.unmodifiableList(Arrays.<Descriptors.OneofDescriptor>asList(this.oneofs).subList(0, this.realOneofCount));
    }
    
    public boolean isExtendable() {
      return (this.proto.getExtensionRangeList().size() != 0);
    }
    
    public boolean isExtensionNumber(int param1Int) {
      for (DescriptorProtos.DescriptorProto.ExtensionRange extensionRange : this.proto.getExtensionRangeList()) {
        if (extensionRange.getStart() <= param1Int && param1Int < extensionRange.getEnd())
          return true; 
      } 
      return false;
    }
    
    public boolean isReservedName(String param1String) {
      Internal.checkNotNull(param1String);
      Iterator<String> iterator = this.proto.getReservedNameList().iterator();
      while (iterator.hasNext()) {
        if (((String)iterator.next()).equals(param1String))
          return true; 
      } 
      return false;
    }
    
    public boolean isReservedNumber(int param1Int) {
      for (DescriptorProtos.DescriptorProto.ReservedRange reservedRange : this.proto.getReservedRangeList()) {
        if (reservedRange.getStart() <= param1Int && param1Int < reservedRange.getEnd())
          return true; 
      } 
      return false;
    }
    
    public DescriptorProtos.DescriptorProto toProto() {
      return this.proto;
    }
  }
  
  static final class DescriptorPool {
    private boolean allowUnknownDependencies;
    
    private final Set<Descriptors.FileDescriptor> dependencies = new HashSet<Descriptors.FileDescriptor>();
    
    private final Map<String, Descriptors.GenericDescriptor> descriptorsByName = new HashMap<String, Descriptors.GenericDescriptor>();
    
    private final Map<DescriptorIntPair, Descriptors.EnumValueDescriptor> enumValuesByNumber = new HashMap<DescriptorIntPair, Descriptors.EnumValueDescriptor>();
    
    private final Map<DescriptorIntPair, Descriptors.FieldDescriptor> fieldsByNumber = new HashMap<DescriptorIntPair, Descriptors.FieldDescriptor>();
    
    DescriptorPool(Descriptors.FileDescriptor[] param1ArrayOfFileDescriptor, boolean param1Boolean) {
      this.allowUnknownDependencies = param1Boolean;
      for (int i = 0; i < param1ArrayOfFileDescriptor.length; i++) {
        this.dependencies.add(param1ArrayOfFileDescriptor[i]);
        importPublicDependencies(param1ArrayOfFileDescriptor[i]);
      } 
      Iterator<Descriptors.FileDescriptor> iterator = this.dependencies.iterator();
      while (iterator.hasNext()) {
        Descriptors.FileDescriptor fileDescriptor = iterator.next();
        try {
          addPackage(fileDescriptor.getPackage(), fileDescriptor);
        } catch (DescriptorValidationException descriptorValidationException) {
          throw new AssertionError(descriptorValidationException);
        } 
      } 
    }
    
    private void importPublicDependencies(Descriptors.FileDescriptor param1FileDescriptor) {
      for (Descriptors.FileDescriptor fileDescriptor : param1FileDescriptor.getPublicDependencies()) {
        if (this.dependencies.add(fileDescriptor))
          importPublicDependencies(fileDescriptor); 
      } 
    }
    
    static void validateSymbolName(Descriptors.GenericDescriptor param1GenericDescriptor) throws Descriptors.DescriptorValidationException {
      String str = param1GenericDescriptor.getName();
      if (str.length() != 0) {
        int i = 0;
        while (i < str.length()) {
          char c = str.charAt(i);
          if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || c == '_' || ('0' <= c && c <= '9' && i > 0)) {
            i++;
            continue;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append('"');
          stringBuilder.append(str);
          stringBuilder.append("\" is not a valid identifier.");
          throw new Descriptors.DescriptorValidationException(param1GenericDescriptor, stringBuilder.toString());
        } 
        return;
      } 
      throw new Descriptors.DescriptorValidationException(param1GenericDescriptor, "Missing name.");
    }
    
    void addEnumValueByNumber(Descriptors.EnumValueDescriptor param1EnumValueDescriptor) {
      DescriptorIntPair descriptorIntPair = new DescriptorIntPair(param1EnumValueDescriptor.getType(), param1EnumValueDescriptor.getNumber());
      param1EnumValueDescriptor = this.enumValuesByNumber.put(descriptorIntPair, param1EnumValueDescriptor);
      if (param1EnumValueDescriptor != null)
        this.enumValuesByNumber.put(descriptorIntPair, param1EnumValueDescriptor); 
    }
    
    void addFieldByNumber(Descriptors.FieldDescriptor param1FieldDescriptor) throws Descriptors.DescriptorValidationException {
      DescriptorIntPair descriptorIntPair = new DescriptorIntPair(param1FieldDescriptor.getContainingType(), param1FieldDescriptor.getNumber());
      Descriptors.FieldDescriptor fieldDescriptor = this.fieldsByNumber.put(descriptorIntPair, param1FieldDescriptor);
      if (fieldDescriptor == null)
        return; 
      this.fieldsByNumber.put(descriptorIntPair, fieldDescriptor);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Field number ");
      stringBuilder.append(param1FieldDescriptor.getNumber());
      stringBuilder.append(" has already been used in \"");
      stringBuilder.append(param1FieldDescriptor.getContainingType().getFullName());
      stringBuilder.append("\" by field \"");
      stringBuilder.append(fieldDescriptor.getName());
      stringBuilder.append("\".");
      throw new Descriptors.DescriptorValidationException(param1FieldDescriptor, stringBuilder.toString());
    }
    
    void addPackage(String param1String, Descriptors.FileDescriptor param1FileDescriptor) throws Descriptors.DescriptorValidationException {
      String str;
      int i = param1String.lastIndexOf('.');
      if (i == -1) {
        str = param1String;
      } else {
        addPackage(param1String.substring(0, i), param1FileDescriptor);
        str = param1String.substring(i + 1);
      } 
      Descriptors.GenericDescriptor genericDescriptor = this.descriptorsByName.put(param1String, new PackageDescriptor(str, param1String, param1FileDescriptor));
      if (genericDescriptor != null) {
        this.descriptorsByName.put(param1String, genericDescriptor);
        if (genericDescriptor instanceof PackageDescriptor)
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('"');
        stringBuilder.append(str);
        stringBuilder.append("\" is already defined (as something other than a package) in file \"");
        stringBuilder.append(genericDescriptor.getFile().getName());
        stringBuilder.append("\".");
        throw new Descriptors.DescriptorValidationException(param1FileDescriptor, stringBuilder.toString());
      } 
    }
    
    void addSymbol(Descriptors.GenericDescriptor param1GenericDescriptor) throws Descriptors.DescriptorValidationException {
      validateSymbolName(param1GenericDescriptor);
      String str = param1GenericDescriptor.getFullName();
      Descriptors.GenericDescriptor genericDescriptor = this.descriptorsByName.put(str, param1GenericDescriptor);
      if (genericDescriptor != null) {
        StringBuilder stringBuilder1;
        this.descriptorsByName.put(str, genericDescriptor);
        if (param1GenericDescriptor.getFile() == genericDescriptor.getFile()) {
          int i = str.lastIndexOf('.');
          if (i == -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('"');
            stringBuilder.append(str);
            stringBuilder.append("\" is already defined.");
            throw new Descriptors.DescriptorValidationException(param1GenericDescriptor, stringBuilder.toString());
          } 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append('"');
          stringBuilder1.append(str.substring(i + 1));
          stringBuilder1.append("\" is already defined in \"");
          stringBuilder1.append(str.substring(0, i));
          stringBuilder1.append("\".");
          throw new Descriptors.DescriptorValidationException(param1GenericDescriptor, stringBuilder1.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append('"');
        stringBuilder2.append(str);
        stringBuilder2.append("\" is already defined in file \"");
        stringBuilder2.append(stringBuilder1.getFile().getName());
        stringBuilder2.append("\".");
        throw new Descriptors.DescriptorValidationException(param1GenericDescriptor, stringBuilder2.toString());
      } 
    }
    
    Descriptors.GenericDescriptor findSymbol(String param1String) {
      return findSymbol(param1String, SearchFilter.ALL_SYMBOLS);
    }
    
    Descriptors.GenericDescriptor findSymbol(String param1String, SearchFilter param1SearchFilter) {
      Descriptors.GenericDescriptor genericDescriptor = this.descriptorsByName.get(param1String);
      if (genericDescriptor != null && (param1SearchFilter == SearchFilter.ALL_SYMBOLS || (param1SearchFilter == SearchFilter.TYPES_ONLY && isType(genericDescriptor)) || (param1SearchFilter == SearchFilter.AGGREGATES_ONLY && isAggregate(genericDescriptor))))
        return genericDescriptor; 
      Iterator<Descriptors.FileDescriptor> iterator = this.dependencies.iterator();
      while (iterator.hasNext()) {
        Descriptors.GenericDescriptor genericDescriptor1 = ((Descriptors.FileDescriptor)iterator.next()).pool.descriptorsByName.get(param1String);
        if (genericDescriptor1 != null && (param1SearchFilter == SearchFilter.ALL_SYMBOLS || (param1SearchFilter == SearchFilter.TYPES_ONLY && isType(genericDescriptor1)) || (param1SearchFilter == SearchFilter.AGGREGATES_ONLY && isAggregate(genericDescriptor1))))
          return genericDescriptor1; 
      } 
      return null;
    }
    
    boolean isAggregate(Descriptors.GenericDescriptor param1GenericDescriptor) {
      return (param1GenericDescriptor instanceof Descriptors.Descriptor || param1GenericDescriptor instanceof Descriptors.EnumDescriptor || param1GenericDescriptor instanceof PackageDescriptor || param1GenericDescriptor instanceof Descriptors.ServiceDescriptor);
    }
    
    boolean isType(Descriptors.GenericDescriptor param1GenericDescriptor) {
      return (param1GenericDescriptor instanceof Descriptors.Descriptor || param1GenericDescriptor instanceof Descriptors.EnumDescriptor);
    }
    
    Descriptors.GenericDescriptor lookupSymbol(String param1String, Descriptors.GenericDescriptor param1GenericDescriptor, SearchFilter param1SearchFilter) throws Descriptors.DescriptorValidationException {
      // Byte code:
      //   0: aload_1
      //   1: ldc_w '.'
      //   4: invokevirtual startsWith : (Ljava/lang/String;)Z
      //   7: ifeq -> 29
      //   10: aload_1
      //   11: iconst_1
      //   12: invokevirtual substring : (I)Ljava/lang/String;
      //   15: astore #7
      //   17: aload_0
      //   18: aload #7
      //   20: aload_3
      //   21: invokevirtual findSymbol : (Ljava/lang/String;Lcom/google/protobuf/Descriptors$DescriptorPool$SearchFilter;)Lcom/google/protobuf/Descriptors$GenericDescriptor;
      //   24: astore #8
      //   26: goto -> 195
      //   29: aload_1
      //   30: bipush #46
      //   32: invokevirtual indexOf : (I)I
      //   35: istore #4
      //   37: iload #4
      //   39: iconst_m1
      //   40: if_icmpne -> 49
      //   43: aload_1
      //   44: astore #7
      //   46: goto -> 58
      //   49: aload_1
      //   50: iconst_0
      //   51: iload #4
      //   53: invokevirtual substring : (II)Ljava/lang/String;
      //   56: astore #7
      //   58: new java/lang/StringBuilder
      //   61: dup
      //   62: aload_2
      //   63: invokevirtual getFullName : ()Ljava/lang/String;
      //   66: invokespecial <init> : (Ljava/lang/String;)V
      //   69: astore #9
      //   71: aload #9
      //   73: ldc_w '.'
      //   76: invokevirtual lastIndexOf : (Ljava/lang/String;)I
      //   79: istore #5
      //   81: iload #5
      //   83: iconst_m1
      //   84: if_icmpne -> 101
      //   87: aload_0
      //   88: aload_1
      //   89: aload_3
      //   90: invokevirtual findSymbol : (Ljava/lang/String;Lcom/google/protobuf/Descriptors$DescriptorPool$SearchFilter;)Lcom/google/protobuf/Descriptors$GenericDescriptor;
      //   93: astore #8
      //   95: aload_1
      //   96: astore #7
      //   98: goto -> 195
      //   101: iload #5
      //   103: iconst_1
      //   104: iadd
      //   105: istore #6
      //   107: aload #9
      //   109: iload #6
      //   111: invokevirtual setLength : (I)V
      //   114: aload #9
      //   116: aload #7
      //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   121: pop
      //   122: aload_0
      //   123: aload #9
      //   125: invokevirtual toString : ()Ljava/lang/String;
      //   128: getstatic com/google/protobuf/Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY : Lcom/google/protobuf/Descriptors$DescriptorPool$SearchFilter;
      //   131: invokevirtual findSymbol : (Ljava/lang/String;Lcom/google/protobuf/Descriptors$DescriptorPool$SearchFilter;)Lcom/google/protobuf/Descriptors$GenericDescriptor;
      //   134: astore #8
      //   136: aload #8
      //   138: ifnull -> 328
      //   141: iload #4
      //   143: iconst_m1
      //   144: if_icmpeq -> 176
      //   147: aload #9
      //   149: iload #6
      //   151: invokevirtual setLength : (I)V
      //   154: aload #9
      //   156: aload_1
      //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   160: pop
      //   161: aload_0
      //   162: aload #9
      //   164: invokevirtual toString : ()Ljava/lang/String;
      //   167: aload_3
      //   168: invokevirtual findSymbol : (Ljava/lang/String;Lcom/google/protobuf/Descriptors$DescriptorPool$SearchFilter;)Lcom/google/protobuf/Descriptors$GenericDescriptor;
      //   171: astore #7
      //   173: goto -> 180
      //   176: aload #8
      //   178: astore #7
      //   180: aload #9
      //   182: invokevirtual toString : ()Ljava/lang/String;
      //   185: astore #9
      //   187: aload #7
      //   189: astore #8
      //   191: aload #9
      //   193: astore #7
      //   195: aload #8
      //   197: ifnonnull -> 325
      //   200: aload_0
      //   201: getfield allowUnknownDependencies : Z
      //   204: ifeq -> 282
      //   207: aload_3
      //   208: getstatic com/google/protobuf/Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY : Lcom/google/protobuf/Descriptors$DescriptorPool$SearchFilter;
      //   211: if_acmpne -> 282
      //   214: invokestatic access$100 : ()Ljava/util/logging/Logger;
      //   217: astore_2
      //   218: new java/lang/StringBuilder
      //   221: dup
      //   222: invokespecial <init> : ()V
      //   225: astore_3
      //   226: aload_3
      //   227: ldc_w 'The descriptor for message type "'
      //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   233: pop
      //   234: aload_3
      //   235: aload_1
      //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: pop
      //   240: aload_3
      //   241: ldc_w '" can not be found and a placeholder is created for it'
      //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   247: pop
      //   248: aload_2
      //   249: aload_3
      //   250: invokevirtual toString : ()Ljava/lang/String;
      //   253: invokevirtual warning : (Ljava/lang/String;)V
      //   256: new com/google/protobuf/Descriptors$Descriptor
      //   259: dup
      //   260: aload #7
      //   262: invokespecial <init> : (Ljava/lang/String;)V
      //   265: astore_1
      //   266: aload_0
      //   267: getfield dependencies : Ljava/util/Set;
      //   270: aload_1
      //   271: invokevirtual getFile : ()Lcom/google/protobuf/Descriptors$FileDescriptor;
      //   274: invokeinterface add : (Ljava/lang/Object;)Z
      //   279: pop
      //   280: aload_1
      //   281: areturn
      //   282: new java/lang/StringBuilder
      //   285: dup
      //   286: invokespecial <init> : ()V
      //   289: astore_3
      //   290: aload_3
      //   291: bipush #34
      //   293: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   296: pop
      //   297: aload_3
      //   298: aload_1
      //   299: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   302: pop
      //   303: aload_3
      //   304: ldc_w '" is not defined.'
      //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   310: pop
      //   311: new com/google/protobuf/Descriptors$DescriptorValidationException
      //   314: dup
      //   315: aload_2
      //   316: aload_3
      //   317: invokevirtual toString : ()Ljava/lang/String;
      //   320: aconst_null
      //   321: invokespecial <init> : (Lcom/google/protobuf/Descriptors$GenericDescriptor;Ljava/lang/String;Lcom/google/protobuf/Descriptors$1;)V
      //   324: athrow
      //   325: aload #8
      //   327: areturn
      //   328: aload #9
      //   330: iload #5
      //   332: invokevirtual setLength : (I)V
      //   335: goto -> 71
    }
    
    static final class DescriptorIntPair {
      private final Descriptors.GenericDescriptor descriptor;
      
      private final int number;
      
      DescriptorIntPair(Descriptors.GenericDescriptor param2GenericDescriptor, int param2Int) {
        this.descriptor = param2GenericDescriptor;
        this.number = param2Int;
      }
      
      public boolean equals(Object param2Object) {
        boolean bool = param2Object instanceof DescriptorIntPair;
        boolean bool1 = false;
        if (!bool)
          return false; 
        param2Object = param2Object;
        bool = bool1;
        if (this.descriptor == ((DescriptorIntPair)param2Object).descriptor) {
          bool = bool1;
          if (this.number == ((DescriptorIntPair)param2Object).number)
            bool = true; 
        } 
        return bool;
      }
      
      public int hashCode() {
        return this.descriptor.hashCode() * 65535 + this.number;
      }
    }
    
    static final class PackageDescriptor extends Descriptors.GenericDescriptor {
      private final Descriptors.FileDescriptor file;
      
      private final String fullName;
      
      private final String name;
      
      PackageDescriptor(String param2String1, String param2String2, Descriptors.FileDescriptor param2FileDescriptor) {
        this.file = param2FileDescriptor;
        this.fullName = param2String2;
        this.name = param2String1;
      }
      
      public Descriptors.FileDescriptor getFile() {
        return this.file;
      }
      
      public String getFullName() {
        return this.fullName;
      }
      
      public String getName() {
        return this.name;
      }
      
      public Message toProto() {
        return this.file.toProto();
      }
    }
    
    enum SearchFilter {
      AGGREGATES_ONLY, ALL_SYMBOLS, TYPES_ONLY;
      
      static {
      
      }
    }
  }
  
  static final class DescriptorIntPair {
    private final Descriptors.GenericDescriptor descriptor;
    
    private final int number;
    
    DescriptorIntPair(Descriptors.GenericDescriptor param1GenericDescriptor, int param1Int) {
      this.descriptor = param1GenericDescriptor;
      this.number = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof DescriptorIntPair;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (this.descriptor == ((DescriptorIntPair)param1Object).descriptor) {
        bool = bool1;
        if (this.number == ((DescriptorIntPair)param1Object).number)
          bool = true; 
      } 
      return bool;
    }
    
    public int hashCode() {
      return this.descriptor.hashCode() * 65535 + this.number;
    }
  }
  
  static final class PackageDescriptor extends GenericDescriptor {
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final String name;
    
    PackageDescriptor(String param1String1, String param1String2, Descriptors.FileDescriptor param1FileDescriptor) {
      this.file = param1FileDescriptor;
      this.fullName = param1String2;
      this.name = param1String1;
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public String getName() {
      return this.name;
    }
    
    public Message toProto() {
      return this.file.toProto();
    }
  }
  
  enum SearchFilter {
    AGGREGATES_ONLY, ALL_SYMBOLS, TYPES_ONLY;
    
    static {
      $VALUES = new SearchFilter[] { TYPES_ONLY, AGGREGATES_ONLY, ALL_SYMBOLS };
    }
  }
  
  public static class DescriptorValidationException extends Exception {
    private static final long serialVersionUID = 5750205775490483148L;
    
    private final String description;
    
    private final String name;
    
    private final Message proto;
    
    private DescriptorValidationException(Descriptors.FileDescriptor param1FileDescriptor, String param1String) {
      super(stringBuilder.toString());
      this.name = param1FileDescriptor.getName();
      this.proto = param1FileDescriptor.toProto();
      this.description = param1String;
    }
    
    private DescriptorValidationException(Descriptors.GenericDescriptor param1GenericDescriptor, String param1String) {
      super(stringBuilder.toString());
      this.name = param1GenericDescriptor.getFullName();
      this.proto = param1GenericDescriptor.toProto();
      this.description = param1String;
    }
    
    private DescriptorValidationException(Descriptors.GenericDescriptor param1GenericDescriptor, String param1String, Throwable param1Throwable) {
      this(param1GenericDescriptor, param1String);
      initCause(param1Throwable);
    }
    
    public String getDescription() {
      return this.description;
    }
    
    public Message getProblemProto() {
      return this.proto;
    }
    
    public String getProblemSymbolName() {
      return this.name;
    }
  }
  
  public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {
    private final Descriptors.Descriptor containingType;
    
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final int index;
    
    private DescriptorProtos.EnumDescriptorProto proto;
    
    private final WeakHashMap<Integer, WeakReference<Descriptors.EnumValueDescriptor>> unknownValues = new WeakHashMap<Integer, WeakReference<Descriptors.EnumValueDescriptor>>();
    
    private Descriptors.EnumValueDescriptor[] values;
    
    private EnumDescriptor(DescriptorProtos.EnumDescriptorProto param1EnumDescriptorProto, Descriptors.FileDescriptor param1FileDescriptor, Descriptors.Descriptor param1Descriptor, int param1Int) throws Descriptors.DescriptorValidationException {
      this.index = param1Int;
      this.proto = param1EnumDescriptorProto;
      this.fullName = Descriptors.computeFullName(param1FileDescriptor, param1Descriptor, param1EnumDescriptorProto.getName());
      this.file = param1FileDescriptor;
      this.containingType = param1Descriptor;
      if (param1EnumDescriptorProto.getValueCount() != 0) {
        this.values = new Descriptors.EnumValueDescriptor[param1EnumDescriptorProto.getValueCount()];
        for (param1Int = 0; param1Int < param1EnumDescriptorProto.getValueCount(); param1Int++)
          this.values[param1Int] = new Descriptors.EnumValueDescriptor(param1EnumDescriptorProto.getValue(param1Int), param1FileDescriptor, this, param1Int); 
        param1FileDescriptor.pool.addSymbol(this);
        return;
      } 
      throw new Descriptors.DescriptorValidationException(this, "Enums must contain at least one value.");
    }
    
    private void setProto(DescriptorProtos.EnumDescriptorProto param1EnumDescriptorProto) {
      this.proto = param1EnumDescriptorProto;
      int i = 0;
      while (true) {
        Descriptors.EnumValueDescriptor[] arrayOfEnumValueDescriptor = this.values;
        if (i < arrayOfEnumValueDescriptor.length) {
          arrayOfEnumValueDescriptor[i].setProto(param1EnumDescriptorProto.getValue(i));
          i++;
          continue;
        } 
        break;
      } 
    }
    
    public Descriptors.EnumValueDescriptor findValueByName(String param1String) {
      Descriptors.DescriptorPool descriptorPool = this.file.pool;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.fullName);
      stringBuilder.append('.');
      stringBuilder.append(param1String);
      Descriptors.GenericDescriptor genericDescriptor = descriptorPool.findSymbol(stringBuilder.toString());
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.EnumValueDescriptor) ? (Descriptors.EnumValueDescriptor)genericDescriptor : null;
    }
    
    public Descriptors.EnumValueDescriptor findValueByNumber(int param1Int) {
      return (Descriptors.EnumValueDescriptor)this.file.pool.enumValuesByNumber.get(new Descriptors.DescriptorPool.DescriptorIntPair(this, param1Int));
    }
    
    public Descriptors.EnumValueDescriptor findValueByNumberCreatingIfUnknown(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual findValueByNumber : (I)Lcom/google/protobuf/Descriptors$EnumValueDescriptor;
      //   5: astore_2
      //   6: aload_2
      //   7: ifnull -> 12
      //   10: aload_2
      //   11: areturn
      //   12: aload_0
      //   13: monitorenter
      //   14: new java/lang/Integer
      //   17: dup
      //   18: iload_1
      //   19: invokespecial <init> : (I)V
      //   22: astore #4
      //   24: aload_0
      //   25: getfield unknownValues : Ljava/util/WeakHashMap;
      //   28: aload #4
      //   30: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   33: checkcast java/lang/ref/WeakReference
      //   36: astore_3
      //   37: aload_3
      //   38: ifnull -> 49
      //   41: aload_3
      //   42: invokevirtual get : ()Ljava/lang/Object;
      //   45: checkcast com/google/protobuf/Descriptors$EnumValueDescriptor
      //   48: astore_2
      //   49: aload_2
      //   50: astore_3
      //   51: aload_2
      //   52: ifnonnull -> 89
      //   55: new com/google/protobuf/Descriptors$EnumValueDescriptor
      //   58: dup
      //   59: aload_0
      //   60: getfield file : Lcom/google/protobuf/Descriptors$FileDescriptor;
      //   63: aload_0
      //   64: aload #4
      //   66: aconst_null
      //   67: invokespecial <init> : (Lcom/google/protobuf/Descriptors$FileDescriptor;Lcom/google/protobuf/Descriptors$EnumDescriptor;Ljava/lang/Integer;Lcom/google/protobuf/Descriptors$1;)V
      //   70: astore_3
      //   71: aload_0
      //   72: getfield unknownValues : Ljava/util/WeakHashMap;
      //   75: aload #4
      //   77: new java/lang/ref/WeakReference
      //   80: dup
      //   81: aload_3
      //   82: invokespecial <init> : (Ljava/lang/Object;)V
      //   85: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   88: pop
      //   89: aload_0
      //   90: monitorexit
      //   91: aload_3
      //   92: areturn
      //   93: astore_2
      //   94: aload_0
      //   95: monitorexit
      //   96: aload_2
      //   97: athrow
      // Exception table:
      //   from	to	target	type
      //   14	37	93	finally
      //   41	49	93	finally
      //   55	89	93	finally
      //   89	91	93	finally
      //   94	96	93	finally
    }
    
    public Descriptors.Descriptor getContainingType() {
      return this.containingType;
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public int getIndex() {
      return this.index;
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public DescriptorProtos.EnumOptions getOptions() {
      return this.proto.getOptions();
    }
    
    int getUnknownEnumValueDescriptorCount() {
      return this.unknownValues.size();
    }
    
    public List<Descriptors.EnumValueDescriptor> getValues() {
      return Collections.unmodifiableList(Arrays.asList(this.values));
    }
    
    public DescriptorProtos.EnumDescriptorProto toProto() {
      return this.proto;
    }
  }
  
  public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final int index;
    
    private DescriptorProtos.EnumValueDescriptorProto proto;
    
    private final Descriptors.EnumDescriptor type;
    
    private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto param1EnumValueDescriptorProto, Descriptors.FileDescriptor param1FileDescriptor, Descriptors.EnumDescriptor param1EnumDescriptor, int param1Int) throws Descriptors.DescriptorValidationException {
      this.index = param1Int;
      this.proto = param1EnumValueDescriptorProto;
      this.file = param1FileDescriptor;
      this.type = param1EnumDescriptor;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1EnumDescriptor.getFullName());
      stringBuilder.append('.');
      stringBuilder.append(param1EnumValueDescriptorProto.getName());
      this.fullName = stringBuilder.toString();
      param1FileDescriptor.pool.addSymbol(this);
      param1FileDescriptor.pool.addEnumValueByNumber(this);
    }
    
    private EnumValueDescriptor(Descriptors.FileDescriptor param1FileDescriptor, Descriptors.EnumDescriptor param1EnumDescriptor, Integer param1Integer) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("UNKNOWN_ENUM_VALUE_");
      stringBuilder2.append(param1EnumDescriptor.getName());
      stringBuilder2.append("_");
      stringBuilder2.append(param1Integer);
      String str = stringBuilder2.toString();
      DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName(str).setNumber(param1Integer.intValue()).build();
      this.index = -1;
      this.proto = enumValueDescriptorProto;
      this.file = param1FileDescriptor;
      this.type = param1EnumDescriptor;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(param1EnumDescriptor.getFullName());
      stringBuilder1.append('.');
      stringBuilder1.append(enumValueDescriptorProto.getName());
      this.fullName = stringBuilder1.toString();
    }
    
    private void setProto(DescriptorProtos.EnumValueDescriptorProto param1EnumValueDescriptorProto) {
      this.proto = param1EnumValueDescriptorProto;
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public int getIndex() {
      return this.index;
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public int getNumber() {
      return this.proto.getNumber();
    }
    
    public DescriptorProtos.EnumValueOptions getOptions() {
      return this.proto.getOptions();
    }
    
    public Descriptors.EnumDescriptor getType() {
      return this.type;
    }
    
    public DescriptorProtos.EnumValueDescriptorProto toProto() {
      return this.proto;
    }
    
    public String toString() {
      return this.proto.getName();
    }
  }
  
  public static final class FieldDescriptor extends GenericDescriptor implements FieldSet.FieldDescriptorLite<FieldDescriptor>, Comparable<FieldDescriptor> {
    private static final WireFormat.FieldType[] table = WireFormat.FieldType.values();
    
    private Descriptors.OneofDescriptor containingOneof;
    
    private Descriptors.Descriptor containingType;
    
    private Object defaultValue;
    
    private Descriptors.EnumDescriptor enumType;
    
    private final Descriptors.Descriptor extensionScope;
    
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final int index;
    
    private final boolean isProto3Optional;
    
    private final String jsonName;
    
    private Descriptors.Descriptor messageType;
    
    private DescriptorProtos.FieldDescriptorProto proto;
    
    private Type type;
    
    static {
      if ((Type.values()).length == (DescriptorProtos.FieldDescriptorProto.Type.values()).length)
        return; 
      throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
    }
    
    private FieldDescriptor(DescriptorProtos.FieldDescriptorProto param1FieldDescriptorProto, Descriptors.FileDescriptor param1FileDescriptor, Descriptors.Descriptor param1Descriptor, int param1Int, boolean param1Boolean) throws Descriptors.DescriptorValidationException {
      this.index = param1Int;
      this.proto = param1FieldDescriptorProto;
      this.fullName = Descriptors.computeFullName(param1FileDescriptor, param1Descriptor, param1FieldDescriptorProto.getName());
      this.file = param1FileDescriptor;
      if (param1FieldDescriptorProto.hasJsonName()) {
        this.jsonName = param1FieldDescriptorProto.getJsonName();
      } else {
        this.jsonName = fieldNameToJsonName(param1FieldDescriptorProto.getName());
      } 
      if (param1FieldDescriptorProto.hasType())
        this.type = Type.valueOf(param1FieldDescriptorProto.getType()); 
      this.isProto3Optional = param1FieldDescriptorProto.getProto3Optional();
      if (getNumber() > 0) {
        if (param1Boolean) {
          if (param1FieldDescriptorProto.hasExtendee()) {
            this.containingType = null;
            if (param1Descriptor != null) {
              this.extensionScope = param1Descriptor;
            } else {
              this.extensionScope = null;
            } 
            if (!param1FieldDescriptorProto.hasOneofIndex()) {
              this.containingOneof = null;
            } else {
              throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.");
            } 
          } else {
            throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.");
          } 
        } else if (!param1FieldDescriptorProto.hasExtendee()) {
          this.containingType = param1Descriptor;
          if (param1FieldDescriptorProto.hasOneofIndex()) {
            if (param1FieldDescriptorProto.getOneofIndex() >= 0 && param1FieldDescriptorProto.getOneofIndex() < param1Descriptor.toProto().getOneofDeclCount()) {
              this.containingOneof = param1Descriptor.getOneofs().get(param1FieldDescriptorProto.getOneofIndex());
              Descriptors.OneofDescriptor.access$2008(this.containingOneof);
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("FieldDescriptorProto.oneof_index is out of range for type ");
              stringBuilder.append(param1Descriptor.getName());
              throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
            } 
          } else {
            this.containingOneof = null;
          } 
          this.extensionScope = null;
        } else {
          throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.");
        } 
        param1FileDescriptor.pool.addSymbol(this);
        return;
      } 
      throw new Descriptors.DescriptorValidationException(this, "Field numbers must be positive integers.");
    }
    
    private void crossLink() throws Descriptors.DescriptorValidationException {
      if (this.proto.hasExtendee()) {
        Descriptors.GenericDescriptor genericDescriptor = this.file.pool.lookupSymbol(this.proto.getExtendee(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
        if (genericDescriptor instanceof Descriptors.Descriptor) {
          this.containingType = (Descriptors.Descriptor)genericDescriptor;
          if (!getContainingType().isExtensionNumber(getNumber())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('"');
            stringBuilder.append(getContainingType().getFullName());
            stringBuilder.append("\" does not declare ");
            stringBuilder.append(getNumber());
            stringBuilder.append(" as an extension number.");
            throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append('"');
          stringBuilder.append(this.proto.getExtendee());
          stringBuilder.append("\" is not a message type.");
          throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
        } 
      } 
      if (this.proto.hasTypeName()) {
        StringBuilder stringBuilder;
        Descriptors.GenericDescriptor genericDescriptor = this.file.pool.lookupSymbol(this.proto.getTypeName(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
        if (!this.proto.hasType())
          if (genericDescriptor instanceof Descriptors.Descriptor) {
            this.type = Type.MESSAGE;
          } else if (genericDescriptor instanceof Descriptors.EnumDescriptor) {
            this.type = Type.ENUM;
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('"');
            stringBuilder.append(this.proto.getTypeName());
            stringBuilder.append("\" is not a type.");
            throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
          }  
        if (getJavaType() == JavaType.MESSAGE) {
          if (stringBuilder instanceof Descriptors.Descriptor) {
            this.messageType = (Descriptors.Descriptor)stringBuilder;
            if (this.proto.hasDefaultValue())
              throw new Descriptors.DescriptorValidationException(this, "Messages can't have default values."); 
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('"');
            stringBuilder.append(this.proto.getTypeName());
            stringBuilder.append("\" is not a message type.");
            throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
          } 
        } else if (getJavaType() == JavaType.ENUM) {
          if (stringBuilder instanceof Descriptors.EnumDescriptor) {
            this.enumType = (Descriptors.EnumDescriptor)stringBuilder;
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append('"');
            stringBuilder.append(this.proto.getTypeName());
            stringBuilder.append("\" is not an enum type.");
            throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
          } 
        } else {
          throw new Descriptors.DescriptorValidationException(this, "Field with primitive type has type_name.");
        } 
      } else if (getJavaType() == JavaType.MESSAGE || getJavaType() == JavaType.ENUM) {
        throw new Descriptors.DescriptorValidationException(this, "Field with message or enum type missing type_name.");
      } 
      if (!this.proto.getOptions().getPacked() || isPackable()) {
        if (this.proto.hasDefaultValue()) {
          if (!isRepeated()) {
            try {
              StringBuilder stringBuilder;
              int i = Descriptors.null.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[getType().ordinal()];
              switch (i) {
                case 17:
                case 18:
                  throw new Descriptors.DescriptorValidationException(this, "Message type had default value.");
                case 16:
                  this.defaultValue = this.enumType.findValueByName(this.proto.getDefaultValue());
                  if (this.defaultValue != null)
                    break; 
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("Unknown enum default value: \"");
                  stringBuilder.append(this.proto.getDefaultValue());
                  stringBuilder.append('"');
                  throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
                case 15:
                  try {
                    this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());
                  } catch (InvalidEscapeSequenceException invalidEscapeSequenceException) {
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("Couldn't parse default value: ");
                    stringBuilder1.append(invalidEscapeSequenceException.getMessage());
                    throw new Descriptors.DescriptorValidationException(this, stringBuilder1.toString(), invalidEscapeSequenceException);
                  } 
                  break;
                case 14:
                  this.defaultValue = this.proto.getDefaultValue();
                  break;
                case 13:
                  this.defaultValue = Boolean.valueOf(this.proto.getDefaultValue());
                  break;
                case 12:
                  if (this.proto.getDefaultValue().equals("inf")) {
                    this.defaultValue = Double.valueOf(Double.POSITIVE_INFINITY);
                    break;
                  } 
                  if (this.proto.getDefaultValue().equals("-inf")) {
                    this.defaultValue = Double.valueOf(Double.NEGATIVE_INFINITY);
                    break;
                  } 
                  if (this.proto.getDefaultValue().equals("nan")) {
                    this.defaultValue = Double.valueOf(Double.NaN);
                    break;
                  } 
                  this.defaultValue = Double.valueOf(this.proto.getDefaultValue());
                  break;
                case 11:
                  if (this.proto.getDefaultValue().equals("inf")) {
                    this.defaultValue = Float.valueOf(Float.POSITIVE_INFINITY);
                    break;
                  } 
                  if (this.proto.getDefaultValue().equals("-inf")) {
                    this.defaultValue = Float.valueOf(Float.NEGATIVE_INFINITY);
                    break;
                  } 
                  if (this.proto.getDefaultValue().equals("nan")) {
                    this.defaultValue = Float.valueOf(Float.NaN);
                    break;
                  } 
                  this.defaultValue = Float.valueOf(this.proto.getDefaultValue());
                  break;
                case 9:
                case 10:
                  this.defaultValue = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));
                  break;
                case 6:
                case 7:
                case 8:
                  this.defaultValue = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));
                  break;
                case 4:
                case 5:
                  this.defaultValue = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));
                  break;
                case 1:
                case 2:
                case 3:
                  this.defaultValue = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));
                  break;
              } 
            } catch (NumberFormatException numberFormatException) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Could not parse default value: \"");
              stringBuilder.append(this.proto.getDefaultValue());
              stringBuilder.append('"');
              throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString(), numberFormatException);
            } 
          } else {
            throw new Descriptors.DescriptorValidationException(this, "Repeated fields cannot have default values.");
          } 
        } else if (isRepeated()) {
          this.defaultValue = Collections.emptyList();
        } else {
          int i = Descriptors.null.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getJavaType().ordinal()];
          if (i != 1) {
            if (i != 2) {
              this.defaultValue = (getJavaType()).defaultDefault;
            } else {
              this.defaultValue = null;
            } 
          } else {
            this.defaultValue = this.enumType.getValues().get(0);
          } 
        } 
        if (!isExtension())
          this.file.pool.addFieldByNumber(this); 
        Descriptors.Descriptor descriptor = this.containingType;
        if (descriptor != null && descriptor.getOptions().getMessageSetWireFormat()) {
          if (isExtension()) {
            if (isOptional() && getType() == Type.MESSAGE)
              return; 
            throw new Descriptors.DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.");
          } 
          throw new Descriptors.DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.");
        } 
        return;
      } 
      throw new Descriptors.DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.");
    }
    
    private static String fieldNameToJsonName(String param1String) {
      int j = param1String.length();
      StringBuilder stringBuilder = new StringBuilder(j);
      int i = 0;
      boolean bool = false;
      while (i < j) {
        char c = param1String.charAt(i);
        if (c == '_') {
          bool = true;
        } else if (bool) {
          char c1 = c;
          if ('a' <= c) {
            c1 = c;
            if (c <= 'z')
              c1 = (char)(c - 97 + 65); 
          } 
          stringBuilder.append(c1);
          bool = false;
        } else {
          stringBuilder.append(c);
        } 
        i++;
      } 
      return stringBuilder.toString();
    }
    
    private void setProto(DescriptorProtos.FieldDescriptorProto param1FieldDescriptorProto) {
      this.proto = param1FieldDescriptorProto;
    }
    
    public int compareTo(FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.containingType == this.containingType)
        return getNumber() - param1FieldDescriptor.getNumber(); 
      throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
    }
    
    public Descriptors.OneofDescriptor getContainingOneof() {
      return this.containingOneof;
    }
    
    public Descriptors.Descriptor getContainingType() {
      return this.containingType;
    }
    
    public Object getDefaultValue() {
      if (getJavaType() != JavaType.MESSAGE)
        return this.defaultValue; 
      throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
    }
    
    public Descriptors.EnumDescriptor getEnumType() {
      if (getJavaType() == JavaType.ENUM)
        return this.enumType; 
      throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", new Object[] { this.fullName }));
    }
    
    public Descriptors.Descriptor getExtensionScope() {
      if (isExtension())
        return this.extensionScope; 
      throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", new Object[] { this.fullName }));
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public int getIndex() {
      return this.index;
    }
    
    public JavaType getJavaType() {
      return this.type.getJavaType();
    }
    
    public String getJsonName() {
      return this.jsonName;
    }
    
    public WireFormat.JavaType getLiteJavaType() {
      return getLiteType().getJavaType();
    }
    
    public WireFormat.FieldType getLiteType() {
      return table[this.type.ordinal()];
    }
    
    public Descriptors.Descriptor getMessageType() {
      if (getJavaType() == JavaType.MESSAGE)
        return this.messageType; 
      throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", new Object[] { this.fullName }));
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public int getNumber() {
      return this.proto.getNumber();
    }
    
    public DescriptorProtos.FieldOptions getOptions() {
      return this.proto.getOptions();
    }
    
    public Descriptors.OneofDescriptor getRealContainingOneof() {
      Descriptors.OneofDescriptor oneofDescriptor = this.containingOneof;
      return (oneofDescriptor != null && !oneofDescriptor.isSynthetic()) ? this.containingOneof : null;
    }
    
    public Type getType() {
      return this.type;
    }
    
    public boolean hasDefaultValue() {
      return this.proto.hasDefaultValue();
    }
    
    public boolean hasOptionalKeyword() {
      return (this.isProto3Optional || (this.file.getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO2 && isOptional() && getContainingOneof() == null));
    }
    
    boolean hasPresence() {
      boolean bool1 = isRepeated();
      boolean bool = false;
      if (bool1)
        return false; 
      if (getType() == Type.MESSAGE || getType() == Type.GROUP || getContainingOneof() != null || this.file.getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO2)
        bool = true; 
      return bool;
    }
    
    public MessageLite.Builder internalMergeFrom(MessageLite.Builder param1Builder, MessageLite param1MessageLite) {
      return ((Message.Builder)param1Builder).mergeFrom((Message)param1MessageLite);
    }
    
    public boolean isExtension() {
      return this.proto.hasExtendee();
    }
    
    public boolean isMapField() {
      return (getType() == Type.MESSAGE && isRepeated() && getMessageType().getOptions().getMapEntry());
    }
    
    public boolean isOptional() {
      return (this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL);
    }
    
    public boolean isPackable() {
      return (isRepeated() && getLiteType().isPackable());
    }
    
    public boolean isPacked() {
      boolean bool1 = isPackable();
      boolean bool = false;
      if (!bool1)
        return false; 
      if (getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO2)
        return getOptions().getPacked(); 
      if (!getOptions().hasPacked() || getOptions().getPacked())
        bool = true; 
      return bool;
    }
    
    public boolean isRepeated() {
      return (this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED);
    }
    
    public boolean isRequired() {
      return (this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED);
    }
    
    public boolean needsUtf8Check() {
      return (this.type != Type.STRING) ? false : (getContainingType().getOptions().getMapEntry() ? true : ((getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO3) ? true : getFile().getOptions().getJavaStringCheckUtf8()));
    }
    
    public DescriptorProtos.FieldDescriptorProto toProto() {
      return this.proto;
    }
    
    public String toString() {
      return getFullName();
    }
    
    public enum JavaType {
      BOOLEAN,
      BYTE_STRING,
      DOUBLE,
      ENUM,
      FLOAT,
      INT((String)Integer.valueOf(0)),
      LONG((String)Long.valueOf(0L)),
      MESSAGE((String)Long.valueOf(0L)),
      STRING((String)Long.valueOf(0L));
      
      private final Object defaultDefault;
      
      static {
        BOOLEAN = new JavaType("BOOLEAN", 4, Boolean.valueOf(false));
        STRING = new JavaType("STRING", 5, "");
        BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
        ENUM = new JavaType("ENUM", 7, null);
        MESSAGE = new JavaType("MESSAGE", 8, null);
        $VALUES = new JavaType[] { INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE };
      }
      
      JavaType(Object param2Object) {
        this.defaultDefault = param2Object;
      }
    }
    
    public enum Type {
      DOUBLE((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
      ENUM((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
      FIXED32((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
      FIXED64((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
      BOOL((String)Long.valueOf(0L)),
      BYTES((String)Long.valueOf(0L)),
      FLOAT((String)Descriptors.FieldDescriptor.JavaType.FLOAT),
      GROUP((String)Descriptors.FieldDescriptor.JavaType.FLOAT),
      INT32((String)Descriptors.FieldDescriptor.JavaType.FLOAT),
      INT64((String)Descriptors.FieldDescriptor.JavaType.LONG),
      MESSAGE((String)Descriptors.FieldDescriptor.JavaType.LONG),
      SFIXED32((String)Descriptors.FieldDescriptor.JavaType.LONG),
      SFIXED64((String)Descriptors.FieldDescriptor.JavaType.LONG),
      SINT32((String)Descriptors.FieldDescriptor.JavaType.LONG),
      SINT64((String)Descriptors.FieldDescriptor.JavaType.LONG),
      STRING((String)Descriptors.FieldDescriptor.JavaType.LONG),
      UINT32((String)Descriptors.FieldDescriptor.JavaType.LONG),
      UINT64((String)Descriptors.FieldDescriptor.JavaType.LONG);
      
      private Descriptors.FieldDescriptor.JavaType javaType;
      
      static {
        FIXED32 = new Type("FIXED32", 6, Descriptors.FieldDescriptor.JavaType.INT);
        BOOL = new Type("BOOL", 7, Descriptors.FieldDescriptor.JavaType.BOOLEAN);
        STRING = new Type("STRING", 8, Descriptors.FieldDescriptor.JavaType.STRING);
        GROUP = new Type("GROUP", 9, Descriptors.FieldDescriptor.JavaType.MESSAGE);
        MESSAGE = new Type("MESSAGE", 10, Descriptors.FieldDescriptor.JavaType.MESSAGE);
        BYTES = new Type("BYTES", 11, Descriptors.FieldDescriptor.JavaType.BYTE_STRING);
        UINT32 = new Type("UINT32", 12, Descriptors.FieldDescriptor.JavaType.INT);
        ENUM = new Type("ENUM", 13, Descriptors.FieldDescriptor.JavaType.ENUM);
        SFIXED32 = new Type("SFIXED32", 14, Descriptors.FieldDescriptor.JavaType.INT);
        SFIXED64 = new Type("SFIXED64", 15, Descriptors.FieldDescriptor.JavaType.LONG);
        SINT32 = new Type("SINT32", 16, Descriptors.FieldDescriptor.JavaType.INT);
        SINT64 = new Type("SINT64", 17, Descriptors.FieldDescriptor.JavaType.LONG);
        $VALUES = new Type[] { 
            DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, 
            MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64 };
      }
      
      Type(Descriptors.FieldDescriptor.JavaType param2JavaType) {
        this.javaType = param2JavaType;
      }
      
      public Descriptors.FieldDescriptor.JavaType getJavaType() {
        return this.javaType;
      }
      
      public DescriptorProtos.FieldDescriptorProto.Type toProto() {
        return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
      }
    }
  }
  
  public enum JavaType {
    INT((String)Integer.valueOf(0)),
    LONG((String)Long.valueOf(0L)),
    MESSAGE((String)Long.valueOf(0L)),
    STRING((String)Long.valueOf(0L)),
    BOOLEAN((String)JavaType.LONG),
    BYTE_STRING((String)JavaType.LONG),
    DOUBLE((String)JavaType.LONG),
    ENUM((String)JavaType.LONG),
    FLOAT((String)JavaType.LONG);
    
    private final Object defaultDefault;
    
    static {
      DOUBLE = new JavaType("DOUBLE", 3, Double.valueOf(0.0D));
      BOOLEAN = new JavaType("BOOLEAN", 4, Boolean.valueOf(false));
      STRING = new JavaType("STRING", 5, "");
      BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
      ENUM = new JavaType("ENUM", 7, null);
      MESSAGE = new JavaType("MESSAGE", 8, null);
      $VALUES = new JavaType[] { INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, MESSAGE };
    }
    
    JavaType(Object param1Object) {
      this.defaultDefault = param1Object;
    }
  }
  
  public enum Type {
    DOUBLE((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
    ENUM((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
    FIXED32((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
    FIXED64((String)Descriptors.FieldDescriptor.JavaType.DOUBLE),
    BOOL((String)Long.valueOf(0L)),
    BYTES((String)Long.valueOf(0L)),
    FLOAT((String)Descriptors.FieldDescriptor.JavaType.FLOAT),
    GROUP((String)Descriptors.FieldDescriptor.JavaType.FLOAT),
    INT32((String)Descriptors.FieldDescriptor.JavaType.FLOAT),
    INT64((String)Descriptors.FieldDescriptor.JavaType.LONG),
    MESSAGE((String)Descriptors.FieldDescriptor.JavaType.LONG),
    SFIXED32((String)Descriptors.FieldDescriptor.JavaType.LONG),
    SFIXED64((String)Descriptors.FieldDescriptor.JavaType.LONG),
    SINT32((String)Descriptors.FieldDescriptor.JavaType.LONG),
    SINT64((String)Descriptors.FieldDescriptor.JavaType.LONG),
    STRING((String)Descriptors.FieldDescriptor.JavaType.LONG),
    UINT32((String)Descriptors.FieldDescriptor.JavaType.LONG),
    UINT64((String)Descriptors.FieldDescriptor.JavaType.LONG);
    
    private Descriptors.FieldDescriptor.JavaType javaType;
    
    static {
      FIXED64 = new Type("FIXED64", 5, Descriptors.FieldDescriptor.JavaType.LONG);
      FIXED32 = new Type("FIXED32", 6, Descriptors.FieldDescriptor.JavaType.INT);
      BOOL = new Type("BOOL", 7, Descriptors.FieldDescriptor.JavaType.BOOLEAN);
      STRING = new Type("STRING", 8, Descriptors.FieldDescriptor.JavaType.STRING);
      GROUP = new Type("GROUP", 9, Descriptors.FieldDescriptor.JavaType.MESSAGE);
      MESSAGE = new Type("MESSAGE", 10, Descriptors.FieldDescriptor.JavaType.MESSAGE);
      BYTES = new Type("BYTES", 11, Descriptors.FieldDescriptor.JavaType.BYTE_STRING);
      UINT32 = new Type("UINT32", 12, Descriptors.FieldDescriptor.JavaType.INT);
      ENUM = new Type("ENUM", 13, Descriptors.FieldDescriptor.JavaType.ENUM);
      SFIXED32 = new Type("SFIXED32", 14, Descriptors.FieldDescriptor.JavaType.INT);
      SFIXED64 = new Type("SFIXED64", 15, Descriptors.FieldDescriptor.JavaType.LONG);
      SINT32 = new Type("SINT32", 16, Descriptors.FieldDescriptor.JavaType.INT);
      SINT64 = new Type("SINT64", 17, Descriptors.FieldDescriptor.JavaType.LONG);
      $VALUES = new Type[] { 
          DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, 
          MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64 };
    }
    
    Type(Descriptors.FieldDescriptor.JavaType param1JavaType) {
      this.javaType = param1JavaType;
    }
    
    public Descriptors.FieldDescriptor.JavaType getJavaType() {
      return this.javaType;
    }
    
    public DescriptorProtos.FieldDescriptorProto.Type toProto() {
      return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
    }
  }
  
  public static final class FileDescriptor extends GenericDescriptor {
    private final FileDescriptor[] dependencies;
    
    private final Descriptors.EnumDescriptor[] enumTypes;
    
    private final Descriptors.FieldDescriptor[] extensions;
    
    private final Descriptors.Descriptor[] messageTypes;
    
    private final Descriptors.DescriptorPool pool;
    
    private DescriptorProtos.FileDescriptorProto proto;
    
    private final FileDescriptor[] publicDependencies;
    
    private final Descriptors.ServiceDescriptor[] services;
    
    private FileDescriptor(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto, FileDescriptor[] param1ArrayOfFileDescriptor, Descriptors.DescriptorPool param1DescriptorPool, boolean param1Boolean) throws Descriptors.DescriptorValidationException {
      StringBuilder stringBuilder;
      this.pool = param1DescriptorPool;
      this.proto = param1FileDescriptorProto;
      this.dependencies = (FileDescriptor[])param1ArrayOfFileDescriptor.clone();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      int j = param1ArrayOfFileDescriptor.length;
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++) {
        FileDescriptor fileDescriptor = param1ArrayOfFileDescriptor[i];
        hashMap.put(fileDescriptor.getName(), fileDescriptor);
      } 
      ArrayList<FileDescriptor> arrayList = new ArrayList();
      i = 0;
      while (i < param1FileDescriptorProto.getPublicDependencyCount()) {
        j = param1FileDescriptorProto.getPublicDependency(i);
        if (j >= 0 && j < param1FileDescriptorProto.getDependencyCount()) {
          String str = param1FileDescriptorProto.getDependency(j);
          FileDescriptor fileDescriptor = (FileDescriptor)hashMap.get(str);
          if (fileDescriptor == null) {
            if (!param1Boolean) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("Invalid public dependency: ");
              stringBuilder.append(str);
              throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
            } 
          } else {
            arrayList.add(fileDescriptor);
          } 
          i++;
          continue;
        } 
        throw new Descriptors.DescriptorValidationException(this, "Invalid public dependency index.");
      } 
      this.publicDependencies = new FileDescriptor[arrayList.size()];
      arrayList.toArray(this.publicDependencies);
      param1DescriptorPool.addPackage(getPackage(), this);
      this.messageTypes = new Descriptors.Descriptor[stringBuilder.getMessageTypeCount()];
      for (i = 0; i < stringBuilder.getMessageTypeCount(); i++)
        this.messageTypes[i] = new Descriptors.Descriptor(stringBuilder.getMessageType(i), this, null, i); 
      this.enumTypes = new Descriptors.EnumDescriptor[stringBuilder.getEnumTypeCount()];
      for (i = 0; i < stringBuilder.getEnumTypeCount(); i++)
        this.enumTypes[i] = new Descriptors.EnumDescriptor(stringBuilder.getEnumType(i), this, null, i); 
      this.services = new Descriptors.ServiceDescriptor[stringBuilder.getServiceCount()];
      for (i = 0; i < stringBuilder.getServiceCount(); i++)
        this.services[i] = new Descriptors.ServiceDescriptor(stringBuilder.getService(i), this, i); 
      this.extensions = new Descriptors.FieldDescriptor[stringBuilder.getExtensionCount()];
      for (i = bool; i < stringBuilder.getExtensionCount(); i++)
        this.extensions[i] = new Descriptors.FieldDescriptor(stringBuilder.getExtension(i), this, null, i, true); 
    }
    
    FileDescriptor(String param1String, Descriptors.Descriptor param1Descriptor) throws Descriptors.DescriptorValidationException {
      this.pool = new Descriptors.DescriptorPool(new FileDescriptor[0], true);
      DescriptorProtos.FileDescriptorProto.Builder builder = DescriptorProtos.FileDescriptorProto.newBuilder();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1Descriptor.getFullName());
      stringBuilder.append(".placeholder.proto");
      this.proto = builder.setName(stringBuilder.toString()).setPackage(param1String).addMessageType(param1Descriptor.toProto()).build();
      this.dependencies = new FileDescriptor[0];
      this.publicDependencies = new FileDescriptor[0];
      this.messageTypes = new Descriptors.Descriptor[] { param1Descriptor };
      this.enumTypes = new Descriptors.EnumDescriptor[0];
      this.services = new Descriptors.ServiceDescriptor[0];
      this.extensions = new Descriptors.FieldDescriptor[0];
      this.pool.addPackage(param1String, this);
      this.pool.addSymbol(param1Descriptor);
    }
    
    public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto, FileDescriptor[] param1ArrayOfFileDescriptor) throws Descriptors.DescriptorValidationException {
      return buildFrom(param1FileDescriptorProto, param1ArrayOfFileDescriptor, false);
    }
    
    public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto, FileDescriptor[] param1ArrayOfFileDescriptor, boolean param1Boolean) throws Descriptors.DescriptorValidationException {
      FileDescriptor fileDescriptor = new FileDescriptor(param1FileDescriptorProto, param1ArrayOfFileDescriptor, new Descriptors.DescriptorPool(param1ArrayOfFileDescriptor, param1Boolean), param1Boolean);
      fileDescriptor.crossLink();
      return fileDescriptor;
    }
    
    private void crossLink() throws Descriptors.DescriptorValidationException {
      Descriptors.Descriptor[] arrayOfDescriptor = this.messageTypes;
      int j = arrayOfDescriptor.length;
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++)
        arrayOfDescriptor[i].crossLink(); 
      Descriptors.ServiceDescriptor[] arrayOfServiceDescriptor = this.services;
      j = arrayOfServiceDescriptor.length;
      for (i = 0; i < j; i++)
        arrayOfServiceDescriptor[i].crossLink(); 
      Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.extensions;
      j = arrayOfFieldDescriptor.length;
      for (i = bool; i < j; i++)
        arrayOfFieldDescriptor[i].crossLink(); 
    }
    
    private static FileDescriptor[] findDescriptors(Class<?> param1Class, String[] param1ArrayOfString1, String[] param1ArrayOfString2) {
      ArrayList<FileDescriptor> arrayList = new ArrayList();
      int i = 0;
      while (true) {
        if (i < param1ArrayOfString1.length) {
          try {
            arrayList.add((FileDescriptor)param1Class.getClassLoader().loadClass(param1ArrayOfString1[i]).getField("descriptor").get(null));
          } catch (Exception exception) {
            Logger logger = Descriptors.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Descriptors for \"");
            stringBuilder.append(param1ArrayOfString2[i]);
            stringBuilder.append("\" can not be found.");
            logger.warning(stringBuilder.toString());
          } 
          i++;
          continue;
        } 
        return arrayList.<FileDescriptor>toArray(new FileDescriptor[0]);
      } 
    }
    
    public static FileDescriptor internalBuildGeneratedFileFrom(String[] param1ArrayOfString1, Class<?> param1Class, String[] param1ArrayOfString2, String[] param1ArrayOfString3) {
      return internalBuildGeneratedFileFrom(param1ArrayOfString1, findDescriptors(param1Class, param1ArrayOfString2, param1ArrayOfString3));
    }
    
    public static FileDescriptor internalBuildGeneratedFileFrom(String[] param1ArrayOfString, FileDescriptor[] param1ArrayOfFileDescriptor) {
      byte[] arrayOfByte = latin1Cat(param1ArrayOfString);
      try {
        DescriptorProtos.FileDescriptorProto fileDescriptorProto = DescriptorProtos.FileDescriptorProto.parseFrom(arrayOfByte);
        try {
          return buildFrom(fileDescriptorProto, param1ArrayOfFileDescriptor, true);
        } catch (DescriptorValidationException descriptorValidationException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid embedded descriptor for \"");
          stringBuilder.append(fileDescriptorProto.getName());
          stringBuilder.append("\".");
          throw new IllegalArgumentException(stringBuilder.toString(), descriptorValidationException);
        } 
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", invalidProtocolBufferException);
      } 
    }
    
    @Deprecated
    public static void internalBuildGeneratedFileFrom(String[] param1ArrayOfString1, Class<?> param1Class, String[] param1ArrayOfString2, String[] param1ArrayOfString3, InternalDescriptorAssigner param1InternalDescriptorAssigner) {
      internalBuildGeneratedFileFrom(param1ArrayOfString1, findDescriptors(param1Class, param1ArrayOfString2, param1ArrayOfString3), param1InternalDescriptorAssigner);
    }
    
    @Deprecated
    public static void internalBuildGeneratedFileFrom(String[] param1ArrayOfString, FileDescriptor[] param1ArrayOfFileDescriptor, InternalDescriptorAssigner param1InternalDescriptorAssigner) {
      byte[] arrayOfByte = latin1Cat(param1ArrayOfString);
      try {
        DescriptorProtos.FileDescriptorProto fileDescriptorProto = DescriptorProtos.FileDescriptorProto.parseFrom(arrayOfByte);
        try {
          FileDescriptor fileDescriptor = buildFrom(fileDescriptorProto, param1ArrayOfFileDescriptor, true);
          ExtensionRegistry extensionRegistry = param1InternalDescriptorAssigner.assignDescriptors(fileDescriptor);
          if (extensionRegistry != null)
            try {
              DescriptorProtos.FileDescriptorProto fileDescriptorProto1 = DescriptorProtos.FileDescriptorProto.parseFrom(arrayOfByte, extensionRegistry);
              fileDescriptor.setProto(fileDescriptorProto1);
              return;
            } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
              throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", invalidProtocolBufferException);
            }  
          return;
        } catch (DescriptorValidationException descriptorValidationException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid embedded descriptor for \"");
          stringBuilder.append(invalidProtocolBufferException.getName());
          stringBuilder.append("\".");
          throw new IllegalArgumentException(stringBuilder.toString(), descriptorValidationException);
        } 
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", invalidProtocolBufferException);
      } 
    }
    
    public static void internalUpdateFileDescriptor(FileDescriptor param1FileDescriptor, ExtensionRegistry param1ExtensionRegistry) {
      ByteString byteString = param1FileDescriptor.proto.toByteString();
      try {
        DescriptorProtos.FileDescriptorProto fileDescriptorProto = DescriptorProtos.FileDescriptorProto.parseFrom(byteString, param1ExtensionRegistry);
        param1FileDescriptor.setProto(fileDescriptorProto);
        return;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", invalidProtocolBufferException);
      } 
    }
    
    private static byte[] latin1Cat(String[] param1ArrayOfString) {
      int j = param1ArrayOfString.length;
      int i = 0;
      if (j == 1)
        return param1ArrayOfString[0].getBytes(Internal.ISO_8859_1); 
      StringBuilder stringBuilder = new StringBuilder();
      j = param1ArrayOfString.length;
      while (i < j) {
        stringBuilder.append(param1ArrayOfString[i]);
        i++;
      } 
      return stringBuilder.toString().getBytes(Internal.ISO_8859_1);
    }
    
    private void setProto(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      this.proto = param1FileDescriptorProto;
      byte b = 0;
      int i = 0;
      while (true) {
        Descriptors.Descriptor[] arrayOfDescriptor = this.messageTypes;
        if (i < arrayOfDescriptor.length) {
          arrayOfDescriptor[i].setProto(param1FileDescriptorProto.getMessageType(i));
          i++;
          continue;
        } 
        i = 0;
        while (true) {
          int j;
          Descriptors.EnumDescriptor[] arrayOfEnumDescriptor = this.enumTypes;
          if (i < arrayOfEnumDescriptor.length) {
            arrayOfEnumDescriptor[i].setProto(param1FileDescriptorProto.getEnumType(i));
            i++;
            continue;
          } 
          i = 0;
          while (true) {
            Descriptors.ServiceDescriptor[] arrayOfServiceDescriptor = this.services;
            j = b;
            if (i < arrayOfServiceDescriptor.length) {
              arrayOfServiceDescriptor[i].setProto(param1FileDescriptorProto.getService(i));
              i++;
              continue;
            } 
            break;
          } 
          while (true) {
            Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.extensions;
            if (j < arrayOfFieldDescriptor.length) {
              arrayOfFieldDescriptor[j].setProto(param1FileDescriptorProto.getExtension(j));
              j++;
              continue;
            } 
            break;
          } 
          return;
        } 
        break;
      } 
    }
    
    public Descriptors.EnumDescriptor findEnumTypeByName(String param1String) {
      if (param1String.indexOf('.') != -1)
        return null; 
      String str2 = getPackage();
      String str1 = param1String;
      if (!str2.isEmpty()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('.');
        stringBuilder.append(param1String);
        str1 = stringBuilder.toString();
      } 
      Descriptors.GenericDescriptor genericDescriptor = this.pool.findSymbol(str1);
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.EnumDescriptor && genericDescriptor.getFile() == this) ? (Descriptors.EnumDescriptor)genericDescriptor : null;
    }
    
    public Descriptors.FieldDescriptor findExtensionByName(String param1String) {
      if (param1String.indexOf('.') != -1)
        return null; 
      String str2 = getPackage();
      String str1 = param1String;
      if (!str2.isEmpty()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('.');
        stringBuilder.append(param1String);
        str1 = stringBuilder.toString();
      } 
      Descriptors.GenericDescriptor genericDescriptor = this.pool.findSymbol(str1);
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.FieldDescriptor && genericDescriptor.getFile() == this) ? (Descriptors.FieldDescriptor)genericDescriptor : null;
    }
    
    public Descriptors.Descriptor findMessageTypeByName(String param1String) {
      if (param1String.indexOf('.') != -1)
        return null; 
      String str2 = getPackage();
      String str1 = param1String;
      if (!str2.isEmpty()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('.');
        stringBuilder.append(param1String);
        str1 = stringBuilder.toString();
      } 
      Descriptors.GenericDescriptor genericDescriptor = this.pool.findSymbol(str1);
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.Descriptor && genericDescriptor.getFile() == this) ? (Descriptors.Descriptor)genericDescriptor : null;
    }
    
    public Descriptors.ServiceDescriptor findServiceByName(String param1String) {
      if (param1String.indexOf('.') != -1)
        return null; 
      String str2 = getPackage();
      String str1 = param1String;
      if (!str2.isEmpty()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('.');
        stringBuilder.append(param1String);
        str1 = stringBuilder.toString();
      } 
      Descriptors.GenericDescriptor genericDescriptor = this.pool.findSymbol(str1);
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.ServiceDescriptor && genericDescriptor.getFile() == this) ? (Descriptors.ServiceDescriptor)genericDescriptor : null;
    }
    
    public List<FileDescriptor> getDependencies() {
      return Collections.unmodifiableList(Arrays.asList(this.dependencies));
    }
    
    public List<Descriptors.EnumDescriptor> getEnumTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
    }
    
    public List<Descriptors.FieldDescriptor> getExtensions() {
      return Collections.unmodifiableList(Arrays.asList(this.extensions));
    }
    
    public FileDescriptor getFile() {
      return this;
    }
    
    public String getFullName() {
      return this.proto.getName();
    }
    
    public List<Descriptors.Descriptor> getMessageTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public DescriptorProtos.FileOptions getOptions() {
      return this.proto.getOptions();
    }
    
    public String getPackage() {
      return this.proto.getPackage();
    }
    
    public List<FileDescriptor> getPublicDependencies() {
      return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
    }
    
    public List<Descriptors.ServiceDescriptor> getServices() {
      return Collections.unmodifiableList(Arrays.asList(this.services));
    }
    
    public Syntax getSyntax() {
      return Syntax.PROTO3.name.equals(this.proto.getSyntax()) ? Syntax.PROTO3 : Syntax.PROTO2;
    }
    
    boolean supportsUnknownEnumValue() {
      return (getSyntax() == Syntax.PROTO3);
    }
    
    public DescriptorProtos.FileDescriptorProto toProto() {
      return this.proto;
    }
    
    @Deprecated
    public static interface InternalDescriptorAssigner {
      ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param2FileDescriptor);
    }
    
    public enum Syntax {
      UNKNOWN("unknown"),
      PROTO2((String)Descriptors.FieldDescriptor.JavaType.LONG),
      PROTO3((String)Descriptors.FieldDescriptor.JavaType.LONG);
      
      private final String name;
      
      static {
      
      }
      
      Syntax(String param2String1) {
        this.name = param2String1;
      }
    }
  }
  
  @Deprecated
  public static interface InternalDescriptorAssigner {
    ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor);
  }
  
  public enum Syntax {
    PROTO2("unknown"),
    PROTO3("unknown"),
    UNKNOWN("unknown");
    
    private final String name;
    
    static {
      $VALUES = new Syntax[] { UNKNOWN, PROTO2, PROTO3 };
    }
    
    Syntax(String param1String1) {
      this.name = param1String1;
    }
  }
  
  public static abstract class GenericDescriptor {
    private GenericDescriptor() {}
    
    public abstract Descriptors.FileDescriptor getFile();
    
    public abstract String getFullName();
    
    public abstract String getName();
    
    public abstract Message toProto();
  }
  
  public static final class MethodDescriptor extends GenericDescriptor {
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final int index;
    
    private Descriptors.Descriptor inputType;
    
    private Descriptors.Descriptor outputType;
    
    private DescriptorProtos.MethodDescriptorProto proto;
    
    private final Descriptors.ServiceDescriptor service;
    
    private MethodDescriptor(DescriptorProtos.MethodDescriptorProto param1MethodDescriptorProto, Descriptors.FileDescriptor param1FileDescriptor, Descriptors.ServiceDescriptor param1ServiceDescriptor, int param1Int) throws Descriptors.DescriptorValidationException {
      this.index = param1Int;
      this.proto = param1MethodDescriptorProto;
      this.file = param1FileDescriptor;
      this.service = param1ServiceDescriptor;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1ServiceDescriptor.getFullName());
      stringBuilder.append('.');
      stringBuilder.append(param1MethodDescriptorProto.getName());
      this.fullName = stringBuilder.toString();
      param1FileDescriptor.pool.addSymbol(this);
    }
    
    private void crossLink() throws Descriptors.DescriptorValidationException {
      Descriptors.GenericDescriptor genericDescriptor = this.file.pool.lookupSymbol(this.proto.getInputType(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
      if (genericDescriptor instanceof Descriptors.Descriptor) {
        this.inputType = (Descriptors.Descriptor)genericDescriptor;
        genericDescriptor = this.file.pool.lookupSymbol(this.proto.getOutputType(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
        if (genericDescriptor instanceof Descriptors.Descriptor) {
          this.outputType = (Descriptors.Descriptor)genericDescriptor;
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append('"');
        stringBuilder1.append(this.proto.getOutputType());
        stringBuilder1.append("\" is not a message type.");
        throw new Descriptors.DescriptorValidationException(this, stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append('"');
      stringBuilder.append(this.proto.getInputType());
      stringBuilder.append("\" is not a message type.");
      throw new Descriptors.DescriptorValidationException(this, stringBuilder.toString());
    }
    
    private void setProto(DescriptorProtos.MethodDescriptorProto param1MethodDescriptorProto) {
      this.proto = param1MethodDescriptorProto;
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public int getIndex() {
      return this.index;
    }
    
    public Descriptors.Descriptor getInputType() {
      return this.inputType;
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public DescriptorProtos.MethodOptions getOptions() {
      return this.proto.getOptions();
    }
    
    public Descriptors.Descriptor getOutputType() {
      return this.outputType;
    }
    
    public Descriptors.ServiceDescriptor getService() {
      return this.service;
    }
    
    public boolean isClientStreaming() {
      return this.proto.getClientStreaming();
    }
    
    public boolean isServerStreaming() {
      return this.proto.getServerStreaming();
    }
    
    public DescriptorProtos.MethodDescriptorProto toProto() {
      return this.proto;
    }
  }
  
  public static final class OneofDescriptor extends GenericDescriptor {
    private Descriptors.Descriptor containingType;
    
    private int fieldCount;
    
    private Descriptors.FieldDescriptor[] fields;
    
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final int index;
    
    private DescriptorProtos.OneofDescriptorProto proto;
    
    private OneofDescriptor(DescriptorProtos.OneofDescriptorProto param1OneofDescriptorProto, Descriptors.FileDescriptor param1FileDescriptor, Descriptors.Descriptor param1Descriptor, int param1Int) throws Descriptors.DescriptorValidationException {
      this.proto = param1OneofDescriptorProto;
      this.fullName = Descriptors.computeFullName(param1FileDescriptor, param1Descriptor, param1OneofDescriptorProto.getName());
      this.file = param1FileDescriptor;
      this.index = param1Int;
      this.containingType = param1Descriptor;
      this.fieldCount = 0;
    }
    
    private void setProto(DescriptorProtos.OneofDescriptorProto param1OneofDescriptorProto) {
      this.proto = param1OneofDescriptorProto;
    }
    
    public Descriptors.Descriptor getContainingType() {
      return this.containingType;
    }
    
    public Descriptors.FieldDescriptor getField(int param1Int) {
      return this.fields[param1Int];
    }
    
    public int getFieldCount() {
      return this.fieldCount;
    }
    
    public List<Descriptors.FieldDescriptor> getFields() {
      return Collections.unmodifiableList(Arrays.asList(this.fields));
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public int getIndex() {
      return this.index;
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public DescriptorProtos.OneofOptions getOptions() {
      return this.proto.getOptions();
    }
    
    public boolean isSynthetic() {
      Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.fields;
      int i = arrayOfFieldDescriptor.length;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (i == 1) {
        bool1 = bool2;
        if ((arrayOfFieldDescriptor[0]).isProto3Optional)
          bool1 = true; 
      } 
      return bool1;
    }
    
    public DescriptorProtos.OneofDescriptorProto toProto() {
      return this.proto;
    }
  }
  
  public static final class ServiceDescriptor extends GenericDescriptor {
    private final Descriptors.FileDescriptor file;
    
    private final String fullName;
    
    private final int index;
    
    private Descriptors.MethodDescriptor[] methods;
    
    private DescriptorProtos.ServiceDescriptorProto proto;
    
    private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto param1ServiceDescriptorProto, Descriptors.FileDescriptor param1FileDescriptor, int param1Int) throws Descriptors.DescriptorValidationException {
      this.index = param1Int;
      this.proto = param1ServiceDescriptorProto;
      this.fullName = Descriptors.computeFullName(param1FileDescriptor, null, param1ServiceDescriptorProto.getName());
      this.file = param1FileDescriptor;
      this.methods = new Descriptors.MethodDescriptor[param1ServiceDescriptorProto.getMethodCount()];
      for (param1Int = 0; param1Int < param1ServiceDescriptorProto.getMethodCount(); param1Int++)
        this.methods[param1Int] = new Descriptors.MethodDescriptor(param1ServiceDescriptorProto.getMethod(param1Int), param1FileDescriptor, this, param1Int); 
      param1FileDescriptor.pool.addSymbol(this);
    }
    
    private void crossLink() throws Descriptors.DescriptorValidationException {
      Descriptors.MethodDescriptor[] arrayOfMethodDescriptor = this.methods;
      int j = arrayOfMethodDescriptor.length;
      for (int i = 0; i < j; i++)
        arrayOfMethodDescriptor[i].crossLink(); 
    }
    
    private void setProto(DescriptorProtos.ServiceDescriptorProto param1ServiceDescriptorProto) {
      this.proto = param1ServiceDescriptorProto;
      int i = 0;
      while (true) {
        Descriptors.MethodDescriptor[] arrayOfMethodDescriptor = this.methods;
        if (i < arrayOfMethodDescriptor.length) {
          arrayOfMethodDescriptor[i].setProto(param1ServiceDescriptorProto.getMethod(i));
          i++;
          continue;
        } 
        break;
      } 
    }
    
    public Descriptors.MethodDescriptor findMethodByName(String param1String) {
      Descriptors.DescriptorPool descriptorPool = this.file.pool;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.fullName);
      stringBuilder.append('.');
      stringBuilder.append(param1String);
      Descriptors.GenericDescriptor genericDescriptor = descriptorPool.findSymbol(stringBuilder.toString());
      return (genericDescriptor != null && genericDescriptor instanceof Descriptors.MethodDescriptor) ? (Descriptors.MethodDescriptor)genericDescriptor : null;
    }
    
    public Descriptors.FileDescriptor getFile() {
      return this.file;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public int getIndex() {
      return this.index;
    }
    
    public List<Descriptors.MethodDescriptor> getMethods() {
      return Collections.unmodifiableList(Arrays.asList(this.methods));
    }
    
    public String getName() {
      return this.proto.getName();
    }
    
    public DescriptorProtos.ServiceOptions getOptions() {
      return this.proto.getOptions();
    }
    
    public DescriptorProtos.ServiceDescriptorProto toProto() {
      return this.proto;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Descriptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */