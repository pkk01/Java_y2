<%-- Display search results --%>
<c:forEach var="product" items="${products}">
	<p>${product.product_name}-${product.category} - ${product.price}</p>
</c:forEach>
