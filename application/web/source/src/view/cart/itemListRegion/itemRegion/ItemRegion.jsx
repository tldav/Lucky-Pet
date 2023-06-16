import { calculateLineItemTotal, formatCurrency } from "../../../../currency/currency";

/*
 ***** Come up with better names for product in ItemRegion *****
 */
function ItemRegion({ item }) {
	return (
		<div className="item-region">
			<div>
				Product Price:{" "}
				<span className="product-price">{formatCurrency(item._product.price)} </span>
			</div>
			<div>
				Product Description:{" "}
				<span className="product-description">{item._product.description}</span>
			</div>
			<div>
				Item Quantity: <span className="line-item-quantity">{item.quantity}</span>
			</div>
			<div>
				Item Total:{" "}
				<span className="line-item-total">
					{formatCurrency(calculateLineItemTotal(item))}
				</span>
			</div>
			<br />
		</div>
	);
}

export default ItemRegion;
