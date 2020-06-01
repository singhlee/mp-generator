package mybatis.plus.generator.core;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;

/**
 * @Auther: aijing
 * @Date: 2019/5/28 14:09
 * @Description:
 */
public interface ConfigInitiator {

    /**
     * 数据源配置，通过该配置，指定需要生成代码的具体数据库
     */
    DataSourceConfig initDataSourceConfig();

    /**
     * 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
     */
    StrategyConfig initStrategyConfig();

    /**
     * 包名配置，通过该配置，指定生成代码的包路径
     */
    PackageConfig initPackageConfig();

    /**
     * 模板配置，可自定义代码生成的模板，实现个性化操作
     */
    TemplateConfig initTemplateConfig();

    /**
     * 全局策略配置
     */
    GlobalConfig initGlobalConfig();

    /**
     * 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
     */
    InjectionConfig initInjectionConfig();


}
