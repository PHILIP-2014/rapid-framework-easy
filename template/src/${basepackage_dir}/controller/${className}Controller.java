<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do">
package ${basepackage}.controller;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ${className}Controller {

	@Autowired
	private ${className}Service ${classNameLower}Service;
	
}
