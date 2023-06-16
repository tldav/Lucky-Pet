import React, { useEffect, useState } from "react";
import fetchLoginFailures from "./loginFailures";
import FailedLoginRegion from "./failedLoginRegion/FailedLoginRegion";
import getUrlParam from "../../../urlParam/urlParam";

function FailedLoginListRegion() {
  const [loginFailures, setLoginFailures] = useState([]);

  useEffect(() => {
    const fileName = getUrlParam("fileName")
      ? getUrlParam("fileName")
      : "loginfailure";
    const path = `${process.env.PUBLIC_URL}/logs/${fileName}.log`;
    fetchLoginFailures(path).then((response) => {
      setLoginFailures(Array.from(response));
    });
  }, []);

  return (
    <div id="failed-login-list-region">
      {loginFailures ? (
        <table>
          <caption>Login Failure Report</caption>
          <tbody>
            <tr>
              <th>Date</th>
              <th>Failures</th>
            </tr>
            {loginFailures.map((failure) => {
              return <FailedLoginRegion key={failure[0]} failure={failure} />;
            })}
          </tbody>
        </table>
      ) : (
        ""
      )}
    </div>
  );
}

export default FailedLoginListRegion;
