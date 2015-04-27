<%-- 
    Document   : tesChart
    Created on : Apr 27, 2015, 12:43:56 AM
    Author     : Hansel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="jquery.min.js"></script>
        <script src="bar.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="container" style="width:50%; height:400px;"></div>
        <script>
            $(function () {
                $('#container').highcharts({
                    chart: {
                        type: 'bar'
                    },
                    title: {
                        text: 'Fruit Consumption'
                    },
                    xAxis: {
                        categories: ['Apples', 'Bananas', 'Oranges']
                    },
                    yAxis: {
                        title: {
                            text: 'Fruit eaten'
                        }
                    },
                    series: [{
                            name: 'Jane',
                            data: [1, 3, 4]
                        }, {
                            name: 'John',
                            data: [5, 5, 3]
                        }]
                });
            });
        </script>
    </body>
</html>
