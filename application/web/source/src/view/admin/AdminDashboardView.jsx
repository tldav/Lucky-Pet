import React from "react";
import FailedLoginListRegion from "./failedLoginListRegion/FailedLoginListRegion";

function AdminDashboardView() {
  return (
    <div id="admin-dashboard">
      <h1>Admin Dashboard</h1>
      <FailedLoginListRegion />
    </div>
  );
}
export default AdminDashboardView;
