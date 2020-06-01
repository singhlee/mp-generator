package mybatis.plus.generator.initior;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import mybatis.plus.generator.Application;
import mybatis.plus.generator.core.ConfigInitiator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: aijing
 * @Date: 2019/5/28 14:45
 * @Description:
 */
public class DefaultConfigInititor implements ConfigInitiator {

    private String projectPath = System.getProperty("user.dir")+"/mp-generator";

    /**
     * 数据源配置，通过该配置，指定需要生成代码的具体数据库
     */
    public DataSourceConfig initDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl(Application.db_url);
        dsc.setUsername(Application.db_username);
        dsc.setPassword(Application.db_password);
        return dsc;
    }

    /**
     * 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
     */
    public StrategyConfig initStrategyConfig() {
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        //是否生成实体时，生成字段注解
        sc.setEntityTableFieldAnnotationEnable(true);
        sc.setInclude(StringUtils.split(Application.tableNames,","));
        //逻辑删除属性名称
        sc.setLogicDeleteFieldName("delete");
//        sc.setSuperEntityClass("com.laozicloud.developer.entity.BaseModel");
//        sc.setSuperEntityColumns("id","uuid","version","create_time","update_time","deleted");
        return sc;
    }

    public PackageConfig initPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(Application.packageName);
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setXml("dao");
        return pc;
    }

    /**
     * 模板配置，可自定义代码生成的模板，实现个性化操作
     */
    public TemplateConfig initTemplateConfig() {
        TemplateConfig tc = new TemplateConfig();
        tc.setController("templates/controller.java");
        tc.setService("templates/service.java");
        tc.setServiceImpl("templates/serviceimpl.java");
        tc.setMapper("templates/mapper.java");
        tc.setEntity("templates/entity.java");
        tc.setXml("templates/mapper.xml");
        return tc;
    }

    /**
     * 全局策略配置
     */
    public GlobalConfig initGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOpen(false);
        gc.setAuthor(Application.author);
        gc.setServiceName("%sService");
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setDateType(DateType.ONLY_DATE);
        return gc;
    }

    /**
     * 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
     */
    public InjectionConfig initInjectionConfig() {
        InjectionConfig ic = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义mapper.xml输出配置
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名
//                return projectPath + "/src/main/java/com/open/capacity/personal/dao/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_XML;
//            }
//        });

        ic.setFileOutConfigList(focList);
        IFileCreate fileCreate = (ConfigBuilder configBuilder, FileType fileType, String filePath) -> {
            return true;
        };
        ic.setFileCreate(fileCreate);
        return ic;
    }
}
