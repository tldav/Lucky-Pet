import { Navigate, Route, Routes } from "react-router-dom";
import AdminDashboardView from "../view/adminDashboard/AdminDashboardView";
import CartView from "../view/cart/CartView";
import CheckoutView from "../view/checkout/CheckoutView";
import ErrorGenerator from "../view/error/ErrorGenerator";
import ErrorView from "../view/error/ErrorView";
import FinancialDashboardView from "../view/financialDashboard/FinancialDashboardView";
import HighOrderBoundary from "./ErrorBoundary";
import LandingView from "../view/landing/LandingView";
import InventoryDashboardView from "../view/inventoryDashboard/InventoryDashboardView";
import PetsView from "../view/pets/PetsView";
import ProductsView from "../view/products/ProductsView";
import PurchaseConfirmation from "../view/purchase-confirmation/PurchaseConfirmation";

function Router() {
	return (
		<Routes>
			<Route path="/" element={<LandingView />} />
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
