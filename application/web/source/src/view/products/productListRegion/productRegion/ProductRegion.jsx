import getOutOfStockMessage from "./getOutOfStockMessage";
import { formatCurrency } from "../../../../currency/currency";

/*
 ***** Come up with better names for product in ItemRegion *****
 */
function ProductRegion({ product, isInCart }) {
	const renderProduct = () => {
		return (
			<>
				<p className="description">{product.description} </p>
				<span className="out-of-stock" style={{ color: "red" }}>
					{getOutOfStockMessage(product.stock)}
				</span>
				<p className="price">{formatCurrency(product.price)}</p>
				<button disabled={isInCart} className="add-to-cart-button">
					Add to Cart
				</button>
			</>
		);
	};

	return (
		<div className="product-region" data-product={product.id}>
			{renderProduct()}
		</div>
	);
}

export default ProductRegion;
