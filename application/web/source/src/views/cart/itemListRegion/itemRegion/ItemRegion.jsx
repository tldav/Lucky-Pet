import { formatCurrency } from "../../../../currency/currency";

function ItemRegion({ item }) {
	return (
		<div className="item-region">
			<div className="item-amount">{formatCurrency(item.product.price)} </div>
			<div>Item Description:</div>
			<div className="item-description">{item.product.description}</div>
		</div>
	);
}

export default ItemRegion;
