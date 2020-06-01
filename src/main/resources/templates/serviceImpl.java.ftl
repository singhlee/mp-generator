package ${package.ServiceImpl};

import lombok.extern.slf4j.Slf4j;
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};

/**
* @Author: ${author}
* @Date: ${date}
* @Description:
*/
@Slf4j
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ServiceImpl<${table.mapperName},${entity}> implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} ${table.mapperName?uncap_first};

}
</#if>
