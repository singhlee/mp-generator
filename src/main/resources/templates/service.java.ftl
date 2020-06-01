package ${package.Service};
import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @Author: ${author}
* @Date: ${date}
* @Description:
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends IService<${entity}> {

}
</#if>
