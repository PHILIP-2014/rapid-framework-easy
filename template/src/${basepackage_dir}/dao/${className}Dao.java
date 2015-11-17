<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

public interface ${className}Dao {
	
	${className} queryOne(${table.idColumn.javaType} ${classNameLower});

	Integer insert(${className} ${classNameLower});

	void update(${className} ${classNameLower});
	
}
