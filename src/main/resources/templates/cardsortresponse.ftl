<!DOCTYPE html>
<html>
<head>
    <title>Cards sorted</title>
    <meta charset="UTF-8">

</head>
<body>
<h2>List of cards</h2>

<table>
    <tr>
        <th>Bank</th>
        <th>Card Number</th>
        <th>Expiration</th>
    </tr>

    <#list results as result>
    <tr>
        <td>${result.bankName}</td>
        <td>${result.filteredCardNumber}</td>
        <td>${result.expirationDate}</td>
    </tr>
    </#list>
</table>

</body>
</html>
