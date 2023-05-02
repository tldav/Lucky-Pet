import { calculateLineItemTotal, formatCurrency } from "../../../../currency/currency";

/*
 ***** Come up with better names for product in ItemRegion *****
 */
function ItemRegion({ item }) {
	return (
		<div className="item-region">
			<div className="product-price">{formatCurrency(item.product.price)} </div>
			<div>Description:</div>
			<div className="product-description">{item.product.description}</div>
			<div>
				Quantity:
				<span className="line-item-quantity">{item.quantity}</span>
			</div>
			<div>
				Item total:{" "}
				<span className="line-item-total">
					{formatCurrency(calculateLineItemTotal(item))}
				</span>
			</div>
		</div>
	);
}

export default ItemRegion;
