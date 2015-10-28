package cn.org.rapid_framework.generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javacommon.util.XmlUtil;

public class GeneratorMain {
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
		//g.printAllTableNames();
		g.clean();
		/**生成全部表***/
		g.generateByAllTable();
		/**按照类名生成表**/
		//g.generateByClass(Blog.class);
		
		/**单个===按照指定生成表***/
		//g.generateByTable("cairh_vse_trade_log","TradeLog");
		/**批量===按照指定生成表***/
//		List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
//		new XmlUtil("/tables.xml","/root/item").readXml(listMap);
//		for(Map<String,String> map:listMap){
//			if("off".equalsIgnoreCase(map.get("switch"))){
//				continue;
//			}else{
//				System.out.println(map.get("key")+"--->"+map.get("className"));
//				g.generateByTable(map.get("key"),map.get("className"));
//			}
//		}
		//Runtime.getRuntime().exec("cmd.exe /c start D:\\webapp-generator-output");
	}
}
