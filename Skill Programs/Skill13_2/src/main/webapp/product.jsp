<form action="product" method="post">
    <input type="hidden" name="action" value="add">
    <label>Product Name:</label>
    <input type="text" name="product_name" required>
    <label>Description:</label>
    <input type="text" name="description">
    <label>Price:</label>
    <input type="number" name="price" step="0.01" required>
    <label>Category:</label>
    <input type="text" name="category" required>
    <button type="submit">Add Product</button>
</form>
