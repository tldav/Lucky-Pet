import React from "react";
import LowStockListRegion from "./lowStockListRegion/LowStockListRegion";
import "./inventoryDashboardView.css";

function InventoryDashboardView() {
  return (
    <div id="inventory-dashboard-view">
        <LowStockListRegion />
    </div>
  )
}

export default InventoryDashboardView;
