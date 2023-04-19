import { Navigate, Route, Routes } from "react-router-dom";
import React from "react";
import CartView from "../views/cart/CartView";
import Checkout from "../views/checkout/Checkout";
import PurchaseConfirmation from "../views/purchase-confirmation/PurchaseConfirmation";
import PaymentSubmission from "../views/payment-submission/PaymentSubmission";
import AdminDashboardView from "../views/admin/AdminDashboardView";
import ErrorGenerator from "../views/error/ErrorGenerator";
import HighOrderBoundary from "./ErrorBoundary";
import ErrorView from "../views/error/ErrorView";
import Home from "../views/Home/Home";
import ProductsView from "../views/products/ProductsView";
import InventoryDashboardView from "../views/inventoryDashboard/InventoryDashboardView";
import FinancialDashboardView from "../views/financialDashboard/FinancialDashboardView";
import PetsView from "../views/pets/PetsView";

function Router() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/products" element={<ProductsView />} />
      <Route path="/cart" element={<CartView />} />
      <Route path="/checkout" element={<Checkout />} />
      <Route path="/purchase-confirmation" element={<PurchaseConfirmation />} />
      <Route path="/payment-submission" element={<PaymentSubmission />} />
      <Route path="/admin-dashboard" element={<AdminDashboardView />} />
      <Route path="/inventory-dashboard" element={<InventoryDashboardView />} />
      <Route path="/financial-dashboard" element={<FinancialDashboardView />} />
      <Route path="/error-generator" element={<ErrorGenerator />} />
      <Route path="/error" element={<ErrorView />} />
      <Route path="/pets" element={<PetsView /> } />
      <Route path="*" element={<Navigate to="/error" replace />} />
    </Routes>
  );
}

export default HighOrderBoundary(Router);
