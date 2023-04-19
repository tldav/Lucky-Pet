import React from "react";
import { formatCurrency } from "../../../../currency/currency";

function RevenueRegion({ revenue }) {
	const renderRevenueRegion = () => {
		return (
			<>
				<p className="revenue-month">{revenue.month}</p>
				<p className="revenue-year">{revenue.year}</p>
				<p className="revenue-gross">{formatCurrency(revenue.gross)}</p>
			</>
		);
	};

	return <div className="revenue-region">{renderRevenueRegion()}</div>;
}

export default RevenueRegion;
