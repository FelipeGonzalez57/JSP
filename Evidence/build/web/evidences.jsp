<%-- 
    Document   : evidences
    Created on : 29/09/2016, 11:42:02 AM
    Author     : PandithaGD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Evidence</title>
    </head>
    <body>
        <form action="EvidenceController" method="post">
            <fieldset>
                <div> 
                <label>Id de evidence:</label>
                <input type="text" name="id"
                       value="${evidence.id}"
                       readonly="readonly"
                       />
                </div>
               <div> 
               <label>Code:</label>
                <input type="text" name="code"
                       value="${evidence.code}"
                       placeholder="code"
                       />
               </div>
                       <div>
                       <label>Seq:</label>
                <input type="text" name="seq"
                       value="${evidence.seq}"
                       placeholder="seq"
                       />
                </div>
                <div>
                <label>Association:</label>
                <input type="number" name="association"
                       value="${evidence.association}"
                       placeholder="Association"
                       />
                </div>
                <div>       
                    <input type="submit" value="Guardar" />
                </div>
            </fieldset>
        </form>
    </body>
</html>
