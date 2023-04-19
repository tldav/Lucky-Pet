import { formatCurrency } from "../../../../currency/currency";

function Item({ item }) {
  return (
    <div className="item-region">
      <div className="item-id">Item Id: {item.id} </div>
      <div className="item-amount">{formatCurrency(item.price)} </div>
      <div>Item Description:</div>
      <div className="item-description">{item.description}</div>
    </div>
  );
}

export default Item;
