/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.struts.action;

import com.app.struts.formbean.SearchParamActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Dhiman
 */
public class SearchImageAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        SearchParamActionForm sform=(SearchParamActionForm)form;
        String name= sform.getName();
        System.out.println(name);
        request.getSession().setAttribute("name", name);
        return mapping.findForward(SUCCESS);
    }
}
