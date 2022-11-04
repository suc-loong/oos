////调试表原始对象
//{
//        "title":"调试：com.intellij.database.psi.DbTableImpl",
//        "methodList":[{
//        "name":"isSystem",
//        "desc":"public boolean com.intellij.database.psi.DbTableImpl.isSystem()",
//        "value":"false"
//        },{
//        "name":"isTemporary",
//        "desc":"public boolean com.intellij.database.psi.DbTableImpl.isTemporary()",
//        "value":"false"
//        },{
//        "name":"getDocumentation",
//        "desc":"public java.lang.CharSequence com.intellij.database.psi.DbTableImpl.getDocumentation(boolean)",
//        "value":null
//        },{
//        "name":"getDocumentation",
//        "desc":"public java.lang.StringBuilder com.intellij.database.psi.DbTableImpl.getDocumentation(boolean)",
//        "value":null
//        },{
//        "name":"getColumnAttrs",
//        "desc":"public java.util.Set<com.intellij.database.model.DasColumn$Attribute> com.intellij.database.psi.DbTableImpl.getColumnAttrs(com.intellij.database.model.DasColumn)",
//        "value":null
//        },{
//        "name":"getName",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getName(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getName",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getName()",
//        "value":"me_infos"
//        },{
//        "name":"getTypeName",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getTypeName()",
//        "value":"table"
//        },{
//        "name":"getParent",
//        "desc":"public com.intellij.database.psi.DbElement com.intellij.database.psi.DbElementImpl.getParent()",
//        "value":"hc_manager: schema"
//        },{
//        "name":"getParent",
//        "desc":"public com.intellij.psi.PsiFileSystemItem com.intellij.database.psi.DbElementImpl.getParent()",
//        "value":"hc_manager: schema"
//        },{
//        "name":"getParent",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.database.psi.DbElementImpl.getParent()",
//        "value":"hc_manager: schema"
//        },{
//        "name":"init",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.init(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"setName",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.database.psi.DbElementImpl.setName(java.lang.String) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"getLanguage",
//        "desc":"public com.intellij.lang.Language com.intellij.database.psi.DbElementImpl.getLanguage()",
//        "value":"Language: SQL"
//        },{
//        "name":"isDirectory",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isDirectory()",
//        "value":"false"
//        },{
//        "name":"getComment",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getComment()",
//        "value":null
//        },{
//        "name":"isWritable",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isWritable()",
//        "value":"true"
//        },{
//        "name":"isValid",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isValid()",
//        "value":"true"
//        },{
//        "name":"getChildren",
//        "desc":"public com.intellij.psi.PsiElement[] com.intellij.database.psi.DbElementImpl.getChildren()",
//        "value":"[Lcom.intellij.psi.PsiElement;@725a6af3"
//        },{
//        "name":"getPosition",
//        "desc":"public short com.intellij.database.psi.DbElementImpl.getPosition()",
//        "value":"0"
//        },{
//        "name":"getText",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getText()",
//        "value":"create table me_infos\n(\n    elmt_no          int(10)                        not null\n        primary key,\n    uuid             varchar(50)  default ''        not null comment '厂家保证唯一性，建议用 MAC 地址',\n    elmt_name        varchar(50)  default ''        not null comment '网元名称',\n    manufacturer     varchar(32)  default ''        not null comment '网元厂商名称，长度范围是 1～32',\n    elmt_alias       varchar(50)  default ''        not null comment '网元别名',\n    elmt_type        tinyint(3)   default 0         not null comment '网元类型',\n    elmt_spec        varchar(50)  default ''        not null comment '网元型号',\n    software_version varchar(50)  default ''        not null comment '软件版本',\n    hardware_version varchar(50)  default ''        not null comment '硬件版本',\n    ip_address       varchar(50)  default '0.0.0.0' not null comment '网元IP，无则填0.0.0.0',\n    status           tinyint(1)   default 0         not null comment '网元状态（Installing、Running、Maintenance）',\n    power_mode       tinyint(1)   default 0         not null comment '网元/子架供电方式（0:220V AC/ 1:48V DC）',\n    work_mode        tinyint(1)   default 0         not null comment '网元/子架风扇工作模式',\n    location         varchar(255) default ''        not null comment '市县、机房',\n    rack             varchar(50)  default ''        not null comment '机架',\n    holder           varchar(50)  default ''        not null comment '子架',\n    longitude        decimal(6, 2)                  null comment '经度',\n    latitude         decimal(6, 2)                  null comment '纬度',\n    parent_elmt_no   int(6)       default 0         not null comment '父网元号',\n    create_datetime  datetime                       null comment '创建时间',\n    create_user      varchar(100) default ''        not null comment '网元创建用户',\n    left_topx        int(5)       default 0         null comment '网元在视图左上角X坐标',\n    left_topy        int(5)       default 0         null comment '网元在视图左上角Y坐标',\n    elmt_remarks     varchar(100) default ''        not null comment '网元备注'\n);\n\n"
//        },{
//        "name":"getIcon",
//        "desc":"public javax.swing.Icon com.intellij.database.psi.DbElementImpl.getIcon()",
//        "value":"Deferred. Base=Row icon. myIcons=[IconWrapperWithTooltip:jar:file:/D:/Program%20Files/JetBrains/IntelliJ%20IDEA%202020.2.3/plugins/DatabaseTools/lib/database-openapi.jar!/icons/table.svg, null]"
//        },{
//        "name":"getIcon",
//        "desc":"public javax.swing.Icon com.intellij.database.psi.DbElementImpl.getIcon(boolean)",
//        "value":null
//        },{
//        "name":"getDelegate",
//        "desc":"public D com.intellij.database.psi.DbElementImpl.getDelegate()",
//        "value":"me_infos: table"
//        },{
//        "name":"getWeight",
//        "desc":"public int com.intellij.database.psi.DbElementImpl.getWeight()",
//        "value":"10000"
//        },{
//        "name":"getManager",
//        "desc":"public com.intellij.psi.PsiManager com.intellij.database.psi.DbElementImpl.getManager()",
//        "value":"com.intellij.psi.impl.PsiManagerImpl@15c8ad23"
//        },{
//        "name":"getMetaData",
//        "desc":"public com.intellij.psi.meta.PsiMetaData com.intellij.database.psi.DbElementImpl.getMetaData()",
//        "value":"me_infos: table"
//        },{
//        "name":"processChildren",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.processChildren(com.intellij.psi.search.PsiElementProcessor<com.intellij.psi.PsiFileSystemItem>)",
//        "value":null
//        },{
//        "name":"getBaseIcon",
//        "desc":"public javax.swing.Icon com.intellij.database.psi.DbElementImpl.getBaseIcon()",
//        "value":"IconWrapperWithTooltip:jar:file:/D:/Program%20Files/JetBrains/IntelliJ%20IDEA%202020.2.3/plugins/DatabaseTools/lib/database-openapi.jar!/icons/table.svg"
//        },{
//        "name":"getProject",
//        "desc":"public com.intellij.openapi.project.Project com.intellij.database.psi.DbElementImpl.getProject()",
//        "value":"Project(name=oos_dev, containerState=ACTIVE, componentStore=E:\\test\\odl_otn_system\\oos_dev)"
//        },{
//        "name":"getDeclaration",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.database.psi.DbElementImpl.getDeclaration()",
//        "value":"me_infos: table"
//        },{
//        "name":"getKind",
//        "desc":"public com.intellij.database.model.ObjectKind com.intellij.database.psi.DbElementImpl.getKind()",
//        "value":"table"
//        },{
//        "name":"getVirtualFile",
//        "desc":"public com.intellij.openapi.vfs.VirtualFile com.intellij.database.psi.DbElementImpl.getVirtualFile()",
//        "value":"DB VirtualFile: table, hc_manager.me_infos [hc_manager@localhost] (Valid)"
//        },{
//        "name":"isCaseSensitive",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isCaseSensitive()",
//        "value":"false"
//        },{
//        "name":"isQuoted",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isQuoted()",
//        "value":"true"
//        },{
//        "name":"navigate",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.navigate(boolean,java.lang.String[],com.intellij.database.util.DbImplUtil$TriConsumer<com.intellij.database.util.DdlBuilder, java.util.List<com.intellij.database.model.DasColumn>, com.intellij.database.Dbms>)",
//        "value":null
//        },{
//        "name":"navigate",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.navigate(boolean,java.lang.String[],boolean,com.intellij.database.util.DbImplUtil$TriConsumer<com.intellij.database.util.DdlBuilder, java.util.List<com.intellij.database.model.DasColumn>, com.intellij.database.Dbms>)",
//        "value":null
//        },{
//        "name":"navigate",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.navigate(boolean)",
//        "value":null
//        },{
//        "name":"checkSetName",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.checkSetName(java.lang.String) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"canNavigate",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.canNavigate()",
//        "value":null
//        },{
//        "name":"acceptChildren",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.acceptChildren(com.intellij.psi.PsiElementVisitor)",
//        "value":null
//        },{
//        "name":"processDeclarations",
//        "desc":"public final boolean com.intellij.database.psi.DbElementImpl.processDeclarations(com.intellij.database.model.DasScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"canNavigateToSource",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.canNavigateToSource()",
//        "value":null
//        },{
//        "name":"getDataSource",
//        "desc":"public com.intellij.database.psi.DbDataSource com.intellij.database.psi.DbElementImpl.getDataSource()",
//        "value":"hc_manager@localhost: root"
//        },{
//        "name":"getDataSource",
//        "desc":"public com.intellij.database.psi.DbDataSourceImpl com.intellij.database.psi.DbElementImpl.getDataSource()",
//        "value":"hc_manager@localhost: root"
//        },{
//        "name":"getLocationString",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getLocationString()",
//        "value":"hc_manager [hc_manager@localhost]"
//        },{
//        "name":"getDasChildren",
//        "desc":"public com.intellij.util.containers.JBIterable<com.intellij.database.psi.DbElement> com.intellij.database.psi.DbElementImpl.getDasChildren(com.intellij.database.model.ObjectKind)",
//        "value":null
//        },{
//        "name":"getDasParent",
//        "desc":"public P com.intellij.database.psi.DbElementImpl.getDasParent()",
//        "value":"hc_manager: schema"
//        },{
//        "name":"getDasParent",
//        "desc":"public com.intellij.database.model.DasObject com.intellij.database.psi.DbElementImpl.getDasParent()",
//        "value":"hc_manager: schema"
//        },{
//        "name":"newDeclarationProcessor",
//        "desc":"public static com.intellij.util.Processor<com.intellij.database.psi.DbElement> com.intellij.database.psi.DbElementImpl.newDeclarationProcessor(com.intellij.database.model.DasScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"createDeclarationProcessor",
//        "desc":"public com.intellij.util.Processor<com.intellij.database.psi.DbElement> com.intellij.database.psi.DbElementImpl.createDeclarationProcessor(com.intellij.database.model.DasScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getNode",
//        "desc":"public com.intellij.lang.ASTNode com.intellij.psi.impl.FakePsiElement.getNode()",
//        "value":null
//        },{
//        "name":"getTextLength",
//        "desc":"public int com.intellij.psi.impl.FakePsiElement.getTextLength()",
//        "value":"0"
//        },{
//        "name":"getIcon",
//        "desc":"public final javax.swing.Icon com.intellij.psi.impl.FakePsiElement.getIcon(int)",
//        "value":null
//        },{
//        "name":"getFirstChild",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getFirstChild()",
//        "value":null
//        },{
//        "name":"getLastChild",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getLastChild()",
//        "value":null
//        },{
//        "name":"getNextSibling",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getNextSibling()",
//        "value":null
//        },{
//        "name":"getTextOffset",
//        "desc":"public int com.intellij.psi.impl.FakePsiElement.getTextOffset()",
//        "value":"0"
//        },{
//        "name":"getPresentation",
//        "desc":"public com.intellij.navigation.ItemPresentation com.intellij.psi.impl.FakePsiElement.getPresentation()",
//        "value":"me_infos: table"
//        },{
//        "name":"isPhysical",
//        "desc":"public boolean com.intellij.psi.impl.FakePsiElement.isPhysical()",
//        "value":"false"
//        },{
//        "name":"getPresentableText",
//        "desc":"public java.lang.String com.intellij.psi.impl.FakePsiElement.getPresentableText()",
//        "value":"me_infos"
//        },{
//        "name":"findElementAt",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.findElementAt(int)",
//        "value":null
//        },{
//        "name":"getTextRange",
//        "desc":"public com.intellij.openapi.util.TextRange com.intellij.psi.impl.FakePsiElement.getTextRange()",
//        "value":null
//        },{
//        "name":"textContains",
//        "desc":"public boolean com.intellij.psi.impl.FakePsiElement.textContains(char)",
//        "value":null
//        },{
//        "name":"textToCharArray",
//        "desc":"public char[] com.intellij.psi.impl.FakePsiElement.textToCharArray()",
//        "value":null
//        },{
//        "name":"getPrevSibling",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getPrevSibling()",
//        "value":null
//        },{
//        "name":"getStartOffsetInParent",
//        "desc":"public int com.intellij.psi.impl.FakePsiElement.getStartOffsetInParent()",
//        "value":"0"
//        },{
//        "name":"add",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.add(com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"replace",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.replace(com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"checkDelete",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.checkDelete() throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"delete",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.delete() throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"accept",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.accept(com.intellij.psi.PsiElementVisitor)",
//        "value":null
//        },{
//        "name":"getContext",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.getContext()",
//        "value":"hc_manager: schema"
//        },{
//        "name":"copy",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.copy()",
//        "value":null
//        },{
//        "name":"addRange",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addRange(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"addAfter",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addAfter(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"addBefore",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addBefore(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"textMatches",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.textMatches(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"textMatches",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.textMatches(java.lang.CharSequence)",
//        "value":null
//        },{
//        "name":"getReferences",
//        "desc":"public com.intellij.psi.PsiReference[] com.intellij.psi.impl.PsiElementBase.getReferences()",
//        "value":"[Lcom.intellij.psi.PsiReference;@60f5b628"
//        },{
//        "name":"getUseScope",
//        "desc":"public com.intellij.psi.search.SearchScope com.intellij.psi.impl.PsiElementBase.getUseScope()",
//        "value":"Project and Libraries"
//        },{
//        "name":"findReferenceAt",
//        "desc":"public com.intellij.psi.PsiReference com.intellij.psi.impl.PsiElementBase.findReferenceAt(int)",
//        "value":null
//        },{
//        "name":"deleteChildRange",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.deleteChildRange(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"getContainingFile",
//        "desc":"public com.intellij.psi.PsiFile com.intellij.psi.impl.PsiElementBase.getContainingFile()",
//        "value":null
//        },{
//        "name":"getResolveScope",
//        "desc":"public com.intellij.psi.search.GlobalSearchScope com.intellij.psi.impl.PsiElementBase.getResolveScope()",
//        "value":"Project and Libraries"
//        },{
//        "name":"isEquivalentTo",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.isEquivalentTo(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getOriginalElement",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.getOriginalElement()",
//        "value":"me_infos: table"
//        },{
//        "name":"addRangeBefore",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addRangeBefore(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"checkAdd",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.checkAdd(com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"addRangeAfter",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addRangeAfter(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"getReference",
//        "desc":"public com.intellij.psi.PsiReference com.intellij.psi.impl.PsiElementBase.getReference()",
//        "value":null
//        },{
//        "name":"processDeclarations",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.processDeclarations(com.intellij.psi.scope.PsiScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getNavigationElement",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.getNavigationElement()",
//        "value":"me_infos: table"
//        },{
//        "name":"registerIconLayer",
//        "desc":"public static void com.intellij.psi.impl.ElementBase.registerIconLayer(int,javax.swing.Icon)",
//        "value":null
//        },{
//        "name":"createLayeredIcon",
//        "desc":"public static com.intellij.ui.RowIcon com.intellij.psi.impl.ElementBase.createLayeredIcon(com.intellij.openapi.util.Iconable,javax.swing.Icon,int)",
//        "value":null
//        },{
//        "name":"buildRowIcon",
//        "desc":"public static com.intellij.ui.icons.RowIcon com.intellij.psi.impl.ElementBase.buildRowIcon(javax.swing.Icon,javax.swing.Icon)",
//        "value":null
//        },{
//        "name":"transformFlags",
//        "desc":"public static int com.intellij.psi.impl.ElementBase.transformFlags(com.intellij.psi.PsiElement,int)",
//        "value":null
//        },{
//        "name":"isNativeFileType",
//        "desc":"public static boolean com.intellij.psi.impl.ElementBase.isNativeFileType(com.intellij.openapi.fileTypes.FileType)",
//        "value":null
//        },{
//        "name":"overlayIcons",
//        "desc":"public static javax.swing.Icon com.intellij.psi.impl.ElementBase.overlayIcons(javax.swing.Icon...)",
//        "value":null
//        },{
//        "name":"iconWithVisibilityIfNeeded",
//        "desc":"public static javax.swing.Icon com.intellij.psi.impl.ElementBase.iconWithVisibilityIfNeeded(int,javax.swing.Icon,javax.swing.Icon)",
//        "value":null
//        },{
//        "name":"replace",
//        "desc":"public <T> boolean com.intellij.openapi.util.UserDataHolderBase.replace(com.intellij.openapi.util.Key<T>,T,T)",
//        "value":null
//        },{
//        "name":"getCopyableUserData",
//        "desc":"public <T> T com.intellij.openapi.util.UserDataHolderBase.getCopyableUserData(com.intellij.openapi.util.Key<T>)",
//        "value":null
//        },{
//        "name":"putCopyableUserData",
//        "desc":"public <T> void com.intellij.openapi.util.UserDataHolderBase.putCopyableUserData(com.intellij.openapi.util.Key<T>,T)",
//        "value":null
//        },{
//        "name":"putUserDataIfAbsent",
//        "desc":"public <T> T com.intellij.openapi.util.UserDataHolderBase.putUserDataIfAbsent(com.intellij.openapi.util.Key<T>,T)",
//        "value":null
//        },{
//        "name":"getUserData",
//        "desc":"public <T> T com.intellij.openapi.util.UserDataHolderBase.getUserData(com.intellij.openapi.util.Key<T>)",
//        "value":null
//        },{
//        "name":"copyCopyableDataTo",
//        "desc":"public void com.intellij.openapi.util.UserDataHolderBase.copyCopyableDataTo(com.intellij.openapi.util.UserDataHolderBase)",
//        "value":null
//        },{
//        "name":"getUserDataString",
//        "desc":"public java.lang.String com.intellij.openapi.util.UserDataHolderBase.getUserDataString()",
//        "value":"{COLOR_KEY=com.intellij.database.view.DatabaseColorManager$CachedColor@72789855, lastComputedIcon={0=Row icon. myIcons=[IconWrapperWithTooltip:jar:file:/D:/Program%20Files/JetBrains/IntelliJ%20IDEA%202020.2.3/plugins/DatabaseTools/lib/database-openapi.jar!/icons/table.svg, null]}, CACHED_SMART_POINTER_KEY=com.intellij.reference.SoftReference@38377026, com.intellij.semantic.SemServiceImpl$$Lambda$3816/0x0000000102541840=PsiCachedValueImpl{com.intellij.semantic.SemServiceImpl$$Lambda$3816/0x0000000102541840@11eab410}}"
//        },{
//        "name":"copyUserDataTo",
//        "desc":"public void com.intellij.openapi.util.UserDataHolderBase.copyUserDataTo(com.intellij.openapi.util.UserDataHolderBase)",
//        "value":null
//        },{
//        "name":"isUserDataEmpty",
//        "desc":"public boolean com.intellij.openapi.util.UserDataHolderBase.isUserDataEmpty()",
//        "value":"false"
//        },{
//        "name":"putUserData",
//        "desc":"public <T> void com.intellij.openapi.util.UserDataHolderBase.putUserData(com.intellij.openapi.util.Key<T>,T)",
//        "value":null
//        },{
//        "name":"getOwnReferences",
//        "desc":"public default java.lang.Iterable<? extends com.intellij.model.psi.PsiSymbolReference> com.intellij.psi.PsiElement.getOwnReferences()",
//        "value":"[]"
//        },{
//        "name":"getTextRangeInParent",
//        "desc":"public default com.intellij.openapi.util.TextRange com.intellij.psi.PsiElement.getTextRangeInParent()",
//        "value":"(0,0)"
//        },{
//        "name":"getDbChildren",
//        "desc":"public default <C> com.intellij.util.containers.JBIterable<C> com.intellij.database.model.DasObject.getDbChildren(java.lang.Class<C>,com.intellij.database.model.ObjectKind)",
//        "value":null
//        },{
//        "name":"getDbParent",
//        "desc":"public default com.intellij.database.model.DasObject com.intellij.database.model.DasObject.getDbParent()",
//        "value":"hc_manager: schema"
//        },{
//        "name":"getDependencies",
//        "desc":"public default java.lang.Object[] com.intellij.psi.meta.PsiMetaData.getDependencies()",
//        "value":"[Ljava.lang.Object;@5c6314f3"
//        },{
//        "name":"getDependences",
//        "desc":"public default java.lang.Object[] com.intellij.psi.meta.PsiMetaData.getDependences()",
//        "value":"[Ljava.lang.Object;@5c6314f3"
//        },{
//        "name":"getPsiDeclarations",
//        "desc":"public default com.intellij.util.containers.JBIterable<com.intellij.psi.PsiElement> com.intellij.database.symbols.DasPsiSymbol.getPsiDeclarations()",
//        "value":"me_infos: table"
//        },{
//        "name":"getDasObject",
//        "desc":"public default com.intellij.database.model.DasObject com.intellij.database.psi.DbTable.getDasObject()",
//        "value":"me_infos: table"
//        },{
//        "name":"getDasObject",
//        "desc":"public default com.intellij.database.model.DasTable com.intellij.database.psi.DbTable.getDasObject()",
//        "value":"me_infos: table"
//        }],
//        "----":"-----------------我是一条华丽的分割线-----------------",
//        "fieldList":[{
//        "name":"LOG",
//        "type":"com.intellij.openapi.diagnostic.Logger",
//        "value":"com.intellij.idea.IdeaLogger@6ab7bb0e"
//        },{
//        "name":"WEIGHT_BASE",
//        "type":"int",
//        "value":"10000"
//        },{
//        "name":"WEIGHT_INC",
//        "type":"int",
//        "value":"1000"
//        },{
//        "name":"myParent",
//        "type":"com.intellij.database.psi.DbElement",
//        "value":"hc_manager: schema"
//        },{
//        "name":"myDelegate",
//        "type":"java.lang.Object",
//        "value":"me_infos: table"
//        },{
//        "name":"myTransactionalVersion",
//        "type":"long",
//        "value":"22"
//        },{
//        "name":"ASYNC_DOC_CUT",
//        "type":"java.lang.String",
//        "value":"<!-- async-doc-cut -->"
//        },{
//        "name":"LOG",
//        "type":"com.intellij.openapi.diagnostic.Logger",
//        "value":"com.intellij.idea.IdeaLogger@3f4656bb"
//        },{
//        "name":"LOG",
//        "type":"com.intellij.openapi.diagnostic.Logger",
//        "value":"com.intellij.idea.IdeaLogger@2c6853ec"
//        },{
//        "name":"FLAGS_LOCKED",
//        "type":"int",
//        "value":"2048"
//        },{
//        "name":"ICON_COMPUTE",
//        "type":"java.util.function.Function",
//        "value":"com.intellij.psi.impl.ElementBase$$Lambda$1249/0x000000010110f040@2185b0f0"
//        },{
//        "name":"VISIBILITY_ICON_PLACEHOLDER",
//        "type":"com.intellij.openapi.util.NotNullLazyValue",
//        "value":"com.intellij.psi.impl.ElementBase$1@76bd1005"
//        },{
//        "name":"ICON_PLACEHOLDER",
//        "type":"com.intellij.openapi.util.NotNullLazyValue",
//        "value":"com.intellij.psi.impl.ElementBase$2@7bc363e7"
//        },{
//        "name":"COPYABLE_USER_MAP_KEY",
//        "type":"com.intellij.openapi.util.Key",
//        "value":"COPYABLE_USER_MAP_KEY"
//        },{
//        "name":"myUserMap",
//        "type":"com.intellij.util.keyFMap.KeyFMap",
//        "value":"{COLOR_KEY=com.intellij.database.view.DatabaseColorManager$CachedColor@72789855, lastComputedIcon={0=Row icon. myIcons=[IconWrapperWithTooltip:jar:file:/D:/Program%20Files/JetBrains/IntelliJ%20IDEA%202020.2.3/plugins/DatabaseTools/lib/database-openapi.jar!/icons/table.svg, null]}, CACHED_SMART_POINTER_KEY=com.intellij.reference.SoftReference@38377026, com.intellij.semantic.SemServiceImpl$$Lambda$3816/0x0000000102541840=PsiCachedValueImpl{com.intellij.semantic.SemServiceImpl$$Lambda$3816/0x0000000102541840@11eab410}}"
//        },{
//        "name":"updater",
//        "type":"com.intellij.util.concurrency.AtomicFieldUpdater",
//        "value":"com.intellij.util.concurrency.AtomicFieldUpdater@15dab840"
//        }]
//        }
//
////调试列原始对象
//        {
//        "title":"调试：com.intellij.database.psi.DbColumnImpl",
//        "methodList":[{
//        "name":"getDefault",
//        "desc":"public java.lang.String com.intellij.database.psi.DbColumnImpl.getDefault()",
//        "value":null
//        },{
//        "name":"getParent",
//        "desc":"public com.intellij.psi.PsiFileSystemItem com.intellij.database.psi.DbColumnImpl.getParent()",
//        "value":"me_infos: table"
//        },{
//        "name":"getParent",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.database.psi.DbColumnImpl.getParent()",
//        "value":"me_infos: table"
//        },{
//        "name":"getParent",
//        "desc":"public com.intellij.database.psi.DbElement com.intellij.database.psi.DbColumnImpl.getParent()",
//        "value":"me_infos: table"
//        },{
//        "name":"getParent",
//        "desc":"public com.intellij.database.psi.DbTable com.intellij.database.psi.DbColumnImpl.getParent()",
//        "value":"me_infos: table"
//        },{
//        "name":"getTable",
//        "desc":"public com.intellij.database.psi.DbTable com.intellij.database.psi.DbColumnImpl.getTable()",
//        "value":"me_infos: table"
//        },{
//        "name":"getTable",
//        "desc":"public com.intellij.database.model.DasTable com.intellij.database.psi.DbColumnImpl.getTable()",
//        "value":"me_infos: table"
//        },{
//        "name":"getDataType",
//        "desc":"public com.intellij.database.model.DataType com.intellij.database.psi.DbColumnImpl.getDataType()",
//        "value":"int(10)"
//        },{
//        "name":"getWeight",
//        "desc":"public int com.intellij.database.psi.DbColumnImpl.getWeight()",
//        "value":"10030"
//        },{
//        "name":"isNotNull",
//        "desc":"public boolean com.intellij.database.psi.DbColumnImpl.isNotNull()",
//        "value":"true"
//        },{
//        "name":"getDocumentation",
//        "desc":"public java.lang.CharSequence com.intellij.database.psi.DbColumnImpl.getDocumentation(boolean)",
//        "value":null
//        },{
//        "name":"getDocumentation",
//        "desc":"public java.lang.StringBuilder com.intellij.database.psi.DbColumnImpl.getDocumentation(boolean)",
//        "value":null
//        },{
//        "name":"getName",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getName(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getName",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getName()",
//        "value":"elmt_no"
//        },{
//        "name":"getTypeName",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getTypeName()",
//        "value":"column"
//        },{
//        "name":"init",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.init(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"setName",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.database.psi.DbElementImpl.setName(java.lang.String) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"getLanguage",
//        "desc":"public com.intellij.lang.Language com.intellij.database.psi.DbElementImpl.getLanguage()",
//        "value":"Language: SQL"
//        },{
//        "name":"isDirectory",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isDirectory()",
//        "value":"false"
//        },{
//        "name":"getComment",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getComment()",
//        "value":null
//        },{
//        "name":"isWritable",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isWritable()",
//        "value":"true"
//        },{
//        "name":"isValid",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isValid()",
//        "value":"true"
//        },{
//        "name":"getChildren",
//        "desc":"public com.intellij.psi.PsiElement[] com.intellij.database.psi.DbElementImpl.getChildren()",
//        "value":"[Lcom.intellij.psi.PsiElement;@725a6af3"
//        },{
//        "name":"getPosition",
//        "desc":"public short com.intellij.database.psi.DbElementImpl.getPosition()",
//        "value":"1"
//        },{
//        "name":"getText",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getText()",
//        "value":"alter table me_infos\n    add elmt_no int(10) not null;\n\n"
//        },{
//        "name":"getIcon",
//        "desc":"public javax.swing.Icon com.intellij.database.psi.DbElementImpl.getIcon()",
//        "value":"Deferred. Base=IconWrapperWithTooltip:jar:file:/D:/Program%20Files/JetBrains/IntelliJ%20IDEA%202020.2.3/plugins/DatabaseTools/lib/database-openapi.jar!/icons/col.svg"
//        },{
//        "name":"getIcon",
//        "desc":"public javax.swing.Icon com.intellij.database.psi.DbElementImpl.getIcon(boolean)",
//        "value":null
//        },{
//        "name":"getDelegate",
//        "desc":"public D com.intellij.database.psi.DbElementImpl.getDelegate()",
//        "value":"elmt_no: column"
//        },{
//        "name":"getManager",
//        "desc":"public com.intellij.psi.PsiManager com.intellij.database.psi.DbElementImpl.getManager()",
//        "value":"com.intellij.psi.impl.PsiManagerImpl@15c8ad23"
//        },{
//        "name":"getMetaData",
//        "desc":"public com.intellij.psi.meta.PsiMetaData com.intellij.database.psi.DbElementImpl.getMetaData()",
//        "value":"elmt_no: column"
//        },{
//        "name":"processChildren",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.processChildren(com.intellij.psi.search.PsiElementProcessor<com.intellij.psi.PsiFileSystemItem>)",
//        "value":null
//        },{
//        "name":"getBaseIcon",
//        "desc":"public javax.swing.Icon com.intellij.database.psi.DbElementImpl.getBaseIcon()",
//        "value":"IconWrapperWithTooltip:jar:file:/D:/Program%20Files/JetBrains/IntelliJ%20IDEA%202020.2.3/plugins/DatabaseTools/lib/database-openapi.jar!/icons/col.svg"
//        },{
//        "name":"getProject",
//        "desc":"public com.intellij.openapi.project.Project com.intellij.database.psi.DbElementImpl.getProject()",
//        "value":"Project(name=oos_dev, containerState=ACTIVE, componentStore=E:\\test\\odl_otn_system\\oos_dev)"
//        },{
//        "name":"getDeclaration",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.database.psi.DbElementImpl.getDeclaration()",
//        "value":"elmt_no: column"
//        },{
//        "name":"getKind",
//        "desc":"public com.intellij.database.model.ObjectKind com.intellij.database.psi.DbElementImpl.getKind()",
//        "value":"column"
//        },{
//        "name":"getVirtualFile",
//        "desc":"public com.intellij.openapi.vfs.VirtualFile com.intellij.database.psi.DbElementImpl.getVirtualFile()",
//        "value":"DB VirtualFile: column, hc_manager.me_infos.elmt_no [hc_manager@localhost] (Valid)"
//        },{
//        "name":"isCaseSensitive",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isCaseSensitive()",
//        "value":"false"
//        },{
//        "name":"isQuoted",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.isQuoted()",
//        "value":"true"
//        },{
//        "name":"navigate",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.navigate(boolean,java.lang.String[],com.intellij.database.util.DbImplUtil$TriConsumer<com.intellij.database.util.DdlBuilder, java.util.List<com.intellij.database.model.DasColumn>, com.intellij.database.Dbms>)",
//        "value":null
//        },{
//        "name":"navigate",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.navigate(boolean,java.lang.String[],boolean,com.intellij.database.util.DbImplUtil$TriConsumer<com.intellij.database.util.DdlBuilder, java.util.List<com.intellij.database.model.DasColumn>, com.intellij.database.Dbms>)",
//        "value":null
//        },{
//        "name":"navigate",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.navigate(boolean)",
//        "value":null
//        },{
//        "name":"checkSetName",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.checkSetName(java.lang.String) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"canNavigate",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.canNavigate()",
//        "value":null
//        },{
//        "name":"acceptChildren",
//        "desc":"public void com.intellij.database.psi.DbElementImpl.acceptChildren(com.intellij.psi.PsiElementVisitor)",
//        "value":null
//        },{
//        "name":"processDeclarations",
//        "desc":"public final boolean com.intellij.database.psi.DbElementImpl.processDeclarations(com.intellij.database.model.DasScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"canNavigateToSource",
//        "desc":"public boolean com.intellij.database.psi.DbElementImpl.canNavigateToSource()",
//        "value":null
//        },{
//        "name":"getDataSource",
//        "desc":"public com.intellij.database.psi.DbDataSource com.intellij.database.psi.DbElementImpl.getDataSource()",
//        "value":"hc_manager@localhost: root"
//        },{
//        "name":"getDataSource",
//        "desc":"public com.intellij.database.psi.DbDataSourceImpl com.intellij.database.psi.DbElementImpl.getDataSource()",
//        "value":"hc_manager@localhost: root"
//        },{
//        "name":"getLocationString",
//        "desc":"public java.lang.String com.intellij.database.psi.DbElementImpl.getLocationString()",
//        "value":"hc_manager.me_infos [hc_manager@localhost]"
//        },{
//        "name":"getDasChildren",
//        "desc":"public com.intellij.util.containers.JBIterable<com.intellij.database.psi.DbElement> com.intellij.database.psi.DbElementImpl.getDasChildren(com.intellij.database.model.ObjectKind)",
//        "value":null
//        },{
//        "name":"getDasParent",
//        "desc":"public P com.intellij.database.psi.DbElementImpl.getDasParent()",
//        "value":"me_infos: table"
//        },{
//        "name":"getDasParent",
//        "desc":"public com.intellij.database.model.DasObject com.intellij.database.psi.DbElementImpl.getDasParent()",
//        "value":"me_infos: table"
//        },{
//        "name":"newDeclarationProcessor",
//        "desc":"public static com.intellij.util.Processor<com.intellij.database.psi.DbElement> com.intellij.database.psi.DbElementImpl.newDeclarationProcessor(com.intellij.database.model.DasScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"createDeclarationProcessor",
//        "desc":"public com.intellij.util.Processor<com.intellij.database.psi.DbElement> com.intellij.database.psi.DbElementImpl.createDeclarationProcessor(com.intellij.database.model.DasScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getNode",
//        "desc":"public com.intellij.lang.ASTNode com.intellij.psi.impl.FakePsiElement.getNode()",
//        "value":null
//        },{
//        "name":"getTextLength",
//        "desc":"public int com.intellij.psi.impl.FakePsiElement.getTextLength()",
//        "value":"0"
//        },{
//        "name":"getIcon",
//        "desc":"public final javax.swing.Icon com.intellij.psi.impl.FakePsiElement.getIcon(int)",
//        "value":null
//        },{
//        "name":"getFirstChild",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getFirstChild()",
//        "value":null
//        },{
//        "name":"getLastChild",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getLastChild()",
//        "value":null
//        },{
//        "name":"getNextSibling",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getNextSibling()",
//        "value":null
//        },{
//        "name":"getTextOffset",
//        "desc":"public int com.intellij.psi.impl.FakePsiElement.getTextOffset()",
//        "value":"0"
//        },{
//        "name":"getPresentation",
//        "desc":"public com.intellij.navigation.ItemPresentation com.intellij.psi.impl.FakePsiElement.getPresentation()",
//        "value":"elmt_no: column"
//        },{
//        "name":"isPhysical",
//        "desc":"public boolean com.intellij.psi.impl.FakePsiElement.isPhysical()",
//        "value":"false"
//        },{
//        "name":"getPresentableText",
//        "desc":"public java.lang.String com.intellij.psi.impl.FakePsiElement.getPresentableText()",
//        "value":"elmt_no"
//        },{
//        "name":"findElementAt",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.findElementAt(int)",
//        "value":null
//        },{
//        "name":"getTextRange",
//        "desc":"public com.intellij.openapi.util.TextRange com.intellij.psi.impl.FakePsiElement.getTextRange()",
//        "value":null
//        },{
//        "name":"textContains",
//        "desc":"public boolean com.intellij.psi.impl.FakePsiElement.textContains(char)",
//        "value":null
//        },{
//        "name":"textToCharArray",
//        "desc":"public char[] com.intellij.psi.impl.FakePsiElement.textToCharArray()",
//        "value":null
//        },{
//        "name":"getPrevSibling",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.FakePsiElement.getPrevSibling()",
//        "value":null
//        },{
//        "name":"getStartOffsetInParent",
//        "desc":"public int com.intellij.psi.impl.FakePsiElement.getStartOffsetInParent()",
//        "value":"0"
//        },{
//        "name":"add",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.add(com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"replace",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.replace(com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"checkDelete",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.checkDelete() throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"delete",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.delete() throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"accept",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.accept(com.intellij.psi.PsiElementVisitor)",
//        "value":null
//        },{
//        "name":"getContext",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.getContext()",
//        "value":"me_infos: table"
//        },{
//        "name":"copy",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.copy()",
//        "value":null
//        },{
//        "name":"addRange",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addRange(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"addAfter",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addAfter(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"addBefore",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addBefore(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"textMatches",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.textMatches(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"textMatches",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.textMatches(java.lang.CharSequence)",
//        "value":null
//        },{
//        "name":"getReferences",
//        "desc":"public com.intellij.psi.PsiReference[] com.intellij.psi.impl.PsiElementBase.getReferences()",
//        "value":"[Lcom.intellij.psi.PsiReference;@60f5b628"
//        },{
//        "name":"getUseScope",
//        "desc":"public com.intellij.psi.search.SearchScope com.intellij.psi.impl.PsiElementBase.getUseScope()",
//        "value":"Project and Libraries"
//        },{
//        "name":"findReferenceAt",
//        "desc":"public com.intellij.psi.PsiReference com.intellij.psi.impl.PsiElementBase.findReferenceAt(int)",
//        "value":null
//        },{
//        "name":"deleteChildRange",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.deleteChildRange(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"getContainingFile",
//        "desc":"public com.intellij.psi.PsiFile com.intellij.psi.impl.PsiElementBase.getContainingFile()",
//        "value":null
//        },{
//        "name":"getResolveScope",
//        "desc":"public com.intellij.psi.search.GlobalSearchScope com.intellij.psi.impl.PsiElementBase.getResolveScope()",
//        "value":"Project and Libraries"
//        },{
//        "name":"isEquivalentTo",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.isEquivalentTo(com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getOriginalElement",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.getOriginalElement()",
//        "value":"elmt_no: column"
//        },{
//        "name":"addRangeBefore",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addRangeBefore(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"checkAdd",
//        "desc":"public void com.intellij.psi.impl.PsiElementBase.checkAdd(com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"addRangeAfter",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.addRangeAfter(com.intellij.psi.PsiElement,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement) throws com.intellij.util.IncorrectOperationException",
//        "value":null
//        },{
//        "name":"getReference",
//        "desc":"public com.intellij.psi.PsiReference com.intellij.psi.impl.PsiElementBase.getReference()",
//        "value":null
//        },{
//        "name":"processDeclarations",
//        "desc":"public boolean com.intellij.psi.impl.PsiElementBase.processDeclarations(com.intellij.psi.scope.PsiScopeProcessor,com.intellij.psi.ResolveState,com.intellij.psi.PsiElement,com.intellij.psi.PsiElement)",
//        "value":null
//        },{
//        "name":"getNavigationElement",
//        "desc":"public com.intellij.psi.PsiElement com.intellij.psi.impl.PsiElementBase.getNavigationElement()",
//        "value":"elmt_no: column"
//        },{
//        "name":"registerIconLayer",
//        "desc":"public static void com.intellij.psi.impl.ElementBase.registerIconLayer(int,javax.swing.Icon)",
//        "value":null
//        },{
//        "name":"createLayeredIcon",
//        "desc":"public static com.intellij.ui.RowIcon com.intellij.psi.impl.ElementBase.createLayeredIcon(com.intellij.openapi.util.Iconable,javax.swing.Icon,int)",
//        "value":null
//        },{
//        "name":"buildRowIcon",
//        "desc":"public static com.intellij.ui.icons.RowIcon com.intellij.psi.impl.ElementBase.buildRowIcon(javax.swing.Icon,javax.swing.Icon)",
//        "value":null
//        },{
//        "name":"transformFlags",
//        "desc":"public static int com.intellij.psi.impl.ElementBase.transformFlags(com.intellij.psi.PsiElement,int)",
//        "value":null
//        },{
//        "name":"isNativeFileType",
//        "desc":"public static boolean com.intellij.psi.impl.ElementBase.isNativeFileType(com.intellij.openapi.fileTypes.FileType)",
//        "value":null
//        },{
//        "name":"overlayIcons",
//        "desc":"public static javax.swing.Icon com.intellij.psi.impl.ElementBase.overlayIcons(javax.swing.Icon...)",
//        "value":null
//        },{
//        "name":"iconWithVisibilityIfNeeded",
//        "desc":"public static javax.swing.Icon com.intellij.psi.impl.ElementBase.iconWithVisibilityIfNeeded(int,javax.swing.Icon,javax.swing.Icon)",
//        "value":null
//        },{
//        "name":"replace",
//        "desc":"public <T> boolean com.intellij.openapi.util.UserDataHolderBase.replace(com.intellij.openapi.util.Key<T>,T,T)",
//        "value":null
//        },{
//        "name":"getCopyableUserData",
//        "desc":"public <T> T com.intellij.openapi.util.UserDataHolderBase.getCopyableUserData(com.intellij.openapi.util.Key<T>)",
//        "value":null
//        },{
//        "name":"putCopyableUserData",
//        "desc":"public <T> void com.intellij.openapi.util.UserDataHolderBase.putCopyableUserData(com.intellij.openapi.util.Key<T>,T)",
//        "value":null
//        },{
//        "name":"putUserDataIfAbsent",
//        "desc":"public <T> T com.intellij.openapi.util.UserDataHolderBase.putUserDataIfAbsent(com.intellij.openapi.util.Key<T>,T)",
//        "value":null
//        },{
//        "name":"getUserData",
//        "desc":"public <T> T com.intellij.openapi.util.UserDataHolderBase.getUserData(com.intellij.openapi.util.Key<T>)",
//        "value":null
//        },{
//        "name":"copyCopyableDataTo",
//        "desc":"public void com.intellij.openapi.util.UserDataHolderBase.copyCopyableDataTo(com.intellij.openapi.util.UserDataHolderBase)",
//        "value":null
//        },{
//        "name":"getUserDataString",
//        "desc":"public java.lang.String com.intellij.openapi.util.UserDataHolderBase.getUserDataString()",
//        "value":"{CACHED_SMART_POINTER_KEY=com.intellij.reference.SoftReference@62b2196a}"
//        },{
//        "name":"copyUserDataTo",
//        "desc":"public void com.intellij.openapi.util.UserDataHolderBase.copyUserDataTo(com.intellij.openapi.util.UserDataHolderBase)",
//        "value":null
//        },{
//        "name":"isUserDataEmpty",
//        "desc":"public boolean com.intellij.openapi.util.UserDataHolderBase.isUserDataEmpty()",
//        "value":"false"
//        },{
//        "name":"putUserData",
//        "desc":"public <T> void com.intellij.openapi.util.UserDataHolderBase.putUserData(com.intellij.openapi.util.Key<T>,T)",
//        "value":null
//        },{
//        "name":"getOwnReferences",
//        "desc":"public default java.lang.Iterable<? extends com.intellij.model.psi.PsiSymbolReference> com.intellij.psi.PsiElement.getOwnReferences()",
//        "value":"[]"
//        },{
//        "name":"getTextRangeInParent",
//        "desc":"public default com.intellij.openapi.util.TextRange com.intellij.psi.PsiElement.getTextRangeInParent()",
//        "value":"(0,0)"
//        },{
//        "name":"getDbChildren",
//        "desc":"public default <C> com.intellij.util.containers.JBIterable<C> com.intellij.database.model.DasObject.getDbChildren(java.lang.Class<C>,com.intellij.database.model.ObjectKind)",
//        "value":null
//        },{
//        "name":"getDbParent",
//        "desc":"public default com.intellij.database.model.DasObject com.intellij.database.model.DasObject.getDbParent()",
//        "value":"me_infos: table"
//        },{
//        "name":"getDependencies",
//        "desc":"public default java.lang.Object[] com.intellij.psi.meta.PsiMetaData.getDependencies()",
//        "value":"[Ljava.lang.Object;@5c6314f3"
//        },{
//        "name":"getDependences",
//        "desc":"public default java.lang.Object[] com.intellij.psi.meta.PsiMetaData.getDependences()",
//        "value":"[Ljava.lang.Object;@5c6314f3"
//        },{
//        "name":"getPsiDeclarations",
//        "desc":"public default com.intellij.util.containers.JBIterable<com.intellij.psi.PsiElement> com.intellij.database.symbols.DasPsiSymbol.getPsiDeclarations()",
//        "value":"elmt_no: column"
//        },{
//        "name":"getDasObject",
//        "desc":"public default com.intellij.database.model.DasObject com.intellij.database.psi.DbColumn.getDasObject()",
//        "value":"elmt_no: column"
//        },{
//        "name":"getDasObject",
//        "desc":"public default com.intellij.database.model.DasColumn com.intellij.database.psi.DbColumn.getDasObject()",
//        "value":"elmt_no: column"
//        },{
//        "name":"getTableName",
//        "desc":"public default java.lang.String com.intellij.database.model.DasColumn.getTableName()",
//        "value":"me_infos"
//        }],
//        "----":"-----------------我是一条华丽的分割线-----------------",
//        "fieldList":[{
//        "name":"LOG",
//        "type":"com.intellij.openapi.diagnostic.Logger",
//        "value":"com.intellij.idea.IdeaLogger@6ab7bb0e"
//        },{
//        "name":"WEIGHT_BASE",
//        "type":"int",
//        "value":"10000"
//        },{
//        "name":"WEIGHT_INC",
//        "type":"int",
//        "value":"1000"
//        },{
//        "name":"myParent",
//        "type":"com.intellij.database.psi.DbElement",
//        "value":"me_infos: table"
//        },{
//        "name":"myDelegate",
//        "type":"java.lang.Object",
//        "value":"elmt_no: column"
//        },{
//        "name":"myTransactionalVersion",
//        "type":"long",
//        "value":"22"
//        },{
//        "name":"ASYNC_DOC_CUT",
//        "type":"java.lang.String",
//        "value":"<!-- async-doc-cut -->"
//        },{
//        "name":"LOG",
//        "type":"com.intellij.openapi.diagnostic.Logger",
//        "value":"com.intellij.idea.IdeaLogger@3f4656bb"
//        },{
//        "name":"LOG",
//        "type":"com.intellij.openapi.diagnostic.Logger",
//        "value":"com.intellij.idea.IdeaLogger@2c6853ec"
//        },{
//        "name":"FLAGS_LOCKED",
//        "type":"int",
//        "value":"2048"
//        },{
//        "name":"ICON_COMPUTE",
//        "type":"java.util.function.Function",
//        "value":"com.intellij.psi.impl.ElementBase$$Lambda$1249/0x000000010110f040@2185b0f0"
//        },{
//        "name":"VISIBILITY_ICON_PLACEHOLDER",
//        "type":"com.intellij.openapi.util.NotNullLazyValue",
//        "value":"com.intellij.psi.impl.ElementBase$1@76bd1005"
//        },{
//        "name":"ICON_PLACEHOLDER",
//        "type":"com.intellij.openapi.util.NotNullLazyValue",
//        "value":"com.intellij.psi.impl.ElementBase$2@7bc363e7"
//        },{
//        "name":"COPYABLE_USER_MAP_KEY",
//        "type":"com.intellij.openapi.util.Key",
//        "value":"COPYABLE_USER_MAP_KEY"
//        },{
//        "name":"myUserMap",
//        "type":"com.intellij.util.keyFMap.KeyFMap",
//        "value":"{CACHED_SMART_POINTER_KEY=com.intellij.reference.SoftReference@62b2196a}"
//        },{
//        "name":"updater",
//        "type":"com.intellij.util.concurrency.AtomicFieldUpdater",
//        "value":"com.intellij.util.concurrency.AtomicFieldUpdater@15dab840"
//        }]
//        }
//
////调试列原始列类型
//        {
//        "title":"调试：com.intellij.database.model.DataType",
//        "methodList":[{
//        "name":"getLength",
//        "desc":"public int com.intellij.database.model.DataType.getLength()",
//        "value":"10"
//        },{
//        "name":"getScale",
//        "desc":"public int com.intellij.database.model.DataType.getScale()",
//        "value":"0"
//        },{
//        "name":"getPrecision",
//        "desc":"public int com.intellij.database.model.DataType.getPrecision()",
//        "value":"10"
//        },{
//        "name":"getSpecification",
//        "desc":"public java.lang.String com.intellij.database.model.DataType.getSpecification(boolean,boolean)",
//        "value":null
//        },{
//        "name":"getSpecification",
//        "desc":"public java.lang.String com.intellij.database.model.DataType.getSpecification()",
//        "value":"int(10)"
//        },{
//        "name":"withTypeName",
//        "desc":"public com.intellij.database.model.DataType com.intellij.database.model.DataType.withTypeName(java.lang.String)",
//        "value":null
//        },{
//        "name":"equalsWithoutJdbc",
//        "desc":"public boolean com.intellij.database.model.DataType.equalsWithoutJdbc(com.intellij.database.model.DataType)",
//        "value":null
//        }],
//        "----":"-----------------我是一条华丽的分割线-----------------",
//        "fieldList":[{
//        "name":"MAX_SIZE",
//        "type":"int",
//        "value":"2147483647"
//        },{
//        "name":"STAR_SIZE",
//        "type":"int",
//        "value":"2147483646"
//        },{
//        "name":"NO_SIZE",
//        "type":"int",
//        "value":"-1"
//        },{
//        "name":"NO_SCALE",
//        "type":"int",
//        "value":"0"
//        },{
//        "name":"UNKNOWN",
//        "type":"com.intellij.database.model.DataType",
//        "value":"unknown"
//        },{
//        "name":"schemaName",
//        "type":"java.lang.String",
//        "value":null
//        },{
//        "name":"packageName",
//        "type":"java.lang.String",
//        "value":null
//        },{
//        "name":"typeName",
//        "type":"java.lang.String",
//        "value":"int"
//        },{
//        "name":"size",
//        "type":"int",
//        "value":"10"
//        },{
//        "name":"scale",
//        "type":"int",
//        "value":"0"
//        },{
//        "name":"sizeUnit",
//        "type":"com.intellij.database.model.LengthUnit",
//        "value":"com.intellij.database.model.LengthUnit@11bb54e1"
//        },{
//        "name":"vagueArg",
//        "type":"java.lang.String",
//        "value":null
//        },{
//        "name":"suffix",
//        "type":"java.lang.String",
//        "value":null
//        },{
//        "name":"sizeUnitExplicit",
//        "type":"boolean",
//        "value":"false"
//        },{
//        "name":"custom",
//        "type":"boolean",
//        "value":"false"
//        },{
//        "name":"enumValues",
//        "type":"java.util.List",
//        "value":null
//        },{
//        "name":"jdbcType",
//        "type":"int",
//        "value":"0"
//        }]
//        }
//
////获取原始列类型中的字段
//        sqlType=int
//
////执行原始列类型中的方法
//        sqlTypeLen=10