import React from "react";
import RevenueRegion from "./revenueRegion/RevenueRegion";
import revenueList from "../../../data/revenue.json";

function RevenueListRegion() {
	const renderRevenueRegion = () => {
		return revenueList.map((revenue) => {
			return <RevenueRegion revenue={revenue} key={revenue.id} />;
		});
	};

	return (
		<div id="revenue-list-region">
			<div id="revenue-col-title">
				<p className="revenue-month">Month</p>
				<p className="revenue-year">Year</p>
				<p className="revenue-gross">Gross</p>
			</div>
			{renderRevenueRegion()}
		</div>
	);
}

export default RevenueListRegion;
