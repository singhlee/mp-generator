package mybatis.plus.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import mybatis.plus.generator.core.ConfigInitiator;
import mybatis.plus.generator.initior.DefaultConfigInititor;

/**
 * @Auther: aijing
 * @Date: 2019/5/28 14:48
 * @Description:
 */
public class Application {

    public static String db_url = "jdbc:mysql://10.10.10.176:3306/user-center?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false";
    public static String db_username = "root";
    public static String db_password = "mr888888";
    public static String packageName = "com.open.capacity.user";
    public static String author = "hdxj_lx";
    public static String tableNames = "authentication_data";


    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        ConfigInitiator configInitiator = new DefaultConfigInititor();
        generator.setDataSource(configInitiator.initDataSourceConfig());
        generator.setGlobalConfig(configInitiator.initGlobalConfig());
        generator.setCfg(configInitiator.initInjectionConfig());
        generator.setPackageInfo(configInitiator.initPackageConfig());
        generator.setStrategy(configInitiator.initStrategyConfig());
        generator.setTemplate(configInitiator.initTemplateConfig());
        generator.execute();
    }

}
