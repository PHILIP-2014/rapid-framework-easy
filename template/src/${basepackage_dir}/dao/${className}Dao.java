<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

public interface ${className}Dao {
	
	${className} getById(${table.idColumn.javaType} ${classNameLower});

	Integer save(${className} ${classNameLower});

	void update(${className} ${classNameLower});
	
}
