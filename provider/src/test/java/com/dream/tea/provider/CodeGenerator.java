package com.dream.tea.provider;

import com.google.common.base.CaseFormat;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CodeGenerator {

    // 项目基础包名称
    public static final String BASE_PACKAGE = "com.dream.tea.service";
    // entity所在包
    public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".model";
    // Mapper所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";
    //    // Mapper插件基础接口的完全限定名
//    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".mapper.CustomMapper";
    // 项目在硬盘上的基础路径
    private static final String PROJECT_PATH = "E:\\gdut\\tea\\service";
    // java文件路径
    private static final String JAVA_PATH = "/src/main/java";
    // 资源文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";

    // JDBC默认配置，请修改为你项目的实际配置
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/tea-user?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true&useSSL=false";
    private static String JDBC_USERNAME = "root";
    private static String JDBC_PASSWORD = "yaya";
    private static String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    // 初始化默认数据库逻辑名
    private static String DATABASE = "test";
    // 数据库包路径
    private static String DATABASE_PACKAGE = DATABASE == null ? "" : ("." + DATABASE);
    // mapper 路径
    private static String PACKAGE_MAPPER = MAPPER_PACKAGE + DATABASE_PACKAGE;
    // entity 路径
    private static String PACKAGE_MODEL = ENTITY_PACKAGE + DATABASE_PACKAGE;

    // @author
    private static String AUTHOR = "MybatisCodeGenerator";
    private static boolean overwrite = false;
    // 是否原样输出数据库字段中的值，新系统使用的是小写+下划线，旧系统是大驼峰，所以生成旧系统的表对象时，需要加上
    private static boolean useActualColumnNames = false;

    /**
     * 参数格式如下：
     * -table activity_config
     * -modelName ActivityConfig
     * -overwrite -jdbcUrl jdbc:mysql://devdb.61info.com:3306/hll-activity?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&serverTimezone=UTC
     * -jdbcUsername root
     * -jdbcPassword dbtest
     * -author yejunhong
     * -database activity
     */
    public static void main(final String[] args) throws IOException {
        CommandLine line;
        // 命令行有参数，读取命令行
        if (args != null && args.length > 0) {
            line = parseArgs(args);
        } else {
            // 没有参数读取配置文件
            URL resource = CodeGenerator.class.getClassLoader().getResource("code_generator.txt");
            if (resource == null) {
                System.out.println("未获取到配置文件");
                return;
            }
            String arg = null;
            try {
                InputStream inputStream = resource.openStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while((length = inputStream.read(buffer)) != -1) {
                    bos.write(buffer,0,length);
                }
                bos.close();
                inputStream.close();
                arg = bos.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (StringUtils.isBlank(arg)){
                System.out.println("读取文件内容错误");
                return;
            }
            String[] argss = arg.split("\\s+");
            line = parseArgs(argss);
        }

        String table = line.getOptionValue("table");

        if (line.hasOption("overwrite")) {
            overwrite = true;
        }

        JDBC_URL = getArgs(line, "jdbcUrl", JDBC_URL);
        JDBC_USERNAME = getArgs(line, "jdbcUsername", JDBC_USERNAME);
        JDBC_PASSWORD = getArgs(line, "jdbcPassword", JDBC_PASSWORD);
        JDBC_DIVER_CLASS_NAME = getArgs(line, "jdbcDrive", JDBC_DIVER_CLASS_NAME);

        AUTHOR = getArgs(line, "author", AUTHOR);

        DATABASE = getArgs(line, "database", DATABASE);
        DATABASE_PACKAGE = DATABASE == null ? "" : ("." + DATABASE);
        PACKAGE_MAPPER = MAPPER_PACKAGE + DATABASE_PACKAGE;
        PACKAGE_MODEL = ENTITY_PACKAGE + DATABASE_PACKAGE;

        PACKAGE_MODEL = getArgs(line, "modelPackage", PACKAGE_MODEL);
        PACKAGE_MAPPER = getArgs(line, "modelPackage", PACKAGE_MAPPER);

        if (line.hasOption("modelName")) {
            String modelName = line.getOptionValue("modelName");
            genCodeByCustomModelName(table, modelName);
        } else {
            genCode(table);
        }
    }

    private static String getArgs(CommandLine line, String key, String defaultValue) {
        if (line.hasOption(key)) {
            return line.getOptionValue(key);
        }
        return defaultValue;
    }

    private static CommandLine parseArgs(String[] args) {
        System.out.println("args:" + Arrays.toString(args));

        Options options = new Options();
        options.addOption(Option.builder("overwrite")
                .argName("overwrite").hasArg(false).desc("是否覆盖已有文件").build());
        options.addOption(Option.builder("jdbcUrl")
                .argName("jdbcUrl").hasArg(true).desc("jdbcUrl").build());
        options.addOption(Option.builder("jdbcUsername")
                .argName("jdbcUsername").hasArg(true).desc("jdbcUsername").build());
        options.addOption(Option.builder("jdbcPassword")
                .argName("jdbcPassword").hasArg(true).desc("jdbcPassword").build());
        options.addOption(Option.builder("jdbcDrive")
                .argName("jdbcDrive").hasArg(true).desc("jdbcDrive").build());
        options.addOption(Option.builder("database")
                .argName("database").hasArg(true).desc("database").build());
        options.addOption(Option.builder("author")
                .argName("author").hasArg(true).desc("author").build());
        options.addOption(Option.builder("modelPackage")
                .argName("modelPackage").hasArg(true).desc("modelPackage").build());
        options.addOption(Option.builder("modelName")
                .argName("modelName").hasArg(true).desc("自定义Model名称").build());
        options.addOption(Option.builder("table")
                .argName("table").hasArg(true).required(true).desc("表名").build());

        CommandLineParser parser = new DefaultParser();
        try {
            // parse the command line arguments
            return parser.parse(options, args);
        } catch (Exception exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
            throw new RuntimeException("parse args error", exp);
        }
    }

    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     *
     * @param tableNames 数据表名称...
     */
    private static void genCode(final String... tableNames) {
        for (final String tableName : tableNames) {
            genCodeByCustomModelName(tableName, null);
        }
    }

    /**
     * 通过数据表名称，和自定义的 Model 名称生成代码
     * 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "sysUser" 将生成 sysUser、UserMapper、UserService ...
     *
     * @param tableName 数据表名称
     * @param modelName 自定义的 Model 名称
     */
    private static void genCodeByCustomModelName(final String tableName, final String modelName) {
        genModelAndMapper(tableName, modelName);
    }


    private static void genModelAndMapper(final String tableName, String modelName) {
        final Context context = new Context(ModelType.FLAT);
        context.setId("Potato");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        final JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

//        final PluginConfiguration pluginConfiguration = new PluginConfiguration();
//        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
//        pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
//        context.addPluginConfiguration(pluginConfiguration);

        final JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(PACKAGE_MODEL);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        final SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper" + DATABASE_PACKAGE);
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        final JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(PACKAGE_MAPPER);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        //注解
        final TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        if (StringUtils.isNotEmpty(modelName)) {
            tableConfiguration.setDomainObjectName(modelName);
        }
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
        // 下面这行配置设置的是是否原样输出数据库字段中的值，新系统使用的是小写+下划线，旧系统是大驼峰，所以生成旧系统的表对象时，需要加上下面这行配置
        if (useActualColumnNames) {
            tableConfiguration.addProperty("useActualColumnNames", "true");
        }
        context.addTableConfiguration(tableConfiguration);
        //是否去除所有自动生成文件的注释：
        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressAllComments","true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

        final List<String> warnings;
        final MyBatisGenerator generator;
        try {
            final Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            final DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (final Exception e) {
            throw new RuntimeException("生成 Model和 Mapper 失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成 Model 和 Mapper 失败：" + warnings);
        }
        if (StringUtils.isEmpty(modelName)) {
            modelName = tableNameConvertUpperCamel(tableName);
        }
        System.out.println(modelName + ".java 生成成功");
        System.out.println(modelName + "Mapper.java 生成成功");
        System.out.println(modelName + "Mapper.xml 生成成功");
    }

    private static String tableNameConvertUpperCamel(final String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

    }

    private static String packageConvertPath(final String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

}
