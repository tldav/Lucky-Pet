import React from "react";
import {useLocation} from "react-router-dom";
import "./error.css";

function ErrorView({errorCode}) {
    const location = useLocation();
    const isUnhandledException = location.state
        ? location.state.isUnhandledException
        : false;

    function getErrorMessage() {
        return isUnhandledException
            ? "Generic error!"
            : "Ruh-roh... a dog ate this page!";
    }

    return (
        <div id="error-view">
            <h2 className="error-message">{getErrorMessage(errorCode)} 🐕</h2>
        </div>
    );
}

export default ErrorView;
