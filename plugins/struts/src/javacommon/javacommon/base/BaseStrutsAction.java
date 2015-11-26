package javacommon.base;

import javacommon.util.PageRequestFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ActionError;
import org.apache.struts2.components.ActionMessage;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.springframework.util.Assert;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.struts.AutowireMappingDispatchAction;
import cn.org.rapid_framework.struts.StrutsMessageUtil;
/**
 * @author badqiu
 */
public class BaseStrutsAction extends AutowireMappingDispatchAction{
	
	private static final String DIRECT_MESSAGE_KEY = "message";
	
	public static final String MSG_SAVED_FAILURE = "保存失败";
	public static final String MSG_SAVED_SUCCESS = "保存成功";
	public static final String MSG_DELETE_SUCCESS = "删除成功";
	public static final String MSG_HANDLE_SUCCESS = "处理成功";
	
	static {
		//注册converters
		ConvertRegisterHelper.registerConverters();
	}
	
	public void copyProperties(Object target,Object source) {
		BeanUtils.copyProperties(target, source);
	}

	public <T> T copyProperties(Class<T> destClass,Object orig) {
		return BeanUtils.copyProperties(destClass, orig);
	}
	
	public void saveDirectMessage(HttpServletRequest request,String msg){
		StrutsMessageUtil.addMessage(request,new ActionMessage(DIRECT_MESSAGE_KEY,msg));
	}
	
	public void saveDirectError(HttpServletRequest request,String msg){
		StrutsMessageUtil.addError(request,new ActionError(DIRECT_MESSAGE_KEY,msg));
	}
	
	public void savePage(Page page,PageRequest pageRequest,HttpServletRequest request){
		savePage("",page,pageRequest,request);
	}
	/**
	 * 用于一个页面有多个extremeTable是使用
	 * @param tableId 等于extremeTable的tableId属性
	 */
	public void savePage(String tableId,Page page,PageRequest pageRequest,HttpServletRequest request){
		Assert.notNull(tableId,"tableId must be not null");
		Assert.notNull(page,"page must be not null");
		
		request.setAttribute(tableId+"page", page);
		request.setAttribute(tableId+"totalRows", new Integer(page.getTotalCount()));
		request.setAttribute(tableId+"pageRequest", pageRequest);
	}
	
	public PageRequest newPageRequest(HttpServletRequest request,String defaultSortColumns){
		return PageRequestFactory.newPageRequest(request, defaultSortColumns);
    }
	
	/**
	 * 得到struts要执行的方法名称
	 */
	protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
		String result = parameter;
		if(log.isInfoEnabled())
			log.info("enter '" + result + "()' method before");
		return result;
	}
	
}
