function LoginFailureRegion({ failure }) {
	return (
		<tr className="login-failure-region" key={failure[0]}>
			<td className="failure-date">{failure[0]}</td>
			<td className="failure-count" style={{ textAlign: "end" }}>
				{failure[1]}
			</td>
		</tr>
	);
}

export default LoginFailureRegion;
