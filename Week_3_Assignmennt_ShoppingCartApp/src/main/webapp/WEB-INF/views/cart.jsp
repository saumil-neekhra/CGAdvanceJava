<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Cart Summary</h2>

<c:if test="${empty cartItems}">
    <p>Your cart is empty.</p>
</c:if>

<c:forEach var="item" items="${cartItems}">
    <p>
        <b>${item.product.name}</b> <br>
        Price: ₹${item.product.price} <br>
        Quantity: ${item.quantity} <br>
        Total: ₹${item.total}
    </p>
    <hr>
</c:forEach>

<h3>Total Amount: ₹${total}</h3>

<a href="${pageContext.request.contextPath}/">Back to Products</a>