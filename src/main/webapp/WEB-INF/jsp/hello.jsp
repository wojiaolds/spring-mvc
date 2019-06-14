<!DOCTYPE html>
<meta charset="utf-8"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<div>
    <center>
        <body>
        ${msg}
        ${msg1}
        </body>
    </center>
</div>
<form action="index.tran">
</form>
<script src="js/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
    $(function () {
        sleep(2000);
        $("form").submit();
    });
    function sleep(d){
        var t = Date.now();

        while(Date.now() - t <= d);
    }
</script>
