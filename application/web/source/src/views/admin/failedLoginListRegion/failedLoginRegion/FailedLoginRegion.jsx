import React from "react";

function FailedLoginRegion({ failure }) {
  return (
    <tr className="failure-aggregation" key={failure[0]}>
      <td className="failure-date">{failure[0]}</td>
      <td className="failure-count" style={{ textAlign: "end" }}>
        {failure[1]}
      </td>
    </tr>
  );
}

export default FailedLoginRegion;
