<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html:html lang="true">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <head>
        <link rel="stylesheet" type="text/css" media="all" href="css/reset.css" />
        <link rel="stylesheet" type="text/css" media="all" href="css/text.css" />
        <link rel="stylesheet" type="text/css" media="all" href="css/960.css" />
        <link rel="stylesheet" type="text/css" media="all" href="css/style.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/galleria.css" /> 

        <script type="text/javascript" src="js/jquery-1.7.min.js"></script> 
        <script type="text/javascript" src="js/jquery-ui-1.8.16.min.js"></script> 
        <script type="text/javascript" src="js/jquery.livequery.min.js"></script> 

        <style media="screen,projection" type="text/css">
            /* BEGIN DEMO STYLE */
            .gallery li{width:80px;height:60px;border:3px double #111;margin: 0 2px;background:#000; float:left;}
            .gallery {width:300px;}
        </style>
        
        <title>Search Image</title>
    </head>

    <body>
        <div class="container_12" id="topContent">
            <div class="grid_4">
                <h1>Image</h1>
                <h2>.....Search</h2>
            </div>
            <div class="grid_8" id="rightTopContent">
                <a href="#">Search</a> |
                <a href="#">Compare</a> |
                <a href="#">contact</a>
            </div>
        </div>

        <div class="clear">&nbsp;</div>

        <div class="container_12">
            <div class="grid_4">    
                <img src="images/1.jpg" width="280px"/>
            </div>
            <!-- end .grid_4 -->
            <div class="grid_8">
                <html:form action="/searchimage">
                    <html:text property="name" value=""/><br/>
                    <html:text property="pass" value=""/><br/>
                    <html:submit value="Submit Query" />
                </html:form>
            </div>
        </div>

        <div class="clear">&nbsp;</div>

        <div class="container_16">
            <div class="grid_2">
                <p>&nbsp;</p>
            </div>

            <div class="grid_12" id="galleryInformation">
                <h2>Search Result</h2>
                    
                <div id="search-result">
                    <logic:present name="name" scope="session">
                        <p>Welcome <bean:write name="name" scope="session"/></p>
                    </logic:present>
                </div>

                <div id="footer"><a href="#">Dhiman, Ragib and Riyad</a></div>
            </div>

            <div class="grid_2">
                <p>&nbsp;</p>
            </div>
        </div>
    </body>
</html:html>
