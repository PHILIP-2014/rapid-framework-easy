package javacommon.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * xml读写工具包
 * @author lujun
 *
 */
public class XmlUtil {
	private static final Log log = LogFactory.getLog(XmlUtil.class);
	private String xmlFilePath;		//xml文件路劲
	private String itemPath;		//item路径
	public XmlUtil(String filepath,String itemPath) {
		super();
		this.xmlFilePath = filepath;
		this.itemPath = itemPath;
	}
	public List<Map<String, String>> readXml(List<Map<String, String>> list) {
		if (list == null)
			list = new ArrayList<Map<String, String>>();
		else if (list.size() > 0)
			list.clear();
		InputStream in = null;
		try {
			in = getClass().getResourceAsStream(getXmlFilePath());
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			List dataList = doc.selectNodes(getItemPath());
			if(dataList!=null && dataList.size()>0)
			for(int i=0;i<dataList.size();i++){
				Element e = (Element)dataList.get(i);
				Iterator it = e.attributeIterator();
				Map<String, String> item = new HashMap<String, String>();
				while (it.hasNext()){
					Attribute attr = (Attribute) it.next();
					String attrName = attr.getName();
					String attrValue = attr.getValue();
					item.put(attrName, attrValue);
				}
				item.put("text",e.getText()==null?"":e.getText());
				list.add(item);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in = null;
		}
		return list;
	}
	public String getXmlFilePath() {
		return xmlFilePath;
	}
	public void setXmlFilePath(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
	}
	public String getItemPath() {
		return itemPath;
	}
	public void setItemPath(String itemPath) {
		this.itemPath = itemPath;
	}
	

}
