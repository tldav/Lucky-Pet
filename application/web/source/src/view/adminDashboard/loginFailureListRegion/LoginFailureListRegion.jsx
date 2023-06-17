import { useEffect, useState } from "react";
import fetchLoginFailures from "./loginFailures";
import LoginFailureRegion from "./loginFailureRegion/LoginFailureRegion";
import getUrlParam from "../../../urlParam/urlParam";

function LoginFailureListRegion() {
	const [loginFailures, setLoginFailures] = useState([]);

	useEffect(() => {
		const fileName = getUrlParam("fileName") ? getUrlParam("fileName") : "loginfailure";
		const path = `${process.env.PUBLIC_URL}/logs/${fileName}.log`;
		fetchLoginFailures(path).then((response) => {
			setLoginFailures(Array.from(response));
		});
	}, []);

	return (
		<div id="login-failure-list-region">
			{loginFailures ? (
				<table>
					<caption>Login Failure Report</caption>
					<tbody>
						<tr>
							<th>Date</th>
							<th>Failures</th>
						</tr>
						{loginFailures.map((failure) => {
							return <LoginFailureRegion key={failure[0]} failure={failure} />;
						})}
					</tbody>
				</table>
			) : (
				""
			)}
		</div>
	);
}

export default LoginFailureListRegion;
