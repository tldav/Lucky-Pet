import {Component} from "react";
import {Navigate} from "react-router-dom";

const HighOrderBoundary = (ErrorComponent) =>
    class ErrorBoundary extends Component {
        state = {hasUnhandledException: false};

        componentDidMount() {
            window.self.addEventListener("error", () =>
                this.setState({hasUnhandledException: true})
            );
        }

        componentDidCatch() {
            this.setState({hasUnhandledException: true});
        }

        render() {
            if (this.state.hasUnhandledException) {
                this.setState({hasUnhandledException: false});
                return (
                    <Navigate state={{isUnhandledException: true}} to="error" replace/>
                );
            }
            return <ErrorComponent/>;
        }
    };

export default HighOrderBoundary;
