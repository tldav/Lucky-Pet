import { useEffect, useState } from "react";
import LowStockRegion from "./lowStockRegion/LowStockRegion";
import hasLowStock from "./hasLowStock";
import getProducts from "../../../api/product";

function LowStockListRegion() {
	const [products, setProducts] = useState([]);

	useEffect(() => {
		getProducts().then((response) => setProducts(response));
	}, []);

	const renderLowStockProducts = () => {
		return products.map((product) => {
			return hasLowStock(product) ? (
				<LowStockRegion product={product} key={product.id} />
			) : null;
		});
	};

	return <div id="low-stock-list-region">{renderLowStockProducts()}</div>;
}

export default LowStockListRegion;
