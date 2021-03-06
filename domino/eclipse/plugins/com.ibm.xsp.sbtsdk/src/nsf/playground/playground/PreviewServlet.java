package nsf.playground.playground;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.extlib.servlet.FacesContextServlet;


public class PreviewServlet extends FacesContextServlet {

	private static final long serialVersionUID = 1L;

	private PreviewJavaScriptHandler javaScriptHandler;
	private PreviewJavaHandler javaHandler;
	private PreviewXPagesHandler xpagesHandler;
	private PreviewGadgetHandler gadgetHandler;
	
	public PreviewServlet() {
	}
	
	public PreviewHandler getJavaScriptSnippetHandler() {
		if(javaScriptHandler==null) {
			javaScriptHandler = new PreviewJavaScriptHandler();
		}
		return javaScriptHandler;
	}

	public PreviewHandler getJavaSnippetHandler() {
		if(javaHandler==null) {
			javaHandler = new PreviewJavaHandler();
		}
		return javaHandler;
	}

	public PreviewHandler getXPagesSnippetHandler() {
		if(xpagesHandler==null) {
			xpagesHandler = new PreviewXPagesHandler();
		}
		return xpagesHandler;
	}

	public PreviewHandler getGadgetSnippetHandler() {
		if(gadgetHandler==null) {
			gadgetHandler = new PreviewGadgetHandler();
		}
		return gadgetHandler;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Dispatch to the right handler
		String pathInfo = req.getPathInfo();
		if(StringUtil.equalsIgnoreCase(pathInfo, "/javascriptsnippet")) {
			getJavaScriptSnippetHandler().doService(req, resp);
		} else if(StringUtil.equalsIgnoreCase(pathInfo, "/javasnippet")) {
			getJavaSnippetHandler().doService(req, resp);
		} else if(StringUtil.equalsIgnoreCase(pathInfo, "/xpagessnippet")) {
			getXPagesSnippetHandler().doService(req, resp);
		} else if(StringUtil.equalsIgnoreCase(pathInfo, "/gadgetsnippet")) {
			getGadgetSnippetHandler().doService(req, resp);
		}
	}
}
