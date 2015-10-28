<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

@Service
public class ${className}Service {
	
	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
}
