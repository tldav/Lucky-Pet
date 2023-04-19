import React from "react";

function LowStockRegion({ product }) {
  const renderLowStockProduct = () => {
    return (
      <div>
        <span>Description: <p className="product-description-low">{product.description}</p></span>
        <span>Price: <p className="product-price-low">{product.price}</p></span>
        <span>Stock: <p className="product-stock-low">{product.stock}</p></span>
      </div>
    );
  };

  return <div className="low-stock-region">{renderLowStockProduct()}</div>;
}

export default LowStockRegion;
