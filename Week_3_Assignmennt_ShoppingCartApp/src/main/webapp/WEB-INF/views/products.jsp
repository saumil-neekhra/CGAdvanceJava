<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Available Products</h2>

<c:forEach var="p" items="${products}">
    <form action="add" method="post">
        <p>
            <b>${p.name}</b> - ₹${p.price}
        </p>

        <input type="hidden" name="id" value="${p.id}" />

        Quantity:
        <input type="number" name="qty" min="1" required />

        <input type="submit" value="Add to Cart" />
        <hr>
    </form>
</c:forEach>

<a href="cart">View Cart</a>