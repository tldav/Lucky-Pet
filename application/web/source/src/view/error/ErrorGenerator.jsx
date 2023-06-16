import React from "react";

function ErrorGenerator() {
    function throwError() {
        throw new Error("Generic exception thrown.");
    }

    return (
        <div id="error-generator">
            {throwError()}
            <div>Generic error message.</div>
        </div>
    );
}

export default ErrorGenerator;
