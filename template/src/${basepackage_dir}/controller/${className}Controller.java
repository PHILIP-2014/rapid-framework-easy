<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do">
package ${basepackage}.controller;

@Controller
@RequestMapping("/${classNameLower}")
public class ${className}Controller {

	@Resource
	private ${className}Service ${classNameLower}Service;
	
}
