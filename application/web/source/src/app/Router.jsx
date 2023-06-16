import { Navigate, Route, Routes } from "react-router-dom";
import React from "react";
import CartView from "../view/cart/CartView";
import CheckoutView from "../view/checkout/CheckoutView";
import PurchaseConfirmation from "../view/purchase-confirmation/PurchaseConfirmation";
import AdminDashboardView from "../view/admin/AdminDashboardView";
import ErrorGenerator from "../view/error/ErrorGenerator";
import HighOrderBoundary from "./ErrorBoundary";
import ErrorView from "../view/error/ErrorView";
import Home from "../view/Home/Home";
import ProductsView from "../view/products/ProductsView";
import InventoryDashboardView from "../view/inventoryDashboard/InventoryDashboardView";
import FinancialDashboardView from "../view/financialDashboard/FinancialDashboardView";
import PetsView from "../view/pets/PetsView";

function Router() {
	return (
		<Routes>
			<Route path="/" element={<Home />} />
			<Route path="/products" element={<ProductsView />} />
			<Route path="/cart" element={<CartView />} />
			<Route path="/checkout" element={<CheckoutView />} />
			<Route path="/purchase-confirmation" element={<PurchaseConfirmation />} />
			<Route path="/admin-dashboard" element={<AdminDashboardView />} />
			<Route path="/inventory-dashboard" element={<InventoryDashboardView />} />
			<Route path="/financial-dashboard" element={<FinancialDashboardView />} />
			<Route path="/error-generator" element={<ErrorGenerator />} />
			<Route path="/error" element={<ErrorView />} />
			<Route path="/pets" element={<PetsView />} />
			<Route path="*" element={<Navigate to="/error" replace />} />
		</Routes>
	);
}

export default HighOrderBoundary(Router);
