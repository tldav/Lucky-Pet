import { formatCurrency } from "../../../../currency/currency";

/*
 ***** Come up with better names for product in ItemRegion *****
 */
function ItemRegion({ item }) {
	return (
		<div className="item-region">
			<div className="product-price">{formatCurrency(item.product.price)} </div>
			<div>Item Description:</div>
			<div className="product-description">{item.product.description}</div>
		</div>
	);
}

export default ItemRegion;
