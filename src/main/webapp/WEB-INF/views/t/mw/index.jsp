<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<SCRIPT language="JavaScript">
function getCookie( name ) { 
    var start = document.cookie.indexOf( name + "=" ); 
    var len = start + name.length + 1; 
    if ( ( !start ) && ( name != document.cookie.substring( 0, name.length ) ) ) { 
        return null; 
    } 
    if ( start == -1 ) return null; 
    var end = document.cookie.indexOf( ';', len ); 
    if ( end == -1 ) end = document.cookie.length; 
    return unescape( document.cookie.substring( len, end ) ); 
} 
//全屏操作
var sURL = 'list';
var localeSet = getCookie("localeSet");
if(localeSet!=null && localeSet != ""){
	sURL = sURL + "?locale="+localeSet;
}
var win = window.open(sURL,'','width='+(screen.width-10)+',height='+(screen.height-80)+',status=yes,toolbar=no,menubar=no,location=no,resizable=yes,scrollbars=yes,top=0,left=0');
if(!win){
	window.location.href = sURL;
}
else{
	win.focus();
    window.open("","_self");//fix ie7
	setTimeout("window.opener=null;window.close();",1);
}

</SCRIPT>
</HEAD>
</html>