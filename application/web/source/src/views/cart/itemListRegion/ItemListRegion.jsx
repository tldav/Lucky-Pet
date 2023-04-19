import React from "react";
import ItemRegion from "./itemRegion/ItemRegion";
import cartHasItems from "./cartHasItems";

function ItemListRegion({ items }) {
  const renderEmptyMessage = () => {
    return <p id="cart-empty-message">Cart is empty</p>;
  };

  const renderItemRegions = () => {
    return items.map((item) => {
      return <ItemRegion key={item.id} item={item} />;
    });
  };

  return (
    <div id="item-list-region">
      <h4>Your Cart Items</h4>
      {cartHasItems(items) ? renderItemRegions() : renderEmptyMessage()}
    </div>
  );
}

export default ItemListRegion;
