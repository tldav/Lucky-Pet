import React from "react"; 
import LowStockRegion from "./lowStockRegion/LowStockRegion";
import products from "../../../data/product.json";
import hasLowStock from "./hasLowStock";

function LowStockListRegion() {

    const renderLowStockProducts= () => {
        return products.map((product) => {
            return hasLowStock(product) ? <LowStockRegion product={product} key={product.id} /> : null;
        })
    }

    return <div id="low-stock-list-region">  
        {renderLowStockProducts()}
    </div>
}

export default LowStockListRegion;